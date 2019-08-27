package com.king2.product.server.dto;

import com.king2.commons.pojo.K2ProductSkuKey;

import java.util.List;

// 显示商品类目的SKU信息
public class ShowCategoryOfSkuInfo {

    // 系统定制的SKU信息
    private List<K2ProductSkuKey> systemSkuInfo;
    // 是否有权限编辑系统定制好的SKU信息
    private boolean editSystemFlag;
    // 用户定义的SKU信息
    private List<K2ProductSkuKey> userSkuInfo;
    // 是否显示用户的SKU信息
    private boolean showUserInfoFlag;

    public List<K2ProductSkuKey> getSystemSkuInfo() {
        return systemSkuInfo;
    }

    public void setSystemSkuInfo(List<K2ProductSkuKey> systemSkuInfo) {
        this.systemSkuInfo = systemSkuInfo;
    }

    public boolean isEditSystemFlag() {
        return editSystemFlag;
    }

    public void setEditSystemFlag(boolean editSystemFlag) {
        this.editSystemFlag = editSystemFlag;
    }

    public List<K2ProductSkuKey> getUserSkuInfo() {
        return userSkuInfo;
    }

    public void setUserSkuInfo(List<K2ProductSkuKey> userSkuInfo) {
        this.userSkuInfo = userSkuInfo;
    }

    public boolean isShowUserInfoFlag() {
        return showUserInfoFlag;
    }

    public void setShowUserInfoFlag(boolean showUserInfoFlag) {
        this.showUserInfoFlag = showUserInfoFlag;
    }
}
