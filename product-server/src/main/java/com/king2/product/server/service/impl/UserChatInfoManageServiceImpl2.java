package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2MemberMapper;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.UserChatInfoManageAppoint;
import com.king2.product.server.dto.UserCharInfoDto;
import com.king2.product.server.dto.UserChatCacheInfoDto;
import com.king2.product.server.pojo.UserCharHtmlDataPojo;
import com.king2.product.server.pojo.UserCharInfoPojo;
import com.king2.product.server.service.UserChatInfoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserChatInfoManageServiceImpl2 implements UserChatInfoManageService {

    // 注入用户管理Mapper
    @Autowired
    private K2MemberMapper k2MemberMapper;

    /**
     * -----------------------------------------------------
     * 功能:  获取用户的全部信息
     * <p>
     * 参数:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         操作的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo) {

        // 创建显示的数据结构
        UserCharInfoDto charInfoDto = new UserCharInfoDto();

        // 获取该用户的所有消息集合
        ConcurrentHashMap<String, UserChatCacheInfoDto> chatInfoAllById =
                UserChatInfoManageAppoint.getChatInfoAllById(k2MemberAndElseInfo.getK2Member().getMemberId());

        if (!CollectionUtils.isEmpty(chatInfoAllById)) {
            List<UserCharHtmlDataPojo> newPojo = new ArrayList<>();
            List<UserCharHtmlDataPojo> oldPojo = new ArrayList<>();

            for (Map.Entry<String, UserChatCacheInfoDto> entry : chatInfoAllById.entrySet()) {
                boolean empty = CollectionUtils.isEmpty(entry.getValue().getNewChatInfos());
                UserCharHtmlDataPojo pojo = new UserCharHtmlDataPojo();
                UserCharInfoPojo infoPojo =
                        !empty ? entry.getValue().getNewChatInfos().get(entry.getValue().getNewChatInfos().size() - 1)
                                : entry.getValue().getOldChatInfos().get(entry.getValue().getOldChatInfos().size() - 1);

                pojo.setTime(UserChatInfoManageServiceImpl.sdf.format(infoPojo.getCreateTime()));
                pojo.setUserId(
                        k2MemberAndElseInfo.getK2Member().getMemberId().toString()
                                .equals(infoPojo.getReceiveUserId().toString()) ? infoPojo.getSendUserId() : infoPojo.getReceiveUserId());
                pojo.setImage(infoPojo.getReImage());
                pojo.setNotReadSize(entry.getValue().getNewChatInfos().size());
                pojo.setName(infoPojo.getReName());
                pojo.setContent(infoPojo.getChaoInfoMessage());
                if (!empty) {
                    newPojo.add(pojo);
                } else {
                    oldPojo.add(pojo);
                }
            }
//            chatInfoAllById.forEach((k, v) -> {
//                boolean empty = CollectionUtils.isEmpty(v.getNewChatInfos());
//
//            });

            charInfoDto.setOldCharInfo(oldPojo);
            charInfoDto.setNewCharInfo(newPojo);
        }
        return new SystemResult(charInfoDto);
    }


    public SystemResult get(Integer getId, K2MemberAndElseInfo k2MemberAndElseInfo) {
        // 获取该用户的所有消息集合
        ConcurrentHashMap<String, UserChatCacheInfoDto> chatInfoAllById =
                UserChatInfoManageAppoint.getChatInfoAllById(k2MemberAndElseInfo.getK2Member().getMemberId());

        // 返回的数据结构
        List<UserCharInfoPojo> pojos = null;

        // 取出需要查询的getId的信息
        UserChatCacheInfoDto userInfoById = UserChatInfoManageAppoint.getUserInfoById(chatInfoAllById, k2MemberAndElseInfo.getK2Member().getMemberId(), getId);
        if (!CollectionUtils.isEmpty(userInfoById.getNewChatInfos())) {
            // 将新的消息 存入历史消息中
            userInfoById.getOldChatInfos().addAll(userInfoById.getNewChatInfos());
            // 并排序
            pojos = userInfoById.getOldChatInfos();
            Collections.sort(pojos);
            // 排序完成后 将新消息重新写入缓存结构里
            userInfoById.setNewChatInfos(new ArrayList<>());
            chatInfoAllById.put(UserChatInfoManageAppoint.CHAT_INFO_CHCHE_KEY + "_" + getId, userInfoById);
            UserChatInfoManageAppoint.writeChatInfoAllById(k2MemberAndElseInfo.getK2Member().getMemberId(), chatInfoAllById);
        } else {
            pojos = userInfoById.getOldChatInfos();
        }
        return new SystemResult(pojos);
    }

    /**
     * -----------------------------------------------------
     * 功能:  发送消息
     * <p>
     * 参数:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         操作的用户信息
     * receiverId                   Integer                     接收人的id
     * message                      String                      消息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public SystemResult sendMessage(Integer receiverId, K2MemberAndElseInfo k2MemberAndElseInfo, String message) {

        // 校验本次发送的数据是否过长或者超出一定的大小
        Boolean aBoolean = UserChatInfoManageAppoint.checkMessageIfPass(message);
        if (!aBoolean) return new SystemResult("发送信息数据量不符合规定，通常在1-200字符");

        K2Member member = k2MemberMapper.selectByPrimaryKey(receiverId);
        if (member == null) return new SystemResult(100, "用户不存在");

        // 将新消息写入接收者的新消息里
        newChatInfoGotoWriteReceiveNewChatInfoData(message, member, k2MemberAndElseInfo.getK2Member(), "new");

        // 将新消息写入发送者的旧消息里
        newChatInfoGotoWriteReceiveNewChatInfoData(message, member, k2MemberAndElseInfo.getK2Member(), "old");

        return new SystemResult("ok");
    }

    /**
     * 将新消息写入接收者的新消息里
     *
     * @param message
     * @param reMember
     * @param sendMember
     */
    public static void newChatInfoGotoWriteReceiveNewChatInfoData(String message, K2Member reMember, K2Member sendMember, String type) {
        // 取出接收者的所有信息
        ConcurrentHashMap<String, UserChatCacheInfoDto> chatInfoAllById =
                UserChatInfoManageAppoint.getChatInfoAllById(reMember.getMemberId());

        // 取出该发送者存在接收者里的消息结构
        UserChatCacheInfoDto userInfoById =
                UserChatInfoManageAppoint.getUserInfoById(chatInfoAllById, reMember.getMemberId(), sendMember.getMemberId());

        // 取出新的消息
        List<UserCharInfoPojo> chatInfos = null;
        if ("new".equals(type)) {
            chatInfos = userInfoById.getNewChatInfos();
        } else {
            chatInfos = userInfoById.getOldChatInfos();
        }


        // 补全消息
        UserCharInfoPojo pojo = new UserCharInfoPojo();
        pojo.setReImage("new".equals(type) ? sendMember.getMemberName() : reMember.getMemberName());
        pojo.setImage("new".equals(type) ? sendMember.getMemberPortrait() : reMember.getMemberPortrait());
        pojo.setName("new".equals(type) ? sendMember.getMemberName() : reMember.getMemberName());
        pojo.setReName("new".equals(type) ? reMember.getMemberName() : sendMember.getMemberName());
        pojo.setFlag("old".equals(type));
        pojo.setChaoInfoMessage(message);
        pojo.setCreateTime(new Date());
        pojo.setReceiveUserId(reMember.getMemberId());
        pojo.setSendUserId(sendMember.getMemberId());
        chatInfos.add(pojo);
        // 重新写回缓存
        if ("new".equals(type)) {
            userInfoById.setNewChatInfos(chatInfos);
        } else {
            userInfoById.setOldChatInfos(chatInfos);
        }

        chatInfoAllById.put(UserChatInfoManageAppoint.CHAT_INFO_CHCHE_KEY + "_" + ("new".equals(type) ? sendMember.getMemberId() : reMember.getMemberId()), userInfoById);
        UserChatInfoManageAppoint.writeChatInfoAllById(("new".equals(type) ? sendMember.getMemberId() : reMember.getMemberId()), chatInfoAllById);
    }

}
