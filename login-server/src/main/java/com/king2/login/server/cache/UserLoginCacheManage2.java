package com.king2.login.server.cache;

import com.king2.commons.pojo.K2Member;

import java.util.concurrent.ConcurrentHashMap;

public class UserLoginCacheManage2 {

    private UserLoginCacheManage2() {
    }

    private static UserLoginCacheManage2 userLoginCacheManage2 = new UserLoginCacheManage2();

    public static UserLoginCacheManage2 getInstance() {
        return userLoginCacheManage2;
    }

    private ConcurrentHashMap<String, K2Member> userCacheHashMapDatas = new ConcurrentHashMap<>();


    public ConcurrentHashMap<String, K2Member> getUserCacheHashMapDatas() {
        return userCacheHashMapDatas;
    }

    public void setUserCacheHashMapDatas(ConcurrentHashMap<String, K2Member> userCacheHashMapDatas) {
        this.userCacheHashMapDatas = userCacheHashMapDatas;
    }
}
