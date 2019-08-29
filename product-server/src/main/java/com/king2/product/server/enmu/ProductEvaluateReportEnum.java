package com.king2.product.server.enmu;

// 商品举报类型枚举类
public enum ProductEvaluateReportEnum {

    EYSD("恶意刷单", 1),
    EYCP("恶意差评", 2),
    THWX("同行诬陷", 3);

    private final int value;
    private final String key;

    ProductEvaluateReportEnum(String key, int value) {
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
