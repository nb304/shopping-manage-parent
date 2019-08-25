package com.king2.product.server.controller;

import com.king2.commons.result.SystemResult;
import com.king2.product.server.service.ProductSkuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*=======================================================
	说明:    商品SKU管理Controller

	作者		时间					注释
  	俞烨		2019.08.21   			创建
=======================================================*/
@RestController
@RequestMapping("/product/sku")
@Validated
@CrossOrigin
public class ProductSkuManageController {


    // 注入商品SKU管理Service
    @Autowired
    private ProductSkuManageService productSkuManageService;

    /**
     * -----------------------------------------------------
     * 功能:   获取商品SKU的信息
     * <p>
     * 参数:
     * productId          String         商品id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @GetMapping("/get/{productId}")
    public SystemResult get(@PathVariable("productId") @NotBlank(message = "商品id不能为空")
                            @Pattern(regexp = "[0-9]{1,}", message = "商品id类型错误") String productId) {
        SystemResult skuByProductId = productSkuManageService.getSkuByProductId(Integer.parseInt(productId));
        return skuByProductId;
    }

    /**
     * -----------------------------------------------------
     * 功能:    修改商品的库存信息
     * <p>
     * 参数:
     * productSkuKcJson          String         商品库存的json
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/edit")
    public SystemResult edit(@NotBlank(message = "商品库存信息不能为空") String productSkuKcJson) {
        SystemResult result = productSkuManageService.editSkuInfo(productSkuKcJson);
        return result;
    }
}
