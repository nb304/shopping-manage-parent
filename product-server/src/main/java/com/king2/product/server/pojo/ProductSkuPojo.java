package com.king2.product.server.pojo;

public class ProductSkuPojo implements Comparable<ProductSkuPojo> {

    // sku的key
    private String skuKey;
    // sku的value
    private String skuValue;
    // sku的排序
    private String spuOrder;
    // sku是否为系统定义
    private boolean isSystemDef;

    public String getSkuKey() {
        return skuKey;
    }

    public void setSkuKey(String skuKey) {
        this.skuKey = skuKey;
    }

    public String getSkuValue() {
        return skuValue;
    }

    public void setSkuValue(String skuValue) {
        this.skuValue = skuValue;
    }

    public String getSpuOrder() {
        return spuOrder;
    }

    public void setSpuOrder(String spuOrder) {
        this.spuOrder = spuOrder;
    }

    public boolean isSystemDef() {
        return isSystemDef;
    }

    public void setSystemDef(boolean systemDef) {
        isSystemDef = systemDef;
    }

    @Override
    public int compareTo(ProductSkuPojo o) {
        return Integer.parseInt(this.spuOrder) - Integer.parseInt(o.getSpuOrder());
    }
}
