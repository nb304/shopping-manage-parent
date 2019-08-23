package com.king2.product.server.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 显示修改页面的商品信息Dto
 */
public class ShowEditProductInfoDto {


    private Integer productId;
    private String productName;
    private Integer productBrandId;
    private BigDecimal productBazaarPrice;
    private BigDecimal productSystemPrice;
    private String productPoints;
    private Integer productOrderRule;
    private String productUnit;
    private String productSketchContentl;
    private Date nextUpdateTime;
    private Date lastUpdateTime;
    private String lastUpdateUserNaem;
    private String nextTimeStr;
    private String lastTimeStr;
    private Integer productIfSupport;
    private Integer productSupportDay;
    private Integer productSketchId;

    public Integer getProductSketchId() {
        return productSketchId;
    }

    public void setProductSketchId(Integer productSketchId) {
        this.productSketchId = productSketchId;
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

    public String getProductSketchContentl() {
        return productSketchContentl;
    }

    public void setProductSketchContentl(String productSketchContentl) {
        this.productSketchContentl = productSketchContentl;
    }

    public String getNextTimeStr() {
        return nextTimeStr;
    }

    public void setNextTimeStr(String nextTimeStr) {
        this.nextTimeStr = nextTimeStr;
    }

    public String getLastTimeStr() {
        return lastTimeStr;
    }

    public void setLastTimeStr(String lastTimeStr) {
        this.lastTimeStr = lastTimeStr;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public Date getNextUpdateTime() {
        return nextUpdateTime;
    }

    public void setNextUpdateTime(Date nextUpdateTime) {
        this.nextUpdateTime = nextUpdateTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateUserNaem() {
        return lastUpdateUserNaem;
    }

    public void setLastUpdateUserNaem(String lastUpdateUserNaem) {
        this.lastUpdateUserNaem = lastUpdateUserNaem;
    }
}
