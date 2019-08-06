package com.king2.commons.pojo;

public class K2OneRotaryNewsWithBLOBs extends K2OneRotaryNews {
    /**
     * 新闻跳转链接
     */
    private String oneRotaryNewsUrl;

    /**
     * 新闻图片
     */
    private String oneRotaryNewsImage;

    /**
     * 新闻跳转链接
     * @return one_rotary_news_url 新闻跳转链接
     */
    public String getOneRotaryNewsUrl() {
        return oneRotaryNewsUrl;
    }

    /**
     * 新闻跳转链接
     * @param oneRotaryNewsUrl 新闻跳转链接
     */
    public void setOneRotaryNewsUrl(String oneRotaryNewsUrl) {
        this.oneRotaryNewsUrl = oneRotaryNewsUrl == null ? null : oneRotaryNewsUrl.trim();
    }

    /**
     * 新闻图片
     * @return one_rotary_news_image 新闻图片
     */
    public String getOneRotaryNewsImage() {
        return oneRotaryNewsImage;
    }

    /**
     * 新闻图片
     * @param oneRotaryNewsImage 新闻图片
     */
    public void setOneRotaryNewsImage(String oneRotaryNewsImage) {
        this.oneRotaryNewsImage = oneRotaryNewsImage == null ? null : oneRotaryNewsImage.trim();
    }
}