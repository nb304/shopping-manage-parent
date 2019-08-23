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
	说明:    商品类目委派类

	作者		时间					注释
  	俞烨		2019.08.10   			创建
=======================================================*/
@Component
public class ProductCategoryAppoint {

    // 注入类目Mapper
    @Autowired
    private K2ProductCategoryMapper k2ProductCategoryMapper;

    /**
     * -----------------------------------------------------
     * 功能:  查询商品类目信息
     * <p>
     * 参数:
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public SystemResult getProductCategoryInfo() {

        // 查询商品类目的信息
        SystemResult productOneCategoryInfo = getProductOneCategoryInfo();
        return productOneCategoryInfo;
    }


    /**
     * -----------------------------------------------------
     * 功能:  处理一级类目的信息
     * <p>
     * 参数:
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    private SystemResult getProductOneCategoryInfo() {
        // 查询一级类目
        K2ProductCategoryExample categoryExample = new K2ProductCategoryExample();
        categoryExample.createCriteria().andCategoryIsParentEqualTo(ProductEnum.PRODUCT_ONE_CATEGORY)
                .andCategoryStateEqualTo(ProductEnum.PRODUCT_CATEGORY_TYPE1);
        // 查询出一级类目
        List<K2ProductCategory> k2ProductCategories = k2ProductCategoryMapper.selectByExample(categoryExample);
        // 查询出一级类目后 去处理他二级类目的数据
        SystemResult productTwoCategoryInfo = getProductTwoCategoryInfo(k2ProductCategories);
        return productTwoCategoryInfo;
    }

    /**
     * -----------------------------------------------------
     * 功能:  处理二级类目的信息
     * <p>
     * 参数:
     * k2ProductOneCategories       List<K2ProductCategory>         商品的一级类目
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    private SystemResult getProductTwoCategoryInfo(List<K2ProductCategory> k2ProductOneCategories) {

        // 判断集合信息是否存在
        if (CollectionUtils.isEmpty(k2ProductOneCategories)) return new SystemResult(100, "类目信息为空", null);

        // 商品查询条件
        K2ProductCategoryExample categoryExample = new K2ProductCategoryExample();
        // 创建返回数据
        ShowProductAddPageDto productCategoryDto = new ShowProductAddPageDto();
        // 创建商品类目的信息
        List<ProductCategoryDto> productCategoryDtos = new ArrayList<>();
        // 处理他的二级类目信息
        for (int i = 0; i < k2ProductOneCategories.size(); i++) {
            // 创建类目对象
            ProductCategoryDto dto = new ProductCategoryDto();
            // 本次一级类目的信息
            K2ProductCategory k2ProductCategory = k2ProductOneCategories.get(i);
            // 补全一级类目的信息
            dto.setValue(k2ProductCategory.getCategoryId() + "");
            dto.setLabel(k2ProductCategory.getCategoryName());

            // 查询该一级类目的子类目信息
            categoryExample.clear();
            categoryExample.createCriteria().andCategoryIsParentEqualTo(ProductEnum.PRODUCT_TWO_CATEGORY)
                    .andCategoryParentIdEqualTo(k2ProductCategory.getCategoryId())
                    .andCategoryStateEqualTo(ProductEnum.PRODUCT_CATEGORY_TYPE1);;
            List<K2ProductCategory> k2ProductTwoCategories = k2ProductCategoryMapper.selectByExample(categoryExample);

            // 查询是否存在子类目
            if (!CollectionUtils.isEmpty(k2ProductTwoCategories)) {
                // 创建子集合信息
                // 创建商品类目的信息
                List<ProductCategoryDto> productTwoCategoryDtos = new ArrayList<>();
                // 处理信息
                for (int i1 = 0; i1 < k2ProductTwoCategories.size(); i1++) {
                    K2ProductCategory k2TwoProductInfo = k2ProductTwoCategories.get(i1);
                    ProductCategoryDto dto1 = new ProductCategoryDto();
                    dto1.setValue(k2TwoProductInfo.getCategoryId() + "");
                    dto1.setLabel(k2TwoProductInfo.getCategoryName());
                    productTwoCategoryDtos.add(dto1);
                }
                dto.setChildren(productTwoCategoryDtos);

            }

            // 添加一级类目的信息
            productCategoryDtos.add(dto);
        }

        productCategoryDto.setProductCategorys(productCategoryDtos);
        return new SystemResult(productCategoryDto);
    }

}
