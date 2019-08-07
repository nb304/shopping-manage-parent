package com.king2.commons.getnumber;

import com.king2.commons.exceptions.JedisIsNullException;
import com.king2.commons.lock.Lock;
import com.king2.commons.lock.impl.DfsRedisLock;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.JsonUtils;
import freemarker.template.SimpleDate;
import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

/*=======================================================
	说明:     商品编号的队列信息

	作者		时间					注释
  	俞烨		2019.08.06   			创建
=======================================================*/
public class ShoppingNumberManage {

    // 创建jedis模板对象
    private Jedis JEDIS;
    // 创建jedis解锁的脚本
    private String SCRIPT;
    // 编号存在redis中的key
    private String NUMBER_REDIS_KEY;
    // 编号的前缀
    private String PREFIX = "K2";
    // 编号的长度
    private int SIZE = 11;

    /**
     * 提供商城系统生成唯一编号的操作类,最多存入36长度的编号
     *
     * @param jedis    jedis实例
     * @param script   lua脚本解锁串
     * @param redisKey 该编号存在于redis中的key
     * @param prefix   该编号的前缀符号"限制2个长度"
     * @param size     编号的长度
     * @throws Exception
     */
    public ShoppingNumberManage(Jedis jedis, String script, String redisKey, String prefix, int size) throws Exception {
        if (jedis == null || StringUtils.isEmpty(script)) {
            throw new JedisIsNullException("redis实例为空或者解锁的脚本为空,请检查代码");
        } else if (StringUtils.isEmpty(redisKey)) {
            throw new RuntimeException("编号存在redis中的key不能为空");
        } else if (!StringUtils.isEmpty(prefix) && prefix.length() == 2) {
            this.PREFIX = prefix;
        } else if (size < 11) {
            throw new RuntimeException("编号的长度必须大于10");
        }

        this.JEDIS = jedis;
        this.SCRIPT = script;
        this.NUMBER_REDIS_KEY = redisKey;
        this.SIZE = size;
    }

    /**
     * -----------------------------------------------------
     * 功能:  添加编号的方法
     * <p>
     * 参数:
     * size         int                 添加几次
     * lockTimeOut  int             锁的过期时间单位毫秒
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public SystemResult addProductNumber(int addSize, int lockTimeOut) throws Exception {

        // 开启锁
        Lock lock = new DfsRedisLock(this.NUMBER_REDIS_KEY + "_LOCK", lockTimeOut, this.JEDIS);
        lock.lock();
        try {
            ConcurrentLinkedQueue<String> numberQueue = new ConcurrentLinkedQueue<>();
            // 创建hashMap保证唯一
            Map<String, String> numberMap = new HashMap<>();
            /**
             *   调用方法 往map里面设置参数
             *    numberMap为map的实例
             *    size 往map里面添加几个参数
             */
            addShoppingNumberGetToMap(numberMap, addSize);
            // 获取成功 遍历Map值存入Queue中
            for (Map.Entry<String, String> entry : numberMap.entrySet()) {
                numberQueue.add(entry.getValue());
            }
            // 重新存入redis中
            JEDIS.set(NUMBER_REDIS_KEY, JsonUtils.objectToJson(numberQueue));
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, "系统异常", null);
        } finally {
            // 解锁
            lock.unlock(this.SCRIPT);
        }
        return new SystemResult("成功");
    }


    /**
     * -----------------------------------------------------
     * 功能:  添加商品编号到Map集合中去
     * <p>
     * 参数:
     * map         Map<String, String>         需要添加的集合
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public void addShoppingNumberGetToMap(Map<String, String> map, int size) {

        /*
            根据编号长度 计算出UUID中需要截取的位数
            11位数的编号 PR123094832
         */
        int legnth = (SIZE - 2 - 6) > 28 ? 28 : (SIZE - 2 - 6);
        /*
        这里为什么要用while不用for呢？
        因为编号要唯一 创建的商品编号有可能会出现存在的故障 所以使用HashMap，只存唯一数据，所以不能使用for要使用while
         */
        while (map.size() < size) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            uuid = uuid.substring(uuid.length() - legnth).toUpperCase();
            long time = new Date().getTime();
            String uuid2 = (time + "").substring((time + "").length() - 6);
            map.put((PREFIX + uuid + uuid2), (PREFIX + uuid + uuid2));
        }
    }


    /**
     * -----------------------------------------------------
     * 功能:  根据redis的key获取对应的商品编号
     * <p>
     * 参数:
     * redisKey     String          Redis的key
     * lockTimeOut  int             锁的过期时间单位毫秒
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public SystemResult getNumberByRedisKey(String redisKey, int lockTimeOut) throws Exception {

        // 加锁
        // 开启锁
        Lock lock = new DfsRedisLock(this.NUMBER_REDIS_KEY + "_LOCK", lockTimeOut, this.JEDIS);
        lock.lock();
        try {
            // 根据key获取编号
            String numbers = JEDIS.get(redisKey);
            if (StringUtils.isEmpty(numbers)) {
                return new SystemResult(202, "编码为空", null);
            }
            // 不等于空说明编号列表中还有数据
            ConcurrentLinkedQueue numberQueue = JsonUtils.jsonToPojo(numbers, ConcurrentLinkedQueue.class);
            if (numberQueue.isEmpty()) {
                // 编码为空 重新生成
                SystemResult systemResult = addProductNumber(10000, 0);
                if (systemResult.getStatus() != 200) return systemResult;
            }
            Object poll = numberQueue.poll();
            // 取出数据后 重新写入redis
            JEDIS.set(redisKey, JsonUtils.objectToJson(numberQueue));
            // 返回数据
            return new SystemResult(poll);
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, "程序内部异常", null);
        } finally {
            // 解锁
            lock.unlock(this.SCRIPT);
        }
    }
}
