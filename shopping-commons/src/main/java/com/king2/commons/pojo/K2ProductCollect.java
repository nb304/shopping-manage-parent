package com.king2.commons.pojo;

import java.util.Date;

public class K2ProductCollect {
    private Integer productCollectId;

    private Integer collectUserId;

    private Integer collectProductId;

    private Integer collectState;

    private Date createTime;

    public Integer getProductCollectId() {
        return productCollectId;
    }

    public void setProductCollectId(Integer productCollectId) {
        this.productCollectId = productCollectId;
    }

    public Integer getCollectUserId() {
        return collectUserId;
    }

    public void setCollectUserId(Integer collectUserId) {
        this.collectUserId = collectUserId;
    }

    public Integer getCollectProductId() {
        return collectProductId;
    }

    public void setCollectProductId(Integer collectProductId) {
        this.collectProductId = collectProductId;
    }

    public Integer getCollectState() {
        return collectState;
    }

    public void setCollectState(Integer collectState) {
        this.collectState = collectState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}