package com.king2.product.server.cache;

import com.king2.commons.pojo.K2MemberAndElseInfo;

import java.util.concurrent.ConcurrentHashMap;

/*=======================================================
	说明:    用户信息缓存类

	作者		时间					注释
  	俞烨		2019.09.04   		创建
=======================================================*/
public class UserInfoCacheManage {

    // 单列模式
    private UserInfoCacheManage() {
    }

    private static UserInfoCacheManage userInfoCacheManage = new UserInfoCacheManage();

    public static UserInfoCacheManage getInstance() {
        return userInfoCacheManage;
    }

    private ConcurrentHashMap<String, K2MemberAndElseInfo> userInfoCacheMapDatas = new ConcurrentHashMap<>();


    public ConcurrentHashMap<String, K2MemberAndElseInfo> getUserInfoCacheMapDatas() {
        return userInfoCacheMapDatas;
    }

    public void setUserInfoCacheMapDatas(ConcurrentHashMap<String, K2MemberAndElseInfo> userInfoCacheMapDatas) {
        this.userInfoCacheMapDatas = userInfoCacheMapDatas;
    }
}
