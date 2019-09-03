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
	说明:    系统首页管理委托类

	作者		时间					注释
  	俞烨		2019.08.24   			创建
=======================================================*/
@Component
public class SystemIndexManageAppiont {

    // 注入系统信息Mapper
    @Autowired
    private K2MessageMapper k2MessageMapper;


    /**
     * -----------------------------------------------------
     * 功能:  根据用户id获取用户信息
     * <p>
     * 参数:
     * userId      Integer     用户id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    public SystemResult getMessageByUserId(Integer userId) {

        // 首先查询缓存中的数据是否存在
        SystemResult userMeesageCacheById = getUserMeesageCacheById(userId);
        if (userMeesageCacheById.getStatus() == 200) return userMeesageCacheById;
        // 根据用户id查询该用户的消息
        K2MessageExample example = new K2MessageExample();
        example.createCriteria().andUserIdEqualTo(userId).andStateNotEqualTo(K2MessageEnum.DEL.getValue());
        List<K2Message> k2Messages = k2MessageMapper.selectByExampleWithBLOBs(example);
        // 查看信息是否存在
        if (!CollectionUtils.isEmpty(k2Messages)) {
            // 不等于空 把消息进行分类
            List<K2Message> YIDU_MESSAGE_LIST = new ArrayList<>();
            List<K2Message> WEIDU_MESSAGE_LIST = new ArrayList<>();

            k2Messages.forEach((n) -> {
                n.setCreateTimeStr(UserMessageAppoint.sdf.format(n.getCreateTime()));
                n.setSubStringContent(n.getMessageContent().length() > 50 ? n.getMessageContent().substring(0, 50) : n.getMessageContent());
                // 判断消息是否是已读
                if ((K2MessageEnum.YD.getValue() + "").equals(n.getState() + "")) {
                    // 消息属于已读
                    YIDU_MESSAGE_LIST.add(n);
                } else if ((K2MessageEnum.WD.getValue() + "").equals(n.getState() + "")) {
                    // 消息属于未读
                    WEIDU_MESSAGE_LIST.add(n);
                }
            });

            // 分类完成后 存入数据集合中
            // 获取锁
            ConcurrentHashMap<String, LockPojo> lockMaps = ProductQueueLockFactory.getInstance().getLockMaps();
            LockPojo lockPojo = lockMaps.get(ProductQueueLockFactoryTypeEnum.DEFAULT_SYSTEM_MESSAGE_KEY.getValue());
            Condition condition = lockPojo.getCondition();  // 锁的监听器
            ReentrantLock lock = lockPojo.getLock();  // 锁对象
            // 加锁
            lock.lock();
            try {

                // 将数据存入缓存中
                ConcurrentHashMap<String, Object> systemIndexHashMapData = // 获取缓存对象
                        SystemIndexCacheManage.getInstance().getSystemIndexHashMapData();

                // 重新写入flag
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapDataDelFlag().put(
                        SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_",
                        new Date()
                );

                // 将信息存入缓存中
                systemIndexHashMapData.put(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_YD", YIDU_MESSAGE_LIST);
                systemIndexHashMapData.put(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_WD", WEIDU_MESSAGE_LIST);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 释放锁
                lock.unlock();
            }

            // 创建返回的对象
            SystemIndexDto dto = new SystemIndexDto();
            dto.setwDMessage(WEIDU_MESSAGE_LIST);
            dto.setyDMessage(YIDU_MESSAGE_LIST);
            return new SystemResult(dto);
        }

        return new SystemResult(null);
    }

    /**
     * 获取缓存中的数据
     *
     * @param userId 用户id
     * @return
     */
    public SystemResult getUserMeesageCacheById(Integer userId) {

        // 查询缓存中是否存在数据
        // 将数据存入缓存中
        ConcurrentHashMap<String, Object> systemIndexHashMapData = // 获取缓存对象
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapData();
        if (CollectionUtils.isEmpty(systemIndexHashMapData)) {
            return new SystemResult(201, "不存在", null);
        }

        // 判断该用户的信息是否存在
        if (!systemIndexHashMapData.containsKey(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_YD") &&
                systemIndexHashMapData.containsKey(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_WD")) {

            return new SystemResult(201, "不存在", null);
        }

        // 获取已读信息
        List<K2Message> WEIDU_MESSAGE_LIST =
                (List<K2Message>) systemIndexHashMapData.get(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_WD");
        // 获取未读信息
        List<K2Message> YIDU_MESSAGE_LIST =
                (List<K2Message>) systemIndexHashMapData.get(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_YD");

        // 重新写入flag
        SystemIndexCacheManage.getInstance().getSystemIndexHashMapDataDelFlag().put(
                SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + userId + "_",
                new Date()
        );

        // 创建数据 将数据返回
        SystemIndexDto dto = new SystemIndexDto();
        dto.setyDMessage(YIDU_MESSAGE_LIST);
        dto.setwDMessage(WEIDU_MESSAGE_LIST);
        return new SystemResult(dto);
    }


    /**
     * 将消息数据重新写入缓存中
     *
     * @param state               状态
     * @param oldState            旧的状态
     * @param k2MemberAndElseInfo 用户的信息
     * @param messageId           消息的id
     * @return
     */
    public SystemResult editUserMessageById(String state, String oldState, K2MemberAndElseInfo k2MemberAndElseInfo, String messageId) {
        // 修改完成后 需要判断 是否是删除  如果是删除 则需要删除缓存数据
        if (state.equals(K2MessageEnum.DEL.getValue() + "")) {
            // 需要删除缓存的数据
            // 获取锁对象
            LockPojo lockPojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_SYSTEM_MESSAGE_KEY.getValue());
            // 开启锁
            lockPojo.getLock().lock();
            try {
                // 获取是否是已读的信息
                boolean isReadFlag = false;
                // 根据信息的旧状态 获取对应的信息缓存
                List<K2Message> k2Messages = null;
                if (oldState.equals(K2MessageEnum.YD.getValue() + "")) {
                    // 获取缓存中已读的数据
                    isReadFlag = true;
                    k2Messages = (List<K2Message>) SystemIndexCacheManage.getInstance().getSystemIndexHashMapData()
                            .get(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_YD");
                } else if (oldState.equals(K2MessageEnum.WD.getValue() + "")) {
                    k2Messages = (List<K2Message>) SystemIndexCacheManage.getInstance().getSystemIndexHashMapData()
                            .get(SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_WD");
                }

                // 判断集合是否为空
                if (!CollectionUtils.isEmpty(k2Messages)) {
                    // 需要删除该信息,然后并存入共享数据
                    for (int i = 0; i < k2Messages.size(); i++) {
                        if (k2Messages.get(i).getMessageId().toString().equals(messageId)) {
                            k2Messages.remove(i);
                            // 删除后立马结束循环 否则会报错
                            break;
                        }
                    }

                    // 当删除完元素后 重新写入缓存
                    if (isReadFlag) {
                        // 写入已读
                        SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().put(
                                SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_YD",
                                k2Messages);
                    } else {
                        // 写入未读
                        SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().put(
                                SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_WD",
                                k2Messages);
                    }

                    // 重新写入flag
                    SystemIndexCacheManage.getInstance().getSystemIndexHashMapDataDelFlag().put(
                            SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_",
                            new Date()
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lockPojo.getLock().unlock(); // 解锁
            }
        } else {

            // 需要从未读中查询数据

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
            // 遍历数据 然后将数据更换到已读当中去
            if (!CollectionUtils.isEmpty(k2Messages_WD)) {
                for (int i = 0; i < k2Messages_WD.size(); i++) {
                    if (k2Messages_WD.get(i).getMessageId().toString().equals(messageId)) {

                        // 取出该数据 存入已读数据中
                        k2Messages_YD.add(k2Messages_WD.get(i));
                        k2Messages_WD.remove(i);
                        // 删除后立马结束循环 否则会报错
                        break;
                    }
                }

                // 当删除完元素后 重新写入缓存
                // 写入已读
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().put(
                        SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_YD",
                        k2Messages_YD);
                // 写入未读
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().put(
                        SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_WD",
                        k2Messages_WD);

                // 重新写入flag
                SystemIndexCacheManage.getInstance().getSystemIndexHashMapDataDelFlag().put(
                        SystemIndexCacheManage.PRODUCT_INDEX_USER_MESSAGE_KEY + "_" + k2MemberAndElseInfo.getK2Member().getMemberId() + "_",
                        new Date()
                );
            }
        }

        return new SystemResult("ok");
    }

}
