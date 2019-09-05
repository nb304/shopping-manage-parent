package com.king2.commons.pojo;

import java.util.Date;
import java.util.List;

// 用户的其他信息
public class K2MemberAndElseInfo {

    // 用户信息
    private K2Member k2Member;

    // 角色信息
    private List<K2Role> k2Roles;

    // 本次的token信息
    private String currentToken;

    // 以前的token
    private String oldToken;

    // 最后一次登录的日期
    private Date lastLoginTime;

    public String getOldToken() {
        return oldToken;
    }

    public void setOldToken(String oldToken) {
        this.oldToken = oldToken;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getCurrentToken() {
        return currentToken;
    }

    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken;
    }

    public K2Member getK2Member() {
        return k2Member;
    }

    public void setK2Member(K2Member k2Member) {
        this.k2Member = k2Member;
    }

    public List<K2Role> getK2Roles() {
        return k2Roles;
    }

    public void setK2Roles(List<K2Role> k2Roles) {
        this.k2Roles = k2Roles;
    }
}
