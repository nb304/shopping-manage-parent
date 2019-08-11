package com.king2.product.server.service.impl;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.JsonUtils;
import com.king2.product.server.dto.ProductIndexDto;
import com.king2.product.server.dto.ShowProductIndexDto;
import com.king2.product.server.mapper.ProductManageMapper;
import com.king2.product.server.service.ProductIndexManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPool;

import java.util.List;


/*=======================================================
	说明:    商品首页管理Service实现类

	作者		时间					注释
  	俞烨		2019.08.11   			创建
=======================================================*/
@Service
public class ProductIndexManageServiceImpl implements ProductIndexManageService {

    // 注入商品在redis中的key
    @Value("${PRODUCT_INFO_REDIS_KEY}")
    private String PRODUCT_INFO_REDIS_KEY;

    // 注入redis连接池
    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    // 注入商品Mapper
    @Autowired
    private ProductManageMapper productManageMapper;

    /**
     * -----------------------------------------------------
     * 功能:  显示商品的首页
     * <p>
     * 参数:
     * K2Member         K2Member        操作的用户信息
     * dto              ProductIndexDto 分页数据
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult index(K2Member k2Member, ProductIndexDto dto) {


        try {
            // 获取redis模板
            ValueOperations<Object, Object> redis = redisTemplate.opsForValue();
            // 查询Redis中是否存在数据
            String productStrInfo = (String) redis.get(PRODUCT_INFO_REDIS_KEY + k2Member.getRetain1());
            // 判断redis中商品信息是否为空
            if (!StringUtils.isEmpty(productStrInfo)) {
                // redis中有数据 将数据转换成模板
                List lists = JsonUtils.jsonToList(productStrInfo, List.class);
            } else {
                // redis中没有数据从数据中查询数据 并保存到Redis当中去
                productManageMapper.getProductByStoreId(Integer.parseInt(k2Member.getRetain1()), 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }
}
