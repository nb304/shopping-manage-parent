package com.king2.product.server.service;


import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;

/*=======================================================
	说明:    用户聊天管理Service

	作者		时间					注释
  	俞烨		2019.08.30   			创建
=======================================================*/
public interface UserChatInfoManageService {

    /**
     * -----------------------------------------------------
     * 功能:  获取用户的全部信息
     * <p>
     * 参数:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         操作的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo);

    /**
     * -----------------------------------------------------
     * 功能:  发送消息
     * <p>
     * 参数:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         操作的用户信息
     * receiverId                   Integer                     接收人的id
     * message                      String                      消息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult sendMessage(Integer receiverId, K2MemberAndElseInfo k2MemberAndElseInfo, String message);

    /**
     * -----------------------------------------------------
     * 功能:  通过getId同步信息
     * <p>
     * 参数:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         操作的用户信息
     * getId                        Integer                     查询人的id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult get(Integer getId, K2MemberAndElseInfo k2MemberAndElseInfo);
}
