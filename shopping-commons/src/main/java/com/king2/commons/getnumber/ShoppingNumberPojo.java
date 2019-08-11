package com.king2.commons.getnumber;

import com.king2.commons.result.SystemResult;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisPool;

public class ShoppingNumberPojo {

    /**
     * 本地缓存中商品编号的KEY
     */
    public static final String NUMBER_TYPE_PRODUCT = "NUMBER_CACHE_PRODUCT";

    /**
     * 本地缓存中订单编号的KEY
     */
    public static final String NUMBER_TYPE_ORDER = "NUMBER_CACHE_ORDER";

    /**
     * 商品图片的名称
     */
    public static final String PRODUCT_NAME_IMAGE = "PRODUCT_NAME_IMAGE";

    public ShoppingNumberPojo(JedisPool jedisPool, String SCRIPT, String NUMBER_REDIS_KEY, String PREFIX, int SIZE, RestTemplate restTemplate, String servletUrl) {
        this.jedisPool = jedisPool;
        this.SCRIPT = SCRIPT;
        this.NUMBER_REDIS_KEY = NUMBER_REDIS_KEY;
        this.PREFIX = PREFIX;
        this.SIZE = SIZE;
        this.restTemplate = restTemplate;
        this.servletUrl = servletUrl;
    }

    // 创建jedis连接池对象
    private JedisPool jedisPool;
    // 创建jedis解锁的脚本
    private String SCRIPT;
    // 编号存在redis中的key
    private String NUMBER_REDIS_KEY;
    // 编号的前缀
    private String PREFIX = "K2";
    // 编号的长度
    private int SIZE = 11;
    // 远程调用模板
    private RestTemplate restTemplate;
    // 远程服务器
    private String servletUrl;


    public SystemResult checkDataInfo() {

        if (jedisPool == null || StringUtils.isEmpty(SCRIPT)) {
            return new SystemResult(100, "jedisPool实例为空或者解锁的脚本为空,请检查代码", null);
        } else if (StringUtils.isEmpty(NUMBER_REDIS_KEY)) {
            return new SystemResult(100, "编号存在redis中的key不能为空", null);
        } else if (!StringUtils.isEmpty(PREFIX) && PREFIX.length() == 2) {
            this.PREFIX = PREFIX;
        } else if (SIZE < 11) {
            return new SystemResult(100, "编号的长度必须大于10", null);
        } else if (restTemplate == null || StringUtils.isEmpty(servletUrl)) {
            return new SystemResult(100, "远程调用模板和服务器地址不能为空,因为有可能操作redis会失败,需要用到其他缓存服务器。", null);
        }
        return new SystemResult("ok");
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public String getSCRIPT() {
        return SCRIPT;
    }

    public void setSCRIPT(String SCRIPT) {
        this.SCRIPT = SCRIPT;
    }

    public String getNUMBER_REDIS_KEY() {
        return NUMBER_REDIS_KEY;
    }

    public void setNUMBER_REDIS_KEY(String NUMBER_REDIS_KEY) {
        this.NUMBER_REDIS_KEY = NUMBER_REDIS_KEY;
    }

    public String getPREFIX() {
        return PREFIX;
    }

    public void setPREFIX(String PREFIX) {
        this.PREFIX = PREFIX;
    }

    public int getSIZE() {
        return SIZE;
    }

    public void setSIZE(int SIZE) {
        this.SIZE = SIZE;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getServletUrl() {
        return servletUrl;
    }

    public void setServletUrl(String servletUrl) {
        this.servletUrl = servletUrl;
    }
}
