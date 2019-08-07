package com.king2.orderserver.controller;


import com.king2.orderserver.RemoteClient.ProductRemoteClient;
import com.king2.orderserver.entiry.Order;
import com.king2.orderserver.entiry.SystemResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order")
@Api(tags = "商品订单接口")
public class OrderController {

//    @Autowired
//    private RestTemplate  restTemplate; //调用指定的服务使用Feign调用服务

    @Autowired
    private ProductRemoteClient productRemoteClient; // //使用Fegin组件调用远程的商品服务信息

    @ApiOperation("获取商品信息")
    @GetMapping("/getProducts")
    public SystemResult getOrderOnProducts(){
        //return this.restTemplate.getForObject("http://PRODUCT-SERVER/product/getProducts/上海中心",SystemResult.class);
        return productRemoteClient.getProducts("江西省上饶市广丰县");
    }

    @ApiOperation("获取订单信息")
    @ApiImplicitParam(name = "order", value = "一个订单信息体", dataType = "Order")
    @PostMapping("/setOrder")
    public SystemResult setOrder(@RequestBody Order order){
        order.setOId(order.getOId()+"江西先锋软件职业技术学院");
        return SystemResult.ok(order);
    }

}
