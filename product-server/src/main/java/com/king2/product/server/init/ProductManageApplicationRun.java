package com.king2.product.server.init;

import com.king2.product.server.cache.SystemCacheManage;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

/*=======================================================
	说明:    商品管理模块的初始化

	作者		时间					注释
  	俞烨		2019.08.06   			创建
=======================================================*/
@Component
public class ProductManageApplicationRun implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*
            =============================初始化reids解锁脚本==========================
         */
        // 获取系统缓存对象
        SystemCacheManage instance = SystemCacheManage.getInstance();
        // 读取lua脚本存储到缓存对象中
        String luaScript = FileUtils.readFileToString(ResourceUtils.getFile("classpath:unlock.lua"), "utf-8");
        instance.UNLOCK_REDIS_LUA = luaScript;
        /*
            =============================初始化reids解锁脚本(结束)==========================
         */

    }
}
