package com.king2.product.server.pojo;

import java.util.Date;

// 用户聊天的POJO类
public class UserCharInfoPojo {


    // 本次消息的Id
    private Integer charId;
    // 发送者
    private Integer sendUserId;
    // 接收者
    private Integer receiveUserId;
    // 本次的聊天记录
    private String chaoInfoMessage;
    // 发送的时间
    private Date createTime;
    // 本条消息的状态
    private Integer state;
    // 发送者的名称
    private String name;
    // 发送者的头像
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCharId() {
        return charId;
    }

    public void setCharId(Integer charId) {
        this.charId = charId;
    }

    public Integer getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Integer sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public String getChaoInfoMessage() {
        return chaoInfoMessage;
    }

    public void setChaoInfoMessage(String chaoInfoMessage) {
        this.chaoInfoMessage = chaoInfoMessage;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
