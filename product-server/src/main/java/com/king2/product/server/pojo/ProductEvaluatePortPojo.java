package com.king2.product.server.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//  商品举报Pojo
public class ProductEvaluatePortPojo {


    // 举报的评价id
    @NotNull(message = "举报的内容id不能为空")
    private Integer reportEvId;
    // 举报的类型
    @NotNull(message = "举报的状态不能为空")
    @Min(value = 1)
    @Max(value = 3)
    private Integer reportState;
    //举报的内容
    @NotBlank(message = "举报的内容不能为空")
    @Length(max = 1000, message = "举报的内容过长,请检查1-1000长度")
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
