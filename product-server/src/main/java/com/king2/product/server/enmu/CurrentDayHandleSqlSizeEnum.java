package com.king2.product.server.enmu;

// 操作数据库的次数枚举
public enum CurrentDayHandleSqlSizeEnum {

    EBRAND("EDIT_BRAND_KEY", 10);//修改品牌的次数

    private final int value;
    private final String key;

    CurrentDayHandleSqlSizeEnum(String key, int value) {
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
