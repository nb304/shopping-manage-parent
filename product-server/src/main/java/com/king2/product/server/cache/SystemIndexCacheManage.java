package com.king2.product.server.cache;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/*=======================================================
	说明:    商城系统首页缓存类

	作者		时间					注释
  	俞烨		2019.08.24   			创建
=======================================================*/
public class SystemIndexCacheManage {


    // 私有化构造  因为要当缓存类 所有我们需要保证全局就一个对象
    private SystemIndexCacheManage() {
    }

    private static SystemIndexCacheManage systemCacheManage = new SystemIndexCacheManage();

    public static SystemIndexCacheManage getInstance() {
        return systemCacheManage;
    }

    // 商城首页信息的key
    public static final String PRODUCT_INDEX_KEY = "PRODUCT_INDEX_KEY";
    // 商城首页顶部栏的key
    public static final String PRODUCT_INDEX_NARBAR_KEY = "PRODUCT_INDEX_NARBAR_KEY";
    // 用户的消息key
    public static final String PRODUCT_INDEX_USER_MESSAGE_KEY = "PRODUCT_INDEX_USER_MESSAGE_KEY";

    /**
     * 创建商城首页的缓存结构
     */
    private ConcurrentHashMap<String, Object> systemIndexHashMapData = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String , Date> systemIndexHashMapDataDelFlag = new ConcurrentHashMap<>();


    public ConcurrentHashMap<String, Date> getSystemIndexHashMapDataDelFlag() {
        return systemIndexHashMapDataDelFlag;
    }

    public void setSystemIndexHashMapDataDelFlag(ConcurrentHashMap<String, Date> systemIndexHashMapDataDelFlag) {
        this.systemIndexHashMapDataDelFlag = systemIndexHashMapDataDelFlag;
    }

    public ConcurrentHashMap<String, Object> getSystemIndexHashMapData() {
        return systemIndexHashMapData;
    }

    public void setSystemIndexHashMapData(ConcurrentHashMap<String, Object> systemIndexHashMapData) {
        this.systemIndexHashMapData = systemIndexHashMapData;
    }
}
