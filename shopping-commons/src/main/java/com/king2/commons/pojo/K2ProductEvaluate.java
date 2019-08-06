package com.king2.commons.pojo;

import java.util.Date;

public class K2ProductEvaluate {
    /**
     * 商品评价表的主键id
     */
    private Integer productEvaluateId;

    /**
     * 该评价属于哪条订单
     */
    private String orderNumber;

    /**
     * 该评价的用户id ---指向用户主键id
     */
    private Integer productEvaluateUserid;

    /**
     * 该评价的用户名称 ---冗余字段
     */
    private String productEvaluateUsername;

    /**
     * 该评价的创建时间
     */
    private Date createTime;

    /**
     * 该评价属于哪个商品 ---指向商品表
     */
    private Integer belongProductId;

    /**
     * 该评价属于哪个商品的名称  ---冗余字段
     */
    private String belongProductName;

    /**
     * 该评价属于哪个店铺  ---指向店铺主键id
     */
    private Integer belongStoreId;

    /**
     * 评价的状态  1好评  2中评 3差评 4删除
     */
    private Integer productEvaluateState;

    /**
     * 是否已读  ---0未读  1已读
     */
    private Integer isRead;

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
     * 商品评价表的主键id
     * @return product_evaluate_id 商品评价表的主键id
     */
    public Integer getProductEvaluateId() {
        return productEvaluateId;
    }

    /**
     * 商品评价表的主键id
     * @param productEvaluateId 商品评价表的主键id
     */
    public void setProductEvaluateId(Integer productEvaluateId) {
        this.productEvaluateId = productEvaluateId;
    }

    /**
     * 该评价属于哪条订单
     * @return order_number 该评价属于哪条订单
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 该评价属于哪条订单
     * @param orderNumber 该评价属于哪条订单
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    /**
     * 该评价的用户id ---指向用户主键id
     * @return product_evaluate_userid 该评价的用户id ---指向用户主键id
     */
    public Integer getProductEvaluateUserid() {
        return productEvaluateUserid;
    }

    /**
     * 该评价的用户id ---指向用户主键id
     * @param productEvaluateUserid 该评价的用户id ---指向用户主键id
     */
    public void setProductEvaluateUserid(Integer productEvaluateUserid) {
        this.productEvaluateUserid = productEvaluateUserid;
    }

    /**
     * 该评价的用户名称 ---冗余字段
     * @return product_evaluate_username 该评价的用户名称 ---冗余字段
     */
    public String getProductEvaluateUsername() {
        return productEvaluateUsername;
    }

    /**
     * 该评价的用户名称 ---冗余字段
     * @param productEvaluateUsername 该评价的用户名称 ---冗余字段
     */
    public void setProductEvaluateUsername(String productEvaluateUsername) {
        this.productEvaluateUsername = productEvaluateUsername == null ? null : productEvaluateUsername.trim();
    }

    /**
     * 该评价的创建时间
     * @return create_time 该评价的创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 该评价的创建时间
     * @param createTime 该评价的创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 该评价属于哪个商品 ---指向商品表
     * @return belong_product_id 该评价属于哪个商品 ---指向商品表
     */
    public Integer getBelongProductId() {
        return belongProductId;
    }

    /**
     * 该评价属于哪个商品 ---指向商品表
     * @param belongProductId 该评价属于哪个商品 ---指向商品表
     */
    public void setBelongProductId(Integer belongProductId) {
        this.belongProductId = belongProductId;
    }

    /**
     * 该评价属于哪个商品的名称  ---冗余字段
     * @return belong_product_name 该评价属于哪个商品的名称  ---冗余字段
     */
    public String getBelongProductName() {
        return belongProductName;
    }

    /**
     * 该评价属于哪个商品的名称  ---冗余字段
     * @param belongProductName 该评价属于哪个商品的名称  ---冗余字段
     */
    public void setBelongProductName(String belongProductName) {
        this.belongProductName = belongProductName == null ? null : belongProductName.trim();
    }

    /**
     * 该评价属于哪个店铺  ---指向店铺主键id
     * @return belong_store_id 该评价属于哪个店铺  ---指向店铺主键id
     */
    public Integer getBelongStoreId() {
        return belongStoreId;
    }

    /**
     * 该评价属于哪个店铺  ---指向店铺主键id
     * @param belongStoreId 该评价属于哪个店铺  ---指向店铺主键id
     */
    public void setBelongStoreId(Integer belongStoreId) {
        this.belongStoreId = belongStoreId;
    }

    /**
     * 评价的状态  1好评  2中评 3差评 4删除
     * @return product_evaluate_state 评价的状态  1好评  2中评 3差评 4删除
     */
    public Integer getProductEvaluateState() {
        return productEvaluateState;
    }

    /**
     * 评价的状态  1好评  2中评 3差评 4删除
     * @param productEvaluateState 评价的状态  1好评  2中评 3差评 4删除
     */
    public void setProductEvaluateState(Integer productEvaluateState) {
        this.productEvaluateState = productEvaluateState;
    }

    /**
     * 是否已读  ---0未读  1已读
     * @return is_read 是否已读  ---0未读  1已读
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * 是否已读  ---0未读  1已读
     * @param isRead 是否已读  ---0未读  1已读
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
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