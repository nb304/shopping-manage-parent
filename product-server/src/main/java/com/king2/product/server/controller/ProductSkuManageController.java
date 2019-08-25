package com.king2.product.server.controller;

import com.king2.commons.result.SystemResult;
import com.king2.product.server.service.ProductSkuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*=======================================================
	˵��:    ��ƷSKU����Controller

	����		ʱ��					ע��
  	����		2019.08.21   			����
=======================================================*/
@RestController
@RequestMapping("/product/sku")
@Validated
@CrossOrigin
public class ProductSkuManageController {


    // ע����ƷSKU����Service
    @Autowired
    private ProductSkuManageService productSkuManageService;

    /**
     * -----------------------------------------------------
     * ����:   ��ȡ��ƷSKU����Ϣ
     * <p>
     * ����:
     * productId          String         ��Ʒid
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @GetMapping("/get/{productId}")
    public SystemResult get(@PathVariable("productId") @NotBlank(message = "��Ʒid����Ϊ��")
                            @Pattern(regexp = "[0-9]{1,}", message = "��Ʒid���ʹ���") String productId) {
        SystemResult skuByProductId = productSkuManageService.getSkuByProductId(Integer.parseInt(productId));
        return skuByProductId;
    }

    /**
     * -----------------------------------------------------
     * ����:    �޸���Ʒ�Ŀ����Ϣ
     * <p>
     * ����:
     * productSkuKcJson          String         ��Ʒ����json
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @PostMapping("/edit")
    public SystemResult edit(@NotBlank(message = "��Ʒ�����Ϣ����Ϊ��") String productSkuKcJson) {
        SystemResult result = productSkuManageService.editSkuInfo(productSkuKcJson);
        return result;
    }
}
