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
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult addProductSku(String skuJson, String productInfo, String state, K2Member K2Member) throws Exception;


    /**
     * -----------------------------------------------------
     * 功能:  添加商品页面所需要的信息
     * <p>
     * 参数:
     * K2Member         K2Member        操作的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult addProductPageInfo(K2Member k2Member) throws Exception;

    /**
     * -----------------------------------------------------
     * 功能:  通过类目id获取商品SKU模板信息
     * <p>
     * 参数:
     * cId         Integer          类目id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult getSkuInfoByCId(Integer cId);

    /**
     * -----------------------------------------------------
     * 功能:  添加商品的SPU信息
     * <p>
     * 参数:
     * productSpuJson         String            商品的SPU信息
     * productId              Integer           商品的id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult addProductSpu(String productSpuJson, Integer productId, K2Member k2Member);



}
