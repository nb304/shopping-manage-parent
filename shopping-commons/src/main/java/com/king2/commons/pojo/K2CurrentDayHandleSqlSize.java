package com.king2.commons.pojo;

import java.util.Date;

public class K2CurrentDayHandleSqlSize {
    /**
     * 操作数据库的次数id
     */
    private Integer sqlSizeId;

    /**
     * 哪个用户对数据库进行操作了  ---指向用户表主键
     */
    private Integer userId;

    /**
     * 针对当前用户当天对商品数据库插入的次数 最高为100次
     */
    private Integer addProductSize;

    /**
     * 针对当前用户当天对商品品牌数据库插入的次数 最高为100次
     */
    private Integer addBrandSize;

    /**
     * 针对当前用户当天对商品类目数据库插入的次数 最高为100次
     */
    private Integer addCategorySize;

    private Integer editBrandSize;

    /**
     * 系统反馈的次数  一天之内最高100次
     */
    private Integer addFeedbackSize;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 保留字段1
     */
    private String retain1;

    /**
     * 保留字段2
     */
    private String retain2;

    /**
     * 保留字段3
     */
    private String retain3;

    /**
     * 保留字段4
     */
    private String retain4;

    /**
     * 保留字段5
     */
    private String retain5;

    public Integer getEditBrandSize() {
        return editBrandSize;
    }

    public void setEditBrandSize(Integer editBrandSize) {
        this.editBrandSize = editBrandSize;
    }

    /**
     * 操作数据库的次数id
     *
     * @return sql_size_id 操作数据库的次数id
     */
    public Integer getSqlSizeId() {
        return sqlSizeId;
    }

    /**
     * 操作数据库的次数id
     *
     * @param sqlSizeId 操作数据库的次数id
     */
    public void setSqlSizeId(Integer sqlSizeId) {
        this.sqlSizeId = sqlSizeId;
    }

    /**
     * 哪个用户对数据库进行操作了  ---指向用户表主键
     *
     * @return user_id 哪个用户对数据库进行操作了  ---指向用户表主键
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 哪个用户对数据库进行操作了  ---指向用户表主键
     *
     * @param userId 哪个用户对数据库进行操作了  ---指向用户表主键
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 针对当前用户当天对商品数据库插入的次数 最高为100次
     *
     * @return add_product_size 针对当前用户当天对商品数据库插入的次数 最高为100次
     */
    public Integer getAddProductSize() {
        return addProductSize;
    }

    /**
     * 针对当前用户当天对商品数据库插入的次数 最高为100次
     *
     * @param addProductSize 针对当前用户当天对商品数据库插入的次数 最高为100次
     */
    public void setAddProductSize(Integer addProductSize) {
        this.addProductSize = addProductSize;
    }

    /**
     * 针对当前用户当天对商品品牌数据库插入的次数 最高为100次
     *
     * @return add_brand__size 针对当前用户当天对商品品牌数据库插入的次数 最高为100次
     */
    public Integer getAddBrandSize() {
        return addBrandSize;
    }

    /**
     * 针对当前用户当天对商品品牌数据库插入的次数 最高为100次
     *
     * @param addBrandSize 针对当前用户当天对商品品牌数据库插入的次数 最高为100次
     */
    public void setAddBrandSize(Integer addBrandSize) {
        this.addBrandSize = addBrandSize;
    }

    /**
     * 针对当前用户当天对商品类目数据库插入的次数 最高为100次
     *
     * @return add_category_size 针对当前用户当天对商品类目数据库插入的次数 最高为100次
     */
    public Integer getAddCategorySize() {
        return addCategorySize;
    }

    /**
     * 针对当前用户当天对商品类目数据库插入的次数 最高为100次
     *
     * @param addCategorySize 针对当前用户当天对商品类目数据库插入的次数 最高为100次
     */
    public void setAddCategorySize(Integer addCategorySize) {
        this.addCategorySize = addCategorySize;
    }

    /**
     * 系统反馈的次数  一天之内最高100次
     *
     * @return add_feedback_size 系统反馈的次数  一天之内最高100次
     */
    public Integer getAddFeedbackSize() {
        return addFeedbackSize;
    }

    /**
     * 系统反馈的次数  一天之内最高100次
     *
     * @param addFeedbackSize 系统反馈的次数  一天之内最高100次
     */
    public void setAddFeedbackSize(Integer addFeedbackSize) {
        this.addFeedbackSize = addFeedbackSize;
    }

    /**
     * 创建时间
     *
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 保留字段1
     *
     * @return retain1 保留字段1
     */
    public String getRetain1() {
        return retain1;
    }

    /**
     * 保留字段1
     *
     * @param retain1 保留字段1
     */
    public void setRetain1(String retain1) {
        this.retain1 = retain1 == null ? null : retain1.trim();
    }

    /**
     * 保留字段2
     *
     * @return retain2 保留字段2
     */
    public String getRetain2() {
        return retain2;
    }

    /**
     * 保留字段2
     *
     * @param retain2 保留字段2
     */
    public void setRetain2(String retain2) {
        this.retain2 = retain2 == null ? null : retain2.trim();
    }

    /**
     * 保留字段3
     *
     * @return retain3 保留字段3
     */
    public String getRetain3() {
        return retain3;
    }

    /**
     * 保留字段3
     *
     * @param retain3 保留字段3
     */
    public void setRetain3(String retain3) {
        this.retain3 = retain3 == null ? null : retain3.trim();
    }

    /**
     * 保留字段4
     *
     * @return retain4 保留字段4
     */
    public String getRetain4() {
        return retain4;
    }

    /**
     * 保留字段4
     *
     * @param retain4 保留字段4
     */
    public void setRetain4(String retain4) {
        this.retain4 = retain4 == null ? null : retain4.trim();
    }

    /**
     * 保留字段5
     *
     * @return retain5 保留字段5
     */
    public String getRetain5() {
        return retain5;
    }

    /**
     * 保留字段5
     *
     * @param retain5 保留字段5
     */
    public void setRetain5(String retain5) {
        this.retain5 = retain5 == null ? null : retain5.trim();
    }
}
