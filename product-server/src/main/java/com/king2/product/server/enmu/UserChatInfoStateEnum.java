package com.king2.product.server.enmu;

// �û������¼��ö����
public enum UserChatInfoStateEnum {

    ZC("����", 1),//����
    DEL("ɾ��", 2);//ɾ��

    private final int value;
    private final String key;

    UserChatInfoStateEnum(String key, int value) {
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
