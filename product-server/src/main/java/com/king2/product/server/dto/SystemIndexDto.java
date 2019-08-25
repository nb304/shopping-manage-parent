package com.king2.product.server.dto;

import com.king2.commons.pojo.K2Message;

import java.util.List;

// 系统首页需要的dto
public class SystemIndexDto {

    private List<K2Message> yDMessage; // 已读消息
    private List<K2Message> wDMessage; // 未读消息

    public List<K2Message> getyDMessage() {
        return yDMessage;
    }

    public void setyDMessage(List<K2Message> yDMessage) {
        this.yDMessage = yDMessage;
    }

    public List<K2Message> getwDMessage() {
        return wDMessage;
    }

    public void setwDMessage(List<K2Message> wDMessage) {
        this.wDMessage = wDMessage;
    }
}
