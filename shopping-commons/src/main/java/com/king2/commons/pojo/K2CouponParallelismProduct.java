package com.king2.commons.pojo;

import java.util.Date;

public class K2CouponParallelismProduct {
    /**
     * 商品对应的优惠卷主键
     */
    private Integer couponParallelismProductId;

    /**
     * 优惠卷的id  ---指向优惠卷表的主键
     */
    private Integer couponId;

    /**
     * 商品id ---指向哪个商品使用了该优惠卷
     */
    private Integer productId;

    /**
     * 创建时间
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
     * 商品对应的优惠卷主键
     * @return coupon_parallelism_product_id 商品对应的优惠卷主键
     */
    public Integer getCouponParallelismProductId() {
        return couponParallelismProductId;
    }

    /**
     * 商品对应的优惠卷主键
     * @param couponParallelismProductId 商品对应的优惠卷主键
     */
    public void setCouponParallelismProductId(Integer couponParallelismProductId) {
        this.couponParallelismProductId = couponParallelismProductId;
    }

    /**
     * 优惠卷的id  ---指向优惠卷表的主键
     * @return coupon_id 优惠卷的id  ---指向优惠卷表的主键
     */
    public Integer getCouponId() {
        return couponId;
    }

    /**
     * 优惠卷的id  ---指向优惠卷表的主键
     * @param couponId 优惠卷的id  ---指向优惠卷表的主键
     */
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    /**
     * 商品id ---指向哪个商品使用了该优惠卷
     * @return product_id 商品id ---指向哪个商品使用了该优惠卷
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 商品id ---指向哪个商品使用了该优惠卷
     * @param productId 商品id ---指向哪个商品使用了该优惠卷
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
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