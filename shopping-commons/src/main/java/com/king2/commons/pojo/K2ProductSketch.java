package com.king2.commons.pojo;

public class K2ProductSketch {
    /**
     * 商品简述表主键id
     */
    private Integer productSketchId;

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
     * 商品简述的信息
     */
    private String productSketchValue;

    /**
     * 商品简述表主键id
     * @return product_sketch_id 商品简述表主键id
     */
    public Integer getProductSketchId() {
        return productSketchId;
    }

    /**
     * 商品简述表主键id
     * @param productSketchId 商品简述表主键id
     */
    public void setProductSketchId(Integer productSketchId) {
        this.productSketchId = productSketchId;
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

    /**
     * 商品简述的信息
     * @return product_sketch_value 商品简述的信息
     */
    public String getProductSketchValue() {
        return productSketchValue;
    }

    /**
     * 商品简述的信息
     * @param productSketchValue 商品简述的信息
     */
    public void setProductSketchValue(String productSketchValue) {
        this.productSketchValue = productSketchValue == null ? null : productSketchValue.trim();
    }
}