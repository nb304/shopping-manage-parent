package com.king2.product.server.appoint;

import com.king2.commons.mapper.K2ProductMapper;
import com.king2.commons.mapper.K2ProductSketchMapper;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.check.CheckProductInfoManage;
import com.king2.product.server.dto.AddProductDto;
import com.king2.product.server.dto.LockPojo;
import com.king2.product.server.dto.ProductSkuDto;
import com.king2.product.server.exception.CheckValueException;
import com.king2.product.server.locks.ProductServerStroeManageLockFactory;
import com.king2.product.server.locks.ProductServerStroeManageLockFactoryTypeEnum;
import com.king2.product.server.mapper.ProductManageMapper;
import com.king2.product.server.mapper.ProductSkuMapper;
import com.king2.product.server.mapper.ProductSpuMapper;
import com.king2.product.server.utlis.GetNumberByType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*=======================================================
	说明:    商品添加委派类

	作者		时间					注释
  	俞烨		2019.09.22   			创建
=======================================================*/
@Component
public class ProductAddAppoint {

    // 注入远程的商品Mapper
    @Autowired
    private K2ProductMapper k2ProductMapper;

    // 注入商品无图片的地址
    @Value("${PRODUCT_IMAGE_NOT_DEFINITION}")
    private String PRODUCT_IMAGE_NOT_DEFINITION;

    // 注入商品存在缓存中的key
    @Value("${PRODUCT_NUMBER_REDIS_KEY}")
    private String PRODUCT_NUMBER_REDIS_KEY;

    // 注入获取编号的工具类
    @Autowired
    private GetNumberByType getNumberByType;

    // 注入本地的商品Mapper
    @Autowired
    private ProductManageMapper productManageMapper;

    // 注入商品简述Mapper
    @Autowired
    private K2ProductSketchMapper k2ProductSketchMapper;

    // 注入商品的SPUMapper
    @Autowired
    private ProductSpuMapper productSpuMapper;

    // 注入商品的SKUMapper
    @Autowired
    private ProductSkuMapper productSkuMapper;

    /**
     * -----------------------------------------------------
     * 功能:  判断商品信息是否正确 并返回商品的信息
     * <p>
     * 参数:
     * productDto         AddProductDto         需要判断的商品信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public SystemResult checkProductInfo(AddProductDto productDto, K2MemberAndElseInfo k2MemberAndElseInfo) throws CheckValueException {


        // 获取店铺添加的锁
        LockPojo pojo = ProductServerStroeManageLockFactory.getInstance().getLockMaps()
                .get(ProductServerStroeManageLockFactoryTypeEnum.STORE_ADD_KEY_LOCK.getValue() + "_" + k2MemberAndElseInfo.getK2Member().getRetain1());

        // 开启锁
        pojo.getLock().lock();

        try {
            // 创建返回的商品信息
            K2ProductWithBLOBs product = new K2ProductWithBLOBs();

            // 校验类目信息是否正确
            CheckProductInfoManage.checkProductCategoryInfo(productDto, product);

            // 校验商品的其他信息
            CheckProductInfoManage.checkProductElseInfo(productDto, product);

            // 校验商品的SPU信息 并返回
            List<K2ProductSpu> spus = CheckProductInfoManage.checkProductSpuJsonReturnSpuInfoLists(productDto);

            // 校验商品的SKU信息并返回
            List<ProductSkuDto> skus = CheckProductInfoManage.checkProductSkuJsonReturnSkuInfoLists(productDto);

            /***
             * 到这里就说明校验成功通过了  我们需要调用添加接口 将商品信息和商品的SKU等其他信息添加到数据库中 将数据持久化
             */
            addProductInfo(product, k2MemberAndElseInfo);

            // 商品添加成功后  添加商品的SPU信息
            addProductSpuInfo(spus, product);

            // 添加成功后  添加商品的SKU信息
            addProductSkuInfo(skus, product);

            // 添加成功往队列里面塞数据
            ProductBasicsAppoint.addProductInfoQueue(product);
            ProductBasicsAppoint.addSynchronizedProductGotoCache(product);
            return new SystemResult("ok");
        } catch (Exception e) {
            throw e;
        } finally {
            pojo.getLock().unlock();
        }

    }

    /**
     * -----------------------------------------------------
     * 功能:  校验商品信息成功后  添加商品的信息
     * <p>
     * 参数:
     * productWithBLOBs         K2ProductWithBLOBs         需要添加的商品信息
     * k2MemberAndElseInfo      K2MemberAndElseInfo        登录的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public void addProductInfo(K2ProductWithBLOBs productWithBLOBs, K2MemberAndElseInfo k2MemberAndElseInfo)
            throws CheckValueException {

        // 添加商品的简述信息
        // 判断是否为空 不为空就需要添加
        if (!StringUtils.isEmpty(productWithBLOBs.getProductSketchContent())) {
            // 需要添加简述信息
            K2ProductSketch sketch = new K2ProductSketch();
            sketch.setProductSketchValue(productWithBLOBs.getProductSketchContent());
            k2ProductSketchMapper.insert(sketch);
            // 添加完成后将id指向商品的简述id
            productWithBLOBs.setProductSketchId(sketch.getProductSketchId());
        }
        // 补全一些数据
        productWithBLOBs.setProductCreateUsername(k2MemberAndElseInfo.getK2Member().getMemberAccount());
        productWithBLOBs.setProductUpdateTime(new Date());
        productWithBLOBs.setProductCreateUserid(k2MemberAndElseInfo.getK2Member().getMemberId());
        productWithBLOBs.setProductUpdateUserid(k2MemberAndElseInfo.getK2Member().getMemberId());
        productWithBLOBs.setProductUpdateUsername(k2MemberAndElseInfo.getK2Member().getMemberAccount());
        productWithBLOBs.setProductStoreId(Integer.parseInt(k2MemberAndElseInfo.getK2Member().getRetain1()));
        productWithBLOBs.setProductImage(PRODUCT_IMAGE_NOT_DEFINITION);
        productWithBLOBs.setProductImageDescribe(PRODUCT_IMAGE_NOT_DEFINITION);

        // 获取商品的编号信息
        SystemResult sp = null;
        try {
            for (int i = 0; i < 10; i++) {
                if (sp == null || sp.getStatus() != 200) {
                    sp = getNumberByType.getNumber(PRODUCT_NUMBER_REDIS_KEY, 11, "sp");
                } else if (sp != null && sp.getStatus() == 200) {
                    break;
                }
            }
            // 如果到这里商品编号还是没有取到就算了 抛出异常
            if (sp == null || sp.getStatus() != 200) {
                throw new CheckValueException("您的网络波动较大,请稍后重试");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        productWithBLOBs.setProductNumber(sp.getData() + "");

        // 获取最大的排序
        if (productWithBLOBs.getProductOrderRule() == null) {
            Integer productMaxOrderByStoreId = productManageMapper.getProductMaxOrderByStoreId(Integer.parseInt(k2MemberAndElseInfo.getK2Member().getRetain1()));
            productWithBLOBs.setProductOrderRule(productMaxOrderByStoreId + 1);
        } else if (productWithBLOBs.getProductOrderRule() > 999999) {
            throw new CheckValueException("排序错误");
        }


        // 数据补全成功 添加商品的信息
        k2ProductMapper.insert(productWithBLOBs);

    }

    /**
     * -----------------------------------------------------
     * 功能:  添加商品成功后添加商品的SPU信息
     * <p>
     * 参数:
     * spus         List<K2ProductSpu>          需要添加的商品SPU信息
     * productWithBLOBs K2ProductWithBLOBs      SPU属于哪个商品
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    private void addProductSpuInfo(List<K2ProductSpu> spus, K2ProductWithBLOBs productWithBLOBs) {

        // 批量添加商品的SPU信息
        spus.forEach(spu -> spu.setBelongProductId(productWithBLOBs.getProductId()));
        // 添加SPU信息
        productSpuMapper.batchInsertProductSpu(spus);
    }

    /**
     * -----------------------------------------------------
     * 功能:  添加商品成功后添加商品的SKU信息
     * <p>
     * 参数:
     * skus         List<ProductSkuDto>         需要添加的商品SKU信息
     * productWithBLOBs K2ProductWithBLOBs      SPU属于哪个商品
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    private void addProductSkuInfo(List<ProductSkuDto> skus, K2ProductWithBLOBs product) throws CheckValueException {

        skus.forEach(sku -> {
            sku.setCreateUserid(product.getProductCreateUserid());
            sku.setBelongProductId(product.getProductId());
            sku.setBelongCategoryId(product.getProductTwoCategoryId());
        });

        // 添加商品的SkuKey
        productSkuMapper.batchInsertSkuKey(skus);

        // 添加商品的SKU-Key成功现在添加SKU-Value
        addSkuSuccessAndAddSkuValueInfo(skus, product);


    }

    /**
     * -----------------------------------------------------
     * 功能:  添加商品的SKU-Key成功后 添加商品的SKU-Value
     * <p>
     * 参数:
     * skus         List<ProductSkuDto>         需要添加的商品SKU信息
     * productWithBLOBs K2ProductWithBLOBs      SPU属于哪个商品
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    private void addSkuSuccessAndAddSkuValueInfo(List<ProductSkuDto> skus, K2ProductWithBLOBs product) throws CheckValueException {


        // 遍历原先的SKUs数据
        // 创建商品的SKU-Value的数据集合
        List<K2ProductSkuValue> skuValues = new ArrayList<>();
        for (ProductSkuDto skuDto : skus) {
            // 创建单个商品的SKuValue的值
            K2ProductSkuValue skuValue = new K2ProductSkuValue();
            skuValue.setSkuKeyId(skuDto.getProductSkuKeyId());
            if (StringUtils.isEmpty(skuDto.getProduct_sku_value())) {
                throw new CheckValueException("商品配置的值不能为空");
            }
            String[] split = skuDto.getProduct_sku_value().split(",");
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                // 判断长度是否在预期中
                if (StringUtils.isEmpty(s) || s.length() > 100) {
                    throw new CheckValueException("商品配置的值不能为空");
                }
                skuValue.setSkuValue(s);
            }
            skuValues.add(skuValue);
        }

        // 遍历完成 添加商品的SKu-Value
        productSkuMapper.batchInsertSkuValue(skuValues);

        // 添加成功 添加商品的的SKU库存价格

        Map<Integer, List<K2ProductSkuValue>> collect = skuValues.stream().collect(Collectors.groupingBy(K2ProductSkuValue::getSkuKeyId));
        // 创建返回的List
        List<List<K2ProductSkuValue>> lists = new ArrayList<>();
        for (Map.Entry<Integer, List<K2ProductSkuValue>> entry : collect.entrySet()) {
            lists.add(entry.getValue());
        }

        // 创建SKU的价格库存信息
        List<K2ProductSkuPriceandkc> kcs = new ArrayList<>();
        ProductSkuValueKcAppoint.dkej(lists, kcs);
        // 设置其他参数
        ProductSkuValueKcAppoint.setSkuKcValues(kcs, product);

        // 添加商品的库存价格标
        productSkuMapper.batchInsertSkuValueKc(kcs);
    }
}

