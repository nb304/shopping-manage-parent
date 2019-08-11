package com.king2.commons.utils;

import com.king2.commons.exceptions.UserManageException;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.result.SystemResult;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.Map;

/*=======================================================
	说明:    用户管理工具类

	作者		时间					注释
  	俞烨		2019.08.05   			创建
=======================================================*/
public class UserManageUtil {

    /**
     * 创建jedis模板
     */
    private JedisPool jedisPool = null;

    /**
     * 用户令牌的key
     */
    public static final String USER_COOKIE_TOKEN = "king2-token";

    /**
     * 用户账号存在Cookie中的key
     */
    public static final String USER_COOKIE_USERNAME = "king2-user-name";

    /**
     * -----------------------------------------------------
     * 功能:  提供jedis带参构造
     * <p>
     * 参数:
     * jedis        Jedis    Jedis实例对象
     * <p>
     * 返回: UserManageUtil               返回用户工具类
     * -----------------------------------------------------
     */
    public UserManageUtil(JedisPool jedisPool) throws Exception {
        if (jedisPool == null) {
            throw new UserManageException("JedisPoll实例不能为null,请检查是否注入成功。");
        }
        this.jedisPool = jedisPool;
    }

    /**
     * -----------------------------------------------------
     * 功能:  根据用户账号和Token获取用户在redis中的信息
     * <p>
     * 参数:
     * account        String      用户存在数据库的唯一标识
     * token          String      用户存在redis中的唯一标识
     * <p>
     * 返回: SystemResult               返回本次执行的结果
     * 返回结果：为null说明用户不存在redis中
     * 状态码：100 异常
     * -----------------------------------------------------
     */
    public SystemResult getUserInfoByAccountAndToken(String account, String token) {

        // 获取jedis实例
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // 判断accout是否为空
            if (StringUtils.isEmpty(account) || StringUtils.isEmpty(token)) {
                return null;
            }
            // 获取用户在redis中的信息
            String userJson = jedis.hget(account, token);
            // 判断是否存在该用户信息
            if (StringUtils.isEmpty(userJson)) {
                jedis.close();
                return new SystemResult(100, "该账号在其他地方登录", null);
            }
            // 将用户Json转换成用户对象
            K2Member k2Member = JsonUtils.jsonToPojo(userJson, K2Member.class);
            return new SystemResult(k2Member);
        } catch (IOException e) {
            return new SystemResult(100, "用户JSON转换失败,请检查JSON格式是否正确。", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, "连接池获取失败。", null);
        } finally {
            if (jedis != null) jedis.close();
        }

    }


    /**
     * -----------------------------------------------------
     * 功能:  保证一个账户只能一个用户在使用
     * <p>
     * 参数:
     * k2Member        K2Member      用户信息
     * token          String         用户存在redis中的唯一标识
     * <p>
     * 返回: SystemResult               返回本次执行的结果
     * 返回结果：SystemResult
     * 状态码：200登录成功、201登录成功，但是前面已经有人登录、100异常
     * -----------------------------------------------------
     */
    public SystemResult refresh(K2Member k2Member, String token) throws Exception {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // 判断用户是否登录
            Map<String, String> userMap = jedis.hgetAll(k2Member.getMemberAccount());
            if (CollectionUtils.isEmpty(userMap)) {
                // 说明redis中没有该用户的信息
                // 往redis中添加数据
                jedis.hset(k2Member.getMemberAccount(), token, JsonUtils.objectToJson(k2Member));
                jedis.close();
                return new SystemResult(200, "登录成功", k2Member);
            }

            SystemResult userInfoResult = getUserInfoByAccountAndToken(k2Member.getMemberAccount(), token);
            if (userInfoResult != null && userInfoResult.getStatus() == 200) {
                // 说明存在
                jedis.close();
                return userInfoResult;
            }

            // 重新刷新用户在redis中的数据
            jedis.del(k2Member.getMemberAccount());
            jedis.hset(k2Member.getMemberAccount(), token, JsonUtils.objectToJson(k2Member));
            return new SystemResult(201, "登录成功", k2Member);
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(500, "系统内部异常", k2Member);
        } finally {
            if (jedis != null) jedis.close();
        }


    }


}
