package com.king2.commons.pojo;


import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class K2ProductWithBLOBs extends K2Product implements Serializable {
    /**
     * 商品卖点
     */
    @NotBlank(message = "商品卖点不能为空")
    private String productPoints;

    /**
     * 商品图片  ---多张图片,隔开
     */
    private String productImage;

    /**
     * 商品详情图片 ---多张图片,隔开
     */
    private String productImageDescribe;

    /**
     * 商品卖点
     *
     * @return product_points 商品卖点
     */
    public String getProductPoints() {
        return productPoints;
    }

    /**
     * 商品卖点
     *
     * @param productPoints 商品卖点
     */
    public void setProductPoints(String productPoints) {
        this.productPoints = productPoints == null ? null : productPoints.trim();
    }

    /**
     * 商品图片  ---多张图片,隔开
     *
     * @return product_image 商品图片  ---多张图片,隔开
     */
    public String getProductImage() {
        return productImage;
    }

    /**
     * 商品图片  ---多张图片,隔开
     *
     * @param productImage 商品图片  ---多张图片,隔开
     */
    public void setProductImage(String productImage) {
        this.productImage = productImage == null ? null : productImage.trim();
    }

    /**
     * 商品详情图片 ---多张图片,隔开
     *
     * @return product_image_describe 商品详情图片 ---多张图片,隔开
     */
    public String getProductImageDescribe() {
        return productImageDescribe;
    }

    /**
     * 商品详情图片 ---多张图片,隔开
     *
     * @param productImageDescribe 商品详情图片 ---多张图片,隔开
     */
    public void setProductImageDescribe(String productImageDescribe) {
        this.productImageDescribe = productImageDescribe == null ? null : productImageDescribe.trim();
    }


    public void editClearValue() {
        this.setProductNumber(null);
        this.setProductTwoCategoryId(null);
        this.setProductOneCategoryId(null);
        this.productImage = null;
        this.productImageDescribe = null;
    }
}
