package com.king2.product.server.enmu;

// 反馈的状态枚举
public enum UserFeedbackEnum {

    CLZ("处理中", 1),
    YCL("已处理", 2),
    DEL("删除", 3);
    private final int value;
    private final String key;

    UserFeedbackEnum(String key, int value) {
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
