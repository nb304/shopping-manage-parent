package com.king2.product.server.log;


import cn.hutool.core.date.DateUtil;
import com.king2.commons.utils.FileUtil;
import java.util.Date;

/*=======================================================
	˵��:   ��Ʒģ�����־��������

	����		ʱ��					ע��
  	����		2019.08.08   			����
=======================================================*/
public class ProductServerLog {

    // �����ʼ����־���ļ�·��
    public static final String PRODUCT_SYSTEM_INFO_FILE = FileUtil.SYSTEM_PATH + "/public/ProductLog/" + "productInitLog.txt";

    /**
     * -----------------------------------------------------
     * ����:  ϵͳ��ʼ����LOG��־
     * <p>
     * ����:
     * <p>
     * ����: void
     * -----------------------------------------------------
     */
    public static void systemInitLog() throws Exception {

        // ��ѯϵͳ��־�ļ����Ƿ񴴽��ɹ�
        createLogFile();
    }

    /**
     * �ж��Ƿ�Ҫ������־�ļ���
     */
    private static void createLogFile() throws Exception {

        // �����ļ���
        FileUtil.createFolder(FileUtil.SYSTEM_PATH + "/public/ProductLog");
        // �����ļ�
        FileUtil.createFile(PRODUCT_SYSTEM_INFO_FILE);
        // д����Ϣ
        FileUtil.fileWrite(PRODUCT_SYSTEM_INFO_FILE,
                "========================== ��Ʒģ���ʼ����־ ����ʱ��--" + DateUtil.formatDateTime(new Date()) + " ==========================",
                true);
    }
}
