package com.king2.product.server.queue.consumer;

import com.king2.product.server.cache.SystemIndexCacheManage;
import com.king2.product.server.dto.LockPojo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.king2.product.server.locks.ProductQueueLockFactory;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 系统缓存工具消费者
 */
@Component
public class SystemIndexCacheConsumer implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 开启新的线程
        new Thread(() -> {
            // 监听信息
            while (true) {

                // 获取锁对象
                LockPojo lockPojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactory.DEFAULT_SYSTEM_MESSAGE_KEY);
                // 开启锁
                lockPojo.getLock().lock();
                try {
                    // 取出共享数据和共享数据的删除flag
                    ConcurrentHashMap<String, Date> systemIndexHashMapDataDelFlag =  // 删除的标记
                            SystemIndexCacheManage.getInstance().getSystemIndexHashMapDataDelFlag();

                    ConcurrentHashMap<String, Object> systemIndexHashMapData =  // 信息共享数据
                            SystemIndexCacheManage.getInstance().getSystemIndexHashMapData();

                    Date date = new Date();
                    // 遍历删除的flag数据 判断是否需要清空一些共享数据
                    systemIndexHashMapDataDelFlag.forEach((k, v) -> {
                        if (date.getTime() - v.getTime() > 1 * 60 * 1000) {
                            // 说明需要清空数据
                            systemIndexHashMapData.remove(k + "YD");
                            systemIndexHashMapData.remove(k + "WD");
                        }
                    });

                    // 每隔60分钟就去查询是否有需要清空的数据
                    lockPojo.getCondition().await(60, TimeUnit.MINUTES);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lockPojo.getLock().unlock();
                }


            }
        }).start();
    }
}
