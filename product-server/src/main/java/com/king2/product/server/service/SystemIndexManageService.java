package com.king2.product.server.service;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;

/*=======================================================
	说明:    系统首页管理Service

	作者		时间					注释
  	俞烨		2019.08.24   			创建
=======================================================*/
public interface SystemIndexManageService {

    /**
     * -----------------------------------------------------
     * 功能:  商城系统的首页信息
     * <p>
     * 参数:
     * k2MemberAndElseInfo      K2MemberAndElseInfo     登入的用户信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult systemIndex(K2MemberAndElseInfo k2MemberAndElseInfo);

}
