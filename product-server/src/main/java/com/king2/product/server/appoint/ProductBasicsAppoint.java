package com.king2.product.server.appoint;

import com.king2.commons.getnumber.ShoppingNumberManage;
import com.king2.commons.getnumber.ShoppingNumberPojo;
import com.king2.commons.mapper.K2ProductMapper;
import com.king2.commons.mapper.K2ProductSketchMapper;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.JsonUtils;
import com.king2.product.server.cache.SystemCacheManage;
import com.king2.product.server.dto.ProductInfoDto;
import com.king2.product.server.locks.ProductQueueLockFactoryTypeEnum;
import com.king2.product.server.enmu.ProductStateEnum;
import com.king2.product.server.locks.ProductQueueLockFactory;
import com.king2.product.server.pojo.ProductSkuPojo;
import com.king2.product.server.queue.ProductSuccessQueue;
import com.king2.product.server.queue.SynchornizedProductQueue;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisPool;

import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*=======================================================
	???:    ????????????????

	????		???					???
  	????		2019.08.06   			????
=======================================================*/
@Component
public class ProductBasicsAppoint {

    /**
     * -----------------------------------------------------
     * ????:  ?§Ø???????????????????????????????????
     * ?????????????????????????????
     * <p>
     * ????:
     * productWithBLOBs         K2ProductWithBLOBs          ??????
     * k2MemberAndElseInfo      K2MemberAndElseInfo         ????????????
     * SYSTEM_ROLE_PROVE        String                      ?????????????
     * <p>
     * ????: UserManageUtil              ??????????????
     * -----------------------------------------------------
     */
    public static SystemResult checkProductIsUser(K2ProductWithBLOBs productWithBLOBs,
                                                  K2MemberAndElseInfo k2MemberAndElseInfo,
                                                  String SYSTEM_ROLE_PROVE) {

        // ??????????????????????????????
        // ?????????????????flag
        boolean isSystemAdminFlag = false;
        List<K2Role> k2Roles = k2MemberAndElseInfo.getK2Roles();
        for (int i = 0; i < k2Roles.size(); i++) {
            if (SYSTEM_ROLE_PROVE.equals(k2Roles.get(i).getRetain1())) {
                isSystemAdminFlag = true;
                break;
            }
        }

        // ?§Ø??????????????? ????????????????????????????????????
        if (!isSystemAdminFlag &&
                !productWithBLOBs.getProductStoreId().toString().equals(k2MemberAndElseInfo.getK2Member().getRetain1())) {
            // ?????? ?????????????????  ???????????§Ù???ip+??????
            return new SystemResult(100, "??????????????????????", null);
        }
        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * ????:  §µ?ø‰???????json???????????????????class????
     * <p>
     * ????:
     * jsonInfo         String          JSON????
     * clazz            Class           ????????????
     * <p>
     * ????: UserManageUtil              ??????????????
     * -----------------------------------------------------
     */
    private static SystemResult checkJsonWhetherGotoClass(String jsonInfo, Class clazz, String errorMsg, String image) {

        // ?§Ø?Json??????????
        if (StringUtils.isEmpty(jsonInfo) || clazz == null) {
            return new SystemResult(100, "????????????§á??", null);
        }

        // ???????
        try {
            ProductInfoDto o = (ProductInfoDto) JsonUtils.jsonToPojo(jsonInfo, clazz);
            // ?????? ???????????????
            SystemResult productByProductJsonInfo = getProductByProductJsonInfo(o, image);
//            if(o == null)   return new SystemResult(100, "?????????????§¹", null);
            return productByProductJsonInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, errorMsg + "?????????????????????", null);
        }
    }

    /**
     * ????????????
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
        productWithBLOBs.setProductSketchContent(productInfoDto.getProductSketchContent());
        productWithBLOBs.setProductUnit(productInfoDto.getProductUnit());
        return new SystemResult(productWithBLOBs);
    }


    /**
     * -----------------------------------------------------
     * ????:  §µ?ø‰???????SKUjson?????????????????????????
     * <p>
     * ????:
     * jsonInfo         String          JSON????
     * clazz            Class           ????????????
     * <p>
     * ????: UserManageUtil              ??????????????
     * -----------------------------------------------------
     */
    public static SystemResult checkSkuJsonGotoLists(String jsonInfo) {

        // ?§Ø?Json??????????
        if (StringUtils.isEmpty(jsonInfo)) {
            return new SystemResult(100, "????????????§á??", null);
        }

        // ???????
        try {
            List<ProductSkuPojo> productSkuPojos = JsonUtils.jsonToList(jsonInfo, ProductSkuPojo.class);
//            if(o == null)   return new SystemResult(100, "?????????????§¹", null);
            return new SystemResult(productSkuPojos);
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, "?????????????????????", null);
        }
    }

    // ???JedisPool?????
    @Autowired
    private JedisPool jedisPool;

    /**
     * -----------------------------------------------------
     * ????:  ??????????Json???????????????
     * <p>
     * ????:
     * productJson          String          ?????JSON????
     * jedis                Jedis           jedis???
     * scrpit               String          ??????lua???
     * redisKey             String          ????key
     * k2ProductMapper  K2ProductMapper     ???Mapper???
     * <p>
     * ????: UserManageUtil              ??????????????
     * -----------------------------------------------------
     */
    private static SystemResult getProductInfoByPJson(K2ProductWithBLOBs k2Product, JedisPool jedisPool, String scrpit, String redisKey,
                                                      K2ProductMapper k2ProductMapper, K2Member k2Member, RestTemplate restTemplate, String servletUrl) throws Exception {

        // ????????¦·????
        SystemResult onlyProductNumber = getOnlyProductNumber(jedisPool, redisKey, k2ProductMapper, restTemplate, servletUrl);
        if (onlyProductNumber.getStatus() != 200) return onlyProductNumber;
        // ???????
        String number = onlyProductNumber.getData() + "";
        // ??????????????
        k2Product.setProductNumber(number);
        // §µ??????????????
        SystemResult systemResult = validatedProductInfo(k2Product, k2Member);
        if (systemResult.getStatus() != 200) return systemResult;
        // ??????????
        getProductInfoByPJsonLast(k2Product);
        return new SystemResult(k2Product);
    }


    /**
     * -----------------------------------------------------
     * ????:  §µ????????????????????
     * <p>
     * ????:
     * k2Product         K2Product          ????????
     * k2Member          K2Member           ????????????
     * <p>
     * ????: SystemResult              ??????????????
     * -----------------------------------------------------
     */
    public static SystemResult validatedProductInfo(K2ProductWithBLOBs k2Product, K2Member k2Member) {

        // §µ?????????
        if (StringUtils.isEmpty(k2Product.getProductName()) || k2Product.getProductName().length() > 200) {
            return new SystemResult(100, "?????????§Õ????,????????1-200????", null);
        }
        // §µ????????
        if (k2Product.getProductBrandId() == null || k2Product.getProductBrandId() == 0 ||
                k2Product.getProductBrandId().toString().length() > 11) {
            return new SystemResult(100, "????????????,????????????", null);
        }
        // §µ???????????
        if (k2Product.getProductOneCategoryId() == null || k2Product.getProductOneCategoryId() == 0 ||
                k2Product.getProductOneCategoryId().toString().length() > 11 ||
                k2Product.getProductTwoCategoryId() == null || k2Product.getProductTwoCategoryId() == 0 ||
                k2Product.getProductTwoCategoryId().toString().length() > 11) {

            return new SystemResult(100, "????????????????", null);
        }

        // §µ??????§Ô????
        if (k2Product.getProductBazaarPrice() == null || k2Product.getProductBazaarPrice().floatValue() > 9999999.99 ||
                k2Product.getProductBazaarPrice().floatValue() < 1) {
            return new SystemResult(100, "????§Ô???????,???¦¶??1~9999999.99???", null);
        }

        // §µ???????
        if (k2Product.getProductSystemPrice() == null || k2Product.getProductSystemPrice().floatValue() > 9999999.99 ||
                k2Product.getProductSystemPrice().floatValue() < 1) {
            return new SystemResult(100, "???????????,???¦¶??1~9999999.99???", null);
        }

        // §µ?????????
        if (StringUtils.isEmpty(k2Product.getProductSketchContent()) || k2Product.getProductSketchContent().length() > 1000) {
            return new SystemResult(100, "???????????,??????¦¶??1~1000??????", null);
        }

        // §µ????????????
        if (k2Product.getProductOrderRule() == null || k2Product.getProductOrderRule().toString().length() > 11) {
            return new SystemResult(100, "???????????,??¦¶??1~11¦Ë?????", null);
        }

        // §µ???????¦Ë???
        if (StringUtils.isEmpty(k2Product.getProductUnit()) || k2Product.getProductUnit().length() > 10) {
            return new SystemResult(100, "????§Õ??????????¦Ë", null);
        }

        // §µ????????????????????
        if (k2Product.getProductIfSupport() == null || (k2Product.getProductIfSupport() != 1 && k2Product.getProductIfSupport() != 2)) {
            return new SystemResult(100, "????§Õ???????????????????????", null);
        }

        // §µ????????????????
        if (k2Product.getProductIfSupport() == null || k2Product.getProductIfSupport() != 1) {
            k2Product.setProductSupportDay(0);
        } else if (k2Product.getProductSupportDay() == null || k2Product.getProductSupportDay() > 999) {
            return new SystemResult(100, "??????999????????????", null);
        }

        // ?????
        if (StringUtils.isEmpty(k2Product.getProductImage())) {
            return new SystemResult(100, "????????????", null);
        }
        String[] imageSplit = k2Product.getProductImage().split(",");
        if (imageSplit.length > 6 || imageSplit.length < 1) {
            return new SystemResult(100, "????????1-6??", null);
        }

        // §µ?????????
        if (!StringUtils.isEmpty(k2Product.getProductPoints()) && k2Product.getProductPoints().length() > 700) {
            return new SystemResult(100, "???????????????", null);
        }

        // §µ????????????
        if (StringUtils.isEmpty(k2Product.getProductImageDescribe())) {
            return new SystemResult(100, "???????????????", null);
        }
        String[] iamgeDe = k2Product.getProductImageDescribe().split(",");
        if (iamgeDe.length > 30 || iamgeDe.length < 1) {
            return new SystemResult(100, "???????????1-30??", null);
        }

        // ???????
        // ---1??? 2??? 3??? 4???? 5 ?????
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
     * ????:  ??????¦·?????????
     * <p>
     * ????:
     * jedis         Jedis          jedis???
     * scrpit        String         ??????lua???
     * redisKey      String         ????key
     * k2ProductMapper  K2ProductMapper     ???Mapper???
     * <p>
     * ????: SystemResult              ??????????????
     * -----------------------------------------------------
     */
    private static SystemResult getOnlyProductNumber(JedisPool jedisPool, String redisKey, K2ProductMapper k2ProductMapper, RestTemplate restTemplate, String servletUrl) throws Exception {
        while (true) {
            // ???????????????SystemCacheManage.UNLOCK_REDIS_LUA
            ShoppingNumberPojo sp = new ShoppingNumberPojo(jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA, redisKey, "SP", 11, restTemplate, servletUrl);
            ShoppingNumberManage numberManage = new ShoppingNumberManage(sp, sp.NUMBER_TYPE_PRODUCT);
            SystemResult numberByRedisKey = numberManage.getNumberByRedisKey(redisKey, 10);
            if (numberByRedisKey.getStatus() != 200) return numberByRedisKey;
            // ??????
            String number = numberByRedisKey.getData().toString();
            if (!StringUtils.isEmpty(number) && number.length() != 11) {
                number = number.substring(0, 11);
            }
            // ?§Ø??????????¦·?
            K2ProductExample example = new K2ProductExample();
            example.createCriteria().andProductNumberEqualTo(number);
            List<K2Product> k2Products = k2ProductMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(k2Products)) {
                return new SystemResult(200, "ok", number);
            }
        }
    }

    /**
     * ??????????
     *
     * @param k2Product
     */
    public static void getProductInfoByPJsonLast(K2Product k2Product) {
    }


    /**
     * -----------------------------------------------------
     * ????:  ??????????????
     * <p>
     * ????:
     * jedis                            Jedis               jedis???
     * productInfo                      String              ?????Json????
     * PRODUCT_NUMBER_REDIS_KEY         String              ????key
     * k2ProductMapper                  K2ProductMapper     ???Mapper???
     * k2Member                         K2Member            ??????
     * state                            String              ?????????  1??? 2?????
     * <p>
     * ????: SystemResult              ??????????????
     * -----------------------------------------------------
     */
    public static SystemResult addProduct(JedisPool jedisPool, String productInfo, String PRODUCT_NUMBER_REDIS_KEY,
                                          K2ProductMapper k2ProductMapper, K2Member k2Member, String state, K2ProductSketchMapper k2ProductSketchMapper,
                                          RestTemplate restTemplate, String servletUrl, String image) throws Exception {

        // ?????????
        K2ProductWithBLOBs k2Product = null;
        // ????§µ???? ????????JSON???????????
        SystemResult checkProductResult = ProductBasicsAppoint.checkJsonWhetherGotoClass(productInfo, ProductInfoDto.class, "??????", image);
        if (checkProductResult.getStatus() != 200) return checkProductResult;
        k2Product = (K2ProductWithBLOBs) checkProductResult.getData();
        // ?§Ø???¦Ë?????????????????
        if ("1".equals(state)) {
            // ????????? ??????????????
            SystemResult productResult = ProductBasicsAppoint.getProductInfoByPJson
                    (k2Product, jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA, PRODUCT_NUMBER_REDIS_KEY, k2ProductMapper, k2Member, restTemplate, servletUrl);
            if (productResult.getStatus() != 200) return productResult;
            // ?????????
            k2Product = (K2ProductWithBLOBs) productResult.getData();
            // ??????????????
            K2ProductSketch sketch = new K2ProductSketch();
            sketch.setProductSketchValue(k2Product.getProductSketchContent());
            k2ProductSketchMapper.insert(sketch);
            // ?????????
            k2Product.setProductSketchId(sketch.getProductSketchId());
            k2ProductMapper.insert(k2Product);
        }
        return new SystemResult(k2Product);
    }


    /**
     * §µ?????????????????????solr??????
     *
     * @param k2ProductWithBLOBs
     */
    public static void addProductInfoQueue(K2ProductWithBLOBs k2ProductWithBLOBs) {
        // ?????
        ProductQueueLockFactory instance = ProductQueueLockFactory.getInstance();
        ReentrantLock reentrantLock = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_INFO_KEY.getValue()).getLock();
        Condition condition = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_INFO_KEY.getValue()).getCondition();
        // ????
        reentrantLock.lock();
        try {
            // ??????????????
            ProductSuccessQueue successQueue = ProductSuccessQueue.getInstance();
            successQueue.getProdudctInfoQueue().add(k2ProductWithBLOBs);
            // ???????????
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * ???????????????????????
     *
     * @param k2ProductWithBLOBs
     */
    public static void addSynchronizedProductGotoCache(K2ProductWithBLOBs k2ProductWithBLOBs) {
        // ?????
        ProductQueueLockFactory instance = ProductQueueLockFactory.getInstance();
        ReentrantLock reentrantLock = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_CACHE_KEY.getValue()).getLock();
        Condition condition = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_CACHE_KEY.getValue()).getCondition();
        // ????
        reentrantLock.lock();
        try {
            // ??????????????????
            SynchornizedProductQueue queue = SynchornizedProductQueue.getInstance();
            queue.getSynchronizedProductQueue().add(k2ProductWithBLOBs);
            // ???????????
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * ????????????????????§Ý?????
     *
     * @param productWithBLOBs
     */
    public static void addSynchronizedProductsGotoCache(List<K2ProductWithBLOBs> productWithBLOBs) {
        // ?????
        ProductQueueLockFactory instance = ProductQueueLockFactory.getInstance();
        ReentrantLock reentrantLock = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_CACHE_KEY.getValue()).getLock();
        Condition condition = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_CACHE_KEY.getValue()).getCondition();
        // ????
        reentrantLock.lock();
        try {
            // ??????????????????
            for (int i = 0; i < productWithBLOBs.size(); i++) {
                SynchornizedProductQueue queue = SynchornizedProductQueue.getInstance();
                queue.getSynchronizedProductQueue().add(productWithBLOBs.get(i));
            }

            // ???????????
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
