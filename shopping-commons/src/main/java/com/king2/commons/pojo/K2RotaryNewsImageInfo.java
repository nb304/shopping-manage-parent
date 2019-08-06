package com.king2.commons.pojo;

import java.util.Date;

public class K2RotaryNewsImageInfo {
    /**
     * 新闻图片信息主键
     */
    private Integer rotaryImageInfoId;

    /**
     * 新闻名称
     */
    private String rotaryImageInfoName;

    /**
     * 新闻来源
     */
    private String rotaryImageInfoSource;

    /**
     * 新闻活动时间
     */
    private Date rotaryStartTime;

    /**
     * 新闻的结束时间
     */
    private Date rotaryEndTime;

    /**
     * 新闻的创建时间
     */
    private Date rotaryCreateTime;

    /**
     * 创建的用户id
     */
    private Integer createUserId;

    /**
     * 该新闻信息是否为第一张  1是 2 否
     */
    private Integer isOne;

    /**
     * 新闻状态 1、停用 2、删除
     */
    private Integer rotaryImageState;

    /**
     * 该新闻图片信息 属于哪个新闻列表 ---指向新闻列表主键
     */
    private Integer rotaryId;

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
     * 新闻图片信息主键
     * @return rotary_image_info_id 新闻图片信息主键
     */
    public Integer getRotaryImageInfoId() {
        return rotaryImageInfoId;
    }

    /**
     * 新闻图片信息主键
     * @param rotaryImageInfoId 新闻图片信息主键
     */
    public void setRotaryImageInfoId(Integer rotaryImageInfoId) {
        this.rotaryImageInfoId = rotaryImageInfoId;
    }

    /**
     * 新闻名称
     * @return rotary_image_info_name 新闻名称
     */
    public String getRotaryImageInfoName() {
        return rotaryImageInfoName;
    }

    /**
     * 新闻名称
     * @param rotaryImageInfoName 新闻名称
     */
    public void setRotaryImageInfoName(String rotaryImageInfoName) {
        this.rotaryImageInfoName = rotaryImageInfoName == null ? null : rotaryImageInfoName.trim();
    }

    /**
     * 新闻来源
     * @return rotary_image_info_source 新闻来源
     */
    public String getRotaryImageInfoSource() {
        return rotaryImageInfoSource;
    }

    /**
     * 新闻来源
     * @param rotaryImageInfoSource 新闻来源
     */
    public void setRotaryImageInfoSource(String rotaryImageInfoSource) {
        this.rotaryImageInfoSource = rotaryImageInfoSource == null ? null : rotaryImageInfoSource.trim();
    }

    /**
     * 新闻活动时间
     * @return rotary_start_time 新闻活动时间
     */
    public Date getRotaryStartTime() {
        return rotaryStartTime;
    }

    /**
     * 新闻活动时间
     * @param rotaryStartTime 新闻活动时间
     */
    public void setRotaryStartTime(Date rotaryStartTime) {
        this.rotaryStartTime = rotaryStartTime;
    }

    /**
     * 新闻的结束时间
     * @return rotary_end_time 新闻的结束时间
     */
    public Date getRotaryEndTime() {
        return rotaryEndTime;
    }

    /**
     * 新闻的结束时间
     * @param rotaryEndTime 新闻的结束时间
     */
    public void setRotaryEndTime(Date rotaryEndTime) {
        this.rotaryEndTime = rotaryEndTime;
    }

    /**
     * 新闻的创建时间
     * @return rotary_create_time 新闻的创建时间
     */
    public Date getRotaryCreateTime() {
        return rotaryCreateTime;
    }

    /**
     * 新闻的创建时间
     * @param rotaryCreateTime 新闻的创建时间
     */
    public void setRotaryCreateTime(Date rotaryCreateTime) {
        this.rotaryCreateTime = rotaryCreateTime;
    }

    /**
     * 创建的用户id
     * @return create_user_id 创建的用户id
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建的用户id
     * @param createUserId 创建的用户id
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 该新闻信息是否为第一张  1是 2 否
     * @return is_one 该新闻信息是否为第一张  1是 2 否
     */
    public Integer getIsOne() {
        return isOne;
    }

    /**
     * 该新闻信息是否为第一张  1是 2 否
     * @param isOne 该新闻信息是否为第一张  1是 2 否
     */
    public void setIsOne(Integer isOne) {
        this.isOne = isOne;
    }

    /**
     * 新闻状态 1、停用 2、删除
     * @return rotary_image_state 新闻状态 1、停用 2、删除
     */
    public Integer getRotaryImageState() {
        return rotaryImageState;
    }

    /**
     * 新闻状态 1、停用 2、删除
     * @param rotaryImageState 新闻状态 1、停用 2、删除
     */
    public void setRotaryImageState(Integer rotaryImageState) {
        this.rotaryImageState = rotaryImageState;
    }

    /**
     * 该新闻图片信息 属于哪个新闻列表 ---指向新闻列表主键
     * @return rotary_id 该新闻图片信息 属于哪个新闻列表 ---指向新闻列表主键
     */
    public Integer getRotaryId() {
        return rotaryId;
    }

    /**
     * 该新闻图片信息 属于哪个新闻列表 ---指向新闻列表主键
     * @param rotaryId 该新闻图片信息 属于哪个新闻列表 ---指向新闻列表主键
     */
    public void setRotaryId(Integer rotaryId) {
        this.rotaryId = rotaryId;
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