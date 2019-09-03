package com.king2.product.server.appoint;

import com.king2.commons.mapper.K2MemberMapper;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户聊天记录委托类
 */
@Component
public class UserChatInfoAppoint {

    // 注入系统成员表
    @Autowired
    private K2MemberMapper k2MemberMapper;


    public SystemResult getSendUserChatData(K2MemberAndElseInfo k2MemberAndElseInfo, Integer receiveId) {
        // 查看接收者在系统中是否存在
        K2Member k2Member = k2MemberMapper.selectByPrimaryKey(receiveId);
        if (k2Member == null) return new SystemResult(100, "您需要发送的用户不存在,或者已被删除");


        return null;
    }
}
