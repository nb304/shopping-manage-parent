package com.king2.product.server.service;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.BrandIndexManageDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    /**
     * -----------------------------------------------------
     * 功能:  上传LOGO图片
     * <p>
     * 参数:
     * logoFile                MultipartFile         LOGO样式
     * k2MemberAndElseInfo      K2MemberAndElseInfo 操作的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult uploadLogo(MultipartFile logoFile, K2MemberAndElseInfo k2MemberAndElseInfo, Integer brandId) throws Exception;

    /**
     * -----------------------------------------------------
     * 功能:  修改品牌信息
     * <p>
     * 参数:
     * brandId                Integer         品牌id
     * k2MemberAndElseInfo      K2MemberAndElseInfo 操作的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult editBrandInfo(Integer brandId, String brandName, K2MemberAndElseInfo k2MemberAndElseInfo);

    /**
     * -----------------------------------------------------
     * 功能:  修改品牌的状态
     * <p>
     * 参数:
     * state                Integer         品牌状态
     * k2MemberAndElseInfo      K2MemberAndElseInfo 操作的用户信息
     * brandId              Integer         品牌id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult editBrandState(K2MemberAndElseInfo k2MemberAndElseInfo, Integer brandId, Integer state);
}
