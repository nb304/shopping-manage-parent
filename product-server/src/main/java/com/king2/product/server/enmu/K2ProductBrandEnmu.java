package com.king2.product.server.enmu;

// 商品品牌类型枚举
public enum K2ProductBrandEnmu {

    ZC("正常", 1),//消息未读
    DEL("删除", 2);// 消息删除

    private final int value;
    private final String key;

    K2ProductBrandEnmu(String key, int value) {
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
