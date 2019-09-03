package com.king2.product.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.UserFeedbackIndexDto;
import com.king2.product.server.service.UserFeedbackManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*=======================================================
	˵��:    �û���������Controller

	����		ʱ��					ע��
  	����		2019.08.31   			����
=======================================================*/
@RestController
@RequestMapping("/feedback")
@Validated
public class UserFeedbackManageController {

    // ע���û�����Service
    @Autowired
    private UserFeedbackManageService userFeedbackManageService;

    /**
     * -----------------------------------------------------
     * ����: �û���������ҳ��Ϣ
     * <p>
     * ����:
     * indexDto         UserFeedbackIndexDto        ��ҳ����
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/index")
    public SystemResult index(@Validated UserFeedbackIndexDto indexDto, HttpServletRequest request) {
        // �û���Ϣ
        K2MemberAndElseInfo userInfoByRequest = getUserInfoByRequest(request);
        SystemResult index = userFeedbackManageService.index(userInfoByRequest, indexDto);
        return index;
    }

    /**
     * -----------------------------------------------------
     * ����: �ظ���������Ϣ
     * <p>
     * ����:
     * content         String        �ظ�����Ϣ
     * feedbackId        String       �ظ��ķ���id
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/reply")
    public SystemResult reply(@NotBlank(message = "�ظ������ݲ���Ϊ��") String content,
                              @NotBlank(message = "������id����Ϊ��") @Pattern(regexp = "[0-9]{1,}", message = "������id���ʹ���") String feedbackId,
                              HttpServletRequest request) {
        // �û���Ϣ
        K2MemberAndElseInfo userInfoByRequest = getUserInfoByRequest(request);
        SystemResult index = userFeedbackManageService.readUserFeedBack(Integer.parseInt(feedbackId), userInfoByRequest, content);
        return index;
    }

    /**
     * -----------------------------------------------------
     * ����: ��ȡ�����Ļظ���Ϣ
     * <p>
     * ����:
     * feedbackId        String       �ظ��ķ���id
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/get/reply/content")
    public SystemResult getReplayContent(
            @NotBlank(message = "������id����Ϊ��") @Pattern(regexp = "[0-9]{1,}", message = "������id���ʹ���") String feedbackId,
            HttpServletRequest request) {
        // �û���Ϣ
        K2MemberAndElseInfo userInfoByRequest = getUserInfoByRequest(request);
        SystemResult index = userFeedbackManageService.getReplyInfo(Integer.parseInt(feedbackId), userInfoByRequest);
        return index;
    }


    /**
     * -----------------------------------------------------
     * ����: ��ȡ�����ĸ���
     * <p>
     * ����:
     * feedbackId        String       ����id
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/get/accessory")
    public SystemResult getAccessoryInfo(
            @NotBlank(message = "������id����Ϊ��") @Pattern(regexp = "[0-9]{1,}", message = "������id���ʹ���") String feedbackId,
            HttpServletRequest request) {
        // �û���Ϣ
        K2MemberAndElseInfo userInfoByRequest = getUserInfoByRequest(request);
        SystemResult index = userFeedbackManageService.getFeedbackAccessory(Integer.parseInt(feedbackId), userInfoByRequest);
        return index;
    }


    /**
     * -----------------------------------------------------
     * ����: ɾ��������Ϣ
     * <p>
     * ����:
     * feedbackId        String       ����id
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/del")
    public SystemResult del(
            @NotBlank(message = "������id����Ϊ��") @Pattern(regexp = "[0-9]{1,}", message = "������id���ʹ���") String feedbackId,
            HttpServletRequest request) {
        // �û���Ϣ
        K2MemberAndElseInfo userInfoByRequest = getUserInfoByRequest(request);
        SystemResult index = userFeedbackManageService.delFeedback(Integer.parseInt(feedbackId), userInfoByRequest);
        return index;
    }

    // ��ȡ�û���Ϣ
    public static K2MemberAndElseInfo getUserInfoByRequest(HttpServletRequest request) {
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        return k2MemberAndElseInfo;
    }
}
