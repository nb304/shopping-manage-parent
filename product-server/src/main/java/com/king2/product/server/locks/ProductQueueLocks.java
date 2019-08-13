package com.king2.product.server.locks;

import com.king2.product.server.dto.LockPojo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

// 商品队列锁集合
public class ProductQueueLocks {

    // 单列模式
    private ProductQueueLocks() {
    }

    private static ProductQueueLocks productInfoQueueLock = new ProductQueueLocks();

    public static ProductQueueLocks getInstance() {
        refreshLock();
        return productInfoQueueLock;
    }

    // 锁集合
    private static ConcurrentHashMap<String, LockPojo> lockMaps = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, LockPojo> getLockMaps() {
        return lockMaps;
    }

    public void setLockMaps(ConcurrentHashMap<String, LockPojo> lockMaps) {
        ProductQueueLocks.lockMaps = lockMaps;
    }

    // 商品信息Key
    public static final String DEFAULT_PRODUCT_INFO_KEY = "PRODUC_TINFO_KEY";


    // key的集合信息
    private static List<String> keys = new ArrayList<>();

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    // 刷新锁
    private static void refreshLock() {
        // 双重校验
        if (lockMaps.isEmpty()) {
            synchronized (ProductQueueLocks.class) {
                if (lockMaps.isEmpty()) {
                    keys.add(DEFAULT_PRODUCT_INFO_KEY);

                    for (int i = 0; i < keys.size(); i++) {
                        LockPojo lockPojo = new LockPojo();
                        lockPojo.setLock(new ReentrantLock());
                        lockMaps.put(keys.get(i), lockPojo);
                    }
                }
            }
        }
    }
}

