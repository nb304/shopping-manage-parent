package com.king2.product.server.service;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.ProductIndexDto;

/*=======================================================
	说明:    商品首页管理Service

	作者		时间					注释
  	俞烨		2019.08.11   			创建
=======================================================*/
public interface ProductIndexManageService {

    /**
     * -----------------------------------------------------
     * 功能:  显示商品的首页
     * <p>
     * 参数:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        操作的用户信息
     * dto              ProductIndexDto 分页数据
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, ProductIndexDto dto);
}
