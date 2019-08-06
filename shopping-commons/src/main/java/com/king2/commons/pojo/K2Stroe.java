package com.king2.commons.pojo;

import java.util.Date;

public class K2Stroe {
    /**
     * 店铺表的主键id
     */
    private Integer stroeId;

    /**
     * 店铺的名称
     */
    private String stroeName;

    /**
     * 店铺的头像
     */
    private String storeImage;

    /**
     * 店铺的LOGO图像
     */
    private String storeLogoImage;

    /**
     * 该店铺属于哪个用户  ---指向用户表主键
     */
    private Integer belongUserId;

    /**
     * 该店铺的支付宝账户
     */
    private Integer storeProceedsZfb;

    /**
     * 店铺的描述
     */
    private String storeDescribe;

    /**
     * 店长的手机号码
     */
    private Integer storePhone;

    /**
     * 店铺的状态  ---1开业中 2关闭
     */
    private Integer storeState;

    /**
     * 用户的等级分类  ---指向店铺分类表主键
     */
    private Integer storeLeven;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 倒闭时间
     */
    private Date gointoTime;

    /**
     * 店铺的押金
     */
    private Integer storeCash;

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
     * 店铺表的主键id
     * @return stroe_id 店铺表的主键id
     */
    public Integer getStroeId() {
        return stroeId;
    }

    /**
     * 店铺表的主键id
     * @param stroeId 店铺表的主键id
     */
    public void setStroeId(Integer stroeId) {
        this.stroeId = stroeId;
    }

    /**
     * 店铺的名称
     * @return stroe_name 店铺的名称
     */
    public String getStroeName() {
        return stroeName;
    }

    /**
     * 店铺的名称
     * @param stroeName 店铺的名称
     */
    public void setStroeName(String stroeName) {
        this.stroeName = stroeName == null ? null : stroeName.trim();
    }

    /**
     * 店铺的头像
     * @return store_image 店铺的头像
     */
    public String getStoreImage() {
        return storeImage;
    }

    /**
     * 店铺的头像
     * @param storeImage 店铺的头像
     */
    public void setStoreImage(String storeImage) {
        this.storeImage = storeImage == null ? null : storeImage.trim();
    }

    /**
     * 店铺的LOGO图像
     * @return store_logo_image 店铺的LOGO图像
     */
    public String getStoreLogoImage() {
        return storeLogoImage;
    }

    /**
     * 店铺的LOGO图像
     * @param storeLogoImage 店铺的LOGO图像
     */
    public void setStoreLogoImage(String storeLogoImage) {
        this.storeLogoImage = storeLogoImage == null ? null : storeLogoImage.trim();
    }

    /**
     * 该店铺属于哪个用户  ---指向用户表主键
     * @return belong_user_id 该店铺属于哪个用户  ---指向用户表主键
     */
    public Integer getBelongUserId() {
        return belongUserId;
    }

    /**
     * 该店铺属于哪个用户  ---指向用户表主键
     * @param belongUserId 该店铺属于哪个用户  ---指向用户表主键
     */
    public void setBelongUserId(Integer belongUserId) {
        this.belongUserId = belongUserId;
    }

    /**
     * 该店铺的支付宝账户
     * @return store_proceeds_zfb 该店铺的支付宝账户
     */
    public Integer getStoreProceedsZfb() {
        return storeProceedsZfb;
    }

    /**
     * 该店铺的支付宝账户
     * @param storeProceedsZfb 该店铺的支付宝账户
     */
    public void setStoreProceedsZfb(Integer storeProceedsZfb) {
        this.storeProceedsZfb = storeProceedsZfb;
    }

    /**
     * 店铺的描述
     * @return store_describe 店铺的描述
     */
    public String getStoreDescribe() {
        return storeDescribe;
    }

    /**
     * 店铺的描述
     * @param storeDescribe 店铺的描述
     */
    public void setStoreDescribe(String storeDescribe) {
        this.storeDescribe = storeDescribe == null ? null : storeDescribe.trim();
    }

    /**
     * 店长的手机号码
     * @return store_phone 店长的手机号码
     */
    public Integer getStorePhone() {
        return storePhone;
    }

    /**
     * 店长的手机号码
     * @param storePhone 店长的手机号码
     */
    public void setStorePhone(Integer storePhone) {
        this.storePhone = storePhone;
    }

    /**
     * 店铺的状态  ---1开业中 2关闭
     * @return store_state 店铺的状态  ---1开业中 2关闭
     */
    public Integer getStoreState() {
        return storeState;
    }

    /**
     * 店铺的状态  ---1开业中 2关闭
     * @param storeState 店铺的状态  ---1开业中 2关闭
     */
    public void setStoreState(Integer storeState) {
        this.storeState = storeState;
    }

    /**
     * 用户的等级分类  ---指向店铺分类表主键
     * @return store_leven 用户的等级分类  ---指向店铺分类表主键
     */
    public Integer getStoreLeven() {
        return storeLeven;
    }

    /**
     * 用户的等级分类  ---指向店铺分类表主键
     * @param storeLeven 用户的等级分类  ---指向店铺分类表主键
     */
    public void setStoreLeven(Integer storeLeven) {
        this.storeLeven = storeLeven;
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
     * 倒闭时间
     * @return gointo_time 倒闭时间
     */
    public Date getGointoTime() {
        return gointoTime;
    }

    /**
     * 倒闭时间
     * @param gointoTime 倒闭时间
     */
    public void setGointoTime(Date gointoTime) {
        this.gointoTime = gointoTime;
    }

    /**
     * 店铺的押金
     * @return store_cash 店铺的押金
     */
    public Integer getStoreCash() {
        return storeCash;
    }

    /**
     * 店铺的押金
     * @param storeCash 店铺的押金
     */
    public void setStoreCash(Integer storeCash) {
        this.storeCash = storeCash;
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