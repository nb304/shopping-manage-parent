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
	˵��:    �û��������Serviceʵ����

	����		ʱ��					ע��
  	����		2019.08.30   			����
=======================================================*/
@Service
@SuppressWarnings("all")
public class UserCharInfoManageServiceImpl implements UserCharInfoManageService {

    public static final String USER_CHAR_INFO_KEY = "CHAR_INFO_KEY";

    /**
     * -----------------------------------------------------
     * ����:  ��������������ҳ
     * <p>
     * ����:
     * k2MemberAndElseInfo      K2MemberAndElseInfo     ������û���Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo) {

        // ��������ֻ���ڶ�ȡ���� �������ǲ�������
        // ��ȡ���û��µ�������Ϣ
        SystemResult newCharInfoAll = getNewCharInfoAll(k2MemberAndElseInfo.getK2Member().getMemberId());
        SystemResult oldCharInfoAll = getOldCharInfoAll(k2MemberAndElseInfo.getK2Member().getMemberId());


        // ������ʾ�����ݽṹ
        UserCharInfoDto charInfoDto = new UserCharInfoDto();

        // �����������¼�;������¼
        ConcurrentHashMap<String, List<UserCharInfoPojo>> newCharInfo =
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) newCharInfoAll.getData();
        ConcurrentHashMap<String, List<UserCharInfoPojo>> oldCharInfo =
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) oldCharInfoAll.getData();

        // �����¼���
        if (!CollectionUtils.isEmpty(newCharInfo)) {
            List<UserCharHtmlDataPojo> dataPojos = new ArrayList<>();
            for (Map.Entry<String, List<UserCharInfoPojo>> entry : newCharInfo.entrySet()) {
                if (CollectionUtils.isEmpty(entry.getValue())) continue;
                UserCharHtmlDataPojo pojo = new UserCharHtmlDataPojo();
                // ����������Ϣ
                pojo.setContent(entry.getValue().get(0).getChaoInfoMessage());
                pojo.setImage(entry.getValue().get(0).getImage());
                pojo.setName(entry.getValue().get(0).getName());
                pojo.setNotReadSize(entry.getValue().size());
                pojo.setUserId(entry.getValue().get(0).getSendUserId());
                dataPojos.add(pojo);
            }
            charInfoDto.setNewCharInfo(dataPojos);
        }
        // �����ɵ���������
        if (!CollectionUtils.isEmpty(oldCharInfo)) {
            List<UserCharHtmlDataPojo> oldPojos = new ArrayList<>();
            for (Map.Entry<String, List<UserCharInfoPojo>> entry : oldCharInfo.entrySet()) {
                if (CollectionUtils.isEmpty(entry.getValue())) {
                    continue;
                } else if (!CollectionUtils.isEmpty(newCharInfo) && newCharInfo.containsKey(entry.getKey())) {
                    continue;
                }
                UserCharHtmlDataPojo pojo = new UserCharHtmlDataPojo();
                // ����������Ϣ
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
     * ͨ���û�id��ȡ���û�ȫ������������Ϣ
     *
     * @param userId
     * @return
     */
    public static SystemResult getNewCharInfoAll(Integer userId) {
        // ��ȡ������Դ
        ConcurrentHashMap<String, List<UserCharInfoPojo>> stringListConcurrentHashMap =
                UserCharInfoCacheManage.getInstance().getNewMessageDatas().get(USER_CHAR_INFO_KEY + "_" + userId);
        return new SystemResult(stringListConcurrentHashMap);
    }

    /**
     * ͨ���û�id��ȡ���û�ȫ������������Ϣ
     *
     * @param userId
     * @return
     */
    public static SystemResult getOldCharInfoAll(Integer userId) {
        // ��ȡ������Դ
        ConcurrentHashMap<String, List<UserCharInfoPojo>> stringListConcurrentHashMap =
                UserCharInfoCacheManage.getInstance().getOldMessageDatas().get(USER_CHAR_INFO_KEY + "_" + userId);
        return new SystemResult(stringListConcurrentHashMap);
    }

}
