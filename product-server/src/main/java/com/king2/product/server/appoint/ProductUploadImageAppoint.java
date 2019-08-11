package com.king2.product.server.appoint;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import com.king2.commons.getnumber.ShoppingNumberManage;
import com.king2.commons.getnumber.ShoppingNumberPojo;
import com.king2.commons.mapper.K2ProductMapper;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.MinioUtil;
import com.king2.product.server.cache.SystemCacheManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisPool;

/*=======================================================
	说明:    商品图片上传委派类

	作者		时间					注释
  	俞烨		2019.08.10   			创建
=======================================================*/
@Component
public class ProductUploadImageAppoint {

    // 注入Jedis连接池
    @Autowired
    private JedisPool jedisPool;
    // 注入RestTemple模板
    @Autowired
    private RestTemplate restTemplate;
    // 注入商品图片名称存在redis中的key
    @Value("${PRODUCT_IMAGES_REDIS_KEY}")
    private String PRODUCT_IMAGES_REDIS_KEY;
    // 注入缓存服务器地址
    @Value("${CACHE_SERVER_URL}")
    private String CACHE_SERVER_URL;
    // 注入MinIo的操作
    @Value("${MINIO_SERVER_URL}")
    private String MINIO_SERVER_URL;
    @Value("${MINIO_USER_NAME}")
    private String MINIO_USER_NAME;
    @Value("${MINIO_PASS_WORD}")
    private String MINIO_PASS_WORD;
    // 注入图片的类型
    @Value("${PRODUCT_IMAGE_TYPE}")
    private String PRODUCT_IMAGE_TYPE;
    // 注入商品Mapper
    @Autowired
    private K2ProductMapper k2ProductMapper;


    /**
     * -----------------------------------------------------
     * 功能:  上传图片
     * <p>
     * 参数:
     * multipartFile            MultipartFile           图片对象
     * prefix                   String                  前缀的信息
     * productId                Integer                 该商品的id
     * size                     Integer                 该图片添加的次数
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Transactional(rollbackFor = Exception.class)
    public SystemResult upload(MultipartFile[] files, String prefix, Integer productId, Integer size, String uploadType) throws Exception {

        // 校验数据
        if (files == null || files.length < 1 || files[0] == null || StringUtils.isEmpty(files[0].getOriginalFilename()) || files[0].getInputStream() == null) {
            // 图片为空
            return new SystemResult(100, "图片不能为空", null);
        } else if (StringUtils.isEmpty(uploadType) || (!"image".equals(uploadType) && "contentImage".equals(uploadType))) {
            return new SystemResult(100, "本次上传图片的状态错误", null);
        }

        // 创建返回值信息
        StringBuilder sb = new StringBuilder();

        // 遍历图片数据
        for (MultipartFile file : files) {
            // 获取到图片的类型
            String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            if (!StringUtils.isEmpty(type)) {
                if (!PRODUCT_IMAGE_TYPE.contains(type.toLowerCase())) {
                    return new SystemResult(100, "文件类型错误", null);
                }
            }

            // 获取图片的名称
            StringBuilder sbName = new StringBuilder();
            sbName.append("king2");
            sbName.append("-");
            sbName.append(prefix);
            sbName.append("-");
            // 从缓存中取出一个编号
            ShoppingNumberPojo shoppingNumberPojo = new ShoppingNumberPojo
                    (jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA, PRODUCT_IMAGES_REDIS_KEY, "SP", 36, restTemplate, CACHE_SERVER_URL);
            // 调用编号接口
            ShoppingNumberManage sp = new ShoppingNumberManage(shoppingNumberPojo, SystemCacheManage.PRODUCT_NAME_IMAGE);
            SystemResult numberByRedisKey = sp.getNumberByRedisKey(PRODUCT_IMAGES_REDIS_KEY, 10);
            if (numberByRedisKey.getStatus() != 200) return numberByRedisKey;
            sbName.append(numberByRedisKey.getData());
            sbName.append("." + type);

            // 调用上传方法
            MinioUtil util = new MinioUtil(MINIO_SERVER_URL, MINIO_USER_NAME, MINIO_PASS_WORD, "king2-product-image");
            SystemResult systemResult = util.uploadFile(file, sbName.toString(), "image/" + type);
            if (systemResult.getStatus() != 200) return systemResult;
            if (StringUtils.isEmpty(sb.toString())) {
                sb.append(systemResult.getData() + "");
            } else {
                sb.append("," + systemResult.getData());
            }
        }

        // 图片上传完成 修改数据信息
        K2ProductWithBLOBs withBLOBs = new K2ProductWithBLOBs();
        withBLOBs.setProductId(productId);
        if ("image".equals(uploadType)) {
            withBLOBs.setProductImage(sb.toString());
        } else {
            withBLOBs.setProductImageDescribe(sb.toString());
        }

        k2ProductMapper.updateByPrimaryKeySelective(withBLOBs);
        // 有可能需要插入日志信息


        return new SystemResult(sb.toString());
    }
}
