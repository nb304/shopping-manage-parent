package com.king2.product.server.dto;

import com.king2.product.server.pojo.UserCharHtmlDataPojo;
import com.king2.product.server.pojo.UserCharInfoPojo;

import java.util.List;

// 用户聊天记录Dto
public class UserCharInfoDto {

    // 未读消息
    private List<UserCharHtmlDataPojo> newCharInfo;
    // 已读消息
    private List<UserCharHtmlDataPojo> oldCharInfo;

    public List<UserCharHtmlDataPojo> getNewCharInfo() {
        return newCharInfo;
    }

    public void setNewCharInfo(List<UserCharHtmlDataPojo> newCharInfo) {
        this.newCharInfo = newCharInfo;
    }

    public List<UserCharHtmlDataPojo> getOldCharInfo() {
        return oldCharInfo;
    }

    public void setOldCharInfo(List<UserCharHtmlDataPojo> oldCharInfo) {
        this.oldCharInfo = oldCharInfo;
    }
}
