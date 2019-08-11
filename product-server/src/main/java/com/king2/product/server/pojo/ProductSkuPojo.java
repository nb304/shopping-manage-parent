package com.king2.product.server.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.util.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductSkuPojo implements Comparable<ProductSkuPojo> {

    // 系统创建的SKUid
    private String productSkuKeyId;
    // sku的key
    private String productSkuKeyName;
    // sku的value
    private String skuValue;
    // sku的排序
    private String skuKeyOrder;

    // sku是否为系统定义
    private Integer isSystemCreate;
    private boolean isSystemDef;

    public String getProductSkuKeyId() {
        return productSkuKeyId;
    }

    public void setProductSkuKeyId(String productSkuKeyId) {
        this.productSkuKeyId = productSkuKeyId;
    }

    public String getProductSkuKeyName() {
        return productSkuKeyName;
    }

    public void setProductSkuKeyName(String productSkuKeyName) {
        this.productSkuKeyName = productSkuKeyName;
    }

    public String getSkuValue() {
        return skuValue;
    }

    public void setSkuValue(String skuValue) {
        this.skuValue = skuValue;
    }

    public String getSkuKeyOrder() {
        return skuKeyOrder;
    }

    public void setSkuKeyOrder(String skuKeyOrder) {
        if (StringUtils.isEmpty(skuKeyOrder) || "null".equals(skuKeyOrder)) {
            this.skuKeyOrder = null;
        } else {
            this.skuKeyOrder = skuKeyOrder;
        }
    }

    public Integer getIsSystemCreate() {
        return isSystemCreate;
    }

    public void setIsSystemCreate(Integer isSystemCreate) {
        if (isSystemCreate == 1) {
            this.isSystemDef = true;
        } else {
            this.isSystemDef = false;
        }
        this.isSystemCreate = isSystemCreate;
    }

    public boolean isSystemDef() {
        return isSystemDef;
    }

    public void setSystemDef(boolean systemDef) {
        isSystemDef = systemDef;
    }

    @Override
    public int compareTo(ProductSkuPojo o) {
        return Integer.parseInt(this.skuKeyOrder) - Integer.parseInt(o.getSkuKeyOrder());
    }
}
