package com.king2.product.server.queue;

import com.king2.commons.pojo.K2ProductWithBLOBs;

import java.util.concurrent.ConcurrentLinkedQueue;

/*=======================================================
	说明:   商品模块操作成功的队列信息

	作者		时间					注释
  	俞烨		2019.08.13  		创建
=======================================================*/
public class ProductSuccessQueue {

    // 启动单列模式
    private ProductSuccessQueue() {
    }

    private static ProductSuccessQueue productSuccessQueue = new ProductSuccessQueue();

    public static ProductSuccessQueue getInstance() {
        return productSuccessQueue;
    }


    /**
     * 商品信息队列
     */
    private ConcurrentLinkedQueue<K2ProductWithBLOBs> produdctInfoQueue =
            new ConcurrentLinkedQueue<K2ProductWithBLOBs>();

    public ConcurrentLinkedQueue<K2ProductWithBLOBs> getProdudctInfoQueue() {
        return produdctInfoQueue;
    }

    public void setProdudctInfoQueue(ConcurrentLinkedQueue<K2ProductWithBLOBs> produdctInfoQueue) {
        this.produdctInfoQueue = produdctInfoQueue;
    }
}
