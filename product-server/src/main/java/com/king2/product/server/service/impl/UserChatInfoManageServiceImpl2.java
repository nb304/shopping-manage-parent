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

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@SuppressWarnings("all")
public class UserChatInfoManageServiceImpl2 implements UserChatInfoManageService {

    // 注入用户管理Mapper
    @Autowired
    private K2MemberMapper k2MemberMapper;

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

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


        // 取得该登录的用户全部的消息集合
        ConcurrentHashMap<String, UserChatCacheInfoDto> chatInfoAllById =
                UserChatInfoManageAppoint.getChatInfoAllById(k2MemberAndElseInfo.getK2Member().getMemberId());

        // 判断数据集合是否存在数据信息
        if (!CollectionUtils.isEmpty(chatInfoAllById)) {
            List<UserCharHtmlDataPojo> newPojo = new ArrayList<>();
            List<UserCharHtmlDataPojo> oldPojo = new ArrayList<>();

            // 遍历数据集合,取得数据信息
            for (Map.Entry<String, UserChatCacheInfoDto> map : chatInfoAllById.entrySet()) {
                // 本次的新消息数据
                List<UserCharInfoPojo> newChatInfos = map.getValue().getNewChatInfos();
                if (!CollectionUtils.isEmpty(newChatInfos)) {
                    // 不等于空的话 说明只要操作新数据信息就行了  旧的数据信息就可以不用操作了
                    // 要问为什么？？？  你觉得有人给你发了新的消息 你在好友列表里 能看到旧消息吗？

                    // 获取最后一个新的消息
                    UserCharInfoPojo charInfoPojo = newChatInfos.get(newChatInfos.size() - 1);
                    UserCharHtmlDataPojo htmlDataPojo = charInfoPojo.getHtmlDataPojo();
                    // 注入信息
                    htmlDataPojo.setTime(UserChatInfoManageServiceImpl.sdf.format(charInfoPojo.getCreateTime()));
                    htmlDataPojo.setContent(charInfoPojo.getChaoInfoMessage());
                    htmlDataPojo.setNotReadSize(newChatInfos.size());
                    // 填入新的消息
                    newPojo.add(htmlDataPojo);
                } else {
                    // 说明没有新的消息 取出旧消息就行了
                    List<UserCharInfoPojo> oldChatInfos = map.getValue().getOldChatInfos();
                    // 最后一条旧消息
                    UserCharInfoPojo charInfoPojo = oldChatInfos.get(oldChatInfos.size() - 1);
                    UserCharHtmlDataPojo htmlDataPojo = charInfoPojo.getHtmlDataPojo();
                    // 注入信息
                    htmlDataPojo.setNotReadSize(null);
                    htmlDataPojo.setTime(UserChatInfoManageServiceImpl.sdf.format(charInfoPojo.getCreateTime()));
                    htmlDataPojo.setContent(charInfoPojo.getChaoInfoMessage());
                    oldPojo.add(htmlDataPojo);
                }
            }

            charInfoDto.setNewCharInfo(newPojo);
            charInfoDto.setOldCharInfo(oldPojo);
        }


        /*// 获取该用户的所有消息集合
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
        }*/
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
        goGoMessageNewInfo(message, k2MemberAndElseInfo.getK2Member(), member, true);

        // 将新消息写入发送者的旧消息里
        goGoMessageOldInfo(message, k2MemberAndElseInfo.getK2Member(), member, true);

        return new SystemResult("ok");
    }

    public static void goGoMessageOldInfo(String message, K2Member sendMember, K2Member reMember, boolean flag) {

        // 将发送的消息存入发送者的旧消息数据集合中去
        // 取得发送者在这个系统缓存里与全部人的聊天信息
        ConcurrentHashMap<String, UserChatCacheInfoDto> sendMemberAllInfo =
                UserChatInfoManageAppoint.getChatInfoAllById(sendMember.getMemberId());

        // 取得发送者和接收者的消息数据
        // 将发送者的全部信息数据集合(reMemberAllInfo) 通过接收者的ID进行筛选
        // 就能筛选出该发送者和接收者的全部信息  全部信息包含
        // (newInfo新消息数据集合)、(oldInfo旧消息数据集合)
        UserChatCacheInfoDto sendMemberDuiReMemberAllInfo =
                UserChatInfoManageAppoint.getUserInfoById(sendMemberAllInfo, sendMember.getMemberId(), reMember.getMemberId());

        // 取出该发送者的旧消息
        // 这里的旧消息指的是 发送者与接收者的旧消息数据集合
        List<UserCharInfoPojo> oldChatInfos = sendMemberDuiReMemberAllInfo.getOldChatInfos();


        // 填写本次发送的数据信息
        UserCharInfoPojo charInfoPojo = new UserCharInfoPojo();
        charInfoPojo.setChaoInfoMessage(message);
        charInfoPojo.setReceiveUserId(reMember.getMemberId());
        charInfoPojo.setSendUserId(sendMember.getMemberId());
        charInfoPojo.setImage(sendMember.getMemberPortrait());
        charInfoPojo.setCreateTime(new Date());
        charInfoPojo.setReName(reMember.getMemberName());
        charInfoPojo.setName(sendMember.getMemberName());
        charInfoPojo.setReImage(reMember.getMemberPortrait());
        charInfoPojo.setCreateTimeStr(sdf.format(charInfoPojo.getCreateTime()));
        charInfoPojo.setFlag(true);
        UserCharHtmlDataPojo htmlDataPojo = new UserCharHtmlDataPojo();
        htmlDataPojo.setName(reMember.getMemberName());
        htmlDataPojo.setImage(reMember.getMemberPortrait());
        htmlDataPojo.setCreateTime(new Date());
        htmlDataPojo.setUserId(reMember.getMemberId());
        charInfoPojo.setHtmlDataPojo(htmlDataPojo);

        // 将数据重新写入发送者的旧消息数据集合中
        oldChatInfos.add(charInfoPojo);
        sendMemberDuiReMemberAllInfo.setOldChatInfos(oldChatInfos);

        // 将数据重新写入接收者的全部数据集合中
        sendMemberAllInfo.put(UserChatInfoManageAppoint.CHAT_INFO_CHCHE_KEY + "_" + reMember.getMemberId(), sendMemberDuiReMemberAllInfo);
        UserChatInfoManageAppoint.writeChatInfoAllById(sendMember.getMemberId(), sendMemberAllInfo);
    }

    /**
     * 将新消息存入接收者的新数据集合中去
     *
     * @param message
     * @param sendMember
     * @param reMember
     * @param flag
     */
    public static void goGoMessageNewInfo(String message, K2Member sendMember, K2Member reMember, boolean flag) {

        // 需要将发送者发出的消息 存入接收者的新消息数据中
        // 然后将发送者的小心 存入发送者的旧消息数据中


        // 取得了接收者全部的消息
        // 这里的全部消息指的是 接收者在这个系统里与全部人的消息集合
        ConcurrentHashMap<String, UserChatCacheInfoDto> reMemberAllInfo =
                UserChatInfoManageAppoint.getChatInfoAllById(reMember.getMemberId());

        // 取得接收者和发送者的消息数据
        // 将接收者的全部信息数据集合(reMemberAllInfo) 通过发送者的ID进行筛选
        // 就能筛选出该接收者和发送者的全部信息  全部信息包含
        // (newInfo新消息数据集合)、(oldInfo旧消息数据集合)
        UserChatCacheInfoDto reMemberDuiSendMemberAllInfo =
                UserChatInfoManageAppoint.getUserInfoById(reMemberAllInfo, reMember.getMemberId(), sendMember.getMemberId());

        // 取出该接收者的新消息
        // 这里的新新消息指的是 接收者没有查看的新消息数据集合
        List<UserCharInfoPojo> newChatInfos = reMemberDuiSendMemberAllInfo.getNewChatInfos();

        // 填写本次发送的数据信息
        UserCharInfoPojo charInfoPojo = new UserCharInfoPojo();
        charInfoPojo.setChaoInfoMessage(message);
        charInfoPojo.setReceiveUserId(reMember.getMemberId());
        charInfoPojo.setSendUserId(sendMember.getMemberId());
        charInfoPojo.setImage(sendMember.getMemberPortrait());
        charInfoPojo.setCreateTime(new Date());
        charInfoPojo.setReName(reMember.getMemberName());
        charInfoPojo.setCreateTimeStr(sdf.format(charInfoPojo.getCreateTime()));
        charInfoPojo.setName(sendMember.getMemberName());
        charInfoPojo.setReImage(reMember.getMemberPortrait());
        charInfoPojo.setFlag(false);
        UserCharHtmlDataPojo htmlDataPojo = new UserCharHtmlDataPojo();
        htmlDataPojo.setName(sendMember.getMemberName());
        htmlDataPojo.setImage(sendMember.getMemberPortrait());
        htmlDataPojo.setCreateTime(new Date());
        htmlDataPojo.setUserId(sendMember.getMemberId());
        charInfoPojo.setHtmlDataPojo(htmlDataPojo);

        // 将数据重新写入新消息数据集合中
        newChatInfos.add(charInfoPojo);
        reMemberDuiSendMemberAllInfo.setNewChatInfos(newChatInfos);

        // 将数据重新写入接收者的全部数据集合中
        reMemberAllInfo.put(UserChatInfoManageAppoint.CHAT_INFO_CHCHE_KEY + "_" + sendMember.getMemberId(), reMemberDuiSendMemberAllInfo);
        UserChatInfoManageAppoint.writeChatInfoAllById(reMember.getMemberId(), reMemberAllInfo);
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
