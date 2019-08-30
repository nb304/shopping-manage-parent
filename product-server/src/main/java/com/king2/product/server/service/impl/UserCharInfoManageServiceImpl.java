package com.king2.product.server.service.impl;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.cache.UserCharInfoCacheManage;
import com.king2.product.server.dto.UserCharInfoDto;
import com.king2.product.server.pojo.UserCharHtmlDataPojo;
import com.king2.product.server.pojo.UserCharInfoPojo;
import com.king2.product.server.service.UserCharInfoManageService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
        if (!CollectionUtils.isEmpty(newCharInfo)) {
            List<UserCharHtmlDataPojo> dataPojos = new ArrayList<>();
            for (Map.Entry<String, List<UserCharInfoPojo>> entry : newCharInfo.entrySet()) {
                if (CollectionUtils.isEmpty(entry.getValue())) continue;
                UserCharHtmlDataPojo pojo = new UserCharHtmlDataPojo();
                // 设置聊天信息
                pojo.setContent(entry.getValue().get(0).getChaoInfoMessage());
                pojo.setImage(entry.getValue().get(0).getImage());
                pojo.setName(entry.getValue().get(0).getName());
                pojo.setNotReadSize(entry.getValue().size());
                pojo.setUserId(entry.getValue().get(0).getSendUserId());
                dataPojos.add(pojo);
            }
            charInfoDto.setNewCharInfo(dataPojos);
        }
        // 遍历旧的聊天数据
        if (!CollectionUtils.isEmpty(oldCharInfo)) {
            List<UserCharHtmlDataPojo> oldPojos = new ArrayList<>();
            for (Map.Entry<String, List<UserCharInfoPojo>> entry : oldCharInfo.entrySet()) {
                if (CollectionUtils.isEmpty(entry.getValue())) {
                    continue;
                } else if (!CollectionUtils.isEmpty(newCharInfo) && newCharInfo.containsKey(entry.getKey())) {
                    continue;
                }
                UserCharHtmlDataPojo pojo = new UserCharHtmlDataPojo();
                // 设置聊天信息
                pojo.setContent(entry.getValue().get(0).getChaoInfoMessage());
                pojo.setImage(entry.getValue().get(0).getImage());
                pojo.setName(entry.getValue().get(0).getName());
                pojo.setNotReadSize(entry.getValue().size());
                pojo.setUserId(entry.getValue().get(0).getSendUserId());
                oldPojos.add(pojo);
            }
            charInfoDto.setOldCharInfo(oldPojos);
        }


        return new SystemResult(charInfoDto);
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
     * 通过用户id获取该用户全部的新聊天信息
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
