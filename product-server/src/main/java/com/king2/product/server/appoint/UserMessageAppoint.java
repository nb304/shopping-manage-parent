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
	说明:    用户的消息委派类

	作者		时间					注释
  	俞烨		2019.08.24   			创建
=======================================================*/
public class UserMessageAppoint {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");


    /**
     * 将消息重新写入缓存数据中
     *
     * @param k2Message 消息
     * @param userId    用户id
     */
    public static void addMessageGotoCache(K2Message k2Message, Integer userId) {

        // 获取锁
        LockPojo lockPojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactory.DEFAULT_SYSTEM_MESSAGE_KEY);
        // 加锁
        lockPojo.getLock().lock();
        try {
            k2Message.setCreateTimeStr(sdf.format(k2Message.getCreateTime()));
            k2Message.setSubStringContent(k2Message.getMessageContent().length() > 50 ? k2Message.getMessageContent().substring(0, 50) : k2Message.getMessageContent());
            // 修改共享数据的删除标志
            // 重新写入flag
            SystemIndexCacheManage.getInstance().getSystemIndexHashMapDataDelFlag().put(
                    SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_",
                    new Date()
            );

            // 取出未读的信息
            ConcurrentHashMap<String, Object> systemIndexHashMapData = SystemIndexCacheManage.getInstance().getSystemIndexHashMapData();
            List<K2Message> WEIDU_MESSAGE_LIST =
                    (List<K2Message>) systemIndexHashMapData.get(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_WD");

            // 添加新的数据然后重新写入缓存中
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
     * 添加信息到mysqlzhong
     *
     * @param message         消息
     * @param userId          用户id
     * @param k2MessageMapper 消息Mapper
     */
    public static void addMessageGotoMysql(String message, Integer userId, K2MessageMapper k2MessageMapper) {
        K2Message k2Message = new K2Message();
        k2Message.setUserId(userId);
        k2Message.setMessageContent(message);
        k2Message.setCreateTime(new Date());
        k2Message.setState(K2MessageEnum.WD.getValue());
        k2MessageMapper.insert(k2Message);

        // 同步数据
        addMessageGotoCache(k2Message, userId);
    }

    /**
     * 根据状态删除或清空缓存中的数据
     *
     * @param userId 用户的id
     * @param state  状态
     */
    public static void clearOrReadMessageByUserIdAndState(Integer userId, String state) {
        // 获取锁
        LockPojo pojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactory.DEFAULT_SYSTEM_MESSAGE_KEY);
        // 开启锁
        pojo.getLock().lock();
        try {
            if ("2".equals(state)) {
                // 该状态需要将用户数据中未读的信息放到已读中并清空
                List<K2Message> wd = getMessageByType(userId, "WD");
                List<K2Message> yd = getMessageByType(userId, "YD");
                if (CollectionUtils.isEmpty(wd)) return;
                wd.forEach((n) -> n.setState(2));
                yd.addAll(wd);

                // 更改信息的删除Flag
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapDataDelFlag()
                        .put(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_", new Date());

                // 将信息数据重新写入缓存数据中
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().put(
                        SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_YD", yd
                );
                wd.clear();
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().put(
                        SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_WD", wd
                );
            } else if ("3".equals(state)) {
                // 删除缓存中所有的数据
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
     * 根据状态获取消息
     *
     * @param userId 用户id
     * @param type   信息的状态 已读OR未读
     * @return
     */
    public static List<K2Message> getMessageByType(Integer userId, String type) {
        // 获取已读的数据
        List<K2Message> typeMessage = (List<K2Message>) SystemIndexCacheManage.getInstance().getSystemIndexHashMapData()
                .get(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_" + type);
        return typeMessage;
    }

}
