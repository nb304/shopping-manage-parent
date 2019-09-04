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
	˵��:    �û��������Serviceʵ����

	����		ʱ��					ע��
  	����		2019.08.30   			����
=======================================================*/
@Service
@SuppressWarnings("all")
public class UserChatInfoManageServiceImpl implements UserCharInfoManageService {

    public static final String USER_CHAR_INFO_KEY = "CHAR_INFO_KEY";
    // ע��ϵͳ��Ա��
    @Autowired
    private K2MemberMapper k2MemberMapper;
    // ��ӡ��־
    private static final Logger LOGGER = LoggerFactory.getLogger(UserChatInfoManageServiceImpl.class);

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
        // ��ȡ���û��µĺ;ɵ�������Ϣ
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
        SystemResult result2 = foreachChatInfoReturnDto(oldCharInfo, newCharInfo, true);
        charInfoDto.setOldCharInfo((List<UserCharHtmlDataPojo>) result2.getData());

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


        // ��ȡ��
        LockPojo lockPojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactoryTypeEnum.USER_CHAT_KEY.getValue());

        // ������
        lockPojo.getLock().lock();
        try {
            // �鿴��������ϵͳ���Ƿ����
            K2Member k2Member = k2MemberMapper.selectByPrimaryKey(receiveId);
            if (k2Member == null) return new SystemResult(100, "����Ҫ���͵��û�������,�����ѱ�ɾ��");

            // ������Ϣд������ߵ������ݽṹ��
            newChatInfoGotoWriteReceiveNewChatInfoData(k2Member, k2MemberAndElseInfo, chatInfo);

            // ������Ϣд�뷢���ߵľ����ݽṹ��
            newChatInfoGotoWriteSendUserOldChatInfoData(k2Member, k2MemberAndElseInfo, chatInfo);
        } catch (Exception e) {
            LOGGER.error("������Ϣʱ����,������Ϣ:" + e);
            LOGGER.error(GetErrorInfo.getTrace(e));
            // ������Ա������Ϣ
            return new SystemResult(100, "�������粨���ϴ�,���Ժ�����.");
        } finally {
            lockPojo.getLock().unlock();
        }

        // ���ͳɹ�
        return new SystemResult("ok");
    }


    /**
     * -----------------------------------------------------
     * ����:   ��ѯ��Ϣ
     * <p>
     * ����:
     * k2MemberAndElseInfo      K2MemberAndElseInfo     �����ߵ���Ϣ
     * getId                   Integer                  ��Ҫ��ȡ���û�id
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult getChatInfoByGetId(Integer getId, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // �鿴�Ƿ�����µ���Ϣ
        SystemResult newCharInfoAll = getNewCharInfoAll(k2MemberAndElseInfo.getK2Member().getMemberId());
        ConcurrentHashMap<String, List<UserCharInfoPojo>> newChatInfoMaps =  // ���ڸ��û��������¼���ݽṹ
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) newCharInfoAll.getData();

        // ��ȡ������Ϣ������
        SystemResult chatInfoByGetIdAndSynchronizedNewChatInfo = getChatInfoByGetIdAndSynchronizedNewChatInfo(newChatInfoMaps, getId, k2MemberAndElseInfo);
        return chatInfoByGetIdAndSynchronizedNewChatInfo;
    }

    /**
     * ��ȡ�������Ϣ ����id ��ȡ���µ���Ϣ������Ҫ����ͬ��
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

        // ��ȡ���û��ľ�������Ϣ
        SystemResult oldCharInfoAll = getOldCharInfoAll(k2MemberAndElseInfo.getK2Member().getMemberId());
        ConcurrentHashMap<String, List<UserCharInfoPojo>> oldChatInfoMaps =  // ���ڸ��û��������¼���ݽṹ
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) oldCharInfoAll.getData();

        // �жϸ��û�����ʷ�����Ƿ�Ϊ��
        if (CollectionUtils.isEmpty(oldChatInfoMaps)) {
            // �û���Map����Ϊ�� ����д����Ϣ �Է���ָ���쳣
            if (oldChatInfoMaps == null) {
                oldChatInfoMaps = new ConcurrentHashMap<>();
                addChatInfo(USER_CHAR_INFO_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId(), oldChatInfoMaps, "old");
            }
            if (CollectionUtils.isEmpty(newChatInfoMaps)) {
                return new SystemResult(new ArrayList<>());
            }
        }

        // ȡ���������GetId�������¼
        List<UserCharInfoPojo> pojos = null;
        if (!oldChatInfoMaps.containsKey(USER_CHAR_INFO_KEY + "_" + getId)) {
            pojos = new ArrayList<>();
        } else {
            pojos = oldChatInfoMaps.get(USER_CHAR_INFO_KEY + "_" + getId);
        }

        // �ж�����Ϣ�������Ƿ���ڿ�
        // �������Ϣ������Ϊ�� �򽫾ɵ����ݷ��ظ�ҳ�� �ɵ������ǲ�������� ��Ϊ������������
        if (CollectionUtils.isEmpty(newChatInfoMaps)) {
            if (newChatInfoMaps == null) {
                newChatInfoMaps = new ConcurrentHashMap<String, List<UserCharInfoPojo>>();
                addChatInfo(USER_CHAR_INFO_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId(), newChatInfoMaps, "new");
            }
            return CollectionUtils.isEmpty(pojos) ? new SystemResult(new ArrayList<>()) :
                    new SystemResult(pojos);
        } else if (!CollectionUtils.isEmpty(newChatInfoMaps) &&
                newChatInfoMaps.containsKey(USER_CHAR_INFO_KEY + "_" + getId)) {

            // �µ���Ϣ�����ڿյ������ ���Ұ���getId���͵�����Ϣ ����Ҫ����ͬ��
            List<UserCharInfoPojo> newPojos = newChatInfoMaps.get(USER_CHAR_INFO_KEY + "_" + getId);
            pojos.addAll(newPojos);
            Collections.sort(pojos);
            // ������� ����д���µ���Ϣ
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
     * ������Ϣд�뷢���ߵľ����ݽṹ��
     *
     * @param receiveId
     * @param memberAndElseInfo
     * @param chatInfo
     */
    public static void newChatInfoGotoWriteSendUserOldChatInfoData(K2Member k2Member, K2MemberAndElseInfo memberAndElseInfo, String chatInfo) {

        // ��ȡ�����ߵľ���Ϣ���ݽṹ
        SystemResult oldCharInfoAll = getOldCharInfoAll(memberAndElseInfo.getK2Member().getMemberId());
        ConcurrentHashMap<String, List<UserCharInfoPojo>> oldChatInfoMaps =  // ���ڸ��û��������¼���ݽṹ
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) oldCharInfoAll.getData();
        // �ж��Ƿ���ڿ�
        if (CollectionUtils.isEmpty(oldChatInfoMaps)) {
            oldChatInfoMaps = new ConcurrentHashMap<String, List<UserCharInfoPojo>>();
            addChatInfo(USER_CHAR_INFO_KEY + "_" + memberAndElseInfo.getK2Member().getMemberId(), oldChatInfoMaps, "old");
        }

        // ȡ���÷������ڽ����ߵ���Ϣ
        List<UserCharInfoPojo> oldCharInfoPojos = null;
        String sendUserKeyOld = USER_CHAR_INFO_KEY + "_" + memberAndElseInfo.getK2Member().getMemberId();
        if (oldChatInfoMaps.containsKey(sendUserKeyOld)) {
            oldCharInfoPojos = oldChatInfoMaps.get(sendUserKeyOld);
        }
        // �жϷ����ߵ���Ϣ�Ƿ�Ϊ��
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
     * ������Ϣд�뵽�����ߵ�����Ϣ���ݽṹ��
     */
    public static void newChatInfoGotoWriteReceiveNewChatInfoData(K2Member k2Member, K2MemberAndElseInfo memberAndElseInfo, String chatInfo) {
        // ȡ���������ڻ��������е�����Ϣ���ݽṹ
        SystemResult newCharInfoAll = getNewCharInfoAll(k2Member.getMemberId());
        ConcurrentHashMap<String, List<UserCharInfoPojo>> newChatInfoMaps =  // ��ȡ�����ߵ�����Ϣ�Ļ���ṹ
                (ConcurrentHashMap<String, List<UserCharInfoPojo>>) newCharInfoAll.getData();
        // �ж��Ƿ���ڿ�
        if (CollectionUtils.isEmpty(newChatInfoMaps)) {
            newChatInfoMaps = new ConcurrentHashMap<String, List<UserCharInfoPojo>>();
            addChatInfo(USER_CHAR_INFO_KEY + "_" + k2Member.getMemberId(), newChatInfoMaps, "new");
        }
        // ȡ���÷������ڽ����ߵ���Ϣ
        List<UserCharInfoPojo> charInfoPojos = null;
        String sendUserKey = USER_CHAR_INFO_KEY + "_" + memberAndElseInfo.getK2Member().getMemberId();
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

        // ��һ�ν����������Ҫ�鿴�����ߵ����� ����Ҫ��������
        ConcurrentHashMap<String, Boolean> isSortFlagMaps = UserCharInfoCacheManage.getInstance().getIsSortFlagMaps();
        if (CollectionUtils.isEmpty(isSortFlagMaps)) {
            isSortFlagMaps = new ConcurrentHashMap<>();
        }

        // �޸���Ҫ�������Ϣ
//        isSortFlagMaps.put
//                (UserCharInfoCacheManage.IS_SYNCHRONIZED_SORT_FLAG + "_" + receiveId + "_" + memberAndElseInfo.getK2Member().getMemberId(), true);
    }

    /**
     * ������Ϣ���Ϸ���Dto������
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

        // �������صļ�������
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
                // ����������Ϣ
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
