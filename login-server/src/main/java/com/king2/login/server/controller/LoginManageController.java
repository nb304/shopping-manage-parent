package com.king2.login.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.NetworkUtil;
import com.king2.login.server.cache.UserLoginCacheManage2;
import com.king2.login.server.service.LoginManageService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/*=======================================================
	说明:    用户登入管理Controller

	作者		时间					注释
  	俞烨		2019.09.06   		创建
=======================================================*/
@RestController
@RequestMapping("/member")
@Validated
@CrossOrigin
public class LoginManageController {

    // 注入用户登入Service
    @Autowired
    private LoginManageService loginManageService;

    /**
     * -----------------------------------------------------
     * 功能:  显示商品品牌的首页
     * <p>
     * 参数:
     * username         String          用户名
     * password         String          密码
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/login")
    public SystemResult login(@NotBlank(message = "用户名不能为空")
                              @Length(max = 11, message = "用户名错误") String username,
                              @NotBlank(message = "密码不能为空") String password,
                              HttpServletRequest request,
                              @NotBlank(message = "验证码不能为空")
                              @Length(max = 4, min = 4, message = "验证码错误") String code) throws Exception {


        // 调用service
        SystemResult login = loginManageService.login(username, password, request, code);
        if (login.getStatus() == 200 || login.getStatus() == 201) {
            // 说明登入成功
            // 需要写回Cookie信息
            String[] cookieInfos = new String[2];
            K2MemberAndElseInfo data = (K2MemberAndElseInfo) login.getData();
            cookieInfos[0] = data.getCurrentToken();
            cookieInfos[1] = username;
            System.out.println(data.getCurrentToken());
            login.setData(cookieInfos);
        }

        return login;
    }

    /**
     * -----------------------------------------------------
     * 功能:  生成验证码
     * <p>
     * 参数:
     * <p>
     * 返回: String              返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/code")
    public String set(HttpServletRequest request) throws IOException {

        // 获取到验证码的缓存结构
        ConcurrentHashMap<String, String> codeHashMap = UserLoginCacheManage2.getInstance().getCodeHashMap();
        // 验证码
        StringBuffer code = new StringBuffer();
        // 验证码第一部分
        String codeOne = new Date().getTime() + "";
        code.append((codeOne).substring(codeOne.length() - 2));
        // 验证码第二部分
        String codeTwo = UUID.randomUUID().toString();
        code.append((codeTwo).substring(codeTwo.length() - 2));
        // 存入缓存结构中 因为跨域不能实现Session共享 得借助于缓存工具
        codeHashMap.put(NetworkUtil.getHostIpAddress(request), code.toString());
        return code.toString().toUpperCase();
    }
}
