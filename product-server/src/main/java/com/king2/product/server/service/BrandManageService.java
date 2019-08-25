package com.king2.product.server.service;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.BrandIndexManageDto;

/*=======================================================
	说明:    商品品牌管理Service

	作者		时间					注释
  	俞烨		2019.08.25   			创建
=======================================================*/
public interface BrandManageService {


    /**
     * -----------------------------------------------------
     * 功能:  显示商品品牌的首页
     * <p>
     * 参数:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        操作的用户信息
     * dto              BrandIndexManageDto 分页数据
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, BrandIndexManageDto dto);

    /**
     * -----------------------------------------------------
     * 功能:  添加品牌
     * <p>
     * 参数:
     * brandName                String         品牌名称
     * k2MemberAndElseInfo      K2MemberAndElseInfo 操作的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult addBrand(String brandName, K2MemberAndElseInfo k2MemberAndElseInfo);
}
