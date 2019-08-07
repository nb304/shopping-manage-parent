package com.king2.product.server.dto;


import com.king2.commons.pojo.K2ProductSkuKey;

/**
 * 商品SKU的Dto数据
 */
public class ProductSkuDto extends K2ProductSkuKey {

    // 商品SKU的VALUE值
    private String product_sku_value;

    public String getProduct_sku_value() {
        return product_sku_value;
    }

    public void setProduct_sku_value(String product_sku_value) {
        this.product_sku_value = product_sku_value;
    }
}
