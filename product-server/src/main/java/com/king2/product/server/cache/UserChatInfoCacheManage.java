package com.king2.product.server.cache;

import com.king2.product.server.dto.UserChatCacheInfoDto;

import java.util.concurrent.ConcurrentHashMap;

/*=======================================================
	说明:    用户聊天记录缓存类

	作者		时间					注释
  	俞烨		2019.08.30   			创建
=======================================================*/
public class UserChatInfoCacheManage {

    private UserChatInfoCacheManage() {
    }

    private static UserChatInfoCacheManage userChatInfoCacheManage = new UserChatInfoCacheManage();

    public static UserChatInfoCacheManage getInstance() {
        return userChatInfoCacheManage;
    }


    // 创建缓存队列信息
    private ConcurrentHashMap<String, ConcurrentHashMap<String, UserChatCacheInfoDto>> hashMapConcurrentHashMap =
            new ConcurrentHashMap<>();


    public ConcurrentHashMap<String, ConcurrentHashMap<String, UserChatCacheInfoDto>> getHashMapConcurrentHashMap() {
        return hashMapConcurrentHashMap;
    }

    public void setHashMapConcurrentHashMap(ConcurrentHashMap<String, ConcurrentHashMap<String, UserChatCacheInfoDto>> hashMapConcurrentHashMap) {
        this.hashMapConcurrentHashMap = hashMapConcurrentHashMap;
    }
}
