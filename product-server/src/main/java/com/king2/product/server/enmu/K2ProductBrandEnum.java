package com.king2.product.server.enmu;

// ��ƷƷ������ö��
public enum K2ProductBrandEnum {

    ZC("����", 1),//��Ϣδ��
    DEL("ɾ��", 2);// ��Ϣɾ��

    private final int value;
    private final String key;

    K2ProductBrandEnum(String key, int value) {
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