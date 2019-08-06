package com.king2.commons.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class K2ProductCoupon {
    /**
     * 商品优惠券主键
     */
    private Integer productCouponId;

    /**
     * 优惠卷的标题
     */
    private String productCouponName;

    /**
     * 优惠类型 ---1店铺优惠 2商品优惠
     */
    private Integer productCouponType;

    /**
     * 优惠门槛 满减
     */
    private BigDecimal productCouponDoorsill;

    /**
     * 优惠金额
     */
    private BigDecimal productCouponPrice;

    /**
     * 发放个数
     */
    private Integer productCouponSize;

    /**
     * 活动开始
     */
    private Date productCouponStartTime;

    /**
     * 结束时间
     */
    private Date productCouponEndTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人 ---指向用户主键表
     */
    private Integer createUserId;

    /**
     * 优惠卷状态  1、发放中 2、发放完成 3、下架 4 删除
     */
    private Integer productCouponState;

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
     * 商品优惠券主键
     * @return product_coupon_id 商品优惠券主键
     */
    public Integer getProductCouponId() {
        return productCouponId;
    }

    /**
     * 商品优惠券主键
     * @param productCouponId 商品优惠券主键
     */
    public void setProductCouponId(Integer productCouponId) {
        this.productCouponId = productCouponId;
    }

    /**
     * 优惠卷的标题
     * @return product_coupon_name 优惠卷的标题
     */
    public String getProductCouponName() {
        return productCouponName;
    }

    /**
     * 优惠卷的标题
     * @param productCouponName 优惠卷的标题
     */
    public void setProductCouponName(String productCouponName) {
        this.productCouponName = productCouponName == null ? null : productCouponName.trim();
    }

    /**
     * 优惠类型 ---1店铺优惠 2商品优惠
     * @return product_coupon_type 优惠类型 ---1店铺优惠 2商品优惠
     */
    public Integer getProductCouponType() {
        return productCouponType;
    }

    /**
     * 优惠类型 ---1店铺优惠 2商品优惠
     * @param productCouponType 优惠类型 ---1店铺优惠 2商品优惠
     */
    public void setProductCouponType(Integer productCouponType) {
        this.productCouponType = productCouponType;
    }

    /**
     * 优惠门槛 满减
     * @return product_coupon_doorsill 优惠门槛 满减
     */
    public BigDecimal getProductCouponDoorsill() {
        return productCouponDoorsill;
    }

    /**
     * 优惠门槛 满减
     * @param productCouponDoorsill 优惠门槛 满减
     */
    public void setProductCouponDoorsill(BigDecimal productCouponDoorsill) {
        this.productCouponDoorsill = productCouponDoorsill;
    }

    /**
     * 优惠金额
     * @return product_coupon_price 优惠金额
     */
    public BigDecimal getProductCouponPrice() {
        return productCouponPrice;
    }

    /**
     * 优惠金额
     * @param productCouponPrice 优惠金额
     */
    public void setProductCouponPrice(BigDecimal productCouponPrice) {
        this.productCouponPrice = productCouponPrice;
    }

    /**
     * 发放个数
     * @return product_coupon_size 发放个数
     */
    public Integer getProductCouponSize() {
        return productCouponSize;
    }

    /**
     * 发放个数
     * @param productCouponSize 发放个数
     */
    public void setProductCouponSize(Integer productCouponSize) {
        this.productCouponSize = productCouponSize;
    }

    /**
     * 活动开始
     * @return product_coupon_start_time 活动开始
     */
    public Date getProductCouponStartTime() {
        return productCouponStartTime;
    }

    /**
     * 活动开始
     * @param productCouponStartTime 活动开始
     */
    public void setProductCouponStartTime(Date productCouponStartTime) {
        this.productCouponStartTime = productCouponStartTime;
    }

    /**
     * 结束时间
     * @return product_coupon_end_time 结束时间
     */
    public Date getProductCouponEndTime() {
        return productCouponEndTime;
    }

    /**
     * 结束时间
     * @param productCouponEndTime 结束时间
     */
    public void setProductCouponEndTime(Date productCouponEndTime) {
        this.productCouponEndTime = productCouponEndTime;
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
     * 创建人 ---指向用户主键表
     * @return create_user_id 创建人 ---指向用户主键表
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建人 ---指向用户主键表
     * @param createUserId 创建人 ---指向用户主键表
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 优惠卷状态  1、发放中 2、发放完成 3、下架 4 删除
     * @return product_coupon_state 优惠卷状态  1、发放中 2、发放完成 3、下架 4 删除
     */
    public Integer getProductCouponState() {
        return productCouponState;
    }

    /**
     * 优惠卷状态  1、发放中 2、发放完成 3、下架 4 删除
     * @param productCouponState 优惠卷状态  1、发放中 2、发放完成 3、下架 4 删除
     */
    public void setProductCouponState(Integer productCouponState) {
        this.productCouponState = productCouponState;
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