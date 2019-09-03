package com.king2.product.server.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * ϵͳ֪ͨ��ҳ
 */
public class SystemFeedbackIndexDto {


    // ��ǰҳ��
    @NotNull(message = "��ǰҳ������Ϊ��")
    @Min(value = 1, message = "��Сҳ��Ϊ1")
    private Integer currentPage;
    // ��ǰ��ʾ����
    @NotNull(message = "��ǰ��ʾ��������Ϊ��")
    @Min(value = 1, message = "��С����Ϊ1")
    private Integer currentSize;
    // ������
    private Integer totalSize;
    // ��ҳ��
    private Integer totlaPage;
    // ��ҳ��������
    private Integer index;
    // ��ǰ��ҳ������
    private List systemFeedBackDatas;

    // ϵͳ֪ͨ״̬��
    private List<SystemStateDto> systemStateDtos;

    // ��ʼ����
    private String startTimeStr;
    private Date startTime;

    // ѡ�е�״̬��Ϣ
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
