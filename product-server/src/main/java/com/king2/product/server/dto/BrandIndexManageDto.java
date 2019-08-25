package com.king2.product.server.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

// ��ƷƷ����ҳ����Dto
public class BrandIndexManageDto {

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
    private List brandDatas;

    private String brandName;

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

    public List getBrandDatas() {
        return brandDatas;
    }

    public void setBrandDatas(List brandDatas) {
        this.brandDatas = brandDatas;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
