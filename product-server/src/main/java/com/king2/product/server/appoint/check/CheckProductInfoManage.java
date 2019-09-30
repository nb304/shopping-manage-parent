package com.king2.product.server.appoint.check;


import com.king2.commons.pojo.K2Product;
import com.king2.commons.pojo.K2ProductSkuKey;
import com.king2.commons.pojo.K2ProductSpu;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.utils.JsonUtils;
import com.king2.product.server.dto.AddProductDto;
import com.king2.product.server.dto.ProductSkuDto;
import com.king2.product.server.enmu.K2ProductSkuKeyEnum;
import com.king2.product.server.enmu.ProductEnum;
import com.king2.product.server.enmu.ProductSpuEnum;
import com.king2.product.server.enmu.ProductStateEnum;
import com.king2.product.server.exception.CheckValueException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/*=======================================================
	˵��:    ��Ʒ���У�����ݹ�����

	����		ʱ��					ע��
  	����		2019.09.29   			����
=======================================================*/
public class CheckProductInfoManage {

    /**
     * -----------------------------------------------------
     * ����:  У����Ʒ����Ŀ��Ϣ�Ƿ���ȷ
     * <p>
     * ����:
     * productDto         AddProductDto         ��Ҫ�жϵ���Ʒ��Ϣ
     * product            K2ProductWithBLOBs    ���ղ�������Ʒ����
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static void checkProductCategoryInfo(AddProductDto productDto, K2ProductWithBLOBs product)
            throws CheckValueException {
        // �ж���Ŀ�Ƿ���ȷ
        String[] categortArr = {};
        if (StringUtils.isEmpty(productDto.getProductCategory()) || productDto.getProductCategory().split(",").length != 2) {
            throw new CheckValueException("��Ʒ����Ŀ��Ϣ����,������ѡ��");
        } else {
            categortArr = productDto.getProductCategory().split(",");
        }
        for (String s : categortArr) {
            // �ж���Ŀ��Ϣ�Ƿ�������
            if (StringUtils.isEmpty(s) || !s.matches("[0-9]{1,}")) {
                throw new CheckValueException("��Ʒ����Ŀ��Ϣ����,������ѡ��");
            }
        }

        // ��Ŀ��Ϣ��ȷ
        product.setProductOneCategoryId(Integer.parseInt(categortArr[0]));
        product.setProductTwoCategoryId(Integer.parseInt(categortArr[1]));
    }

    /**
     * -----------------------------------------------------
     * ����:  У����Ʒ��������Ϣ
     * <p>
     * ����:
     * productDto         AddProductDto         ��Ҫ�жϵ���Ʒ��Ϣ
     * product            K2ProductWithBLOBs    ���ղ�������Ʒ����
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static void checkProductElseInfo(AddProductDto productDto, K2ProductWithBLOBs productWithBLOBs) throws CheckValueException {

        // У����Ʒ����
        if (!StringUtils.isEmpty(productDto.getProductPoints()) && (productDto.getProductPoints().length() > 200 || productDto.getProductPoints().length() < 10)) {
            throw new CheckValueException("��Ʒ������ַ�������10~200֮��");
        }

        // �ж��Ƿ�֧���˻�
        if (productDto.getProductIfSupport() != 1 && productDto.getProductIfSupport() != 2) {
            throw new CheckValueException("��ѡ���Ƿ�֧���˿�");
        } else if (productDto.getProductIfSupport() == 1 && StringUtils.isEmpty(productDto.getProductSupportDay() + "")) {
            throw new CheckValueException("��ѡ���������˻��˿������");
        }


        // ��Ʒ����Ϣ��������Ѿ������� ������Ҫ���������е����� ���뵽���ǵ�ProductInfo������ȥ
        productWithBLOBs.setProductName(productDto.getProductName());
        productWithBLOBs.setProductBrandId(productDto.getProductBrandId());
        productWithBLOBs.setProductSystemPrice(productDto.getProductSystemPrice());
        productWithBLOBs.setProductBazaarPrice(productDto.getProductBazaarPrice());
        productWithBLOBs.setProductPoints(productDto.getProductPoints());
        productWithBLOBs.setProductUnit(productDto.getProductUnit());
        productWithBLOBs.setProductSketchContent(productDto.getProductSketchContent());
        productWithBLOBs.setProductIfSupport(productDto.getProductIfSupport());
        productWithBLOBs.setProductSupportDay(productDto.getProductSupportDay());
        productWithBLOBs.setProductState(ProductStateEnum.SH.getValue());
        productWithBLOBs.setProductCreateTime(new Date());
        productWithBLOBs.setProductOrderRule(productDto.getProductOrderRule());
    }

    /**
     * -----------------------------------------------------
     * ����:  У����Ʒ��SPU��Ϣ�Ƿ���ȷ �����ȷ�ͷ�����Ʒ��SPU�����б�
     * <p>
     * ����:
     * productDto         AddProductDto         ��Ҫ�жϵ���Ʒ��Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static List<K2ProductSpu> checkProductSpuJsonReturnSpuInfoLists(AddProductDto productDto) throws CheckValueException {

        // �ж���Ʒ��SPU��Ϣ�Ƿ�Ϊ��
        if (StringUtils.isEmpty(productDto.getProductSpu())) {
            throw new CheckValueException("��Ʒ�Ĳ�����Ϣ����Ϊ��");
        }
        productDto.setProductSpu(productDto.getProductSpu().replaceAll("\\\\", ""));
        // ��Ϊ�վͽ���Ϣת���ɼ���
        List<ProductSpuInfo> productSpuInfos = null;
        try {
            productSpuInfos = JsonUtils.jsonToList(productDto.getProductSpu(), ProductSpuInfo.class);
            if (CollectionUtils.isEmpty(productSpuInfos)) {
                throw new CheckValueException("��Ʒ�Ĳ�����Ϣ����Ϊ��");
            }
        } catch (Exception e) {
            throw new CheckValueException("��Ʒ�Ĳ�����Ϣת������,���Ժ�����.");
        }

        // ������Ʒ��SPU��Ϣ ��У��
        List<K2ProductSpu> spus = new ArrayList<>();
        int count = 0;
        for (ProductSpuInfo productSpuInfo : productSpuInfos) {
            // �ж�����
            if (StringUtils.isEmpty(productSpuInfo.getProductSpuName()) || productSpuInfo.getProductSpuName().length() > 20) {
                throw new CheckValueException("��Ʒ�����������ַ�����Ϊ1-20֮��");
            } else if (StringUtils.isEmpty(productSpuInfo.getProductSpuValue()) || productSpuInfo.getProductSpuValue().length() > 100) {
                throw new CheckValueException("��Ʒ������ֵ�ַ�����Ϊ1-100֮��");
            }
            K2ProductSpu spu = new K2ProductSpu();
            spu.setCreateTime(new Date());
            spu.setProductSpuName(productSpuInfo.getProductSpuName());
            spu.setProductSpuValue(productSpuInfo.getProductSpuValue());
            spu.setProductSpuOrder(count++);
            spu.setProductSpuState(ProductSpuEnum.SYZ.getValue());
            spus.add(spu);
        }
        return spus;
    }


    /**
     * -----------------------------------------------------
     * ����:  У����Ʒ��SKU��Ϣ�Ƿ���ȷ �����ȷ�ͷ�����Ʒ��SKU�����б�
     * <p>
     * ����:
     * productDto         AddProductDto         ��Ҫ�жϵ���Ʒ��Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static List<ProductSkuDto> checkProductSkuJsonReturnSkuInfoLists(AddProductDto productDto) throws CheckValueException {
        // �ж���Ʒ��SPU��Ϣ�Ƿ�Ϊ��
        if (StringUtils.isEmpty(productDto.getProductSpu())) {
            throw new CheckValueException("��Ʒ�Ĳ�����Ϣ����Ϊ��");
        }
        productDto.setProductSku(productDto.getProductSku().replaceAll("\\\\", ""));
        // ��Ϊ�վͽ���Ϣת���ɼ���
        List<ProductSkuInfo> productSkuInfos = null;
        try {
            productSkuInfos = JsonUtils.jsonToList(productDto.getProductSku(), ProductSkuInfo.class);
            if (CollectionUtils.isEmpty(productSkuInfos)) {
                throw new CheckValueException("��Ʒ��������Ϣ����Ϊ��");
            }
        } catch (Exception e) {
            throw new CheckValueException("��Ʒ��������Ϣת������,���Ժ�����.");
        }

        List<ProductSkuDto> skuDtos = new ArrayList<>();
        for (int i = 0; i < productSkuInfos.size(); i++) {
            ProductSkuInfo productSkuInfo = productSkuInfos.get(i);
            if (StringUtils.isEmpty(productSkuInfo.getProductSkuName()) || productSkuInfo.getProductSkuName().length() > 20) {
                throw new CheckValueException("��Ʒ���õ������ַ�����Ϊ1-20֮��");
            } else if (StringUtils.isEmpty(productSkuInfo.getProductSkuValue())) {
                throw new CheckValueException("��Ʒ���õ�ֵ����Ϊ��");
            }
            // У����Ʒ��SKU����
            ProductSkuDto skuDto = new ProductSkuDto();
            skuDto.setProduct_sku_value(productSkuInfo.getProductSkuValue());
            skuDto.setSkuKeyOrder(i);
            skuDto.setProductSkuKeyName(productSkuInfo.getProductSkuName());
            skuDto.setSkuKeyState(K2ProductSkuKeyEnum.ZCSY.getValue());
            skuDto.setCreateTime(new Date());
            skuDto.setIsSystemCreate(K2ProductSkuKeyEnum.SYSTEM_FLAG_NO.getValue());
            skuDtos.add(skuDto);
        }
        return skuDtos;
    }

}

// ��Ʒ��Spu��Ϣ
class ProductSpuInfo {
    private String productSpuName;
    private String productSpuValue;

    public String getProductSpuName() {
        return productSpuName;
    }

    public void setProductSpuName(String productSpuName) {
        this.productSpuName = productSpuName;
    }

    public String getProductSpuValue() {
        return productSpuValue;
    }

    public void setProductSpuValue(String productSpuValue) {
        this.productSpuValue = productSpuValue;
    }
}

// ��Ʒ��SKU��Ϣ
class ProductSkuInfo {
    private String productSkuName;
    private String productSkuValue;

    public String getProductSkuName() {
        return productSkuName;
    }

    public void setProductSkuName(String productSkuName) {
        this.productSkuName = productSkuName;
    }

    public String getProductSkuValue() {
        return productSkuValue;
    }

    public void setProductSkuValue(String productSkuValue) {
        this.productSkuValue = productSkuValue;
    }
}
