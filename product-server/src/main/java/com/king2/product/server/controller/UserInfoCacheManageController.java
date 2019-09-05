package com.king2.product.server.controller;

import com.king2.commons.result.SystemResult;
import com.king2.product.server.cache.UserInfoCacheManage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/*=======================================================
	说明:    用户缓存管理Controller

	作者		时间					注释
  	俞烨		2019.09.05   		创建
=======================================================*/
@RestController
@CrossOrigin
@Validated
@RequestMapping("/user/cache")
public class UserInfoCacheManageController {

    /**
     * -----------------------------------------------------
     * 功能: 删除用户缓存中的token信息
     * <p>
     * 参数:
     * token         String        用户存在缓存中的token信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/del/cloud")
    public SystemResult del(@NotBlank(message = "需要删除的token不能为空") String token) {

        UserInfoCacheManage instance = UserInfoCacheManage.getInstance();
        synchronized (instance) {
            instance.getUserInfoCacheMapDatas().remove(token);
        }
        return new SystemResult("ok");
    }
}
