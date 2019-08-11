package com.king2.product.server.dto;

import java.math.BigDecimal;

/**
 * 添加商品的DTO数据信息
 */
public class ProductInfoDto {

    // 商品一级类目
    private Integer productOneCategoryId;
    // 商品二级类目
    private Integer productTwoCategoryId;
    // 商品名称
    private String productName;
    // 商品品牌id
    private Integer productBrandId;
    // 商品市场价格
    private BigDecimal productBazaarPrice;
    // 商品商城价格
    private BigDecimal productSystemPrice;
    // 商品卖点
    private String productPoints;
    // 商品排序
    private Integer productOrderRule;
    // 商品单位
    private String productUnit;
    // 商品简述
    private String productSketchContent;
    // 是否支持退款
    private Integer productIfSupport;
    // 支持的天数
    private Integer productSupportDay;

    public Integer getProductOneCategoryId() {
        return productOneCategoryId;
    }

    public void setProductOneCategoryId(Integer productOneCategoryId) {
        this.productOneCategoryId = productOneCategoryId;
    }

    public Integer getProductTwoCategoryId() {
        return productTwoCategoryId;
    }

    public void setProductTwoCategoryId(Integer productTwoCategoryId) {
        this.productTwoCategoryId = productTwoCategoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductBrandId() {
        return productBrandId;
    }

    public void setProductBrandId(Integer productBrandId) {
        this.productBrandId = productBrandId;
    }

    public BigDecimal getProductBazaarPrice() {
        return productBazaarPrice;
    }

    public void setProductBazaarPrice(BigDecimal productBazaarPrice) {
        this.productBazaarPrice = productBazaarPrice;
    }

    public BigDecimal getProductSystemPrice() {
        return productSystemPrice;
    }

    public void setProductSystemPrice(BigDecimal productSystemPrice) {
        this.productSystemPrice = productSystemPrice;
    }

    public String getProductPoints() {
        return productPoints;
    }

    public void setProductPoints(String productPoints) {
        this.productPoints = productPoints;
    }

    public Integer getProductOrderRule() {
        return productOrderRule;
    }

    public void setProductOrderRule(Integer productOrderRule) {
        this.productOrderRule = productOrderRule;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getProductSketchContent() {
        return productSketchContent;
    }

    public void setProductSketchContent(String productSketchContent) {
        this.productSketchContent = productSketchContent;
    }

    public Integer getProductIfSupport() {
        return productIfSupport;
    }

    public void setProductIfSupport(Integer productIfSupport) {
        this.productIfSupport = productIfSupport;
    }

    public Integer getProductSupportDay() {
        return productSupportDay;
    }

    public void setProductSupportDay(Integer productSupportDay) {
        this.productSupportDay = productSupportDay;
    }
}
