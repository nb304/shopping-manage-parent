package com.king2.commons.pojo;

import java.util.Date;

public class K2FeedbackAccessory {
    /**
     * 反馈附件表主键
     */
    private Integer feedbackAccessoryId;

    /**
     * 附件名称
     */
    private String accessoryName;

    /**
     * 该附件属于哪个反馈单号
     */
    private Integer belongUserBackId;

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
     * 反馈附件的URL多个附件,隔开
     */
    private String accessoryUrl;

    /**
     * 反馈附件表主键
     * @return feedback_accessory_id 反馈附件表主键
     */
    public Integer getFeedbackAccessoryId() {
        return feedbackAccessoryId;
    }

    /**
     * 反馈附件表主键
     * @param feedbackAccessoryId 反馈附件表主键
     */
    public void setFeedbackAccessoryId(Integer feedbackAccessoryId) {
        this.feedbackAccessoryId = feedbackAccessoryId;
    }

    /**
     * 附件名称
     * @return accessory_name 附件名称
     */
    public String getAccessoryName() {
        return accessoryName;
    }

    /**
     * 附件名称
     * @param accessoryName 附件名称
     */
    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName == null ? null : accessoryName.trim();
    }

    /**
     * 该附件属于哪个反馈单号
     * @return belong_user_back_id 该附件属于哪个反馈单号
     */
    public Integer getBelongUserBackId() {
        return belongUserBackId;
    }

    /**
     * 该附件属于哪个反馈单号
     * @param belongUserBackId 该附件属于哪个反馈单号
     */
    public void setBelongUserBackId(Integer belongUserBackId) {
        this.belongUserBackId = belongUserBackId;
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

    /**
     * 反馈附件的URL多个附件,隔开
     * @return accessory_url 反馈附件的URL多个附件,隔开
     */
    public String getAccessoryUrl() {
        return accessoryUrl;
    }

    /**
     * 反馈附件的URL多个附件,隔开
     * @param accessoryUrl 反馈附件的URL多个附件,隔开
     */
    public void setAccessoryUrl(String accessoryUrl) {
        this.accessoryUrl = accessoryUrl == null ? null : accessoryUrl.trim();
    }
}