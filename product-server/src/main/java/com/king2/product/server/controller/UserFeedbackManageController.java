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
	说明:    用户反馈管理Controller

	作者		时间					注释
  	俞烨		2019.08.31   			创建
=======================================================*/
@RestController
@RequestMapping("/feedback")
@Validated
public class UserFeedbackManageController {

    // 注入用户反馈Service
    @Autowired
    private UserFeedbackManageService userFeedbackManageService;

    /**
     * -----------------------------------------------------
     * 功能: 用户反馈的首页信息
     * <p>
     * 参数:
     * indexDto         UserFeedbackIndexDto        分页数据
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/index")
    public SystemResult index(@Validated UserFeedbackIndexDto indexDto, HttpServletRequest request) {
        // 用户信息
        K2MemberAndElseInfo userInfoByRequest = getUserInfoByRequest(request);
        SystemResult index = userFeedbackManageService.index(userInfoByRequest, indexDto);
        return index;
    }

    /**
     * -----------------------------------------------------
     * 功能: 回复反馈的信息
     * <p>
     * 参数:
     * content         String        回复的消息
     * feedbackId        String       回复的反馈id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/reply")
    public SystemResult reply(@NotBlank(message = "回复的内容不能为空") String content,
                              @NotBlank(message = "反馈的id不能为空") @Pattern(regexp = "[0-9]{1,}", message = "反馈的id类型错误") String feedbackId,
                              HttpServletRequest request) {
        // 用户信息
        K2MemberAndElseInfo userInfoByRequest = getUserInfoByRequest(request);
        SystemResult index = userFeedbackManageService.readUserFeedBack(Integer.parseInt(feedbackId), userInfoByRequest, content);
        return index;
    }

    /**
     * -----------------------------------------------------
     * 功能: 获取反馈的回复信息
     * <p>
     * 参数:
     * feedbackId        String       回复的反馈id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/get/reply/content")
    public SystemResult getReplayContent(
            @NotBlank(message = "反馈的id不能为空") @Pattern(regexp = "[0-9]{1,}", message = "反馈的id类型错误") String feedbackId,
            HttpServletRequest request) {
        // 用户信息
        K2MemberAndElseInfo userInfoByRequest = getUserInfoByRequest(request);
        SystemResult index = userFeedbackManageService.getReplyInfo(Integer.parseInt(feedbackId), userInfoByRequest);
        return index;
    }


    /**
     * -----------------------------------------------------
     * 功能: 获取反馈的附件
     * <p>
     * 参数:
     * feedbackId        String       反馈id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/get/accessory")
    public SystemResult getAccessoryInfo(
            @NotBlank(message = "反馈的id不能为空") @Pattern(regexp = "[0-9]{1,}", message = "反馈的id类型错误") String feedbackId,
            HttpServletRequest request) {
        // 用户信息
        K2MemberAndElseInfo userInfoByRequest = getUserInfoByRequest(request);
        SystemResult index = userFeedbackManageService.getFeedbackAccessory(Integer.parseInt(feedbackId), userInfoByRequest);
        return index;
    }


    /**
     * -----------------------------------------------------
     * 功能: 删除反馈信息
     * <p>
     * 参数:
     * feedbackId        String       反馈id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/del")
    public SystemResult del(
            @NotBlank(message = "反馈的id不能为空") @Pattern(regexp = "[0-9]{1,}", message = "反馈的id类型错误") String feedbackId,
            HttpServletRequest request) {
        // 用户信息
        K2MemberAndElseInfo userInfoByRequest = getUserInfoByRequest(request);
        SystemResult index = userFeedbackManageService.delFeedback(Integer.parseInt(feedbackId), userInfoByRequest);
        return index;
    }

    // 获取用户信息
    public static K2MemberAndElseInfo getUserInfoByRequest(HttpServletRequest request) {
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        return k2MemberAndElseInfo;
    }
}
