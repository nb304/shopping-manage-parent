package com.king2.commons.pojo;

import java.util.Date;

public class K2CouponUser {
    /**
     * 用户拥有优惠卷的主键
     */
    private Integer couponUserId;

    /**
     * 商品对应的优惠卷主键  ---指向商品对应的优惠卷表主键
     */
    private Integer couponParallelismProductId;

    /**
     * 用户的主键  ---指向用户表的主键
     */
    private Integer userId;

    /**
     * 用户名 ---冗余字段
     */
    private String userName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 优惠卷状态  ---1、正常2、已使用3、已过期
     */
    private Integer state;

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
     * 用户拥有优惠卷的主键
     * @return coupon_user_id 用户拥有优惠卷的主键
     */
    public Integer getCouponUserId() {
        return couponUserId;
    }

    /**
     * 用户拥有优惠卷的主键
     * @param couponUserId 用户拥有优惠卷的主键
     */
    public void setCouponUserId(Integer couponUserId) {
        this.couponUserId = couponUserId;
    }

    /**
     * 商品对应的优惠卷主键  ---指向商品对应的优惠卷表主键
     * @return coupon_parallelism_product_id 商品对应的优惠卷主键  ---指向商品对应的优惠卷表主键
     */
    public Integer getCouponParallelismProductId() {
        return couponParallelismProductId;
    }

    /**
     * 商品对应的优惠卷主键  ---指向商品对应的优惠卷表主键
     * @param couponParallelismProductId 商品对应的优惠卷主键  ---指向商品对应的优惠卷表主键
     */
    public void setCouponParallelismProductId(Integer couponParallelismProductId) {
        this.couponParallelismProductId = couponParallelismProductId;
    }

    /**
     * 用户的主键  ---指向用户表的主键
     * @return user_id 用户的主键  ---指向用户表的主键
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户的主键  ---指向用户表的主键
     * @param userId 用户的主键  ---指向用户表的主键
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 用户名 ---冗余字段
     * @return user_name 用户名 ---冗余字段
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名 ---冗余字段
     * @param userName 用户名 ---冗余字段
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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
     * 优惠卷状态  ---1、正常2、已使用3、已过期
     * @return state 优惠卷状态  ---1、正常2、已使用3、已过期
     */
    public Integer getState() {
        return state;
    }

    /**
     * 优惠卷状态  ---1、正常2、已使用3、已过期
     * @param state 优惠卷状态  ---1、正常2、已使用3、已过期
     */
    public void setState(Integer state) {
        this.state = state;
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