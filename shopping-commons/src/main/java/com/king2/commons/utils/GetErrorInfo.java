package com.king2.commons.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 获取错误日志
 */
public class GetErrorInfo {

    /**
     * 获取错误信息
     *
     * @param t
     * @return
     */
    public static String getTrace(Throwable t) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer = stringWriter.getBuffer();
        return buffer.toString();
    }
}
