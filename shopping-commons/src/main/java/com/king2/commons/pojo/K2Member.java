package com.king2.commons.pojo;

import java.util.Date;

public class K2Member {
    /**
     * 成员表自增主键
     */
    private Integer memberId;

    /**
     * 成员账号
     */
    private String memberAccount;

    /**
     * 成员密码
     */
    private String memberPassword;

    /**
     * 成员名字
     */
    private String memberName;

    /**
     * 成员电话
     */
    private String memberPhone;

    /**
     * 成员身份证号
     */
    private String memberUid;

    /**
     * 成员住址
     */
    private String memberAddress;

    /**
     * 成员性别 1:男  0:女
     */
    private Integer memberSex;

    /**
     * 成员个性签名
     */
    private String memberSignature;

    /**
     * 成员头像图片路径
     */
    private String memberPortrait;

    /**
     * 邮箱地址
     */
    private String memberEmail;

    /**
     * 成员创建时间
     */
    private Date memberCreateTime;

    /**
     * 成员状态: 1:锁定  2:删除 3:正常
     */
    private Integer memberState;

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
     * 成员表自增主键
     * @return member_id 成员表自增主键
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 成员表自增主键
     * @param memberId 成员表自增主键
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 成员账号
     * @return member_account 成员账号
     */
    public String getMemberAccount() {
        return memberAccount;
    }

    /**
     * 成员账号
     * @param memberAccount 成员账号
     */
    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount == null ? null : memberAccount.trim();
    }

    /**
     * 成员密码
     * @return member_password 成员密码
     */
    public String getMemberPassword() {
        return memberPassword;
    }

    /**
     * 成员密码
     * @param memberPassword 成员密码
     */
    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword == null ? null : memberPassword.trim();
    }

    /**
     * 成员名字
     * @return member_name 成员名字
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 成员名字
     * @param memberName 成员名字
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 成员电话
     * @return member_phone 成员电话
     */
    public String getMemberPhone() {
        return memberPhone;
    }

    /**
     * 成员电话
     * @param memberPhone 成员电话
     */
    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone == null ? null : memberPhone.trim();
    }

    /**
     * 成员身份证号
     * @return member_uid 成员身份证号
     */
    public String getMemberUid() {
        return memberUid;
    }

    /**
     * 成员身份证号
     * @param memberUid 成员身份证号
     */
    public void setMemberUid(String memberUid) {
        this.memberUid = memberUid == null ? null : memberUid.trim();
    }

    /**
     * 成员住址
     * @return member_address 成员住址
     */
    public String getMemberAddress() {
        return memberAddress;
    }

    /**
     * 成员住址
     * @param memberAddress 成员住址
     */
    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress == null ? null : memberAddress.trim();
    }

    /**
     * 成员性别 1:男  0:女
     * @return member_sex 成员性别 1:男  0:女
     */
    public Integer getMemberSex() {
        return memberSex;
    }

    /**
     * 成员性别 1:男  0:女
     * @param memberSex 成员性别 1:男  0:女
     */
    public void setMemberSex(Integer memberSex) {
        this.memberSex = memberSex;
    }

    /**
     * 成员个性签名
     * @return member_signature 成员个性签名
     */
    public String getMemberSignature() {
        return memberSignature;
    }

    /**
     * 成员个性签名
     * @param memberSignature 成员个性签名
     */
    public void setMemberSignature(String memberSignature) {
        this.memberSignature = memberSignature == null ? null : memberSignature.trim();
    }

    /**
     * 成员头像图片路径
     * @return member_portrait 成员头像图片路径
     */
    public String getMemberPortrait() {
        return memberPortrait;
    }

    /**
     * 成员头像图片路径
     * @param memberPortrait 成员头像图片路径
     */
    public void setMemberPortrait(String memberPortrait) {
        this.memberPortrait = memberPortrait == null ? null : memberPortrait.trim();
    }

    /**
     * 邮箱地址
     * @return member_email 邮箱地址
     */
    public String getMemberEmail() {
        return memberEmail;
    }

    /**
     * 邮箱地址
     * @param memberEmail 邮箱地址
     */
    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail == null ? null : memberEmail.trim();
    }

    /**
     * 成员创建时间
     * @return member_create_time 成员创建时间
     */
    public Date getMemberCreateTime() {
        return memberCreateTime;
    }

    /**
     * 成员创建时间
     * @param memberCreateTime 成员创建时间
     */
    public void setMemberCreateTime(Date memberCreateTime) {
        this.memberCreateTime = memberCreateTime;
    }

    /**
     * 成员状态: 1:锁定  2:删除 3:正常
     * @return member_state 成员状态: 1:锁定  2:删除 3:正常
     */
    public Integer getMemberState() {
        return memberState;
    }

    /**
     * 成员状态: 1:锁定  2:删除 3:正常
     * @param memberState 成员状态: 1:锁定  2:删除 3:正常
     */
    public void setMemberState(Integer memberState) {
        this.memberState = memberState;
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