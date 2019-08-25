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
	说明:    商品信息队列的委派类

	作者		时间					注释
  	俞烨		2019.08.17   			创建
=======================================================*/
@Component
public class ProductInfoQueueAppoint {

    // 注入敏感词库的Mapper
    @Autowired
    private King2SensitivityLexiconMapper king2SensitivityLexiconMapper;

    // 注入商品Mapper
    @Autowired
    private K2ProductMapper k2ProductMapper;

    // 定义敏感词信息
    private List<King2SensitivityLexicon> sensitivityLexicons;

    // 注入系统信息表
    @Autowired
    private K2MessageMapper k2MessageMapper;

    // 注入网站通知表
    @Autowired
    private K2SystemFeedbackMapper k2SystemFeedbackMapper;

    // 注入Solr客户端
    HttpSolrClient httpSolrClient = new HttpSolrClient.Builder("http://39.105.41.2:8983/solr/king2_db").build();

    // 注入商品默认图片
    @Value("${PRODUCT_IMAGE_NOT_DEFINITION}")
    private String PRODUCT_IMAGE_NOT_DEFINITION;

    /**
     * -----------------------------------------------------
     * 功能: 校验商品信息是否通过敏感字校验
     * <p>
     * 参数:
     * k2ProductWithBLOBs          k2ProductWithBLOBs               商品信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    public SystemResult checkProductInfoIfPass(K2ProductWithBLOBs k2ProductWithBLOBs) {


        if (CollectionUtils.isEmpty(sensitivityLexicons)) {
            sensitivityLexicons = king2SensitivityLexiconMapper.selectByExampleWithBLOBs(null);
        }
        // 查询敏感词信息

        // 现在主要校验三点  1 商品的名称  2 商品的简述  3 商品的卖点
        SystemResult isProductResult = checkStrContainSensitivity(k2ProductWithBLOBs.getProductName(), sensitivityLexicons);
        if (isProductResult.getStatus() == 208) return isProductResult;

        // 2 商品的简述
        SystemResult isProductContent = checkStrContainSensitivity(k2ProductWithBLOBs.getProductSketchContentl(), sensitivityLexicons);
        if (isProductContent.getStatus() == 208) return isProductContent;

        // 3 商品的卖点
        SystemResult isProductPonints = checkStrContainSensitivity(k2ProductWithBLOBs.getProductPoints(), sensitivityLexicons);
        if (isProductPonints.getStatus() == 208) return isProductPonints;

        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * 功能: 判断一个字符串是否包含敏感字符
     * <p>
     * 参数:
     * compareStr                  String                           作比较的字符串
     * sensitivityLexicons         List<King2SensitivityLexicon>    敏感词信息
     * <p>
     * 返回: SystemResult               true说明包含 false说明不包含
     * -----------------------------------------------------
     */
    public static SystemResult checkStrContainSensitivity(String compareStr, List<King2SensitivityLexicon> sensitivityLexicons) {

        // 定义返回的结果
        boolean returnFlag = false;
        String sensitivityInfo = "";

        // 遍历敏感词库的集合  用来比较是否包含该敏感词库
        // 优化等后面优化
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
                // 判断是否包含
                if (contains) {
                    returnFlag = true;
                    sensitivityInfo = split[i1];
                    break da;
                }
            }
        }

        if (returnFlag) {
            return new SystemResult(208, "信息包含敏感字符:" + sensitivityInfo, sensitivityInfo);
        }
        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * 功能: 商品信息没有过审核
     * <p>
     * 参数:
     * k2ProductWithBLOBs            K2ProductWithBLOBs              没有过审的商品信息
     * <p>
     * 返回: SystemResult
     * -----------------------------------------------------
     */
    @Transactional(rollbackFor = Exception.class)
    public SystemResult prorductInfoNotAudit(K2ProductWithBLOBs k2ProductWithBLOBs, String sensitivityInfo) {

        // 该商品信息没有过审 就需要去改商品的状态
        k2ProductWithBLOBs.setProductState(ProductStateEnum.SHNO.getValue());
        k2ProductMapper.updateByPrimaryKeySelective(k2ProductWithBLOBs);

        // 给该店铺的用户发出信息
        K2Message k2Message = new K2Message();
        k2Message.setCreateTime(new Date());
        k2Message.setMessageContent("您新添加的商品(" + k2ProductWithBLOBs.getProductName() + ")审核失败,原因是商品信息包含敏感词'" + sensitivityInfo + "' 请修改商品信息重新发布。");
        k2Message.setUserId(k2ProductWithBLOBs.getProductCreateUserid());
        k2Message.setState(K2MessageEnum.WD.getValue());
        k2MessageMapper.insert(k2Message);

        // 写入信息到缓存数据中
        UserMessageAppoint.addMessageGotoCache(k2Message, k2ProductWithBLOBs.getProductCreateUserid());

        // 给该店铺的用户发出通知
        K2SystemFeedback systemFeedback = new K2SystemFeedback();
        systemFeedback.setFeedbackNumber(UUID.randomUUID().toString().replaceAll("-", ""));
        systemFeedback.setFeedbackContent("您添加商品的审核通知已下发,请通过查看'我的信息','商品管理'查看新的信息。");
        systemFeedback.setIsCommon(1);
        systemFeedback.setBelongUserId(k2ProductWithBLOBs.getProductCreateUserid());
        systemFeedback.setFeedbackUsername("系统通知");
        systemFeedback.setFeedbackState(K2MessageEnum.WD.getValue());
        systemFeedback.setCreateTime(new Date());
        k2SystemFeedbackMapper.insert(systemFeedback);

        // 商品信息没有通过  通知缓存队列更新数据
        ProductBasicsAppoint.addSynchronizedProductGotoCache(k2ProductWithBLOBs);
        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * 功能: 将商品信息同步到solr信息中
     * <p>
     * 参数:
     * k2ProductWithBLOBs            K2ProductWithBLOBs              商品信息
     * <p>
     * 返回: SystemResult
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
        document.addField("productSkeContent", productWithBLOBs.getProductSketchContentl());
        document.addField("productImage", StringUtils.isEmpty(productWithBLOBs.getProductImage())
                ? PRODUCT_IMAGE_NOT_DEFINITION : productWithBLOBs.getProductImage().split(",")[0]);
        document.addField("createTime", productWithBLOBs.getProductCreateTime());
        document.addField("stroeId", productWithBLOBs.getProductStoreId());

        // 同步到solr去
        try {
            httpSolrClient.add(document);
            httpSolrClient.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, "出现异常", null);
        }

        return new SystemResult("ok");
    }
}
