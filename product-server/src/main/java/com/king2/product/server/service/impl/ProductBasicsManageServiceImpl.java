package com.king2.product.server.service.impl;

import com.king2.commons.mapper.*;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.*;
import com.king2.product.server.dto.ShowProductAddPageDto;
import com.king2.product.server.enmu.ProductEnum;
import com.king2.product.server.locks.ProductQueueLockFactory;
import com.king2.product.server.mapper.ProductSkuMapper;
import com.king2.product.server.mapper.ProductSpuMapper;
import com.king2.product.server.queue.ProductSuccessQueue;
import com.king2.product.server.service.ProductBasicsManageService;
import com.king2.product.server.pojo.ProductSkuPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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

    // 注入远程服务的sku-keyMapper
    @Autowired
    private K2ProductSkuKeyMapper k2ProductSkuKeyMapper;

    // 注入商品简述Mapper
    @Autowired
    private K2ProductSketchMapper k2ProductSketchMapper;

    // 注入远程调用模板对象
    @Autowired
    private RestTemplate restTemplate;

    // 注入缓存服务器地址
    @Value("${CACHE_SERVER_URL}")
    private String CACHE_SERVER_URL;

    // 注入商品类目委派类
    @Autowired
    private ProductCategoryAppoint productCategoryAppoint;

    // 注入商品品牌
    @Autowired
    private K2ProductBrandMapper k2ProductBrandMapper;

    // 注入商品类目表
    @Autowired
    private K2ProductCategoryMapper k2ProductCategoryMapper;
    // 注入商品SPUMapper
    @Autowired
    private ProductSpuMapper productSpuMapper;

    // 注入商品无图片的地址
    @Value("${PRODUCT_IMAGE_NOT_DEFINITION}")
    private String PRODUCT_IMAGE_NOT_DEFINITION;

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
        这里明明是添加商品的SKU为
            因为商品的SKU开销很大 我们需要将数什么会有添加商品信息的方法存在呢？据存放到数据库当中去，存放的时候需要指定商品信息
            所以我们根据传入过来的state 判断本次是否需要添加商品信息
         */
        SystemResult addProductResult = ProductBasicsAppoint.addProduct
                (jedisPool, productInfo, PRODUCT_NUMBER_REDIS_KEY, k2ProductMapper, k2Member, state, k2ProductSketchMapper, restTemplate, CACHE_SERVER_URL, PRODUCT_IMAGE_NOT_DEFINITION);
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
        SystemResult addSku_KeyResult = ProductSkuAppoint.addProductSkuKeyInfos(skuPojos, k2Member, k2ProductWithBLOBs, productSkuMapper, k2ProductSkuKeyMapper);
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

        // 添加商品成功 往队列发送信息同步solr

        // 获取锁
        ProductQueueLockFactory instance = ProductQueueLockFactory.getInstance();
        ReentrantLock reentrantLock = instance.getLockMaps().get(instance.DEFAULT_PRODUCT_INFO_KEY).getLock();
        Condition condition = instance.getLockMaps().get(instance.DEFAULT_PRODUCT_INFO_KEY).getCondition();
        // 加锁
        reentrantLock.lock();
        try {
            // 获取队列数据
            ProductSuccessQueue successQueue = ProductSuccessQueue.getInstance();
            successQueue.getProdudctInfoQueue().add(k2ProductWithBLOBs);
            // 唤醒所有线程
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

        return new SystemResult(200, "添加商品的SKU成功，并保存了商品信息", k2ProductWithBLOBs);
    }

    /**
     * -----------------------------------------------------
     * 功能:  添加商品页面所需要的信息
     * <p>
     * 参数:
     * K2Member         K2Member        操作的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult addProductPageInfo(K2Member k2Member) throws Exception {

        // 商品类目的信息
        SystemResult productCategoryInfo = productCategoryAppoint.getProductCategoryInfo();
        if (productCategoryInfo.getStatus() != 200) return productCategoryInfo;
        // 取出数据
        ShowProductAddPageDto showProductAddPageDto = (ShowProductAddPageDto) productCategoryInfo.getData();

        // 查询商品品牌信息
        K2ProductBrandExample brandExample = new K2ProductBrandExample();
        brandExample.createCriteria().andBrandStoreIdEqualTo(Integer.parseInt(k2Member.getRetain1()))
                .andBrandStateEqualTo(ProductEnum.PRODUCT_BRAND_TYPE1);
        List<K2ProductBrand> k2ProductBrands = k2ProductBrandMapper.selectByExample(brandExample);
        showProductAddPageDto.setProductBrands(k2ProductBrands);

        return new SystemResult(showProductAddPageDto);
    }

    /**
     * -----------------------------------------------------
     * 功能:  通过类目id获取商品SKU模板信息
     * <p>
     * 参数:
     * cId         Integer          类目id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult getSkuInfoByCId(Integer cId) {

        // 查询该商品类目是否存在
        K2ProductCategory k2ProductCategory = k2ProductCategoryMapper.selectByPrimaryKey(cId);
        if (k2ProductCategory == null) {
            return new SystemResult(100, "你选中的类目不存在,请刷新页面重试", null);
        } else if (k2ProductCategory.getCategoryIsParent() == 1) {
            return new SystemResult(100, "请将类目精确到二级类目", null);
        }

        // 查找属于该商品类目的SKU信息
        List<K2ProductSkuKey> skuInfoByCid = productSkuMapper.getSkuInfoByCid(cId);
        // 创建前端需要的模板数据
        List<ProductSkuPojo> productSkuPojos = new ArrayList<>();
        for (K2ProductSkuKey productSkuKey : skuInfoByCid) {
            ProductSkuPojo productSkuPojo = new ProductSkuPojo();
            productSkuPojo.setSkuValue("");
            productSkuPojo.setProductSkuKeyName(productSkuKey.getProductSkuKeyName());
            productSkuPojo.setSkuKeyOrder(productSkuKey.getSkuKeyOrder() + "");
            productSkuPojo.setProductSkuKeyId(productSkuKey.getProductSkuKeyId() + "");
            productSkuPojo.setIsSystemCreate(productSkuKey.getIsSystemCreate());
            productSkuPojos.add(productSkuPojo);
        }
        return new SystemResult(productSkuPojos);
    }

    /**
     * -----------------------------------------------------
     * 功能:  添加商品的SPU信息
     * <p>
     * 参数:
     * productSpuJson         String            商品的SPU信息
     * productId              Integer           商品的id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult addProductSpu(String productSpuJson, Integer productId, K2Member k2Member) {

        // 校验商品的SPU是否正确
        SystemResult result = ProductSpuAppoint.checkProductSpuJsonInfo(productSpuJson, productId, k2Member);
        if (result.getStatus() != 200) return result;

        // 校验数据成功,添加spu
        productSpuMapper.batchInsertProductSpu((List<K2ProductSpu>) result.getData());
        return result;
    }
}
