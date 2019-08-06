package com.king2.commons.pojo;

import java.util.Date;

public class K2InventoryMess {
    /**
     * 商品库存自增主键 
     */
    private Integer imId;

    /**
     * 商品库存操作类型 1:入库  2:出库
     */
    private Integer imType;

    /**
     * 商品库存操作数量
     */
    private Integer imHandleNumber;

    /**
     * 商品库存操作描述
     */
    private String imHandleMess;

    /**
     * 操作人账号
     */
    private String memberAccount;

    /**
     * 操作人名称
     */
    private String memberName;

    /**
     * 操作人电话
     */
    private String memberPhone;

    /**
     * 商品编号
     */
    private String productNumber;

    /**
     * 商品自增主键(关联商品表)
     */
    private Integer productId;

    /**
     * 商品库存信息创建时间
     */
    private Date imCreateTime;

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
     * 商品库存自增主键 
     * @return im_id 商品库存自增主键 
     */
    public Integer getImId() {
        return imId;
    }

    /**
     * 商品库存自增主键 
     * @param imId 商品库存自增主键 
     */
    public void setImId(Integer imId) {
        this.imId = imId;
    }

    /**
     * 商品库存操作类型 1:入库  2:出库
     * @return im_type 商品库存操作类型 1:入库  2:出库
     */
    public Integer getImType() {
        return imType;
    }

    /**
     * 商品库存操作类型 1:入库  2:出库
     * @param imType 商品库存操作类型 1:入库  2:出库
     */
    public void setImType(Integer imType) {
        this.imType = imType;
    }

    /**
     * 商品库存操作数量
     * @return im_handle_number 商品库存操作数量
     */
    public Integer getImHandleNumber() {
        return imHandleNumber;
    }

    /**
     * 商品库存操作数量
     * @param imHandleNumber 商品库存操作数量
     */
    public void setImHandleNumber(Integer imHandleNumber) {
        this.imHandleNumber = imHandleNumber;
    }

    /**
     * 商品库存操作描述
     * @return im_handle_mess 商品库存操作描述
     */
    public String getImHandleMess() {
        return imHandleMess;
    }

    /**
     * 商品库存操作描述
     * @param imHandleMess 商品库存操作描述
     */
    public void setImHandleMess(String imHandleMess) {
        this.imHandleMess = imHandleMess == null ? null : imHandleMess.trim();
    }

    /**
     * 操作人账号
     * @return member_account 操作人账号
     */
    public String getMemberAccount() {
        return memberAccount;
    }

    /**
     * 操作人账号
     * @param memberAccount 操作人账号
     */
    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount == null ? null : memberAccount.trim();
    }

    /**
     * 操作人名称
     * @return member_name 操作人名称
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 操作人名称
     * @param memberName 操作人名称
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 操作人电话
     * @return member_phone 操作人电话
     */
    public String getMemberPhone() {
        return memberPhone;
    }

    /**
     * 操作人电话
     * @param memberPhone 操作人电话
     */
    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone == null ? null : memberPhone.trim();
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
     * 商品自增主键(关联商品表)
     * @return product_id 商品自增主键(关联商品表)
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 商品自增主键(关联商品表)
     * @param productId 商品自增主键(关联商品表)
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 商品库存信息创建时间
     * @return im_create_time 商品库存信息创建时间
     */
    public Date getImCreateTime() {
        return imCreateTime;
    }

    /**
     * 商品库存信息创建时间
     * @param imCreateTime 商品库存信息创建时间
     */
    public void setImCreateTime(Date imCreateTime) {
        this.imCreateTime = imCreateTime;
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