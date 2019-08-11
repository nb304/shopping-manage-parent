package com.king2.product.server.dto;

import java.util.List;

/**
 * 商品类目的Dto
 */
public class ProductCategoryDto {

    // 类目值
    private String value;
    // 类目名称
    private String label;
    // 该类目的子类目
    private List<ProductCategoryDto> children;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ProductCategoryDto> getChildren() {
        return children;
    }

    public void setChildren(List<ProductCategoryDto> children) {
        this.children = children;
    }
}
