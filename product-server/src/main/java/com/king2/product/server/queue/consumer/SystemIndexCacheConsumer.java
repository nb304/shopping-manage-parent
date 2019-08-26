package com.king2.product.server.queue.consumer;

import com.king2.product.server.cache.SystemIndexCacheManage;
import com.king2.product.server.dto.LockPojo;
import com.king2.product.server.enmu.ProductQueueLockFactoryTypeEnum;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.king2.product.server.locks.ProductQueueLockFactory;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * ϵͳ���湤��������
 */
@Component
public class SystemIndexCacheConsumer implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // �����µ��߳�
        new Thread(() -> {
            // ������Ϣ
            while (true) {

                // ��ȡ������
                LockPojo lockPojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_SYSTEM_MESSAGE_KEY.getValue());
                // ������
                lockPojo.getLock().lock();
                try {
                    // ȡ���������ݺ͹������ݵ�ɾ��flag
                    ConcurrentHashMap<String, Date> systemIndexHashMapDataDelFlag =  // ɾ���ı��
                            SystemIndexCacheManage.getInstance().getSystemIndexHashMapDataDelFlag();

                    ConcurrentHashMap<String, Object> systemIndexHashMapData =  // ��Ϣ��������
                            SystemIndexCacheManage.getInstance().getSystemIndexHashMapData();

                    Date date = new Date();
                    // ����ɾ����flag���� �ж��Ƿ���Ҫ���һЩ��������
                    systemIndexHashMapDataDelFlag.forEach((k, v) -> {
                        if (date.getTime() - v.getTime() > 1 * 60 * 1000) {
                            // ˵����Ҫ�������
                            systemIndexHashMapData.remove(k + "YD");
                            systemIndexHashMapData.remove(k + "WD");
                        }
                    });

                    // ÿ��60���Ӿ�ȥ��ѯ�Ƿ�����Ҫ��յ�����
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
