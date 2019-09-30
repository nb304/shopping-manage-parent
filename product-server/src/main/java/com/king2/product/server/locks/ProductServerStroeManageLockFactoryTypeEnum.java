package com.king2.product.server.locks;

/**
 * 店铺功能锁的key
 */
public enum ProductServerStroeManageLockFactoryTypeEnum {

    STORE_ADD_KEY_LOCK("店铺添加商品的锁", "STORE_ADD_KEY_LOCK");

    private final String value;
    private final String key;

    ProductServerStroeManageLockFactoryTypeEnum(String key, String value) {
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
