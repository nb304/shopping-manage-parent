package com.king2.product.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.BrandIndexManageDto;
import com.king2.product.server.service.BrandManageService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

/*=======================================================
	˵��:    ��ƷƷ��Controller

	����		ʱ��					ע��
  	����		2019.08.06   			����
=======================================================*/
@RestController
@RequestMapping("/brand")
@CrossOrigin
@Validated
public class BrandManageController {

    // ע����ƷƷ��Service
    @Autowired
    private BrandManageService brandManageService;

    /**
     * -----------------------------------------------------
     * ����:  ��ʾ��ƷƷ�Ƶ���ҳ
     * <p>
     * ����:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        �������û���Ϣ
     * dto              BrandIndexManageDto ��ҳ����
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @PostMapping("/index")
    public SystemResult index(HttpServletRequest request, @Validated BrandIndexManageDto dto) {

        // ��ȡ�û�����
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = brandManageService.index(k2Member, dto);
        return index;
    }


    /**
     * -----------------------------------------------------
     * ����:  �����Ʒ��Ʒ����Ϣ
     * <p>
     * ����:
     * brandName         String        Ʒ������
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @PostMapping("/add")
    public SystemResult add(@NotBlank(message = "Ʒ�����Ʋ���Ϊ��") @Length(max = 30, message = "Ʒ�����ƹ���") String brandName,
                            HttpServletRequest request) {

        // ��ȡ�û�����
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = brandManageService.addBrand(brandName, k2Member);
        return result;
    }
}
