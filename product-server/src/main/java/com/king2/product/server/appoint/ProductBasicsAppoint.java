package com.king2.product.server.appoint;

import com.king2.commons.getnumber.ShoppingNumberManage;
import com.king2.commons.getnumber.ShoppingNumberPojo;
import com.king2.commons.mapper.K2ProductMapper;
import com.king2.commons.mapper.K2ProductSketchMapper;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.JsonUtils;
import com.king2.commons.utils.RedisUtil;
import com.king2.product.server.cache.SystemCacheManage;
import com.king2.product.server.dto.ProductInfoDto;
import com.king2.product.server.enmu.ProductStateEnum;
import com.king2.product.server.pojo.ProductSkuPojo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Date;
import java.util.List;

/*=======================================================
	说明:    商品基础管理委派类

	作者		时间					注释
  	俞烨		2019.08.06   			创建
=======================================================*/
@Component
public class ProductBasicsAppoint {

    /**
     * -----------------------------------------------------
     * 功能:  校验传输过来的json数据是否可以转换成对应的class对象
     * <p>
     * 参数:
     * jsonInfo         String          JSON数据
     * clazz            Class           需要转换的类型
     * <p>
     * 返回: UserManageUtil              返回调用者的数据
     * -----------------------------------------------------
     */
    private static SystemResult checkJsonWhetherGotoClass(String jsonInfo, Class clazz, String errorMsg, String image) {

        // 判断Json数据是否为空
        if (StringUtils.isEmpty(jsonInfo) || clazz == null) {
            return new SystemResult(100, "转换失败：参数有空值", null);
        }

        // 转换数据
        try {
            ProductInfoDto o = (ProductInfoDto) JsonUtils.jsonToPojo(jsonInfo, clazz);
            // 转换成功 将数据变成商品对象
            SystemResult productByProductJsonInfo = getProductByProductJsonInfo(o, image);
//            if(o == null)   return new SystemResult(100, "转换失败：参数无效", null);
            return productByProductJsonInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, errorMsg + "转换失败：类型与预期的不匹配", null);
        }
    }

    /**
     * 获取到商品对象
     *
     * @param productInfoDto
     * @param image
     * @return
     */
    private static SystemResult getProductByProductJsonInfo(ProductInfoDto productInfoDto, String image) {

        K2ProductWithBLOBs productWithBLOBs = new K2ProductWithBLOBs();
        productWithBLOBs.setProductName(productInfoDto.getProductName());
        productWithBLOBs.setProductOneCategoryId(productInfoDto.getProductOneCategoryId());
        productWithBLOBs.setProductTwoCategoryId(productInfoDto.getProductTwoCategoryId());
        productWithBLOBs.setProductBrandId(productInfoDto.getProductBrandId());
        productWithBLOBs.setProductBazaarPrice(productInfoDto.getProductBazaarPrice());
        productWithBLOBs.setProductSystemPrice(productInfoDto.getProductSystemPrice());
        productWithBLOBs.setProductPoints(productInfoDto.getProductPoints());
        productWithBLOBs.setProductOrderRule(productInfoDto.getProductOrderRule());
        productWithBLOBs.setProductIfSupport(productInfoDto.getProductIfSupport());
        productWithBLOBs.setProductSupportDay(productInfoDto.getProductSupportDay());
        productWithBLOBs.setProductImage(image);
        productWithBLOBs.setProductImageDescribe(image);
        productWithBLOBs.setProductSketchContentl(productInfoDto.getProductSketchContent());
        productWithBLOBs.setProductUnit(productInfoDto.getProductUnit());
        return new SystemResult(productWithBLOBs);
    }


    /**
     * -----------------------------------------------------
     * 功能:  校验传输过来的SKUjson数据是否可以转换成对应的集合对象
     * <p>
     * 参数:
     * jsonInfo         String          JSON数据
     * clazz            Class           需要转换的类型
     * <p>
     * 返回: UserManageUtil              返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult checkSkuJsonGotoLists(String jsonInfo) {

        // 判断Json数据是否为空
        if (StringUtils.isEmpty(jsonInfo)) {
            return new SystemResult(100, "转换失败：参数有空值", null);
        }

        // 转换数据
        try {
            List<ProductSkuPojo> productSkuPojos = JsonUtils.jsonToList(jsonInfo, ProductSkuPojo.class);
//            if(o == null)   return new SystemResult(100, "转换失败：参数无效", null);
            return new SystemResult(productSkuPojos);
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, "转换失败：类型与预期的不匹配", null);
        }
    }

    // 注入JedisPool连接池
    @Autowired
    private JedisPool jedisPool;

    /**
     * -----------------------------------------------------
     * 功能:  根据传过去的Json数据返回商品的信息
     * <p>
     * 参数:
     * productJson          String          商品的JSON数据
     * jedis                Jedis           jedis模板
     * scrpit               String          解锁的lua脚本
     * redisKey             String          编号的key
     * k2ProductMapper  K2ProductMapper     商品Mapper实例
     * <p>
     * 返回: UserManageUtil              返回调用者的数据
     * -----------------------------------------------------
     */
    private static SystemResult getProductInfoByPJson(K2ProductWithBLOBs k2Product, JedisPool jedisPool, String scrpit, String redisKey,
                                                      K2ProductMapper k2ProductMapper, K2Member k2Member, RestTemplate restTemplate, String servletUrl) throws Exception {

        // 获取商品的唯一编号
        SystemResult onlyProductNumber = getOnlyProductNumber(jedisPool, redisKey, k2ProductMapper, restTemplate, servletUrl);
        if (onlyProductNumber.getStatus() != 200) return onlyProductNumber;
        // 商品的编号
        String number = onlyProductNumber.getData() + "";
        // 将商品编号存入对象
        k2Product.setProductNumber(number);
        // 校验商品信息是否正确
        SystemResult systemResult = validatedProductInfo(k2Product, k2Member);
        if (systemResult.getStatus() != 200) return systemResult;
        // 返回前的处理
        getProductInfoByPJsonLast(k2Product);
        return new SystemResult(k2Product);
    }


    /**
     * -----------------------------------------------------
     * 功能:  校验商品的信息是否符合条件
     * <p>
     * 参数:
     * k2Product         K2Product          商品的对象
     * k2Member          K2Member           操作的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult validatedProductInfo(K2ProductWithBLOBs k2Product, K2Member k2Member) {

        // 校验商品名称
        if (StringUtils.isEmpty(k2Product.getProductName()) || k2Product.getProductName().length() > 200) {
            return new SystemResult(100, "商品名称填写错误,名称长度为1-200个字", null);
        }
        // 校验商品品牌
        if (k2Product.getProductBrandId() == null || k2Product.getProductBrandId() == 0 ||
                k2Product.getProductBrandId().toString().length() > 11) {
            return new SystemResult(100, "商品品牌选择错误,请刷新页面重试", null);
        }
        // 校验类目是否正确
        if (k2Product.getProductOneCategoryId() == null || k2Product.getProductOneCategoryId() == 0 ||
                k2Product.getProductOneCategoryId().toString().length() > 11 ||
                k2Product.getProductTwoCategoryId() == null || k2Product.getProductTwoCategoryId() == 0 ||
                k2Product.getProductTwoCategoryId().toString().length() > 11) {

            return new SystemResult(100, "请选择正确的二级类目", null);
        }

        // 校验商品市场价格
        if (k2Product.getProductBazaarPrice() == null || k2Product.getProductBazaarPrice().floatValue() > 9999999.99 ||
                k2Product.getProductBazaarPrice().floatValue() < 1) {
            return new SystemResult(100, "商品市场价格错误,金额范围在1~9999999.99之间", null);
        }

        // 校验系统价格
        if (k2Product.getProductSystemPrice() == null || k2Product.getProductSystemPrice().floatValue() > 9999999.99 ||
                k2Product.getProductSystemPrice().floatValue() < 1) {
            return new SystemResult(100, "商品系统价格错误,金额范围在1~9999999.99之间", null);
        }

        // 校验商品简述
        if (StringUtils.isEmpty(k2Product.getProductSketchContentl()) || k2Product.getProductSketchContentl().length() > 1000) {
            return new SystemResult(100, "商品简述错误,简述范围在1~1000字符之间", null);
        }

        // 校验商品排序规则
        if (k2Product.getProductOrderRule() == null || k2Product.getProductOrderRule().toString().length() > 11) {
            return new SystemResult(100, "商品排序不可为空,范围在1~11位数之间", null);
        }

        // 校验商品单位信息
        if (StringUtils.isEmpty(k2Product.getProductUnit()) || k2Product.getProductUnit().length() > 10) {
            return new SystemResult(100, "请填写正确的商品单位", null);
        }

        // 校验商品是否支持无理由退款
        if (k2Product.getProductIfSupport() == null || (k2Product.getProductIfSupport() != 1 && k2Product.getProductIfSupport() != 2)) {
            return new SystemResult(100, "请填写设置正确的无理由退款的需求", null);
        }

        // 校验无理由退款的天数
        if (k2Product.getProductIfSupport() == null || k2Product.getProductIfSupport() != 1) {
            k2Product.setProductSupportDay(0);
        } else if (k2Product.getProductSupportDay().toString().length() > 999) {
            return new SystemResult(100, "最高支持999天的无理由退款", null);
        }

        // 商品图片
        if (StringUtils.isEmpty(k2Product.getProductImage())) {
            return new SystemResult(100, "请上传商品的图片", null);
        }
        String[] imageSplit = k2Product.getProductImage().split(",");
        if (imageSplit.length > 6 || imageSplit.length < 1) {
            return new SystemResult(100, "商品的图片为1-6张", null);
        }

        // 校验商品卖点
        if (!StringUtils.isEmpty(k2Product.getProductPoints()) && k2Product.getProductPoints().length() > 700) {
            return new SystemResult(100, "商品卖点过多，请减少", null);
        }

        // 校验商品详情的图片
        if (StringUtils.isEmpty(k2Product.getProductImageDescribe())) {
            return new SystemResult(100, "请上传商品详情的图片", null);
        }
        String[] iamgeDe = k2Product.getProductImageDescribe().split(",");
        if (iamgeDe.length > 30 || iamgeDe.length < 1) {
            return new SystemResult(100, "商品详情的图片为1-30张", null);
        }

        // 补全数据
        // ---1上架 2下架 3删除 4编辑中 5 审核中
        k2Product.setProductState(ProductStateEnum.EDIT.getValue());
        k2Product.setProductCreateTime(new Date());
        k2Product.setProductCreateUserid(k2Member.getMemberId());
        k2Product.setProductCreateUsername(k2Member.getMemberAccount());
        k2Product.setProductUpdateTime(new Date());
        k2Product.setProductUpdateUserid(k2Member.getMemberId());
        k2Product.setProductUpdateUsername(k2Member.getMemberAccount());
        k2Product.setProductStoreId(Integer.parseInt(k2Member.getRetain1()));
        return new SystemResult(k2Product);
    }

    /**
     * -----------------------------------------------------
     * 功能:  获取一个唯一的商品编号
     * <p>
     * 参数:
     * jedis         Jedis          jedis模板
     * scrpit        String         解锁的lua脚本
     * redisKey      String         编号的key
     * k2ProductMapper  K2ProductMapper     商品Mapper实例
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    private static SystemResult getOnlyProductNumber(JedisPool jedisPool, String redisKey, K2ProductMapper k2ProductMapper, RestTemplate restTemplate, String servletUrl) throws Exception {
        while (true) {
            // 首先获取一个商品编号SystemCacheManage.UNLOCK_REDIS_LUA
            ShoppingNumberPojo sp = new ShoppingNumberPojo(jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA, redisKey, "SP", 11, restTemplate, servletUrl);
            ShoppingNumberManage numberManage = new ShoppingNumberManage(sp, sp.NUMBER_TYPE_PRODUCT);
            SystemResult numberByRedisKey = numberManage.getNumberByRedisKey(redisKey, 10);
            if (numberByRedisKey.getStatus() != 200) return numberByRedisKey;
            // 获取编号
            String number = numberByRedisKey.getData().toString();
            if (!StringUtils.isEmpty(number) && number.length() != 11) {
                number = number.substring(0, 11);
            }
            // 判断商品编号是否唯一
            K2ProductExample example = new K2ProductExample();
            example.createCriteria().andProductNumberEqualTo(number);
            List<K2Product> k2Products = k2ProductMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(k2Products)) {
                return new SystemResult(number);
            }
        }
    }

    /**
     * 返回前的处理
     *
     * @param k2Product
     */
    public static void getProductInfoByPJsonLast(K2Product k2Product) {
    }


    /**
     * -----------------------------------------------------
     * 功能:  添加商品的基础信息
     * <p>
     * 参数:
     * jedis                            Jedis               jedis模板
     * productInfo                      String              商品的Json数据
     * PRODUCT_NUMBER_REDIS_KEY         String              编号的key
     * k2ProductMapper                  K2ProductMapper     商品Mapper实例
     * k2Member                         K2Member            人员信息
     * state                            String              是否还需要添加  1需要 2不需要
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult addProduct(JedisPool jedisPool, String productInfo, String PRODUCT_NUMBER_REDIS_KEY,
                                          K2ProductMapper k2ProductMapper, K2Member k2Member, String state, K2ProductSketchMapper k2ProductSketchMapper,
                                          RestTemplate restTemplate, String servletUrl, String image) throws Exception {

        // 商品的数据
        K2ProductWithBLOBs k2Product = null;
        // 调用校验类 查询商品的JSON数据是否正常
        SystemResult checkProductResult = ProductBasicsAppoint.checkJsonWhetherGotoClass(productInfo, ProductInfoDto.class, "商品信息", image);
        if (checkProductResult.getStatus() != 200) return checkProductResult;
        k2Product = (K2ProductWithBLOBs) checkProductResult.getData();
        // 判断本次还是否需要添加商品数据
        if ("1".equals(state)) {
            // 交给委托类 返回一个商品对象
            SystemResult productResult = ProductBasicsAppoint.getProductInfoByPJson
                    (k2Product, jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA, PRODUCT_NUMBER_REDIS_KEY, k2ProductMapper, k2Member, restTemplate, servletUrl);
            if (productResult.getStatus() != 200) return productResult;
            // 取出商品信息
            k2Product = (K2ProductWithBLOBs) productResult.getData();
            // 添加商品的简述信息
            K2ProductSketch sketch = new K2ProductSketch();
            sketch.setProductSketchValue(k2Product.getProductSketchContentl());
            k2ProductSketchMapper.insert(sketch);
            // 添加商品信息
            k2Product.setProductSketchId(sketch.getProductSketchId());
            k2ProductMapper.insert(k2Product);
        }
        return new SystemResult(k2Product);
    }
}
