package com.king2.product.server.pojo;

import com.king2.commons.pojo.K2ProductEvaluateWithBLOBs;

public class ProductEvaluatePojo extends K2ProductEvaluateWithBLOBs {

    // 用户名
    private String uName;
    // 头像
    private String image;

    // 商品名称
    private String pName;
    // 商品图片
    private String pImage;

    private String createTimeStr;

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }
}
