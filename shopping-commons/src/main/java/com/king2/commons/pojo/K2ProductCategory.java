package com.king2.commons.pojo;

import java.util.Date;

public class K2ProductCategory {
    /**
     * 类目表主键
     */
    private Integer categoryId;

    /**
     * 类目的名称
     */
    private String categoryName;

    /**
     * 该类目里面的商品适合哪些季节 ---指向类目季节表多个适用季节用,分开
     */
    private String categorySeasonId;

    /**
     * 是否是一级类目  ---1一级类目 2二级类目
     */
    private Integer categoryIsParent;

    private String categoryIsName;

    /**
     * 该类目的父id  ---如果为0就是一级类目
     */
    private Integer categoryParentId;

    /**
     * 类目的状态   ---1正常使用 2 停用  3 删除
     */
    private Integer categoryState;

    private boolean hasChildren = true;

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    /**
     * 创建该类目的用户id   ---指向用户主键表
     */
    private Integer categoryUserid;

    /**
     * 该类目的创建时间
     */
    private Date categoryCreateTime;

    private String createTimeStr;

    /**
     * 修改该类目的用户id   ---指向用户主键表
     */
    private Integer categoryUpdateUserid;

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

    public String getCategoryIsName() {
        return categoryIsName;
    }

    public void setCategoryIsName(String categoryIsName) {
        this.categoryIsName = categoryIsName;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    /**
     * 类目表主键
     * @return category_id 类目表主键
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 类目表主键
     * @param categoryId 类目表主键
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 类目的名称
     * @return category_name 类目的名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 类目的名称
     * @param categoryName 类目的名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 该类目里面的商品适合哪些季节 ---指向类目季节表多个适用季节用,分开
     * @return category_season_id 该类目里面的商品适合哪些季节 ---指向类目季节表多个适用季节用,分开
     */
    public String getCategorySeasonId() {
        return categorySeasonId;
    }

    /**
     * 该类目里面的商品适合哪些季节 ---指向类目季节表多个适用季节用,分开
     * @param categorySeasonId 该类目里面的商品适合哪些季节 ---指向类目季节表多个适用季节用,分开
     */
    public void setCategorySeasonId(String categorySeasonId) {
        this.categorySeasonId = categorySeasonId == null ? null : categorySeasonId.trim();
    }

    /**
     * 是否是一级类目  ---1一级类目 2二级类目
     * @return category_is_parent 是否是一级类目  ---1一级类目 2二级类目
     */
    public Integer getCategoryIsParent() {
        return categoryIsParent;
    }

    /**
     * 是否是一级类目  ---1一级类目 2二级类目
     * @param categoryIsParent 是否是一级类目  ---1一级类目 2二级类目
     */
    public void setCategoryIsParent(Integer categoryIsParent) {
        this.categoryIsParent = categoryIsParent;
    }

    /**
     * 该类目的父id  ---如果为0就是一级类目
     * @return category_parent_id 该类目的父id  ---如果为0就是一级类目
     */
    public Integer getCategoryParentId() {
        return categoryParentId;
    }

    /**
     * 该类目的父id  ---如果为0就是一级类目
     * @param categoryParentId 该类目的父id  ---如果为0就是一级类目
     */
    public void setCategoryParentId(Integer categoryParentId) {
        this.categoryParentId = categoryParentId;
    }

    /**
     * 类目的状态   ---1正常使用 2 停用  3 删除
     * @return category_state 类目的状态   ---1正常使用 2 停用  3 删除
     */
    public Integer getCategoryState() {
        return categoryState;
    }

    /**
     * 类目的状态   ---1正常使用 2 停用  3 删除
     * @param categoryState 类目的状态   ---1正常使用 2 停用  3 删除
     */
    public void setCategoryState(Integer categoryState) {
        this.categoryState = categoryState;
    }

    /**
     * 创建该类目的用户id   ---指向用户主键表
     * @return category_userid 创建该类目的用户id   ---指向用户主键表
     */
    public Integer getCategoryUserid() {
        return categoryUserid;
    }

    /**
     * 创建该类目的用户id   ---指向用户主键表
     * @param categoryUserid 创建该类目的用户id   ---指向用户主键表
     */
    public void setCategoryUserid(Integer categoryUserid) {
        this.categoryUserid = categoryUserid;
    }

    /**
     * 该类目的创建时间
     * @return category_create_time 该类目的创建时间
     */
    public Date getCategoryCreateTime() {
        return categoryCreateTime;
    }

    /**
     * 该类目的创建时间
     * @param categoryCreateTime 该类目的创建时间
     */
    public void setCategoryCreateTime(Date categoryCreateTime) {
        this.categoryCreateTime = categoryCreateTime;
    }

    /**
     * 修改该类目的用户id   ---指向用户主键表
     * @return category_update_userid 修改该类目的用户id   ---指向用户主键表
     */
    public Integer getCategoryUpdateUserid() {
        return categoryUpdateUserid;
    }

    /**
     * 修改该类目的用户id   ---指向用户主键表
     * @param categoryUpdateUserid 修改该类目的用户id   ---指向用户主键表
     */
    public void setCategoryUpdateUserid(Integer categoryUpdateUserid) {
        this.categoryUpdateUserid = categoryUpdateUserid;
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
