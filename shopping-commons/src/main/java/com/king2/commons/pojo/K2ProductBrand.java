package com.king2.commons.pojo;

import java.util.Date;

public class K2ProductBrand {
    /**
     * 商品品牌的主键id
     */
    private Integer brandId;

    /**
     * 商品品牌的编号
     */
    private String brandNumber;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 品牌LOGO
     */
    private String brandImage;

    /**
     * 创建该品牌的用户id  ---指向用户主键
     */
    private Integer brandCreateUserid;

    /**
     * 创建该品牌的用户名  ---冗余字段
     */
    private String brandCreateUsername;

    /**
     * 创建时间
     */
    private Date brandCreateTime;

    /**
     * 最后一次修改品牌的用户id ---指向用户主键
     */
    private Integer brandUpdateUserid;

    /**
     * 最后一次该品牌的用户名  ---冗余字段
     */
    private String brandUpdateUsername;

    /**
     * 最后一次的修改时间
     */
    private Date brandUpdateTime;

    /**
     * 该品牌属于哪个店铺
     */
    private Integer brandStoreId;

    /**
     * 类目的状态  ---1正常 2删除
     */
    private Integer brandState;

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
     * 商品品牌的主键id
     * @return brand_id 商品品牌的主键id
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * 商品品牌的主键id
     * @param brandId 商品品牌的主键id
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * 商品品牌的编号
     * @return brand_number 商品品牌的编号
     */
    public String getBrandNumber() {
        return brandNumber;
    }

    /**
     * 商品品牌的编号
     * @param brandNumber 商品品牌的编号
     */
    public void setBrandNumber(String brandNumber) {
        this.brandNumber = brandNumber == null ? null : brandNumber.trim();
    }

    /**
     * 品牌名称
     * @return brand_name 品牌名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 品牌名称
     * @param brandName 品牌名称
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * 品牌LOGO
     * @return brand_image 品牌LOGO
     */
    public String getBrandImage() {
        return brandImage;
    }

    /**
     * 品牌LOGO
     * @param brandImage 品牌LOGO
     */
    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage == null ? null : brandImage.trim();
    }

    /**
     * 创建该品牌的用户id  ---指向用户主键
     * @return brand_create_userid 创建该品牌的用户id  ---指向用户主键
     */
    public Integer getBrandCreateUserid() {
        return brandCreateUserid;
    }

    /**
     * 创建该品牌的用户id  ---指向用户主键
     * @param brandCreateUserid 创建该品牌的用户id  ---指向用户主键
     */
    public void setBrandCreateUserid(Integer brandCreateUserid) {
        this.brandCreateUserid = brandCreateUserid;
    }

    /**
     * 创建该品牌的用户名  ---冗余字段
     * @return brand_create_username 创建该品牌的用户名  ---冗余字段
     */
    public String getBrandCreateUsername() {
        return brandCreateUsername;
    }

    /**
     * 创建该品牌的用户名  ---冗余字段
     * @param brandCreateUsername 创建该品牌的用户名  ---冗余字段
     */
    public void setBrandCreateUsername(String brandCreateUsername) {
        this.brandCreateUsername = brandCreateUsername == null ? null : brandCreateUsername.trim();
    }

    /**
     * 创建时间
     * @return brand_create_time 创建时间
     */
    public Date getBrandCreateTime() {
        return brandCreateTime;
    }

    /**
     * 创建时间
     * @param brandCreateTime 创建时间
     */
    public void setBrandCreateTime(Date brandCreateTime) {
        this.brandCreateTime = brandCreateTime;
    }

    /**
     * 最后一次修改品牌的用户id ---指向用户主键
     * @return brand_update_userid 最后一次修改品牌的用户id ---指向用户主键
     */
    public Integer getBrandUpdateUserid() {
        return brandUpdateUserid;
    }

    /**
     * 最后一次修改品牌的用户id ---指向用户主键
     * @param brandUpdateUserid 最后一次修改品牌的用户id ---指向用户主键
     */
    public void setBrandUpdateUserid(Integer brandUpdateUserid) {
        this.brandUpdateUserid = brandUpdateUserid;
    }

    /**
     * 最后一次该品牌的用户名  ---冗余字段
     * @return brand_update_username 最后一次该品牌的用户名  ---冗余字段
     */
    public String getBrandUpdateUsername() {
        return brandUpdateUsername;
    }

    /**
     * 最后一次该品牌的用户名  ---冗余字段
     * @param brandUpdateUsername 最后一次该品牌的用户名  ---冗余字段
     */
    public void setBrandUpdateUsername(String brandUpdateUsername) {
        this.brandUpdateUsername = brandUpdateUsername == null ? null : brandUpdateUsername.trim();
    }

    /**
     * 最后一次的修改时间
     * @return brand_update_time 最后一次的修改时间
     */
    public Date getBrandUpdateTime() {
        return brandUpdateTime;
    }

    /**
     * 最后一次的修改时间
     * @param brandUpdateTime 最后一次的修改时间
     */
    public void setBrandUpdateTime(Date brandUpdateTime) {
        this.brandUpdateTime = brandUpdateTime;
    }

    /**
     * 该品牌属于哪个店铺
     * @return brand_store_id 该品牌属于哪个店铺
     */
    public Integer getBrandStoreId() {
        return brandStoreId;
    }

    /**
     * 该品牌属于哪个店铺
     * @param brandStoreId 该品牌属于哪个店铺
     */
    public void setBrandStoreId(Integer brandStoreId) {
        this.brandStoreId = brandStoreId;
    }

    /**
     * 类目的状态  ---1正常 2删除
     * @return brand_state 类目的状态  ---1正常 2删除
     */
    public Integer getBrandState() {
        return brandState;
    }

    /**
     * 类目的状态  ---1正常 2删除
     * @param brandState 类目的状态  ---1正常 2删除
     */
    public void setBrandState(Integer brandState) {
        this.brandState = brandState;
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