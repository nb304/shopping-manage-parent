package com.king2.product.server.dto;

public class ProductImageDto {

    // 商品图片的假id
    private Integer productId;
    // 商品图片的URL
    private String imageUrl;
    // 商品图片的排序
    private Integer order;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
