package com.king2.product.server.locks;

// ��Ʒ��������������ö��
public enum ProductQueueLockFactoryTypeEnum {

    DEFAULT_PRODUCT_INFO_KEY("��Ʒ��Ϣͬ����", "PRODUC_TINFO_KEY_LOCK"),//��Ʒ��Ϣͬ����
    DEFAULT_PRODUCT_CACHE_KEY("��Ʒ��Ϣ����ͬ����", "PRODUC_CACHE_KEY_LOCK"),// ��Ʒ��Ϣ����ͬ����
    DEFAULT_SYSTEM_MESSAGE_KEY("�̳���Ϣͬ����", "USER_MESSAGE_KEY_LOCK"), //�̳���Ϣ��ͬ��������
    DEFAULT_FUNCTION_MYSQL_SIZE_KEY("�������ݿ������������", "MYSQL_SIZE_KEY_LOCK"), // �������ݿ������������
    PRODUCT_EVALUATE_KEY("�û��ظ���������", "CONTENT_USER"),
    MESSAGE_ID_ONLY_KEY("�û���Ϣ��ΨһIDKey", "MESSAGE_NUMBER_ONLY_KEY_LOCK"),
    USER_CHAT_KEY("�û������������", "USER_CHAT_KEY_LOCK");

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
