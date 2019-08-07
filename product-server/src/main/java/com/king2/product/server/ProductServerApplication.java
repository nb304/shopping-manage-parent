package com.king2.product.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;


//@EnableEurekaClient //指定Eureka-Client客户端也就是服务提供者
@SpringBootApplication
@MapperScan({"com.king2.commons.mapper.*", "com.king2.product.server.mapper.*"})
@PropertySource(value = {"classpath:product-config.properties"})
@ServletComponentScan("com.king2.commons.utils")
public class ProductServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServerApplication.class, args);
    }

}
