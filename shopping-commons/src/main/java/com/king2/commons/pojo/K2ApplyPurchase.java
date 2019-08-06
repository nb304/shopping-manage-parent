package com.king2.commons.pojo;

import java.util.Date;

public class K2ApplyPurchase {
    /**
     * 申请采购自增主键
     */
    private Integer apId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品编号
     */
    private String productNumber;

    /**
     * 申请描述
     */
    private String applicantDesc;

    /**
     * 申请人账号
     */
    private String applicantMemberAccount;

    /**
     * 申请人名字
     */
    private String applicantMemberName;

    /**
     * 申请人电话号码
     */
    private String applicantMemberPhone;

    /**
     * 创建时间(申请时间)
     */
    private Date apCreateTime;

    /**
     * 审批状态 0:未审批  1:已审批  
     */
    private Integer approvalState;

    /**
     * 审批人账号
     */
    private String approvalAccount;

    /**
     * 审批人姓名
     */
    private String approvalName;

    /**
     * 审批描述
     */
    private String approvalDesc;

    /**
     * 审批时间
     */
    private Date approvalTime;

    /**
     * 审批结果 1:通过  2:不通过
     */
    private Integer approvalResult;

    /**
     * 记录删除状态 0:未删除   1:已删除
     */
    private Integer apDelFlag;

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
     * 申请图片凭证
     */
    private String applicantImgurl;

    /**
     * 申请采购自增主键
     * @return ap_id 申请采购自增主键
     */
    public Integer getApId() {
        return apId;
    }

    /**
     * 申请采购自增主键
     * @param apId 申请采购自增主键
     */
    public void setApId(Integer apId) {
        this.apId = apId;
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
     * 商品编号
     * @return product_number 商品编号
     */
    public String getProductNumber() {
        return productNumber;
    }

    /**
     * 商品编号
     * @param productNumber 商品编号
     */
    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber == null ? null : productNumber.trim();
    }

    /**
     * 申请描述
     * @return applicant_desc 申请描述
     */
    public String getApplicantDesc() {
        return applicantDesc;
    }

    /**
     * 申请描述
     * @param applicantDesc 申请描述
     */
    public void setApplicantDesc(String applicantDesc) {
        this.applicantDesc = applicantDesc == null ? null : applicantDesc.trim();
    }

    /**
     * 申请人账号
     * @return applicant_member_account 申请人账号
     */
    public String getApplicantMemberAccount() {
        return applicantMemberAccount;
    }

    /**
     * 申请人账号
     * @param applicantMemberAccount 申请人账号
     */
    public void setApplicantMemberAccount(String applicantMemberAccount) {
        this.applicantMemberAccount = applicantMemberAccount == null ? null : applicantMemberAccount.trim();
    }

    /**
     * 申请人名字
     * @return applicant_member_name 申请人名字
     */
    public String getApplicantMemberName() {
        return applicantMemberName;
    }

    /**
     * 申请人名字
     * @param applicantMemberName 申请人名字
     */
    public void setApplicantMemberName(String applicantMemberName) {
        this.applicantMemberName = applicantMemberName == null ? null : applicantMemberName.trim();
    }

    /**
     * 申请人电话号码
     * @return applicant_member_phone 申请人电话号码
     */
    public String getApplicantMemberPhone() {
        return applicantMemberPhone;
    }

    /**
     * 申请人电话号码
     * @param applicantMemberPhone 申请人电话号码
     */
    public void setApplicantMemberPhone(String applicantMemberPhone) {
        this.applicantMemberPhone = applicantMemberPhone == null ? null : applicantMemberPhone.trim();
    }

    /**
     * 创建时间(申请时间)
     * @return ap_create_time 创建时间(申请时间)
     */
    public Date getApCreateTime() {
        return apCreateTime;
    }

    /**
     * 创建时间(申请时间)
     * @param apCreateTime 创建时间(申请时间)
     */
    public void setApCreateTime(Date apCreateTime) {
        this.apCreateTime = apCreateTime;
    }

    /**
     * 审批状态 0:未审批  1:已审批  
     * @return approval_state 审批状态 0:未审批  1:已审批  
     */
    public Integer getApprovalState() {
        return approvalState;
    }

    /**
     * 审批状态 0:未审批  1:已审批  
     * @param approvalState 审批状态 0:未审批  1:已审批  
     */
    public void setApprovalState(Integer approvalState) {
        this.approvalState = approvalState;
    }

    /**
     * 审批人账号
     * @return approval_account 审批人账号
     */
    public String getApprovalAccount() {
        return approvalAccount;
    }

    /**
     * 审批人账号
     * @param approvalAccount 审批人账号
     */
    public void setApprovalAccount(String approvalAccount) {
        this.approvalAccount = approvalAccount == null ? null : approvalAccount.trim();
    }

    /**
     * 审批人姓名
     * @return approval_name 审批人姓名
     */
    public String getApprovalName() {
        return approvalName;
    }

    /**
     * 审批人姓名
     * @param approvalName 审批人姓名
     */
    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName == null ? null : approvalName.trim();
    }

    /**
     * 审批描述
     * @return approval_desc 审批描述
     */
    public String getApprovalDesc() {
        return approvalDesc;
    }

    /**
     * 审批描述
     * @param approvalDesc 审批描述
     */
    public void setApprovalDesc(String approvalDesc) {
        this.approvalDesc = approvalDesc == null ? null : approvalDesc.trim();
    }

    /**
     * 审批时间
     * @return approval_time 审批时间
     */
    public Date getApprovalTime() {
        return approvalTime;
    }

    /**
     * 审批时间
     * @param approvalTime 审批时间
     */
    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    /**
     * 审批结果 1:通过  2:不通过
     * @return approval_result 审批结果 1:通过  2:不通过
     */
    public Integer getApprovalResult() {
        return approvalResult;
    }

    /**
     * 审批结果 1:通过  2:不通过
     * @param approvalResult 审批结果 1:通过  2:不通过
     */
    public void setApprovalResult(Integer approvalResult) {
        this.approvalResult = approvalResult;
    }

    /**
     * 记录删除状态 0:未删除   1:已删除
     * @return ap_del_flag 记录删除状态 0:未删除   1:已删除
     */
    public Integer getApDelFlag() {
        return apDelFlag;
    }

    /**
     * 记录删除状态 0:未删除   1:已删除
     * @param apDelFlag 记录删除状态 0:未删除   1:已删除
     */
    public void setApDelFlag(Integer apDelFlag) {
        this.apDelFlag = apDelFlag;
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
     * 申请图片凭证
     * @return applicant_imgUrl 申请图片凭证
     */
    public String getApplicantImgurl() {
        return applicantImgurl;
    }

    /**
     * 申请图片凭证
     * @param applicantImgurl 申请图片凭证
     */
    public void setApplicantImgurl(String applicantImgurl) {
        this.applicantImgurl = applicantImgurl == null ? null : applicantImgurl.trim();
    }
}