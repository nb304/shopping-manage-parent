package com.king2.commons.pojo;

import java.util.Date;

public class K2StoreCheck {
    /**
     * 店铺审核主键id
     */
    private Integer storeCheckId;

    /**
     * 店铺审核的编号
     */
    private String storeCheckNumber;

    /**
     * 申请的店铺名称
     */
    private String storeCheckStorename;

    /**
     * 身份证上面的姓名
     */
    private String storeCheckName;

    /**
     * 手机号
     */
    private Integer storeCheckPhone;

    /**
     * 身份证号
     */
    private Integer storeCheckCard;

    /**
     * 申请人的支付宝账户
     */
    private Integer storeCheckZfb;

    /**
     * 是谁申请的 ---指向用户表主键
     */
    private Integer storeCheckUserId;

    /**
     * 用户名  ---冗余字段
     */
    private String storeCheckUsername;

    /**
     * 申请的状态 ---1通过 2未通过
     */
    private Integer storeCheckState;

    /**
     * 处理人的id ---指向用户表主键
     */
    private Integer storeCheckDisposeId;

    /**
     * 处理人的名字 ---冗余字段
     */
    private String storeCheckDisposeName;

    /**
     * 申请时间
     */
    private Date storeCheckCreateTime;

    /**
     * 操作时间
     */
    private Date storeCheckHandleTime;

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
     * 店铺审核主键id
     * @return store_check_id 店铺审核主键id
     */
    public Integer getStoreCheckId() {
        return storeCheckId;
    }

    /**
     * 店铺审核主键id
     * @param storeCheckId 店铺审核主键id
     */
    public void setStoreCheckId(Integer storeCheckId) {
        this.storeCheckId = storeCheckId;
    }

    /**
     * 店铺审核的编号
     * @return store_check_number 店铺审核的编号
     */
    public String getStoreCheckNumber() {
        return storeCheckNumber;
    }

    /**
     * 店铺审核的编号
     * @param storeCheckNumber 店铺审核的编号
     */
    public void setStoreCheckNumber(String storeCheckNumber) {
        this.storeCheckNumber = storeCheckNumber == null ? null : storeCheckNumber.trim();
    }

    /**
     * 申请的店铺名称
     * @return store_check_storeName 申请的店铺名称
     */
    public String getStoreCheckStorename() {
        return storeCheckStorename;
    }

    /**
     * 申请的店铺名称
     * @param storeCheckStorename 申请的店铺名称
     */
    public void setStoreCheckStorename(String storeCheckStorename) {
        this.storeCheckStorename = storeCheckStorename == null ? null : storeCheckStorename.trim();
    }

    /**
     * 身份证上面的姓名
     * @return store_check_name 身份证上面的姓名
     */
    public String getStoreCheckName() {
        return storeCheckName;
    }

    /**
     * 身份证上面的姓名
     * @param storeCheckName 身份证上面的姓名
     */
    public void setStoreCheckName(String storeCheckName) {
        this.storeCheckName = storeCheckName == null ? null : storeCheckName.trim();
    }

    /**
     * 手机号
     * @return store_check_phone 手机号
     */
    public Integer getStoreCheckPhone() {
        return storeCheckPhone;
    }

    /**
     * 手机号
     * @param storeCheckPhone 手机号
     */
    public void setStoreCheckPhone(Integer storeCheckPhone) {
        this.storeCheckPhone = storeCheckPhone;
    }

    /**
     * 身份证号
     * @return store_check_card 身份证号
     */
    public Integer getStoreCheckCard() {
        return storeCheckCard;
    }

    /**
     * 身份证号
     * @param storeCheckCard 身份证号
     */
    public void setStoreCheckCard(Integer storeCheckCard) {
        this.storeCheckCard = storeCheckCard;
    }

    /**
     * 申请人的支付宝账户
     * @return store_check_zfb 申请人的支付宝账户
     */
    public Integer getStoreCheckZfb() {
        return storeCheckZfb;
    }

    /**
     * 申请人的支付宝账户
     * @param storeCheckZfb 申请人的支付宝账户
     */
    public void setStoreCheckZfb(Integer storeCheckZfb) {
        this.storeCheckZfb = storeCheckZfb;
    }

    /**
     * 是谁申请的 ---指向用户表主键
     * @return store_check_user_id 是谁申请的 ---指向用户表主键
     */
    public Integer getStoreCheckUserId() {
        return storeCheckUserId;
    }

    /**
     * 是谁申请的 ---指向用户表主键
     * @param storeCheckUserId 是谁申请的 ---指向用户表主键
     */
    public void setStoreCheckUserId(Integer storeCheckUserId) {
        this.storeCheckUserId = storeCheckUserId;
    }

    /**
     * 用户名  ---冗余字段
     * @return store_check_username 用户名  ---冗余字段
     */
    public String getStoreCheckUsername() {
        return storeCheckUsername;
    }

    /**
     * 用户名  ---冗余字段
     * @param storeCheckUsername 用户名  ---冗余字段
     */
    public void setStoreCheckUsername(String storeCheckUsername) {
        this.storeCheckUsername = storeCheckUsername == null ? null : storeCheckUsername.trim();
    }

    /**
     * 申请的状态 ---1通过 2未通过
     * @return store_check_state 申请的状态 ---1通过 2未通过
     */
    public Integer getStoreCheckState() {
        return storeCheckState;
    }

    /**
     * 申请的状态 ---1通过 2未通过
     * @param storeCheckState 申请的状态 ---1通过 2未通过
     */
    public void setStoreCheckState(Integer storeCheckState) {
        this.storeCheckState = storeCheckState;
    }

    /**
     * 处理人的id ---指向用户表主键
     * @return store_check_dispose_id 处理人的id ---指向用户表主键
     */
    public Integer getStoreCheckDisposeId() {
        return storeCheckDisposeId;
    }

    /**
     * 处理人的id ---指向用户表主键
     * @param storeCheckDisposeId 处理人的id ---指向用户表主键
     */
    public void setStoreCheckDisposeId(Integer storeCheckDisposeId) {
        this.storeCheckDisposeId = storeCheckDisposeId;
    }

    /**
     * 处理人的名字 ---冗余字段
     * @return store_check_dispose_name 处理人的名字 ---冗余字段
     */
    public String getStoreCheckDisposeName() {
        return storeCheckDisposeName;
    }

    /**
     * 处理人的名字 ---冗余字段
     * @param storeCheckDisposeName 处理人的名字 ---冗余字段
     */
    public void setStoreCheckDisposeName(String storeCheckDisposeName) {
        this.storeCheckDisposeName = storeCheckDisposeName == null ? null : storeCheckDisposeName.trim();
    }

    /**
     * 申请时间
     * @return store_check_create_time 申请时间
     */
    public Date getStoreCheckCreateTime() {
        return storeCheckCreateTime;
    }

    /**
     * 申请时间
     * @param storeCheckCreateTime 申请时间
     */
    public void setStoreCheckCreateTime(Date storeCheckCreateTime) {
        this.storeCheckCreateTime = storeCheckCreateTime;
    }

    /**
     * 操作时间
     * @return store_check_handle_time 操作时间
     */
    public Date getStoreCheckHandleTime() {
        return storeCheckHandleTime;
    }

    /**
     * 操作时间
     * @param storeCheckHandleTime 操作时间
     */
    public void setStoreCheckHandleTime(Date storeCheckHandleTime) {
        this.storeCheckHandleTime = storeCheckHandleTime;
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