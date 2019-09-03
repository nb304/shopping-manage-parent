package com.king2.product.server.service;


import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.StoreEntryIndexDto;

/*=======================================================
	说明:    店铺入驻管理Service

	作者		时间					注释
  	俞烨		2019.09.02   		创建
=======================================================*/
public interface StoreEnterManageService {

    /**
     * -----------------------------------------------------
     * 功能:  显示商品入驻的主页信息
     * <p>
     * 参数:
     * dto              StoreEntryIndexDto          分页的数据信息
     * k2MemberAndElseInfo  K2MemberAndElseInfo     登入的用户信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult index(StoreEntryIndexDto dto, K2MemberAndElseInfo k2MemberAndElseInfo);

    /**
     * -----------------------------------------------------
     * 功能:  通过状态修改店铺入驻的信息
     * <p>
     * 参数:
     * k2MemberAndElseInfo  K2MemberAndElseInfo     登入的用户信息
     * storeEnterId         Integer                 店铺入驻的id
     * state                Integer                 状态
     * content              String                  如果状态为拒绝  那么拒绝的理由是什么
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    SystemResult editEnterState(K2MemberAndElseInfo k2MemberAndElseInfo, Integer storeEnterId, Integer state, String content);
}
