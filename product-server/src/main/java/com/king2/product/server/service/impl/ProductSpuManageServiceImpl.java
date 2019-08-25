package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2ProductSpuMapper;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.ProductBasicsAppoint;
import com.king2.product.server.appoint.ProductSpuAppoint;
import com.king2.product.server.enmu.ProductSpuEnum;
import com.king2.product.server.mapper.ProductSpuMapper;
import com.king2.product.server.service.ProductSpuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/*=======================================================
	˵��:    ��ƷSPU����Serviceʵ����

	����		ʱ��					ע��
  	����		2019.08.20   			����
=======================================================*/
@Service
public class ProductSpuManageServiceImpl implements ProductSpuManageService {

    // ע����ƷSPUMapper
    @Autowired
    private K2ProductSpuMapper k2ProductSpuMapper;

    // ע�뱾�ص���ƷSPUMapper
    @Autowired
    private ProductSpuMapper productSpuMapper;

    // ע�볬������Ա�ı�־
    @Value("${SYSTEM_ROLE_PROVE}")
    private String SYSTEM_ROLE_PROVE;

    /**
     * -----------------------------------------------------
     * ����:  ��ѯ��Ʒ��SPU����
     * <p>
     * ����:
     * productId        String          ��Ʒid
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult getSpuByPId(Integer productId) {

        List<K2ProductSpu> spuByProductId = productSpuMapper.getSpuByProductId(productId);
        return new SystemResult(spuByProductId);
    }

    /**
     * -----------------------------------------------------
     * ����:  ɾ����Ʒ��SPU��Ϣ
     * <p>
     * ����:
     * spuId        String          ��Ʒ��SPUid
     * k2Member     K2Member        �������û���Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult delSpuById(Integer spuId, K2MemberAndElseInfo k2Member) {


        // У�������Ϣ
        SystemResult result = checkSpuInfoIsUser(spuId, k2Member);
        if (result.getStatus() != 200) return result;

        // ��������
        K2ProductSpu spu = new K2ProductSpu();
        spu.setProductSpuId(spuId);
        spu.setProductSpuState(ProductSpuEnum.DEL.getValue());
        // �߼�ɾ����Ʒ��SPU��Ϣ
        k2ProductSpuMapper.updateByPrimaryKeySelective(spu);
        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * ����:  �ָ�SPU����Ϣ
     * <p>
     * ����:
     * spuId        String          ��Ʒ��SPUid
     * k2Member     K2Member        �������û���Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult recoverNormal(Integer spuId, K2MemberAndElseInfo k2Member) {

        // У�������Ϣ
        SystemResult result = checkSpuInfoIsUser(spuId, k2Member);
        if (result.getStatus() != 200) return result;

        // ��������
        K2ProductSpu spu = new K2ProductSpu();
        spu.setProductSpuId(spuId);
        spu.setProductSpuState(ProductSpuEnum.SYZ.getValue());
        // �ָ�SPU����Ϣ
        k2ProductSpuMapper.updateByPrimaryKeySelective(spu);
        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * ����:  ����ע����Ʒ��SPU��Ϣ
     * <p>
     * ����:
     * spuIds        String         ��Ʒ��SPUIds
     * k2Member     K2Member        �������û���Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult batchCancelSpu(String spuIds, K2MemberAndElseInfo k2Member) {

        // ������Ҫ����ע������ƷSPU��Ϣ
        List<Integer> cancelSpuIds = new ArrayList<>();
        String[] spuSplit = spuIds.split(",");
        // ��������
        for (int i = 0; i < spuSplit.length; i++) {
            // �ж���ƷSPU��idʱ����ȷ
            if (StringUtils.isEmpty(spuSplit[i]) || !spuSplit[i].matches("[0-9]{1,}")) {
                // ��ƷSPUid������
                return new SystemResult(100, "��ƷSPUid����,��ˢ��ҳ������", null);
            }
            cancelSpuIds.add(Integer.parseInt(spuSplit[i]));
        }


        // ������� ��������
        if (!CollectionUtils.isEmpty(cancelSpuIds)) {
            // У�������Ϣ
            SystemResult result = checkSpuInfoIsUser(cancelSpuIds.get(0), k2Member);
            if (result.getStatus() != 200) return result;

            K2ProductSpu spu = new K2ProductSpu();
            spu.setProductSpuState(ProductSpuEnum.ZX.getValue());
            K2ProductSpuExample example = new K2ProductSpuExample();
            example.createCriteria().andProductSpuIdIn(cancelSpuIds);
            // �޸�����
            k2ProductSpuMapper.updateByExampleSelective(spu, example);
            return new SystemResult("ok");
        }
        return new SystemResult(100, "�빴ѡ��Ҫע������ƷSPU��Ϣ", null);
    }

    /**
     * -----------------------------------------------------
     * ����:  �޸���Ʒ��������Ϣ
     * <p>
     * ����:
     * spuKey        String         ��Ʒ��SPU������
     * skuValue      String         ��Ʒ�Ĳ���ֵ
     * productSpuId  String         ��Ʒ������Id
     * k2Member     K2Member        �������û���Ϣ
     * order        Integer         ����
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult editSpuInfo(String spuKey, String skuValue, Integer order, Integer productSpuId, K2MemberAndElseInfo k2Member) {


        // У�������Ϣ
        SystemResult result = checkSpuInfoIsUser(productSpuId, k2Member);
        if (result.getStatus() != 200) return result;
        // ��������
        K2ProductSpu spu = new K2ProductSpu();
        spu.setProductSpuName(spuKey);
        spu.setProductSpuValue(skuValue);
        spu.setProductSpuId(productSpuId);
        spu.setProductSpuOrder(order);
        // �޸���Ʒ��Ϣ
        k2ProductSpuMapper.updateByPrimaryKeySelective(spu);
        return new SystemResult("ok");
    }


    /**
     * /**
     * -----------------------------------------------------
     * ����:  �����Ʒ��SPU��Ϣ
     * <p>
     * ����:
     * productSpuJson         String            ��Ʒ��SPU��Ϣ
     * productId              Integer           ��Ʒ��id
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult addProductSpu(String productSpuJson, Integer productId, K2MemberAndElseInfo k2Member) {

        // ��ѯ���ֵ
        Integer maxOrder = productSpuMapper.getMaxOrder(productId);

        // У����Ʒ��SPU�Ƿ���ȷ
        SystemResult result = ProductSpuAppoint.checkProductSpuJsonInfo(productSpuJson, productId, k2Member.getK2Member(), maxOrder);
        if (result.getStatus() != 200) return result;

        // У�����ݳɹ�,���spu
        productSpuMapper.batchInsertProductSpu((List<K2ProductSpu>) result.getData());
        return result;
    }

    /**
     * У����Ʒ��SPU��Ϣ
     *
     * @param spuId
     * @param k2MemberAndElseInfo
     * @return
     */
    @Autowired
    private ProductBasicsAppoint productBasicsAppoint;

    public SystemResult checkSpuInfoIsUser(Integer spuId, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // �������ص�Result��Ϣ
        SystemResult result = null;
        // ��ѯ��Ʒ��Ϣ
        K2ProductWithBLOBs productBySpuId = productSpuMapper.getProductBySpuId(spuId);
        if (productBySpuId == null) {
            return new SystemResult(100, "��Ʒ��Ϣ���ش���,��ˢ��ҳ�����ԡ�", null);
        } else if ((result = productBasicsAppoint.checkProductIsUser(productBySpuId, k2MemberAndElseInfo, SYSTEM_ROLE_PROVE)).getStatus() != 200) {// ɾ��֮ǰ�Ƚ����ж� �Ƿ����ڸò����û�����Ʒ
            // ɾ��֮ǰ�Ƚ����ж� �Ƿ����ڸò����û�����Ʒ
            return result;
        } else {
            return result;
        }
    }
}
