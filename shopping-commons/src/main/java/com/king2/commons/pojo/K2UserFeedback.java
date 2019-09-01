package com.king2.commons.pojo;

import java.util.Date;

public class K2UserFeedback {
    /**
     * 用户反馈表主键
     */
    private Integer userFeedbackId;

    /**
     * 用户反馈单号
     */
    private String userFeedbackNumber;

    /**
     * 反馈的用户id  ---指向用户主键
     */
    private Integer userId;

    /**
     * 反馈的用户名称 ---冗余字段
     */
    private String userName;

    /**
     * 反馈的时间
     */
    private Date createTime;

    /**
     * 联系方式 ---空等于无法联系
     */
    private String userConnection;

    /**
     * 反馈单号的状态  ---1处理中  2已处理 3删除
     */
    private Integer userFeedbackState;

    /**
     * 处理人的用户id  ---指向用户主键表
     */
    private Integer userFeedbackResult;

    /**
     * 保留字段1  处理人的名称
     */
    private String retain1;

    /**
     * 保留字段2
     */
    private String retain2;

    private String image;

    private String uName;

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

    private String stateStr;

    private String createTimeStr;


    private String replayContent;
    private Date replayTime;

    public String getReplayContent() {
        return replayContent;
    }

    public void setReplayContent(String replayContent) {
        this.replayContent = replayContent;
    }

    public Date getReplayTime() {
        return replayTime;
    }

    public void setReplayTime(Date replayTime) {
        this.replayTime = replayTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    /**
     * 问题描述
     */
    private String feedbackContent;

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }


    /**
     * 用户反馈表主键
     *
     * @return user_feedback_id 用户反馈表主键
     */
    public Integer getUserFeedbackId() {
        return userFeedbackId;
    }

    /**
     * 用户反馈表主键
     *
     * @param userFeedbackId 用户反馈表主键
     */
    public void setUserFeedbackId(Integer userFeedbackId) {
        this.userFeedbackId = userFeedbackId;
    }

    /**
     * 用户反馈单号
     *
     * @return user_feedback_number 用户反馈单号
     */
    public String getUserFeedbackNumber() {
        return userFeedbackNumber;
    }

    /**
     * 用户反馈单号
     *
     * @param userFeedbackNumber 用户反馈单号
     */
    public void setUserFeedbackNumber(String userFeedbackNumber) {
        this.userFeedbackNumber = userFeedbackNumber == null ? null : userFeedbackNumber.trim();
    }

    /**
     * 反馈的用户id  ---指向用户主键
     *
     * @return user_id 反馈的用户id  ---指向用户主键
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 反馈的用户id  ---指向用户主键
     *
     * @param userId 反馈的用户id  ---指向用户主键
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 反馈的用户名称 ---冗余字段
     *
     * @return user_name 反馈的用户名称 ---冗余字段
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 反馈的用户名称 ---冗余字段
     *
     * @param userName 反馈的用户名称 ---冗余字段
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 反馈的时间
     *
     * @return create_time 反馈的时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 反馈的时间
     *
     * @param createTime 反馈的时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 联系方式 ---空等于无法联系
     *
     * @return user_connection 联系方式 ---空等于无法联系
     */
    public String getUserConnection() {
        return userConnection;
    }

    /**
     * 联系方式 ---空等于无法联系
     *
     * @param userConnection 联系方式 ---空等于无法联系
     */
    public void setUserConnection(String userConnection) {
        this.userConnection = userConnection == null ? null : userConnection.trim();
    }

    /**
     * 反馈单号的状态  ---1处理中 2未处理 3已处理 4删除
     *
     * @return user_feedback_state 反馈单号的状态  ---1处理中 2未处理 3已处理 4删除
     */
    public Integer getUserFeedbackState() {
        return userFeedbackState;
    }

    /**
     * 反馈单号的状态  ---1处理中 2未处理 3已处理 4删除
     *
     * @param userFeedbackState 反馈单号的状态  ---1处理中 2未处理 3已处理 4删除
     */
    public void setUserFeedbackState(Integer userFeedbackState) {
        this.userFeedbackState = userFeedbackState;
    }

    /**
     * 处理人的用户id  ---指向用户主键表
     *
     * @return user_feedback_result 处理人的用户id  ---指向用户主键表
     */
    public Integer getUserFeedbackResult() {
        return userFeedbackResult;
    }

    /**
     * 处理人的用户id  ---指向用户主键表
     *
     * @param userFeedbackResult 处理人的用户id  ---指向用户主键表
     */
    public void setUserFeedbackResult(Integer userFeedbackResult) {
        this.userFeedbackResult = userFeedbackResult;
    }

    /**
     * 保留字段1
     *
     * @return retain1 保留字段1
     */
    public String getRetain1() {
        return retain1;
    }

    /**
     * 保留字段1
     *
     * @param retain1 保留字段1
     */
    public void setRetain1(String retain1) {
        this.retain1 = retain1 == null ? null : retain1.trim();
    }

    /**
     * 保留字段2
     *
     * @return retain2 保留字段2
     */
    public String getRetain2() {
        return retain2;
    }

    /**
     * 保留字段2
     *
     * @param retain2 保留字段2
     */
    public void setRetain2(String retain2) {
        this.retain2 = retain2 == null ? null : retain2.trim();
    }

    /**
     * 保留字段3
     *
     * @return retain3 保留字段3
     */
    public String getRetain3() {
        return retain3;
    }

    /**
     * 保留字段3
     *
     * @param retain3 保留字段3
     */
    public void setRetain3(String retain3) {
        this.retain3 = retain3 == null ? null : retain3.trim();
    }

    /**
     * 保留字段4
     *
     * @return retain4 保留字段4
     */
    public String getRetain4() {
        return retain4;
    }

    /**
     * 保留字段4
     *
     * @param retain4 保留字段4
     */
    public void setRetain4(String retain4) {
        this.retain4 = retain4 == null ? null : retain4.trim();
    }

    /**
     * 保留字段5
     *
     * @return retain5 保留字段5
     */
    public String getRetain5() {
        return retain5;
    }

    /**
     * 保留字段5
     *
     * @param retain5 保留字段5
     */
    public void setRetain5(String retain5) {
        this.retain5 = retain5 == null ? null : retain5.trim();
    }

    /**
     * 问题描述
     *
     * @return feedback_content 问题描述
     */
    public String getFeedbackContent() {
        return feedbackContent;
    }

    /**
     * 问题描述
     *
     * @param feedbackContent 问题描述
     */
    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent == null ? null : feedbackContent.trim();
    }
}
