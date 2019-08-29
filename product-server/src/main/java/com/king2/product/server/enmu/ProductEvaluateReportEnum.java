package com.king2.product.server.enmu;

// ��Ʒ�ٱ�����ö����
public enum ProductEvaluateReportEnum {

    EYSD("����ˢ��", 1),
    EYCP("�������", 2),
    THWX("ͬ������", 3);

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
