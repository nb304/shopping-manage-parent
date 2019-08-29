package com.king2.product.server.enmu;

// ������״̬ö��
public enum UserFeedbackEnum {

    CLZ("������", 1),
    YCL("�Ѵ���", 2),
    DEL("ɾ��", 3);
    private final int value;
    private final String key;

    UserFeedbackEnum(String key, int value) {
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
