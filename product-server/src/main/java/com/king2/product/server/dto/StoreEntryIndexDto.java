package com.king2.product.server.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/*
店铺入驻主页的Dto信息
 */
public class StoreEntryIndexDto {


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
    private List storeDatas;

    // 开始时间和结束时间
    private String startTimeStr;
    private String endTimeStr;
    private Date startTime;
    private Date endTime;

    // 店铺入驻的状态信息
    private List<SystemStateDto> dtos;

    public List<SystemStateDto> getDtos() {
        return dtos;
    }

    public void setDtos(List<SystemStateDto> dtos) {
        this.dtos = dtos;
    }

    // 查询条件
    private String state;

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

    public List getStoreDatas() {
        return storeDatas;
    }

    public void setStoreDatas(List storeDatas) {
        this.storeDatas = storeDatas;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
