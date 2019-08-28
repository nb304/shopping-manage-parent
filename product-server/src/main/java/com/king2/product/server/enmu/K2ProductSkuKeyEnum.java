package com.king2.product.server.enmu;


// ��ƷSKUkey��ö��
public enum K2ProductSkuKeyEnum {

    ZCSY("����ʹ��", 1),
    DEL("ɾ��", 2),
    SYSTEM_FLAG("ϵͳ����", 1),
    SYSTEM_FLAG_NO("����ϵͳ����", 2),
    IS_TEMPLATE("��ģ��", 1),
    IS_TEMPLATE_NO("����ģ��", 2);

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
