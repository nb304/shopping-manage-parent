package com.king2.product.server.appoint;

import com.king2.commons.mapper.K2ProductSkuKeyMapper;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.mapper.ProductSkuMapper;
import com.king2.product.server.pojo.ProductSkuPojo;
import com.king2.product.server.dto.ProductSkuDto;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/*=======================================================
	˵��:    ��ƷSKU����ί����

	����		ʱ��					ע��
  	����		2019.08.07   			����
=======================================================*/
@Component
public class ProductSkuAppoint {


    /**
     * -----------------------------------------------------
     * ����:  ����pojos��ȡ��Ӧ����ƷSKU������Ϣ���������
     * <p>
     * ����:
     * productSkuPojos          List<ProductSkuPojo>            SKUPOJO�����ݼ���
     * k2Member                 K2Member                        ��������Ա
     * k2Product                K2ProductWithBLOBs              ��Ʒ��Ϣ
     * <p>
     * ����: UserManageUtil              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static SystemResult addProductSkuKeyInfos(List<ProductSkuPojo> productSkuPojos, K2Member k2Member, K2ProductWithBLOBs k2ProductWithBLOBs,
                                                     ProductSkuMapper productSkuKeyMapper, K2ProductSkuKeyMapper k2ProductSkuKeyMapper) {

        // �ж�Pojo�Ƿ�������
        if (CollectionUtils.isEmpty(productSkuPojos)) return new SystemResult(100, "����д��ƷSKU����Ϣ", null);
        // ���ݼ��ϻ�ȡ��ƷSku��������
        SystemResult systemResult = forEachPojosReturnSkuLists(productSkuPojos, k2ProductWithBLOBs, k2Member, productSkuKeyMapper, k2ProductSkuKeyMapper);
        if (systemResult.getStatus() != 200) return systemResult;

        // �����Ʒsku
        ProductSkuDatas data = (ProductSkuDatas) systemResult.getData();
        SystemResult addProductSkuKey = addProductSkuKey(data, productSkuKeyMapper);

        return addProductSkuKey;
    }


    /**
     * -----------------------------------------------------
     * ����:   �����Ʒsku-key��Ϣ ������SKU����VALUE������
     * <p>
     * ����:
     * productSkuPojos          List<ProductSkuPojo>            SKUPOJO�����ݼ���
     * productSkuKeyMapper      ProductSkuKeyMapper             ��ƷSku-key��Mapper�ӿ�ʵ��
     * <p>
     * ����: UserManageUtil              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static SystemResult addProductSkuKey(ProductSkuDatas productSkuDatas, ProductSkuMapper productSkuKeyMapper) {
        // �����Ʒsku-key����Ϣ
        if (!CollectionUtils.isEmpty(productSkuDatas.getUserCreateSkus()))
            productSkuKeyMapper.batchInsertSkuKey(productSkuDatas.getUserCreateSkus());

        // ��ӳɹ��󴴽���sku-key��ֵ����
        // ��ӳɹ� �� ���������Ϻϲ�������
        productSkuDatas.getUserCreateSkus().addAll(productSkuDatas.getSystemCreateSKus());
        // ��������
        Collections.sort(productSkuDatas.getUserCreateSkus());

        // ����SKUValue�ķ�������
        List<K2ProductSkuValue> k2ProductSkuValues = new ArrayList<>();
        for (ProductSkuDto productSkuDto : productSkuDatas.getUserCreateSkus()) {
            // ��ȡ����ǰsku-key��value��Ϣ
            if (!StringUtils.isEmpty(productSkuDto.getProduct_sku_value())) {
                String[] split = productSkuDto.getProduct_sku_value().split(",");
                for (String s : split) {
                    K2ProductSkuValue value = new K2ProductSkuValue();
                    value.setSkuValue(s);
                    value.setSkuKeyId(productSkuDto.getProductSkuKeyId());
                    k2ProductSkuValues.add(value);
                }
            }

        }
        return new SystemResult(k2ProductSkuValues);
    }


    /**
     * -----------------------------------------------------
     * ����:  ����pojos��ȡ��Ӧ����ƷSKU������Ϣ2
     * <p>
     * ����:
     * productSkuPojos          List<ProductSkuPojo>            SKUPOJO�����ݼ���
     * k2Member                 K2Member                        ��������Ա
     * k2Product                K2ProductWithBLOBs              ��Ʒ��Ϣ
     * <p>
     * ����: UserManageUtil              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static SystemResult forEachPojosReturnSkuLists(List<ProductSkuPojo> productSkuPojos, K2ProductWithBLOBs k2Product,
                                                          K2Member k2Member, ProductSkuMapper productSkuKeyMapper, K2ProductSkuKeyMapper k2ProductSkuKeyMapper) {

        // ����SKU����ֵ
        List<ProductSkuDto> productSkuDtos = new ArrayList<>();
        // ����ϵͳ����õ�SKU��Ϣ
        List<ProductSkuDto> systemProductSkuDtos = new ArrayList<>();
        // ����SKU������Ʒ��Ϣ����
        List<K2ProductCommonskus> k2ProductCommonskuses = new ArrayList<K2ProductCommonskus>();
        // ����POJO��Ϣ��װSKU����
        // ����count;
        int count = 0;
        for (ProductSkuPojo productSkuPojo : productSkuPojos) {
            // �鿴
            // У���������У��ɹ��򷵻�SKU����
            ProductSkuDto dto = new ProductSkuDto();
            // У��SKU����
            if (StringUtils.isEmpty(productSkuPojo.getProductSkuKeyName()) || productSkuPojo.getProductSkuKeyName().length() > 50) {
                return new SystemResult(100, "sku��key��������Χ��1~50��", null);
            }
            // У��SKU��Value
            if (StringUtils.isEmpty(productSkuPojo.getSkuValue())) {
                return new SystemResult(100, "sku��ֵ����Ϊ��", null);
            }

            // �ж��Ƿ���ϵͳ����
            if (productSkuPojo.isSystemDef()) {
                // ��ϵͳ����  ��Ҫ�����Ʒ��Ϣ��Ӧ��SKU���������Ϣ
                if (StringUtils.isEmpty(productSkuPojo.getProductSkuKeyId()) || !productSkuPojo.getProductSkuKeyId().matches("[0-9]{1,}")) {
                    // ϵͳ������SKU��Ϣ����
                    return new SystemResult(100, "ϵͳ������SKU��Ϣ����", null);
                }

                // �鿴��SKU��Ϣ�Ƿ�Ϊ��
                K2ProductSkuKey productSkuKey = k2ProductSkuKeyMapper.selectByPrimaryKey(Integer.parseInt(productSkuPojo.getProductSkuKeyId()));
                if (productSkuKey == null || productSkuKey.getSkuKeyState() != 1)
                    return new SystemResult(100, "����ʧ�ܣ���ˢ��ҳ������", null);

                // ��ȫ������Ϣ����
                K2ProductCommonskus commonskus = new K2ProductCommonskus();
                commonskus.setCommonsSkuId(Integer.parseInt(productSkuPojo.getProductSkuKeyId()));
                commonskus.setProductId(k2Product.getProductId());
                k2ProductCommonskuses.add(commonskus);
                // ���ι�����SKUֵ��Ϣ
                dto.setIsSystemCreate(1);
                dto.setProduct_sku_value(productSkuPojo.getSkuValue());
                dto.setSkuKeyOrder(productSkuKey.getSkuKeyOrder());
                dto.setProductSkuKeyId(productSkuKey.getProductSkuKeyId());
                systemProductSkuDtos.add(dto);
                continue;
            }

            // ��ȫ����
            dto.setProduct_sku_value(productSkuPojo.getSkuValue());
            dto.setProductSkuKeyName(productSkuPojo.getProductSkuKeyName());
            dto.setBelongProductId(k2Product.getProductId());
            dto.setBelongCategoryId(k2Product.getProductTwoCategoryId());
            // �Ƿ���ϵͳ������  ---1�� 2��
            dto.setIsSystemCreate(2);
            dto.setCreateUserid(k2Member.getMemberId());
            dto.setCreateTime(new Date());
            dto.setBelongStoreId(Integer.parseInt(k2Member.getRetain1()));
            dto.setSkuKeyOrder(++count);
            //SKU���״̬  ---1����ʹ�� 2ɾ�� 3ע��
            dto.setSkuKeyState(1);
            productSkuDtos.add(dto);
        }
        // ������� ������ӹ�����SKU����
        if(!CollectionUtils.isEmpty(k2ProductCommonskuses)) productSkuKeyMapper.batchInsertCommonsSku(k2ProductCommonskuses);

        // �����ݷ�װ��������
        ProductSkuDatas skuDatas = new ProductSkuDatas();
        skuDatas.setSystemCreateSKus(systemProductSkuDtos);
        skuDatas.setUserCreateSkus(productSkuDtos);

        return new SystemResult(skuDatas);
    }

}

class ProductSkuDatas {

    private List<ProductSkuDto> userCreateSkus = new ArrayList<>();

    private List<ProductSkuDto> systemCreateSKus;

    public List<ProductSkuDto> getUserCreateSkus() {
        return userCreateSkus;
    }

    public void setUserCreateSkus(List<ProductSkuDto> userCreateSkus) {
        this.userCreateSkus = userCreateSkus;
    }

    public List<ProductSkuDto> getSystemCreateSKus() {
        return systemCreateSKus;
    }

    public void setSystemCreateSKus(List<ProductSkuDto> systemCreateSKus) {
        this.systemCreateSKus = systemCreateSKus;
    }
}
