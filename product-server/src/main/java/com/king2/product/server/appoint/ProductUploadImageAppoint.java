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
	˵��:    ��ƷͼƬ�ϴ�ί����

	����		ʱ��					ע��
  	����		2019.08.10   			����
=======================================================*/
@Component
public class ProductUploadImageAppoint {

    // ע��Jedis���ӳ�
    @Autowired
    private JedisPool jedisPool;
    // ע��RestTempleģ��
    @Autowired
    private RestTemplate restTemplate;
    // ע����ƷͼƬ���ƴ���redis�е�key
    @Value("${PRODUCT_IMAGES_REDIS_KEY}")
    private String PRODUCT_IMAGES_REDIS_KEY;
    // ע�뻺���������ַ
    @Value("${CACHE_SERVER_URL}")
    private String CACHE_SERVER_URL;
    // ע��MinIo�Ĳ���
    @Value("${MINIO_SERVER_URL}")
    private String MINIO_SERVER_URL;
    @Value("${MINIO_USER_NAME}")
    private String MINIO_USER_NAME;
    @Value("${MINIO_PASS_WORD}")
    private String MINIO_PASS_WORD;
    // ע��ͼƬ������
    @Value("${PRODUCT_IMAGE_TYPE}")
    private String PRODUCT_IMAGE_TYPE;
    // ע����ƷMapper
    @Autowired
    private K2ProductMapper k2ProductMapper;


    /**
     * -----------------------------------------------------
     * ����:  �ϴ�ͼƬ
     * <p>
     * ����:
     * multipartFile            MultipartFile           ͼƬ����
     * prefix                   String                  ǰ׺����Ϣ
     * productId                Integer                 ����Ʒ��id
     * size                     Integer                 ��ͼƬ��ӵĴ���
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Transactional(rollbackFor = Exception.class)
    public SystemResult upload(MultipartFile[] files, String prefix, Integer productId, Integer size, String uploadType) throws Exception {

        // У������
        if (files == null || files.length < 1 || files[0] == null || StringUtils.isEmpty(files[0].getOriginalFilename()) || files[0].getInputStream() == null) {
            // ͼƬΪ��
            return new SystemResult(100, "ͼƬ����Ϊ��", null);
        } else if (StringUtils.isEmpty(uploadType) || (!"image".equals(uploadType) && "contentImage".equals(uploadType))) {
            return new SystemResult(100, "�����ϴ�ͼƬ��״̬����", null);
        }

        // ��������ֵ��Ϣ
        StringBuilder sb = new StringBuilder();

        // ����ͼƬ����
        for (MultipartFile file : files) {
            // ��ȡ��ͼƬ������
            String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            if (!StringUtils.isEmpty(type)) {
                if (!PRODUCT_IMAGE_TYPE.contains(type.toLowerCase())) {
                    return new SystemResult(100, "�ļ����ʹ���", null);
                }
            }

            // ��ȡͼƬ������
            StringBuilder sbName = new StringBuilder();
            sbName.append("king2");
            sbName.append("-");
            sbName.append(prefix);
            sbName.append("-");
            // �ӻ�����ȡ��һ�����
            ShoppingNumberPojo shoppingNumberPojo = new ShoppingNumberPojo
                    (jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA, PRODUCT_IMAGES_REDIS_KEY, "SP", 36, restTemplate, CACHE_SERVER_URL);
            // ���ñ�Žӿ�
            ShoppingNumberManage sp = new ShoppingNumberManage(shoppingNumberPojo, SystemCacheManage.PRODUCT_NAME_IMAGE);
            SystemResult numberByRedisKey = sp.getNumberByRedisKey(PRODUCT_IMAGES_REDIS_KEY, 10);
            if (numberByRedisKey.getStatus() != 200) return numberByRedisKey;
            sbName.append(numberByRedisKey.getData());
            sbName.append("." + type);

            // �����ϴ�����
            MinioUtil util = new MinioUtil(MINIO_SERVER_URL, MINIO_USER_NAME, MINIO_PASS_WORD, "king2-product-image");
            SystemResult systemResult = util.uploadFile(file, sbName.toString(), "image/" + type);
            if (systemResult.getStatus() != 200) return systemResult;
            if (StringUtils.isEmpty(sb.toString())) {
                sb.append(systemResult.getData() + "");
            } else {
                sb.append("," + systemResult.getData());
            }
        }

        // ͼƬ�ϴ���� �޸�������Ϣ
        K2ProductWithBLOBs withBLOBs = new K2ProductWithBLOBs();
        withBLOBs.setProductId(productId);
        if ("image".equals(uploadType)) {
            withBLOBs.setProductImage(sb.toString());
        } else {
            withBLOBs.setProductImageDescribe(sb.toString());
        }

        k2ProductMapper.updateByPrimaryKeySelective(withBLOBs);
        // �п�����Ҫ������־��Ϣ


        return new SystemResult(sb.toString());
    }
}
