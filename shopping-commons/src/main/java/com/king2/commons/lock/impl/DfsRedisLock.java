package com.king2.commons.lock.impl;

import com.king2.commons.exceptions.JedisIsNullException;
import com.king2.commons.lock.Lock;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.UUID;

/**
 * Redis锁工具
 */
public class DfsRedisLock implements Lock {

    // 定义默认锁的KEY
    private static String KEY = "DFS_REDIS_DEFAULT_KEY";
    // 定义默认的锁失效时间 默认为100秒
    private static Long timeout = 100l;
    // 定义线程通讯
    private static ThreadLocal<String> local = new ThreadLocal<String>();
    // 定义默认Jedis
    private Jedis jedis = null;

    /**
     * 提供代参构造
     *
     * @param Redis_KEY
     * @param timeout
     * @param jedis
     */
    public DfsRedisLock(String Redis_KEY, Integer timeout, Jedis jedis) throws Exception {
        if (!StringUtils.isEmpty(Redis_KEY)) {
            this.KEY = Redis_KEY;
        }
        if (timeout != null && timeout != 0) {
            this.timeout = timeout.longValue();
        }
        if (jedis == null) {
            throw new JedisIsNullException();
        } else {
            this.jedis = jedis;
        }
    }

    /**
     * 线程阻塞锁
     */
    @Override
    public void lock() {
        /*
            线程阻塞锁，没获取到锁会一直等待，直到获取锁
            实现RedisLock步骤
            1、必须给每个锁设置过期时间 防止死锁
            2、加锁时给每个锁的value设置随机字符串 防止删除锁时误删
            3、Redis加锁必须是原子性的
         */
        while (true) {
            // 获取随机的UUID
            String value = UUID.randomUUID().toString();
            // 尝试加锁
            String addRedisLockFlag = jedis.set(KEY, value, "NX", "EX", timeout);
            // 判断是否加锁成功
            if ("OK".equals(addRedisLockFlag)) {
                // 加锁成功
                local.set(value);
                // 退出
                break;
            }
        }
    }

    /**
     * 尝试加锁(只尝试一次)  失败返回false  成功返回true
     *
     * @return
     */
    @Override
    public boolean tryLock() {
        // 获取随机的UUID
        String value = UUID.randomUUID().toString();
        // 尝试加锁
        String addRedisLockFlag = jedis.set(KEY, value, "NX", "EX", timeout);
        // 判断是否加锁成功
        if ("OK".equals(addRedisLockFlag)) {
            // 加锁成功
            local.set(value);
            // 退出
            return true;
        }
        return false;
    }

    /**
     * 解锁  解锁也是需要原子性的 所以我们用lua脚本完成
     *
     * @return
     */
    @Override
    public boolean unlock(String srcipt) throws Exception {
        // 读取lua脚本
        // String srcipt = FileUtils.readFileToString(new File(luaPath));
        Object eval = jedis.eval(srcipt, Arrays.asList(KEY), Arrays.asList(local.get()));
        return true;
    }
}
