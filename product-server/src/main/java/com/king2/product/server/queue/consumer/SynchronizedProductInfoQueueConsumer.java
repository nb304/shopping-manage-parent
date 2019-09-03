package com.king2.product.server.queue.consumer;

import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.utils.JsonUtils;
import com.king2.product.server.dto.ProductInfoToRedisDataDto;
import com.king2.product.server.locks.ProductQueueLockFactoryTypeEnum;
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
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ͬ����Ʒ��Ϣ��������
 */
@Component
public class SynchronizedProductInfoQueueConsumer implements ApplicationRunner {

    // ע��Redis���ӳ�
    @Autowired
    private JedisPool jedisPool;

    // ע����Ʒ��redis�е�key
    @Value("${PRODUCT_INFO_REDIS_KEY}")
    private String PRODUCT_INFO_REDIS_KEY;

    // ע�뱾�ص���ƷMapper
    @Autowired
    private ProductManageMapper productManageMapper;

    @Override
    public void run(ApplicationArguments args) {

        // ����һ���µ��߳�
        new Thread(() -> {

            // ��ȡ������
            ProductQueueLockFactory instance = ProductQueueLockFactory.getInstance();
            ReentrantLock reentrantLock = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_CACHE_KEY.getValue()).getLock();
            Condition condition = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_CACHE_KEY.getValue()).getCondition();

            while (true) {
                Jedis resource = null;
                // ����
                reentrantLock.lock();
                try {
                    // ��ȡͬ���Ķ�����Ϣ
                    ConcurrentLinkedQueue<K2ProductWithBLOBs> queue = SynchornizedProductQueue.getInstance().getSynchronizedProductQueue();
                    if (!queue.isEmpty()) {
                        // �����ڿվ�ȡ��ʹ��
                        K2ProductWithBLOBs poll = queue.poll();
                        // ��������
                        resource = jedisPool.getResource();

                        // ��ѯ����Ʒ����Ϣ
                        List<ProductInfoToRedisDataDto> productByStoreId = productManageMapper.getProductByStoreId(poll.getProductStoreId(), null, 0, 1, null, null
                                , poll.getProductId(), UUID.randomUUID().toString());
                        // �жϲ�ѯ��������Ʒ�Ƿ����
                        if (!CollectionUtils.isEmpty(productByStoreId)) {
                            // ����
                            // ��������ӵ�redis��ȥ
                            resource.hset(PRODUCT_INFO_REDIS_KEY + poll.getProductStoreId(), poll.getProductNumber(), JsonUtils.objectToJson(productByStoreId.get(0)));
                        } else {
                            // ������ ������Ա������Ϣ ��ʾ����Ա ��Ϣ��ѯʧ��

                        }

                    } else {
                        // ���ڿվ�����
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
