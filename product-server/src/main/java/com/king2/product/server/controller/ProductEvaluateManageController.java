package com.king2.product.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.ProductEvaluateIndexDto;
import com.king2.product.server.service.ProductEvaluateManageService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*=======================================================
	说明:    商品评价管理Controller

	作者		时间					注释
  	俞烨		2019.08.29   			创建
=======================================================*/
@RestController
@Validated
@RequestMapping("/product/evaluate")
@CrossOrigin
public class ProductEvaluateManageController {

    // 注入评价管理Service
    @Autowired
    private ProductEvaluateManageService productEvaluateManageService;

    /**
     * -----------------------------------------------------
     * 功能:  显示商品评价的首页
     * <p>
     * 参数:
     * dto              ProductEvaluateIndexDto 分页数据
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/index")
    public SystemResult index(ProductEvaluateIndexDto dto, HttpServletRequest request) {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = productEvaluateManageService.index(dto, k2Member);
        return index;
    }


    /**
     * -----------------------------------------------------
     * 功能:  回复内容
     * <p>
     * 参数:
     * evalId           String          回复的评价id
     * content          String          回复的内容
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/reply")
    public SystemResult reply(
            @NotBlank(message = "评价的id不能为空")
            @Pattern(regexp = "[0-9]{1,}") String evalId,
            @NotBlank(message = "回复的内容不能为空") @Length(max = 500) String content, HttpServletRequest request) {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = productEvaluateManageService.replyContent(Integer.parseInt(evalId), k2Member, content);
        return index;
    }
}
