package com.king2.product.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.CookieUtils;
import com.king2.product.server.dto.AddCategoryDto;
import com.king2.product.server.dto.CategoryIndexManageDto;
import com.king2.product.server.service.ProductCategoryManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


/*=======================================================
	说明:    商品类目管理Controller

	作者		时间					注释
  	俞烨		2019.08.27   			创建
=======================================================*/
@RestController
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
    public SystemResult index(HttpServletRequest request, HttpServletResponse response, CategoryIndexManageDto categoryIndexManageDto) {

        Cookie cookie = new Cookie("123", "213");

        cookie.setPath("/");
        cookie.setDomain("192.168.124.5");
        response.addCookie(cookie);
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


    /**
     * -----------------------------------------------------
     * 功能: 修改商品的类目的状态
     * <p>
     * 参数:
     * categoryId       String                      修改的类目id
     * state            String                      本次修改的状态
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/edit/state")
    public SystemResult editState(HttpServletRequest request,
                                  @NotBlank(message = "类目id不能为空") @Pattern(regexp = "[0-9]{1,}") String categoryId,
                                  @NotBlank(message = "状态不能为空") @Pattern(regexp = "[0-9]{1,}") String state) {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = productCategoryManageService.editCategoryState(k2Member, Integer.parseInt(categoryId), state);
        return index;
    }


    /**
     * -----------------------------------------------------
     * 功能: 查看商品类目的SKU信息
     * <p>
     * 参数:
     * categoryId       String                      修改的类目id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/get/category/sku")
    public SystemResult showCategorySku(HttpServletRequest request,
                                        @NotBlank(message = "类目id不能为空") @Pattern(regexp = "[0-9]{1,}") String categoryId) {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = productCategoryManageService.showCategorySKUInfo(k2Member, Integer.parseInt(categoryId));
        return index;
    }


    /**
     * -----------------------------------------------------
     * 功能: 查看商品类目的SKU信息
     * <p>
     * 参数:
     * categoryId       String                      修改的类目id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/add/category/sku")
    public SystemResult addCategorySku(HttpServletRequest request,
                                       @NotBlank(message = "类目id不能为空") @Pattern(regexp = "[0-9]{1,}") String categoryId,
                                       @NotBlank(message = "商品类目SKU不能为空") String skuInfoJson) {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = productCategoryManageService
                .manageAndAddCategoryOfSkuInfo(k2Member, Integer.parseInt(categoryId), skuInfoJson);
        return index;
    }


    /**
     * -----------------------------------------------------
     * 功能: 删除商品类目的SKU信息
     * <p>
     * 参数:
     * skuId       String                     删除的SKUid
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/del/category/sku")
    public SystemResult delCategorySku(HttpServletRequest request,
                                       @NotBlank(message = "类目id不能为空") @Pattern(regexp = "[0-9]{1,}") String skuId) {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = productCategoryManageService
                .delSkuInfo(k2Member, Integer.parseInt(skuId));
        return index;
    }
}
