package com.king2.product.server.dto;

import com.king2.commons.pojo.K2ProductWithBLOBs;

import javax.validation.constraints.NotBlank;

/**
 * 添加商品的Dto信息
 */
public class AddProductDto extends K2ProductWithBLOBs {

    // 商品的两个类目
    @NotBlank(message = "商品的类目信息不能为空")
    private String productCategory;
    // 商品的SPU信息
    @NotBlank(message = "商品的参数信息不能为空")
    private String productSpu;
    // 商品的SKU信息
    @NotBlank(message = "商品的配置信息不能为空")
    private String productSku;

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductSpu() {
        return productSpu;
    }

    public void setProductSpu(String productSpu) {
        this.productSpu = productSpu;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }
}
