package com.king2.product.server.enmu;

// �������ݿ�Ĵ���ö��
public enum CurrentDayHandleSqlSizeEnum {

    EBRAND("EDIT_BRAND_KEY", 10);//�޸�Ʒ�ƵĴ���

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
