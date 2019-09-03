package com.king2.product.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.StoreEntryIndexDto;
import com.king2.product.server.service.StoreEnterManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*=======================================================
	说明:    店铺入驻管理Controller

	作者		时间					注释
  	俞烨		2019.09.02   		创建
=======================================================*/
@RestController
@Validated
@RequestMapping("/store/enter")
public class StoreEnterManageController {

    // 注入店铺入驻Service
    @Autowired
    private StoreEnterManageService storeEnterManageService;

    /**
     * -----------------------------------------------------
     * 功能:  显示商品入驻的主页信息
     * <p>
     * 参数:
     * dto              StoreEntryIndexDto          分页的数据信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/index")
    public SystemResult index(HttpServletRequest request, @Validated StoreEntryIndexDto indexDto) {

        // 获取登录的用户信息
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = storeEnterManageService.index(indexDto, k2Member);
        return index;
    }

    /**
     * -----------------------------------------------------
     * 功能:  通过状态修改店铺入驻的信息
     * <p>
     * 参数:
     * storeEnterId         Integer                 店铺入驻的id
     * state                Integer                 状态
     * content              String                  如果状态为拒绝  那么拒绝的理由是什么
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @RequestMapping("/edit/state")
    public SystemResult editState(HttpServletRequest request,
                                  @NotBlank(message = "状态不能为空") @Pattern(regexp = "[0-9]{1,}") String state,
                                  @NotBlank(message = "店铺id不能为空") @Pattern(regexp = "[0-9]{1,}") String storeEnterId, String content) {

        // 获取登录的用户信息
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = storeEnterManageService.editEnterState(k2Member,
                Integer.parseInt(storeEnterId), Integer.parseInt(state), content);
        return index;
    }
}
