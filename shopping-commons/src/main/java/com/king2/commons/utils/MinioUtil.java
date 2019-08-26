package com.king2.commons.utils;

import com.king2.commons.result.SystemResult;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
import io.minio.policy.BucketPolicy;
import io.minio.policy.PolicyType;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


/*=======================================================
	˵��:    Minio�ļ��������Ĳ���������

	����		ʱ��					ע��
  	����		2019.08.06   			����
=======================================================*/
public class MinioUtil {


    // ����minio��url
    private String minioUrl;
    // ����minio���û���
    private String username;
    // ����minio������
    private String password;
    // ������ӵ�Ͱ����
    private String bucketName;

    public MinioUtil(String minioUrl, String username, String password, String bucketName) {
        // �ж���Ϣ
        if (StringUtils.isEmpty(minioUrl)) {
            throw new RuntimeException("MinIo��������ַ����Ϊ��");
        } else if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new RuntimeException("MinIo���û��������벻��Ϊ��");
        } else if (StringUtils.isEmpty(bucketName)) {
            throw new RuntimeException("��Ҫ������Ͱ���Ʋ���Ϊ��");
        }

        this.minioUrl = minioUrl;
        this.username = username;
        this.password = password;
        this.bucketName = bucketName;
    }


    /**
     * -----------------------------------------------------
     * ����:  �ϴ�ͼƬ�ķ���
     * <p>
     * ����:
     * multipartFile            MultipartFile           ͼƬ����
     * fileName                 String                  ͼƬ����
     * fileType                 String                  �ļ�����
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public SystemResult uploadFile(MultipartFile multipartFile, String fileName, String fileType) throws Exception {

        // ʹ��MinIO�����URL���˿ڣ�Access key��Secret key����һ��MinioClient����
        MinioClient minioClient = new MinioClient(minioUrl, username, password);

        // ��ѯͰ�Ƿ��Ѿ�����
        // ���洢Ͱ�Ƿ��Ѿ�����
        boolean isExist = minioClient.bucketExists(bucketName);
        // �����ھʹ���
        if (!isExist) minioClient.makeBucket(bucketName);

        // �ϴ��ļ�
        minioClient.putObject(bucketName, fileName, multipartFile.getInputStream(), "image/jpeg");
        // �ϴ��ɹ���ѯͼƬ��ַ
        String url = minioClient.getObjectUrl(bucketName, fileName);
        return new SystemResult(url);
    }

    /**
     * -----------------------------------------------------
     * ����:  ɾ���ļ��ķ���
     * <p>
     * ����:
     * delFileName            String           ��Ҫɾ�����ļ�����
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public SystemResult delFile(String delFileName) throws Exception {
        // ʹ��MinIO�����URL���˿ڣ�Access key��Secret key����һ��MinioClient����
        MinioClient minioClient = new MinioClient(minioUrl, username, password);
        minioClient.removeObject(bucketName, delFileName);
        return new SystemResult("ok");
    }

}
