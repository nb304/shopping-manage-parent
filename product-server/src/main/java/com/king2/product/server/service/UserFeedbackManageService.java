package com.king2.product.server.service;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.UserFeedbackIndexDto;

/*=======================================================
	说明:     用户反馈时间Service

	作者		时间					注释
  	俞烨		2019.08.31   			创建
=======================================================*/
public interface UserFeedbackManageService {

    /**
     * -----------------------------------------------------
     * 功能:  用户反馈的主页信息
     * <p>
     * 参数:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        操作的用户信息
     * dto              UserFeedbackIndexDto 分页数据
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, UserFeedbackIndexDto dto);

    /**
     * -----------------------------------------------------
     * 功能:  回复用户的反馈
     * <p>
     * 参数:
     * feedBackId         Integer        反馈的信息id
     * k2MemberAndElseInfo              K2MemberAndElseInfo 操作的用户
     * content          String          回复的消息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult readUserFeedBack(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo, String content);

    /**
     * -----------------------------------------------------
     * 功能:   查询反馈的回复信息
     * <p>
     * 参数:
     * feedBackId         Integer        反馈的信息id
     * k2MemberAndElseInfo              K2MemberAndElseInfo 操作的用户
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult getReplyInfo(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo);

    /**
     * -----------------------------------------------------
     * 功能:   查询反馈的附件信息
     * <p>
     * 参数:
     * feedBackId         Integer        反馈的信息id
     * k2MemberAndElseInfo              K2MemberAndElseInfo 操作的用户
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult getFeedbackAccessory(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo);

    /**
     * -----------------------------------------------------
     * 功能:   删除用户反馈功能
     * <p>
     * 参数:
     * feedBackId         Integer        反馈的信息id
     * k2MemberAndElseInfo              K2MemberAndElseInfo 操作的用户
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult delFeedback(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo);
}
