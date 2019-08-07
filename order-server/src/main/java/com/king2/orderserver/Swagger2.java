package com.king2.orderserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration //标记配置类
@EnableSwagger2 //开启在线接口文档 访问方式 http://localhost:8888/swagger-ui.html
public class Swagger2 {
    /**
     * 添加摘要信息(Docket)
     */
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("当前是一个订单服务接口")
                        .description("描述：用于电商后台的订单操作信息模块")
                        .contact("刘梓江")
                        .version("1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.king2.orderserver.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
