package com.king2.product.server.dto;

import com.king2.product.server.pojo.UserCharInfoPojo;

import java.util.List;

/**
 * 用户缓存Dto
 */
public class UserChatCacheInfoDto {


    // 新消息
    private List<UserCharInfoPojo> newChatInfos;
    // 旧消息
    private List<UserCharInfoPojo> oldChatInfos;

    public List<UserCharInfoPojo> getNewChatInfos() {
        return newChatInfos;
    }

    public void setNewChatInfos(List<UserCharInfoPojo> newChatInfos) {
        this.newChatInfos = newChatInfos;
    }

    public List<UserCharInfoPojo> getOldChatInfos() {
        return oldChatInfos;
    }

    public void setOldChatInfos(List<UserCharInfoPojo> oldChatInfos) {
        this.oldChatInfos = oldChatInfos;
    }
}
