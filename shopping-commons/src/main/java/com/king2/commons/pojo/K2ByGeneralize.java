package com.king2.commons.pojo;

import java.util.Date;

public class K2ByGeneralize {
    /**
     * 被推广人的主键
     */
    private Integer byGeneralizeId;

    /**
     * 推广人的id ---指向用户表的主键
     */
    private Integer generalizeId;

    /**
     * 被推广人的id ---指向用户表主键
     */
    private Integer byGeneralizeUserId;

    /**
     * 被推广的用户名 ---冗余字段
     */
    private String byGeneralizeUserName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 推广的奖励
     */
    private Integer generalizeAward;

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
     * 被推广人的主键
     * @return by_generalize_id 被推广人的主键
     */
    public Integer getByGeneralizeId() {
        return byGeneralizeId;
    }

    /**
     * 被推广人的主键
     * @param byGeneralizeId 被推广人的主键
     */
    public void setByGeneralizeId(Integer byGeneralizeId) {
        this.byGeneralizeId = byGeneralizeId;
    }

    /**
     * 推广人的id ---指向用户表的主键
     * @return generalize_id 推广人的id ---指向用户表的主键
     */
    public Integer getGeneralizeId() {
        return generalizeId;
    }

    /**
     * 推广人的id ---指向用户表的主键
     * @param generalizeId 推广人的id ---指向用户表的主键
     */
    public void setGeneralizeId(Integer generalizeId) {
        this.generalizeId = generalizeId;
    }

    /**
     * 被推广人的id ---指向用户表主键
     * @return by_generalize_user_id 被推广人的id ---指向用户表主键
     */
    public Integer getByGeneralizeUserId() {
        return byGeneralizeUserId;
    }

    /**
     * 被推广人的id ---指向用户表主键
     * @param byGeneralizeUserId 被推广人的id ---指向用户表主键
     */
    public void setByGeneralizeUserId(Integer byGeneralizeUserId) {
        this.byGeneralizeUserId = byGeneralizeUserId;
    }

    /**
     * 被推广的用户名 ---冗余字段
     * @return by_generalize_user_name 被推广的用户名 ---冗余字段
     */
    public String getByGeneralizeUserName() {
        return byGeneralizeUserName;
    }

    /**
     * 被推广的用户名 ---冗余字段
     * @param byGeneralizeUserName 被推广的用户名 ---冗余字段
     */
    public void setByGeneralizeUserName(String byGeneralizeUserName) {
        this.byGeneralizeUserName = byGeneralizeUserName == null ? null : byGeneralizeUserName.trim();
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
     * 推广的奖励
     * @return generalize_award 推广的奖励
     */
    public Integer getGeneralizeAward() {
        return generalizeAward;
    }

    /**
     * 推广的奖励
     * @param generalizeAward 推广的奖励
     */
    public void setGeneralizeAward(Integer generalizeAward) {
        this.generalizeAward = generalizeAward;
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