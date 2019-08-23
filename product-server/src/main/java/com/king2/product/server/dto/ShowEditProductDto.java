package com.king2.product.server.dto;

import com.king2.commons.pojo.K2ProductBrand;

import java.util.List;

/**
 * 显示修改商品的Dto
 */
public class ShowEditProductDto {

    private ShowEditProductInfoDto productInfo;
    private List<K2ProductBrand> brands;
    private boolean isEditFlag;

    public ShowEditProductInfoDto getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ShowEditProductInfoDto productInfo) {
        this.productInfo = productInfo;
    }

    public List<K2ProductBrand> getBrands() {
        return brands;
    }

    public void setBrands(List<K2ProductBrand> brands) {
        this.brands = brands;
    }

    public boolean isEditFlag() {
        return isEditFlag;
    }

    public void setEditFlag(boolean editFlag) {
        isEditFlag = editFlag;
    }
}
