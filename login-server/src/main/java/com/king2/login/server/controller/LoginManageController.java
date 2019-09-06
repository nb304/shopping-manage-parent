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
	˵��:    �û��������Controller

	����		ʱ��					ע��
  	����		2019.09.06   		����
=======================================================*/
@RestController
@RequestMapping("/member")
@Validated
@CrossOrigin
public class LoginManageController {

    // ע���û�����Service
    @Autowired
    private LoginManageService loginManageService;

    /**
     * -----------------------------------------------------
     * ����:  ��ʾ��ƷƷ�Ƶ���ҳ
     * <p>
     * ����:
     * username         String          �û���
     * password         String          ����
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/login")
    public SystemResult login(@NotBlank(message = "�û�������Ϊ��")
                              @Length(max = 11, message = "�û�������") String username,
                              @NotBlank(message = "���벻��Ϊ��") String password,
                              HttpServletRequest request,
                              @NotBlank(message = "��֤�벻��Ϊ��")
                              @Length(max = 4, min = 4, message = "��֤�����") String code) throws Exception {


        // ����service
        SystemResult login = loginManageService.login(username, password, request, code);
        if (login.getStatus() == 200 || login.getStatus() == 201) {
            // ˵������ɹ�
            // ��Ҫд��Cookie��Ϣ
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
     * ����:  ������֤��
     * <p>
     * ����:
     * <p>
     * ����: String              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/code")
    public String set(HttpServletRequest request) throws IOException {

        // ��ȡ����֤��Ļ���ṹ
        ConcurrentHashMap<String, String> codeHashMap = UserLoginCacheManage2.getInstance().getCodeHashMap();
        // ��֤��
        StringBuffer code = new StringBuffer();
        // ��֤���һ����
        String codeOne = new Date().getTime() + "";
        code.append((codeOne).substring(codeOne.length() - 2));
        // ��֤��ڶ�����
        String codeTwo = UUID.randomUUID().toString();
        code.append((codeTwo).substring(codeTwo.length() - 2));
        // ���뻺��ṹ�� ��Ϊ������ʵ��Session���� �ý����ڻ��湤��
        codeHashMap.put(NetworkUtil.getHostIpAddress(request), code.toString());
        return code.toString().toUpperCase();
    }
}
