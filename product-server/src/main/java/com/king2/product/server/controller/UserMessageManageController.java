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
	说明:    用户信息管理Controller

	作者		时间					注释
  	俞烨		2019.08.25   			创建
=======================================================*/
@RestController
@CrossOrigin
@RequestMapping("/user/message")
@Validated
public class UserMessageManageController {

    // 注入用户消息Service
    @Autowired
    private UserMessageService userMessageService;

    /**
     * -----------------------------------------------------
     * 功能:  修改信息的状态
     * <p>
     * 参数:
     * messageId            String          需要修改的信息id
     * messageState         String          需要修改的信息状态
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/edit/state")
    public SystemResult editState(HttpServletRequest request,
                                  @NotBlank(message = "消息id不能为空") @Pattern(regexp = "[0-9]{1,}") String messageId,
                                  @NotBlank(message = "消息状态不能为空") @Pattern(regexp = "[0-9]{1,}") String messageState) {

        // 获取用户数据
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = userMessageService.messageRead(Integer.parseInt(messageId), k2MemberAndElseInfo, messageState);
        return result;
    }


    /**
     * -----------------------------------------------------
     * 功能:  清空或已读消息
     * <p>
     * 参数:
     * state         String             本次操作的状态
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/clear/or/read")
    public SystemResult clearOrRead(HttpServletRequest request,
                                    @NotBlank(message = "消息不能为空")
                                    @Pattern(regexp = "[0-9]{1,}") String state) {

        // 获取用户数据
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = userMessageService.clearOrReadMessage(state, k2MemberAndElseInfo.getK2Member().getMemberId());
        return result;
    }

    /**
     * 获取用户信息的状态
     *
     * @param request
     * @return
     */
    @GetMapping("/get/state")
    public SystemResult getState(HttpServletRequest request) {
        // 获取用户数据
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");

        // 获取未读的信息
        List<K2Message> wd = UserMessageAppoint.getMessageByType(k2MemberAndElseInfo.getK2Member().getMemberId(), "WD");
        if (!CollectionUtils.isEmpty(wd)) {
            return new SystemResult("yes");
        }
        return new SystemResult("no");
    }
}
