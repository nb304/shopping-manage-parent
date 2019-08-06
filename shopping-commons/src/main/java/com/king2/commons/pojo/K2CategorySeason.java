package com.king2.commons.pojo;

public class K2CategorySeason {
    /**
     * 季节表的主键id
     */
    private Integer categorySeasonId;

    /**
     * 季节的名称如：春天
     */
    private String categorySeasonValue;

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
     * 季节表的主键id
     * @return category_season_id 季节表的主键id
     */
    public Integer getCategorySeasonId() {
        return categorySeasonId;
    }

    /**
     * 季节表的主键id
     * @param categorySeasonId 季节表的主键id
     */
    public void setCategorySeasonId(Integer categorySeasonId) {
        this.categorySeasonId = categorySeasonId;
    }

    /**
     * 季节的名称如：春天
     * @return category_season_value 季节的名称如：春天
     */
    public String getCategorySeasonValue() {
        return categorySeasonValue;
    }

    /**
     * 季节的名称如：春天
     * @param categorySeasonValue 季节的名称如：春天
     */
    public void setCategorySeasonValue(String categorySeasonValue) {
        this.categorySeasonValue = categorySeasonValue == null ? null : categorySeasonValue.trim();
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