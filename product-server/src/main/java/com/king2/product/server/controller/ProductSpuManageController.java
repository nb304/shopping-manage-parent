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
	˵��:    ��ƷSPU����Controller

	����		ʱ��					ע��
  	����		2019.08.20   			����
=======================================================*/
@RestController
@RequestMapping("/product/spu")
@Validated
@CrossOrigin
public class ProductSpuManageController {

    // ע����ƷSPUService
    @Autowired
    private ProductSpuManageService productSpuManageService;


    /**
     * -----------------------------------------------------
     * ����:  ��ѯ��Ʒ��SPU����
     * <p>
     * ����:
     * productId        String          ��Ʒid
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @GetMapping("/get/{productId}")
    public SystemResult get(@PathVariable("productId") @NotBlank(message = "��Ʒid����Ϊ��")
                            @Pattern(regexp = "[0-9]{1,}", message = "���ʹ���") String productId) {
        SystemResult spuByPId = productSpuManageService.getSpuByPId(Integer.parseInt(productId));
        return spuByPId;
    }

    /**
     * -----------------------------------------------------
     * ����:  ɾ����Ʒ��SPU��Ϣ
     * <p>
     * ����:
     * spuId        String          ��Ʒ��SPUid
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @PostMapping("/del")
    public SystemResult del(@NotBlank(message = "��ƷSpuId����Ϊ��")
                            @Pattern(regexp = "[0-9]{1,}", message = "���ʹ���") String productSpuId, HttpServletRequest request) {
        // ��ȡ�û�����
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = productSpuManageService.delSpuById(Integer.parseInt(productSpuId), k2Member);
        return result;
    }


    /**
     * -----------------------------------------------------
     * ����:  �ָ�SPU����Ϣ
     * <p>
     * ����:
     * spuId        String          ��Ʒ��SPUid
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @PostMapping("/normal")
    public SystemResult normal(@NotBlank(message = "��ƷSpuId����Ϊ��")
                               @Pattern(regexp = "[0-9]{1,}", message = "���ʹ���") String productSpuId, HttpServletRequest request) {
        // ��ȡ�û�����
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = productSpuManageService.recoverNormal(Integer.parseInt(productSpuId), k2Member);
        return result;
    }

    /**
     * -----------------------------------------------------
     * ����:  ����ע����Ʒ��SPU��Ϣ
     * <p>
     * ����:
     * spuIds        String         ��Ʒ��SPUIds
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @PostMapping("/cancel")
    public SystemResult batchCancelSpu(@NotBlank(message = "��ѡ����Ҫע������ƷSPU��Ϣ") String spuIds, HttpServletRequest request) {
        // ��ȡ�û�����
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = productSpuManageService.batchCancelSpu(spuIds, k2Member);
        return result;
    }

    /**
     * -----------------------------------------------------
     * ����:  �޸���Ʒ��������Ϣ
     * <p>
     * ����:
     * spuKey        String         ��Ʒ��SPU������
     * skuValue      String         ��Ʒ�Ĳ���ֵ
     * productSpuId  String         ��Ʒ������Id
     * order        Integer         ����
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @PostMapping("/edit")
    public SystemResult edit(@NotBlank(message = "����д��Ʒ����������") @Length(min = 1, max = 20, message = "��Ʒ���������Ƴ���Ϊ1-20�ַ�") String productSpuName,
                             @NotBlank(message = "����д��Ʒ������ֵ") @Length(min = 1, max = 100, message = "��Ʒ������ֵ����Ϊ1-100�ַ�") String productSpuValue,
                             @NotBlank(message = "����д��Ʒ������") @Length(min = 1, max = 100000, message = "��Ʒ���������򳤶�Ϊ1-10000�ַ�")
                             @Pattern(regexp = "[0-9]{1,}", message = "��Ʒ����Ĺ���Ϊ����") String productSpuOrder,
                             @NotBlank(message = "����д��Ʒ����Id") @Pattern(regexp = "[0-9]{1,}", message = "��Ʒ����Id�Ĺ���Ϊ����") String productSpuId,
                             HttpServletRequest request) {
        // ��ȡ�û�����
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult result = productSpuManageService.editSpuInfo(productSpuName, productSpuValue, Integer.parseInt(productSpuOrder),
                Integer.parseInt(productSpuId), k2Member);
        return result;
    }


    /**
     * -----------------------------------------------------
     * ����:  �����Ʒ��SPU��Ϣ
     * <p>
     * ����:
     * productSpuJson             String           SPU��JSON����
     * productId                  String           ��Ʒid
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @PostMapping("/add")
    public SystemResult addProductSpu(@NotBlank(message = "��ƷSPU���ݲ���Ϊ��") String productSpuJson,
                                      @NotBlank(message = "��ƷId����Ϊ��") @Pattern(regexp = "[0-9]{1,}", message = "��ƷID���ʹ���") String productId, HttpServletRequest request) {

        // ��ȡ�û�����
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        // ���÷��� ����SPU����
        SystemResult result = productSpuManageService.addProductSpu(productSpuJson, Integer.parseInt(productId), k2Member);
        return result;
    }

}
