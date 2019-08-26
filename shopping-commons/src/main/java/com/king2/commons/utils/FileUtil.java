package com.king2.commons.utils;

import com.king2.commons.result.SystemResult;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.FileWriter;

/*================================================================
˵�����ļ�����������

����      ʱ��           		 ע��
����      2019.8.9     		 ����
==================================================================*/
public class FileUtil {

    /**
     * ϵͳ���·��
     */
    public static final String SYSTEM_PATH = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1);

    /**
     * -----------------------------------------------------
     * ����:  �����ļ���
     * <p>
     * ����:
     * path         String          �ļ��е�·��
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static SystemResult createFolder(String path) {

        // �������ض���
        SystemResult result = new SystemResult();
        // �ж��ļ����Ƿ����
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
            result.setData(file);
            result.setMsg("�����ɹ�");
            result.setStatus(200);
        } else {
            result.setData(file);
            result.setMsg("�ļ��д���ʧ��,�Ѵ���");
            result.setStatus(200);
        }
        return result;
    }

    /**
     * -----------------------------------------------------
     * ����:  �����ļ�
     * <p>
     * ����:
     * path         String          �ļ���·��
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static SystemResult createFile(String path) throws Exception {
        // �������ض���
        SystemResult result = new SystemResult();
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
            result.setData(file);
            result.setMsg("�����ɹ�");
            result.setStatus(200);
        } else {
            result.setData(file);
            result.setMsg("�ļ�����ʧ��,�Ѵ���");
            result.setStatus(200);
        }
        return result;
    }

    /**
     * -----------------------------------------------------
     * ����:  д���ļ�����
     * <p>
     * ����:
     * filePath         String          �ļ���·��
     * msg              String          д�����Ϣ
     * append           boolean         ����д��������Ƿ���ӵ��ļ�ĩβ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static SystemResult fileWrite(String filePath, String msg, boolean append) throws Exception {

        // �����ļ�������
        FileWriter writer = new FileWriter(new File(filePath), append);
        writer.write(msg);
        writer.write("\r\n");
        writer.flush();
        writer.close();
        return new SystemResult("ok");
    }
}
