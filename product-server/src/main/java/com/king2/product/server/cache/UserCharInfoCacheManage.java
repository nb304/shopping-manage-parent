package com.king2.product.server.cache;

import com.king2.product.server.pojo.UserCharInfoPojo;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/*=======================================================
	说明:    用户聊天记录缓存类

	作者		时间					注释
  	俞烨		2019.08.30   			创建
=======================================================*/
public class UserCharInfoCacheManage {

    // 作为缓存类 就要变成单列状态
    private UserCharInfoCacheManage() {
    }

    private static UserCharInfoCacheManage userCharInfoCacheManage = new UserCharInfoCacheManage();

    public static UserCharInfoCacheManage getInstance() {
        return userCharInfoCacheManage;
    }

    // 聊天记录缓存类 维护着两个数据结构
    // 1、用户新的消息结构
    // 2、用户历史消息的数据结构
    // 当发送者给接收者发送消息时，新的消息回进接收者新消息数据结构中 。发送的消息会进发送者的旧消息数据结构中
    // 前端一直监听新消息的结构里是否存在着属于该用户的消息
    // 当用户点击消息时，我们就需要将发送者的消息数据 从新消息数据中移除 并安置到历史记录 并且更新历史消息

    // 用户新的消息结构
    private ConcurrentHashMap<String, ConcurrentHashMap<String, List<UserCharInfoPojo>>> newMessageDatas = new ConcurrentHashMap<>();

    // 用户历史消息的数据结构
    private ConcurrentHashMap<String, ConcurrentHashMap<String, List<UserCharInfoPojo>>> oldMessageDatas = new ConcurrentHashMap<>();

    // 是否进行排序的数据结构
    private ConcurrentHashMap<String, Boolean> isSortFlagMaps = new ConcurrentHashMap<>();

    /**
     * 是否进行排序的Flag
     */
    public static final String IS_SYNCHRONIZED_SORT_FLAG = "IS_SYNCHRONIZED_FLAG";


    public ConcurrentHashMap<String, Boolean> getIsSortFlagMaps() {
        return isSortFlagMaps;
    }

    public void setIsSortFlagMaps(ConcurrentHashMap<String, Boolean> isSortFlagMaps) {
        this.isSortFlagMaps = isSortFlagMaps;
    }

    public ConcurrentHashMap<String, ConcurrentHashMap<String, List<UserCharInfoPojo>>> getNewMessageDatas() {
        return newMessageDatas;
    }

    public void setNewMessageDatas(ConcurrentHashMap<String, ConcurrentHashMap<String, List<UserCharInfoPojo>>> newMessageDatas) {
        this.newMessageDatas = newMessageDatas;
    }

    public ConcurrentHashMap<String, ConcurrentHashMap<String, List<UserCharInfoPojo>>> getOldMessageDatas() {
        return oldMessageDatas;
    }

    public void setOldMessageDatas(ConcurrentHashMap<String, ConcurrentHashMap<String, List<UserCharInfoPojo>>> oldMessageDatas) {
        this.oldMessageDatas = oldMessageDatas;
    }
}
