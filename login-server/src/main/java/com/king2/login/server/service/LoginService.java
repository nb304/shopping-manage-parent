package com.king2.login.server.service;


import com.king2.commons.result.SystemResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*================================================================
说明：用户登录业务接口类

作者          	时间            		注释
刘梓江           2019/8/31           创建类

==================================================================*/
public interface LoginService {


    /**-----------------------------------------------------------------
     * 功能：登录
     *
     * 参数：形参名               类型		                    描述
     *      account             String                      用户账号
     *      password            String                      用户密码
     *      HttpServletRequest  request                     请求对象
     *      response            HttpServletResponse         响应对象
     *
     * 返回：SystemResult 该方法返回信息封装存储到响应体对象
     -------------------------------------------------------------------*/
    public SystemResult login(String account,String password,HttpServletRequest request, HttpServletResponse response);



    /**-----------------------------------------------------------------
     * 功能：退出登录
     *
     * 参数：形参名               类型		        描述
     *      token               String        用户登录成功的唯一标识
     *      account             String        用户账号
     *      HttpServletRequest  request       请求对象
     *
     * 返回：SystemResult 该方法返回信息封装存储到响应体对象
     -------------------------------------------------------------------*/
    public SystemResult outLogin(String token, String account, HttpServletRequest request);
}
