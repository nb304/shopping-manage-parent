package com.king2.login.server.service;

import com.king2.commons.result.SystemResult;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*=======================================================
	说明:    用户登入管理Service

	作者		时间					注释
  	俞烨		2019.09.06   		创建
=======================================================*/
public interface LoginManageService {

    /**
     * -----------------------------------------------------
     * 功能:  SSO单点登录系统
     * <p>
     * 参数:
     * username         String          用户名
     * password         String          密码
     * code             String          验证码
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult login(String username, String password, HttpServletRequest request, String code) throws IOException;
}
