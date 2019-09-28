package com.king2.product.server.controller;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.ProductIndexDto;
import com.king2.product.server.service.ProductIndexManageService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/product")
@Validated
public class ProductIndexManageController {

    // 注入商品首页管理Service
    @Autowired
    private ProductIndexManageService productIndexManageService;

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
    @RequestMapping("/index")
    public SystemResult index(HttpServletRequest request, @Validated ProductIndexDto dto) {
        K2MemberAndElseInfo user = (K2MemberAndElseInfo) request.getAttribute("user");
        // 调用服务
        SystemResult index = productIndexManageService.index(user, dto);
        return index;
    }
}
