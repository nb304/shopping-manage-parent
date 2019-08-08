package com.king2.product.server.log;


import cn.hutool.core.date.DateUtil;
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

    /**
     * 系统相对路径
     */
    public static String SYSTEM_PATH = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1);


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

        File file = new File(SYSTEM_PATH + "/public/ProductLog");
        // 判断文件夹是否存在
        if (!file.exists()) {
            file.mkdirs();
        }

        // 创建日志文件
        file = new File(SYSTEM_PATH + "/public/ProductLog/" + "productInitLog.txt");
        if (!file.exists()) file.createNewFile();
        FileWriter writer = new FileWriter(file, true);
        writer.write("========================== 商品模块初始化日志 创建时间--" + DateUtil.formatDateTime(new Date()) + " ==========================");
        writer.flush();
        writer.close();
    }
}
