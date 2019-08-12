package com.king2.product.server.service.impl;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.JsonUtils;
import com.king2.product.server.appoint.ProductIndexAppoint;
import com.king2.product.server.dto.ProductIndexDto;
import com.king2.product.server.dto.ProductInfoToRedisDataDto;
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

    /*// 注入商品在redis中的key
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

    // 注入每个商家在redis中存入的商品最大值
    @Value("${PRODUCT_GOTO_REDIS_MAX_SIZE}")
    private Integer PRODUCT_GOTO_REDIS_MAX_SIZE;*/

    // 注入商品首页管理委托类
    @Autowired
    private ProductIndexAppoint productIndexAppoint;

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

        // 根据条件获取商品的信息
        SystemResult productInfoByQuery = productIndexAppoint.getProductInfoByQuery(k2Member, dto);

        // 封装返回条件
        ShowProductIndexDto data = (ShowProductIndexDto) productInfoByQuery.getData();
        dto.setTotalSize(data.getTotalSize());
        dto.setTotlaPage(data.getTotalPage());

        // 获取指定的商品数据
        SystemResult currentRequestProductInfos = productIndexAppoint.getCurrentRequestProductInfos(k2Member, dto, data.getProductInfoToRedisDataDtos());
        dto.setProductDatas((List) currentRequestProductInfos.getData());
        return new SystemResult(dto);
    }
}
