package com.king2.product.server.enmu;

/**
 * 系统通知枚举类
 */
public enum SystemFeedbackEnum {

    YD("已读", 1),
    WD("未读", 2),
    DDFM("订单方面", 4),
    TS("投诉", 5),
    IS_COMMON_YES("是公共的", 0),
    IS_COMMONS_NO("不是公共的", 1),
    BELONG_USER_ID("属于的用户id,为0属于系统发送", 0),
    STORE_LOOK_YES("该店铺的都能看到", 1),
    STORE_LOOK_NO("该店铺的成员看不到", 2);

    private final int value;
    private final String key;

    SystemFeedbackEnum(String key, int value) {
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
