package com.king2.product.server.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//  ��Ʒ�ٱ�Pojo
public class ProductEvaluatePortPojo {


    // �ٱ�������id
    @NotNull(message = "�ٱ�������id����Ϊ��")
    private Integer reportEvId;
    // �ٱ�������
    @NotNull(message = "�ٱ���״̬����Ϊ��")
    @Min(value = 1)
    @Max(value = 3)
    private Integer reportState;
    //�ٱ�������
    @NotBlank(message = "�ٱ������ݲ���Ϊ��")
    @Length(max = 1000, message = "�ٱ������ݹ���,����1-1000����")
    private String reportContent;


    public Integer getReportEvId() {
        return reportEvId;
    }

    public void setReportEvId(Integer reportEvId) {
        this.reportEvId = reportEvId;
    }

    public Integer getReportState() {
        return reportState;
    }

    public void setReportState(Integer reportState) {
        this.reportState = reportState;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
}
