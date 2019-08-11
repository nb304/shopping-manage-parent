package com.king2.commons.utils;

import com.king2.commons.result.SystemResult;
import io.minio.MinioClient;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


/*=======================================================
	说明:    Minio文件服务器的操作工具类

	作者		时间					注释
  	俞烨		2019.08.06   			创建
=======================================================*/
public class MinioUtil {


    // 定义minio的url
    private String minioUrl;
    // 定义minio的用户名
    private String username;
    // 定义minio的密码
    private String password;
    // 定义添加的桶名称
    private String bucketName;

    public MinioUtil(String minioUrl, String username, String password, String bucketName) {
        // 判断信息
        if (StringUtils.isEmpty(minioUrl)) {
            throw new RuntimeException("MinIo服务器地址不能为空");
        } else if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new RuntimeException("MinIo的用户名和密码不能为空");
        } else if (StringUtils.isEmpty(bucketName)) {
            throw new RuntimeException("需要操作的桶名称不能为空");
        }

        this.minioUrl = minioUrl;
        this.username = username;
        this.password = password;
        this.bucketName = bucketName;
    }


    /**
     * -----------------------------------------------------
     * 功能:  上传图片的方法
     * <p>
     * 参数:
     * multipartFile            MultipartFile           图片对象
     * fileName                 String                  图片名称
     * fileType                 String                  文件类型
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    public SystemResult uploadFile(MultipartFile multipartFile, String fileName, String fileType) throws Exception {

        // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
        MinioClient minioClient = new MinioClient(minioUrl, username, password);

        // 查询桶是否已经存在
        // 检查存储桶是否已经存在
        boolean isExist = minioClient.bucketExists(bucketName);
        // 不存在就创建
        if (!isExist) minioClient.makeBucket(bucketName);

        // 上传文件
        minioClient.putObject(bucketName, fileName, multipartFile.getInputStream(), fileType);
        // 上传成功查询图片地址
        String url = minioClient.getObjectUrl(bucketName, fileName);
        return new SystemResult(url);
    }

    /*public static void main(String[] args) throws Exception {
        try {


            // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
            MinioClient minioClient = new MinioClient("http://39.105.41.2:9000", "11RZ2CRLYMM2G6G65J77", "bmYqP1euEGZIbqz3cVOzZ0nAnrbu48ORiOVPIyAT");

            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists("king2-product-image");
            if (isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
                minioClient.makeBucket("asiatrip");
            }

            // 读取一个文件
            File file = new File("D:\\ideaBackImg.jpg");

            // 使用putObject上传一个文件到存储桶中。
            minioClient.putObject("king2-product-image", "asiaphotos.jpg", new FileInputStream(file), "image/jpeg");
            String url = minioClient.getObjectUrl("king2-product-image", "asiaphotos.jpg");
            System.out.println(url);
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }*/
}
