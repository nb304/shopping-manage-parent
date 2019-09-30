package com.king2.product.server.exception;

/**
 * 校验参数出错的信息
 */
public class CheckValueException extends Exception {

    public CheckValueException(String result) {
        super(result);
    }
}
