package com.king2.login.server.cache;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;

import java.util.concurrent.ConcurrentHashMap;

public class UserLoginCacheManage2 {

    private UserLoginCacheManage2() {
    }

    private static UserLoginCacheManage2 userLoginCacheManage2 = new UserLoginCacheManage2();

    public static UserLoginCacheManage2 getInstance() {
        return userLoginCacheManage2;
    }

    //  用户的信息缓存结构
    private ConcurrentHashMap<String, K2MemberAndElseInfo> userCacheHashMapDatas = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, K2MemberAndElseInfo> getUserCacheHashMapDatas() {
        return userCacheHashMapDatas;
    }

    public void setUserCacheHashMapDatas(ConcurrentHashMap<String, K2MemberAndElseInfo> userCacheHashMapDatas) {
        this.userCacheHashMapDatas = userCacheHashMapDatas;
    }

    // 登入的验证码缓存结构
    private ConcurrentHashMap<String, String> codeHashMap = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, String> getCodeHashMap() {
        return codeHashMap;
    }

    public void setCodeHashMap(ConcurrentHashMap<String, String> codeHashMap) {
        this.codeHashMap = codeHashMap;
    }
}
