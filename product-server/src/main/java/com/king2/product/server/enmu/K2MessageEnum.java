package com.king2.product.server.enmu;

public enum K2MessageEnum {

    WD("未读", 1),//消息未读
    YD("已读", 2),//消息已读
    DEL("删除", 3);// 消息删除

    private final int value;
    private final String key;

    K2MessageEnum(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
