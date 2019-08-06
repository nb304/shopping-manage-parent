package com.king2.commons.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class K2Order {
    /**
     * 订单表记录唯一id
     */
    private Integer orderId;

    /**
     * 订单编号(格式:)
     */
    private String orderNumber;

    /**
     * 订单类型(内容对于的有一张订单类型表)
     */
    private String orderType;

    /**
     * 订单状态(内容对于的有一张订单状态表)
     */
    private String orderState;

    /**
     * 订单结算状态 0:未结算  1:已结算
     */
    private Integer orderSettlementStatus;

    /**
     * 用户售后状态 0 未发起售后 1 申请售后 -1 售后已取消 2 处理中 200 处理完毕
     */
    private Integer orderAfterStatus;

    /**
     * 商品购买总金额
     */
    private BigDecimal productAmountTotal;

    /**
     * 订单实付金额
     */
    private BigDecimal orderAmountTotal;

    /**
     * 优惠金额
     */
    private BigDecimal orderDiscountAmount;

    /**
     * 快递运费金额
     */
    private BigDecimal orderLogisticsFee;

    /**
     * 其他金额(就是额外手动添加的金额)
     */
    private BigDecimal orderOtherAmount;

    /**
     * 其它描述(就是额外手动添加的描述)
     */
    private String orderOtherDesc;

    /**
     * 订单收货地址默认:从人员信息中的默认首选收货地址
     */
    private String orderShippingAddress;

    /**
     * 店铺自增主键(关联店铺表)
     */
    private Integer storeId;

    /**
     * 店铺名称 
     */
    private String storeName;

    /**
     * 商品自增主键(关联商品表) 
     */
    private Integer productId;

    /**
     * 商品唯一编号
     */
    private String productNumber;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 客户自增主键(关联用户信息表)
     */
    private Integer memberId;

    /**
     * 客户账号
     */
    private String memberAccount;

    /**
     * 客户姓名
     */
    private String memberName;

    /**
     * 购买了几件该商品数量
     */
    private Integer productCount;

    /**
     * 订单结算时间
     */
    private Date orderSettlementTime;

    /**
     * 付款时间
     */
    private Date payTime;

    /**
     * 发货时间
     */
    private Date deliveryTime;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 最近的一次修改时间
     */
    private Date updateTime;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 是否已删除  0：未删除   1：已删除 
     */
    private Integer orderDelFalg;

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
     * 订单表记录唯一id
     * @return order_id 订单表记录唯一id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 订单表记录唯一id
     * @param orderId 订单表记录唯一id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 订单编号(格式:)
     * @return order_number 订单编号(格式:)
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 订单编号(格式:)
     * @param orderNumber 订单编号(格式:)
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    /**
     * 订单类型(内容对于的有一张订单类型表)
     * @return order_type 订单类型(内容对于的有一张订单类型表)
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * 订单类型(内容对于的有一张订单类型表)
     * @param orderType 订单类型(内容对于的有一张订单类型表)
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    /**
     * 订单状态(内容对于的有一张订单状态表)
     * @return order_state 订单状态(内容对于的有一张订单状态表)
     */
    public String getOrderState() {
        return orderState;
    }

    /**
     * 订单状态(内容对于的有一张订单状态表)
     * @param orderState 订单状态(内容对于的有一张订单状态表)
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    /**
     * 订单结算状态 0:未结算  1:已结算
     * @return order_settlement_status 订单结算状态 0:未结算  1:已结算
     */
    public Integer getOrderSettlementStatus() {
        return orderSettlementStatus;
    }

    /**
     * 订单结算状态 0:未结算  1:已结算
     * @param orderSettlementStatus 订单结算状态 0:未结算  1:已结算
     */
    public void setOrderSettlementStatus(Integer orderSettlementStatus) {
        this.orderSettlementStatus = orderSettlementStatus;
    }

    /**
     * 用户售后状态 0 未发起售后 1 申请售后 -1 售后已取消 2 处理中 200 处理完毕
     * @return order_after_status 用户售后状态 0 未发起售后 1 申请售后 -1 售后已取消 2 处理中 200 处理完毕
     */
    public Integer getOrderAfterStatus() {
        return orderAfterStatus;
    }

    /**
     * 用户售后状态 0 未发起售后 1 申请售后 -1 售后已取消 2 处理中 200 处理完毕
     * @param orderAfterStatus 用户售后状态 0 未发起售后 1 申请售后 -1 售后已取消 2 处理中 200 处理完毕
     */
    public void setOrderAfterStatus(Integer orderAfterStatus) {
        this.orderAfterStatus = orderAfterStatus;
    }

    /**
     * 商品购买总金额
     * @return product_amount_total 商品购买总金额
     */
    public BigDecimal getProductAmountTotal() {
        return productAmountTotal;
    }

    /**
     * 商品购买总金额
     * @param productAmountTotal 商品购买总金额
     */
    public void setProductAmountTotal(BigDecimal productAmountTotal) {
        this.productAmountTotal = productAmountTotal;
    }

    /**
     * 订单实付金额
     * @return order_amount_total 订单实付金额
     */
    public BigDecimal getOrderAmountTotal() {
        return orderAmountTotal;
    }

    /**
     * 订单实付金额
     * @param orderAmountTotal 订单实付金额
     */
    public void setOrderAmountTotal(BigDecimal orderAmountTotal) {
        this.orderAmountTotal = orderAmountTotal;
    }

    /**
     * 优惠金额
     * @return order_discount_amount 优惠金额
     */
    public BigDecimal getOrderDiscountAmount() {
        return orderDiscountAmount;
    }

    /**
     * 优惠金额
     * @param orderDiscountAmount 优惠金额
     */
    public void setOrderDiscountAmount(BigDecimal orderDiscountAmount) {
        this.orderDiscountAmount = orderDiscountAmount;
    }

    /**
     * 快递运费金额
     * @return order_logistics_fee 快递运费金额
     */
    public BigDecimal getOrderLogisticsFee() {
        return orderLogisticsFee;
    }

    /**
     * 快递运费金额
     * @param orderLogisticsFee 快递运费金额
     */
    public void setOrderLogisticsFee(BigDecimal orderLogisticsFee) {
        this.orderLogisticsFee = orderLogisticsFee;
    }

    /**
     * 其他金额(就是额外手动添加的金额)
     * @return order_other_amount 其他金额(就是额外手动添加的金额)
     */
    public BigDecimal getOrderOtherAmount() {
        return orderOtherAmount;
    }

    /**
     * 其他金额(就是额外手动添加的金额)
     * @param orderOtherAmount 其他金额(就是额外手动添加的金额)
     */
    public void setOrderOtherAmount(BigDecimal orderOtherAmount) {
        this.orderOtherAmount = orderOtherAmount;
    }

    /**
     * 其它描述(就是额外手动添加的描述)
     * @return order_other_desc 其它描述(就是额外手动添加的描述)
     */
    public String getOrderOtherDesc() {
        return orderOtherDesc;
    }

    /**
     * 其它描述(就是额外手动添加的描述)
     * @param orderOtherDesc 其它描述(就是额外手动添加的描述)
     */
    public void setOrderOtherDesc(String orderOtherDesc) {
        this.orderOtherDesc = orderOtherDesc == null ? null : orderOtherDesc.trim();
    }

    /**
     * 订单收货地址默认:从人员信息中的默认首选收货地址
     * @return order_shipping_address 订单收货地址默认:从人员信息中的默认首选收货地址
     */
    public String getOrderShippingAddress() {
        return orderShippingAddress;
    }

    /**
     * 订单收货地址默认:从人员信息中的默认首选收货地址
     * @param orderShippingAddress 订单收货地址默认:从人员信息中的默认首选收货地址
     */
    public void setOrderShippingAddress(String orderShippingAddress) {
        this.orderShippingAddress = orderShippingAddress == null ? null : orderShippingAddress.trim();
    }

    /**
     * 店铺自增主键(关联店铺表)
     * @return store_id 店铺自增主键(关联店铺表)
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * 店铺自增主键(关联店铺表)
     * @param storeId 店铺自增主键(关联店铺表)
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * 店铺名称 
     * @return store_name 店铺名称 
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 店铺名称 
     * @param storeName 店铺名称 
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
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
     * 商品唯一编号
     * @return product_number 商品唯一编号
     */
    public String getProductNumber() {
        return productNumber;
    }

    /**
     * 商品唯一编号
     * @param productNumber 商品唯一编号
     */
    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber == null ? null : productNumber.trim();
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
     * 客户自增主键(关联用户信息表)
     * @return member_id 客户自增主键(关联用户信息表)
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 客户自增主键(关联用户信息表)
     * @param memberId 客户自增主键(关联用户信息表)
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 客户账号
     * @return member_account 客户账号
     */
    public String getMemberAccount() {
        return memberAccount;
    }

    /**
     * 客户账号
     * @param memberAccount 客户账号
     */
    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount == null ? null : memberAccount.trim();
    }

    /**
     * 客户姓名
     * @return member_name 客户姓名
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 客户姓名
     * @param memberName 客户姓名
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 购买了几件该商品数量
     * @return product_count 购买了几件该商品数量
     */
    public Integer getProductCount() {
        return productCount;
    }

    /**
     * 购买了几件该商品数量
     * @param productCount 购买了几件该商品数量
     */
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    /**
     * 订单结算时间
     * @return order_settlement_time 订单结算时间
     */
    public Date getOrderSettlementTime() {
        return orderSettlementTime;
    }

    /**
     * 订单结算时间
     * @param orderSettlementTime 订单结算时间
     */
    public void setOrderSettlementTime(Date orderSettlementTime) {
        this.orderSettlementTime = orderSettlementTime;
    }

    /**
     * 付款时间
     * @return pay_time 付款时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 付款时间
     * @param payTime 付款时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 发货时间
     * @return delivery_time 发货时间
     */
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * 发货时间
     * @param deliveryTime 发货时间
     */
    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * 创建时间
     * @return created_time 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 创建时间
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 最近的一次修改时间
     * @return update_time 最近的一次修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 最近的一次修改时间
     * @param updateTime 最近的一次修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 删除时间
     * @return delete_time 删除时间
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * 删除时间
     * @param deleteTime 删除时间
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * 是否已删除  0：未删除   1：已删除 
     * @return order_del_falg 是否已删除  0：未删除   1：已删除 
     */
    public Integer getOrderDelFalg() {
        return orderDelFalg;
    }

    /**
     * 是否已删除  0：未删除   1：已删除 
     * @param orderDelFalg 是否已删除  0：未删除   1：已删除 
     */
    public void setOrderDelFalg(Integer orderDelFalg) {
        this.orderDelFalg = orderDelFalg;
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