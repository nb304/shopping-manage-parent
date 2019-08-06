package com.king2.commons.pojo;

import java.util.Date;

public class K2SystemFeedback {
    /**
     * 网站通知表主键
     */
    private Integer systemFeedbackId;

    /**
     * 通知编号
     */
    private String feedbackNumber;

    /**
     * 是否是公共的 ---0 是  1 不是  -----0属于全网站的用户都能看见  1 属于个人用户能看见
     */
    private Integer isCommon;

    /**
     * 该通知属于哪个用户  ---为0属于系统发送 全部用户都能查看
     */
    private Integer belongUserId;

    /**
     * 是谁发送的通知
     */
    private String feedbackUsername;

    /**
     * 通知状态 ---1已读 2未读  3 删除
     */
    private Integer feedbackState;

    /**
     * 通知时间
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
     * 通知的内容
     */
    private String feedbackContent;

    /**
     * 网站通知表主键
     * @return system_feedback_id 网站通知表主键
     */
    public Integer getSystemFeedbackId() {
        return systemFeedbackId;
    }

    /**
     * 网站通知表主键
     * @param systemFeedbackId 网站通知表主键
     */
    public void setSystemFeedbackId(Integer systemFeedbackId) {
        this.systemFeedbackId = systemFeedbackId;
    }

    /**
     * 通知编号
     * @return feedback_number 通知编号
     */
    public String getFeedbackNumber() {
        return feedbackNumber;
    }

    /**
     * 通知编号
     * @param feedbackNumber 通知编号
     */
    public void setFeedbackNumber(String feedbackNumber) {
        this.feedbackNumber = feedbackNumber == null ? null : feedbackNumber.trim();
    }

    /**
     * 是否是公共的 ---0 是  1 不是  -----0属于全网站的用户都能看见  1 属于个人用户能看见
     * @return is_common 是否是公共的 ---0 是  1 不是  -----0属于全网站的用户都能看见  1 属于个人用户能看见
     */
    public Integer getIsCommon() {
        return isCommon;
    }

    /**
     * 是否是公共的 ---0 是  1 不是  -----0属于全网站的用户都能看见  1 属于个人用户能看见
     * @param isCommon 是否是公共的 ---0 是  1 不是  -----0属于全网站的用户都能看见  1 属于个人用户能看见
     */
    public void setIsCommon(Integer isCommon) {
        this.isCommon = isCommon;
    }

    /**
     * 该通知属于哪个用户  ---为0属于系统发送 全部用户都能查看
     * @return belong_user_id 该通知属于哪个用户  ---为0属于系统发送 全部用户都能查看
     */
    public Integer getBelongUserId() {
        return belongUserId;
    }

    /**
     * 该通知属于哪个用户  ---为0属于系统发送 全部用户都能查看
     * @param belongUserId 该通知属于哪个用户  ---为0属于系统发送 全部用户都能查看
     */
    public void setBelongUserId(Integer belongUserId) {
        this.belongUserId = belongUserId;
    }

    /**
     * 是谁发送的通知
     * @return feedback_username 是谁发送的通知
     */
    public String getFeedbackUsername() {
        return feedbackUsername;
    }

    /**
     * 是谁发送的通知
     * @param feedbackUsername 是谁发送的通知
     */
    public void setFeedbackUsername(String feedbackUsername) {
        this.feedbackUsername = feedbackUsername == null ? null : feedbackUsername.trim();
    }

    /**
     * 通知状态 ---1已读 2未读  3 删除
     * @return feedback_state 通知状态 ---1已读 2未读  3 删除
     */
    public Integer getFeedbackState() {
        return feedbackState;
    }

    /**
     * 通知状态 ---1已读 2未读  3 删除
     * @param feedbackState 通知状态 ---1已读 2未读  3 删除
     */
    public void setFeedbackState(Integer feedbackState) {
        this.feedbackState = feedbackState;
    }

    /**
     * 通知时间
     * @return create_time 通知时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 通知时间
     * @param createTime 通知时间
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

    /**
     * 通知的内容
     * @return feedback_content 通知的内容
     */
    public String getFeedbackContent() {
        return feedbackContent;
    }

    /**
     * 通知的内容
     * @param feedbackContent 通知的内容
     */
    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent == null ? null : feedbackContent.trim();
    }
}