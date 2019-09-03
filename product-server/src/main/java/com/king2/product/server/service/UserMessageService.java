package com.king2.product.server.service;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;

/*=======================================================
	说明:    用户消息Service

	作者		时间					注释
  	俞烨		2019.08.25   			创建
=======================================================*/
public interface UserMessageService {

    /**
     * -----------------------------------------------------
     * 功能:  根据状态设置消息的状态
     * <p>
     * 参数:
     * k2MemberAndElseInfo      K2MemberAndElseInfo     登入的用户信息
     * messageId                Integer                 消息的id
     * statw                    String                  消息的状态
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult messageRead(Integer messageId, K2MemberAndElseInfo k2MemberAndElseInfo, String state);

    /**
     * -----------------------------------------------------
     * 功能:  清空或删除所有信息
     * <p>
     * 参数:
     * state      String     状态
     * userId     Integer    操作人的id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult clearOrReadMessage(String state, Integer userId);

}
