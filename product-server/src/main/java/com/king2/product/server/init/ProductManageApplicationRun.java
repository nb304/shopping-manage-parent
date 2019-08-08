package com.king2.product.server.init;

import com.king2.commons.getnumber.ShoppingNumberManage;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.cache.SystemCacheManage;
import com.king2.product.server.log.ProductServerLog;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/*=======================================================
	说明:    商品管理模块的初始化

	作者		时间					注释
  	俞烨		2019.08.08   			创建
=======================================================*/
@Component
public class ProductManageApplicationRun implements ApplicationRunner {

    // 注入商品编号存在redis中的key
    @Value("${PRODUCT_NUMBER_REDIS_KEY}")
    private String PRODUCT_NUMBER_REDIS_KEY;
    // 注入Jedis连接池
    @Autowired
    private JedisPool jedisPool;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        // 创建日志信息
        ProductServerLog.systemInitLog();
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

        /*
            =============================初始化商品编号==========================
         */

        Jedis jedis = jedisPool.getResource();
        // 获取商品编号的JSON串
        String productNumberJson = jedis.get(PRODUCT_NUMBER_REDIS_KEY);
        if (StringUtils.isEmpty(productNumberJson)) {
            // 已经没有JSON串了 添加1000个JSON串
            ShoppingNumberManage numberManage = new ShoppingNumberManage(jedisPool, luaScript, PRODUCT_NUMBER_REDIS_KEY, "SP", 11);
            SystemResult systemResult = numberManage.addProductNumber(1000);
            if (systemResult.getStatus() != 200) {
                // 写入日志

            }
        }
         /*
            =============================初始化商品编号（结束）==========================
         */
    }
}
