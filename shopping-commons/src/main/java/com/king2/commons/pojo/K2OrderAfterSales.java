package com.king2.commons.pojo;

import java.util.Date;

public class K2OrderAfterSales {
    /**
     * 订单售后id
     */
    private Integer asId;

    /**
     * 售后类型1:我要退款(无需退货)  2:我要退货退款
     */
    private String asType;

    /**
     * 请求售后描述
     */
    private String asDesc;

    /**
     * 请求售后人(关联着一张人员信息表)
     */
    private Integer memberId;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 售后处理时间
     */
    private Date asDealwithTime;

    /**
     * 售后处理描述
     */
    private String asDealwithDesc;

    /**
     * 售后处理结果 0:未处理  1:已通过  -1:未通过
     */
    private Integer asDealwithFlag;

    /**
     * 售后处理人对应账号
     */
    private String asDealwithAccount;

    /**
     * 售后表创建时间
     */
    private Date asCreateTime;

    /**
     * 售后表删除标志  0:未删除  1:已删除 
     */
    private Integer asDelFlag;

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
     * 请求售后的图片凭证(多个图片路径用,隔开)
     */
    private String asImgurl;

    /**
     * 订单售后id
     * @return as_id 订单售后id
     */
    public Integer getAsId() {
        return asId;
    }

    /**
     * 订单售后id
     * @param asId 订单售后id
     */
    public void setAsId(Integer asId) {
        this.asId = asId;
    }

    /**
     * 售后类型1:我要退款(无需退货)  2:我要退货退款
     * @return as_type 售后类型1:我要退款(无需退货)  2:我要退货退款
     */
    public String getAsType() {
        return asType;
    }

    /**
     * 售后类型1:我要退款(无需退货)  2:我要退货退款
     * @param asType 售后类型1:我要退款(无需退货)  2:我要退货退款
     */
    public void setAsType(String asType) {
        this.asType = asType == null ? null : asType.trim();
    }

    /**
     * 请求售后描述
     * @return as_desc 请求售后描述
     */
    public String getAsDesc() {
        return asDesc;
    }

    /**
     * 请求售后描述
     * @param asDesc 请求售后描述
     */
    public void setAsDesc(String asDesc) {
        this.asDesc = asDesc == null ? null : asDesc.trim();
    }

    /**
     * 请求售后人(关联着一张人员信息表)
     * @return member_id 请求售后人(关联着一张人员信息表)
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 请求售后人(关联着一张人员信息表)
     * @param memberId 请求售后人(关联着一张人员信息表)
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 订单编号
     * @return order_number 订单编号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 订单编号
     * @param orderNumber 订单编号
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    /**
     * 售后处理时间
     * @return as_dealWith_time 售后处理时间
     */
    public Date getAsDealwithTime() {
        return asDealwithTime;
    }

    /**
     * 售后处理时间
     * @param asDealwithTime 售后处理时间
     */
    public void setAsDealwithTime(Date asDealwithTime) {
        this.asDealwithTime = asDealwithTime;
    }

    /**
     * 售后处理描述
     * @return as_dealWith_desc 售后处理描述
     */
    public String getAsDealwithDesc() {
        return asDealwithDesc;
    }

    /**
     * 售后处理描述
     * @param asDealwithDesc 售后处理描述
     */
    public void setAsDealwithDesc(String asDealwithDesc) {
        this.asDealwithDesc = asDealwithDesc == null ? null : asDealwithDesc.trim();
    }

    /**
     * 售后处理结果 0:未处理  1:已通过  -1:未通过
     * @return as_dealWith_flag 售后处理结果 0:未处理  1:已通过  -1:未通过
     */
    public Integer getAsDealwithFlag() {
        return asDealwithFlag;
    }

    /**
     * 售后处理结果 0:未处理  1:已通过  -1:未通过
     * @param asDealwithFlag 售后处理结果 0:未处理  1:已通过  -1:未通过
     */
    public void setAsDealwithFlag(Integer asDealwithFlag) {
        this.asDealwithFlag = asDealwithFlag;
    }

    /**
     * 售后处理人对应账号
     * @return as_dealWith_account 售后处理人对应账号
     */
    public String getAsDealwithAccount() {
        return asDealwithAccount;
    }

    /**
     * 售后处理人对应账号
     * @param asDealwithAccount 售后处理人对应账号
     */
    public void setAsDealwithAccount(String asDealwithAccount) {
        this.asDealwithAccount = asDealwithAccount == null ? null : asDealwithAccount.trim();
    }

    /**
     * 售后表创建时间
     * @return as_create_time 售后表创建时间
     */
    public Date getAsCreateTime() {
        return asCreateTime;
    }

    /**
     * 售后表创建时间
     * @param asCreateTime 售后表创建时间
     */
    public void setAsCreateTime(Date asCreateTime) {
        this.asCreateTime = asCreateTime;
    }

    /**
     * 售后表删除标志  0:未删除  1:已删除 
     * @return as_del_flag 售后表删除标志  0:未删除  1:已删除 
     */
    public Integer getAsDelFlag() {
        return asDelFlag;
    }

    /**
     * 售后表删除标志  0:未删除  1:已删除 
     * @param asDelFlag 售后表删除标志  0:未删除  1:已删除 
     */
    public void setAsDelFlag(Integer asDelFlag) {
        this.asDelFlag = asDelFlag;
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
     * 请求售后的图片凭证(多个图片路径用,隔开)
     * @return as_imgUrl 请求售后的图片凭证(多个图片路径用,隔开)
     */
    public String getAsImgurl() {
        return asImgurl;
    }

    /**
     * 请求售后的图片凭证(多个图片路径用,隔开)
     * @param asImgurl 请求售后的图片凭证(多个图片路径用,隔开)
     */
    public void setAsImgurl(String asImgurl) {
        this.asImgurl = asImgurl == null ? null : asImgurl.trim();
    }
}