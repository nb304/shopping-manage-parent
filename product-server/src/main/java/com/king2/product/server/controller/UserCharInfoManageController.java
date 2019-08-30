package com.king2.product.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.service.UserCharInfoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/*=======================================================
	说明:    用户聊天记录管理Controller

	作者		时间					注释
  	俞烨		2019.08.20   			创建
=======================================================*/
@RestController
@RequestMapping("/char/info")
@Validated
public class UserCharInfoManageController {

    // 注入聊天记录Service
    @Autowired
    private UserCharInfoManageService userCharInfoManageService;

    /**
     * -----------------------------------------------------
     * 功能:  显示聊天记录首页 并准备数据
     * <p>
     * 参数:
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/index")
    public SystemResult index(HttpServletRequest request) {
        // 获取用户数据
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = userCharInfoManageService.index(k2MemberAndElseInfo);
        return index;
    }
}
