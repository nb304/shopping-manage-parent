package com.king2.product.server.enmu;

// ��Ʒ״̬��ö����
public enum ProductStateEnum {

    ALL("ȫ��", 0),// ȫ����Ʒ
    SJ("�ϼ�", 1),  // ��Ʒ�ϼܵ�״̬
    XJ("�¼�", 2), // ��Ʒ�¼ܵ�״̬
    DEL("ɾ��", 3), // ��Ʒɾ����״̬
    EDIT("�༭��", 4), // ��Ʒ�༭�е�״̬
    SH("�����", 5), // ����е�״̬
    KCYES("������", 6), // �������״̬
    KCNO("��治��", 7), // ��治���״̬
    SHNO("��˲�ͨ��", 8);

    private final int value;
    private final String key;

    ProductStateEnum(String key, int value) {
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
