package com.king2.product.server.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

// 商品类目首页Dto
public class CategoryIndexManageDto {

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
    private List categoryDatas;

    private String categoryName;

    private boolean addOrEdit;

    // 一级类目的信息
    private List oneCategorDatas;

    // 四季的信息
    private List siJieDatas;

    public List getSiJieDatas() {
        return siJieDatas;
    }

    public void setSiJieDatas(List siJieDatas) {
        this.siJieDatas = siJieDatas;
    }

    public List getOneCategorDatas() {
        return oneCategorDatas;
    }

    public void setOneCategorDatas(List oneCategorDatas) {
        this.oneCategorDatas = oneCategorDatas;
    }

    public boolean isAddOrEdit() {
        return addOrEdit;
    }

    public void setAddOrEdit(boolean addOrEdit) {
        this.addOrEdit = addOrEdit;
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

    public List getCategoryDatas() {
        return categoryDatas;
    }

    public void setCategoryDatas(List categoryDatas) {
        this.categoryDatas = categoryDatas;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
