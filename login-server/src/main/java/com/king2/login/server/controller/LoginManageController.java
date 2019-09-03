package com.king2.login.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.login.server.service.LoginManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/member")
@Validated
@CrossOrigin
public class LoginManageController {

    @Autowired
    private LoginManageService loginManageService;

    @RequestMapping("/login")
    public SystemResult login(String username, String password,
                              HttpServletRequest request, HttpServletResponse response) {
        // 调用service
        SystemResult login = loginManageService.login(username, password, request);
        if (login.getStatus() == 200 || login.getStatus() == 201) {
            // 说明登入成功
            // 需要写回Cookie信息
            K2MemberAndElseInfo data = (K2MemberAndElseInfo) login.getData();
            Cookie kie = new Cookie("userKey", data.getCurrentToken() + "");
            kie.setDomain("192.168.0.143");
            kie.setPath("/");
            response.addCookie(kie);
        }

        return login;
    }
}
