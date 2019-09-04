package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2MemberMapper;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.GetErrorInfo;
import com.king2.product.server.cache.UserCharInfoCacheManage;
import com.king2.product.server.dto.LockPojo;
import com.king2.product.server.dto.UserCharInfoDto;
import com.king2.product.server.enmu.UserChatInfoStateEnum;
import com.king2.product.server.locks.ProductQueueLockFactory;
import com.king2.product.server.locks.ProductQueueLockFactoryTypeEnum;
import com.king2.product.server.pojo.UserCharHtmlDataPojo;
import com.king2.product.server.pojo.UserCharInfoPojo;
import com.king2.product.server.service.UserCharInfoManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/*=======================================================
	说明:    用户聊天管理Service实现类

	作者		时间					注释
  	俞烨		2019.08.30   			创建
=======================================================*/
@Service
@SuppressWarnings("all")
public class UserChatInfoManageServiceImpl implements UserCharInfoManageService {

    public static final String USER_CHAR_INFO_KEY = "CHAR_INFO_KEY";
    // 注入系统成员表
    @Autowired
    private K2MemberMapper k2MemberMapper;
    // 打印日志
    private static final Logger LOGGER = LoggerFactory.getLogger(UserChatInfoManageServiceImpl.class);

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
        // 获取该用户新的和旧的聊天信息
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
        SystemResult result2 = foreachChatInfoReturnDto(oldCharInfo, newCharInfo, true);
        charInfoDto.setOldCharInfo((List<UserCharHtmlDataPojo>) result2.getData());

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


        // 获取锁
        LockPojo lockPojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactoryTypeEnum.USER_CHAT_KEY.getValue());

        // 开启锁
        lockPojo.getLock().lock();
        try {
            // 查看接收者在系统中是否存在
            K2Member k2Member = k2MemberMapper.selectByPrimaryKey(receiveId);
            if (k2Member == null) return new SystemResult(100, "您需要发送的用户不存在,或者已被删除");

            // 将新消息写入接收者的新数据结构中
            newChatInfoGotoWriteReceiveNewChatInfoData(k2Member, k2MemberAndElseInfo, chatInfo);

            // 将新消息写入发送者的旧数据结构中
            newChatInfoGotoWriteSendUserOldChatInfoData(k2Member, k2MemberAndElseInfo, chatInfo);
        } catch (Exception e) {
            LOGGER.error("发送消息时出错,报错信息:" + e);
            LOGGER.error(GetErrorInfo.getTrace(e));
            // 给管理员发送信息
            return new SystemResult(100, "您的网络波动较大,请稍后重试.");
        } finally {
            lockPojo.getLock().unlock();
        }

        // 发送成功
        return new SystemResult("ok");
    }


    /**
     * -----------------------------------------------------
     * 功能:   查询消息
     * <p>
     * 参数:
     * k2MemberAndElseInfo      K2MemberAndElseInfo     发送者的信息
     * getId                   Integer                  需要获取的用户id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult getChatInfoByGetId(Integer getId, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // 查看是否存在新的消息
        SystemResult newCharInfoAll = getNewCharInfoAll(k2MemberAndElseInfo.getK2Member().getMemberId());
        ConcurrentHashMap<String, List<UserCharInfoPojo>> newChatInfoMaps =  // 属于该用户的聊天记录数据结构
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) newCharInfoAll.getData();

        // 获取聊天信息的数据
        SystemResult chatInfoByGetIdAndSynchronizedNewChatInfo = getChatInfoByGetIdAndSynchronizedNewChatInfo(newChatInfoMaps, getId, k2MemberAndElseInfo);
        return chatInfoByGetIdAndSynchronizedNewChatInfo;
    }

    /**
     * 获取聊天的信息 根据id 获取到新的消息后并且需要进行同步
     *
     * @param newChatInfoMaps
     * @param getId
     * @param k2MemberAndElseInfo
     * @return
     */
    public static SystemResult getChatInfoByGetIdAndSynchronizedNewChatInfo(
            ConcurrentHashMap<String, List<UserCharInfoPojo>> newChatInfoMaps,
            Integer getId, K2MemberAndElseInfo k2MemberAndElseInfo
    ) {

        // 获取该用户的旧数据信息
        SystemResult oldCharInfoAll = getOldCharInfoAll(k2MemberAndElseInfo.getK2Member().getMemberId());
        ConcurrentHashMap<String, List<UserCharInfoPojo>> oldChatInfoMaps =  // 属于该用户的聊天记录数据结构
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) oldCharInfoAll.getData();

        // 判断该用户的历史数据是否为空
        if (CollectionUtils.isEmpty(oldChatInfoMaps)) {
            // 用户的Map集合为空 重新写入信息 以防空指针异常
            if (oldChatInfoMaps == null) {
                oldChatInfoMaps = new ConcurrentHashMap<>();
                addChatInfo(USER_CHAR_INFO_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId(), oldChatInfoMaps, "old");
            }
            if (CollectionUtils.isEmpty(newChatInfoMaps)) {
                return new SystemResult(new ArrayList<>());
            }
        }

        // 取出属于这个GetId的聊天记录
        List<UserCharInfoPojo> pojos = null;
        if (!oldChatInfoMaps.containsKey(USER_CHAR_INFO_KEY + "_" + getId)) {
            pojos = new ArrayList<>();
        } else {
            pojos = oldChatInfoMaps.get(USER_CHAR_INFO_KEY + "_" + getId);
        }

        // 判断新消息的数据是否等于空
        // 如果新消息的数据为空 则将旧的数据返回给页面 旧的数据是不用排序的 因为是排序后的数据
        if (CollectionUtils.isEmpty(newChatInfoMaps)) {
            if (newChatInfoMaps == null) {
                newChatInfoMaps = new ConcurrentHashMap<String, List<UserCharInfoPojo>>();
                addChatInfo(USER_CHAR_INFO_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId(), newChatInfoMaps, "new");
            }
            return CollectionUtils.isEmpty(pojos) ? new SystemResult(new ArrayList<>()) :
                    new SystemResult(pojos);
        } else if (!CollectionUtils.isEmpty(newChatInfoMaps) &&
                newChatInfoMaps.containsKey(USER_CHAR_INFO_KEY + "_" + getId)) {

            // 新的消息不等于空的情况下 并且包含getId发送的新消息 就需要进行同步
            List<UserCharInfoPojo> newPojos = newChatInfoMaps.get(USER_CHAR_INFO_KEY + "_" + getId);
            pojos.addAll(newPojos);
            Collections.sort(pojos);
            // 排序完成 重新写回新的消息
            newChatInfoMaps.put(USER_CHAR_INFO_KEY + "_" + getId, new ArrayList<>());
            addChatInfo(
                    USER_CHAR_INFO_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId(),
                    newChatInfoMaps, "new");
            oldChatInfoMaps.put(USER_CHAR_INFO_KEY + "_" + getId, pojos);
            addChatInfo(
                    USER_CHAR_INFO_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId(),
                    oldChatInfoMaps, "old");


        }

        return new SystemResult(pojos);
    }

    /**
     * 将新消息写入发送者的旧数据结构中
     *
     * @param receiveId
     * @param memberAndElseInfo
     * @param chatInfo
     */
    public static void newChatInfoGotoWriteSendUserOldChatInfoData(K2Member k2Member, K2MemberAndElseInfo memberAndElseInfo, String chatInfo) {

        // 获取发送者的旧信息数据结构
        SystemResult oldCharInfoAll = getOldCharInfoAll(memberAndElseInfo.getK2Member().getMemberId());
        ConcurrentHashMap<String, List<UserCharInfoPojo>> oldChatInfoMaps =  // 属于该用户的聊天记录数据结构
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) oldCharInfoAll.getData();
        // 判断是否等于空
        if (CollectionUtils.isEmpty(oldChatInfoMaps)) {
            oldChatInfoMaps = new ConcurrentHashMap<String, List<UserCharInfoPojo>>();
            addChatInfo(USER_CHAR_INFO_KEY + "_" + memberAndElseInfo.getK2Member().getMemberId(), oldChatInfoMaps, "old");
        }

        // 取出该发送者在接收者的信息
        List<UserCharInfoPojo> oldCharInfoPojos = null;
        String sendUserKeyOld = USER_CHAR_INFO_KEY + "_" + memberAndElseInfo.getK2Member().getMemberId();
        if (oldChatInfoMaps.containsKey(sendUserKeyOld)) {
            oldCharInfoPojos = oldChatInfoMaps.get(sendUserKeyOld);
        }
        // 判断发送者的信息是否为空
        if (CollectionUtils.isEmpty(oldCharInfoPojos)) {
            oldCharInfoPojos = new ArrayList<>();
        }
        UserCharInfoPojo pojo = new UserCharInfoPojo();
        pojo.setState(UserChatInfoStateEnum.ZC.getValue());
        pojo.setSendUserId(memberAndElseInfo.getK2Member().getMemberId());
        pojo.setReceiveUserId(k2Member.getMemberId());
        pojo.setName(memberAndElseInfo.getK2Member().getMemberName());
        pojo.setReName(k2Member.getMemberName());
        pojo.setImage(memberAndElseInfo.getK2Member().getMemberPortrait());
        pojo.setReImage(memberAndElseInfo.getK2Member().getMemberPortrait());
        pojo.setCreateTime(new Date());
        pojo.setChaoInfoMessage(chatInfo);
        pojo.setCharId(123);
        pojo.setFlag(true);
        oldCharInfoPojos.add(pojo);
        oldChatInfoMaps.put(sendUserKeyOld, oldCharInfoPojos);
    }


    /**
     * 将新消息写入到接收者的新消息数据结构中
     */
    public static void newChatInfoGotoWriteReceiveNewChatInfoData(K2Member k2Member, K2MemberAndElseInfo memberAndElseInfo, String chatInfo) {
        // 取出接收者在缓存数据中的新消息数据结构
        SystemResult newCharInfoAll = getNewCharInfoAll(k2Member.getMemberId());
        ConcurrentHashMap<String, List<UserCharInfoPojo>> newChatInfoMaps =  // 获取接收者的新消息的缓存结构
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) newCharInfoAll.getData();
        // 判断是否等于空
        if (CollectionUtils.isEmpty(newChatInfoMaps)) {
            newChatInfoMaps = new ConcurrentHashMap<String, List<UserCharInfoPojo>>();
            addChatInfo(USER_CHAR_INFO_KEY + "_" + k2Member.getMemberId(), newChatInfoMaps, "new");
        }
        // 取出该发送者在接收者的信息
        List<UserCharInfoPojo> charInfoPojos = null;
        String sendUserKey = USER_CHAR_INFO_KEY + "_" + memberAndElseInfo.getK2Member().getMemberId();
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
        pojo.setSendUserId(memberAndElseInfo.getK2Member().getMemberId());
        pojo.setReceiveUserId(k2Member.getMemberId());
        pojo.setImage(memberAndElseInfo.getK2Member().getMemberPortrait());
        pojo.setReImage(k2Member.getMemberPortrait());
        pojo.setName(memberAndElseInfo.getK2Member().getMemberName());
        pojo.setReName(k2Member.getMemberName());
        pojo.setCreateTime(new Date());
        pojo.setChaoInfoMessage(chatInfo);
        pojo.setCharId(123);
        pojo.setFlag(false);
        charInfoPojos.add(pojo);
        newChatInfoMaps.put(sendUserKey, charInfoPojos);

        // 下一次接收者如果需要查看发送者的数据 就需要进行排序
        ConcurrentHashMap<String, Boolean> isSortFlagMaps = UserCharInfoCacheManage.getInstance().getIsSortFlagMaps();
        if (CollectionUtils.isEmpty(isSortFlagMaps)) {
            isSortFlagMaps = new ConcurrentHashMap<>();
        }

        // 修改需要排序的信息
//        isSortFlagMaps.put
//                (UserCharInfoCacheManage.IS_SYNCHRONIZED_SORT_FLAG + "_" + receiveId + "_" + memberAndElseInfo.getK2Member().getMemberId(), true);
    }

    /**
     * 遍历消息集合返回Dto的数据
     *
     * @param chatInfo
     * @param newChatInfo
     * @param sFlag
     * @return
     */
    public static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm");

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
                        if (newChatInfo.get(entry.getKey()).size() > 0) {
                            continue;
                        }

                    }
                }
                UserCharHtmlDataPojo pojo = new UserCharHtmlDataPojo();
                // 设置聊天信息
                pojo.setContent(entry.getValue().get(entry.getValue().size() - 1).getChaoInfoMessage());
                pojo.setImage(entry.getValue().get(entry.getValue().size() - 1).getImage());
                pojo.setName(entry.getValue().get(entry.getValue().size() - 1).getName());
                if (!sFlag) pojo.setNotReadSize(entry.getValue().size());
                pojo.setUserId(entry.getValue().get(entry.getValue().size() - 1).getSendUserId());
                pojo.setTime(sdf.format(entry.getValue().get(entry.getValue().size() - 1).getCreateTime()));
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

    public static void addChatInfo(String key,
                                   ConcurrentHashMap<String, List<UserCharInfoPojo>> chatMap,
                                   String type) {
        if ("new".equals(type)) {
            UserCharInfoCacheManage.getInstance().getNewMessageDatas().put(key, chatMap);
        } else if ("old".equals(type)) {
            UserCharInfoCacheManage.getInstance().getOldMessageDatas().put(key, chatMap);
        }

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
