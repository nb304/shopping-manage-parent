package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2ProductMapper;
import com.king2.commons.mapper.K2ProductSkuPriceandkcMapper;
import com.king2.commons.pojo.K2ProductSkuPriceandkc;
import com.king2.commons.pojo.K2ProductSkuPriceandkcExample;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.ProductBasicsAppoint;
import com.king2.product.server.appoint.ProductSkuValueKcAppoint;
import com.king2.product.server.mapper.ProductManageMapper;
import com.king2.product.server.service.ProductSkuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*=======================================================
	˵��:    ��ƷSKU����Serviceʵ����

	����		ʱ��					ע��
  	����		2019.08.21   			����
=======================================================*/
@Service
public class ProductSkuManageServiceImpl implements ProductSkuManageService {

    // ע��Զ�̵���Ʒ���Mapper
    @Autowired
    private K2ProductSkuPriceandkcMapper k2ProductSkuPriceandkcMapper;
    // ע��Զ�̵���ƷMapper
    @Autowired
    private K2ProductMapper k2ProductMapper;

    /**
     * -----------------------------------------------------
     * ����:   ������Ʒid��ȡ����Ʒ��SKU��Ϣ����
     * <p>
     * ����:
     * productId          Integer         ��ƷID
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult getSkuByProductId(Integer productId) {

        // ������Ʒid��ѯ��Ʒ��SKU��Ϣ
        K2ProductSkuPriceandkcExample example = new K2ProductSkuPriceandkcExample();
        example.createCriteria().andBelongProductIdEqualTo(productId);
        List<K2ProductSkuPriceandkc> k2ProductSkuPriceandkcs = k2ProductSkuPriceandkcMapper.selectByExampleWithBLOBs(example);
        // �����ݷ��ظ�Controller
        return new SystemResult(k2ProductSkuPriceandkcs);
    }

    /**
     * -----------------------------------------------------
     * ����:   �޸���ƷSKU��Ϣ
     * <p>
     * ����:
     * skuKcInfo          String         ��ƷSKU����Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult editSkuInfo(String skuKcInfo) {

        // У���޸ĵ���ƷSKU�����Ϣ�Ƿ���ȷ
        SystemResult result = ProductSkuValueKcAppoint.checkEditProductSkuKcInfo(skuKcInfo);
        if (result.getStatus() != 200) return result;

        // У��ɹ� ȡ��ֵ
        List<K2ProductSkuPriceandkc> kcs = (List<K2ProductSkuPriceandkc>) result.getData();
        // ȡ��һ����Ʒ��Ϣ��id
        Integer productId = kcs.get(0).getBelongProductId();
        // ������Ҫ�޸ĵ�ֵȡ����������Щ��Խ��ǰ��
        kcs.forEach((n) -> {
            n.clearValue();
            k2ProductSkuPriceandkcMapper.updateByPrimaryKeySelective(n);
        });

        // �޸ĳɹ� ������д����Ϣ
        // ��ѯһ�����ݿ� ȡ����Ϣ
        K2ProductWithBLOBs k2ProductWithBLOBs = k2ProductMapper.selectByPrimaryKey(productId);
        ProductBasicsAppoint.addSynchronizedProductGotoCache(k2ProductWithBLOBs);

        return new SystemResult("ok");
    }
}
