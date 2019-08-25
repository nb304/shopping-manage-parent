package com.king2.product.server.service;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2ProductWithBLOBs;
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
    SystemResult addProductSku(String skuJson, String productInfo, String state, K2MemberAndElseInfo K2Member) throws Exception;


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
    SystemResult addProductPageInfo(K2MemberAndElseInfo k2Member) throws Exception;

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
     * 功能:  显示商品修改页面并查询商品信息
     * <p>
     * 参数:
     * productId         Integer          需要查询的商品id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult showEditGetProInfo(Integer productId, K2MemberAndElseInfo k2Member);

    /**
     * -----------------------------------------------------
     * 功能:  查询商品的图片信息
     * <p>
     * 参数:
     * productId         Integer          需要查询的商品id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult getProductImageByPId(Integer productId);

    /**
     * -----------------------------------------------------
     * 功能:  修改商品信息
     * <p>
     * 参数:
     * k2ProductWithBLOBs         K2ProductWithBLOBs          修改的商品信息
     * k2Member                   K2Member                    操作的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult editProductInfo(K2ProductWithBLOBs k2ProductWithBLOBs, K2MemberAndElseInfo k2MemberAndElseInfo);

    /**
     * -----------------------------------------------------
     * 功能:  逻辑删除商品信息
     * <p>
     * 参数:
     * productId                Integer          被删除的商品id
     * k2Member                   K2Member       操作的用户信息
     * state                    Integer          商品状态
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult delProductInfo(Integer productId, K2MemberAndElseInfo k2MemberAndElseInfo, Integer state);
}
