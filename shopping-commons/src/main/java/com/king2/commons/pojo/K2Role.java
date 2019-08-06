package com.king2.commons.pojo;

public class K2Role {
    /**
     * 用户角色表主键
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 创建人的id  ---指向用户表主键
     */
    private Integer createUserId;

    /**
     * 创建人的用户名 ---冗余字段
     */
    private String createUserName;

    /**
     * 角色状态 1正常 2删除 3注销
     */
    private Integer state;

    /**
     * 修改人的id  ---指向用户表主键
     */
    private Integer updateUserId;

    /**
     * 修改人的用户名  ---指向用户表主键
     */
    private String updateUserName;

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
     * 用户角色表主键
     * @return role_id 用户角色表主键
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 用户角色表主键
     * @param roleId 用户角色表主键
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 角色名称
     * @return role_name 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名称
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 创建人的id  ---指向用户表主键
     * @return create_user_id 创建人的id  ---指向用户表主键
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建人的id  ---指向用户表主键
     * @param createUserId 创建人的id  ---指向用户表主键
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 创建人的用户名 ---冗余字段
     * @return create_user_name 创建人的用户名 ---冗余字段
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 创建人的用户名 ---冗余字段
     * @param createUserName 创建人的用户名 ---冗余字段
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 角色状态 1正常 2删除 3注销
     * @return state 角色状态 1正常 2删除 3注销
     */
    public Integer getState() {
        return state;
    }

    /**
     * 角色状态 1正常 2删除 3注销
     * @param state 角色状态 1正常 2删除 3注销
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 修改人的id  ---指向用户表主键
     * @return update_user_id 修改人的id  ---指向用户表主键
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 修改人的id  ---指向用户表主键
     * @param updateUserId 修改人的id  ---指向用户表主键
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 修改人的用户名  ---指向用户表主键
     * @return update_user_name 修改人的用户名  ---指向用户表主键
     */
    public String getUpdateUserName() {
        return updateUserName;
    }

    /**
     * 修改人的用户名  ---指向用户表主键
     * @param updateUserName 修改人的用户名  ---指向用户表主键
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
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