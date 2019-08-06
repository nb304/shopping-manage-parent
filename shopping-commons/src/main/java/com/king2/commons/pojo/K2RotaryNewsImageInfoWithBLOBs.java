package com.king2.commons.pojo;

public class K2RotaryNewsImageInfoWithBLOBs extends K2RotaryNewsImageInfo {
    /**
     * 新闻图片
     */
    private String rotaryImage;

    /**
     * 指定跳转的链接地址
     */
    private String rotaryImageUrl;

    /**
     * 新闻描述
     */
    private String rotaryDescribe;

    /**
     * 新闻图片
     * @return rotary_image 新闻图片
     */
    public String getRotaryImage() {
        return rotaryImage;
    }

    /**
     * 新闻图片
     * @param rotaryImage 新闻图片
     */
    public void setRotaryImage(String rotaryImage) {
        this.rotaryImage = rotaryImage == null ? null : rotaryImage.trim();
    }

    /**
     * 指定跳转的链接地址
     * @return rotary_image_url 指定跳转的链接地址
     */
    public String getRotaryImageUrl() {
        return rotaryImageUrl;
    }

    /**
     * 指定跳转的链接地址
     * @param rotaryImageUrl 指定跳转的链接地址
     */
    public void setRotaryImageUrl(String rotaryImageUrl) {
        this.rotaryImageUrl = rotaryImageUrl == null ? null : rotaryImageUrl.trim();
    }

    /**
     * 新闻描述
     * @return rotary_describe 新闻描述
     */
    public String getRotaryDescribe() {
        return rotaryDescribe;
    }

    /**
     * 新闻描述
     * @param rotaryDescribe 新闻描述
     */
    public void setRotaryDescribe(String rotaryDescribe) {
        this.rotaryDescribe = rotaryDescribe == null ? null : rotaryDescribe.trim();
    }
}