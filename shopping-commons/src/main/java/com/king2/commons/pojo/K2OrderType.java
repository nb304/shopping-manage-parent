package com.king2.commons.pojo;

import java.util.Date;

public class K2OrderType {
    /**
     * 订单类型自增主键
     */
    private Integer oyId;

    /**
     * 订单类型编号
     */
    private String oyNumber;

    /**
     * 订单类型名称
     */
    private String oyName;

    /**
     * 订单类型创建人
     */
    private String oyMember;

    /**
     * 订单类型创建时间
     */
    private Date oyCreateTime;

    /**
     * 订单删除标志 0:未删除 1:已删除
     */
    private Integer oyDelFlag;

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
     * 订单类型自增主键
     * @return oy_id 订单类型自增主键
     */
    public Integer getOyId() {
        return oyId;
    }

    /**
     * 订单类型自增主键
     * @param oyId 订单类型自增主键
     */
    public void setOyId(Integer oyId) {
        this.oyId = oyId;
    }

    /**
     * 订单类型编号
     * @return oy_number 订单类型编号
     */
    public String getOyNumber() {
        return oyNumber;
    }

    /**
     * 订单类型编号
     * @param oyNumber 订单类型编号
     */
    public void setOyNumber(String oyNumber) {
        this.oyNumber = oyNumber == null ? null : oyNumber.trim();
    }

    /**
     * 订单类型名称
     * @return oy_name 订单类型名称
     */
    public String getOyName() {
        return oyName;
    }

    /**
     * 订单类型名称
     * @param oyName 订单类型名称
     */
    public void setOyName(String oyName) {
        this.oyName = oyName == null ? null : oyName.trim();
    }

    /**
     * 订单类型创建人
     * @return oy_member 订单类型创建人
     */
    public String getOyMember() {
        return oyMember;
    }

    /**
     * 订单类型创建人
     * @param oyMember 订单类型创建人
     */
    public void setOyMember(String oyMember) {
        this.oyMember = oyMember == null ? null : oyMember.trim();
    }

    /**
     * 订单类型创建时间
     * @return oy_create_time 订单类型创建时间
     */
    public Date getOyCreateTime() {
        return oyCreateTime;
    }

    /**
     * 订单类型创建时间
     * @param oyCreateTime 订单类型创建时间
     */
    public void setOyCreateTime(Date oyCreateTime) {
        this.oyCreateTime = oyCreateTime;
    }

    /**
     * 订单删除标志 0:未删除 1:已删除
     * @return oy_del_flag 订单删除标志 0:未删除 1:已删除
     */
    public Integer getOyDelFlag() {
        return oyDelFlag;
    }

    /**
     * 订单删除标志 0:未删除 1:已删除
     * @param oyDelFlag 订单删除标志 0:未删除 1:已删除
     */
    public void setOyDelFlag(Integer oyDelFlag) {
        this.oyDelFlag = oyDelFlag;
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