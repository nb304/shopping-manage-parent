package com.king2.product.server.enmu;


// 商品SKUkey的枚举
public enum K2ProductSkuKeyEnum {

    ZCSY("正常使用", 1),
    DEL("删除", 2),
    SYSTEM_FLAG("系统创建", 1),
    SYSTEM_FLAG_NO("不是系统创建", 2),
    IS_TEMPLATE("是模板", 1),
    IS_TEMPLATE_NO("不是模板", 2);

    private final int value;
    private final String key;

    K2ProductSkuKeyEnum(String key, int value) {
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
