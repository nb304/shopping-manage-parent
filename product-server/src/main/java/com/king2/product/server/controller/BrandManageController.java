package com.king2.product.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.BrandIndexManageDto;
import com.king2.product.server.service.BrandManageService;
import io.swagger.models.auth.In;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*=======================================================
	说明:    商品品牌Controller

	作者		时间					注释
  	俞烨		2019.08.06   			创建
=======================================================*/
@RestController
@RequestMapping("/brand")
@CrossOrigin
@Validated
public class BrandManageController {

    // 注入商品品牌Service
    @Autowired
    private BrandManageService brandManageService;

    /**
     * -----------------------------------------------------
     * 功能:  显示商品品牌的首页
     * <p>
     * 参数:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        操作的用户信息
     * dto              BrandIndexManageDto 分页数据
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/index")
    public SystemResult index(HttpServletRequest request, @Validated BrandIndexManageDto dto) {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = brandManageService.index(k2Member, dto);
        return index;
    }


    /**
     * -----------------------------------------------------
     * 功能:  添加商品的品牌信息
     * <p>
     * 参数:
     * brandName         String        品牌名称
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/add")
    public SystemResult add(@NotBlank(message = "品牌名称不能为空") @Length(max = 30, message = "品牌名称过长") String brandName,
                            HttpServletRequest request) {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = brandManageService.addBrand(brandName, k2Member);
        return result;
    }

    /**
     * -----------------------------------------------------
     * 功能:  上传品牌图片
     * <p>
     * 参数:
     * multipartFile         MultipartFile        品牌LOGO
     * brandID              String                 操作的品牌Id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/upload/logo/{brandId}")
    public SystemResult uploadLogo(@NotBlank(message = "品牌id不能为空") @Pattern(regexp = "[0-9]{1,}") @PathVariable("brandId") String brandId,
                                   MultipartFile multipartFile,
                                   HttpServletRequest request) throws Exception {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = brandManageService.uploadLogo(multipartFile, k2Member, Integer.parseInt(brandId));
        return result;
    }

    /**
     * -----------------------------------------------------
     * 功能:  修改品牌的信息
     * <p>
     * 参数:
     * brandName            String                  品牌名称
     * brandID              String                 操作的品牌Id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/edit")
    public SystemResult edit(@NotBlank(message = "品牌名称id为空") @Pattern(regexp = "[0-9]{1,}") String brandId,
                             @NotBlank(message = "品牌名称不能为空") @Length(max = 30) String brandName,
                             HttpServletRequest request) {

        // 获取用户数据
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = brandManageService.editBrandInfo(Integer.parseInt(brandId), brandName, k2Member);
        return result;
    }
}
