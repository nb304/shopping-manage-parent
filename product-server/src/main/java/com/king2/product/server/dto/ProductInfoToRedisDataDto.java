package com.king2.product.server.dto;

/**
 * 商品信息在Redis中的数据结构体
 */
public class ProductInfoToRedisDataDto {


    // 商品名称
    private String productName;
    // 商品Id
    private String productId;
    // 商品编号
    private String productNumber;
    // 店铺名称
    private String belongStoreName;
    // 商品状态
    private Integer productState;
    // 商品创建人的id
    private Integer productCreateUserid;
    // 商品更新人的用户名
    private String productUpdateUsername;
    // 更新人的id
    private Integer productUpdateUserid;
    // 品牌名称
    private String brandName;
    // 创建人的用户名
    private String productCreateUsername;
    // 该商品总库存量
    private Integer totalKc;
    // 商品二级类目
    private Integer productTwoCategoryId;
    // 商品一级类目的名称
    private String categoryName;
    // 商品二级类目的名称
    private String twoCateName;

    public String getTwoCateName() {
        return twoCateName;
    }

    public void setTwoCateName(String twoCateName) {
        this.twoCateName = twoCateName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getBelongStoreName() {
        return belongStoreName;
    }

    public void setBelongStoreName(String belongStoreName) {
        this.belongStoreName = belongStoreName;
    }

    public Integer getProductState() {
        return productState;
    }

    public void setProductState(Integer productState) {
        this.productState = productState;
    }

    public Integer getProductCreateUserid() {
        return productCreateUserid;
    }

    public void setProductCreateUserid(Integer productCreateUserid) {
        this.productCreateUserid = productCreateUserid;
    }

    public String getProductUpdateUsername() {
        return productUpdateUsername;
    }

    public void setProductUpdateUsername(String productUpdateUsername) {
        this.productUpdateUsername = productUpdateUsername;
    }

    public Integer getProductUpdateUserid() {
        return productUpdateUserid;
    }

    public void setProductUpdateUserid(Integer productUpdateUserid) {
        this.productUpdateUserid = productUpdateUserid;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductCreateUsername() {
        return productCreateUsername;
    }

    public void setProductCreateUsername(String productCreateUsername) {
        this.productCreateUsername = productCreateUsername;
    }

    public Integer getTotalKc() {
        return totalKc;
    }

    public void setTotalKc(Integer totalKc) {
        this.totalKc = totalKc;
    }
}
