package com.king2.product.server.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 商品首页需要的数据Dto
 */
public class ProductIndexDto {

    // 当前页数
    @NotNull(message = "当前页数不能为空")
    @Min(value = 1, message = "最小页数为1")
    private Integer currentPage;
    // 当前显示条数
    @NotNull(message = "当前显示条数不能为空")
    @Min(value = 1, message = "最小条数为1")
    private Integer currentSize;
    // 总条数
    private Integer totalSize;
    // 总页数
    private Integer totlaPage;
    // 分页索引数据
    private Integer index;
    // 当前分页的数据
    private List productDatas;

    // 商品状态的集合信息
    private List<SystemStateDto> states;

    // 条件 列表
    private String productName;
    // 商品状态
    // 商品的状态信息  ---0 全部 1上架 2下架 3删除 4编辑中 5 审核中 6 库存充足 7 库存不足
    private String state = "0";

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(Integer currentSize) {
        this.currentSize = currentSize;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getTotlaPage() {
        return totlaPage;
    }

    public void setTotlaPage(Integer totlaPage) {
        this.totlaPage = totlaPage;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public List getProductDatas() {
        return productDatas;
    }

    public void setProductDatas(List productDatas) {
        this.productDatas = productDatas;
    }


    public List<SystemStateDto> getStates() {
        return states;
    }

    public void setStates(List<SystemStateDto> states) {
        this.states = states;
    }
}
