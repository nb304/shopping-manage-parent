package com.king2.commons.pojo;

import java.util.Date;

public class K2MemberLoginRecord {
    /**
     * 登陆记录自增主键
     */
    private Integer reId;

    /**
     * 对应的成员账号
     */
    private String memberAccount;

    /**
     * 记录创建时间(就是登陆时间)
     */
    private Date reCreateTime;

    /**
     * 记录登陆的ip地址
     */
    private String reIp;

    /**
     * 记录大概的物理地址
     */
    private String reAddress;

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
     * 登陆记录自增主键
     * @return re_id 登陆记录自增主键
     */
    public Integer getReId() {
        return reId;
    }

    /**
     * 登陆记录自增主键
     * @param reId 登陆记录自增主键
     */
    public void setReId(Integer reId) {
        this.reId = reId;
    }

    /**
     * 对应的成员账号
     * @return member_account 对应的成员账号
     */
    public String getMemberAccount() {
        return memberAccount;
    }

    /**
     * 对应的成员账号
     * @param memberAccount 对应的成员账号
     */
    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount == null ? null : memberAccount.trim();
    }

    /**
     * 记录创建时间(就是登陆时间)
     * @return re_create_time 记录创建时间(就是登陆时间)
     */
    public Date getReCreateTime() {
        return reCreateTime;
    }

    /**
     * 记录创建时间(就是登陆时间)
     * @param reCreateTime 记录创建时间(就是登陆时间)
     */
    public void setReCreateTime(Date reCreateTime) {
        this.reCreateTime = reCreateTime;
    }

    /**
     * 记录登陆的ip地址
     * @return re_ip 记录登陆的ip地址
     */
    public String getReIp() {
        return reIp;
    }

    /**
     * 记录登陆的ip地址
     * @param reIp 记录登陆的ip地址
     */
    public void setReIp(String reIp) {
        this.reIp = reIp == null ? null : reIp.trim();
    }

    /**
     * 记录大概的物理地址
     * @return re_address 记录大概的物理地址
     */
    public String getReAddress() {
        return reAddress;
    }

    /**
     * 记录大概的物理地址
     * @param reAddress 记录大概的物理地址
     */
    public void setReAddress(String reAddress) {
        this.reAddress = reAddress == null ? null : reAddress.trim();
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