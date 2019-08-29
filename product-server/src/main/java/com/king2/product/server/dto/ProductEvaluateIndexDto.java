package com.king2.product.server.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

// 商品首页Dto
public class ProductEvaluateIndexDto {


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
    private List productEvaluateDatas;

    // 当前选中的是好评还是差评
    private Integer isHZCState;

    // 订单编号
    private String orderNumber;

    // 商品名称
    private String productName;

    // 用户名
    private String userName;

    // 开始时间
    private String startTimeStr;

    // 结束时间
    private String endTimeStr;

    // 开始时间
    private Date startTime;

    // 结束时间
    private Date endTime;

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

    public List getProductEvaluateDatas() {
        return productEvaluateDatas;
    }

    public void setProductEvaluateDatas(List productEvaluateDatas) {
        this.productEvaluateDatas = productEvaluateDatas;
    }

    public Integer getIsHZCState() {
        return isHZCState;
    }

    public void setIsHZCState(Integer isHZCState) {
        this.isHZCState = isHZCState;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
