package com.king2.product.server.service;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;

/*=======================================================
	说明:    商品SPU管理Service

	作者		时间					注释
  	俞烨		2019.08.20   			创建
=======================================================*/
public interface ProductSpuManageService {

    /**
     * -----------------------------------------------------
     * 功能:  查询商品的SPU操作
     * <p>
     * 参数:
     * productId        String          商品id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult getSpuByPId(Integer productId);

    /**
     * -----------------------------------------------------
     * 功能:  逻辑删除商品的SPU信息
     * <p>
     * 参数:
     * spuId        String          商品的SPUid
     * k2Member     K2Member        操作的用户信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult delSpuById(Integer spuId, K2MemberAndElseInfo k2Member);

    /**
     * -----------------------------------------------------
     * 功能:  恢复SPU的信息
     * <p>
     * 参数:
     * spuId        String          商品的SPUid
     * k2Member     K2Member        操作的用户信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult recoverNormal(Integer spuId, K2MemberAndElseInfo k2Member);

    /**
     * -----------------------------------------------------
     * 功能:  批量注销商品的SPU信息
     * <p>
     * 参数:
     * spuIds        String         商品的SPUIds
     * k2Member     K2Member        操作的用户信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult batchCancelSpu(String spuIds, K2MemberAndElseInfo k2Member);

    /**
     * -----------------------------------------------------
     * 功能:  修改商品参数的信息
     * <p>
     * 参数:
     * spuKey        String         商品的SPU的名称
     * skuValue      String         商品的参数值
     * productSpuId  String         商品参数的Id
     * k2Member     K2Member        操作的用户信息
     * order        Integer         排序
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult editSpuInfo(String spuKey, String skuValue, Integer order, Integer productSpuId, K2MemberAndElseInfo k2Member);

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
    SystemResult addProductSpu(String productSpuJson, Integer productId, K2MemberAndElseInfo k2Member);
}
