package com.king2.product.server.appoint;

import com.king2.commons.mapper.K2ProductCategoryMapper;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2ProductCategory;
import com.king2.commons.pojo.K2ProductCategoryExample;
import com.king2.commons.pojo.K2ProductSkuKey;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.ProductCategoryDto;
import com.king2.product.server.dto.ProductSkuDto;
import com.king2.product.server.dto.ShowProductAddPageDto;
import com.king2.product.server.enmu.ProductEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*=======================================================
	˵��:    ��Ʒ��Ŀί����

	����		ʱ��					ע��
  	����		2019.08.10   			����
=======================================================*/
@Component
public class ProductCategoryAppoint {

    // ע����ĿMapper
    @Autowired
    private K2ProductCategoryMapper k2ProductCategoryMapper;

    /**
     * -----------------------------------------------------
     * ����:  ��ѯ��Ʒ��Ŀ��Ϣ
     * <p>
     * ����:
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public SystemResult getProductCategoryInfo() {

        // ��ѯ��Ʒ��Ŀ����Ϣ
        SystemResult productOneCategoryInfo = getProductOneCategoryInfo();
        return productOneCategoryInfo;
    }


    /**
     * -----------------------------------------------------
     * ����:  ����һ����Ŀ����Ϣ
     * <p>
     * ����:
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    private SystemResult getProductOneCategoryInfo() {
        // ��ѯһ����Ŀ
        K2ProductCategoryExample categoryExample = new K2ProductCategoryExample();
        categoryExample.createCriteria().andCategoryIsParentEqualTo(ProductEnum.PRODUCT_ONE_CATEGORY)
                .andCategoryStateEqualTo(ProductEnum.PRODUCT_CATEGORY_TYPE1);
        // ��ѯ��һ����Ŀ
        List<K2ProductCategory> k2ProductCategories = k2ProductCategoryMapper.selectByExample(categoryExample);
        // ��ѯ��һ����Ŀ�� ȥ������������Ŀ������
        SystemResult productTwoCategoryInfo = getProductTwoCategoryInfo(k2ProductCategories);
        return productTwoCategoryInfo;
    }

    /**
     * -----------------------------------------------------
     * ����:  ���������Ŀ����Ϣ
     * <p>
     * ����:
     * k2ProductOneCategories       List<K2ProductCategory>         ��Ʒ��һ����Ŀ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    private SystemResult getProductTwoCategoryInfo(List<K2ProductCategory> k2ProductOneCategories) {

        // �жϼ�����Ϣ�Ƿ����
        if (CollectionUtils.isEmpty(k2ProductOneCategories)) return new SystemResult(100, "��Ŀ��ϢΪ��", null);

        // ��Ʒ��ѯ����
        K2ProductCategoryExample categoryExample = new K2ProductCategoryExample();
        // ������������
        ShowProductAddPageDto productCategoryDto = new ShowProductAddPageDto();
        // ������Ʒ��Ŀ����Ϣ
        List<ProductCategoryDto> productCategoryDtos = new ArrayList<>();
        // �������Ķ�����Ŀ��Ϣ
        for (int i = 0; i < k2ProductOneCategories.size(); i++) {
            // ������Ŀ����
            ProductCategoryDto dto = new ProductCategoryDto();
            // ����һ����Ŀ����Ϣ
            K2ProductCategory k2ProductCategory = k2ProductOneCategories.get(i);
            // ��ȫһ����Ŀ����Ϣ
            dto.setValue(k2ProductCategory.getCategoryId() + "");
            dto.setLabel(k2ProductCategory.getCategoryName());

            // ��ѯ��һ����Ŀ������Ŀ��Ϣ
            categoryExample.clear();
            categoryExample.createCriteria().andCategoryIsParentEqualTo(ProductEnum.PRODUCT_TWO_CATEGORY)
                    .andCategoryParentIdEqualTo(k2ProductCategory.getCategoryId())
                    .andCategoryStateEqualTo(ProductEnum.PRODUCT_CATEGORY_TYPE1);
            ;
            List<K2ProductCategory> k2ProductTwoCategories = k2ProductCategoryMapper.selectByExample(categoryExample);

            // ��ѯ�Ƿ��������Ŀ
            if (!CollectionUtils.isEmpty(k2ProductTwoCategories)) {
                // �����Ӽ�����Ϣ
                // ������Ʒ��Ŀ����Ϣ
                List<ProductCategoryDto> productTwoCategoryDtos = new ArrayList<>();
                // ������Ϣ
                for (int i1 = 0; i1 < k2ProductTwoCategories.size(); i1++) {
                    K2ProductCategory k2TwoProductInfo = k2ProductTwoCategories.get(i1);
                    ProductCategoryDto dto1 = new ProductCategoryDto();
                    dto1.setValue(k2TwoProductInfo.getCategoryId() + "");
                    dto1.setLabel(k2TwoProductInfo.getCategoryName());
                    productTwoCategoryDtos.add(dto1);
                }
                dto.setChildren(productTwoCategoryDtos);

            }

            // ���һ����Ŀ����Ϣ
            productCategoryDtos.add(dto);
        }

        productCategoryDto.setProductCategorys(productCategoryDtos);
        return new SystemResult(productCategoryDto);
    }

    /**
     * -----------------------------------------------------
     * ����:   У����Ŀ��SKU��Ϣģ���Ƿ���ȷ
     * <p>
     * ����:
     * skuJsons         String         skuJson��
     * flag             boolean        ��ǰ������û��Ƿ��ǹ���Ա
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public SystemResult checkCategorySkuInfoAndReturnSkuLists(String skuJsons, boolean flag, Integer residueSize,
                                                              Integer categoryId, K2Member k2Member, Integer order) {

        // �ж�JSON�Ƿ�Ϊ��
        if (StringUtils.isEmpty(skuJsons)) return new SystemResult(100, "�����һ��SKU��Ϣ");

        // SKU��Ϣ���� ����ͨ��,�����ָ�
        String[] skuSplit = skuJsons.split(",");
        // �ж�SKU�ĸ���
        if (skuSplit.length < 1 || (!flag && skuSplit.length > residueSize)) {
            return new SystemResult(100, "ʣ���Լ�����Ĵ���Ϊ:" + residueSize + "����������������Ҫ������ϵ����Ա");
        }


        // �������ص�SKU��Ϣ����
        List<ProductSkuDto> keys = new ArrayList<>();

        // �鿴SKU�����Ƿ���ȷ
        for (String s : skuSplit) {
            if (StringUtils.isEmpty(s)) {
                return new SystemResult(100, "�뽫SKU��Ϣ��д����");
            } else if (s.length() > 50) {
                return new SystemResult(100, "SKU������Ϊ1-50�ַ�");
            }
            ProductSkuDto skuKey = new ProductSkuDto();
            skuKey.setBelongCategoryId(categoryId);
            skuKey.setProductSkuKeyName(s);
            skuKey.setIsSystemCreate(flag ? 1 : 2);
            skuKey.setCreateUserid(k2Member.getMemberId());
            skuKey.setBelongStoreId(flag ? null : Integer.parseInt(k2Member.getRetain1()));
            skuKey.setSkuKeyState(1);
            skuKey.setSkuKeyOrder(order++);
            skuKey.setCreateTime(new Date());
            skuKey.setRetain1("1");
            keys.add(skuKey);
        }

        return new SystemResult(keys);
    }

}
