package com.king2.commons.utils;

import com.king2.commons.exceptions.UserManageException;
import com.king2.commons.exceptions.pojo.K2Member;
import redis.clients.jedis.Jedis;

/*=======================================================
	说明:    用户管理工具类

	作者		时间					注释
  	俞烨		2019.08.05   			创建
=======================================================*/
public class UserManageUtil {

    /**
     * 创建jedis模板
     */
    private Jedis jedis = null;

    /**
     * 提供jedis带参构造
     *
     * @param jedis Jedis实例
     */
    public UserManageUtil(Jedis jedis) throws Exception {
        if (jedis == null) {
            throw new UserManageException("Jedis实例不能为null,请检查是否注入成功。");
        }
        this.jedis = jedis;
    }


    public K2Member getUserInfoByAccount(String account) {
        return null;
    }
}
