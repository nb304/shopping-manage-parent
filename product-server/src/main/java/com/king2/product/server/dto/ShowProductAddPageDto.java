package com.king2.product.server.dto;

import com.king2.commons.pojo.K2ProductBrand;
import com.king2.commons.pojo.K2ProductCategory;

import java.util.List;

/**
 * 显示添加页面的Dto数据
 */
public class ShowProductAddPageDto {

    // 商品类目信息
    private List<ProductCategoryDto> productCategorys;

    // 商品品牌信息
    private List<K2ProductBrand> productBrands;

    public List<ProductCategoryDto> getProductCategorys() {
        return productCategorys;
    }

    public void setProductCategorys(List<ProductCategoryDto> productCategorys) {
        this.productCategorys = productCategorys;
    }

    public List<K2ProductBrand> getProductBrands() {
        return productBrands;
    }

    public void setProductBrands(List<K2ProductBrand> productBrands) {
        this.productBrands = productBrands;
    }
}
