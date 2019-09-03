package com.king2.product.server.appoint;

import com.king2.commons.mapper.K2MessageMapper;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2Message;
import com.king2.commons.pojo.K2MessageExample;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.cache.SystemIndexCacheManage;
import com.king2.product.server.dto.LockPojo;
import com.king2.product.server.dto.SystemIndexDto;
import com.king2.product.server.enmu.K2MessageEnum;
import com.king2.product.server.locks.ProductQueueLockFactoryTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.king2.product.server.locks.ProductQueueLockFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*=======================================================
	˵��:    ϵͳ��ҳ����ί����

	����		ʱ��					ע��
  	����		2019.08.24   			����
=======================================================*/
@Component
public class SystemIndexManageAppiont {

    // ע��ϵͳ��ϢMapper
    @Autowired
    private K2MessageMapper k2MessageMapper;


    /**
     * -----------------------------------------------------
     * ����:  �����û�id��ȡ�û���Ϣ
     * <p>
     * ����:
     * userId      Integer     �û�id
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public SystemResult getMessageByUserId(Integer userId) {

        // ���Ȳ�ѯ�����е������Ƿ����
        SystemResult userMeesageCacheById = getUserMeesageCacheById(userId);
        if (userMeesageCacheById.getStatus() == 200) return userMeesageCacheById;
        // �����û�id��ѯ���û�����Ϣ
        K2MessageExample example = new K2MessageExample();
        example.createCriteria().andUserIdEqualTo(userId).andStateNotEqualTo(K2MessageEnum.DEL.getValue());
        List<K2Message> k2Messages = k2MessageMapper.selectByExampleWithBLOBs(example);
        // �鿴��Ϣ�Ƿ����
        if (!CollectionUtils.isEmpty(k2Messages)) {
            // �����ڿ� ����Ϣ���з���
            List<K2Message> YIDU_MESSAGE_LIST = new ArrayList<>();
            List<K2Message> WEIDU_MESSAGE_LIST = new ArrayList<>();

            k2Messages.forEach((n) -> {
                n.setCreateTimeStr(UserMessageAppoint.sdf.format(n.getCreateTime()));
                n.setSubStringContent(n.getMessageContent().length() > 50 ? n.getMessageContent().substring(0, 50) : n.getMessageContent());
                // �ж���Ϣ�Ƿ����Ѷ�
                if ((K2MessageEnum.YD.getValue() + "").equals(n.getState() + "")) {
                    // ��Ϣ�����Ѷ�
                    YIDU_MESSAGE_LIST.add(n);
                } else if ((K2MessageEnum.WD.getValue() + "").equals(n.getState() + "")) {
                    // ��Ϣ����δ��
                    WEIDU_MESSAGE_LIST.add(n);
                }
            });

            // ������ɺ� �������ݼ�����
            // ��ȡ��
            ConcurrentHashMap<String, LockPojo> lockMaps = ProductQueueLockFactory.getInstance().getLockMaps();
            LockPojo lockPojo = lockMaps.get(ProductQueueLockFactoryTypeEnum.DEFAULT_SYSTEM_MESSAGE_KEY.getValue());
            Condition condition = lockPojo.getCondition();  // ���ļ�����
            ReentrantLock lock = lockPojo.getLock();  // ������
            // ����
            lock.lock();
            try {

                // �����ݴ��뻺����
                ConcurrentHashMap<String, Object> systemIndexHashMapData = // ��ȡ�������
                        SystemIndexCacheManage.getInstance().getSystemIndexHashMapData();

                // ����д��flag
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapDataDelFlag().put(
                        SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_",
                        new Date()
                );

                // ����Ϣ���뻺����
                systemIndexHashMapData.put(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_YD", YIDU_MESSAGE_LIST);
                systemIndexHashMapData.put(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_WD", WEIDU_MESSAGE_LIST);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // �ͷ���
                lock.unlock();
            }

            // �������صĶ���
            SystemIndexDto dto = new SystemIndexDto();
            dto.setwDMessage(WEIDU_MESSAGE_LIST);
            dto.setyDMessage(YIDU_MESSAGE_LIST);
            return new SystemResult(dto);
        }

        return new SystemResult(null);
    }

    /**
     * ��ȡ�����е�����
     *
     * @param userId �û�id
     * @return
     */
    public SystemResult getUserMeesageCacheById(Integer userId) {

        // ��ѯ�������Ƿ��������
        // �����ݴ��뻺����
        ConcurrentHashMap<String, Object> systemIndexHashMapData = // ��ȡ�������
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapData();
        if (CollectionUtils.isEmpty(systemIndexHashMapData)) {
            return new SystemResult(201, "������", null);
        }

        // �жϸ��û�����Ϣ�Ƿ����
        if (!systemIndexHashMapData.containsKey(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_YD") &&
                systemIndexHashMapData.containsKey(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_WD")) {

            return new SystemResult(201, "������", null);
        }

        // ��ȡ�Ѷ���Ϣ
        List<K2Message> WEIDU_MESSAGE_LIST =
                (List<K2Message>) systemIndexHashMapData.get(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_WD");
        // ��ȡδ����Ϣ
        List<K2Message> YIDU_MESSAGE_LIST =
                (List<K2Message>) systemIndexHashMapData.get(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_YD");

        // ����д��flag
        SystemIndexCacheManage.getInstance().getSystemIndexHashMapDataDelFlag().put(
                SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_",
                new Date()
        );

        // �������� �����ݷ���
        SystemIndexDto dto = new SystemIndexDto();
        dto.setyDMessage(YIDU_MESSAGE_LIST);
        dto.setwDMessage(WEIDU_MESSAGE_LIST);
        return new SystemResult(dto);
    }


    /**
     * ����Ϣ��������д�뻺����
     *
     * @param state               ״̬
     * @param oldState            �ɵ�״̬
     * @param k2MemberAndElseInfo �û�����Ϣ
     * @param messageId           ��Ϣ��id
     * @return
     */
    public SystemResult editUserMessageById(String state, String oldState, K2MemberAndElseInfo k2MemberAndElseInfo, String messageId) {
        // �޸���ɺ� ��Ҫ�ж� �Ƿ���ɾ��  �����ɾ�� ����Ҫɾ����������
        if (state.equals(K2MessageEnum.DEL.getValue() + "")) {
            // ��Ҫɾ�����������
            // ��ȡ������
            LockPojo lockPojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_SYSTEM_MESSAGE_KEY.getValue());
            // ������
            lockPojo.getLock().lock();
            try {
                // ��ȡ�Ƿ����Ѷ�����Ϣ
                boolean isReadFlag = false;
                // ������Ϣ�ľ�״̬ ��ȡ��Ӧ����Ϣ����
                List<K2Message> k2Messages = null;
                if (oldState.equals(K2MessageEnum.YD.getValue() + "")) {
                    // ��ȡ�������Ѷ�������
                    isReadFlag = true;
                    k2Messages = (List<K2Message>) SystemIndexCacheManage.getInstance().getSystemIndexHashMapData()
                            .get(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_YD");
                } else if (oldState.equals(K2MessageEnum.WD.getValue() + "")) {
                    k2Messages = (List<K2Message>) SystemIndexCacheManage.getInstance().getSystemIndexHashMapData()
                            .get(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_WD");
                }

                // �жϼ����Ƿ�Ϊ��
                if (!CollectionUtils.isEmpty(k2Messages)) {
                    // ��Ҫɾ������Ϣ,Ȼ�󲢴��빲������
                    for (int i = 0; i < k2Messages.size(); i++) {
                        if (k2Messages.get(i).getMessageId().toString().equals(messageId)) {
                            k2Messages.remove(i);
                            // ɾ�����������ѭ�� ����ᱨ��
                            break;
                        }
                    }

                    // ��ɾ����Ԫ�غ� ����д�뻺��
                    if (isReadFlag) {
                        // д���Ѷ�
                        SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().put(
                                SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_YD",
                                k2Messages);
                    } else {
                        // д��δ��
                        SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().put(
                                SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_WD",
                                k2Messages);
                    }

                    // ����д��flag
                    SystemIndexCacheManage.getInstance().getSystemIndexHashMapDataDelFlag().put(
                            SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_",
                            new Date()
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lockPojo.getLock().unlock(); // ����
            }
        } else {

            // ��Ҫ��δ���в�ѯ����

            List<K2Message> k2Messages_WD = (List<K2Message>) SystemIndexCacheManage.getInstance().getSystemIndexHashMapData()
                    .get(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_WD");
            List<K2Message> k2Messages_YD = (List<K2Message>) SystemIndexCacheManage.getInstance().getSystemIndexHashMapData()
                    .get(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_YD");
            if(CollectionUtils.isEmpty(k2Messages_YD)) {
                k2Messages_YD = new ArrayList<>();
            }
            if(CollectionUtils.isEmpty(k2Messages_WD)) {
                k2Messages_WD = new ArrayList<>();
            }
            // �������� Ȼ�����ݸ������Ѷ�����ȥ
            if (!CollectionUtils.isEmpty(k2Messages_WD)) {
                for (int i = 0; i < k2Messages_WD.size(); i++) {
                    if (k2Messages_WD.get(i).getMessageId().toString().equals(messageId)) {

                        // ȡ�������� �����Ѷ�������
                        k2Messages_YD.add(k2Messages_WD.get(i));
                        k2Messages_WD.remove(i);
                        // ɾ�����������ѭ�� ����ᱨ��
                        break;
                    }
                }

                // ��ɾ����Ԫ�غ� ����д�뻺��
                // д���Ѷ�
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().put(
                        SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_YD",
                        k2Messages_YD);
                // д��δ��
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().put(
                        SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_WD",
                        k2Messages_WD);

                // ����д��flag
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapDataDelFlag().put(
                        SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_",
                        new Date()
                );
            }
        }

        return new SystemResult("ok");
    }

}
