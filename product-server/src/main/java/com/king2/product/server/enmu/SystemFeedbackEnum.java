package com.king2.product.server.enmu;

/**
 * ϵͳ֪ͨö����
 */
public enum SystemFeedbackEnum {

    YD("�Ѷ�", 1),
    WD("δ��", 2),
    DDFM("��������", 4),
    TS("Ͷ��", 5),
    IS_COMMON_YES("�ǹ�����", 0),
    IS_COMMONS_NO("���ǹ�����", 1),
    BELONG_USER_ID("���ڵ��û�id,Ϊ0����ϵͳ����", 0),
    STORE_LOOK_YES("�õ��̵Ķ��ܿ���", 1),
    STORE_LOOK_NO("�õ��̵ĳ�Ա������", 2);

    private final int value;
    private final String key;

    SystemFeedbackEnum(String key, int value) {
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
