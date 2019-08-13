package com.king2.product.server.queue.consumer;

import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.product.server.locks.ProductQueueLocks;
import com.king2.product.server.queue.ProductSuccessQueue;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 商品信息队列的消费者
 */
@Component
public class ProductInfoQueueConsumer implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 开启一条新的线程 以免干扰到主线程
        new Thread(() -> {
            // 获取锁对象
            ProductQueueLocks instance = ProductQueueLocks.getInstance();
            ReentrantLock reentrantLock = instance.getLockMaps().get(instance.DEFAULT_PRODUCT_INFO_KEY).getLock();
            Condition condition = instance.getLockMaps().get(instance.DEFAULT_PRODUCT_INFO_KEY).getCondition();
            while (true) {
                // 开启锁
                reentrantLock.lock();
                try {
                    // 查看缓存中是否存在数据
                    // 获取队列数据
                    ProductSuccessQueue successQueue = ProductSuccessQueue.getInstance();
                    ConcurrentLinkedQueue<K2ProductWithBLOBs> produdctInfoQueue = successQueue.getProdudctInfoQueue();
                    if (produdctInfoQueue == null || !produdctInfoQueue.isEmpty()) {

                        // 有数据就消费数据
                        K2ProductWithBLOBs poll = produdctInfoQueue.poll();
                        System.out.println(poll);
                    } else {
                        // 没有数据 就休息 直到被唤醒
                        condition.await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }).start();
    }
}
