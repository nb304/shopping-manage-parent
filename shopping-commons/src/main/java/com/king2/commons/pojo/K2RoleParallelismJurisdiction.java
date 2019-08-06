package com.king2.commons.pojo;

import java.util.Date;

public class K2RoleParallelismJurisdiction {
    /**
     * 角色对应的权限列表主键
     */
    private Integer parallelismJurisdictionId;

    /**
     * 对应的角色id ---指向角色表主键
     */
    private Integer roleId;

    /**
     * 角色对应的权限 ---对应着权限表的主键
     */
    private Integer jurisdictionId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 角色对应的权限列表主键
     * @return parallelism_jurisdiction_id 角色对应的权限列表主键
     */
    public Integer getParallelismJurisdictionId() {
        return parallelismJurisdictionId;
    }

    /**
     * 角色对应的权限列表主键
     * @param parallelismJurisdictionId 角色对应的权限列表主键
     */
    public void setParallelismJurisdictionId(Integer parallelismJurisdictionId) {
        this.parallelismJurisdictionId = parallelismJurisdictionId;
    }

    /**
     * 对应的角色id ---指向角色表主键
     * @return role_id 对应的角色id ---指向角色表主键
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 对应的角色id ---指向角色表主键
     * @param roleId 对应的角色id ---指向角色表主键
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 角色对应的权限 ---对应着权限表的主键
     * @return jurisdiction_id 角色对应的权限 ---对应着权限表的主键
     */
    public Integer getJurisdictionId() {
        return jurisdictionId;
    }

    /**
     * 角色对应的权限 ---对应着权限表的主键
     * @param jurisdictionId 角色对应的权限 ---对应着权限表的主键
     */
    public void setJurisdictionId(Integer jurisdictionId) {
        this.jurisdictionId = jurisdictionId;
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
}