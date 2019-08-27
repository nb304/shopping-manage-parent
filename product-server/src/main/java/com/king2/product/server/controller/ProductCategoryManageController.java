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
	˵��:    ��Ʒ��Ŀ����Controller

	����		ʱ��					ע��
  	����		2019.08.27   			����
=======================================================*/
@RestController
@CrossOrigin
@RequestMapping("/product/category")
@Validated
public class ProductCategoryManageController {


    // ע����Ʒ��ĿService
    @Autowired
    private ProductCategoryManageService productCategoryManageService;

    /**
     * -----------------------------------------------------
     * ����:  ��ʾ��Ʒ��Ŀ����ҳ
     * <p>
     * ����:
     * dto              CategoryIndexManageDto              ��ҳ����
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/index")
    public SystemResult index(HttpServletRequest request, CategoryIndexManageDto categoryIndexManageDto) {

        // ��ȡ�û�����
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = productCategoryManageService.index(k2Member, categoryIndexManageDto);
        return index;
    }

    /**
     * -----------------------------------------------------
     * ����:  ���ݸ�����Ϣ��ѯ�������Ŀ��Ϣ
     * <p>
     * ����:
     * parentId              String              ������Ŀ��id
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/load/data")
    public SystemResult loadData(@NotBlank(message = "����di����Ϊ��")
                                 @Pattern(regexp = "[0-9]{1,}") String parentId) {

        // ��ȡ�û�����
        SystemResult index = productCategoryManageService.loadCategoryById(Integer.parseInt(parentId));
        return index;
    }

    /**
     * -----------------------------------------------------
     * ����:  ������Ʒ����Ŀ��Ϣ
     * <p>
     * ����:
     * dto              AddCategoryDto              ��������Ŀ��Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/add")
    public SystemResult add(HttpServletRequest request, @Validated AddCategoryDto dto) {

        // ��ȡ�û�����
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = productCategoryManageService.addCategory(k2Member, dto);
        return index;
    }


    /**
     * -----------------------------------------------------
     * ����: �޸���Ʒ����Ŀ��Ϣ
     * <p>
     * ����:
     * dto              AddCategoryDto              �޸ĵ���Ŀ��Ϣ
     * categoryId       String                      �޸ĵ���Ŀid
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/edit")
    public SystemResult edit(HttpServletRequest request, @Validated AddCategoryDto dto,
                             @NotBlank(message = "��Ŀid����Ϊ��") @Pattern(regexp = "[0-9]{1,}") String categoryId) {

        // ��ȡ�û�����
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = productCategoryManageService.editCategory(k2Member, dto, Integer.parseInt(categoryId));
        return index;
    }


    /**
     * -----------------------------------------------------
     * ����: �޸���Ʒ����Ŀ��״̬
     * <p>
     * ����:
     * categoryId       String                      �޸ĵ���Ŀid
     * state            String                      �����޸ĵ�״̬
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/edit/state")
    public SystemResult editState(HttpServletRequest request,
                                  @NotBlank(message = "��Ŀid����Ϊ��") @Pattern(regexp = "[0-9]{1,}") String categoryId,
                                  @NotBlank(message = "״̬����Ϊ��") @Pattern(regexp = "[0-9]{1,}") String state) {

        // ��ȡ�û�����
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = productCategoryManageService.editCategoryState(k2Member, Integer.parseInt(categoryId), state);
        return index;
    }


    /**
     * -----------------------------------------------------
     * ����: �鿴��Ʒ��Ŀ��SKU��Ϣ
     * <p>
     * ����:
     * categoryId       String                      �޸ĵ���Ŀid
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/get/category/sku")
    public SystemResult showCategorySku(HttpServletRequest request,
                                        @NotBlank(message = "��Ŀid����Ϊ��") @Pattern(regexp = "[0-9]{1,}") String categoryId) {

        // ��ȡ�û�����
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = productCategoryManageService.showCategorySKUInfo(k2Member, Integer.parseInt(categoryId));
        return index;
    }
}
