package com.king2.product.server.config;

import com.king2.product.server.interceptor.ProductReqeustInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 商城模块的配置类
 */
@Configuration
public class ProductManageConfig implements WebMvcConfigurer {

    // 注入远程调用模板
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    // 注入拦截器
    @Bean
    public ProductReqeustInterceptor productReqeustInterceptor() {
        return new ProductReqeustInterceptor();
    }

    // 配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(productReqeustInterceptor())
                .addPathPatterns("/**");
    }
}
