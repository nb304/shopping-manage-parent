package com.king2.commons.getnumber;

import com.king2.commons.exceptions.JedisIsNullException;
import com.king2.commons.lock.Lock;
import com.king2.commons.lock.impl.DfsRedisLock;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.JsonUtils;
import freemarker.template.SimpleDate;
import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.SimpleFormatter;

/*=======================================================
	说明:     商品编号的队列信息

	作者		时间					注释
  	俞烨		2019.08.06   			创建
=======================================================*/
public class ProductNumberManage {

    // 创建jedis模板对象
    private Jedis JEDIS;
    // 创建jedis解锁的脚本
    private String SCRIPT;
    // 商品编号存在redis中的key
    private String PRODUCT_REDIS_KEY = "PRODUCT-REDIS-KEY21483";

    // 提供jedis模板对象和jedis解锁的脚本
    public ProductNumberManage(Jedis jedis, String script) throws Exception {
        if (jedis == null || StringUtils.isEmpty(script)) {
            throw new JedisIsNullException("redis实例为空或者解锁的脚本为空,请检查代码");
        }
        this.JEDIS = jedis;
        this.SCRIPT = script;
    }

    /**
     * -----------------------------------------------------
     * 功能:  添加商品编号的方法
     * <p>
     * 参数:
     * size         int                 添加几次
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public SystemResult addProductNumber(int size) throws Exception {

        // 开启锁
        Lock lock = new DfsRedisLock("PRODUCT_REDIS_LOCK", null, this.JEDIS);
        lock.lock();
        try {
            ConcurrentLinkedQueue<String> numberQueue = new ConcurrentLinkedQueue<>();
            // 创建hashMap保证唯一
            Map<String, String> numberMap = new HashMap<>();
            // 获取redis上剩下的参数队列
            String productNumberQueue = JEDIS.get(PRODUCT_REDIS_KEY);
            if (StringUtils.isEmpty(productNumberQueue)) {
                // 根据传进来的size进行创建编号次数
                while (numberMap.size() <= size) {
                    // 创建唯一标识
                    String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                    uuid = uuid.substring(uuid.length() - 5);
                    String uuid2 = new SimpleDateFormat("hhmmss").format(new Date());
                    numberMap.put(uuid + uuid2, uuid + uuid2);
                }
            } else {
                // 说明有值
                numberQueue = JsonUtils.jsonToPojo(productNumberQueue, ConcurrentLinkedQueue.class);
                // 获取到现在的长度
                int queueSize = numberQueue.size();
                while (numberMap.size() <= (queueSize + size)) {
                    // 创建唯一标识
                    String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                    uuid = uuid.substring(uuid.length() - 5);
                    String uuid2 = new SimpleDateFormat("hhmmss").format(new Date());
                    numberMap.put(uuid + uuid2, uuid + uuid2);
                }
            }

            // 获取成功 遍历Map值存入Queue中
            for (Map.Entry<String, String> entry : numberMap.entrySet()) {
                numberQueue.add(entry.getValue());
            }

            // 重新存入redis中
            JEDIS.set(PRODUCT_REDIS_KEY , JsonUtils.objectToJson(numberQueue));
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, "系统异常", null);
        } finally {
            // 解锁
            lock.unlock(this.SCRIPT);
        }
        return new SystemResult("成功");
    }

}
