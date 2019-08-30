package com.king2.commons.pojo;

import java.util.Date;

public class K2Message {
    /**
     * 信息表主键
     */
    private Integer messageId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 该信息属于哪个用户 ---指向用户表主键
     */
    private Integer userId;

    /**
     * 信息状态 1、未读 2、已读 3、删除
     */
    private Integer state;

    /**
     * 保留字段1   是否需要插入数据库的信息  1是 2否
     */
    private String retain1;

    /**
     * 保留字段2    id的key
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
     * 信息表内容
     */
    private String messageContent;

    private String subStringContent;

    private String createTimeStr;

    public String getCreateTimeStr() {
        return createTimeStr;
    }


    public String getSubStringContent() {
        return subStringContent;
    }

    public void setSubStringContent(String subStringContent) {
        this.subStringContent = subStringContent;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    /**
     * 信息表主键
     *
     * @return message_id 信息表主键
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * 信息表主键
     *
     * @param messageId 信息表主键
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * 创建时间
     *
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 该信息属于哪个用户 ---指向用户表主键
     *
     * @return user_id 该信息属于哪个用户 ---指向用户表主键
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 该信息属于哪个用户 ---指向用户表主键
     *
     * @param userId 该信息属于哪个用户 ---指向用户表主键
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 信息状态 1、未读 2、已读 3、删除
     *
     * @return state 信息状态 1、未读 2、已读 3、删除
     */
    public Integer getState() {
        return state;
    }

    /**
     * 信息状态 1、未读 2、已读 3、删除
     *
     * @param state 信息状态 1、未读 2、已读 3、删除
     */
    public void setState(Integer state) {
        this.state = state;
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
     * 信息表内容
     *
     * @return message_content 信息表内容
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * 信息表内容
     *
     * @param messageContent 信息表内容
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }
}
