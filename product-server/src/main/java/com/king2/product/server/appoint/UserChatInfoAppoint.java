package com.king2.product.server.appoint;

import com.king2.commons.mapper.K2MemberMapper;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * �û������¼ί����
 */
@Component
public class UserChatInfoAppoint {

    // ע��ϵͳ��Ա��
    @Autowired
    private K2MemberMapper k2MemberMapper;


    public SystemResult getSendUserChatData(K2MemberAndElseInfo k2MemberAndElseInfo, Integer receiveId) {
        // �鿴��������ϵͳ���Ƿ����
        K2Member k2Member = k2MemberMapper.selectByPrimaryKey(receiveId);
        if (k2Member == null) return new SystemResult(100, "����Ҫ���͵��û�������,�����ѱ�ɾ��");


        return null;
    }
}
