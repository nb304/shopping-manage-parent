package com.king2.product.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableEurekaClient //指定Eureka-Client客户端也就是服务提供者
@SpringBootApplication
@MapperScan({"com.king2.commons.mapper", "com.king2.product.server.mapper"})
@PropertySource(value = {"classpath:product-config.properties"})
@ServletComponentScan("com.king2.commons.utils.EncodingFilter")
@EnableSwagger2
@ComponentScan(basePackages = {"com.king2.product.server.*", "com.king2.commons.getnumber"})
public class ProductServerApplication {


    public static void main(String[] args) {

        SpringApplication.run(ProductServerApplication.class, args);
    }

}
