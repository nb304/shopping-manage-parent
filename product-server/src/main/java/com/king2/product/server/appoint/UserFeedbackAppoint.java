package com.king2.product.server.appoint;

import com.king2.commons.mapper.K2UserFeedbackMapper;
import com.king2.commons.pojo.K2FeedbackReply;
import com.king2.commons.pojo.K2UserFeedback;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.GetErrorInfo;
import com.king2.product.server.enmu.UserFeedbackEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * �û�����ί����
 */
@Component
public class UserFeedbackAppoint {

    // ע�뷴��Mapper
    @Autowired
    private K2UserFeedbackMapper k2UserFeedbackMapper;

    // ��������ֽ���
    private static final Long MAX_SIZE = 104857600l;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFeedbackAppoint.class);

    /**
     * У�鷴����Ϣ�Ƿ���ȷ
     *
     * @param feedId
     * @return
     */
    public SystemResult checkUserFeedbackInfo(Integer feedId) {
        // ��ѯ��Ϣ�Ƿ���� �����Ƿ�Ϊ�Իظ���״̬
        K2UserFeedback userFeedback = k2UserFeedbackMapper.selectByPrimaryKey(feedId);
        if (userFeedback == null) {
            return new SystemResult(100, "����������,�����Ѿ���ɾ��");
        } else if (!(UserFeedbackEnum.CLZ.getValue() + "").equals(userFeedback.getUserFeedbackState() + "")) {
            return new SystemResult(100, "�÷����Ѿ�����������Ա����,��ˢ��ҳ��");
        }
        return new SystemResult(userFeedback);
    }

    /**
     * У�������Ƿ���ϳ��� �����ض�Ӧ����
     *
     * @param content
     * @param feedId
     * @return
     * @throws Exception
     */
    public SystemResult checkReplyInfo(String content, Integer feedId) {

        // У��������Ϣ�Ƿ����
        int length = 0;
        try {
            length = content.getBytes("utf-8").length;
        } catch (Exception e) {
            LOGGER.error("�ظ���������ת���ֽڳ���ʧ��" + e);
            LOGGER.error(GetErrorInfo.getTrace(e));
            e.printStackTrace();
            return new SystemResult(100, "�ֽ�ת��ʧ��");
        }

        if (length > MAX_SIZE) {
            return new SystemResult(100, "�ظ������ݹ�����");
        }

        // �������ص���Ϣ
        K2FeedbackReply reply = new K2FeedbackReply();
        reply.setCreateTime(new Date());
        reply.setFeedbackId(feedId);
        reply.setReplyContent(content);
        return new SystemResult(reply);
    }
}
