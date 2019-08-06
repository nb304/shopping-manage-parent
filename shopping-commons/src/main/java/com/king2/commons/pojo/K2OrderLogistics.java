package com.king2.commons.pojo;

import java.util.Date;

public class K2OrderLogistics {
    /**
     * 订单物流表自增主键
     */
    private Integer olId;

    /**
     * 订单编号(对应有商品订单编号 或采购订单编号)
     */
    private String orderNumber;

    /**
     * 物流编号
     */
    private String olNumber;

    /**
     * 物流名称
     */
    private String olName;

    /**
     * 创建时间
     */
    private Date olCreateTime;

    /**
     * 订单物流发货时间
     */
    private Date olDeliveryTime;

    /**
     * 物流类型(1:订单物流  2:采购单物流)
     */
    private Integer olType;

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
     * 物流详情信息  是否第三方物流公司获取过来的数据
     */
    private String olDesc;

    /**
     * 订单物流表自增主键
     * @return ol_id 订单物流表自增主键
     */
    public Integer getOlId() {
        return olId;
    }

    /**
     * 订单物流表自增主键
     * @param olId 订单物流表自增主键
     */
    public void setOlId(Integer olId) {
        this.olId = olId;
    }

    /**
     * 订单编号(对应有商品订单编号 或采购订单编号)
     * @return order_number 订单编号(对应有商品订单编号 或采购订单编号)
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 订单编号(对应有商品订单编号 或采购订单编号)
     * @param orderNumber 订单编号(对应有商品订单编号 或采购订单编号)
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    /**
     * 物流编号
     * @return ol_number 物流编号
     */
    public String getOlNumber() {
        return olNumber;
    }

    /**
     * 物流编号
     * @param olNumber 物流编号
     */
    public void setOlNumber(String olNumber) {
        this.olNumber = olNumber == null ? null : olNumber.trim();
    }

    /**
     * 物流名称
     * @return ol_name 物流名称
     */
    public String getOlName() {
        return olName;
    }

    /**
     * 物流名称
     * @param olName 物流名称
     */
    public void setOlName(String olName) {
        this.olName = olName == null ? null : olName.trim();
    }

    /**
     * 创建时间
     * @return ol_create_time 创建时间
     */
    public Date getOlCreateTime() {
        return olCreateTime;
    }

    /**
     * 创建时间
     * @param olCreateTime 创建时间
     */
    public void setOlCreateTime(Date olCreateTime) {
        this.olCreateTime = olCreateTime;
    }

    /**
     * 订单物流发货时间
     * @return ol_delivery_time 订单物流发货时间
     */
    public Date getOlDeliveryTime() {
        return olDeliveryTime;
    }

    /**
     * 订单物流发货时间
     * @param olDeliveryTime 订单物流发货时间
     */
    public void setOlDeliveryTime(Date olDeliveryTime) {
        this.olDeliveryTime = olDeliveryTime;
    }

    /**
     * 物流类型(1:订单物流  2:采购单物流)
     * @return ol_type 物流类型(1:订单物流  2:采购单物流)
     */
    public Integer getOlType() {
        return olType;
    }

    /**
     * 物流类型(1:订单物流  2:采购单物流)
     * @param olType 物流类型(1:订单物流  2:采购单物流)
     */
    public void setOlType(Integer olType) {
        this.olType = olType;
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
     * 物流详情信息  是否第三方物流公司获取过来的数据
     * @return ol_desc 物流详情信息  是否第三方物流公司获取过来的数据
     */
    public String getOlDesc() {
        return olDesc;
    }

    /**
     * 物流详情信息  是否第三方物流公司获取过来的数据
     * @param olDesc 物流详情信息  是否第三方物流公司获取过来的数据
     */
    public void setOlDesc(String olDesc) {
        this.olDesc = olDesc == null ? null : olDesc.trim();
    }
}