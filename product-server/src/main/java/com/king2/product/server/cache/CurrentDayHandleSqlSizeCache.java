package com.king2.product.server.cache;

import com.king2.commons.pojo.K2CurrentDayHandleSqlSize;

import java.util.concurrent.ConcurrentHashMap;

/*=======================================================
	˵��:    ����������ݿ�����Ļ�����

	����		ʱ��					ע��
  	����		2019.08.26   			����
=======================================================*/
public class CurrentDayHandleSqlSizeCache {


    // ��������ģʽ
    private CurrentDayHandleSqlSizeCache() {
    }

    private static CurrentDayHandleSqlSizeCache currentDayHandleSqlSizeCache = new CurrentDayHandleSqlSizeCache();

    public static CurrentDayHandleSqlSizeCache getInstance() {
        return currentDayHandleSqlSizeCache;
    }


    // �����������ڻ����е����ݽṹ
    private ConcurrentHashMap<String, K2CurrentDayHandleSqlSize> dataMaps = new ConcurrentHashMap<String, K2CurrentDayHandleSqlSize>();

    public ConcurrentHashMap<String, K2CurrentDayHandleSqlSize> getDataMaps() {
        return dataMaps;
    }

    public void setDataMaps(ConcurrentHashMap<String, K2CurrentDayHandleSqlSize> dataMaps) {
        this.dataMaps = dataMaps;
    }
}
