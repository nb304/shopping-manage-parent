package com.king2.product.server.dto;

public class AddProductSpuDto {

    private String productSpuName;
    private String productSpuValue;
    private String productSpuOrder;
    private String key;

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

    public String getProductSpuOrder() {
        return productSpuOrder;
    }

    public void setProductSpuOrder(String productSpuOrder) {
        this.productSpuOrder = productSpuOrder;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
