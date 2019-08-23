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
 * 商品信息队列的消费者
 */
@Component
public class ProductInfoQueueConsumer implements ApplicationRunner {

    // 注入商品校验委派类
    @Autowired
    private ProductInfoQueueAppoint productInfoQueueAppoint;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        // 开启一条新的线程 以免干扰到主线程
        new Thread(() -> {
            // 获取锁对象
            ProductQueueLockFactory instance = ProductQueueLockFactory.getInstance();
            ReentrantLock reentrantLock = instance.getLockMaps().get(instance.DEFAULT_PRODUCT_INFO_KEY).getLock();
            Condition condition = instance.getLockMaps().get(instance.DEFAULT_PRODUCT_INFO_KEY).getCondition();
            while (true) {
                // 开启锁
                reentrantLock.lock();
                // 模拟业务逻辑
                /*int count = 0;
                while (count++ < 1000) {
                    System.out.println("锁对象正在使用");
                    try {
                        Thread.sleep(20);
                    } catch (Exception e) {

                    }

                }*/
                try {
                    // 查看缓存中是否存在数据
                    // 获取队列数据
                    ProductSuccessQueue successQueue = ProductSuccessQueue.getInstance();
                    ConcurrentLinkedQueue<K2ProductWithBLOBs> produdctInfoQueue = successQueue.getProdudctInfoQueue();
                    if (produdctInfoQueue != null && !produdctInfoQueue.isEmpty()) {
                        // 有数据就消费数据
                        K2ProductWithBLOBs product = produdctInfoQueue.poll();

                        // 查看商品的信息是否过审
                        SystemResult productIsPassResult = productInfoQueueAppoint.checkProductInfoIfPass(product);
                        if (productIsPassResult.getStatus() == 208) {
                            // 商品信息没有过审  修改商品状态
                            productInfoQueueAppoint.prorductInfoNotAudit(product, productIsPassResult.getData() + "");
                        } else if (productIsPassResult.getStatus() != 200) {
                            // 系统抛出异常  记录日志
                            FileUtil.createFolder(FileUtil.SYSTEM_PATH + "/public/ProductLog");
                            // 创建文件
                            FileUtil.createFolder(FileUtil.SYSTEM_PATH + "/public/ProductLog/审核商品信息异常.txt");
                            // 写入日志
                            FileUtil.fileWrite(FileUtil.SYSTEM_PATH + "/public/ProductLog/审核商品信息异常.txt",
                                    "审核商品信息出错，请及时处理。----时间:" + new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss").format(new Date()),
                                    true);
                        } else if (productIsPassResult.getStatus() == 200) {
                            // 审核成功
                            // 将信息存到缓存服务器中去
                            // 商品信息没有通过  通知缓存队列更新数据
                            ProductBasicsAppoint.addSynchronizedProductGotoCache(product);
                            // 信息过审后将信息推到solr搜索服务器去
                            SystemResult result = productInfoQueueAppoint.synchronizedSolr(product);
                            if (result.getStatus() != 200) {
                                // 出现异常 写入日志信息
                                FileUtil.createFolder(FileUtil.SYSTEM_PATH + "/public/ProductLog");
                                // 创建文件
                                FileUtil.createFolder(FileUtil.SYSTEM_PATH + "/public/ProductLog/商品solr异常.txt");
                                // 写入日志
                                FileUtil.fileWrite(FileUtil.SYSTEM_PATH + "/public/ProductLog/商品solr异常.txt",
                                        "商品Solr配置失败，请及时检查。----时间:" + new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss").format(new Date()),
                                        true);
                            }
                        }
                    } else {
                        // 没有数据 就休息 直到被唤醒
                        // await和Object的wait一样会让出cpu和锁资源
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
