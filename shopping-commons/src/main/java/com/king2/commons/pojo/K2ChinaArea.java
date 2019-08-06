package com.king2.commons.pojo;

public class K2ChinaArea {
    /**
     * 区域id表
     */
    private Integer areaId;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 他的父类id
     */
    private Integer parentId;

    /**
     * 区域id表
     * @return area_id 区域id表
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * 区域id表
     * @param areaId 区域id表
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * 区域名称
     * @return area_name 区域名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 区域名称
     * @param areaName 区域名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * 他的父类id
     * @return parent_id 他的父类id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 他的父类id
     * @param parentId 他的父类id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}