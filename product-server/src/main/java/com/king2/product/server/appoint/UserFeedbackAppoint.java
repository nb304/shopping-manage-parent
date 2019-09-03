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
 * 用户反馈委托类
 */
@Component
public class UserFeedbackAppoint {

    // 注入反馈Mapper
    @Autowired
    private K2UserFeedbackMapper k2UserFeedbackMapper;

    // 定义最大字节数
    private static final Long MAX_SIZE = 104857600l;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFeedbackAppoint.class);

    /**
     * 校验反馈信息是否正确
     *
     * @param feedId
     * @return
     */
    public SystemResult checkUserFeedbackInfo(Integer feedId) {
        // 查询信息是否存在 存在是否为以回复的状态
        K2UserFeedback userFeedback = k2UserFeedbackMapper.selectByPrimaryKey(feedId);
        if (userFeedback == null) {
            return new SystemResult(100, "反馈不存在,可能已经被删除");
        } else if (!(UserFeedbackEnum.CLZ.getValue() + "").equals(userFeedback.getUserFeedbackState() + "")) {
            return new SystemResult(100, "该反馈已经被其他管理员处理,请刷新页面");
        }
        return new SystemResult(userFeedback);
    }

    /**
     * 校验内容是否符合长度 并返回对应数据
     *
     * @param content
     * @param feedId
     * @return
     * @throws Exception
     */
    public SystemResult checkReplyInfo(String content, Integer feedId) {

        // 校验内容信息是否过长
        int length = 0;
        try {
            length = content.getBytes("utf-8").length;
        } catch (Exception e) {
            LOGGER.error("回复反馈内容转换字节长度失败" + e);
            LOGGER.error(GetErrorInfo.getTrace(e));
            e.printStackTrace();
            return new SystemResult(100, "字节转换失败");
        }

        if (length > MAX_SIZE) {
            return new SystemResult(100, "回复的内容过长。");
        }

        // 创建返回的信息
        K2FeedbackReply reply = new K2FeedbackReply();
        reply.setCreateTime(new Date());
        reply.setFeedbackId(feedId);
        reply.setReplyContent(content);
        return new SystemResult(reply);
    }
}
