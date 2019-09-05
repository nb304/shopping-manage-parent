package com.king2.login.server.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis配置文件
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisProperties properties;

    @Bean
    public JedisPool getJedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(properties.getJedis().getPool().getMaxIdle());
        config.setMaxTotal(properties.getJedis().getPool().getMaxActive());
        config.setMaxWaitMillis(properties.getJedis().getPool().getMaxWait().toMillis());
        return new JedisPool(config, properties.getHost(), properties.getPort(), 10000);
    }


    // 注入远程调用模板
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
