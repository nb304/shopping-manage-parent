package com.king2.commons.pojo;

import java.util.Date;

public class K2ProductEditSize {
    private Integer editSize;

    private Integer editProductId;

    private Date lastUpdateTime;

    private Date nextUpdateTime;

    private Integer lastUpdateUserId;

    private String lastUpdateUserNaem;

    private String retain1;

    private String retain2;

    private String retain3;

    private String retain4;

    private String retain5;

    public Integer getEditSize() {
        return editSize;
    }

    public void setEditSize(Integer editSize) {
        this.editSize = editSize;
    }

    public Integer getEditProductId() {
        return editProductId;
    }

    public void setEditProductId(Integer editProductId) {
        this.editProductId = editProductId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getNextUpdateTime() {
        return nextUpdateTime;
    }

    public void setNextUpdateTime(Date nextUpdateTime) {
        this.nextUpdateTime = nextUpdateTime;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public String getLastUpdateUserNaem() {
        return lastUpdateUserNaem;
    }

    public void setLastUpdateUserNaem(String lastUpdateUserNaem) {
        this.lastUpdateUserNaem = lastUpdateUserNaem == null ? null : lastUpdateUserNaem.trim();
    }

    public String getRetain1() {
        return retain1;
    }

    public void setRetain1(String retain1) {
        this.retain1 = retain1 == null ? null : retain1.trim();
    }

    public String getRetain2() {
        return retain2;
    }

    public void setRetain2(String retain2) {
        this.retain2 = retain2 == null ? null : retain2.trim();
    }

    public String getRetain3() {
        return retain3;
    }

    public void setRetain3(String retain3) {
        this.retain3 = retain3 == null ? null : retain3.trim();
    }

    public String getRetain4() {
        return retain4;
    }

    public void setRetain4(String retain4) {
        this.retain4 = retain4 == null ? null : retain4.trim();
    }

    public String getRetain5() {
        return retain5;
    }

    public void setRetain5(String retain5) {
        this.retain5 = retain5 == null ? null : retain5.trim();
    }
}