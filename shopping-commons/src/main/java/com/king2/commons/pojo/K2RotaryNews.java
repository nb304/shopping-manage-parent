package com.king2.commons.pojo;

import java.util.Date;

public class K2RotaryNews {
    /**
     * 网站轮播管理主键
     */
    private Integer rotaryId;

    /**
     * 轮播的编号
     */
    private String rotaryNumber;

    /**
     * 新闻名称
     */
    private String rotaryName;

    /**
     * 上架时间
     */
    private Date rotaryStartTime;

    /**
     * 下架时间
     */
    private Date rotaryEndTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是谁创建了这条新闻信息  ---指向用户表主键
     */
    private Integer createUserId;

    /**
     * 新闻状态  1正常  2 下架  3删除
     */
    private Integer rotaryState;

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
     * 新闻描述
     */
    private String rotaryDescribe;

    /**
     * 网站轮播管理主键
     * @return rotary_id 网站轮播管理主键
     */
    public Integer getRotaryId() {
        return rotaryId;
    }

    /**
     * 网站轮播管理主键
     * @param rotaryId 网站轮播管理主键
     */
    public void setRotaryId(Integer rotaryId) {
        this.rotaryId = rotaryId;
    }

    /**
     * 轮播的编号
     * @return rotary_number 轮播的编号
     */
    public String getRotaryNumber() {
        return rotaryNumber;
    }

    /**
     * 轮播的编号
     * @param rotaryNumber 轮播的编号
     */
    public void setRotaryNumber(String rotaryNumber) {
        this.rotaryNumber = rotaryNumber == null ? null : rotaryNumber.trim();
    }

    /**
     * 新闻名称
     * @return rotary_name 新闻名称
     */
    public String getRotaryName() {
        return rotaryName;
    }

    /**
     * 新闻名称
     * @param rotaryName 新闻名称
     */
    public void setRotaryName(String rotaryName) {
        this.rotaryName = rotaryName == null ? null : rotaryName.trim();
    }

    /**
     * 上架时间
     * @return rotary_start_time 上架时间
     */
    public Date getRotaryStartTime() {
        return rotaryStartTime;
    }

    /**
     * 上架时间
     * @param rotaryStartTime 上架时间
     */
    public void setRotaryStartTime(Date rotaryStartTime) {
        this.rotaryStartTime = rotaryStartTime;
    }

    /**
     * 下架时间
     * @return rotary_end_time 下架时间
     */
    public Date getRotaryEndTime() {
        return rotaryEndTime;
    }

    /**
     * 下架时间
     * @param rotaryEndTime 下架时间
     */
    public void setRotaryEndTime(Date rotaryEndTime) {
        this.rotaryEndTime = rotaryEndTime;
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
     * 是谁创建了这条新闻信息  ---指向用户表主键
     * @return create_user_id 是谁创建了这条新闻信息  ---指向用户表主键
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 是谁创建了这条新闻信息  ---指向用户表主键
     * @param createUserId 是谁创建了这条新闻信息  ---指向用户表主键
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 新闻状态  1正常  2 下架  3删除
     * @return rotary_state 新闻状态  1正常  2 下架  3删除
     */
    public Integer getRotaryState() {
        return rotaryState;
    }

    /**
     * 新闻状态  1正常  2 下架  3删除
     * @param rotaryState 新闻状态  1正常  2 下架  3删除
     */
    public void setRotaryState(Integer rotaryState) {
        this.rotaryState = rotaryState;
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
     * 新闻描述
     * @return rotary_describe 新闻描述
     */
    public String getRotaryDescribe() {
        return rotaryDescribe;
    }

    /**
     * 新闻描述
     * @param rotaryDescribe 新闻描述
     */
    public void setRotaryDescribe(String rotaryDescribe) {
        this.rotaryDescribe = rotaryDescribe == null ? null : rotaryDescribe.trim();
    }
}