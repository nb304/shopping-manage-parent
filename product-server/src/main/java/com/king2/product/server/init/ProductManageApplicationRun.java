package com.king2.product.server.init;

import cn.hutool.core.date.DateUtil;
import com.king2.commons.getnumber.ShoppingNumberManage;
import com.king2.commons.getnumber.ShoppingNumberPojo;
import com.king2.commons.lock.Lock;
import com.king2.commons.lock.impl.DfsRedisLock;
import com.king2.commons.mapper.K2StroeMapper;
import com.king2.commons.pojo.K2Stroe;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.FileUtil;
import com.king2.product.server.cache.SystemCacheManage;
import com.king2.product.server.dto.LockPojo;
import com.king2.product.server.locks.ProductServerStroeManageLockFactory;
import com.king2.product.server.locks.ProductServerStroeManageLockFactoryTypeEnum;
import com.king2.product.server.log.ProductServerLog;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

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
    // 注入远程调用模板
    @Autowired
    private RestTemplate restTemplate;
    // 注入缓存服务器地址
    @Value("${CACHE_SERVER_URL}")
    private String CACHE_SERVER_URL;

    // 注入店铺Mapper
    @Autowired
    private K2StroeMapper k2StroeMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 创建日志信息
        ProductServerLog.systemInitLog();

        // 初始化reids解锁脚本
        writeRedisLua();

        // 初始化商品编号
        initProductNumber(jedisPool, PRODUCT_NUMBER_REDIS_KEY, restTemplate, CACHE_SERVER_URL);

        // 开启定时添加商品编号的功能
        timerAddProductNumber(20, jedisPool, PRODUCT_NUMBER_REDIS_KEY, restTemplate, CACHE_SERVER_URL);

        // 系统初始化 我们就要去创建关于这个系统的所以店铺的锁
        refreshStoreLock();
    }


    /**
     * 初始化店铺锁
     */
    public void refreshStoreLock() {

        // 获取 商品服务模块 根据店铺类型创建锁的数据
        ProductServerStroeManageLockFactory instance = ProductServerStroeManageLockFactory.getInstance();
        // 开启锁 因为其他地方有可能也会调用
        synchronized (instance) {
            // 获取锁的信息
            ConcurrentHashMap<String, LockPojo> lockMaps = instance.getLockMaps();
            // 查询所有的店铺
            List<K2Stroe> k2Stroes = k2StroeMapper.selectByExample(null);
            // 遍历店铺添加信息
            for (K2Stroe k2Stroe : k2Stroes) {
                // 遍历锁的类型
                for (ProductServerStroeManageLockFactoryTypeEnum value : ProductServerStroeManageLockFactoryTypeEnum.values()) {
                    LockPojo pojo = new LockPojo();
                    pojo.setLock(new ReentrantLock());
                    lockMaps.put(value.getValue() + "_" + k2Stroe.getStroeId(), pojo);
                }
            }
        }


    }

    /**
     * 定义查询是否需要添加商品编号
     *
     * @param sleepTime 每隔几秒
     * @param jedisPool jedisPool连接池
     * @param key       redis的key
     */
    public static void timerAddProductNumber(int sleepTime, JedisPool jedisPool, String key, RestTemplate restTemplate, String URL) {
        // 启动一个新的线程
        new Thread(() -> {
            while (true) {
                try {
                    // 调用添加商品信息
                    initProductNumber(jedisPool, key, restTemplate, URL);
                    // sleep会让出cpu的资源 所以不用害怕资源浪费
                    // sleep会让出cpu的资源 但是不会让出锁资源
                    // wait 会让出cpu的资源 也能让出锁资源
                    Thread.sleep(sleepTime * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


    /**
     * 初始化1000个商品编号
     *
     * @param jedisPool                Jedis连接池
     * @param PRODUCT_NUMBER_REDIS_KEY Redis中的key
     * @throws Exception
     */
    public static void initProductNumber(JedisPool jedisPool, String PRODUCT_NUMBER_REDIS_KEY, RestTemplate restTemplate, String servletUrl) throws Exception {
        Jedis jedis = null;
        Lock lock = null;
        try {
            jedis = jedisPool.getResource();
            lock = new DfsRedisLock(PRODUCT_NUMBER_REDIS_KEY + "_LOCK", 10, jedis);
            // 开启锁
            lock.lock();
            // 获取商品编号的JSON串
            String productNumberJson = jedis.get(PRODUCT_NUMBER_REDIS_KEY);
            if (StringUtils.isEmpty(productNumberJson)) {
                // 已经没有JSON串了 添加1000个JSON串
                ShoppingNumberPojo sp = new ShoppingNumberPojo(jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA, PRODUCT_NUMBER_REDIS_KEY, "SP", 11, restTemplate, servletUrl);
                // 获取商品信息判断是否为空
                ShoppingNumberManage numberManage = new ShoppingNumberManage(sp, sp.NUMBER_TYPE_PRODUCT);
                SystemResult systemResult = numberManage.addProductNumberGotoRedis(1000);
                if (systemResult.getStatus() != 200) {
                    // 创建商品编号失败 写入日志
                    FileUtil.fileWrite(ProductServerLog.PRODUCT_SYSTEM_INFO_FILE,
                            "编号初始化失败,请检查Redis服务是否正常启动---时间:" + DateUtil.formatDateTime(new Date()),
                            true);
                } else {
                    FileUtil.fileWrite(ProductServerLog.PRODUCT_SYSTEM_INFO_FILE,
                            "编号初始化成功,初始化了1000个编号信息---时间:" + DateUtil.formatDateTime(new Date()),
                            true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 用完就回收
            if (jedis != null) jedis.close();
            if (lock != null) lock.unlock(SystemCacheManage.UNLOCK_REDIS_LUA);
        }

    }


    /**
     * 初始化解锁脚本
     *
     * @throws Exception
     */
    public static void writeRedisLua() throws Exception {

        // 获取系统缓存对象
        SystemCacheManage instance = SystemCacheManage.getInstance();
        // 读取lua脚本存储到缓存对象中
        String luaScript = FileUtils.readFileToString(ResourceUtils.getFile("classpath:unlock.lua"), "utf-8");
        // 判断lua脚本是否为空
        if (StringUtils.isEmpty(luaScript)) {
            // 写入日志信息
            FileUtil.fileWrite(ProductServerLog.PRODUCT_SYSTEM_INFO_FILE,
                    "解锁lua脚本注入失败,请检查文件是否存在---时间:" + DateUtil.formatDateTime(new Date()),
                    true);
        }
        instance.UNLOCK_REDIS_LUA = luaScript;
    }
}
