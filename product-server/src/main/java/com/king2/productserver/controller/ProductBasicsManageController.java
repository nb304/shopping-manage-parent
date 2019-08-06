package com.king2.productserver.controller;

import com.king2.commons.result.SystemResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*=======================================================
	说明:    商品基础管理Controller

	作者		时间					注释
  	俞烨		2019.08.06   			创建
=======================================================*/
@RestController
@RequestMapping("/product/basics")
@Validated
public class ProductBasicsManageController {

    /**
     * -----------------------------------------------------
     * 功能:  添加商品的SKU
     * <p>
     * 参数:
     * skuJson          String          SKU的JSON数据
     * state            String          本次是否还需要继续添加商品信息  1需要  2不需要
     * productInfo      String          商品的JSON数据
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/addProductSku")
    public SystemResult addProductSku(
            @NotBlank(message = "请填写SKU的信息") String skuJson, @NotBlank(message = "请填写商品信息") String productInfo,
            @NotBlank(message = "本次状态为空,请刷新页面重试") @Pattern(regexp = "[0-9]{1,}", message = "状态码类型错误") String state, HttpServletRequest request) {


        return null;
    }
}
