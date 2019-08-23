package com.king2.product.server.appoint;

import com.king2.commons.mapper.K2ProductCategoryMapper;
import com.king2.commons.pojo.K2ProductCategory;
import com.king2.commons.pojo.K2ProductCategoryExample;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.ProductCategoryDto;
import com.king2.product.server.dto.ShowProductAddPageDto;
import com.king2.product.server.enmu.ProductEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
                    .andCategoryStateEqualTo(ProductEnum.PRODUCT_CATEGORY_TYPE1);;
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

}
