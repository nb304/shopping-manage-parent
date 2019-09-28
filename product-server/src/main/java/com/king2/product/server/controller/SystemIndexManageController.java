package com.king2.product.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.service.SystemIndexManageService;
import com.king2.product.server.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/*=======================================================
	说明:    商城系统首页Controller

	作者		时间					注释
  	俞烨		2019.08.24   			创建
=======================================================*/
@RestController
@RequestMapping("/shop")
@CrossOrigin
@Validated
public class SystemIndexManageController {

    // 注入商品首页Service
    @Autowired
    private SystemIndexManageService systemIndexManageService;


    /**
     * -----------------------------------------------------
     * 功能:  商城系统的首页
     * <p>
     * 参数:
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @GetMapping("/index")
    public SystemResult index(HttpServletRequest request) {

        // 获取用户数据
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = systemIndexManageService.systemIndex(k2MemberAndElseInfo);
        return result;
    }


}
