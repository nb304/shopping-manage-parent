package com.king2.product.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.ProductUploadImageAppoint;
import com.king2.product.server.dto.AddProductDto;
import com.king2.product.server.service.ProductBasicsManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*=======================================================
	说明:    商品基础管理Controller

	作者		时间					注释
  	俞烨		2019.08.06   			创建
=======================================================*/
@RequestMapping("/product/basics")
@Validated
@CrossOrigin
@Api("商品基础管理接口")
@RestController
public class ProductBasicsManageController {

    // 注入商品基础管理Service
    @Autowired
    private ProductBasicsManageService productBasicsManageService;
    // 注入商品图片上传的委托类
    @Autowired
    private ProductUploadImageAppoint productUploadImageAppoint;

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
    /*@ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "skuJson", value = "商品SKU的JSON数据串", required = true, dataType = "string"),
                    @ApiImplicitParam(name = "productJson", value = "本次的商品的JSON数据", required = true, dataType = "string"),
                    @ApiImplicitParam(name = "state", value = "判断添加本次SKU时，是否需要添加商品", required = true, dataType = "string")
            })
    @ApiOperation(value = "添加商品的SKU信息", notes = "")
    @PostMapping("/add/sku")
    public SystemResult addProductSku(
            @NotBlank(message = "请填写SKU的信息") String skuJson,
            @NotBlank(message = "请填写商品信息") String productJson,
            @NotBlank(message = "本次状态为空,请刷新页面重试") @Pattern(regexp = "[0-9]{1,}", message = "状态码类型错误") String state, HttpServletRequest request) throws Exception {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");

        // 调用商品服务
        SystemResult systemResult = productBasicsManageService.addProductSku(skuJson, productJson, state, k2Member);
        return systemResult;
    }*/

    /**
     * -----------------------------------------------------
     * 功能:  添加商品的SKU
     * <p>
     * 参数:
     * productDto           AddProductDto           本次添加的商品信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/add")
    public SystemResult addProduct(@Validated AddProductDto productDto, HttpServletRequest request) {

        // 获取登录的用户信息

        return null;
    }

    /**
     * -----------------------------------------------------
     * 功能:  添加商品页面需要的数据
     * <p>
     * 参数:
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @GetMapping("/add/page/info")
    @ApiOperation(value = "添加商品页面时需要的数据接口", notes = "")
    public SystemResult addPageInfo(HttpServletRequest request) throws Exception {
        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        // 调用服务 查询添加商品的基础信息
        SystemResult systemResult = productBasicsManageService.addProductPageInfo(k2Member);
        return systemResult;
    }


    /**
     * -----------------------------------------------------
     * 功能:  通过类目查询SKU信息模板
     * <p>
     * 参数:
     * categoryId             String           类目id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @GetMapping("/get/sku/info")
    @ApiOperation(value = "通过类目查询SKU信息", notes = "")
    public SystemResult getSkuInfoByCategoryId(@NotBlank(message = "类目id不能为空")
                                               @Pattern(regexp = "[0-9]{1,}", message = "类目id的类型错误,请刷新页面重试") String categoryId,
                                               HttpServletRequest request) {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        // 调用服务 查询商品SKU的信息
        SystemResult result = productBasicsManageService.getSkuInfoByCId(Integer.parseInt(categoryId), k2Member);
        return result;
    }

    /**
     * -----------------------------------------------------
     * 功能:  上传图片的方法
     * <p>
     * 参数:
     * file             MultipartFile           图片信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/upload/image")
    @ApiOperation(value = "上传商品图片", notes = "")
    public SystemResult uploadProductImage(@RequestParam("files[]") MultipartFile[] files, @NotBlank(message = "上传图片的状态不能为空") String uploadType,
                                           @NotBlank(message = "商品信息不能为空") @Pattern(regexp = "[0-9]{1,}", message = "商品id类型错误") String productId,
                                           @NotBlank(message = "本次添加的图片次数不能为空") @Pattern(regexp = "[0-9]{1,}", message = "次数类型错误") String size) throws Exception {

        SystemResult product = productUploadImageAppoint.upload(files, "product", Integer.parseInt(productId), Integer.parseInt(size), uploadType);
        return product;
    }

    /**
     * -----------------------------------------------------
     * 功能:  显示商品修改页面并准备数据的方法
     * <p>
     * 参数:
     * productId             String           商品id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @GetMapping("/edit/get/{productId}")
    public SystemResult showEditProductInfo(HttpServletRequest request,
                                            @NotBlank(message = "商品id不能为空") @PathVariable("productId")
                                            @Pattern(regexp = "[0-9]{1,}", message = "商品id类型错误") String productId) {
        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = productBasicsManageService.showEditGetProInfo(Integer.parseInt(productId), k2Member);
        return result;
    }

    /**
     * -----------------------------------------------------
     * 功能:  查询商品的图片信息
     * <p>
     * 参数:
     * productId             String           商品id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @GetMapping("/edit/get/image/{productId}")
    public SystemResult getProductImage(@NotBlank(message = "商品id不能为空") @PathVariable("productId")
                                        @Pattern(regexp = "[0-9]{1,}", message = "商品id类型错误") String productId) {
        SystemResult result = productBasicsManageService.getProductImageByPId(Integer.parseInt(productId));
        return result;
    }

    /**
     * -----------------------------------------------------
     * 功能:  修改商品信息
     * <p>
     * 参数:
     * k2ProductWithBLOBs             K2ProductWithBLOBs           修改的商品信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/edit/info")
    public SystemResult edit(HttpServletRequest request, @Validated K2ProductWithBLOBs k2ProductWithBLOBs) {
        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = productBasicsManageService.editProductInfo(k2ProductWithBLOBs, k2Member);
        return result;
    }


    /**
     * -----------------------------------------------------
     * 功能:  逻辑删除商品信息
     * <p>
     * 参数:
     * productId             String           商品id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/del")
    public SystemResult del(@NotBlank(message = "商品id不能为空") @Pattern(regexp = "[0-9]{1,}", message = "商品id的类型错误") String productId,
                            @NotBlank(message = "商品状态不能为空") @Pattern(regexp = "[0-9]{1,}", message = "商品状态类型错误") String state,
                            HttpServletRequest request) {
        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = productBasicsManageService.delProductInfo(Integer.parseInt(productId), k2Member, Integer.parseInt(state));
        return result;
    }
}
