package com.king2.product.server.appoint;

import com.king2.commons.mapper.K2MessageMapper;
import com.king2.commons.mapper.K2ProductMapper;
import com.king2.commons.mapper.K2SystemFeedbackMapper;
import com.king2.commons.mapper.King2SensitivityLexiconMapper;
import com.king2.commons.pojo.K2Message;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.pojo.K2SystemFeedback;
import com.king2.commons.pojo.King2SensitivityLexicon;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.enmu.K2MessageEnum;
import com.king2.product.server.enmu.ProductStateEnum;
import com.king2.product.server.enmu.SystemFeedbackEnum;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/*=======================================================
	˵��:    ��Ʒ��Ϣ���е�ί����

	����		ʱ��					ע��
  	����		2019.08.17   			����
=======================================================*/
@Component
public class ProductInfoQueueAppoint {

    // ע�����дʿ��Mapper
    @Autowired
    private King2SensitivityLexiconMapper king2SensitivityLexiconMapper;

    // ע����ƷMapper
    @Autowired
    private K2ProductMapper k2ProductMapper;

    // �������д���Ϣ
    private List<King2SensitivityLexicon> sensitivityLexicons;

    // ע��ϵͳ��Ϣ��
    @Autowired
    private K2MessageMapper k2MessageMapper;

    // ע����վ֪ͨ��
    @Autowired
    private K2SystemFeedbackMapper k2SystemFeedbackMapper;

    // ע��Solr�ͻ���
    HttpSolrClient httpSolrClient = new HttpSolrClient.Builder("http://39.105.41.2:8983/solr/king2_db").build();

    // ע����ƷĬ��ͼƬ
    @Value("${PRODUCT_IMAGE_NOT_DEFINITION}")
    private String PRODUCT_IMAGE_NOT_DEFINITION;

    /**
     * -----------------------------------------------------
     * ����: У����Ʒ��Ϣ�Ƿ�ͨ��������У��
     * <p>
     * ����:
     * k2ProductWithBLOBs          k2ProductWithBLOBs               ��Ʒ��Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public SystemResult checkProductInfoIfPass(K2ProductWithBLOBs k2ProductWithBLOBs) {


        if (CollectionUtils.isEmpty(sensitivityLexicons)) {
            sensitivityLexicons = king2SensitivityLexiconMapper.selectByExampleWithBLOBs(null);
        }
        // ��ѯ���д���Ϣ

        // ������ҪУ������  1 ��Ʒ������  2 ��Ʒ�ļ���  3 ��Ʒ������
        SystemResult isProductResult = checkStrContainSensitivity(k2ProductWithBLOBs.getProductName(), sensitivityLexicons);
        if (isProductResult.getStatus() == 208) return isProductResult;

        // 2 ��Ʒ�ļ���
        SystemResult isProductContent = checkStrContainSensitivity(k2ProductWithBLOBs.getProductSketchContent(), sensitivityLexicons);
        if (isProductContent.getStatus() == 208) return isProductContent;

        // 3 ��Ʒ������
        SystemResult isProductPonints = checkStrContainSensitivity(k2ProductWithBLOBs.getProductPoints(), sensitivityLexicons);
        if (isProductPonints.getStatus() == 208) return isProductPonints;

        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * ����: �ж�һ���ַ����Ƿ���������ַ�
     * <p>
     * ����:
     * compareStr                  String                           ���Ƚϵ��ַ���
     * sensitivityLexicons         List<King2SensitivityLexicon>    ���д���Ϣ
     * <p>
     * ����: SystemResult               true˵������ false˵��������
     * -----------------------------------------------------
     */
    public static SystemResult checkStrContainSensitivity(String compareStr, List<King2SensitivityLexicon> sensitivityLexicons) {

        // ���巵�صĽ��
        boolean returnFlag = false;
        String sensitivityInfo = "";

        // �������дʿ�ļ���  �����Ƚ��Ƿ���������дʿ�
        // �Ż��Ⱥ����Ż�
        da:
        for (int i = 0; i < sensitivityLexicons.size(); i++) {
            String[] split = sensitivityLexicons.get(i).getLexiconContent().split(",");
            for (int i1 = 0; i1 < split.length; i1++) {
                if (StringUtils.isEmpty(split[i1])) {
                    continue;
                } else if (StringUtils.isEmpty(compareStr)) {
                    break da;
                }
                if (StringUtils.isEmpty(compareStr)) {
                    System.out.println(compareStr);
                } else if (StringUtils.isEmpty(split[i1])) {
                    System.out.println(split[i1]);
                }
                boolean contains = compareStr.contains(split[i1]);
                // �ж��Ƿ����
                if (contains) {
                    returnFlag = true;
                    sensitivityInfo = split[i1];
                    break da;
                }
            }
        }

        if (returnFlag) {
            return new SystemResult(208, "��Ϣ���������ַ�:" + sensitivityInfo, sensitivityInfo);
        }
        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * ����: ��Ʒ��Ϣû�й����
     * <p>
     * ����:
     * k2ProductWithBLOBs            K2ProductWithBLOBs              û�й������Ʒ��Ϣ
     * <p>
     * ����: SystemResult
     * -----------------------------------------------------
     */
    @Transactional(rollbackFor = Exception.class)
    public SystemResult prorductInfoNotAudit(K2ProductWithBLOBs k2ProductWithBLOBs, String sensitivityInfo) {

        // ����Ʒ��Ϣû�й��� ����Ҫȥ����Ʒ��״̬
        k2ProductWithBLOBs.setProductState(ProductStateEnum.SHNO.getValue());
        k2ProductMapper.updateByPrimaryKeySelective(k2ProductWithBLOBs);

        // ���õ��̵��û�������Ϣ
        K2Message k2Message = new K2Message();
        k2Message.setCreateTime(new Date());
        k2Message.setMessageContent("������ӵ���Ʒ(" + k2ProductWithBLOBs.getProductName() + ")���ʧ��,ԭ������Ʒ��Ϣ�������д�'" + sensitivityInfo + "' ���޸���Ʒ��Ϣ���·�����");
        k2Message.setUserId(k2ProductWithBLOBs.getProductCreateUserid());
        k2Message.setState(K2MessageEnum.WD.getValue());
        k2MessageMapper.insert(k2Message);

        // д����Ϣ������������
        UserMessageAppoint.addMessageGotoCache(k2Message, k2ProductWithBLOBs.getProductCreateUserid());

        // ���õ��̵��û�����֪ͨ
        K2SystemFeedback systemFeedback = new K2SystemFeedback();
        systemFeedback.setFeedbackNumber(UUID.randomUUID().toString().replaceAll("-", ""));
        systemFeedback.setFeedbackContent("�������Ʒ�����֪ͨ���·�,��ͨ���鿴'�ҵ���Ϣ','��Ʒ����'�鿴�µ���Ϣ��");
        systemFeedback.setIsCommon(SystemFeedbackEnum.IS_COMMONS_NO.getValue());
        systemFeedback.setBelongUserId(k2ProductWithBLOBs.getProductCreateUserid());
        systemFeedback.setFeedbackUsername("ϵͳ֪ͨ");
        systemFeedback.setFeedbackState(K2MessageEnum.WD.getValue());
        systemFeedback.setCreateTime(new Date());
        systemFeedback.setRetain1(k2ProductWithBLOBs.getProductStoreId() + "");
        k2SystemFeedbackMapper.insert(systemFeedback);

        // ��Ʒ��Ϣû��ͨ��  ֪ͨ������и�������
        ProductBasicsAppoint.addSynchronizedProductGotoCache(k2ProductWithBLOBs);
        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * ����: ����Ʒ��Ϣͬ����solr��Ϣ��
     * <p>
     * ����:
     * k2ProductWithBLOBs            K2ProductWithBLOBs              ��Ʒ��Ϣ
     * <p>
     * ����: SystemResult
     * -----------------------------------------------------
     */
    public SystemResult synchronizedSolr(K2ProductWithBLOBs productWithBLOBs) {
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", productWithBLOBs.getProductId());
        document.addField("productName", productWithBLOBs.getProductName());
        document.addField("productBrandId", productWithBLOBs.getProductBrandId());
        document.addField("pOneCateId", productWithBLOBs.getProductOneCategoryId());
        document.addField("pTwoCateId", productWithBLOBs.getProductTwoCategoryId());
        document.addField("bazaarPrice", productWithBLOBs.getProductBazaarPrice()
                .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        document.addField("systemPrice", productWithBLOBs.getProductSystemPrice()
                .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        document.addField("productPoints", productWithBLOBs.getProductPoints());
        document.addField("productUnit", productWithBLOBs.getProductUnit());
        document.addField("productSkeContent", productWithBLOBs.getProductSketchContent());
        document.addField("productImage", StringUtils.isEmpty(productWithBLOBs.getProductImage())
                ? PRODUCT_IMAGE_NOT_DEFINITION : productWithBLOBs.getProductImage().split(",")[0]);
        document.addField("createTime", productWithBLOBs.getProductCreateTime());
        document.addField("stroeId", productWithBLOBs.getProductStoreId());

        // ͬ����solrȥ
        try {
            httpSolrClient.add(document);
            httpSolrClient.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, "�����쳣", null);
        }

        return new SystemResult("ok");
    }
}
