package com.king2.product.server.appoint;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.JsonUtils;
import com.king2.product.server.dto.ProductIndexDto;
import com.king2.product.server.dto.ProductInfoToRedisDataDto;
import com.king2.product.server.dto.ShowProductIndexDto;
import com.king2.product.server.locks.ProductQueueLockFactory;
import com.king2.product.server.locks.ProductQueueLockFactoryTypeEnum;
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
	说明:    商品首页管理委派类

	作者		时间					注释
  	俞烨		2019.08.12   			创建
=======================================================*/
@Component
public class ProductIndexAppoint {

    // 注入商品在redis中的key
    @Value("${PRODUCT_INFO_REDIS_KEY}")
    private String PRODUCT_INFO_REDIS_KEY;

    // 注入redis模板
    @Autowired
    private JedisPool jedisPool;

    // 注入商品Mapper
    @Autowired
    private ProductManageMapper productManageMapper;

    // 注入每个商家在redis中存入的商品最大值
    @Value("${PRODUCT_GOTO_REDIS_MAX_SIZE}")
    private Integer PRODUCT_GOTO_REDIS_MAX_SIZE;

    /**
     * -----------------------------------------------------
     * 功能: 获取商品存在于redis中的信息
     * <p>
     * 参数:
     * k2Member          K2Member         操作的用户信息
     * dto               ProductIndexDto  条件信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    public SystemResult getProductInfoByQuery(K2Member k2Member, ProductIndexDto dto) {

        // 商品信息
        ShowProductIndexDto showProductIndexDto = null;
        final Jedis redis = jedisPool.getResource();
        // 获取锁
        ProductQueueLockFactory instance = ProductQueueLockFactory.getInstance();
        ReentrantLock reentrantLock = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_CACHE_KEY.getValue()).getLock();
        Condition condition = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_CACHE_KEY.getValue()).getCondition();
        // 开启锁
        reentrantLock.lock();
        try {
            // 获取redis模板
            // 查询Redis中是否存在数据
            Map<String, String> stringStringMap = redis.hgetAll(PRODUCT_INFO_REDIS_KEY + k2Member.getRetain1());
            String productStrInfo = redis.get(PRODUCT_INFO_REDIS_KEY + k2Member.getRetain1() + "_DTO_VALUE");
            // 判断redis中商品信息是否为空
            if (!CollectionUtils.isEmpty(stringStringMap) && !StringUtils.isEmpty(productStrInfo)) {
                // redis中有数据 将数据转换成模板
                showProductIndexDto = JsonUtils.jsonToPojo(productStrInfo, ShowProductIndexDto.class);
                showProductIndexDto.setTotalSize(stringStringMap.size());
                // 创建商品信息
                List<ProductInfoToRedisDataDto> dtos = new ArrayList<>();
                // 获取Map里面的值
                for (Map.Entry<String, String> productInfo : stringStringMap.entrySet()) {
                    dtos.add(JsonUtils.jsonToPojo(productInfo.getValue(), ProductInfoToRedisDataDto.class));
                }
                // 排序
                ProductInfoSort.speedinessSortByState(dtos);
                showProductIndexDto.setProductInfoToRedisDataDtos(dtos);
            } else {
                showProductIndexDto = new ShowProductIndexDto();
                // 查询该所有商品条数
                Integer maxSize = productManageMapper.getProductCountByStoreId(Integer.parseInt(k2Member.getRetain1()), null, null);
                showProductIndexDto.setTotalSize(maxSize);
                // redis中没有数据从数据中查询数据 并保存到Redis当中去
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
                    // 往redis写入Map类型的数据结构
                    try {
                        redis.hset(PRODUCT_INFO_REDIS_KEY + k2Member.getRetain1(), n.getProductNumber(), JsonUtils.objectToJson(n));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });
                // 对状态进行排序
                ProductInfoSort.speedinessSortByState(productByStoreId);
                showProductIndexDto.setProductInfoToRedisDataDtos(productByStoreId);

                // 存入redis
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


    // 获取本次请求的商品信息集合
    public SystemResult getCurrentRequestProductInfos(K2Member k2Member, ProductIndexDto dto,
                                                      List<ProductInfoToRedisDataDto> productDatas) {

        // 判断本次查询的数据是否已经超出商品的数量
        if (dto.getCurrentPage() > dto.getTotlaPage()) {
            dto.setCurrentPage(dto.getTotlaPage());
        }

        // 获取本次的数据索引
        int index = (dto.getCurrentPage() - 1) * dto.getCurrentSize() == -1 ? 0 : (dto.getCurrentPage() - 1) * dto.getCurrentSize();
        // 获取结束索引
        int endIndex = index + dto.getCurrentSize();

        // 创建是否去数据库查询数据的Flag
        boolean getMysqlFlag = false;
        // 判断结束索引是否大于存在redis中的数量
        if (endIndex > PRODUCT_GOTO_REDIS_MAX_SIZE) {
            // 说明接下来要去数据库中查询信息
            getMysqlFlag = true;
        } else if (!StringUtils.isEmpty(dto.getProductName())) { // 判断是否要查询名称 需要查询名称就要去数据库查找
            getMysqlFlag = true;
            dto.setProductName("%" + dto.getProductName() + "%");
        } else if (!"0".equals(dto.getState())) { // 判断是否查询库存充足和库存不足  如果需要就去查询数据库
            getMysqlFlag = true;
        }

        // 创建数据的集合
        List<ProductInfoToRedisDataDto> currentProductInfos = new ArrayList<>();
        if (getMysqlFlag) {
            // 去数据库查询数据
            currentProductInfos = productManageMapper.getProductByStoreId(Integer.parseInt(k2Member.getRetain1()),
                    Integer.parseInt(dto.getState()) == 0 ? null : Integer.parseInt(dto.getState()),
                    index, dto.getCurrentSize(), null,
                    StringUtils.isEmpty(dto.getProductName()) ? null : dto.getProductName(), null, UUID.randomUUID().toString()
            );
            currentProductInfos.forEach((n) -> n.setCategoryName(n.getCategoryName() + " / " + n.getTwoCateName()));
            // 查询总条数
            Integer productCountByStoreId = productManageMapper.getProductCountByStoreId(Integer.parseInt(k2Member.getRetain1()),
                    StringUtils.isEmpty(dto.getProductName()) ? null : dto.getProductName(),
                    Integer.parseInt(dto.getState()) == 0 ? null : Integer.parseInt(dto.getState()));
            dto.setTotalSize(productCountByStoreId);
            dto.setTotlaPage((currentProductInfos.size() + (dto.getCurrentSize() + 1)) / dto.getCurrentSize());
        } else {
            // 从redis中取出数据
            // 判断本次需要的数据是否是全部
            if (productDatas.size() < endIndex) {
                // 将从该集合的inde索引到结束的数据全部返回
                for (int i = index; i < productDatas.size(); i++) {
                    currentProductInfos.add(productDatas.get(i));
                }
            } else {
                // 根据起始索引和结束索引获取数据
                for (int i = index; i < endIndex; i++) {
                    currentProductInfos.add(productDatas.get(i));
                }
            }
        }
        return new SystemResult(currentProductInfos);
    }
}
