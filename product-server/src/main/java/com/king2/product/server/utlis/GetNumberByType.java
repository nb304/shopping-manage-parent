package com.king2.product.server.utlis;

import com.king2.commons.getnumber.ShoppingNumberManage;
import com.king2.commons.getnumber.ShoppingNumberPojo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.cache.SystemCacheManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisPool;

/**
 * �������ͻ�ȡ���
 */
@Component
@Scope(value = "prototype")
public class GetNumberByType {

    // �������
    public static String TYPE = "NB";
    // ��ų���
    public static Integer SIZE = 11;
    // ǰ׺
    public static String PX = "NB";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JedisPool jedisPool;

    @Value("${CACHE_SERVER_URL}")
    private String CACHE_SERVER_URL;


    public SystemResult getNumber(String type, Integer size, String px) throws Exception {

        // ����ϵͳ��Ź���
        ShoppingNumberPojo pojo = new ShoppingNumberPojo(jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA, type, px, size, restTemplate, CACHE_SERVER_URL);
        ShoppingNumberManage shoppingNumberManage = new ShoppingNumberManage(pojo, type);
        SystemResult numberByRedisKey = shoppingNumberManage.getNumberByRedisKey(type, 10);
        return numberByRedisKey;
    }
}
