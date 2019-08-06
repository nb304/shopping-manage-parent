package com.king2.commons.pojo;

import java.util.Date;

public class K2OrderState {
    /**
     * 订单状态自增主键
     */
    private String osId;

    /**
     * 订单状态编号
     */
    private String osNumber;

    /**
     * 订单状态名字
     */
    private String osName;

    /**
     * 删除记录标志 0:未删除  1:已删除
     */
    private Integer osDelFlag;

    /**
     * 订单状态创建时间
     */
    private Date osCreateTime;

    /**
     * 创建人账号
     */
    private String osMemberAccount;

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
     * 订单状态自增主键
     * @return os_id 订单状态自增主键
     */
    public String getOsId() {
        return osId;
    }

    /**
     * 订单状态自增主键
     * @param osId 订单状态自增主键
     */
    public void setOsId(String osId) {
        this.osId = osId == null ? null : osId.trim();
    }

    /**
     * 订单状态编号
     * @return os_number 订单状态编号
     */
    public String getOsNumber() {
        return osNumber;
    }

    /**
     * 订单状态编号
     * @param osNumber 订单状态编号
     */
    public void setOsNumber(String osNumber) {
        this.osNumber = osNumber == null ? null : osNumber.trim();
    }

    /**
     * 订单状态名字
     * @return os_name 订单状态名字
     */
    public String getOsName() {
        return osName;
    }

    /**
     * 订单状态名字
     * @param osName 订单状态名字
     */
    public void setOsName(String osName) {
        this.osName = osName == null ? null : osName.trim();
    }

    /**
     * 删除记录标志 0:未删除  1:已删除
     * @return os_del_flag 删除记录标志 0:未删除  1:已删除
     */
    public Integer getOsDelFlag() {
        return osDelFlag;
    }

    /**
     * 删除记录标志 0:未删除  1:已删除
     * @param osDelFlag 删除记录标志 0:未删除  1:已删除
     */
    public void setOsDelFlag(Integer osDelFlag) {
        this.osDelFlag = osDelFlag;
    }

    /**
     * 订单状态创建时间
     * @return os_create_time 订单状态创建时间
     */
    public Date getOsCreateTime() {
        return osCreateTime;
    }

    /**
     * 订单状态创建时间
     * @param osCreateTime 订单状态创建时间
     */
    public void setOsCreateTime(Date osCreateTime) {
        this.osCreateTime = osCreateTime;
    }

    /**
     * 创建人账号
     * @return os_member_account 创建人账号
     */
    public String getOsMemberAccount() {
        return osMemberAccount;
    }

    /**
     * 创建人账号
     * @param osMemberAccount 创建人账号
     */
    public void setOsMemberAccount(String osMemberAccount) {
        this.osMemberAccount = osMemberAccount == null ? null : osMemberAccount.trim();
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