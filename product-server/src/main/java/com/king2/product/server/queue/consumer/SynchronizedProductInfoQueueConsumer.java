package com.king2.product.server.queue.consumer;

import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.utils.JsonUtils;
import com.king2.product.server.dto.ProductInfoToRedisDataDto;
import com.king2.product.server.locks.ProductQueueLockFactory;
import com.king2.product.server.mapper.ProductManageMapper;
import com.king2.product.server.queue.SynchornizedProductQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步商品信息到缓存中
 */
@Component
public class SynchronizedProductInfoQueueConsumer implements ApplicationRunner {

    // 注入Redis连接池
    @Autowired
    private JedisPool jedisPool;

    // 注入商品在redis中的key
    @Value("${PRODUCT_INFO_REDIS_KEY}")
    private String PRODUCT_INFO_REDIS_KEY;

    // 注入本地的商品Mapper
    @Autowired
    private ProductManageMapper productManageMapper;

    @Override
    public void run(ApplicationArguments args) {

        // 开启一个新的线程
        new Thread(() -> {

            // 获取锁对象
            ProductQueueLockFactory instance = ProductQueueLockFactory.getInstance();
            ReentrantLock reentrantLock = instance.getLockMaps().get(instance.DEFAULT_PRODUCT_CACHE_KEY).getLock();
            Condition condition = instance.getLockMaps().get(instance.DEFAULT_PRODUCT_CACHE_KEY).getCondition();

            while (true) {
                Jedis resource = null;
                try {
                    // 加锁
                    reentrantLock.lock();
                    // 获取同步的队列信息
                    ConcurrentLinkedQueue<K2ProductWithBLOBs> queue = SynchornizedProductQueue.getInstance().getSynchronizedProductQueue();
                    if (!queue.isEmpty()) {
                        // 不等于空就取出使用
                        K2ProductWithBLOBs poll = queue.poll();
                        // 消费数据
                        resource = jedisPool.getResource();

                        // 查询该商品的信息
                        List<ProductInfoToRedisDataDto> productByStoreId = productManageMapper.getProductByStoreId(poll.getProductStoreId(), null, 0, 1, null, null
                                , poll.getProductId());
                        // 判断查询出来的商品是否存在
                        if (!CollectionUtils.isEmpty(productByStoreId)) {
                            // 存在
                            // 将数据添加到redis中去
                            resource.hset(PRODUCT_INFO_REDIS_KEY + poll.getProductStoreId(), poll.getProductNumber(), JsonUtils.objectToJson(productByStoreId.get(0)));
                        } else {
                            // 不存在 给管理员发送信息 提示管理员 信息查询失败

                        }

                    } else {
                        // 等于空就休眠
                        condition.await(100, TimeUnit.MINUTES);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (resource != null) resource.close();
                    reentrantLock.unlock();
                }
            }
        }).start();

    }
}
