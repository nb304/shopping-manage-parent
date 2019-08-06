package com.king2.commons.pojo;

import java.util.Date;

public class K2Jurisdiction {
    /**
     * 权限模块id
     */
    private String jurId;

    /**
     * 权限名称
     */
    private String jurName;

    /**
     * 权限请求地址(/system  或 /order)
     */
    private String juriUrl;

    /**
     * 权限图标
     */
    private String jurIcon;

    /**
     * 当前权限父模块id
     */
    private String jurParentId;

    /**
     * 权限模块地址(显示给前端 如:views/system/user/index)
     */
    private String jurComponent;

    /**
     * 创建时间
     */
    private Date jurCreateTime;

    /**
     * 修改时间
     */
    private Date jurUpdateTime;

    /**
     * 删除标志 0:未删除   1:已删除
     */
    private Integer jurDelFlag;

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
     * 权限模块id
     * @return jur_id 权限模块id
     */
    public String getJurId() {
        return jurId;
    }

    /**
     * 权限模块id
     * @param jurId 权限模块id
     */
    public void setJurId(String jurId) {
        this.jurId = jurId == null ? null : jurId.trim();
    }

    /**
     * 权限名称
     * @return jur_name 权限名称
     */
    public String getJurName() {
        return jurName;
    }

    /**
     * 权限名称
     * @param jurName 权限名称
     */
    public void setJurName(String jurName) {
        this.jurName = jurName == null ? null : jurName.trim();
    }

    /**
     * 权限请求地址(/system  或 /order)
     * @return juri_url 权限请求地址(/system  或 /order)
     */
    public String getJuriUrl() {
        return juriUrl;
    }

    /**
     * 权限请求地址(/system  或 /order)
     * @param juriUrl 权限请求地址(/system  或 /order)
     */
    public void setJuriUrl(String juriUrl) {
        this.juriUrl = juriUrl == null ? null : juriUrl.trim();
    }

    /**
     * 权限图标
     * @return jur_icon 权限图标
     */
    public String getJurIcon() {
        return jurIcon;
    }

    /**
     * 权限图标
     * @param jurIcon 权限图标
     */
    public void setJurIcon(String jurIcon) {
        this.jurIcon = jurIcon == null ? null : jurIcon.trim();
    }

    /**
     * 当前权限父模块id
     * @return jur_parent_id 当前权限父模块id
     */
    public String getJurParentId() {
        return jurParentId;
    }

    /**
     * 当前权限父模块id
     * @param jurParentId 当前权限父模块id
     */
    public void setJurParentId(String jurParentId) {
        this.jurParentId = jurParentId == null ? null : jurParentId.trim();
    }

    /**
     * 权限模块地址(显示给前端 如:views/system/user/index)
     * @return jur_component 权限模块地址(显示给前端 如:views/system/user/index)
     */
    public String getJurComponent() {
        return jurComponent;
    }

    /**
     * 权限模块地址(显示给前端 如:views/system/user/index)
     * @param jurComponent 权限模块地址(显示给前端 如:views/system/user/index)
     */
    public void setJurComponent(String jurComponent) {
        this.jurComponent = jurComponent == null ? null : jurComponent.trim();
    }

    /**
     * 创建时间
     * @return jur_create_time 创建时间
     */
    public Date getJurCreateTime() {
        return jurCreateTime;
    }

    /**
     * 创建时间
     * @param jurCreateTime 创建时间
     */
    public void setJurCreateTime(Date jurCreateTime) {
        this.jurCreateTime = jurCreateTime;
    }

    /**
     * 修改时间
     * @return jur_update_time 修改时间
     */
    public Date getJurUpdateTime() {
        return jurUpdateTime;
    }

    /**
     * 修改时间
     * @param jurUpdateTime 修改时间
     */
    public void setJurUpdateTime(Date jurUpdateTime) {
        this.jurUpdateTime = jurUpdateTime;
    }

    /**
     * 删除标志 0:未删除   1:已删除
     * @return jur_del_flag 删除标志 0:未删除   1:已删除
     */
    public Integer getJurDelFlag() {
        return jurDelFlag;
    }

    /**
     * 删除标志 0:未删除   1:已删除
     * @param jurDelFlag 删除标志 0:未删除   1:已删除
     */
    public void setJurDelFlag(Integer jurDelFlag) {
        this.jurDelFlag = jurDelFlag;
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