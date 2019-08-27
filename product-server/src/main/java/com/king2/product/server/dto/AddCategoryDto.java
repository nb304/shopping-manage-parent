package com.king2.product.server.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

//添加商品类目Dto
public class AddCategoryDto {

    // 类目名称
    @NotBlank(message = "类目名称不能为空")
    @Length(max = 50, message = "类目名称长度过高")
    private String categoryName;
    // 属于季节
    @NotBlank(message = "适应季节不能为空")
    private String siJie;
    // 一级类目的id 如果未0 就是属于一级类目
    @NotBlank(message = "一级类目的id不能为空")
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
