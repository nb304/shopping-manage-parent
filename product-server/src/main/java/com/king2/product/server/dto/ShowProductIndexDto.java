package com.king2.product.server.dto;

import com.king2.commons.pojo.K2ProductWithBLOBs;

import java.util.List;

// 显示商品主页主要的DTO数据
public class ShowProductIndexDto {


   // 商品信息
    private List<ProductInfoToRedisDataDto> productInfoToRedisDataDtos;
    // 该店铺的商品总数量
    private Integer totalSize;

    public List<ProductInfoToRedisDataDto> getProductInfoToRedisDataDtos() {
        return productInfoToRedisDataDtos;
    }

    public void setProductInfoToRedisDataDtos(List<ProductInfoToRedisDataDto> productInfoToRedisDataDtos) {
        this.productInfoToRedisDataDtos = productInfoToRedisDataDtos;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }
}
