package com.king2.product.server.enmu;

/*
������ס��״̬ö����
 */
public enum StoreEnterStateEnum {

    TG("��ͨ��", 1),
    WTG("δͨ��", 2),
    WCL("δ����", 3);

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
