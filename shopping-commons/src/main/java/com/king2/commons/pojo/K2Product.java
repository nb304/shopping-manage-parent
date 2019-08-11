package com.king2.commons.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class K2Product {
    /**
     * 商品自增主键
     */
    private Integer productId;

    /**
     * 商品唯一编号
     */
    private String productNumber;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品品牌 ---对应着商品品牌主键id
     */
    private Integer productBrandId;

    /**
     * 商品一级类目 ---对应着商品类目的主键id
     */
    private Integer productOneCategoryId;

    /**
     * 商品二级类目 ---对应着商品类目的主键id
     */
    private Integer productTwoCategoryId;

    /**
     * 商品市场价格
     */
    private BigDecimal productBazaarPrice;

    /**
     * 商品在系统上面的价格
     */
    private BigDecimal productSystemPrice;

    /**
     * 商品排序规则
     */
    private Integer productOrderRule;

    /**
     * 商品单位信息
     */
    private String productUnit;

    /**
     * 商品简述  ---对应着商品简述的主键id
     */
    private Integer productSketchId;

    /**
     * 商品简述
     */
    private String productSketchContentl;

    /**
     * 是否支持无理由退款退货 ---1支持  2不支持
     */
    private Integer productIfSupport;

    /**
     * 支持的天数  ---默认0
     */
        private Integer productSupportDay;

    /**
     * 商品的状态信息  ---1上架 2下架 3删除 4编辑中
     */
    private Integer productState;

    /**
     * 商品在数据库的创建时间
     */
    private Date productCreateTime;

    /**
     * 商品的创建人  ---对应用户主键id表
     */
    private Integer productCreateUserid;

    /**
     * 创建该商品的用户名 --冗余字段
     */
    private String productCreateUsername;

    /**
     * 商品最后一次的修改时间
     */
    private Date productUpdateTime;

    /**
     * 商品最后一次的修改人  ---对应用户主键id表
     */
    private Integer productUpdateUserid;

    /**
     * 最后一次修改该商品的用户名 --冗余字段
     */
    private String productUpdateUsername;

    /**
     * 该商品属于哪个店铺的  ---指向店铺表的主键id
     */
    private Integer productStoreId;

    /**
     * 保留字段
     */
    private String productRetain1;

    /**
     * 保留字段
     */
    private String productRetain2;

    /**
     * 保留字段
     */
    private String productRetain3;

    /**
     * 保留字段
     */
    private String productRetain4;

    /**
     * 保留字段
     */
    private String productRetain5;

    /**
     * 保留字段
     */
    private String productRetain6;

    /**
     * 保留字段
     */
    private String productRetain7;

    /**
     * 商品自增主键
     * @return product_id 商品自增主键
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 商品自增主键
     * @param productId 商品自增主键
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 商品唯一编号
     * @return product_number 商品唯一编号
     */
    public String getProductNumber() {
        return productNumber;
    }

    /**
     * 商品唯一编号
     * @param productNumber 商品唯一编号
     */
    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber == null ? null : productNumber.trim();
    }

    /**
     * 商品名称
     * @return product_name 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 商品名称
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 商品品牌 ---对应着商品品牌主键id
     * @return product_brand_id 商品品牌 ---对应着商品品牌主键id
     */
    public Integer getProductBrandId() {
        return productBrandId;
    }

    /**
     * 商品品牌 ---对应着商品品牌主键id
     * @param productBrandId 商品品牌 ---对应着商品品牌主键id
     */
    public void setProductBrandId(Integer productBrandId) {
        this.productBrandId = productBrandId;
    }

    /**
     * 商品一级类目 ---对应着商品类目的主键id
     * @return product_one_category_id 商品一级类目 ---对应着商品类目的主键id
     */
    public Integer getProductOneCategoryId() {
        return productOneCategoryId;
    }

    /**
     * 商品一级类目 ---对应着商品类目的主键id
     * @param productOneCategoryId 商品一级类目 ---对应着商品类目的主键id
     */
    public void setProductOneCategoryId(Integer productOneCategoryId) {
        this.productOneCategoryId = productOneCategoryId;
    }

    /**
     * 商品二级类目 ---对应着商品类目的主键id
     * @return product_two_category_id 商品二级类目 ---对应着商品类目的主键id
     */
    public Integer getProductTwoCategoryId() {
        return productTwoCategoryId;
    }

    /**
     * 商品二级类目 ---对应着商品类目的主键id
     * @param productTwoCategoryId 商品二级类目 ---对应着商品类目的主键id
     */
    public void setProductTwoCategoryId(Integer productTwoCategoryId) {
        this.productTwoCategoryId = productTwoCategoryId;
    }

    /**
     * 商品市场价格
     * @return product_bazaar_price 商品市场价格
     */
    public BigDecimal getProductBazaarPrice() {
        return productBazaarPrice;
    }

    /**
     * 商品市场价格
     * @param productBazaarPrice 商品市场价格
     */
    public void setProductBazaarPrice(BigDecimal productBazaarPrice) {
        this.productBazaarPrice = productBazaarPrice;
    }

    /**
     * 商品在系统上面的价格
     * @return product_system_price 商品在系统上面的价格
     */
    public BigDecimal getProductSystemPrice() {
        return productSystemPrice;
    }

    /**
     * 商品在系统上面的价格
     * @param productSystemPrice 商品在系统上面的价格
     */
    public void setProductSystemPrice(BigDecimal productSystemPrice) {
        this.productSystemPrice = productSystemPrice;
    }

    /**
     * 商品排序规则
     * @return product_order_rule 商品排序规则
     */
    public Integer getProductOrderRule() {
        return productOrderRule;
    }

    /**
     * 商品排序规则
     * @param productOrderRule 商品排序规则
     */
    public void setProductOrderRule(Integer productOrderRule) {
        this.productOrderRule = productOrderRule;
    }

    /**
     * 商品单位信息
     * @return product_unit 商品单位信息
     */
    public String getProductUnit() {
        return productUnit;
    }

    /**
     * 商品单位信息
     * @param productUnit 商品单位信息
     */
    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit == null ? null : productUnit.trim();
    }

    /**
     * 商品简述  ---对应着商品简述的主键id
     * @return product_sketch_id 商品简述  ---对应着商品简述的主键id
     */
    public Integer getProductSketchId() {
        return productSketchId;
    }

    /**
     * 商品简述  ---对应着商品简述的主键id
     * @param productSketchId 商品简述  ---对应着商品简述的主键id
     */
    public void setProductSketchId(Integer productSketchId) {
        this.productSketchId = productSketchId;
    }

    /**
     * 是否支持无理由退款退货 ---1支持  2不支持
     * @return product_if_support 是否支持无理由退款退货 ---1支持  2不支持
     */
    public Integer getProductIfSupport() {
        return productIfSupport;
    }

    public String getProductSketchContentl() {
        return productSketchContentl;
    }

    public void setProductSketchContentl(String productSketchContentl) {
        this.productSketchContentl = productSketchContentl;
    }

    /**
     * 是否支持无理由退款退货 ---1支持  2不支持
     * @param productIfSupport 是否支持无理由退款退货 ---1支持  2不支持
     */
    public void setProductIfSupport(Integer productIfSupport) {
        this.productIfSupport = productIfSupport;
    }

    /**
     * 支持的天数  ---默认0
     * @return product_support_day 支持的天数  ---默认0
     */
    public Integer getProductSupportDay() {
        return productSupportDay;
    }

    /**
     * 支持的天数  ---默认0
     * @param productSupportDay 支持的天数  ---默认0
     */
    public void setProductSupportDay(Integer productSupportDay) {
        this.productSupportDay = productSupportDay;
    }

    /**
     * 商品的状态信息  ---1上架 2下架 3删除 4编辑中
     * @return product_state 商品的状态信息  ---1上架 2下架 3删除 4编辑中
     */
    public Integer getProductState() {
        return productState;
    }

    /**
     * 商品的状态信息  ---1上架 2下架 3删除 4编辑中
     * @param productState 商品的状态信息  ---1上架 2下架 3删除 4编辑中
     */
    public void setProductState(Integer productState) {
        this.productState = productState;
    }

    /**
     * 商品在数据库的创建时间
     * @return product_create_time 商品在数据库的创建时间
     */
    public Date getProductCreateTime() {
        return productCreateTime;
    }

    /**
     * 商品在数据库的创建时间
     * @param productCreateTime 商品在数据库的创建时间
     */
    public void setProductCreateTime(Date productCreateTime) {
        this.productCreateTime = productCreateTime;
    }

    /**
     * 商品的创建人  ---对应用户主键id表
     * @return product_create_userid 商品的创建人  ---对应用户主键id表
     */
    public Integer getProductCreateUserid() {
        return productCreateUserid;
    }

    /**
     * 商品的创建人  ---对应用户主键id表
     * @param productCreateUserid 商品的创建人  ---对应用户主键id表
     */
    public void setProductCreateUserid(Integer productCreateUserid) {
        this.productCreateUserid = productCreateUserid;
    }

    /**
     * 创建该商品的用户名 --冗余字段
     * @return product_create_username 创建该商品的用户名 --冗余字段
     */
    public String getProductCreateUsername() {
        return productCreateUsername;
    }

    /**
     * 创建该商品的用户名 --冗余字段
     * @param productCreateUsername 创建该商品的用户名 --冗余字段
     */
    public void setProductCreateUsername(String productCreateUsername) {
        this.productCreateUsername = productCreateUsername == null ? null : productCreateUsername.trim();
    }

    /**
     * 商品最后一次的修改时间
     * @return product_update_time 商品最后一次的修改时间
     */
    public Date getProductUpdateTime() {
        return productUpdateTime;
    }

    /**
     * 商品最后一次的修改时间
     * @param productUpdateTime 商品最后一次的修改时间
     */
    public void setProductUpdateTime(Date productUpdateTime) {
        this.productUpdateTime = productUpdateTime;
    }

    /**
     * 商品最后一次的修改人  ---对应用户主键id表
     * @return product_update_userid 商品最后一次的修改人  ---对应用户主键id表
     */
    public Integer getProductUpdateUserid() {
        return productUpdateUserid;
    }

    /**
     * 商品最后一次的修改人  ---对应用户主键id表
     * @param productUpdateUserid 商品最后一次的修改人  ---对应用户主键id表
     */
    public void setProductUpdateUserid(Integer productUpdateUserid) {
        this.productUpdateUserid = productUpdateUserid;
    }

    /**
     * 最后一次修改该商品的用户名 --冗余字段
     * @return product_update_username 最后一次修改该商品的用户名 --冗余字段
     */
    public String getProductUpdateUsername() {
        return productUpdateUsername;
    }

    /**
     * 最后一次修改该商品的用户名 --冗余字段
     * @param productUpdateUsername 最后一次修改该商品的用户名 --冗余字段
     */
    public void setProductUpdateUsername(String productUpdateUsername) {
        this.productUpdateUsername = productUpdateUsername == null ? null : productUpdateUsername.trim();
    }

    /**
     * 该商品属于哪个店铺的  ---指向店铺表的主键id
     * @return product_store_id 该商品属于哪个店铺的  ---指向店铺表的主键id
     */
    public Integer getProductStoreId() {
        return productStoreId;
    }

    /**
     * 该商品属于哪个店铺的  ---指向店铺表的主键id
     * @param productStoreId 该商品属于哪个店铺的  ---指向店铺表的主键id
     */
    public void setProductStoreId(Integer productStoreId) {
        this.productStoreId = productStoreId;
    }

    /**
     * 保留字段
     * @return product_retain1 保留字段
     */
    public String getProductRetain1() {
        return productRetain1;
    }

    /**
     * 保留字段
     * @param productRetain1 保留字段
     */
    public void setProductRetain1(String productRetain1) {
        this.productRetain1 = productRetain1 == null ? null : productRetain1.trim();
    }

    /**
     * 保留字段
     * @return product_retain2 保留字段
     */
    public String getProductRetain2() {
        return productRetain2;
    }

    /**
     * 保留字段
     * @param productRetain2 保留字段
     */
    public void setProductRetain2(String productRetain2) {
        this.productRetain2 = productRetain2 == null ? null : productRetain2.trim();
    }

    /**
     * 保留字段
     * @return product_retain3 保留字段
     */
    public String getProductRetain3() {
        return productRetain3;
    }

    /**
     * 保留字段
     * @param productRetain3 保留字段
     */
    public void setProductRetain3(String productRetain3) {
        this.productRetain3 = productRetain3 == null ? null : productRetain3.trim();
    }

    /**
     * 保留字段
     * @return product_retain4 保留字段
     */
    public String getProductRetain4() {
        return productRetain4;
    }

    /**
     * 保留字段
     * @param productRetain4 保留字段
     */
    public void setProductRetain4(String productRetain4) {
        this.productRetain4 = productRetain4 == null ? null : productRetain4.trim();
    }

    /**
     * 保留字段
     * @return product_retain5 保留字段
     */
    public String getProductRetain5() {
        return productRetain5;
    }

    /**
     * 保留字段
     * @param productRetain5 保留字段
     */
    public void setProductRetain5(String productRetain5) {
        this.productRetain5 = productRetain5 == null ? null : productRetain5.trim();
    }

    /**
     * 保留字段
     * @return product_retain6 保留字段
     */
    public String getProductRetain6() {
        return productRetain6;
    }

    /**
     * 保留字段
     * @param productRetain6 保留字段
     */
    public void setProductRetain6(String productRetain6) {
        this.productRetain6 = productRetain6 == null ? null : productRetain6.trim();
    }

    /**
     * 保留字段
     * @return product_retain7 保留字段
     */
    public String getProductRetain7() {
        return productRetain7;
    }

    /**
     * 保留字段
     * @param productRetain7 保留字段
     */
    public void setProductRetain7(String productRetain7) {
        this.productRetain7 = productRetain7 == null ? null : productRetain7.trim();
    }
}
