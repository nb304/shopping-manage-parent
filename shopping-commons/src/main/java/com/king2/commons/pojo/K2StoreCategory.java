package com.king2.commons.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class K2StoreCategory {
    /**
     * 店铺分类管理id
     */
    private Integer storeCategoryId;

    /**
     * 分类的名称
     */
    private String categoryName;

    /**
     * 分类的图片
     */
    private String categoryImage;

    /**
     * 达到的要求 总售出量
     */
    private Integer categoryReachTotalSize;

    /**
     * 达到的要求 月售出量
     */
    private Integer categoryReachMonthSize;

    /**
     * 达到的要求 好评率
     */
    private BigDecimal categoryReachGood;

    /**
     * 创建人 ---指向用户表主键
     */
    private Integer createUserId;

    /**
     * 创建人名称 ---冗余字段
     */
    private String createUserName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 分类的状态  1使用中 2删除
     */
    private Integer categoryState;

    /**
     * 最后修改人 ---指向用户表主键
     */
    private Integer updateUserId;

    /**
     * 最后修改人名称 ---冗余字段
     */
    private String updateUserName;

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

    /**
     * 店铺分类管理id
     * @return store_category_id 店铺分类管理id
     */
    public Integer getStoreCategoryId() {
        return storeCategoryId;
    }

    /**
     * 店铺分类管理id
     * @param storeCategoryId 店铺分类管理id
     */
    public void setStoreCategoryId(Integer storeCategoryId) {
        this.storeCategoryId = storeCategoryId;
    }

    /**
     * 分类的名称
     * @return category_name 分类的名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 分类的名称
     * @param categoryName 分类的名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 分类的图片
     * @return category_image 分类的图片
     */
    public String getCategoryImage() {
        return categoryImage;
    }

    /**
     * 分类的图片
     * @param categoryImage 分类的图片
     */
    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage == null ? null : categoryImage.trim();
    }

    /**
     * 达到的要求 总售出量
     * @return category_reach_total_size 达到的要求 总售出量
     */
    public Integer getCategoryReachTotalSize() {
        return categoryReachTotalSize;
    }

    /**
     * 达到的要求 总售出量
     * @param categoryReachTotalSize 达到的要求 总售出量
     */
    public void setCategoryReachTotalSize(Integer categoryReachTotalSize) {
        this.categoryReachTotalSize = categoryReachTotalSize;
    }

    /**
     * 达到的要求 月售出量
     * @return category_reach_month_size 达到的要求 月售出量
     */
    public Integer getCategoryReachMonthSize() {
        return categoryReachMonthSize;
    }

    /**
     * 达到的要求 月售出量
     * @param categoryReachMonthSize 达到的要求 月售出量
     */
    public void setCategoryReachMonthSize(Integer categoryReachMonthSize) {
        this.categoryReachMonthSize = categoryReachMonthSize;
    }

    /**
     * 达到的要求 好评率
     * @return category_reach_good 达到的要求 好评率
     */
    public BigDecimal getCategoryReachGood() {
        return categoryReachGood;
    }

    /**
     * 达到的要求 好评率
     * @param categoryReachGood 达到的要求 好评率
     */
    public void setCategoryReachGood(BigDecimal categoryReachGood) {
        this.categoryReachGood = categoryReachGood;
    }

    /**
     * 创建人 ---指向用户表主键
     * @return create_user_id 创建人 ---指向用户表主键
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建人 ---指向用户表主键
     * @param createUserId 创建人 ---指向用户表主键
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 创建人名称 ---冗余字段
     * @return create_user_name 创建人名称 ---冗余字段
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 创建人名称 ---冗余字段
     * @param createUserName 创建人名称 ---冗余字段
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 分类的状态  1使用中 2删除
     * @return category_state 分类的状态  1使用中 2删除
     */
    public Integer getCategoryState() {
        return categoryState;
    }

    /**
     * 分类的状态  1使用中 2删除
     * @param categoryState 分类的状态  1使用中 2删除
     */
    public void setCategoryState(Integer categoryState) {
        this.categoryState = categoryState;
    }

    /**
     * 最后修改人 ---指向用户表主键
     * @return update_user_id 最后修改人 ---指向用户表主键
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 最后修改人 ---指向用户表主键
     * @param updateUserId 最后修改人 ---指向用户表主键
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 最后修改人名称 ---冗余字段
     * @return update_user_name 最后修改人名称 ---冗余字段
     */
    public String getUpdateUserName() {
        return updateUserName;
    }

    /**
     * 最后修改人名称 ---冗余字段
     * @param updateUserName 最后修改人名称 ---冗余字段
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    /**
     * 保留字段1
     * @return retain1 保留字段1
     */
    public String getRetain1() {
        return retain1;
    }

    /**
     * 保留字段1
     * @param retain1 保留字段1
     */
    public void setRetain1(String retain1) {
        this.retain1 = retain1 == null ? null : retain1.trim();
    }

    /**
     * 保留字段2
     * @return retain2 保留字段2
     */
    public String getRetain2() {
        return retain2;
    }

    /**
     * 保留字段2
     * @param retain2 保留字段2
     */
    public void setRetain2(String retain2) {
        this.retain2 = retain2 == null ? null : retain2.trim();
    }

    /**
     * 保留字段3
     * @return retain3 保留字段3
     */
    public String getRetain3() {
        return retain3;
    }

    /**
     * 保留字段3
     * @param retain3 保留字段3
     */
    public void setRetain3(String retain3) {
        this.retain3 = retain3 == null ? null : retain3.trim();
    }

    /**
     * 保留字段4
     * @return retain4 保留字段4
     */
    public String getRetain4() {
        return retain4;
    }

    /**
     * 保留字段4
     * @param retain4 保留字段4
     */
    public void setRetain4(String retain4) {
        this.retain4 = retain4 == null ? null : retain4.trim();
    }

    /**
     * 保留字段5
     * @return retain5 保留字段5
     */
    public String getRetain5() {
        return retain5;
    }

    /**
     * 保留字段5
     * @param retain5 保留字段5
     */
    public void setRetain5(String retain5) {
        this.retain5 = retain5 == null ? null : retain5.trim();
    }
}