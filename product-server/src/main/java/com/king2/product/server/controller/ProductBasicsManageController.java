package com.king2.product.server.controller;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.service.ProductBasicsManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*=======================================================
	说明:    商品基础管理Controller

	作者		时间					注释
  	俞烨		2019.08.06   			创建
=======================================================*/
@Controller
@RequestMapping("/product/basics")
@Validated
@CrossOrigin
@Api("商品基础管理接口")
public class ProductBasicsManageController {

    // 注入商品基础管理Service
    @Autowired
    private ProductBasicsManageService productBasicsManageService;

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
    @ApiOperation(value = "添加商品的SKU信息", notes = "")
    @PostMapping("/add/sku")
    @ResponseBody
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "skuJson", value = "商品的SKU的JSON信息串", required = true, dataType = "string"),
                    @ApiImplicitParam(name = "productInfo", value = "本次的商品信息", required = true, dataType = "string"),
                    @ApiImplicitParam(name = "state", value = "判断本次添加SKU时，是否需要添加商品", required = true, dataType = "string")
            })
    public SystemResult addProductSku(
            @NotBlank(message = "请填写SKU的信息") String skuJson,
            @NotBlank(message = "请填写商品信息") String productInfo,
            @NotBlank(message = "本次状态为空,请刷新页面重试") @Pattern(regexp = "[0-9]{1,}", message = "状态码类型错误") String state, HttpServletRequest request) throws Exception {

        // 模拟用户信息
        K2Member k2Member = new K2Member();
        k2Member.setMemberId(1);
        k2Member.setMemberAccount("luqiqi");
        k2Member.setRetain1("1");

        // 调用商品服务
        SystemResult systemResult = productBasicsManageService.addProductSku(skuJson, productInfo, state, k2Member);
        return systemResult;
    }
}
