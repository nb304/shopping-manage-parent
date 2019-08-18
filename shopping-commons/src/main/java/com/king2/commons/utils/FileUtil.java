package com.king2.commons.utils;

import com.king2.commons.result.SystemResult;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.FileWriter;

/*================================================================
说明：文件操作工具类

作者      时间           		 注释
俞烨      2019.8.9     		 创建
==================================================================*/
public class FileUtil {

    /**
     * 系统相对路径
     */
    public static final String SYSTEM_PATH = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1);

    /**
     * -----------------------------------------------------
     * 功能:  创建文件夹
     * <p>
     * 参数:
     * path         String          文件夹的路径
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult createFolder(String path) {

        // 创建返回对象
        SystemResult result = new SystemResult();
        // 判断文件夹是否存在
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
            result.setData(file);
            result.setMsg("创建成功");
            result.setStatus(200);
        } else {
            result.setData(file);
            result.setMsg("文件夹创建失败,已存在");
            result.setStatus(200);
        }
        return result;
    }

    /**
     * -----------------------------------------------------
     * 功能:  创建文件
     * <p>
     * 参数:
     * path         String          文件的路径
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult createFile(String path) throws Exception {
        // 创建返回对象
        SystemResult result = new SystemResult();
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
            result.setData(file);
            result.setMsg("创建成功");
            result.setStatus(200);
        } else {
            result.setData(file);
            result.setMsg("文件创建失败,已存在");
            result.setStatus(200);
        }
        return result;
    }

    /**
     * -----------------------------------------------------
     * 功能:  写入文件内容
     * <p>
     * 参数:
     * filePath         String          文件的路径
     * msg              String          写入的信息
     * append           boolean         本次写入的内容是否添加到文件末尾
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult fileWrite(String filePath, String msg, boolean append) throws Exception {

        // 创建文件输入流
        FileWriter writer = new FileWriter(new File(filePath), append);
        writer.write(msg);
        writer.write("\r\n");
        writer.flush();
        writer.close();
        return new SystemResult("ok");
    }
}
