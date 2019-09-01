package com.king2.product.server.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 系统通知主页
 */
public class SystemFeedbackIndexDto {


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
    private List systemFeedBackDatas;

    // 系统通知状态表
    private List<SystemStateDto> systemStateDtos;

    // 开始日期
    private String startTimeStr;
    private Date startTime;

    // 选中的状态信息
    private Integer state;

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

    public List getSystemFeedBackDatas() {
        return systemFeedBackDatas;
    }

    public void setSystemFeedBackDatas(List systemFeedBackDatas) {
        this.systemFeedBackDatas = systemFeedBackDatas;
    }

    public List<SystemStateDto> getSystemStateDtos() {
        return systemStateDtos;
    }

    public void setSystemStateDtos(List<SystemStateDto> systemStateDtos) {
        this.systemStateDtos = systemStateDtos;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
