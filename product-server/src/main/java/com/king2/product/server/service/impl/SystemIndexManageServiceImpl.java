package com.king2.product.server.service.impl;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.SystemIndexManageAppiont;
import com.king2.product.server.service.SystemIndexManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/*=======================================================
	说明:    系统首页管理Service实现类

	作者		时间					注释
  	俞烨		2019.08.24   			创建
=======================================================*/
@Service
public class SystemIndexManageServiceImpl implements SystemIndexManageService {


    // 注入首页管理委托类
    @Autowired
    private SystemIndexManageAppiont systemIndexManageAppiont;

    /**
     * -----------------------------------------------------
     * 功能:  商城系统的首页信息
     * <p>
     * 参数:
     * k2MemberAndElseInfo      K2MemberAndElseInfo     登入的用户信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult systemIndex(K2MemberAndElseInfo k2MemberAndElseInfo) {

        // 查询商品首页的信息
        // 根据他是系统管理员还是其他角色信息 查询出信息

        // 查询该用户的信息
        SystemResult userMeesageCacheById = systemIndexManageAppiont.getMessageByUserId(k2MemberAndElseInfo.getK2Member().getMemberId());
        return userMeesageCacheById;
    }

}
