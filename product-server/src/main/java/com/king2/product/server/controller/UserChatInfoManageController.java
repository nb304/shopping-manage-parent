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
	˵��:    �û������¼����Controller

	����		ʱ��					ע��
  	����		2019.08.20   			����
=======================================================*/
@RestController
@RequestMapping("/char/info")
@Validated
public class UserChatInfoManageController {

    // ע�������¼Service
    @Autowired
    private UserCharInfoManageService userCharInfoManageService;

    /**
     * -----------------------------------------------------
     * ����:  ��ʾ�����¼��ҳ ��׼������
     * <p>
     * ����:
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/index")
    public SystemResult index(HttpServletRequest request) {
        // ��ȡ�û�����
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = userCharInfoManageService.index(k2MemberAndElseInfo);
        return index;
    }

    @RequestMapping("/send/message")
    public SystemResult sendMessage(HttpServletRequest request, Integer receiveId, String message) {

        // ��ȡ�û�����
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = userCharInfoManageService.sendChatInfo(k2MemberAndElseInfo, receiveId, message);
        /*// ��ȡ�û�����
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        // ��ȡ�û�ȫ���µ�����
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
            // ���ھ�ȡ��
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

        pojo.setName(receiveId == 1 ? "����" : "¹����");
        pojo.setReceiveUserId(receiveId);
        pojo.setSendUserId(k2MemberAndElseInfo.getK2Member().getMemberId());
        pojo.setState(1);
        userCharInfoPojos.add(0,pojo);
        newChatInfo.put(UserCharInfoManageServiceImpl.USER_CHAR_INFO_KEY + "_" +
                receiveId + "_" + k2MemberAndElseInfo.getK2Member().getMemberId(), userCharInfoPojos);
        // ����д��
        UserCharInfoCacheManage.getInstance().getNewMessageDatas().put(UserCharInfoManageServiceImpl.USER_CHAR_INFO_KEY + "_" + receiveId, newChatInfo);*/
        return result;
    }

    @RequestMapping("/get")
    public SystemResult get(HttpServletRequest request , Integer getId) {
        // ��ȡ�û�����
        K2MemberAndElseInfo k2MemberAndElseInfo = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult chatInfoByGetId = userCharInfoManageService.getChatInfoByGetId(getId, k2MemberAndElseInfo);
        return chatInfoByGetId;
    }
}
