package com.king2.commons.pojo;

import java.util.Date;

public class K2ChatInfo {
    /**
     * 聊天记录的主键
     */
    private Integer chatInfoId;

    /**
     * 聊天记录人1 ---对应着用户表的主键
     */
    private Integer chatInfoUserId1;

    /**
     * 聊天记录人2 ---对应着用户表的主键
     */
    private Integer chatInfoUserId2;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 该聊天记录对应记录人1的状态  ---1、正常  2、删除
     */
    private Integer user1State;

    /**
     * 该聊天记录对应记录人2的状态  ---1、正常  2、删除
     */
    private Integer user2State;

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
     * 聊天内容 ---JSON格式 对应着POJO里面的一个类属性
     */
    private String chatInfoContent;

    /**
     * 聊天记录的主键
     * @return chat_info_id 聊天记录的主键
     */
    public Integer getChatInfoId() {
        return chatInfoId;
    }

    /**
     * 聊天记录的主键
     * @param chatInfoId 聊天记录的主键
     */
    public void setChatInfoId(Integer chatInfoId) {
        this.chatInfoId = chatInfoId;
    }

    /**
     * 聊天记录人1 ---对应着用户表的主键
     * @return chat_info_user_id1 聊天记录人1 ---对应着用户表的主键
     */
    public Integer getChatInfoUserId1() {
        return chatInfoUserId1;
    }

    /**
     * 聊天记录人1 ---对应着用户表的主键
     * @param chatInfoUserId1 聊天记录人1 ---对应着用户表的主键
     */
    public void setChatInfoUserId1(Integer chatInfoUserId1) {
        this.chatInfoUserId1 = chatInfoUserId1;
    }

    /**
     * 聊天记录人2 ---对应着用户表的主键
     * @return chat_info_user_id2 聊天记录人2 ---对应着用户表的主键
     */
    public Integer getChatInfoUserId2() {
        return chatInfoUserId2;
    }

    /**
     * 聊天记录人2 ---对应着用户表的主键
     * @param chatInfoUserId2 聊天记录人2 ---对应着用户表的主键
     */
    public void setChatInfoUserId2(Integer chatInfoUserId2) {
        this.chatInfoUserId2 = chatInfoUserId2;
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
     * 该聊天记录对应记录人1的状态  ---1、正常  2、删除
     * @return user1_state 该聊天记录对应记录人1的状态  ---1、正常  2、删除
     */
    public Integer getUser1State() {
        return user1State;
    }

    /**
     * 该聊天记录对应记录人1的状态  ---1、正常  2、删除
     * @param user1State 该聊天记录对应记录人1的状态  ---1、正常  2、删除
     */
    public void setUser1State(Integer user1State) {
        this.user1State = user1State;
    }

    /**
     * 该聊天记录对应记录人2的状态  ---1、正常  2、删除
     * @return user2_state 该聊天记录对应记录人2的状态  ---1、正常  2、删除
     */
    public Integer getUser2State() {
        return user2State;
    }

    /**
     * 该聊天记录对应记录人2的状态  ---1、正常  2、删除
     * @param user2State 该聊天记录对应记录人2的状态  ---1、正常  2、删除
     */
    public void setUser2State(Integer user2State) {
        this.user2State = user2State;
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
     * 聊天内容 ---JSON格式 对应着POJO里面的一个类属性
     * @return chat_info_content 聊天内容 ---JSON格式 对应着POJO里面的一个类属性
     */
    public String getChatInfoContent() {
        return chatInfoContent;
    }

    /**
     * 聊天内容 ---JSON格式 对应着POJO里面的一个类属性
     * @param chatInfoContent 聊天内容 ---JSON格式 对应着POJO里面的一个类属性
     */
    public void setChatInfoContent(String chatInfoContent) {
        this.chatInfoContent = chatInfoContent == null ? null : chatInfoContent.trim();
    }
}