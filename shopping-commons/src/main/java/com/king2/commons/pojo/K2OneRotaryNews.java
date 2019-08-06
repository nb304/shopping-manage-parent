package com.king2.commons.pojo;

import java.util.Date;

public class K2OneRotaryNews {
    /**
     * 单页新闻主键
     */
    private Integer oneRotaryNewsId;

    /**
     * 新闻标题
     */
    private String oneRotaryNewsName;

    /**
     * 新闻来源
     */
    private String oneRotaryNewsSource;

    /**
     * 活动开始时间
     */
    private Date oneRotaryNewsStartTime;

    /**
     * 活动结束时间
     */
    private Date oneRotaryNewsEndTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 单页新闻的状态 1、正常 2删除 3下架
     */
    private Integer oneRotaryNewsState;

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
     * 单页新闻主键
     * @return one_rotary_news_id 单页新闻主键
     */
    public Integer getOneRotaryNewsId() {
        return oneRotaryNewsId;
    }

    /**
     * 单页新闻主键
     * @param oneRotaryNewsId 单页新闻主键
     */
    public void setOneRotaryNewsId(Integer oneRotaryNewsId) {
        this.oneRotaryNewsId = oneRotaryNewsId;
    }

    /**
     * 新闻标题
     * @return one_rotary_news_name 新闻标题
     */
    public String getOneRotaryNewsName() {
        return oneRotaryNewsName;
    }

    /**
     * 新闻标题
     * @param oneRotaryNewsName 新闻标题
     */
    public void setOneRotaryNewsName(String oneRotaryNewsName) {
        this.oneRotaryNewsName = oneRotaryNewsName == null ? null : oneRotaryNewsName.trim();
    }

    /**
     * 新闻来源
     * @return one_rotary_news_source 新闻来源
     */
    public String getOneRotaryNewsSource() {
        return oneRotaryNewsSource;
    }

    /**
     * 新闻来源
     * @param oneRotaryNewsSource 新闻来源
     */
    public void setOneRotaryNewsSource(String oneRotaryNewsSource) {
        this.oneRotaryNewsSource = oneRotaryNewsSource == null ? null : oneRotaryNewsSource.trim();
    }

    /**
     * 活动开始时间
     * @return one_rotary_news_start_time 活动开始时间
     */
    public Date getOneRotaryNewsStartTime() {
        return oneRotaryNewsStartTime;
    }

    /**
     * 活动开始时间
     * @param oneRotaryNewsStartTime 活动开始时间
     */
    public void setOneRotaryNewsStartTime(Date oneRotaryNewsStartTime) {
        this.oneRotaryNewsStartTime = oneRotaryNewsStartTime;
    }

    /**
     * 活动结束时间
     * @return one_rotary_news_end_time 活动结束时间
     */
    public Date getOneRotaryNewsEndTime() {
        return oneRotaryNewsEndTime;
    }

    /**
     * 活动结束时间
     * @param oneRotaryNewsEndTime 活动结束时间
     */
    public void setOneRotaryNewsEndTime(Date oneRotaryNewsEndTime) {
        this.oneRotaryNewsEndTime = oneRotaryNewsEndTime;
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
     * 单页新闻的状态 1、正常 2删除 3下架
     * @return one_rotary_news_state 单页新闻的状态 1、正常 2删除 3下架
     */
    public Integer getOneRotaryNewsState() {
        return oneRotaryNewsState;
    }

    /**
     * 单页新闻的状态 1、正常 2删除 3下架
     * @param oneRotaryNewsState 单页新闻的状态 1、正常 2删除 3下架
     */
    public void setOneRotaryNewsState(Integer oneRotaryNewsState) {
        this.oneRotaryNewsState = oneRotaryNewsState;
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