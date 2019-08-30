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
    // 当有用户给该用户发送消息时，新的消息就会进入到新消息数据结构中
    // 前端一直监听新消息的结构里是否存在着属于该用户的消息
    // 当用户点击消息时，我们就需要将发送者的消息数据 从新消息数据中移除 并安置到历史记录 并且更新历史消息

    // 用户新的消息结构
    private ConcurrentHashMap<String, ConcurrentHashMap<String, List<UserCharInfoPojo>>> newMessageDatas = new ConcurrentHashMap<>();

    // 用户历史消息的数据结构
    private ConcurrentHashMap<String, ConcurrentHashMap<String, List<UserCharInfoPojo>>> oldMessageDatas = new ConcurrentHashMap<>();


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
