package com.king2.product.server.service;

import com.king2.commons.result.SystemResult;

/*=======================================================
	说明:    商品SKU管理Service

	作者		时间					注释
  	俞烨		2019.08.21   			创建
=======================================================*/
public interface ProductSkuManageService {


    /**
     * -----------------------------------------------------
     * 功能:   根据商品id获取该商品的SKU信息集合
     * <p>
     * 参数:
     * productId          Integer         商品ID
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult getSkuByProductId(Integer productId);

    /**
     * -----------------------------------------------------
     * 功能:   修改商品SKU信息
     * <p>
     * 参数:
     * skuKcInfo          String         商品SKU的信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult editSkuInfo(String skuKcInfo);
}
