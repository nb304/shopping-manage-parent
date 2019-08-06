package com.king2.commons.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class K2OrderTrading {
    /**
     * 订单交易表自增主键
     */
    private Integer tradingId;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 订单交易对应的第三方支付流水号
     */
    private String tradingNumber;

    /**
     * 订单交易支付类型 1:微信 2:支付宝  3:银行卡
     */
    private Integer tradingType;

    /**
     * 交易的用户账号
     */
    private String tradingMemberAccount;

    /**
     * 交易金额
     */
    private BigDecimal tradingPrice;

    /**
     * 支付来源 wx app web wap
     */
    private String tradingSource;

    /**
     * 交易完成时间
     */
    private Date tradingCompletionTime;

    /**
     * 交易描述 
     */
    private String tradingDesc;

    /**
     * 交易表记录创建时间
     */
    private Date tradingCreateTime;

    /**
     * 支付状态 -1：取消 0 未完成 1已完成 -2:异常
     */
    private Integer tradingStatus;

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
     * 订单交易表自增主键
     * @return trading_id 订单交易表自增主键
     */
    public Integer getTradingId() {
        return tradingId;
    }

    /**
     * 订单交易表自增主键
     * @param tradingId 订单交易表自增主键
     */
    public void setTradingId(Integer tradingId) {
        this.tradingId = tradingId;
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
     * 订单交易对应的第三方支付流水号
     * @return trading_number 订单交易对应的第三方支付流水号
     */
    public String getTradingNumber() {
        return tradingNumber;
    }

    /**
     * 订单交易对应的第三方支付流水号
     * @param tradingNumber 订单交易对应的第三方支付流水号
     */
    public void setTradingNumber(String tradingNumber) {
        this.tradingNumber = tradingNumber == null ? null : tradingNumber.trim();
    }

    /**
     * 订单交易支付类型 1:微信 2:支付宝  3:银行卡
     * @return trading_type 订单交易支付类型 1:微信 2:支付宝  3:银行卡
     */
    public Integer getTradingType() {
        return tradingType;
    }

    /**
     * 订单交易支付类型 1:微信 2:支付宝  3:银行卡
     * @param tradingType 订单交易支付类型 1:微信 2:支付宝  3:银行卡
     */
    public void setTradingType(Integer tradingType) {
        this.tradingType = tradingType;
    }

    /**
     * 交易的用户账号
     * @return trading_member_account 交易的用户账号
     */
    public String getTradingMemberAccount() {
        return tradingMemberAccount;
    }

    /**
     * 交易的用户账号
     * @param tradingMemberAccount 交易的用户账号
     */
    public void setTradingMemberAccount(String tradingMemberAccount) {
        this.tradingMemberAccount = tradingMemberAccount == null ? null : tradingMemberAccount.trim();
    }

    /**
     * 交易金额
     * @return trading_price 交易金额
     */
    public BigDecimal getTradingPrice() {
        return tradingPrice;
    }

    /**
     * 交易金额
     * @param tradingPrice 交易金额
     */
    public void setTradingPrice(BigDecimal tradingPrice) {
        this.tradingPrice = tradingPrice;
    }

    /**
     * 支付来源 wx app web wap
     * @return trading_source 支付来源 wx app web wap
     */
    public String getTradingSource() {
        return tradingSource;
    }

    /**
     * 支付来源 wx app web wap
     * @param tradingSource 支付来源 wx app web wap
     */
    public void setTradingSource(String tradingSource) {
        this.tradingSource = tradingSource == null ? null : tradingSource.trim();
    }

    /**
     * 交易完成时间
     * @return trading_completion_time 交易完成时间
     */
    public Date getTradingCompletionTime() {
        return tradingCompletionTime;
    }

    /**
     * 交易完成时间
     * @param tradingCompletionTime 交易完成时间
     */
    public void setTradingCompletionTime(Date tradingCompletionTime) {
        this.tradingCompletionTime = tradingCompletionTime;
    }

    /**
     * 交易描述 
     * @return trading_desc 交易描述 
     */
    public String getTradingDesc() {
        return tradingDesc;
    }

    /**
     * 交易描述 
     * @param tradingDesc 交易描述 
     */
    public void setTradingDesc(String tradingDesc) {
        this.tradingDesc = tradingDesc == null ? null : tradingDesc.trim();
    }

    /**
     * 交易表记录创建时间
     * @return trading_create_time 交易表记录创建时间
     */
    public Date getTradingCreateTime() {
        return tradingCreateTime;
    }

    /**
     * 交易表记录创建时间
     * @param tradingCreateTime 交易表记录创建时间
     */
    public void setTradingCreateTime(Date tradingCreateTime) {
        this.tradingCreateTime = tradingCreateTime;
    }

    /**
     * 支付状态 -1：取消 0 未完成 1已完成 -2:异常
     * @return trading_status 支付状态 -1：取消 0 未完成 1已完成 -2:异常
     */
    public Integer getTradingStatus() {
        return tradingStatus;
    }

    /**
     * 支付状态 -1：取消 0 未完成 1已完成 -2:异常
     * @param tradingStatus 支付状态 -1：取消 0 未完成 1已完成 -2:异常
     */
    public void setTradingStatus(Integer tradingStatus) {
        this.tradingStatus = tradingStatus;
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