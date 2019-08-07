package com.king2.product.server.cache;

/*=======================================================
	说明:    商品管理的缓存类

	作者		时间					注释
  	俞烨		2019.08.07   			创建
=======================================================*/
public class SystemCacheManage {

    // 私有化构造 保持全系统只有一个实例
    private SystemCacheManage() {
    }

    // 提供给别人访问的实例和方法
    private static SystemCacheManage systemCacheManage = new SystemCacheManage();

    private static SystemCacheManage getInstance() {
        return systemCacheManage;
    }

    /**
     * 解锁reids 的lua脚本  在classpath:unlock.lua文件中
     */
    public static String UNLOCK_REDIS_LUA = "";
}
