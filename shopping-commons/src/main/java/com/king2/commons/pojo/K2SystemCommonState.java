package com.king2.commons.pojo;

import java.util.Date;

public class K2SystemCommonState {
    /**
     * 系统公共反馈状态对应的用户状态表
     */
    private Integer systemCommonStateId;

    /**
     * 该公共反馈的状态属于哪个系统反馈 ---指向系统反馈表主键
     */
    private Integer belongSystemId;

    /**
     * 是哪个用户对该公共反馈进行了操作  ---指向用户主键表
     */
    private Integer userId;

    /**
     * 通知状态 ---1已读 2未读  3 删除
     */
    private Integer state;

    /**
     * 创建的时间
     */
    private Date createTime;

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
     * 系统公共反馈状态对应的用户状态表
     * @return system_common_state_id 系统公共反馈状态对应的用户状态表
     */
    public Integer getSystemCommonStateId() {
        return systemCommonStateId;
    }

    /**
     * 系统公共反馈状态对应的用户状态表
     * @param systemCommonStateId 系统公共反馈状态对应的用户状态表
     */
    public void setSystemCommonStateId(Integer systemCommonStateId) {
        this.systemCommonStateId = systemCommonStateId;
    }

    /**
     * 该公共反馈的状态属于哪个系统反馈 ---指向系统反馈表主键
     * @return belong_system_id 该公共反馈的状态属于哪个系统反馈 ---指向系统反馈表主键
     */
    public Integer getBelongSystemId() {
        return belongSystemId;
    }

    /**
     * 该公共反馈的状态属于哪个系统反馈 ---指向系统反馈表主键
     * @param belongSystemId 该公共反馈的状态属于哪个系统反馈 ---指向系统反馈表主键
     */
    public void setBelongSystemId(Integer belongSystemId) {
        this.belongSystemId = belongSystemId;
    }

    /**
     * 是哪个用户对该公共反馈进行了操作  ---指向用户主键表
     * @return user_id 是哪个用户对该公共反馈进行了操作  ---指向用户主键表
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 是哪个用户对该公共反馈进行了操作  ---指向用户主键表
     * @param userId 是哪个用户对该公共反馈进行了操作  ---指向用户主键表
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 通知状态 ---1已读 2未读  3 删除
     * @return state 通知状态 ---1已读 2未读  3 删除
     */
    public Integer getState() {
        return state;
    }

    /**
     * 通知状态 ---1已读 2未读  3 删除
     * @param state 通知状态 ---1已读 2未读  3 删除
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 创建的时间
     * @return create_time 创建的时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建的时间
     * @param createTime 创建的时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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