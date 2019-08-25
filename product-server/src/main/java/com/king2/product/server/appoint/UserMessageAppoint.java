package com.king2.product.server.appoint;

import com.king2.commons.mapper.K2MessageMapper;
import com.king2.product.server.cache.SystemIndexCacheManage;
import com.king2.product.server.dto.LockPojo;
import com.king2.product.server.enmu.K2MessageEnum;
import com.king2.product.server.locks.ProductQueueLockFactory;
import com.king2.commons.pojo.K2Message;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/*=======================================================
	˵��:    �û�����Ϣί����

	����		ʱ��					ע��
  	����		2019.08.24   			����
=======================================================*/
public class UserMessageAppoint {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");


    /**
     * ����Ϣ����д�뻺��������
     *
     * @param k2Message ��Ϣ
     * @param userId    �û�id
     */
    public static void addMessageGotoCache(K2Message k2Message, Integer userId) {

        // ��ȡ��
        LockPojo lockPojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactory.DEFAULT_SYSTEM_MESSAGE_KEY);
        // ����
        lockPojo.getLock().lock();
        try {
            k2Message.setCreateTimeStr(sdf.format(k2Message.getCreateTime()));
            k2Message.setSubStringContent(k2Message.getMessageContent().length() > 50 ? k2Message.getMessageContent().substring(0, 50) : k2Message.getMessageContent());
            // �޸Ĺ������ݵ�ɾ����־
            // ����д��flag
            SystemIndexCacheManage.getInstance().getSystemIndexHashMapDataDelFlag().put(
                    SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_",
                    new Date()
            );

            // ȡ��δ������Ϣ
            ConcurrentHashMap<String, Object> systemIndexHashMapData = SystemIndexCacheManage.getInstance().getSystemIndexHashMapData();
            List<K2Message> WEIDU_MESSAGE_LIST =
                    (List<K2Message>) systemIndexHashMapData.get(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_WD");

            // ����µ�����Ȼ������д�뻺����
            if (CollectionUtils.isEmpty(WEIDU_MESSAGE_LIST)) WEIDU_MESSAGE_LIST = new ArrayList<>();
            WEIDU_MESSAGE_LIST.add(k2Message);
            systemIndexHashMapData.put(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_WD", WEIDU_MESSAGE_LIST);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPojo.getLock().unlock();
        }
    }

    /**
     * �����Ϣ��mysqlzhong
     *
     * @param message         ��Ϣ
     * @param userId          �û�id
     * @param k2MessageMapper ��ϢMapper
     */
    public static void addMessageGotoMysql(String message, Integer userId, K2MessageMapper k2MessageMapper) {
        K2Message k2Message = new K2Message();
        k2Message.setUserId(userId);
        k2Message.setMessageContent(message);
        k2Message.setCreateTime(new Date());
        k2Message.setState(K2MessageEnum.WD.getValue());
        k2MessageMapper.insert(k2Message);

        // ͬ������
        addMessageGotoCache(k2Message, userId);
    }

    /**
     * ����״̬ɾ������ջ����е�����
     *
     * @param userId �û���id
     * @param state  ״̬
     */
    public static void clearOrReadMessageByUserIdAndState(Integer userId, String state) {
        // ��ȡ��
        LockPojo pojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactory.DEFAULT_SYSTEM_MESSAGE_KEY);
        // ������
        pojo.getLock().lock();
        try {
            if ("2".equals(state)) {
                // ��״̬��Ҫ���û�������δ������Ϣ�ŵ��Ѷ��в����
                List<K2Message> wd = getMessageByType(userId, "WD");
                List<K2Message> yd = getMessageByType(userId, "YD");
                if (CollectionUtils.isEmpty(wd)) return;
                wd.forEach((n) -> n.setState(2));
                yd.addAll(wd);

                // ������Ϣ��ɾ��Flag
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapDataDelFlag()
                        .put(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_", new Date());

                // ����Ϣ��������д�뻺��������
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().put(
                        SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_YD", yd
                );
                wd.clear();
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().put(
                        SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_WD", wd
                );
            } else if ("3".equals(state)) {
                // ɾ�����������е�����
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapData()
                        .remove(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_YD");
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapData()
                        .remove(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_WD");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pojo.getLock().unlock();
        }

    }

    /**
     * ����״̬��ȡ��Ϣ
     *
     * @param userId �û�id
     * @param type   ��Ϣ��״̬ �Ѷ�ORδ��
     * @return
     */
    public static List<K2Message> getMessageByType(Integer userId, String type) {
        // ��ȡ�Ѷ�������
        List<K2Message> typeMessage = (List<K2Message>) SystemIndexCacheManage.getInstance().getSystemIndexHashMapData()
                .get(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_" + type);
        return typeMessage;
    }

}
