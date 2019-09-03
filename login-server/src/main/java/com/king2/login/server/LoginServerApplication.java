package com.king2.login.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient //指定Eureka-Client客户端也就是服务提供者
@EnableFeignClients  //使用Feign声明式服务调用组件,不用RestTemplate进行服务使用
@MapperScan({"com.king2.commons.mapper", "com.king2.login.server.mapper"})
public class LoginServerApplication {


    //开启客户端负载均衡的功能,这样就能使用服务名调用服务而不是直接ip+端口访问
    //resttemplate只是类似于httpclient的一个发送rest风格的请求，它这里是没有办法去识别所谓的服务名的
//    @Bean            //@loadBalance注解修饰的restTemplate才能实现服务名的调用，没有修饰的restTemplate是没有该功能的
//    @LoadBalanced    //如果使用@LoadBalanced还是没用,就判断当前本地是否对域名解析二次动了手脚导致的
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(LoginServerApplication.class, args);
    }
}
