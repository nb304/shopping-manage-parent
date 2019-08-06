package com.king2.commons.exceptions;

/**
 * Jedis为空异常
 */
public class JedisIsNullException extends Exception {

    public JedisIsNullException() {
        super("Jedis初始化异常,请传入Jedis实例");
    }

    public JedisIsNullException(String msg) {
        super(msg);
    }
}
