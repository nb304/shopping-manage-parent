package com.king2.product.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.AddCategoryDto;
import com.king2.product.server.dto.CategoryIndexManageDto;
import com.king2.product.server.service.ProductCategoryManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


/*=======================================================
	说明:    商品类目管理Controller

	作者		时间					注释
  	俞烨		2019.08.27   			创建
=======================================================*/
@RestController
@CrossOrigin
@RequestMapping("/product/category")
@Validated
public class ProductCategoryManageController {


    // 注入商品类目Service
    @Autowired
    private ProductCategoryManageService productCategoryManageService;

    /**
     * -----------------------------------------------------
     * 功能:  显示商品类目的首页
     * <p>
     * 参数:
     * dto              CategoryIndexManageDto              分页数据
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/index")
    public SystemResult index(HttpServletRequest request, CategoryIndexManageDto categoryIndexManageDto) {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = productCategoryManageService.index(k2Member, categoryIndexManageDto);
        return index;
    }

    /**
     * -----------------------------------------------------
     * 功能:  根据父类信息查询子类的类目信息
     * <p>
     * 参数:
     * parentId              String              父类类目的id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/load/data")
    public SystemResult loadData(@NotBlank(message = "父类di不能为空")
                                 @Pattern(regexp = "[0-9]{1,}") String parentId) {

        // 获取用户数据
        SystemResult index = productCategoryManageService.loadCategoryById(Integer.parseInt(parentId));
        return index;
    }

    /**
     * -----------------------------------------------------
     * 功能:  新增商品的类目信息
     * <p>
     * 参数:
     * dto              AddCategoryDto              新增的类目信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/add")
    public SystemResult add(HttpServletRequest request, @Validated AddCategoryDto dto) {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = productCategoryManageService.addCategory(k2Member, dto);
        return index;
    }


    /**
     * -----------------------------------------------------
     * 功能: 修改商品的类目信息
     * <p>
     * 参数:
     * dto              AddCategoryDto              修改的类目信息
     * categoryId       String                      修改的类目id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/edit")
    public SystemResult edit(HttpServletRequest request, @Validated AddCategoryDto dto,
                             @NotBlank(message = "类目id不能为空") @Pattern(regexp = "[0-9]{1,}") String categoryId) {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = productCategoryManageService.editCategory(k2Member, dto, Integer.parseInt(categoryId));
        return index;
    }

}
