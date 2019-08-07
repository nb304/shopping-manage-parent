package com.king2.commons.utils;

import com.king2.commons.exceptions.JedisIsNullException;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Redis工具
 */
public class RedisUtil {


    /**
     * 根据Jedis连接池 获取 jedis实例
     *
     * @param jedisPool
     * @return
     */
    public static Jedis getJedisByJedisPool(JedisPool jedisPool) throws Exception {
        if (jedisPool == null) {
            throw new JedisIsNullException("JedisPool IS NULL 请检查连接池的状态");
        }
        return jedisPool.getResource();
    }

}
