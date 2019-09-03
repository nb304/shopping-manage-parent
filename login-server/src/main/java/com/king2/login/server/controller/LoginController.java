package com.king2.login.server.controller;


import com.king2.login.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*================================================================
说明：用户登录控制类

作者          	时间            		注释
刘梓江           2019/8/31           创建类

==================================================================*/
@RestController
@RequestMapping("/account")
@CrossOrigin
@Validated
public class LoginController {


    @Autowired
    private LoginService  loginService;         //注入用户登录业务接口




}
