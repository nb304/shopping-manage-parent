package com.king2.commons.pojo;

import java.util.Date;

public class K2MemberDeliveryAddress {
    /**
     * 收货地址自增主键
     */
    private Integer daId;

    /**
     * 收货人账号
     */
    private String memberAccount;

    /**
     * 收货人姓名
     */
    private String memberName;

    /**
     * 电话号码
     */
    private String daTelphone;

    /**
     * 国家
     */
    private String daCountry;

    /**
     * 省份
     */
    private String daProvince;

    /**
     * 城市
     */
    private String daCity;

    /**
     * 地区
     */
    private String daArea;

    /**
     * 街道/详细收货地址
     */
    private String daStreet;

    /**
     * 邮政编码
     */
    private String daZip;

    /**
     * 是否默认收货地址 0:不是  1:是
     */
    private Integer daDefAddress;

    /**
     * 创建时间
     */
    private Date daCreateTime;

    /**
     * 删除标志  0:未删除   1:已删除 
     */
    private Integer daDelFlag;

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
     * 收货地址自增主键
     * @return da_id 收货地址自增主键
     */
    public Integer getDaId() {
        return daId;
    }

    /**
     * 收货地址自增主键
     * @param daId 收货地址自增主键
     */
    public void setDaId(Integer daId) {
        this.daId = daId;
    }

    /**
     * 收货人账号
     * @return member_account 收货人账号
     */
    public String getMemberAccount() {
        return memberAccount;
    }

    /**
     * 收货人账号
     * @param memberAccount 收货人账号
     */
    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount == null ? null : memberAccount.trim();
    }

    /**
     * 收货人姓名
     * @return member_name 收货人姓名
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 收货人姓名
     * @param memberName 收货人姓名
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 电话号码
     * @return da_telphone 电话号码
     */
    public String getDaTelphone() {
        return daTelphone;
    }

    /**
     * 电话号码
     * @param daTelphone 电话号码
     */
    public void setDaTelphone(String daTelphone) {
        this.daTelphone = daTelphone == null ? null : daTelphone.trim();
    }

    /**
     * 国家
     * @return da_country 国家
     */
    public String getDaCountry() {
        return daCountry;
    }

    /**
     * 国家
     * @param daCountry 国家
     */
    public void setDaCountry(String daCountry) {
        this.daCountry = daCountry == null ? null : daCountry.trim();
    }

    /**
     * 省份
     * @return da_province 省份
     */
    public String getDaProvince() {
        return daProvince;
    }

    /**
     * 省份
     * @param daProvince 省份
     */
    public void setDaProvince(String daProvince) {
        this.daProvince = daProvince == null ? null : daProvince.trim();
    }

    /**
     * 城市
     * @return da_city 城市
     */
    public String getDaCity() {
        return daCity;
    }

    /**
     * 城市
     * @param daCity 城市
     */
    public void setDaCity(String daCity) {
        this.daCity = daCity == null ? null : daCity.trim();
    }

    /**
     * 地区
     * @return da_area 地区
     */
    public String getDaArea() {
        return daArea;
    }

    /**
     * 地区
     * @param daArea 地区
     */
    public void setDaArea(String daArea) {
        this.daArea = daArea == null ? null : daArea.trim();
    }

    /**
     * 街道/详细收货地址
     * @return da_street 街道/详细收货地址
     */
    public String getDaStreet() {
        return daStreet;
    }

    /**
     * 街道/详细收货地址
     * @param daStreet 街道/详细收货地址
     */
    public void setDaStreet(String daStreet) {
        this.daStreet = daStreet == null ? null : daStreet.trim();
    }

    /**
     * 邮政编码
     * @return da_zip 邮政编码
     */
    public String getDaZip() {
        return daZip;
    }

    /**
     * 邮政编码
     * @param daZip 邮政编码
     */
    public void setDaZip(String daZip) {
        this.daZip = daZip == null ? null : daZip.trim();
    }

    /**
     * 是否默认收货地址 0:不是  1:是
     * @return da_def_address 是否默认收货地址 0:不是  1:是
     */
    public Integer getDaDefAddress() {
        return daDefAddress;
    }

    /**
     * 是否默认收货地址 0:不是  1:是
     * @param daDefAddress 是否默认收货地址 0:不是  1:是
     */
    public void setDaDefAddress(Integer daDefAddress) {
        this.daDefAddress = daDefAddress;
    }

    /**
     * 创建时间
     * @return da_create_time 创建时间
     */
    public Date getDaCreateTime() {
        return daCreateTime;
    }

    /**
     * 创建时间
     * @param daCreateTime 创建时间
     */
    public void setDaCreateTime(Date daCreateTime) {
        this.daCreateTime = daCreateTime;
    }

    /**
     * 删除标志  0:未删除   1:已删除 
     * @return da_del_flag 删除标志  0:未删除   1:已删除 
     */
    public Integer getDaDelFlag() {
        return daDelFlag;
    }

    /**
     * 删除标志  0:未删除   1:已删除 
     * @param daDelFlag 删除标志  0:未删除   1:已删除 
     */
    public void setDaDelFlag(Integer daDelFlag) {
        this.daDelFlag = daDelFlag;
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