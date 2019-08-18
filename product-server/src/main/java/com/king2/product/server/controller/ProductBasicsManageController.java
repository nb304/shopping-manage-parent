package com.king2.product.server.controller;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.ProductUploadImageAppoint;
import com.king2.product.server.service.ProductBasicsManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*=======================================================
	˵��:    ��Ʒ��������Controller

	����		ʱ��					ע��
  	����		2019.08.06   			����
=======================================================*/
@RequestMapping("/product/basics")
@Validated
@CrossOrigin
@Api("��Ʒ��������ӿ�")
@RestController
public class ProductBasicsManageController {

    // ע����Ʒ��������Service
    @Autowired
    private ProductBasicsManageService productBasicsManageService;
    // ע����ƷͼƬ�ϴ���ί����
    @Autowired
    private ProductUploadImageAppoint productUploadImageAppoint;

    /**
     * -----------------------------------------------------
     * ����:  �����Ʒ��SKU
     * <p>
     * ����:
     * skuJson          String          SKU��JSON����
     * state            String          �����Ƿ���Ҫ���������Ʒ��Ϣ  1��Ҫ  2����Ҫ
     * productInfo      String          ��Ʒ��JSON����
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "skuJson", value = "��ƷSKU��JSON���ݴ�", required = true, dataType = "string"),
                    @ApiImplicitParam(name = "productJson", value = "���ε���Ʒ��JSON����", required = true, dataType = "string"),
                    @ApiImplicitParam(name = "state", value = "�ж���ӱ���SKUʱ���Ƿ���Ҫ�����Ʒ", required = true, dataType = "string")
            })
    @ApiOperation(value = "�����Ʒ��SKU��Ϣ", notes = "")
    @PostMapping("/add/sku")
    public SystemResult addProductSku(
            @NotBlank(message = "����дSKU����Ϣ") String skuJson,
            @NotBlank(message = "����д��Ʒ��Ϣ") String productJson,
            @NotBlank(message = "����״̬Ϊ��,��ˢ��ҳ������") @Pattern(regexp = "[0-9]{1,}", message = "״̬�����ʹ���") String state, HttpServletRequest request) throws Exception {

        // ģ���û���Ϣ
        K2Member k2Member = new K2Member();
        k2Member.setMemberId(1);
        k2Member.setMemberAccount("luqiqi");
        k2Member.setRetain1("1");


        // ������Ʒ����
        SystemResult systemResult = productBasicsManageService.addProductSku(skuJson, productJson, state, k2Member);
        return systemResult;
    }

    /**
     * -----------------------------------------------------
     * ����:  �����Ʒҳ����Ҫ������
     * <p>
     * ����:
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @GetMapping("/add/page/info")
    @ApiOperation(value = "�����Ʒҳ��ʱ��Ҫ�����ݽӿ�", notes = "")
    public SystemResult addPageInfo(HttpServletRequest request) throws Exception {
        // ��ȡ�û�����
        K2Member k2Member = (K2Member) request.getAttribute("user");
        // ���÷��� ��ѯ�����Ʒ�Ļ�����Ϣ
        SystemResult systemResult = productBasicsManageService.addProductPageInfo(k2Member);
        return systemResult;
    }


    /**
     * -----------------------------------------------------
     * ����:  ͨ����Ŀ��ѯSKU��Ϣģ��
     * <p>
     * ����:
     * categoryId             String           ��Ŀid
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @GetMapping("/get/sku/info")
    @ApiOperation(value = "ͨ����Ŀ��ѯSKU��Ϣ", notes = "")
    public SystemResult getSkuInfoByCategoryId(@NotBlank(message = "��Ŀid����Ϊ��")
                                               @Pattern(regexp = "[0-9]{1,}", message = "��Ŀid�����ʹ���,��ˢ��ҳ������") String categoryId) {

        // ���÷��� ��ѯ��ƷSKU����Ϣ
        SystemResult result = productBasicsManageService.getSkuInfoByCId(Integer.parseInt(categoryId));
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
    @PostMapping("/add/spu")
    @ApiOperation(value = "�����Ʒ��SPU����", notes = "")
    public SystemResult addProductSpu(@NotBlank(message = "��ƷSPU���ݲ���Ϊ��") String productSpuJson,
                                      @NotBlank(message = "��ƷId����Ϊ��") @Pattern(regexp = "[0-9]{1,}", message = "��ƷID���ʹ���") String productId, HttpServletRequest request) {

        // ��ȡ�û�����
        K2Member k2Member = (K2Member) request.getAttribute("user");
        // ���÷��� ����SPU����
        SystemResult result = productBasicsManageService.addProductSpu(productSpuJson, Integer.parseInt(productId), k2Member);
        return result;
    }

    /**
     * -----------------------------------------------------
     * ����:  �ϴ�ͼƬ�ķ���
     * <p>
     * ����:
     * file             MultipartFile           ͼƬ��Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @PostMapping("/upload/image")
    @ApiOperation(value = "�ϴ���ƷͼƬ", notes = "")
    public SystemResult uploadProductImage(@RequestParam("files[]") MultipartFile[] files, @NotBlank(message = "�ϴ�ͼƬ��״̬����Ϊ��") String uploadType,
                                           @NotBlank(message = "��Ʒ��Ϣ����Ϊ��") @Pattern(regexp = "[0-9]{1,}", message = "��Ʒid���ʹ���") String productId,
                                           @NotBlank(message = "������ӵ�ͼƬ��������Ϊ��") @Pattern(regexp = "[0-9]{1,}", message = "�������ʹ���") String size) throws Exception {

        SystemResult product = productUploadImageAppoint.upload(files, "product", Integer.parseInt(productId), Integer.parseInt(size), uploadType);
        return product;
    }


}
