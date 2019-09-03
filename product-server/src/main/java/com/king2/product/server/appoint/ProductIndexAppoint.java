package com.king2.product.server.appoint;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.JsonUtils;
import com.king2.product.server.dto.ProductIndexDto;
import com.king2.product.server.dto.ProductInfoToRedisDataDto;
import com.king2.product.server.dto.ShowProductIndexDto;
import com.king2.product.server.locks.ProductQueueLockFactoryTypeEnum;
import com.king2.product.server.locks.ProductQueueLockFactory;
import com.king2.product.server.mapper.ProductManageMapper;
import com.king2.product.server.sort.ProductInfoSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*=======================================================
	˵��:    ��Ʒ��ҳ����ί����

	����		ʱ��					ע��
  	����		2019.08.12   			����
=======================================================*/
@Component
public class ProductIndexAppoint {

    // ע����Ʒ��redis�е�key
    @Value("${PRODUCT_INFO_REDIS_KEY}")
    private String PRODUCT_INFO_REDIS_KEY;

    // ע��redisģ��
    @Autowired
    private JedisPool jedisPool;

    // ע����ƷMapper
    @Autowired
    private ProductManageMapper productManageMapper;

    // ע��ÿ���̼���redis�д������Ʒ���ֵ
    @Value("${PRODUCT_GOTO_REDIS_MAX_SIZE}")
    private Integer PRODUCT_GOTO_REDIS_MAX_SIZE;

    /**
     * -----------------------------------------------------
     * ����: ��ȡ��Ʒ������redis�е���Ϣ
     * <p>
     * ����:
     * k2Member          K2Member         �������û���Ϣ
     * dto               ProductIndexDto  ������Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public SystemResult getProductInfoByQuery(K2Member k2Member, ProductIndexDto dto) {

        // ��Ʒ��Ϣ
        ShowProductIndexDto showProductIndexDto = null;
        final Jedis redis = jedisPool.getResource();
        // ��ȡ��
        ProductQueueLockFactory instance = ProductQueueLockFactory.getInstance();
        ReentrantLock reentrantLock = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_CACHE_KEY.getValue()).getLock();
        Condition condition = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_CACHE_KEY.getValue()).getCondition();
        // ������
        reentrantLock.lock();
        try {
            // ��ȡredisģ��
            // ��ѯRedis���Ƿ��������
            Map<String, String> stringStringMap = redis.hgetAll(PRODUCT_INFO_REDIS_KEY + k2Member.getRetain1());
            String productStrInfo = redis.get(PRODUCT_INFO_REDIS_KEY + k2Member.getRetain1() + "_DTO_VALUE");
            // �ж�redis����Ʒ��Ϣ�Ƿ�Ϊ��
            if (!CollectionUtils.isEmpty(stringStringMap) && !StringUtils.isEmpty(productStrInfo)) {
                // redis�������� ������ת����ģ��
                showProductIndexDto = JsonUtils.jsonToPojo(productStrInfo, ShowProductIndexDto.class);
                showProductIndexDto.setTotalSize(stringStringMap.size());
                // ������Ʒ��Ϣ
                List<ProductInfoToRedisDataDto> dtos = new ArrayList<>();
                // ��ȡMap�����ֵ
                for (Map.Entry<String, String> productInfo : stringStringMap.entrySet()) {
                    dtos.add(JsonUtils.jsonToPojo(productInfo.getValue(), ProductInfoToRedisDataDto.class));
                }
                // ����
                ProductInfoSort.speedinessSortByState(dtos);
                showProductIndexDto.setProductInfoToRedisDataDtos(dtos);
            } else {
                showProductIndexDto = new ShowProductIndexDto();
                // ��ѯ��������Ʒ����
                Integer maxSize = productManageMapper.getProductCountByStoreId(Integer.parseInt(k2Member.getRetain1()), null, null);
                showProductIndexDto.setTotalSize(maxSize);
                // redis��û�����ݴ������в�ѯ���� �����浽Redis����ȥ
                List<ProductInfoToRedisDataDto> productByStoreId = productManageMapper.getProductByStoreId
                        (
                                Integer.parseInt(k2Member.getRetain1()),
                                Integer.parseInt(dto.getState()) == 0 ? null : Integer.parseInt(dto.getState()),
                                0,
                                PRODUCT_GOTO_REDIS_MAX_SIZE,
                                null,
                                StringUtils.isEmpty(dto.getProductName()) ? null : dto.getProductName(), null, UUID.randomUUID().toString()
                        );
                productByStoreId.forEach((n) -> {
                    n.setCategoryName(n.getCategoryName() + " / " + n.getTwoCateName());
                    // ��redisд��Map���͵����ݽṹ
                    try {
                        redis.hset(PRODUCT_INFO_REDIS_KEY + k2Member.getRetain1(), n.getProductNumber(), JsonUtils.objectToJson(n));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });
                // ��״̬��������
                ProductInfoSort.speedinessSortByState(productByStoreId);
                showProductIndexDto.setProductInfoToRedisDataDtos(productByStoreId);

                // ����redis
                redis.set(PRODUCT_INFO_REDIS_KEY + k2Member.getRetain1() + "_DTO_VALUE", JsonUtils.objectToJson(showProductIndexDto));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (redis != null) redis.close();
            reentrantLock.unlock();
        }
        showProductIndexDto.setTotalPage((showProductIndexDto.getTotalSize() + (dto.getCurrentSize() - 1)) / dto.getCurrentSize());
        return new SystemResult(showProductIndexDto);
    }


    // ��ȡ�����������Ʒ��Ϣ����
    public SystemResult getCurrentRequestProductInfos(K2Member k2Member, ProductIndexDto dto,
                                                      List<ProductInfoToRedisDataDto> productDatas) {

        // �жϱ��β�ѯ�������Ƿ��Ѿ�������Ʒ������
        if (dto.getCurrentPage() > dto.getTotlaPage()) {
            dto.setCurrentPage(dto.getTotlaPage());
        }

        // ��ȡ���ε���������
        int index = (dto.getCurrentPage() - 1) * dto.getCurrentSize() == -1 ? 0 : (dto.getCurrentPage() - 1) * dto.getCurrentSize();
        // ��ȡ��������
        int endIndex = index + dto.getCurrentSize();

        // �����Ƿ�ȥ���ݿ��ѯ���ݵ�Flag
        boolean getMysqlFlag = false;
        // �жϽ��������Ƿ���ڴ���redis�е�����
        if (endIndex > PRODUCT_GOTO_REDIS_MAX_SIZE) {
            // ˵��������Ҫȥ���ݿ��в�ѯ��Ϣ
            getMysqlFlag = true;
        } else if (!StringUtils.isEmpty(dto.getProductName())) { // �ж��Ƿ�Ҫ��ѯ���� ��Ҫ��ѯ���ƾ�Ҫȥ���ݿ����
            getMysqlFlag = true;
            dto.setProductName("%" + dto.getProductName() + "%");
        } else if (!"0".equals(dto.getState())) { // �ж��Ƿ��ѯ������Ϳ�治��  �����Ҫ��ȥ��ѯ���ݿ�
            getMysqlFlag = true;
        }

        // �������ݵļ���
        List<ProductInfoToRedisDataDto> currentProductInfos = new ArrayList<>();
        if (getMysqlFlag) {
            // ȥ���ݿ��ѯ����
            currentProductInfos = productManageMapper.getProductByStoreId(Integer.parseInt(k2Member.getRetain1()),
                    Integer.parseInt(dto.getState()) == 0 ? null : Integer.parseInt(dto.getState()),
                    index, dto.getCurrentSize(), null,
                    StringUtils.isEmpty(dto.getProductName()) ? null : dto.getProductName(), null, UUID.randomUUID().toString()
            );
            currentProductInfos.forEach((n) -> n.setCategoryName(n.getCategoryName() + " / " + n.getTwoCateName()));
            // ��ѯ������
            Integer productCountByStoreId = productManageMapper.getProductCountByStoreId(Integer.parseInt(k2Member.getRetain1()),
                    StringUtils.isEmpty(dto.getProductName()) ? null : dto.getProductName(),
                    Integer.parseInt(dto.getState()) == 0 ? null : Integer.parseInt(dto.getState()));
            dto.setTotalSize(productCountByStoreId);
            dto.setTotlaPage((currentProductInfos.size() + (dto.getCurrentSize() + 1)) / dto.getCurrentSize());
        } else {
            // ��redis��ȡ������
            // �жϱ�����Ҫ�������Ƿ���ȫ��
            if (productDatas.size() < endIndex) {
                // ���Ӹü��ϵ�inde����������������ȫ������
                for (int i = index; i < productDatas.size(); i++) {
                    currentProductInfos.add(productDatas.get(i));
                }
            } else {
                // ������ʼ�����ͽ���������ȡ����
                for (int i = index; i < endIndex; i++) {
                    currentProductInfos.add(productDatas.get(i));
                }
            }
        }
        return new SystemResult(currentProductInfos);
    }
}
