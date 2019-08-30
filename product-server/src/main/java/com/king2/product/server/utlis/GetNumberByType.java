package com.king2.product.server.utlis;

import com.king2.commons.getnumber.ShoppingNumberManage;
import com.king2.commons.getnumber.ShoppingNumberPojo;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.GetErrorInfo;
import com.king2.product.server.cache.SystemCacheManage;
import com.king2.product.server.cache.SystemIndexCacheManage;
import com.king2.product.server.dto.LockPojo;
import com.king2.product.server.enmu.ProductQueueLockFactoryTypeEnum;
import com.king2.product.server.locks.ProductQueueLockFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisPool;

import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 根据类型获取编号
 */
@Component
@Scope(value = "prototype")
public class GetNumberByType {

    // 编号类型
    public static String TYPE = "NB";
    // 编号长度
    public static Integer SIZE = 11;
    // 前缀
    public static String PX = "NB";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JedisPool jedisPool;

    @Value("${CACHE_SERVER_URL}")
    private String CACHE_SERVER_URL;

    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(GetNumberByType.class);

    /**
     * 获取远程的reids中的编号信息
     *
     * @param type redis中的key
     * @param size 长度
     * @param px   前缀
     * @return
     * @throws Exception
     */
    public SystemResult getNumber(String type, Integer size, String px) throws Exception {

        // 创建系统编号管理
        ShoppingNumberPojo pojo = new ShoppingNumberPojo(jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA, type, px, size, restTemplate, CACHE_SERVER_URL);
        ShoppingNumberManage shoppingNumberManage = new ShoppingNumberManage(pojo, type);
        SystemResult numberByRedisKey = shoppingNumberManage.getNumberByRedisKey(type, 10);
        return numberByRedisKey;
    }

    /**
     * 获取一个用户信息的唯一id
     *
     * @return
     */
    public static SystemResult getMessageId() {
        // 获取锁资源
        LockPojo lockPojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactoryTypeEnum.MESSAGE_ID_ONLY_KEY.getValue());
        // 开启锁
        lockPojo.getLock().lock();
        try {
            // 获取缓存数据
            ConcurrentLinkedQueue<Integer> idQueue =
                    (ConcurrentLinkedQueue<Integer>) SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().get(SystemIndexCacheManage.MESSAGE_NUMBER_ONLY_KEY);
            // 查看缓存中是否存在id信息
            if (idQueue == null || idQueue.isEmpty()) {
                idQueue = new ConcurrentLinkedQueue<>();
                // 说明没有队列信息 需要产生数据
                for (int i = 0; i < 1000; i++) {
                    String s = new Date().getTime() + i + "";
                    String substring = s.substring(s.length() - 8);
                    idQueue.add(Integer.parseInt(substring));
                }

            }

            // 取出一个编号信息
            Integer poll = idQueue.poll();
            // 将信息重新存入缓存数据
            SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().put
                    (SystemIndexCacheManage.MESSAGE_NUMBER_ONLY_KEY, idQueue);
            // 返回数据
            return new SystemResult(poll);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("消息唯一id获取异常:" + e);
            LOGGER.error(GetErrorInfo.getTrace(e));
            String s = new Date().getTime() + "";
            return new SystemResult(Integer.parseInt(s.substring(s.length() - 8)));
        } finally {
            lockPojo.getLock().unlock();
        }

    }
}
