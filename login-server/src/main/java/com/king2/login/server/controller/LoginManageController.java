package com.king2.login.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.MACUtil;
import com.king2.commons.utils.NetworkUtil;
import com.king2.login.server.service.LoginManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/member")
@Validated
@CrossOrigin
public class LoginManageController {

    @Autowired
    private LoginManageService loginManageService;

    @RequestMapping("/login")
    public SystemResult login(@NotBlank(message = "用户名不能为空") String username,
                              @NotBlank(message = "密码不能为空") String password,
                              HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 调用service
        SystemResult login = loginManageService.login(username, password, request);
        if (login.getStatus() == 200 || login.getStatus() == 201) {
            // 说明登入成功
            // 需要写回Cookie信息
            String[] cookieInfos = new String[2];
            K2MemberAndElseInfo data = (K2MemberAndElseInfo) login.getData();
            cookieInfos[0] = data.getCurrentToken();
            cookieInfos[1] = username;
            login.setData(cookieInfos);
        }

        return login;
    }
}
