package com.king2.product.server.queue.consumer;

import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.FileUtil;
import com.king2.product.server.appoint.ProductBasicsAppoint;
import com.king2.product.server.appoint.ProductInfoQueueAppoint;
import com.king2.product.server.locks.ProductQueueLockFactory;
import com.king2.product.server.queue.ProductSuccessQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��Ʒ��Ϣ���е�������
 */
@Component
public class ProductInfoQueueConsumer implements ApplicationRunner {

    // ע����ƷУ��ί����
    @Autowired
    private ProductInfoQueueAppoint productInfoQueueAppoint;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        // ����һ���µ��߳� ������ŵ����߳�
        new Thread(() -> {
            // ��ȡ������
            ProductQueueLockFactory instance = ProductQueueLockFactory.getInstance();
            ReentrantLock reentrantLock = instance.getLockMaps().get(instance.DEFAULT_PRODUCT_INFO_KEY).getLock();
            Condition condition = instance.getLockMaps().get(instance.DEFAULT_PRODUCT_INFO_KEY).getCondition();
            while (true) {
                // ������
                reentrantLock.lock();
                // ģ��ҵ���߼�
                /*int count = 0;
                while (count++ < 1000) {
                    System.out.println("����������ʹ��");
                    try {
                        Thread.sleep(20);
                    } catch (Exception e) {

                    }

                }*/
                try {
                    // �鿴�������Ƿ��������
                    // ��ȡ��������
                    ProductSuccessQueue successQueue = ProductSuccessQueue.getInstance();
                    ConcurrentLinkedQueue<K2ProductWithBLOBs> produdctInfoQueue = successQueue.getProdudctInfoQueue();
                    if (produdctInfoQueue != null && !produdctInfoQueue.isEmpty()) {
                        // �����ݾ���������
                        K2ProductWithBLOBs product = produdctInfoQueue.poll();

                        // �鿴��Ʒ����Ϣ�Ƿ����
                        SystemResult productIsPassResult = productInfoQueueAppoint.checkProductInfoIfPass(product);
                        if (productIsPassResult.getStatus() == 208) {
                            // ��Ʒ��Ϣû�й���  �޸���Ʒ״̬
                            productInfoQueueAppoint.prorductInfoNotAudit(product, productIsPassResult.getData() + "");
                        } else if (productIsPassResult.getStatus() != 200) {
                            // ϵͳ�׳��쳣  ��¼��־
                            FileUtil.createFolder(FileUtil.SYSTEM_PATH + "/public/ProductLog");
                            // �����ļ�
                            FileUtil.createFolder(FileUtil.SYSTEM_PATH + "/public/ProductLog/�����Ʒ��Ϣ�쳣.txt");
                            // д����־
                            FileUtil.fileWrite(FileUtil.SYSTEM_PATH + "/public/ProductLog/�����Ʒ��Ϣ�쳣.txt",
                                    "�����Ʒ��Ϣ�����뼰ʱ����----ʱ��:" + new SimpleDateFormat("yyyy��MM��dd�� hh:mm:ss").format(new Date()),
                                    true);
                        } else if (productIsPassResult.getStatus() == 200) {
                            // ��˳ɹ�
                            // ����Ϣ�浽�����������ȥ
                            // ��Ʒ��Ϣû��ͨ��  ֪ͨ������и�������
                            ProductBasicsAppoint.addSynchronizedProductGotoCache(product);
                            // ��Ϣ�������Ϣ�Ƶ�solr����������ȥ
                            SystemResult result = productInfoQueueAppoint.synchronizedSolr(product);
                            if (result.getStatus() != 200) {
                                // �����쳣 д����־��Ϣ
                                FileUtil.createFolder(FileUtil.SYSTEM_PATH + "/public/ProductLog");
                                // �����ļ�
                                FileUtil.createFolder(FileUtil.SYSTEM_PATH + "/public/ProductLog/��Ʒsolr�쳣.txt");
                                // д����־
                                FileUtil.fileWrite(FileUtil.SYSTEM_PATH + "/public/ProductLog/��Ʒsolr�쳣.txt",
                                        "��ƷSolr����ʧ�ܣ��뼰ʱ��顣----ʱ��:" + new SimpleDateFormat("yyyy��MM��dd�� hh:mm:ss").format(new Date()),
                                        true);
                            }
                        }
                    } else {
                        // û������ ����Ϣ ֱ��������
                        // await��Object��waitһ�����ó�cpu������Դ
                        condition.await(100, TimeUnit.MINUTES);
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
