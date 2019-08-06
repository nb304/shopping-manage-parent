package com.king2.commons.pojo;

import java.math.BigDecimal;

public class K2ProductSkuPriceandkc {
    /**
     * 商品SKU的价格库存表主键
     */
    private Integer skuPriceandkcId;

    /**
     * 该SKU库存价格表属于哪个商品  ---指向商品表主键
     */
    private Integer belongProductId;

    /**
     * 该SKU参数组的价格
     */
    private BigDecimal productSkuPrice;

    /**
     * 该SKU参数组的库存数量
     */
    private Integer productSkuKc;

    /**
     * 根据SKU_VALUE的id+排序组合出来的SKU信息
     */
    private String productSkuValueIds;

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
     * 该字段由多个SKU值的id组成，由,分开  ---指向sku值的id
     */
    private String skuPriceandkcValuelistid;

    /**
     * 商品SKU的价格库存表主键
     * @return sku_priceandkc_id 商品SKU的价格库存表主键
     */
    public Integer getSkuPriceandkcId() {
        return skuPriceandkcId;
    }

    /**
     * 商品SKU的价格库存表主键
     * @param skuPriceandkcId 商品SKU的价格库存表主键
     */
    public void setSkuPriceandkcId(Integer skuPriceandkcId) {
        this.skuPriceandkcId = skuPriceandkcId;
    }

    /**
     * 该SKU库存价格表属于哪个商品  ---指向商品表主键
     * @return belong_product_id 该SKU库存价格表属于哪个商品  ---指向商品表主键
     */
    public Integer getBelongProductId() {
        return belongProductId;
    }

    /**
     * 该SKU库存价格表属于哪个商品  ---指向商品表主键
     * @param belongProductId 该SKU库存价格表属于哪个商品  ---指向商品表主键
     */
    public void setBelongProductId(Integer belongProductId) {
        this.belongProductId = belongProductId;
    }

    /**
     * 该SKU参数组的价格
     * @return product_sku_price 该SKU参数组的价格
     */
    public BigDecimal getProductSkuPrice() {
        return productSkuPrice;
    }

    /**
     * 该SKU参数组的价格
     * @param productSkuPrice 该SKU参数组的价格
     */
    public void setProductSkuPrice(BigDecimal productSkuPrice) {
        this.productSkuPrice = productSkuPrice;
    }

    /**
     * 该SKU参数组的库存数量
     * @return product_sku_kc 该SKU参数组的库存数量
     */
    public Integer getProductSkuKc() {
        return productSkuKc;
    }

    /**
     * 该SKU参数组的库存数量
     * @param productSkuKc 该SKU参数组的库存数量
     */
    public void setProductSkuKc(Integer productSkuKc) {
        this.productSkuKc = productSkuKc;
    }

    /**
     * 根据SKU_VALUE的id+排序组合出来的SKU信息
     * @return product_sku_value_ids 根据SKU_VALUE的id+排序组合出来的SKU信息
     */
    public String getProductSkuValueIds() {
        return productSkuValueIds;
    }

    /**
     * 根据SKU_VALUE的id+排序组合出来的SKU信息
     * @param productSkuValueIds 根据SKU_VALUE的id+排序组合出来的SKU信息
     */
    public void setProductSkuValueIds(String productSkuValueIds) {
        this.productSkuValueIds = productSkuValueIds == null ? null : productSkuValueIds.trim();
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

    /**
     * 该字段由多个SKU值的id组成，由,分开  ---指向sku值的id
     * @return sku_priceandkc_valuelistid 该字段由多个SKU值的id组成，由,分开  ---指向sku值的id
     */
    public String getSkuPriceandkcValuelistid() {
        return skuPriceandkcValuelistid;
    }

    /**
     * 该字段由多个SKU值的id组成，由,分开  ---指向sku值的id
     * @param skuPriceandkcValuelistid 该字段由多个SKU值的id组成，由,分开  ---指向sku值的id
     */
    public void setSkuPriceandkcValuelistid(String skuPriceandkcValuelistid) {
        this.skuPriceandkcValuelistid = skuPriceandkcValuelistid == null ? null : skuPriceandkcValuelistid.trim();
    }
}