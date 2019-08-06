package com.king2.commons.pojo;

import java.math.BigDecimal;

public class K2PurchaseProduct {
    /**
     * 采购商品id自增主键
     */
    private Integer ppId;

    /**
     * 采购商品名称
     */
    private String ppProductName;

    /**
     * 采购商品描述
     */
    private String ppProductDesc;

    /**
     * 采购商品数量 
     */
    private Integer ppProductNumber;

    /**
     * 采购商品价格
     */
    private BigDecimal ppPriceCount;

    /**
     * 商品收货数量
     */
    private Integer ppGoodsQuantity;

    /**
     * 采购商品删除标志 0:删除  1:未删除
     */
    private Integer ppDelFlag;

    /**
     * 采购单id自增主键(关联采购单表)
     */
    private Integer poId;

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
     * 采购商品id自增主键
     * @return pp_id 采购商品id自增主键
     */
    public Integer getPpId() {
        return ppId;
    }

    /**
     * 采购商品id自增主键
     * @param ppId 采购商品id自增主键
     */
    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    /**
     * 采购商品名称
     * @return pp_product_name 采购商品名称
     */
    public String getPpProductName() {
        return ppProductName;
    }

    /**
     * 采购商品名称
     * @param ppProductName 采购商品名称
     */
    public void setPpProductName(String ppProductName) {
        this.ppProductName = ppProductName == null ? null : ppProductName.trim();
    }

    /**
     * 采购商品描述
     * @return pp_product_desc 采购商品描述
     */
    public String getPpProductDesc() {
        return ppProductDesc;
    }

    /**
     * 采购商品描述
     * @param ppProductDesc 采购商品描述
     */
    public void setPpProductDesc(String ppProductDesc) {
        this.ppProductDesc = ppProductDesc == null ? null : ppProductDesc.trim();
    }

    /**
     * 采购商品数量 
     * @return pp_product_number 采购商品数量 
     */
    public Integer getPpProductNumber() {
        return ppProductNumber;
    }

    /**
     * 采购商品数量 
     * @param ppProductNumber 采购商品数量 
     */
    public void setPpProductNumber(Integer ppProductNumber) {
        this.ppProductNumber = ppProductNumber;
    }

    /**
     * 采购商品价格
     * @return pp_price_count 采购商品价格
     */
    public BigDecimal getPpPriceCount() {
        return ppPriceCount;
    }

    /**
     * 采购商品价格
     * @param ppPriceCount 采购商品价格
     */
    public void setPpPriceCount(BigDecimal ppPriceCount) {
        this.ppPriceCount = ppPriceCount;
    }

    /**
     * 商品收货数量
     * @return pp_goods_quantity 商品收货数量
     */
    public Integer getPpGoodsQuantity() {
        return ppGoodsQuantity;
    }

    /**
     * 商品收货数量
     * @param ppGoodsQuantity 商品收货数量
     */
    public void setPpGoodsQuantity(Integer ppGoodsQuantity) {
        this.ppGoodsQuantity = ppGoodsQuantity;
    }

    /**
     * 采购商品删除标志 0:删除  1:未删除
     * @return pp_del_flag 采购商品删除标志 0:删除  1:未删除
     */
    public Integer getPpDelFlag() {
        return ppDelFlag;
    }

    /**
     * 采购商品删除标志 0:删除  1:未删除
     * @param ppDelFlag 采购商品删除标志 0:删除  1:未删除
     */
    public void setPpDelFlag(Integer ppDelFlag) {
        this.ppDelFlag = ppDelFlag;
    }

    /**
     * 采购单id自增主键(关联采购单表)
     * @return po_id 采购单id自增主键(关联采购单表)
     */
    public Integer getPoId() {
        return poId;
    }

    /**
     * 采购单id自增主键(关联采购单表)
     * @param poId 采购单id自增主键(关联采购单表)
     */
    public void setPoId(Integer poId) {
        this.poId = poId;
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