package com.king2.product.server.controller;

import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.ProductIndexDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/*=======================================================
	说明:    商品页面的首页显示

	作者		时间					注释
  	俞烨		2019.08.11   			创建
=======================================================*/
@RestController
@CrossOrigin
@RequestMapping("/product/index")
@Validated
public class ProductIndexManageController {

    /**
     * -----------------------------------------------------
     * 功能:   商品首页的显示
     * <p>
     * 参数:
     * dto          ProductIndexDto         商品分页的数据
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/")
    public SystemResult index(HttpServletRequest request, ProductIndexDto dto) {
        return null;
    }
}
