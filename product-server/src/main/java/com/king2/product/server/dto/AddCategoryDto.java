package com.king2.product.server.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

//�����Ʒ��ĿDto
public class AddCategoryDto {

    // ��Ŀ����
    @NotBlank(message = "��Ŀ���Ʋ���Ϊ��")
    @Length(max = 50, message = "��Ŀ���Ƴ��ȹ���")
    private String categoryName;
    // ���ڼ���
    @NotBlank(message = "��Ӧ���ڲ���Ϊ��")
    private String siJie;
    // һ����Ŀ��id ���δ0 ��������һ����Ŀ
    @NotBlank(message = "һ����Ŀ��id����Ϊ��")
    @Pattern(regexp = "[0-9]{1,}")
    private String oneCateId;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSiJie() {
        return siJie;
    }

    public void setSiJie(String siJie) {
        this.siJie = siJie;
    }

    public String getOneCateId() {
        return oneCateId;
    }

    public void setOneCateId(String oneCateId) {
        this.oneCateId = oneCateId;
    }
}
