package com.king2.product.server.dto;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2Message;

import java.util.List;

/**
 * 每次动态获取的条件信息
 */
public class ReqeustDynamicGetInfo {

    // 消息信息
    private List<K2Message> wd;

    // 登录的用户信息
    private K2Member k2Member;

    // 聊天信息
    private UserCharInfoDto userCharInfoDto;

    public UserCharInfoDto getUserCharInfoDto() {
        return userCharInfoDto;
    }

    public void setUserCharInfoDto(UserCharInfoDto userCharInfoDto) {
        this.userCharInfoDto = userCharInfoDto;
    }

    public List<K2Message> getWd() {
        return wd;
    }

    public void setWd(List<K2Message> wd) {
        this.wd = wd;
    }

    public K2Member getK2Member() {
        return k2Member;
    }

    public void setK2Member(K2Member k2Member) {
        this.k2Member = k2Member;
    }
}
