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
public class UserChatInfoManageController {

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

    @RequestMapping("/send/message")
    public SystemResult sendMessage(HttpServletRequest request, Integer receiveId, String message) {

        // 获取用户数据
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = userCharInfoManageService.sendChatInfo(k2MemberAndElseInfo, receiveId, message);
        /*// 获取用户数据
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        // 获取用户全部新的数据
        SystemResult newCharInfoAll = UserCharInfoManageServiceImpl.getNewCharInfoAll(receiveId);
        ConcurrentHashMap<String, List<UserCharInfoPojo>> newChatInfo =
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) newCharInfoAll.getData();

        if (CollectionUtils.isEmpty(newChatInfo)) {
            newChatInfo = new ConcurrentHashMap<>();
        }

        List<UserCharInfoPojo> userCharInfoPojos = null;
        if (newChatInfo.containsKey
                (UserCharInfoManageServiceImpl.USER_CHAR_INFO_KEY + "_" +
                        receiveId + "_" + k2MemberAndElseInfo.getK2Member().getMemberId())) {
            // 存在就取出
            userCharInfoPojos = newChatInfo.get(UserCharInfoManageServiceImpl.USER_CHAR_INFO_KEY + "_" +

                    receiveId + "_" + k2MemberAndElseInfo.getK2Member().getMemberId());
        } else {
            userCharInfoPojos = new LinkedList<>();
        }

        UserCharInfoPojo pojo = new UserCharInfoPojo();
        pojo.setChaoInfoMessage(message);
        pojo.setCharId(123123);
        pojo.setCreateTime(new Date());
        pojo.setImage(receiveId == 1 ?
                "http://39.105.41.2:9000/king2-product-image/king2-BRAND-LOGO-SP7FD5F6064FF9907DD1A16D0FE8EB593295.jpg" :
                "http://39.105.41.2:9000/king2-product-image/king2-BRAND-LOGO-SP6FB4BB1542D59224599FB3313E80254051.png");

        pojo.setName(receiveId == 1 ? "子青" : "鹿七七");
        pojo.setReceiveUserId(receiveId);
        pojo.setSendUserId(k2MemberAndElseInfo.getK2Member().getMemberId());
        pojo.setState(1);
        userCharInfoPojos.add(0,pojo);
        newChatInfo.put(UserCharInfoManageServiceImpl.USER_CHAR_INFO_KEY + "_" +
                receiveId + "_" + k2MemberAndElseInfo.getK2Member().getMemberId(), userCharInfoPojos);
        // 重新写入
        UserCharInfoCacheManage.getInstance().getNewMessageDatas().put(UserCharInfoManageServiceImpl.USER_CHAR_INFO_KEY + "_" + receiveId, newChatInfo);*/
        return result;
    }

    @RequestMapping("/get")
    public SystemResult get(HttpServletRequest request , Integer getId) {
        // 获取用户数据
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult chatInfoByGetId = userCharInfoManageService.getChatInfoByGetId(getId, k2MemberAndElseInfo);
        return chatInfoByGetId;
    }
}
