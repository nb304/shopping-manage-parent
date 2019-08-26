package com.king2.product.server.cache;

import com.king2.commons.pojo.K2CurrentDayHandleSqlSize;

import java.util.concurrent.ConcurrentHashMap;

/*=======================================================
	说明:    当天操作数据库次数的缓存类

	作者		时间					注释
  	俞烨		2019.08.26   			创建
=======================================================*/
public class CurrentDayHandleSqlSizeCache {


    // 开启单列模式
    private CurrentDayHandleSqlSizeCache() {
    }

    private static CurrentDayHandleSqlSizeCache currentDayHandleSqlSizeCache = new CurrentDayHandleSqlSizeCache();

    public static CurrentDayHandleSqlSizeCache getInstance() {
        return currentDayHandleSqlSizeCache;
    }


    // 操作次数存在缓存中的数据结构
    private ConcurrentHashMap<String, K2CurrentDayHandleSqlSize> dataMaps = new ConcurrentHashMap<String, K2CurrentDayHandleSqlSize>();

    public ConcurrentHashMap<String, K2CurrentDayHandleSqlSize> getDataMaps() {
        return dataMaps;
    }

    public void setDataMaps(ConcurrentHashMap<String, K2CurrentDayHandleSqlSize> dataMaps) {
        this.dataMaps = dataMaps;
    }
}
