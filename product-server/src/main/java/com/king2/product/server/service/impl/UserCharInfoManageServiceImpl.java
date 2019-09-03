package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2MemberMapper;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.cache.UserCharInfoCacheManage;
import com.king2.product.server.dto.UserCharInfoDto;
import com.king2.product.server.enmu.UserChatInfoStateEnum;
import com.king2.product.server.pojo.UserCharHtmlDataPojo;
import com.king2.product.server.pojo.UserCharInfoPojo;
import com.king2.product.server.service.UserCharInfoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/*=======================================================
	说明:    用户聊天管理Service实现类

	作者		时间					注释
  	俞烨		2019.08.30   			创建
=======================================================*/
@Service
@SuppressWarnings("all")
public class UserCharInfoManageServiceImpl implements UserCharInfoManageService {

    public static final String USER_CHAR_INFO_KEY = "CHAR_INFO_KEY";
    // 注入系统成员表
    @Autowired
    private K2MemberMapper k2MemberMapper;

    /**
     * -----------------------------------------------------
     * 功能:  进入聊天界面的首页
     * <p>
     * 参数:
     * k2MemberAndElseInfo      K2MemberAndElseInfo     登入的用户信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo) {

        // 由于现在只是在读取数据 所以我们不开启锁
        // 获取该用户新的聊天信息
        SystemResult newCharInfoAll = getNewCharInfoAll(k2MemberAndElseInfo.getK2Member().getMemberId());
        SystemResult oldCharInfoAll = getOldCharInfoAll(k2MemberAndElseInfo.getK2Member().getMemberId());


        // 创建显示的数据结构
        UserCharInfoDto charInfoDto = new UserCharInfoDto();

        // 遍历新聊天记录和旧聊天记录
        ConcurrentHashMap<String, List<UserCharInfoPojo>> newCharInfo =
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) newCharInfoAll.getData();
        ConcurrentHashMap<String, List<UserCharInfoPojo>> oldCharInfo =
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) oldCharInfoAll.getData();

        // 遍历新集合
        SystemResult result = foreachChatInfoReturnDto(newCharInfo, null, false);
        charInfoDto.setNewCharInfo((List<UserCharHtmlDataPojo>) result.getData());
        // 遍历旧的聊天数据
        SystemResult result2 = foreachChatInfoReturnDto(oldCharInfo, newCharInfo, false);
        charInfoDto.setNewCharInfo((List<UserCharHtmlDataPojo>) result.getData());

        return new SystemResult(charInfoDto);
    }

    /**
     * -----------------------------------------------------
     * 功能:   发送消息
     * <p>
     * 参数:
     * k2MemberAndElseInfo      K2MemberAndElseInfo     发送者的信息
     * receiveId                Integer                 接收者的id
     * chatInfo                 String                  发送的信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult sendChatInfo(K2MemberAndElseInfo k2MemberAndElseInfo, Integer receiveId, String chatInfo) {


        // 查看接收者在系统中是否存在
        K2Member k2Member = k2MemberMapper.selectByPrimaryKey(receiveId);
        if (k2Member == null) return new SystemResult(100, "您需要发送的用户不存在,或者已被删除");

        // 取出接收者在缓存数据中的数据结构
        SystemResult newCharInfoAll = getNewCharInfoAll(receiveId);
        ConcurrentHashMap<String, List<UserCharInfoPojo>> newChatInfoMaps =  // 属于该用户的聊天记录数据结构
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) newCharInfoAll.getData();
        // 判断是否等于空
        if (CollectionUtils.isEmpty(newChatInfoMaps)) {
            newChatInfoMaps = new ConcurrentHashMap<String, List<UserCharInfoPojo>>();
        }
        // 取出该发送者的信息
        List<UserCharInfoPojo> charInfoPojos = null;
        String sendUserKey = USER_CHAR_INFO_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId();
        if (newChatInfoMaps.containsKey(sendUserKey)) {
            charInfoPojos = newChatInfoMaps.get(sendUserKey);
        }
        // 判断发送者的信息是否为空
        if (CollectionUtils.isEmpty(charInfoPojos)) {
            charInfoPojos = new ArrayList<>();
        }

        // 补全信息
        UserCharInfoPojo pojo = new UserCharInfoPojo();
        pojo.setState(UserChatInfoStateEnum.ZC.getValue());
        pojo.setSendUserId(k2MemberAndElseInfo.getK2Member().getMemberId());
        pojo.setReceiveUserId(receiveId);
        pojo.setName(k2MemberAndElseInfo.getK2Member().getMemberName());
        pojo.setCreateTime(new Date());
        pojo.setChaoInfoMessage(chatInfo);
        pojo.setCharId(123);
        charInfoPojos.add(pojo);
        newChatInfoMaps.put(sendUserKey, charInfoPojos);

        // 发送成功
        return new SystemResult("ok");
    }

    /**
     * 遍历消息集合返回Dto的数据
     *
     * @param chatInfo
     * @param newChatInfo
     * @param sFlag
     * @return
     */
    public static SystemResult foreachChatInfoReturnDto(
            ConcurrentHashMap<String, List<UserCharInfoPojo>> chatInfo,
            ConcurrentHashMap<String, List<UserCharInfoPojo>> newChatInfo
            , boolean sFlag) {

        // 创建返回的集合数据
        if (!CollectionUtils.isEmpty(chatInfo)) {
            List<UserCharHtmlDataPojo> dataPojos = new ArrayList<>();
            for (Map.Entry<String, List<UserCharInfoPojo>> entry : chatInfo.entrySet()) {
                if (CollectionUtils.isEmpty(entry.getValue())) continue;
                if (sFlag) {
                    if (CollectionUtils.isEmpty(entry.getValue())) {
                        continue;
                    } else if (!CollectionUtils.isEmpty(newChatInfo) && newChatInfo.containsKey(entry.getKey())) {
                        continue;
                    }
                }
                UserCharHtmlDataPojo pojo = new UserCharHtmlDataPojo();
                // 设置聊天信息
                pojo.setContent(entry.getValue().get(0).getChaoInfoMessage());
                pojo.setImage(entry.getValue().get(0).getImage());
                pojo.setName(entry.getValue().get(0).getName());
                pojo.setNotReadSize(entry.getValue().size());
                pojo.setUserId(entry.getValue().get(0).getSendUserId());
                dataPojos.add(pojo);
            }
            return new SystemResult(dataPojos);
        }
        return new SystemResult();
    }

    /**
     * 通过用户id获取该用户全部的新聊天信息
     *
     * @param userId
     * @return
     */
    public static SystemResult getNewCharInfoAll(Integer userId) {
        // 获取共享资源
        ConcurrentHashMap<String, List<UserCharInfoPojo>> stringListConcurrentHashMap =
                UserCharInfoCacheManage.getInstance().getNewMessageDatas().get(USER_CHAR_INFO_KEY + "_" + userId);
        return new SystemResult(stringListConcurrentHashMap);
    }

    /**
     * 通过用户id获取该用户全部的旧聊天信息
     *
     * @param userId
     * @return
     */
    public static SystemResult getOldCharInfoAll(Integer userId) {
        // 获取共享资源
        ConcurrentHashMap<String, List<UserCharInfoPojo>> stringListConcurrentHashMap =
                UserCharInfoCacheManage.getInstance().getOldMessageDatas().get(USER_CHAR_INFO_KEY + "_" + userId);
        return new SystemResult(stringListConcurrentHashMap);
    }

}
