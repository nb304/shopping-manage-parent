package com.king2.commons.getnumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

@Component
public class TestNumber {


    @Autowired
    private JedisPool jedisPool;

    public void test() {

        System.out.println(jedisPool);
    }
}
