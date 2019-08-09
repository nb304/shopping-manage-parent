package com.king2.product.server.log;


import cn.hutool.core.date.DateUtil;
import com.king2.commons.utils.FileUtil;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Date;

/*=======================================================
	说明:   商品模块的日志操作对象

	作者		时间					注释
  	俞烨		2019.08.08   			创建
=======================================================*/
public class ProductServerLog {

    // 定义初始化日志的文件路径
    public static final String PRODUCT_SYSTEM_INFO_FILE = FileUtil.SYSTEM_PATH + "/public/ProductLog/" + "productInitLog.txt";

    /**
     * -----------------------------------------------------
     * 功能:  系统初始化的LOG日志
     * <p>
     * 参数:
     * <p>
     * 返回: void
     * -----------------------------------------------------
     */
    public static void systemInitLog() throws Exception {

        // 查询系统日志文件夹是否创建成功
        createLogFile();
    }

    /**
     * 判断是否要创建日志文件夹
     */
    private static void createLogFile() throws Exception {

        // 创建文件夹
        FileUtil.createFolder(FileUtil.SYSTEM_PATH + "/public/ProductLog");
        // 创建文件
        FileUtil.createFile(PRODUCT_SYSTEM_INFO_FILE);
        // 写入信息
        FileUtil.fileWrite(PRODUCT_SYSTEM_INFO_FILE,
                "========================== 商品模块初始化日志 创建时间--" + DateUtil.formatDateTime(new Date()) + " ==========================",
                true);
    }
}
