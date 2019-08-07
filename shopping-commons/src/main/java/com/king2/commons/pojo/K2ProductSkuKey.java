package com.king2.commons.pojo;

import java.util.Date;

public class K2ProductSkuKey {
    /**
     * SKU参数组表主键
     */
    private Integer productSkuKeyId;

    /**
     * 商品参数组的名称
     */
    private String productSkuKeyName;

    /**
     * 该SKU组属于哪个商品   ---指向商品表主键
     */
    private Integer belongProductId;

    /**
     * 该SKU组属于哪个二级类目  ---指向商品类目表主键
     */
    private Integer belongCategoryId;

    /**
     * 是否是系统创建的  ---1是 2否
     */
    private Integer isSystemCreate;

    /**
     * 创建该SKU参数组的用户id  ---指向用户表主键
     */
    private Integer createUserid;

    /**
     * 该SKU参数组属于哪个店铺  ---指向店铺表主键
     */
    private Integer belongStoreId;

    /**
     * SKU组的状态  ---1正常使用 2删除 3注销
     */
    private Integer skuKeyState;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 排序规则
     */
    private Integer skuKeyOrder;

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
     * SKU参数组表主键
     * @return product_sku_key_id SKU参数组表主键
     */
    public Integer getProductSkuKeyId() {
        return productSkuKeyId;
    }

    /**
     * SKU参数组表主键
     * @param productSkuKeyId SKU参数组表主键
     */
    public void setProductSkuKeyId(Integer productSkuKeyId) {
        this.productSkuKeyId = productSkuKeyId;
    }

    /**
     * 商品参数组的名称
     * @return product_sku_key_name 商品参数组的名称
     */
    public String getProductSkuKeyName() {
        return productSkuKeyName;
    }

    /**
     * 商品参数组的名称
     * @param productSkuKeyName 商品参数组的名称
     */
    public void setProductSkuKeyName(String productSkuKeyName) {
        this.productSkuKeyName = productSkuKeyName == null ? null : productSkuKeyName.trim();
    }

    /**
     * 该SKU组属于哪个商品   ---指向商品表主键
     * @return belong_product_id 该SKU组属于哪个商品   ---指向商品表主键
     */
    public Integer getBelongProductId() {
        return belongProductId;
    }

    /**
     * 该SKU组属于哪个商品   ---指向商品表主键
     * @param belongProductId 该SKU组属于哪个商品   ---指向商品表主键
     */
    public void setBelongProductId(Integer belongProductId) {
        this.belongProductId = belongProductId;
    }

    /**
     * 该SKU组属于哪个二级类目  ---指向商品类目表主键
     * @return belong_category_id 该SKU组属于哪个二级类目  ---指向商品类目表主键
     */
    public Integer getBelongCategoryId() {
        return belongCategoryId;
    }

    /**
     * 该SKU组属于哪个二级类目  ---指向商品类目表主键
     * @param belongCategoryId 该SKU组属于哪个二级类目  ---指向商品类目表主键
     */
    public void setBelongCategoryId(Integer belongCategoryId) {
        this.belongCategoryId = belongCategoryId;
    }

    /**
     * 是否是系统创建的  ---1是 2否
     * @return is_system_create 是否是系统创建的  ---1是 2否
     */
    public Integer getIsSystemCreate() {
        return isSystemCreate;
    }

    /**
     * 是否是系统创建的  ---1是 2否
     * @param isSystemCreate 是否是系统创建的  ---1是 2否
     */
    public void setIsSystemCreate(Integer isSystemCreate) {
        this.isSystemCreate = isSystemCreate;
    }

    /**
     * 创建该SKU参数组的用户id  ---指向用户表主键
     * @return create_userid 创建该SKU参数组的用户id  ---指向用户表主键
     */
    public Integer getCreateUserid() {
        return createUserid;
    }

    /**
     * 创建该SKU参数组的用户id  ---指向用户表主键
     * @param createUserid 创建该SKU参数组的用户id  ---指向用户表主键
     */
    public void setCreateUserid(Integer createUserid) {
        this.createUserid = createUserid;
    }

    /**
     * 该SKU参数组属于哪个店铺  ---指向店铺表主键
     * @return belong_store_id 该SKU参数组属于哪个店铺  ---指向店铺表主键
     */
    public Integer getBelongStoreId() {
        return belongStoreId;
    }

    /**
     * 该SKU参数组属于哪个店铺  ---指向店铺表主键
     * @param belongStoreId 该SKU参数组属于哪个店铺  ---指向店铺表主键
     */
    public void setBelongStoreId(Integer belongStoreId) {
        this.belongStoreId = belongStoreId;
    }

    /**
     * SKU组的状态  ---1正常使用 2删除 3注销
     * @return sku_key_state SKU组的状态  ---1正常使用 2删除 3注销
     */
    public Integer getSkuKeyState() {
        return skuKeyState;
    }

    /**
     * SKU组的状态  ---1正常使用 2删除 3注销
     * @param skuKeyState SKU组的状态  ---1正常使用 2删除 3注销
     */
    public void setSkuKeyState(Integer skuKeyState) {
        this.skuKeyState = skuKeyState;
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
     * 排序规则
     * @return sku_key_order 排序规则
     */
    public Integer getSkuKeyOrder() {
        return skuKeyOrder;
    }

    /**
     * 排序规则
     * @param skuKeyOrder 排序规则
     */
    public void setSkuKeyOrder(Integer skuKeyOrder) {
        this.skuKeyOrder = skuKeyOrder;
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