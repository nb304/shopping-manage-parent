package com.king2.product.server.service;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.result.SystemResult;

/*=======================================================
	说明:    商品基础管理Service

	作者		时间					注释
  	俞烨		2019.08.06   			创建
=======================================================*/
public interface ProductBasicsManageService {

    /**
     * -----------------------------------------------------
     * 功能:  添加商品的SKU
     * <p>
     * 参数:
     * skuJson          String          SKU的JSON数据
     * state            String          本次是否还需要继续添加商品信息  1需要  2不需要
     * productInfo      String          商品的JSON数据
     * K2Member         K2Member        操作的用户信息
     * <p>
     * 返回: UserManageUtil              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult addProductSku(String skuJson, String productInfo, String state, K2Member K2Member) throws Exception;
}
