package com.king2.commons.pojo;

import java.util.Date;

public class K2Service {
    /**
     * 客服表的主键
     */
    private Integer serviceId;

    /**
     * 客服的编号
     */
    private String serviceNumber;

    /**
     * 客服的名称
     */
    private String serviceName;

    /**
     * 客服的昵称
     */
    private String serviceNickName;

    /**
     * 客服管理的范围
     */
    private String serviceScope;

    /**
     * 客服的联系方式
     */
    private Integer servicePhone;

    /**
     * 客服的用户名 ---指向用户表的用户名
     */
    private String serviceUserName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建该信息的用户id  ---指向用户表主键
     */
    private Integer createUserId;

    /**
     * 客户的状态  1、使用中 2、删除
     */
    private Integer state;

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
     * 客服表的主键
     * @return service_id 客服表的主键
     */
    public Integer getServiceId() {
        return serviceId;
    }

    /**
     * 客服表的主键
     * @param serviceId 客服表的主键
     */
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * 客服的编号
     * @return service_number 客服的编号
     */
    public String getServiceNumber() {
        return serviceNumber;
    }

    /**
     * 客服的编号
     * @param serviceNumber 客服的编号
     */
    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber == null ? null : serviceNumber.trim();
    }

    /**
     * 客服的名称
     * @return service_name 客服的名称
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * 客服的名称
     * @param serviceName 客服的名称
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    /**
     * 客服的昵称
     * @return service_nick_name 客服的昵称
     */
    public String getServiceNickName() {
        return serviceNickName;
    }

    /**
     * 客服的昵称
     * @param serviceNickName 客服的昵称
     */
    public void setServiceNickName(String serviceNickName) {
        this.serviceNickName = serviceNickName == null ? null : serviceNickName.trim();
    }

    /**
     * 客服管理的范围
     * @return service_scope 客服管理的范围
     */
    public String getServiceScope() {
        return serviceScope;
    }

    /**
     * 客服管理的范围
     * @param serviceScope 客服管理的范围
     */
    public void setServiceScope(String serviceScope) {
        this.serviceScope = serviceScope == null ? null : serviceScope.trim();
    }

    /**
     * 客服的联系方式
     * @return service_phone 客服的联系方式
     */
    public Integer getServicePhone() {
        return servicePhone;
    }

    /**
     * 客服的联系方式
     * @param servicePhone 客服的联系方式
     */
    public void setServicePhone(Integer servicePhone) {
        this.servicePhone = servicePhone;
    }

    /**
     * 客服的用户名 ---指向用户表的用户名
     * @return service_user_name 客服的用户名 ---指向用户表的用户名
     */
    public String getServiceUserName() {
        return serviceUserName;
    }

    /**
     * 客服的用户名 ---指向用户表的用户名
     * @param serviceUserName 客服的用户名 ---指向用户表的用户名
     */
    public void setServiceUserName(String serviceUserName) {
        this.serviceUserName = serviceUserName == null ? null : serviceUserName.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建该信息的用户id  ---指向用户表主键
     * @return create_user_id 创建该信息的用户id  ---指向用户表主键
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建该信息的用户id  ---指向用户表主键
     * @param createUserId 创建该信息的用户id  ---指向用户表主键
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 客户的状态  1、使用中 2、删除
     * @return state 客户的状态  1、使用中 2、删除
     */
    public Integer getState() {
        return state;
    }

    /**
     * 客户的状态  1、使用中 2、删除
     * @param state 客户的状态  1、使用中 2、删除
     */
    public void setState(Integer state) {
        this.state = state;
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