package com.king2.product.server.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

// �û�������ҳ��Dto����
public class UserFeedbackIndexDto {

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
    private List feedbackDatas;

    private String feedNumber;

    private String userName;

    private String startTimeStr;

    private String endTimeStr;

    private Date startTime;

    private Date endTime;

    // �Ƿ���д���  �������ŵ�״̬  ---1������ 2�Ѵ��� 4ɾ��
    private String state;

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

    public List getFeedbackDatas() {
        return feedbackDatas;
    }

    public void setFeedbackDatas(List feedbackDatas) {
        this.feedbackDatas = feedbackDatas;
    }

    public String getFeedNumber() {
        return feedNumber;
    }

    public void setFeedNumber(String feedNumber) {
        this.feedNumber = feedNumber;
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
