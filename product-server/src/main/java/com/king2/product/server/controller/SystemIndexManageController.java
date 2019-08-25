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
	˵��:    �̳�ϵͳ��ҳController

	����		ʱ��					ע��
  	����		2019.08.24   			����
=======================================================*/
@RestController
@RequestMapping("/shop")
@CrossOrigin
@Validated
public class SystemIndexManageController {

    // ע����Ʒ��ҳService
    @Autowired
    private SystemIndexManageService systemIndexManageService;


    /**
     * -----------------------------------------------------
     * ����:  �̳�ϵͳ����ҳ
     * <p>
     * ����:
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @GetMapping("/index")
    public SystemResult index(HttpServletRequest request) {

        // ��ȡ�û�����
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = systemIndexManageService.systemIndex(k2MemberAndElseInfo);
        return result;
    }


}
