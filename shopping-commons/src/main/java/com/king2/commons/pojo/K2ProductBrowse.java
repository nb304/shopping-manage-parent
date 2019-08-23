package com.king2.commons.pojo;

import java.util.Date;

public class K2ProductBrowse {
    private Integer productBrowseId;

    private Integer browseUserId;

    private Integer browseProductId;

    private Date createTime;

    private Integer state;

    public Integer getProductBrowseId() {
        return productBrowseId;
    }

    public void setProductBrowseId(Integer productBrowseId) {
        this.productBrowseId = productBrowseId;
    }

    public Integer getBrowseUserId() {
        return browseUserId;
    }

    public void setBrowseUserId(Integer browseUserId) {
        this.browseUserId = browseUserId;
    }

    public Integer getBrowseProductId() {
        return browseProductId;
    }

    public void setBrowseProductId(Integer browseProductId) {
        this.browseProductId = browseProductId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}