package com.king2.product.server.enmu;

// 商品类目的枚举
public enum K2ProductCategoryEnum {

    YES("是父类", 1),
    NO("不是", 2),
    ZC("正常使用", 1),
    TY("停用", 2);

    private final int value;
    private final String key;

    K2ProductCategoryEnum(String key, int value) {
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
