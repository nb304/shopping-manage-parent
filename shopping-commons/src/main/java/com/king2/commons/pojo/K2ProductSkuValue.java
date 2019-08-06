package com.king2.commons.pojo;

public class K2ProductSkuValue {
    /**
     * 商品SKU表主键
     */
    private Integer productSkuValueId;

    /**
     * SKU的值
     */
    private String skuValue;

    /**
     * 该SKU值属于哪个SKUKey  ---指向SKUKEY的主键
     */
    private Integer skuKeyId;

    /**
     * 保留字段1
     */
    private String retain1;

    /**
     * 保留字段2
     */
    private String retain2;

    /**
     * 保留字段3
     */
    private String retain3;

    /**
     * 保留字段4
     */
    private String retain4;

    /**
     * 保留字段5
     */
    private String retain5;

    /**
     * 商品SKU表主键
     * @return product_sku_value_id 商品SKU表主键
     */
    public Integer getProductSkuValueId() {
        return productSkuValueId;
    }

    /**
     * 商品SKU表主键
     * @param productSkuValueId 商品SKU表主键
     */
    public void setProductSkuValueId(Integer productSkuValueId) {
        this.productSkuValueId = productSkuValueId;
    }

    /**
     * SKU的值
     * @return sku_value SKU的值
     */
    public String getSkuValue() {
        return skuValue;
    }

    /**
     * SKU的值
     * @param skuValue SKU的值
     */
    public void setSkuValue(String skuValue) {
        this.skuValue = skuValue == null ? null : skuValue.trim();
    }

    /**
     * 该SKU值属于哪个SKUKey  ---指向SKUKEY的主键
     * @return sku_key_id 该SKU值属于哪个SKUKey  ---指向SKUKEY的主键
     */
    public Integer getSkuKeyId() {
        return skuKeyId;
    }

    /**
     * 该SKU值属于哪个SKUKey  ---指向SKUKEY的主键
     * @param skuKeyId 该SKU值属于哪个SKUKey  ---指向SKUKEY的主键
     */
    public void setSkuKeyId(Integer skuKeyId) {
        this.skuKeyId = skuKeyId;
    }

    /**
     * 保留字段1
     * @return retain1 保留字段1
     */
    public String getRetain1() {
        return retain1;
    }

    /**
     * 保留字段1
     * @param retain1 保留字段1
     */
    public void setRetain1(String retain1) {
        this.retain1 = retain1 == null ? null : retain1.trim();
    }

    /**
     * 保留字段2
     * @return retain2 保留字段2
     */
    public String getRetain2() {
        return retain2;
    }

    /**
     * 保留字段2
     * @param retain2 保留字段2
     */
    public void setRetain2(String retain2) {
        this.retain2 = retain2 == null ? null : retain2.trim();
    }

    /**
     * 保留字段3
     * @return retain3 保留字段3
     */
    public String getRetain3() {
        return retain3;
    }

    /**
     * 保留字段3
     * @param retain3 保留字段3
     */
    public void setRetain3(String retain3) {
        this.retain3 = retain3 == null ? null : retain3.trim();
    }

    /**
     * 保留字段4
     * @return retain4 保留字段4
     */
    public String getRetain4() {
        return retain4;
    }

    /**
     * 保留字段4
     * @param retain4 保留字段4
     */
    public void setRetain4(String retain4) {
        this.retain4 = retain4 == null ? null : retain4.trim();
    }

    /**
     * 保留字段5
     * @return retain5 保留字段5
     */
    public String getRetain5() {
        return retain5;
    }

    /**
     * 保留字段5
     * @param retain5 保留字段5
     */
    public void setRetain5(String retain5) {
        this.retain5 = retain5 == null ? null : retain5.trim();
    }
}