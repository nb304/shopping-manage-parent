package com.king2.product.server.locks;

import com.king2.product.server.dto.LockPojo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/*=======================================================
	说明:   商品模块的锁工厂

	作者		时间					注释
  	俞烨		2019.08.14   			创建
=======================================================*/
public class ProductQueueLockFactory {

    // 单列模式
    private ProductQueueLockFactory() {
    }

    private static ProductQueueLockFactory productInfoQueueLock = new ProductQueueLockFactory();

    public static ProductQueueLockFactory getInstance() {
        // 初始化锁
        refreshLock();
        return productInfoQueueLock;
    }

    /**
     * 锁的集合,是一个线程安全的HashMap
     * key代表一把锁的类型 可以通过key获取到那把单例的锁
     * value是一个锁的实例 封装着锁对象和condition对象
     * condition的作用就跟synchronized的wait和notify效果一致
     */
    private static ConcurrentHashMap<String, LockPojo> lockMaps = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, LockPojo> getLockMaps() {
        return lockMaps;
    }


    // 商品信息同步的锁的类型
    public static final String DEFAULT_PRODUCT_INFO_KEY = "PRODUC_TINFO_KEY";

    // 商品模块服务的锁类型集合
    private static List<String> keys = new ArrayList<>();

    // 提供Get方法 可以让别人也进行设置信息
    public List<String> getKeys() {
        return keys;
    }

    // 刷新锁
    private static void refreshLock() {
        // 双重校验
        if (lockMaps.isEmpty()) {
            synchronized (ProductQueueLockFactory.class) {
                if (lockMaps.isEmpty()) {
                    keys.add(DEFAULT_PRODUCT_INFO_KEY);

                    for (int i = 0; i < keys.size(); i++) {
                        // 动态创建锁对象
                        LockPojo lockPojo = new LockPojo();
                        lockPojo.setLock(new ReentrantLock());
                        lockMaps.put(keys.get(i), lockPojo);
                    }
                }
            }
        }
    }
}

