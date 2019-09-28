package com.king2.product.server.dto;

import com.king2.commons.pojo.K2ProductWithBLOBs;

import javax.validation.constraints.NotBlank;

/**
 * �����Ʒ��Dto��Ϣ
 */
public class AddProductDto extends K2ProductWithBLOBs {

    // ��Ʒ��������Ŀ
    @NotBlank(message = "��Ʒ����Ŀ��Ϣ����Ϊ��")
    private String productCategory;
    // ��Ʒ��SPU��Ϣ
    @NotBlank(message = "��Ʒ�Ĳ�����Ϣ����Ϊ��")
    private String productSpu;
    // ��Ʒ��SKU��Ϣ
    @NotBlank(message = "��Ʒ��������Ϣ����Ϊ��")
    private String productSku;

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductSpu() {
        return productSpu;
    }

    public void setProductSpu(String productSpu) {
        this.productSpu = productSpu;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }
}
