package com.king2.product.server.enmu;

// 商品状态的枚举类
public enum ProductStateEnum {

    ALL("全部", 0),// 全部商品
    SJ("上架", 1),  // 商品上架的状态
    XJ("下架", 1), // 商品下架的状态
    DEL("删除", 3), // 商品删除的状态
    EDIT("编辑中", 4), // 商品编辑中的状态
    SH("审核中", 5), // 审核中的状态
    KCYES("库存充足", 6), // 库存充足的状态
    KCNO("库存不足", 7), // 库存不足的状态
    SHNO("审核不通过", 8);

    private final int value;
    private final String key;

    ProductStateEnum(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

}
