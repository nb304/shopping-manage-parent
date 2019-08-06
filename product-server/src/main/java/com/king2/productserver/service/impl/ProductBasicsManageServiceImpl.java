package com.king2.productserver.service.impl;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2Product;
import com.king2.commons.result.SystemResult;
import com.king2.productserver.appoint.ProductBasicsAppoint;
import com.king2.productserver.pojo.ProductSkuPojo;
import com.king2.productserver.service.ProductBasicsManageService;
import org.springframework.stereotype.Service;

/*=======================================================
	说明:    商品基础管理Service实现类

	作者		时间					注释
  	俞烨		2019.08.06   			创建
=======================================================*/
@Service
public class ProductBasicsManageServiceImpl implements ProductBasicsManageService {

    /**
     * -----------------------------------------------------
     * 功能:  添加商品的SKU
     * <p>
     * 参数:
     * skuJson          String          SKU的JSON数据
     * state            String          本次是否还需要继续添加商品信息  1需要  2不需要
     * productInfo      String          商品的JSON数据
     * k2Member         K2Member        操作的用户信息
     * <p>
     * 返回: UserManageUtil              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult addProductSku(String skuJson, String productInfo, String state, K2Member K2Member) {

        // 调用校验类 查询商品的JSON数据是否正常
        SystemResult productResult = ProductBasicsAppoint.checkJsonWhetherGotoClass(productInfo, K2Product.class, "商品信息");
        if (productResult.getStatus() != 200) return productResult;

        // 校验成功调用添加的功能

        // 调用校验类 查看SkuJson数据是否正常
        SystemResult skuResult = ProductBasicsAppoint.checkJsonWhetherGotoClass(skuJson, ProductSkuPojo.class, "商品SKU");
        if (skuResult.getStatus() != 200) return skuResult;

        // 获取转换过来的Json数据
        ProductSkuPojo skuPojo = (ProductSkuPojo) skuResult.getData();

        return null;
    }

}
