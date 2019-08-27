package com.king2.product.server.dto;

import com.king2.commons.pojo.K2ProductSkuKey;

import java.util.List;

// ��ʾ��Ʒ��Ŀ��SKU��Ϣ
public class ShowCategoryOfSkuInfo {

    // ϵͳ���Ƶ�SKU��Ϣ
    private List<K2ProductSkuKey> systemSkuInfo;
    // �Ƿ���Ȩ�ޱ༭ϵͳ���ƺõ�SKU��Ϣ
    private boolean editSystemFlag;
    // �û������SKU��Ϣ
    private List<K2ProductSkuKey> userSkuInfo;
    // �Ƿ���ʾ�û���SKU��Ϣ
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
