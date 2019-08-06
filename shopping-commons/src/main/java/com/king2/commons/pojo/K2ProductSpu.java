package com.king2.commons.pojo;

import java.util.Date;

public class K2ProductSpu {
    /**
     * 商品SPU表主键
     */
    private Integer productSpuId;

    /**
     * SPU的名称 key
     */
    private String productSpuName;

    /**
     * SPU名称的值 value
     */
    private String productSpuValue;

    /**
     * SPU排序规则
     */
    private Integer productSpuOrder;

    /**
     * SPU当前的状态 1使用者 2删除
     */
    private Integer productSpuState;

    /**
     * 该SPU属于哪个商品  ---指向商品的主键
     */
    private Integer belongProductId;

    /**
     * 创建时间
     */
    private Date createTime;

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
     * 商品SPU表主键
     * @return product_spu_id 商品SPU表主键
     */
    public Integer getProductSpuId() {
        return productSpuId;
    }

    /**
     * 商品SPU表主键
     * @param productSpuId 商品SPU表主键
     */
    public void setProductSpuId(Integer productSpuId) {
        this.productSpuId = productSpuId;
    }

    /**
     * SPU的名称 key
     * @return product_spu_name SPU的名称 key
     */
    public String getProductSpuName() {
        return productSpuName;
    }

    /**
     * SPU的名称 key
     * @param productSpuName SPU的名称 key
     */
    public void setProductSpuName(String productSpuName) {
        this.productSpuName = productSpuName == null ? null : productSpuName.trim();
    }

    /**
     * SPU名称的值 value
     * @return product_spu_value SPU名称的值 value
     */
    public String getProductSpuValue() {
        return productSpuValue;
    }

    /**
     * SPU名称的值 value
     * @param productSpuValue SPU名称的值 value
     */
    public void setProductSpuValue(String productSpuValue) {
        this.productSpuValue = productSpuValue == null ? null : productSpuValue.trim();
    }

    /**
     * SPU排序规则
     * @return product_spu_order SPU排序规则
     */
    public Integer getProductSpuOrder() {
        return productSpuOrder;
    }

    /**
     * SPU排序规则
     * @param productSpuOrder SPU排序规则
     */
    public void setProductSpuOrder(Integer productSpuOrder) {
        this.productSpuOrder = productSpuOrder;
    }

    /**
     * SPU当前的状态 1使用者 2删除
     * @return product_spu_state SPU当前的状态 1使用者 2删除
     */
    public Integer getProductSpuState() {
        return productSpuState;
    }

    /**
     * SPU当前的状态 1使用者 2删除
     * @param productSpuState SPU当前的状态 1使用者 2删除
     */
    public void setProductSpuState(Integer productSpuState) {
        this.productSpuState = productSpuState;
    }

    /**
     * 该SPU属于哪个商品  ---指向商品的主键
     * @return belong_product_id 该SPU属于哪个商品  ---指向商品的主键
     */
    public Integer getBelongProductId() {
        return belongProductId;
    }

    /**
     * 该SPU属于哪个商品  ---指向商品的主键
     * @param belongProductId 该SPU属于哪个商品  ---指向商品的主键
     */
    public void setBelongProductId(Integer belongProductId) {
        this.belongProductId = belongProductId;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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