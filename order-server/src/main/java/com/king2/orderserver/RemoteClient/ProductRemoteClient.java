package com.king2.orderserver.RemoteClient;


import com.king2.orderserver.entiry.SystemResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//使用声明式服务调用形式,对远程服务进行操作
@FeignClient(name = "PRODUCT-SERVER" ,fallback = HystrixProductRemoteClient.class)
public interface ProductRemoteClient {

    //获取远程的服务接口信息
    @GetMapping("/product/getProducts/{mess}")
    SystemResult getProducts(@PathVariable("mess") String mess2);

}

//编写对应商品服务的断容器功能
@Component
class HystrixProductRemoteClient implements ProductRemoteClient {

    //调用远程服务接口失效,调用该方法进行处理
    @Override
    public SystemResult getProducts(String mess2) {
        return SystemResult.build(405,"远程商品服务时效请稍后再试");
    }
}


