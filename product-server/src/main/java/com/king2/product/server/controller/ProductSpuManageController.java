package com.king2.product.server.controller;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.service.ProductSpuManageService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*=======================================================
	说明:    商品SPU管理Controller

	作者		时间					注释
  	俞烨		2019.08.20   			创建
=======================================================*/
@RestController
@RequestMapping("/product/spu")
@Validated
@CrossOrigin
public class ProductSpuManageController {

    // 注入商品SPUService
    @Autowired
    private ProductSpuManageService productSpuManageService;


    /**
     * -----------------------------------------------------
     * 功能:  查询商品的SPU操作
     * <p>
     * 参数:
     * productId        String          商品id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @GetMapping("/get/{productId}")
    public SystemResult get(@PathVariable("productId") @NotBlank(message = "商品id不能为空")
                            @Pattern(regexp = "[0-9]{1,}", message = "类型错误") String productId) {
        SystemResult spuByPId = productSpuManageService.getSpuByPId(Integer.parseInt(productId));
        return spuByPId;
    }

    /**
     * -----------------------------------------------------
     * 功能:  删除商品的SPU信息
     * <p>
     * 参数:
     * spuId        String          商品的SPUid
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/del")
    public SystemResult del(@NotBlank(message = "商品SpuId不能为空")
                            @Pattern(regexp = "[0-9]{1,}", message = "类型错误") String productSpuId, HttpServletRequest request) {
        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = productSpuManageService.delSpuById(Integer.parseInt(productSpuId), k2Member);
        return result;
    }


    /**
     * -----------------------------------------------------
     * 功能:  恢复SPU的信息
     * <p>
     * 参数:
     * spuId        String          商品的SPUid
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/normal")
    public SystemResult normal(@NotBlank(message = "商品SpuId不能为空")
                               @Pattern(regexp = "[0-9]{1,}", message = "类型错误") String productSpuId, HttpServletRequest request) {
        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = productSpuManageService.recoverNormal(Integer.parseInt(productSpuId), k2Member);
        return result;
    }

    /**
     * -----------------------------------------------------
     * 功能:  批量注销商品的SPU信息
     * <p>
     * 参数:
     * spuIds        String         商品的SPUIds
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/cancel")
    public SystemResult batchCancelSpu(@NotBlank(message = "请选择你要注销的商品SPU信息") String spuIds, HttpServletRequest request) {
        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = productSpuManageService.batchCancelSpu(spuIds, k2Member);
        return result;
    }

    /**
     * -----------------------------------------------------
     * 功能:  修改商品参数的信息
     * <p>
     * 参数:
     * spuKey        String         商品的SPU的名称
     * skuValue      String         商品的参数值
     * productSpuId  String         商品参数的Id
     * order        Integer         排序
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/edit")
    public SystemResult edit(@NotBlank(message = "请填写商品参数的名称") @Length(min = 1, max = 20, message = "商品参数的名称长度为1-20字符") String productSpuName,
                             @NotBlank(message = "请填写商品参数的值") @Length(min = 1, max = 100, message = "商品参数的值长度为1-100字符") String productSpuValue,
                             @NotBlank(message = "请填写商品的排序") @Length(min = 1, max = 100000, message = "商品参数的排序长度为1-10000字符")
                             @Pattern(regexp = "[0-9]{1,}", message = "商品排序的规则为数字") String productSpuOrder,
                             @NotBlank(message = "请填写商品参数Id") @Pattern(regexp = "[0-9]{1,}", message = "商品参数Id的规则为数字") String productSpuId,
                             HttpServletRequest request) {
        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = productSpuManageService.editSpuInfo(productSpuName, productSpuValue, Integer.parseInt(productSpuOrder),
                Integer.parseInt(productSpuId), k2Member);
        return result;
    }


    /**
     * -----------------------------------------------------
     * 功能:  添加商品的SPU信息
     * <p>
     * 参数:
     * productSpuJson             String           SPU的JSON数据
     * productId                  String           商品id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/add")
    public SystemResult addProductSpu(@NotBlank(message = "商品SPU数据不能为空") String productSpuJson,
                                      @NotBlank(message = "商品Id不能为空") @Pattern(regexp = "[0-9]{1,}", message = "商品ID类型错误") String productId, HttpServletRequest request) {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        // 调用服务 插入SPU数据
        SystemResult result = productSpuManageService.addProductSpu(productSpuJson, Integer.parseInt(productId), k2Member);
        return result;
    }

}
