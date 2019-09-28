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
	˵��:    ��Ʒ��������ί����

	����		ʱ��					ע��
  	����		2019.08.06   			����
=======================================================*/
@Component
public class ProductBasicsAppoint {

    /**
     * -----------------------------------------------------
     * ����:  �жϲ�������Ʒ�Ľ�ɫ�Ƿ����ڸ���Ʒ��������ĳ�Ա
     * �����ϵͳ��������Ա�Ϳ���Խ����Ȩ��
     * <p>
     * ����:
     * productWithBLOBs         K2ProductWithBLOBs          ��Ʒ��Ϣ
     * k2MemberAndElseInfo      K2MemberAndElseInfo         �������û���Ϣ
     * SYSTEM_ROLE_PROVE        String                      ϵͳ����Ա�ı�ʶ��
     * <p>
     * ����: UserManageUtil              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static SystemResult checkProductIsUser(K2ProductWithBLOBs productWithBLOBs,
                                                  K2MemberAndElseInfo k2MemberAndElseInfo,
                                                  String SYSTEM_ROLE_PROVE) {

        // �鿴�ý�ɫ��ϵͳ��ʶ���Ƿ�Ϊ����ϵͳ����Ա
        // �����Ƿ��ǳ�������Աflag
        boolean isSystemAdminFlag = false;
        List<K2Role> k2Roles = k2MemberAndElseInfo.getK2Roles();
        for (int i = 0; i < k2Roles.size(); i++) {
            if (SYSTEM_ROLE_PROVE.equals(k2Roles.get(i).getRetain1())) {
                isSystemAdminFlag = true;
                break;
            }
        }

        // �ж�������ǳ������� ��Ҫ�鿴���û�ɾ������Ʒ�Ƿ����ڸ��û��ĵ�����
        if (!isSystemAdminFlag &&
                !productWithBLOBs.getProductStoreId().toString().equals(k2MemberAndElseInfo.getK2Member().getRetain1())) {
            // ������ ˵�����ǰ��ղ�������  ����Ҫ��Ҫ���з���ip+�˺�???
            return new SystemResult(100, "�����޸��������̵���Ʒ��Ϣ", null);
        }
        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * ����:  У�鴫�������json�����Ƿ����ת���ɶ�Ӧ��class����
     * <p>
     * ����:
     * jsonInfo         String          JSON����
     * clazz            Class           ��Ҫת��������
     * <p>
     * ����: UserManageUtil              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    private static SystemResult checkJsonWhetherGotoClass(String jsonInfo, Class clazz, String errorMsg, String image) {

        // �ж�Json�����Ƿ�Ϊ��
        if (StringUtils.isEmpty(jsonInfo) || clazz == null) {
            return new SystemResult(100, "ת��ʧ�ܣ������п�ֵ", null);
        }

        // ת������
        try {
            ProductInfoDto o = (ProductInfoDto) JsonUtils.jsonToPojo(jsonInfo, clazz);
            // ת���ɹ� �����ݱ����Ʒ����
            SystemResult productByProductJsonInfo = getProductByProductJsonInfo(o, image);
//            if(o == null)   return new SystemResult(100, "ת��ʧ�ܣ�������Ч", null);
            return productByProductJsonInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, errorMsg + "ת��ʧ�ܣ�������Ԥ�ڵĲ�ƥ��", null);
        }
    }

    /**
     * ��ȡ����Ʒ����
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
     * ����:  У�鴫�������SKUjson�����Ƿ����ת���ɶ�Ӧ�ļ��϶���
     * <p>
     * ����:
     * jsonInfo         String          JSON����
     * clazz            Class           ��Ҫת��������
     * <p>
     * ����: UserManageUtil              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static SystemResult checkSkuJsonGotoLists(String jsonInfo) {

        // �ж�Json�����Ƿ�Ϊ��
        if (StringUtils.isEmpty(jsonInfo)) {
            return new SystemResult(100, "ת��ʧ�ܣ������п�ֵ", null);
        }

        // ת������
        try {
            List<ProductSkuPojo> productSkuPojos = JsonUtils.jsonToList(jsonInfo, ProductSkuPojo.class);
//            if(o == null)   return new SystemResult(100, "ת��ʧ�ܣ�������Ч", null);
            return new SystemResult(productSkuPojos);
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, "ת��ʧ�ܣ�������Ԥ�ڵĲ�ƥ��", null);
        }
    }

    // ע��JedisPool���ӳ�
    @Autowired
    private JedisPool jedisPool;

    /**
     * -----------------------------------------------------
     * ����:  ���ݴ���ȥ��Json���ݷ�����Ʒ����Ϣ
     * <p>
     * ����:
     * productJson          String          ��Ʒ��JSON����
     * jedis                Jedis           jedisģ��
     * scrpit               String          ������lua�ű�
     * redisKey             String          ��ŵ�key
     * k2ProductMapper  K2ProductMapper     ��ƷMapperʵ��
     * <p>
     * ����: UserManageUtil              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    private static SystemResult getProductInfoByPJson(K2ProductWithBLOBs k2Product, JedisPool jedisPool, String scrpit, String redisKey,
                                                      K2ProductMapper k2ProductMapper, K2Member k2Member, RestTemplate restTemplate, String servletUrl) throws Exception {

        // ��ȡ��Ʒ��Ψһ���
        SystemResult onlyProductNumber = getOnlyProductNumber(jedisPool, redisKey, k2ProductMapper, restTemplate, servletUrl);
        if (onlyProductNumber.getStatus() != 200) return onlyProductNumber;
        // ��Ʒ�ı��
        String number = onlyProductNumber.getData() + "";
        // ����Ʒ��Ŵ������
        k2Product.setProductNumber(number);
        // У����Ʒ��Ϣ�Ƿ���ȷ
        SystemResult systemResult = validatedProductInfo(k2Product, k2Member);
        if (systemResult.getStatus() != 200) return systemResult;
        // ����ǰ�Ĵ���
        getProductInfoByPJsonLast(k2Product);
        return new SystemResult(k2Product);
    }


    /**
     * -----------------------------------------------------
     * ����:  У����Ʒ����Ϣ�Ƿ��������
     * <p>
     * ����:
     * k2Product         K2Product          ��Ʒ�Ķ���
     * k2Member          K2Member           �������û���Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static SystemResult validatedProductInfo(K2ProductWithBLOBs k2Product, K2Member k2Member) {

        // У����Ʒ����
        if (StringUtils.isEmpty(k2Product.getProductName()) || k2Product.getProductName().length() > 200) {
            return new SystemResult(100, "��Ʒ������д����,���Ƴ���Ϊ1-200����", null);
        }
        // У����ƷƷ��
        if (k2Product.getProductBrandId() == null || k2Product.getProductBrandId() == 0 ||
                k2Product.getProductBrandId().toString().length() > 11) {
            return new SystemResult(100, "��ƷƷ��ѡ�����,��ˢ��ҳ������", null);
        }
        // У����Ŀ�Ƿ���ȷ
        if (k2Product.getProductOneCategoryId() == null || k2Product.getProductOneCategoryId() == 0 ||
                k2Product.getProductOneCategoryId().toString().length() > 11 ||
                k2Product.getProductTwoCategoryId() == null || k2Product.getProductTwoCategoryId() == 0 ||
                k2Product.getProductTwoCategoryId().toString().length() > 11) {

            return new SystemResult(100, "��ѡ����ȷ�Ķ�����Ŀ", null);
        }

        // У����Ʒ�г��۸�
        if (k2Product.getProductBazaarPrice() == null || k2Product.getProductBazaarPrice().floatValue() > 9999999.99 ||
                k2Product.getProductBazaarPrice().floatValue() < 1) {
            return new SystemResult(100, "��Ʒ�г��۸����,��Χ��1~9999999.99֮��", null);
        }

        // У��ϵͳ�۸�
        if (k2Product.getProductSystemPrice() == null || k2Product.getProductSystemPrice().floatValue() > 9999999.99 ||
                k2Product.getProductSystemPrice().floatValue() < 1) {
            return new SystemResult(100, "��Ʒϵͳ�۸����,��Χ��1~9999999.99֮��", null);
        }

        // У����Ʒ����
        if (StringUtils.isEmpty(k2Product.getProductSketchContent()) || k2Product.getProductSketchContent().length() > 1000) {
            return new SystemResult(100, "��Ʒ��������,������Χ��1~1000�ַ�֮��", null);
        }

        // У����Ʒ�������
        if (k2Product.getProductOrderRule() == null || k2Product.getProductOrderRule().toString().length() > 11) {
            return new SystemResult(100, "��Ʒ���򲻿�Ϊ��,��Χ��1~11λ��֮��", null);
        }

        // У����Ʒ��λ��Ϣ
        if (StringUtils.isEmpty(k2Product.getProductUnit()) || k2Product.getProductUnit().length() > 10) {
            return new SystemResult(100, "����д��ȷ����Ʒ��λ", null);
        }

        // У����Ʒ�Ƿ�֧���������˿�
        if (k2Product.getProductIfSupport() == null || (k2Product.getProductIfSupport() != 1 && k2Product.getProductIfSupport() != 2)) {
            return new SystemResult(100, "����д������ȷ���������˿������", null);
        }

        // У���������˿������
        if (k2Product.getProductIfSupport() == null || k2Product.getProductIfSupport() != 1) {
            k2Product.setProductSupportDay(0);
        } else if (k2Product.getProductSupportDay() == null || k2Product.getProductSupportDay() > 999) {
            return new SystemResult(100, "���֧��999����������˿�", null);
        }

        // ��ƷͼƬ
        if (StringUtils.isEmpty(k2Product.getProductImage())) {
            return new SystemResult(100, "���ϴ���Ʒ��ͼƬ", null);
        }
        String[] imageSplit = k2Product.getProductImage().split(",");
        if (imageSplit.length > 6 || imageSplit.length < 1) {
            return new SystemResult(100, "��Ʒ��ͼƬΪ1-6��", null);
        }

        // У����Ʒ����
        if (!StringUtils.isEmpty(k2Product.getProductPoints()) && k2Product.getProductPoints().length() > 700) {
            return new SystemResult(100, "��Ʒ������࣬�����", null);
        }

        // У����Ʒ�����ͼƬ
        if (StringUtils.isEmpty(k2Product.getProductImageDescribe())) {
            return new SystemResult(100, "���ϴ���Ʒ�����ͼƬ", null);
        }
        String[] iamgeDe = k2Product.getProductImageDescribe().split(",");
        if (iamgeDe.length > 30 || iamgeDe.length < 1) {
            return new SystemResult(100, "��Ʒ�����ͼƬΪ1-30��", null);
        }

        // ��ȫ����
        // ---1�ϼ� 2�¼� 3ɾ�� 4�༭�� 5 �����
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
     * ����:  ��ȡһ��Ψһ����Ʒ���
     * <p>
     * ����:
     * jedis         Jedis          jedisģ��
     * scrpit        String         ������lua�ű�
     * redisKey      String         ��ŵ�key
     * k2ProductMapper  K2ProductMapper     ��ƷMapperʵ��
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    private static SystemResult getOnlyProductNumber(JedisPool jedisPool, String redisKey, K2ProductMapper k2ProductMapper, RestTemplate restTemplate, String servletUrl) throws Exception {
        while (true) {
            // ���Ȼ�ȡһ����Ʒ���SystemCacheManage.UNLOCK_REDIS_LUA
            ShoppingNumberPojo sp = new ShoppingNumberPojo(jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA, redisKey, "SP", 11, restTemplate, servletUrl);
            ShoppingNumberManage numberManage = new ShoppingNumberManage(sp, sp.NUMBER_TYPE_PRODUCT);
            SystemResult numberByRedisKey = numberManage.getNumberByRedisKey(redisKey, 10);
            if (numberByRedisKey.getStatus() != 200) return numberByRedisKey;
            // ��ȡ���
            String number = numberByRedisKey.getData().toString();
            if (!StringUtils.isEmpty(number) && number.length() != 11) {
                number = number.substring(0, 11);
            }
            // �ж���Ʒ����Ƿ�Ψһ
            K2ProductExample example = new K2ProductExample();
            example.createCriteria().andProductNumberEqualTo(number);
            List<K2Product> k2Products = k2ProductMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(k2Products)) {
                return new SystemResult(200, "ok", number);
            }
        }
    }

    /**
     * ����ǰ�Ĵ���
     *
     * @param k2Product
     */
    public static void getProductInfoByPJsonLast(K2Product k2Product) {
    }


    /**
     * -----------------------------------------------------
     * ����:  �����Ʒ�Ļ�����Ϣ
     * <p>
     * ����:
     * jedis                            Jedis               jedisģ��
     * productInfo                      String              ��Ʒ��Json����
     * PRODUCT_NUMBER_REDIS_KEY         String              ��ŵ�key
     * k2ProductMapper                  K2ProductMapper     ��ƷMapperʵ��
     * k2Member                         K2Member            ��Ա��Ϣ
     * state                            String              �Ƿ���Ҫ���  1��Ҫ 2����Ҫ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static SystemResult addProduct(JedisPool jedisPool, String productInfo, String PRODUCT_NUMBER_REDIS_KEY,
                                          K2ProductMapper k2ProductMapper, K2Member k2Member, String state, K2ProductSketchMapper k2ProductSketchMapper,
                                          RestTemplate restTemplate, String servletUrl, String image) throws Exception {

        // ��Ʒ������
        K2ProductWithBLOBs k2Product = null;
        // ����У���� ��ѯ��Ʒ��JSON�����Ƿ�����
        SystemResult checkProductResult = ProductBasicsAppoint.checkJsonWhetherGotoClass(productInfo, ProductInfoDto.class, "��Ʒ��Ϣ", image);
        if (checkProductResult.getStatus() != 200) return checkProductResult;
        k2Product = (K2ProductWithBLOBs) checkProductResult.getData();
        // �жϱ��λ��Ƿ���Ҫ�����Ʒ����
        if ("1".equals(state)) {
            // ����ί���� ����һ����Ʒ����
            SystemResult productResult = ProductBasicsAppoint.getProductInfoByPJson
                    (k2Product, jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA, PRODUCT_NUMBER_REDIS_KEY, k2ProductMapper, k2Member, restTemplate, servletUrl);
            if (productResult.getStatus() != 200) return productResult;
            // ȡ����Ʒ��Ϣ
            k2Product = (K2ProductWithBLOBs) productResult.getData();
            // �����Ʒ�ļ�����Ϣ
            K2ProductSketch sketch = new K2ProductSketch();
            sketch.setProductSketchValue(k2Product.getProductSketchContent());
            k2ProductSketchMapper.insert(sketch);
            // �����Ʒ��Ϣ
            k2Product.setProductSketchId(sketch.getProductSketchId());
            k2ProductMapper.insert(k2Product);
        }
        return new SystemResult(k2Product);
    }


    /**
     * У����Ϣ�Ƿ���ȷ��ͬ����Ϣ��solr������
     *
     * @param k2ProductWithBLOBs
     */
    public static void addProductInfoQueue(K2ProductWithBLOBs k2ProductWithBLOBs) {
        // ��ȡ��
        ProductQueueLockFactory instance = ProductQueueLockFactory.getInstance();
        ReentrantLock reentrantLock = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_INFO_KEY.getValue()).getLock();
        Condition condition = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_INFO_KEY.getValue()).getCondition();
        // ����
        reentrantLock.lock();
        try {
            // ��ȡ��Ʒ��������
            ProductSuccessQueue successQueue = ProductSuccessQueue.getInstance();
            successQueue.getProdudctInfoQueue().add(k2ProductWithBLOBs);
            // ���������߳�
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * ͬ����Ʒ��Ϣ�������������ȥ
     *
     * @param k2ProductWithBLOBs
     */
    public static void addSynchronizedProductGotoCache(K2ProductWithBLOBs k2ProductWithBLOBs) {
        // ��ȡ��
        ProductQueueLockFactory instance = ProductQueueLockFactory.getInstance();
        ReentrantLock reentrantLock = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_CACHE_KEY.getValue()).getLock();
        Condition condition = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_CACHE_KEY.getValue()).getCondition();
        // ����
        reentrantLock.lock();
        try {
            // ��ȡ��Ʒͬ���Ķ�������
            SynchornizedProductQueue queue = SynchornizedProductQueue.getInstance();
            queue.getSynchronizedProductQueue().add(k2ProductWithBLOBs);
            // ���������߳�
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * ����Ʒ����������ӵ����л�����
     *
     * @param productWithBLOBs
     */
    public static void addSynchronizedProductsGotoCache(List<K2ProductWithBLOBs> productWithBLOBs) {
        // ��ȡ��
        ProductQueueLockFactory instance = ProductQueueLockFactory.getInstance();
        ReentrantLock reentrantLock = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_CACHE_KEY.getValue()).getLock();
        Condition condition = instance.getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_PRODUCT_CACHE_KEY.getValue()).getCondition();
        // ����
        reentrantLock.lock();
        try {
            // ��ȡ��Ʒͬ���Ķ�������
            for (int i = 0; i < productWithBLOBs.size(); i++) {
                SynchornizedProductQueue queue = SynchornizedProductQueue.getInstance();
                queue.getSynchronizedProductQueue().add(productWithBLOBs.get(i));
            }

            // ���������߳�
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
