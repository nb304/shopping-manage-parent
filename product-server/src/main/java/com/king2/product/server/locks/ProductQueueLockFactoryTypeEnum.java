package com.king2.product.server.locks;

// 商品队列中锁的类型枚举
public enum ProductQueueLockFactoryTypeEnum {

    DEFAULT_PRODUCT_INFO_KEY("商品信息同步锁", "PRODUC_TINFO_KEY_LOCK"),//商品信息同步锁
    DEFAULT_PRODUCT_CACHE_KEY("商品信息缓存同步锁", "PRODUC_CACHE_KEY_LOCK"),// 商品信息缓存同步锁
    DEFAULT_SYSTEM_MESSAGE_KEY("商城消息同步锁", "USER_MESSAGE_KEY_LOCK"), //商城消息的同步类型锁
    DEFAULT_FUNCTION_MYSQL_SIZE_KEY("操作数据库次数的锁类型", "MYSQL_SIZE_KEY_LOCK"), // 操作数据库次数的锁类型
    PRODUCT_EVALUATE_KEY("用户回复的锁类型", "CONTENT_USER"),
    MESSAGE_ID_ONLY_KEY("用户消息的唯一IDKey", "MESSAGE_NUMBER_ONLY_KEY_LOCK"),
    USER_CHAT_KEY("用户聊天的锁类型", "USER_CHAT_KEY_LOCK");

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
