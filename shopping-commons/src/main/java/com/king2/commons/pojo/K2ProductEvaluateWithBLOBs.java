package com.king2.commons.pojo;

public class K2ProductEvaluateWithBLOBs extends K2ProductEvaluate {
    /**
     * 本次评价内容
     */
    private String productEvaluateContent;

    /**
     * 本次评价内容图片  多张图片，隔开
     */
    private String productEvaluateImage;

    /**
     * 本次评价内容
     * @return product_evaluate_content 本次评价内容
     */
    public String getProductEvaluateContent() {
        return productEvaluateContent;
    }

    /**
     * 本次评价内容
     * @param productEvaluateContent 本次评价内容
     */
    public void setProductEvaluateContent(String productEvaluateContent) {
        this.productEvaluateContent = productEvaluateContent == null ? null : productEvaluateContent.trim();
    }

    /**
     * 本次评价内容图片  多张图片，隔开
     * @return product_evaluate_image 本次评价内容图片  多张图片，隔开
     */
    public String getProductEvaluateImage() {
        return productEvaluateImage;
    }

    /**
     * 本次评价内容图片  多张图片，隔开
     * @param productEvaluateImage 本次评价内容图片  多张图片，隔开
     */
    public void setProductEvaluateImage(String productEvaluateImage) {
        this.productEvaluateImage = productEvaluateImage == null ? null : productEvaluateImage.trim();
    }
}