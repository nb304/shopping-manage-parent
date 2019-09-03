package com.king2.product.server.enmu;

// 用户聊天记录的枚举类
public enum UserChatInfoStateEnum {

    ZC("正常", 1),//正常
    DEL("删除", 2);//删除

    private final int value;
    private final String key;

    UserChatInfoStateEnum(String key, int value) {
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
