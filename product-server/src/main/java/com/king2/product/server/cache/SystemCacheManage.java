package com.king2.product.server.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/*=======================================================
	说明:    商品管理的缓存类

	作者		时间					注释
  	俞烨		2019.08.07   			创建
=======================================================*/
public class SystemCacheManage {

    // 私有化构造 保持全系统只有一个实例
    private SystemCacheManage() {
    }

    // 提供给别人访问的实例和方法
    private static SystemCacheManage systemCacheManage = new SystemCacheManage();

    public static SystemCacheManage getInstance() {
        return systemCacheManage;
    }

    /**
     * 解锁reids 的lua脚本  在classpath:unlock.lua文件中
     */
    public static String UNLOCK_REDIS_LUA = "";

    /**
     * 本地缓存中商品编号的KEY
     */
    public static final String NUMBER_TYPE_PRODUCT = "NUMBER_CACHE_PRODUCT";

    /**
     * 本地缓存中订单编号的KEY
     */
    public static final String NUMBER_TYPE_ORDER = "NUMBER_CACHE_ORDER";

    /**
     * 商品图片的名称
     */
    public static final String PRODUCT_NAME_IMAGE = "PRODUCT_NAME_IMAGE";

    /**
     * 本地缓存的队列集合
     * key --- value
     */
    private static Map<String, ConcurrentLinkedQueue<String>> queueMap = new ConcurrentHashMap<>();

    public static Map<String, ConcurrentLinkedQueue<String>> getQueueMap() {
        return queueMap;
    }

    public static void setQueueMap(Map<String, ConcurrentLinkedQueue<String>> queueMap) {
        SystemCacheManage.queueMap = queueMap;
    }
}
