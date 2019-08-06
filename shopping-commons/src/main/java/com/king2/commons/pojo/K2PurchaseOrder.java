package com.king2.commons.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class K2PurchaseOrder {
    /**
     * 采购单自增主键
     */
    private Integer poId;

    /**
     * 采购单编号
     */
    private String poNumber;

    /**
     * 采购单名称
     */
    private String poName;

    /**
     * 采购单描述
     */
    private String poDesc;

    /**
     * 采购时间
     */
    private Date poTime;

    /**
     * 采购总数量
     */
    private Integer poCountNumber;

    /**
     * 采购总金额
     */
    private BigDecimal poCountPrice;

    /**
     * 采购地址
     */
    private String poAddress;

    /**
     * 厂家名称
     */
    private String poFactoryName;

    /**
     * 厂家联系方式
     */
    private String poFactoryPhone;

    /**
     * 用户账号
     */
    private String memberAccount;

    /**
     * 用户名称
     */
    private String memberName;

    /**
     * 采购单创建时间
     */
    private Date poCreateTime;

    /**
     * 采购单删除状态 0:删除 1:已删除
     */
    private Integer poDelFlag;

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
     * 采购图片凭证
     */
    private String poImgurl;

    /**
     * 采购单自增主键
     * @return po_id 采购单自增主键
     */
    public Integer getPoId() {
        return poId;
    }

    /**
     * 采购单自增主键
     * @param poId 采购单自增主键
     */
    public void setPoId(Integer poId) {
        this.poId = poId;
    }

    /**
     * 采购单编号
     * @return po_number 采购单编号
     */
    public String getPoNumber() {
        return poNumber;
    }

    /**
     * 采购单编号
     * @param poNumber 采购单编号
     */
    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber == null ? null : poNumber.trim();
    }

    /**
     * 采购单名称
     * @return po_name 采购单名称
     */
    public String getPoName() {
        return poName;
    }

    /**
     * 采购单名称
     * @param poName 采购单名称
     */
    public void setPoName(String poName) {
        this.poName = poName == null ? null : poName.trim();
    }

    /**
     * 采购单描述
     * @return po_desc 采购单描述
     */
    public String getPoDesc() {
        return poDesc;
    }

    /**
     * 采购单描述
     * @param poDesc 采购单描述
     */
    public void setPoDesc(String poDesc) {
        this.poDesc = poDesc == null ? null : poDesc.trim();
    }

    /**
     * 采购时间
     * @return po_time 采购时间
     */
    public Date getPoTime() {
        return poTime;
    }

    /**
     * 采购时间
     * @param poTime 采购时间
     */
    public void setPoTime(Date poTime) {
        this.poTime = poTime;
    }

    /**
     * 采购总数量
     * @return po_count_number 采购总数量
     */
    public Integer getPoCountNumber() {
        return poCountNumber;
    }

    /**
     * 采购总数量
     * @param poCountNumber 采购总数量
     */
    public void setPoCountNumber(Integer poCountNumber) {
        this.poCountNumber = poCountNumber;
    }

    /**
     * 采购总金额
     * @return po_count_price 采购总金额
     */
    public BigDecimal getPoCountPrice() {
        return poCountPrice;
    }

    /**
     * 采购总金额
     * @param poCountPrice 采购总金额
     */
    public void setPoCountPrice(BigDecimal poCountPrice) {
        this.poCountPrice = poCountPrice;
    }

    /**
     * 采购地址
     * @return po_address 采购地址
     */
    public String getPoAddress() {
        return poAddress;
    }

    /**
     * 采购地址
     * @param poAddress 采购地址
     */
    public void setPoAddress(String poAddress) {
        this.poAddress = poAddress == null ? null : poAddress.trim();
    }

    /**
     * 厂家名称
     * @return po_factory_name 厂家名称
     */
    public String getPoFactoryName() {
        return poFactoryName;
    }

    /**
     * 厂家名称
     * @param poFactoryName 厂家名称
     */
    public void setPoFactoryName(String poFactoryName) {
        this.poFactoryName = poFactoryName == null ? null : poFactoryName.trim();
    }

    /**
     * 厂家联系方式
     * @return po_factory_phone 厂家联系方式
     */
    public String getPoFactoryPhone() {
        return poFactoryPhone;
    }

    /**
     * 厂家联系方式
     * @param poFactoryPhone 厂家联系方式
     */
    public void setPoFactoryPhone(String poFactoryPhone) {
        this.poFactoryPhone = poFactoryPhone == null ? null : poFactoryPhone.trim();
    }

    /**
     * 用户账号
     * @return member_account 用户账号
     */
    public String getMemberAccount() {
        return memberAccount;
    }

    /**
     * 用户账号
     * @param memberAccount 用户账号
     */
    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount == null ? null : memberAccount.trim();
    }

    /**
     * 用户名称
     * @return member_name 用户名称
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 用户名称
     * @param memberName 用户名称
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 采购单创建时间
     * @return po_create_time 采购单创建时间
     */
    public Date getPoCreateTime() {
        return poCreateTime;
    }

    /**
     * 采购单创建时间
     * @param poCreateTime 采购单创建时间
     */
    public void setPoCreateTime(Date poCreateTime) {
        this.poCreateTime = poCreateTime;
    }

    /**
     * 采购单删除状态 0:删除 1:已删除
     * @return po_del_flag 采购单删除状态 0:删除 1:已删除
     */
    public Integer getPoDelFlag() {
        return poDelFlag;
    }

    /**
     * 采购单删除状态 0:删除 1:已删除
     * @param poDelFlag 采购单删除状态 0:删除 1:已删除
     */
    public void setPoDelFlag(Integer poDelFlag) {
        this.poDelFlag = poDelFlag;
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

    /**
     * 采购图片凭证
     * @return po_imgUrl 采购图片凭证
     */
    public String getPoImgurl() {
        return poImgurl;
    }

    /**
     * 采购图片凭证
     * @param poImgurl 采购图片凭证
     */
    public void setPoImgurl(String poImgurl) {
        this.poImgurl = poImgurl == null ? null : poImgurl.trim();
    }
}