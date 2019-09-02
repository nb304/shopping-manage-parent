package com.king2.product.server.enmu;

/*
店铺入住的状态枚举类
 */
public enum StoreEnterStateEnum {

    TG("已通过", 1),
    WTG("未通过", 2),
    WCL("未处理", 3);

    private final int value;
    private final String key;

    StoreEnterStateEnum(String key, int value) {
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
