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
	˵��:    �û��������Serviceʵ����

	����		ʱ��					ע��
  	����		2019.08.30   			����
=======================================================*/
@Service
@SuppressWarnings("all")
public class UserCharInfoManageServiceImpl implements UserCharInfoManageService {

    public static final String USER_CHAR_INFO_KEY = "CHAR_INFO_KEY";
    // ע��ϵͳ��Ա��
    @Autowired
    private K2MemberMapper k2MemberMapper;

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
        SystemResult result = foreachChatInfoReturnDto(newCharInfo, null, false);
        charInfoDto.setNewCharInfo((List<UserCharHtmlDataPojo>) result.getData());
        // �����ɵ���������
        SystemResult result2 = foreachChatInfoReturnDto(oldCharInfo, newCharInfo, false);
        charInfoDto.setNewCharInfo((List<UserCharHtmlDataPojo>) result.getData());

        return new SystemResult(charInfoDto);
    }

    /**
     * -----------------------------------------------------
     * ����:   ������Ϣ
     * <p>
     * ����:
     * k2MemberAndElseInfo      K2MemberAndElseInfo     �����ߵ���Ϣ
     * receiveId                Integer                 �����ߵ�id
     * chatInfo                 String                  ���͵���Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult sendChatInfo(K2MemberAndElseInfo k2MemberAndElseInfo, Integer receiveId, String chatInfo) {


        // �鿴��������ϵͳ���Ƿ����
        K2Member k2Member = k2MemberMapper.selectByPrimaryKey(receiveId);
        if (k2Member == null) return new SystemResult(100, "����Ҫ���͵��û�������,�����ѱ�ɾ��");

        // ȡ���������ڻ��������е����ݽṹ
        SystemResult newCharInfoAll = getNewCharInfoAll(receiveId);
        ConcurrentHashMap<String, List<UserCharInfoPojo>> newChatInfoMaps =  // ���ڸ��û��������¼���ݽṹ
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) newCharInfoAll.getData();
        // �ж��Ƿ���ڿ�
        if (CollectionUtils.isEmpty(newChatInfoMaps)) {
            newChatInfoMaps = new ConcurrentHashMap<String, List<UserCharInfoPojo>>();
        }
        // ȡ���÷����ߵ���Ϣ
        List<UserCharInfoPojo> charInfoPojos = null;
        String sendUserKey = USER_CHAR_INFO_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId();
        if (newChatInfoMaps.containsKey(sendUserKey)) {
            charInfoPojos = newChatInfoMaps.get(sendUserKey);
        }
        // �жϷ����ߵ���Ϣ�Ƿ�Ϊ��
        if (CollectionUtils.isEmpty(charInfoPojos)) {
            charInfoPojos = new ArrayList<>();
        }

        // ��ȫ��Ϣ
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

        // ���ͳɹ�
        return new SystemResult("ok");
    }

    /**
     * ������Ϣ���Ϸ���Dto������
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

        // �������صļ�������
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
                // ����������Ϣ
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
     * ͨ���û�id��ȡ���û�ȫ���ľ�������Ϣ
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
