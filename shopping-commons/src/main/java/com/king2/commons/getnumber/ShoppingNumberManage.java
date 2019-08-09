package com.king2.commons.getnumber;

import com.king2.commons.lock.Lock;
import com.king2.commons.lock.impl.DfsRedisLock;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.JsonUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

/*=======================================================
	说明:     商城后台通用的编号工具类

	作者		时间					注释
  	俞烨		2019.08.06   			创建
=======================================================*/
public class ShoppingNumberManage {


    // 实例对象
    private ShoppingNumberPojo shoppingNumberPojo;
    // 编号类型
    private static String type;

    /**
     * 提供商城系统生成唯一编号的操作类,最多存入36长度的编号
     *
     * @throws Exception
     * @shoppingNumberPojo 包括以下字段
     * jedisPool jedis连接池实例
     * script    lua脚本解锁串
     * redisKey  该编号存在于redis中的key
     * prefix    该编号的前缀符号"限制2个长度"
     * size      编号的长度
     * restTemplate 远程调用模板
     * servletUrl 远程服务器地址
     */
    public ShoppingNumberManage(ShoppingNumberPojo shoppingNumberPojo, String type) {
        // 校验数据
        if (shoppingNumberPojo == null) throw new RuntimeException("实例不能为空");
        SystemResult result = shoppingNumberPojo.checkDataInfo();
        if (result.getStatus() != 200) throw new RuntimeException(result.getMsg());
        this.shoppingNumberPojo = shoppingNumberPojo;
        if (StringUtils.isEmpty(type) || (!type.equals(shoppingNumberPojo.NUMBER_TYPE_PRODUCT) && !type.equals(shoppingNumberPojo.NUMBER_TYPE_ORDER))) {
            throw new RuntimeException("请选择正确的类型");
        }
        this.type = type;
    }

    /**
     * -----------------------------------------------------
     * 功能:  添加编号的方法
     * <p>
     * 参数:
     * size         int                 添加几次
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public SystemResult addProductNumberGotoRedis(int addSize) throws Exception {

        // 获取jedis实例
        Jedis JEDIS = shoppingNumberPojo.getJedisPool().getResource();
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
        try {
            JEDIS.set(shoppingNumberPojo.getNUMBER_REDIS_KEY(), JsonUtils.objectToJson(numberQueue));
        } catch (Exception e) {
            e.printStackTrace();
            // 添加到redis中失败了 我们就需要添加到缓存服务器中去
            addProductNumberGotoCache(numberQueue, shoppingNumberPojo.getRestTemplate(), shoppingNumberPojo.getServletUrl());
        }
        JEDIS.close();
        return new SystemResult("成功");
    }

    /**
     * -----------------------------------------------------
     * 功能:  添加编号到Redis中失败，添加到服务器缓存区去
     * <p>
     * 参数:
     * numberQueue         ConcurrentLinkedQueue<String>                 编号队列
     * restTemplate        RestTemplate                                  远程调用模板
     * servlerUrl          String                                        调用的服务地址
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult addProductNumberGotoCache(ConcurrentLinkedQueue<String> numberQueue, RestTemplate restTemplate, String servlerUrl) throws Exception {
        // 调用远程服务 将数据带入缓存服务器中
        MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("queueJson", JsonUtils.objectToJson(numberQueue));
        SystemResult result = restTemplate.postForObject(servlerUrl + "/cache/number/add?type=" + type, requestEntity, SystemResult.class);
        return result;
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
    private void addShoppingNumberGetToMap(Map<String, String> map, int size) {

        /*
            根据编号长度 计算出UUID中需要截取的位数
            11位数的编号 PR123094832
         */
        int legnth = (shoppingNumberPojo.getSIZE() - 2 - 6) > 28 ? 28 : (shoppingNumberPojo.getSIZE() - 2 - 6);
        /*
        这里为什么要用while不用for呢？
        因为编号要唯一 创建的商品编号有可能会出现存在的故障 所以使用HashMap，只存唯一数据，所以不能使用for要使用while
         */
        while (map.size() < size) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            uuid = uuid.substring(uuid.length() - legnth).toUpperCase();
            long time = new Date().getTime();
            String uuid2 = (time + "").substring((time + "").length() - 6);
            map.put((shoppingNumberPojo.getPREFIX() + uuid + uuid2), (shoppingNumberPojo.getPREFIX() + uuid + uuid2));
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

        // 获取jedis实例
        Jedis JEDIS = shoppingNumberPojo.getJedisPool().getResource();

        // 加锁
        // 开启锁
        Lock lock = new DfsRedisLock(this.shoppingNumberPojo.getNUMBER_REDIS_KEY() + "_LOCK", lockTimeOut, JEDIS);
        lock.lock();
        try {
            // 队列编号的JSON信息
            String numbers = "";
            // 根据key获取编号
            while (StringUtils.isEmpty(JEDIS.get(redisKey))) {
                // 查询缓存服务器是否存在数据
                String numberByCacheServer = getNumberByCacheServer();
                if (!StringUtils.isEmpty(numberByCacheServer)) {
                    // 有数据就返回
                    return new SystemResult(numberByCacheServer);
                }

                // 没有编号 创建编号信息
                addProductNumberGotoRedis(10000);
            }
            // 重新赋值
            numbers = JEDIS.get(redisKey);

            // 不等于空说明编号列表中还有数据
            ConcurrentLinkedQueue numberQueue = JsonUtils.jsonToPojo(numbers, ConcurrentLinkedQueue.class);
            if (numberQueue.isEmpty()) {
                // 编码为空 重新生成
                SystemResult systemResult = addProductNumberGotoRedis(10000);
                if (systemResult.getStatus() != 200) return systemResult;
            }
            Object poll = numberQueue.poll();
            // 取出数据后 重新写入redis
            Jedis resource = shoppingNumberPojo.getJedisPool().getResource();
            resource.set(redisKey, JsonUtils.objectToJson(numberQueue));
            resource.close();
            // 返回数据
            return new SystemResult(poll);
        } catch (Exception e) {
            e.printStackTrace();
            // 说明redis又崩了 连接失败 我们就去访问远程缓存服务器地址
            String numberByCacheServer = getNumberByCacheServer();
            if (StringUtils.isEmpty(numberByCacheServer)) return new SystemResult(100, "程序内部异常", null);
            return new SystemResult(numberByCacheServer);
        } finally {
            // 解锁
            // lock.unlock(shoppingNumberPojo.getSCRIPT());
            JEDIS.close();
        }
    }

    /**
     * -----------------------------------------------------
     * 功能:  获取商品编号失败时 就去获取远程的服务器的数据
     * <p>
     * 参数:
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public String getNumberByCacheServer() {

        // 调用远程服务器 获取数据
        SystemResult result = shoppingNumberPojo.getRestTemplate().postForObject(shoppingNumberPojo.getServletUrl() + "/cache/number/get?type=" + type, null, SystemResult.class);
        if (result.getStatus() == 200) {
            return result.getData().toString();
        }
        return null;
    }
}
