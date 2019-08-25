package com.king2.product.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2Message;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.UserMessageAppoint;
import com.king2.product.server.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

/*=======================================================
	˵��:    �û���Ϣ����Controller

	����		ʱ��					ע��
  	����		2019.08.25   			����
=======================================================*/
@RestController
@CrossOrigin
@RequestMapping("/user/message")
@Validated
public class UserMessageManageController {

    // ע���û���ϢService
    @Autowired
    private UserMessageService userMessageService;

    /**
     * -----------------------------------------------------
     * ����:  �޸���Ϣ��״̬
     * <p>
     * ����:
     * messageId            String          ��Ҫ�޸ĵ���Ϣid
     * messageState         String          ��Ҫ�޸ĵ���Ϣ״̬
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @PostMapping("/edit/state")
    public SystemResult editState(HttpServletRequest request,
                                  @NotBlank(message = "��Ϣid����Ϊ��") @Pattern(regexp = "[0-9]{1,}") String messageId,
                                  @NotBlank(message = "��Ϣ״̬����Ϊ��") @Pattern(regexp = "[0-9]{1,}") String messageState) {

        // ��ȡ�û�����
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = userMessageService.messageRead(Integer.parseInt(messageId), k2MemberAndElseInfo, messageState);
        return result;
    }


    /**
     * -----------------------------------------------------
     * ����:  ��ջ��Ѷ���Ϣ
     * <p>
     * ����:
     * state         String             ���β�����״̬
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @PostMapping("/clear/or/read")
    public SystemResult clearOrRead(HttpServletRequest request,
                                    @NotBlank(message = "��Ϣ����Ϊ��")
                                    @Pattern(regexp = "[0-9]{1,}") String state) {

        // ��ȡ�û�����
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = userMessageService.clearOrReadMessage(state, k2MemberAndElseInfo.getK2Member().getMemberId());
        return result;
    }

    /**
     * ��ȡ�û���Ϣ��״̬
     *
     * @param request
     * @return
     */
    @GetMapping("/get/state")
    public SystemResult getState(HttpServletRequest request) {
        // ��ȡ�û�����
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");

        // ��ȡδ������Ϣ
        List<K2Message> wd = UserMessageAppoint.getMessageByType(k2MemberAndElseInfo.getK2Member().getMemberId(), "WD");
        if (!CollectionUtils.isEmpty(wd)) {
            return new SystemResult("yes");
        }
        return new SystemResult("no");
    }
}
