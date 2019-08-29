package com.king2.product.server.enmu;

// 商品评价枚举类
public enum K2ProductEvaluateEnum {

    HP("好评", 1),
    ZP("中评", 2),
    CP("差评", 3),
    DEL("删除", 4),
    IS_READ_TRUE("已读", 1),
    IS_READ_FALSE("未读", 2);

    private final int value;
    private final String key;

    K2ProductEvaluateEnum(String key, int value) {
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
