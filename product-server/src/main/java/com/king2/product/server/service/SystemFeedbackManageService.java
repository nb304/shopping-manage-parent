package com.king2.product.server.service;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.SystemFeedbackIndexDto;

/*=======================================================
	说明:    系统通知管理Service

	作者		时间					注释
  	俞烨		2019.09.01   			创建
=======================================================*/
public interface SystemFeedbackManageService {

    /**
     * -----------------------------------------------------
     * 功能:  系统通知首页
     * <p>
     * 参数:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         操作的用户
     * dto                          SystemFeedbackIndexDto      系统通知Dto
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, SystemFeedbackIndexDto dto);
}
