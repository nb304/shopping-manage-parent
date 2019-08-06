package com.king2.productserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;


@EnableEurekaClient //指定Eureka-Client客户端也就是服务提供者
@SpringBootApplication
@MapperScan({"com.king2.commons.mapper"})
@PropertySource(value = {"classpath:product-config.properties"})
public class ProductServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServerApplication.class, args);
    }

}
