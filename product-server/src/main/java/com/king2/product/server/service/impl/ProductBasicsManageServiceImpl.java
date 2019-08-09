package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2ProductMapper;
import com.king2.commons.mapper.K2ProductSketchMapper;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2ProductSkuPriceandkc;
import com.king2.commons.pojo.K2ProductSkuValue;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.ProductBasicsAppoint;
import com.king2.product.server.appoint.ProductSkuAppoint;
import com.king2.product.server.appoint.ProductSkuValueKcAppoint;
import com.king2.product.server.mapper.ProductSkuMapper;
import com.king2.product.server.service.ProductBasicsManageService;
import com.king2.product.server.pojo.ProductSkuPojo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisPool;

import java.util.List;

/*=======================================================
	说明:    商品基础管理Service实现类

	作者		时间					注释
  	俞烨		2019.08.06   			创建
=======================================================*/
@Service
public class ProductBasicsManageServiceImpl implements ProductBasicsManageService {

    // 注入Jedis连接池
    @Autowired
    private JedisPool jedisPool;

    // 商品编号存在redis中的key
    @Value("${PRODUCT_NUMBER_REDIS_KEY}")
    private String PRODUCT_NUMBER_REDIS_KEY;

    // 注入商品Mapper
    @Autowired
    private K2ProductMapper k2ProductMapper;

    // 注入商品sku-key的mapper
    @Autowired
    private ProductSkuMapper productSkuMapper;

    // 注入商品简述Mapper
    @Autowired
    private K2ProductSketchMapper k2ProductSketchMapper;

    // 注入远程调用模板对象
    @Autowired
    private RestTemplate restTemplate;

    // 注入缓存服务器地址
    @Value("${CACHE_SERVER_URL}")
    private String CACHE_SERVER_URL;


    /**
     * -----------------------------------------------------
     * 功能:  添加商品的SKU
     * <p>
     * 参数:
     * skuJson          String          SKU的JSON数据
     * state            String          本次是否还需要继续添加商品信息  1需要  2不需要
     * productInfo      String          商品的JSON数据
     * k2Member         K2Member        操作的用户信息
     * <p>
     * 返回: UserManageUtil              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemResult addProductSku(String skuJson, String productInfo, String state, K2Member k2Member) throws Exception {

        /*
        添加商品信息
        这里明明是添加商品的SKU为什么会有添加商品信息的方法存在呢？
            因为商品的SKU开销很大 我们需要将数据存放到数据库当中去，存放的时候需要指定商品信息
            所以我们根据传入过来的state 判断本次是否需要添加商品信息
         */
        SystemResult addProductResult = ProductBasicsAppoint.addProduct
                (jedisPool, productInfo, PRODUCT_NUMBER_REDIS_KEY, k2ProductMapper, k2Member, state, k2ProductSketchMapper, restTemplate, CACHE_SERVER_URL);
        if (addProductResult.getStatus() != 200) return addProductResult;
        // 获取商品的数据
        K2ProductWithBLOBs k2ProductWithBLOBs = (K2ProductWithBLOBs) addProductResult.getData();

        // 调用校验类 查看SkuJson数据是否正常
        SystemResult skuResult = ProductBasicsAppoint.checkSkuJsonGotoLists(skuJson);
        if (skuResult.getStatus() != 200) {
            throw new RuntimeException("校验商品SKU-key时，出错,错误信息:" + skuResult.getMsg());
        }
        // 获取转换过来的Json数据
        List<ProductSkuPojo> skuPojos = (List<ProductSkuPojo>) skuResult.getData();
        // 添加商品sku-key的信息
        SystemResult addSku_KeyResult = ProductSkuAppoint.addProductSkuKeyInfos(skuPojos, k2Member, k2ProductWithBLOBs, productSkuMapper);
        if (addSku_KeyResult.getStatus() != 200) {
            throw new RuntimeException("添加商品SKU-key时，出错");
        }

        // 添加SKU-key成功 现在添加SKU-Value
        List<K2ProductSkuValue> k2ProductSkuValues = (List<K2ProductSkuValue>) addSku_KeyResult.getData();
        if (!CollectionUtils.isEmpty(k2ProductSkuValues)) {
            productSkuMapper.batchInsertSkuValue(k2ProductSkuValues);
            // 添加成功 获取该sku-value的库存和价格信息
            SystemResult productSkuValueKcDatas = ProductSkuValueKcAppoint.getProductSkuValueKcDatas(k2ProductSkuValues, k2ProductWithBLOBs);
            // 判断是否获取库存价格的ids成功
            if (productSkuValueKcDatas.getStatus() != 200) return productSkuValueKcDatas;
            List<K2ProductSkuPriceandkc> kcs = (List<K2ProductSkuPriceandkc>) productSkuValueKcDatas.getData();
            // 批量插入SKU-Value的库存和价格
            productSkuMapper.batchInsertSkuValueKc(kcs);
        }

        return new SystemResult(200, "添加商品的SKU成功，并保存了商品信息", null);
    }
}
