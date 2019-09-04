package com.king2.product.server.appoint;

import com.king2.product.server.cache.UserChatInfoCacheManage;
import com.king2.product.server.dto.UserChatCacheInfoDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用户聊天信息的委派类
 */
public class UserChatInfoManageAppoint {

    // 每次发送消息的最大字节数
    public static final Integer SEND_MESSAGE_SIZE = 1048576;
    // 聊天记录存在缓存中的key
    public static final String CHAT_INFO_CHCHE_KEY = "CHAT_INFO_CHCHE_KEY";

    /**
     * 校验发送的数据是否通过
     *
     * @param message
     * @return
     */
    public static Boolean checkMessageIfPass(String message) {
        if (StringUtils.isEmpty(message) || message.getBytes().length > SEND_MESSAGE_SIZE) {
            return false;
        }
        return true;
    }

    /**
     * 根据id获取该用户存在缓存中所有的信息
     *
     * @param id
     * @return
     */
    public static ConcurrentHashMap<String, UserChatCacheInfoDto> getChatInfoAllById(Integer id) {

        // 获取到聊天信息的数据结构
        UserChatInfoCacheManage instance = UserChatInfoCacheManage.getInstance();
        synchronized (instance) {
            // 聊天的所有消息
            ConcurrentHashMap<String, UserChatCacheInfoDto> stringListConcurrentHashMap = null;
            // 判断该key是否在数据中存在
            if (!instance.getHashMapConcurrentHashMap().containsKey(CHAT_INFO_CHCHE_KEY + "_" + id)) {
                stringListConcurrentHashMap = new ConcurrentHashMap<>();
                // 重新写入缓存
                writeChatInfoAllById(id, stringListConcurrentHashMap);
            } else {

                // 获取到这个id的所有聊天记录的信息
                stringListConcurrentHashMap = instance.getHashMapConcurrentHashMap().get(CHAT_INFO_CHCHE_KEY + "_" + id);
                if (stringListConcurrentHashMap == null) {
                    stringListConcurrentHashMap = new ConcurrentHashMap<>();
                    // 重新写入缓存
                    writeChatInfoAllById(id, stringListConcurrentHashMap);
                }
            }
            return stringListConcurrentHashMap;
        }
    }

    /**
     * 根据类型取出本次需要取出的信息
     *
     * @return
     */
    public static UserChatCacheInfoDto getUserInfoById
    (ConcurrentHashMap<String, UserChatCacheInfoDto> datas, Integer hostId,
     Integer haveId) {

        // 取出针对于id的新消息和旧消息信息
        UserChatCacheInfoDto chatCacheInfoDtos = null;
        // 判断该数据信息在缓存中是否存在
        if (!datas.containsKey(CHAT_INFO_CHCHE_KEY + "_" + haveId)) {
            chatCacheInfoDtos = new UserChatCacheInfoDto();
            chatCacheInfoDtos.setNewChatInfos(new ArrayList<>());
            chatCacheInfoDtos.setOldChatInfos(new ArrayList<>());
            datas.put(CHAT_INFO_CHCHE_KEY + "_" + haveId, chatCacheInfoDtos);
            writeChatInfoAllById(hostId, datas);
        } else {
            chatCacheInfoDtos = datas.get(CHAT_INFO_CHCHE_KEY + "_" + haveId);
            if (chatCacheInfoDtos == null) {
                chatCacheInfoDtos = new UserChatCacheInfoDto();
                chatCacheInfoDtos.setNewChatInfos(new ArrayList<>());
                chatCacheInfoDtos.setOldChatInfos(new ArrayList<>());
                datas.put(CHAT_INFO_CHCHE_KEY + "_" + haveId, chatCacheInfoDtos);
                writeChatInfoAllById(hostId, datas);
            }
        }

        return chatCacheInfoDtos;
    }

    /**
     * 将这个用户所有的信息重新写入缓存
     *
     * @param id
     * @param hashMap
     */
    public static void writeChatInfoAllById(Integer id, ConcurrentHashMap<String, UserChatCacheInfoDto> hashMap) {
        // 获取到聊天信息的数据结构
        UserChatInfoCacheManage instance = UserChatInfoCacheManage.getInstance();
        synchronized (instance) {
            // 获取到这个id的所有聊天记录的信息
            instance.getHashMapConcurrentHashMap().put(CHAT_INFO_CHCHE_KEY + "_" + id, hashMap);
        }
    }
}
