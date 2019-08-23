package com.king2.product.server.enmu;

// 商品SPU枚举
public enum ProductSpuEnum {

    SYZ("使用中", 1),//使用中
    DEL("删除", 2),//删除
    ZX("注销", 3);// 注销

    private final int value;
    private final String key;

    ProductSpuEnum(String key, int value) {
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
