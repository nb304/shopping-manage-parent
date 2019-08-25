package com.king2.commons.pojo;

import java.util.List;

// 用户的其他信息
public class K2MemberAndElseInfo {

    // 用户信息
    private K2Member k2Member;

    // 角色信息
    private List<K2Role> k2Roles;


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
