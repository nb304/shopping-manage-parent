package com.king2.product.server.queue;

import com.king2.commons.pojo.K2ProductWithBLOBs;

import java.util.concurrent.ConcurrentLinkedQueue;

/*=======================================================
	说明:   同步缓存中的商品信息

	作者		时间					注释
  	俞烨		2019.08.13  		创建
=======================================================*/
public class SynchornizedProductQueue {

    // 开启单例模式
    private SynchornizedProductQueue() {
    }

    private static SynchornizedProductQueue synchornizedProductQueue = new SynchornizedProductQueue();

    public static SynchornizedProductQueue getInstance() {
        return synchornizedProductQueue;
    }

    // 同步缓存中的商品信息队列
    private ConcurrentLinkedQueue<K2ProductWithBLOBs> synchronizedProductQueue = new ConcurrentLinkedQueue<>();

    public ConcurrentLinkedQueue<K2ProductWithBLOBs> getSynchronizedProductQueue() {
        return synchronizedProductQueue;
    }

    public void setSynchronizedProductQueue(ConcurrentLinkedQueue<K2ProductWithBLOBs> synchronizedProductQueue) {
        this.synchronizedProductQueue = synchronizedProductQueue;
    }
}
