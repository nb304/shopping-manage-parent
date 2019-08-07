package com.king2.orderserver.entiry;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//自动创建get/set
@AllArgsConstructor   //创建带参数构造函数
@NoArgsConstructor   //创建无参数构造函数
public class Order {

    private String oId;

    private String orderNumber;

}
