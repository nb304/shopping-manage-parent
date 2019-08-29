package com.king2.product.server.enmu;

// ��Ʒ��������������ö��
public enum ProductQueueLockFactoryTypeEnum {

    DEFAULT_PRODUCT_INFO_KEY("��Ʒ��Ϣͬ����", "PRODUC_TINFO_KEY"),//��Ʒ��Ϣͬ����
    DEFAULT_PRODUCT_CACHE_KEY("��Ʒ��Ϣ����ͬ����", "PRODUC_CACHE_KEY"),// ��Ʒ��Ϣ����ͬ����
    DEFAULT_SYSTEM_MESSAGE_KEY("�̳���Ϣͬ����", "USER_MESSAGE_KEY"), //�̳���Ϣ��ͬ��������
    DEFAULT_FUNCTION_MYSQL_SIZE_KEY("�������ݿ������������", "MYSQL_SIZE_KEY"), // �������ݿ������������
    PRODUCT_EVALUATE_KEY("�û��ظ���������", "CONTENT_USER");;

    private final String value;
    private final String key;

    ProductQueueLockFactoryTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
