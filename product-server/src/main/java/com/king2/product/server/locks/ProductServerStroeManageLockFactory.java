package com.king2.product.server.locks;

import com.king2.product.server.dto.LockPojo;

import java.util.concurrent.ConcurrentHashMap;

/*=======================================================
	说明:  商品服务模块 根据店铺类型创建锁

	作者		时间					            注释
  	俞烨		2019-09-29                         创建
=======================================================*/
public class ProductServerStroeManageLockFactory {

    // 私有化
    private ProductServerStroeManageLockFactory() {
    }

    private static ProductServerStroeManageLockFactory lockFactory = new ProductServerStroeManageLockFactory();

    public static ProductServerStroeManageLockFactory getInstance() {
        return lockFactory;
    }

    /*
     * 锁的集合,是一个线程安全的HashMap
     * key代表一把锁的类型 可以通过key获取到那把单例的锁
     * value是一个锁的实例 封装着锁对象和condition对象
     * condition的作用就跟synchronized的wait和notify效果一致
     */
    private ConcurrentHashMap<String, LockPojo> lockMaps = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, LockPojo> getLockMaps() {
        return lockMaps;
    }

    public void setLockMaps(ConcurrentHashMap<String, LockPojo> lockMaps) {
        this.lockMaps = lockMaps;
    }
}
