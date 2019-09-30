package com.king2.product.server.service.impl;

import com.king2.commons.mapper.*;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.*;
import com.king2.product.server.dto.*;
import com.king2.product.server.enmu.ProductEnum;
import com.king2.product.server.enmu.ProductStateEnum;
import com.king2.product.server.exception.CheckValueException;
import com.king2.product.server.mapper.ProductManageMapper;
import com.king2.product.server.mapper.ProductSkuMapper;
import com.king2.product.server.pojo.ProductSkuPojo;
import com.king2.product.server.service.ProductBasicsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisPool;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    // 注入本地的商品Mapper
    @Autowired
    private ProductManageMapper productManageMapper;

    // 注入商品无图片的地址
    @Value("${PRODUCT_IMAGE_NOT_DEFINITION}")
    private String PRODUCT_IMAGE_NOT_DEFINITION;

    // 注入商品最后一次修改的时间
    @Autowired
    private K2ProductEditSizeMapper k2ProductEditSizeMapper;

    // 注入超级系统管理员标识符
    @Value("${SYSTEM_ROLE_PROVE}")
    private String SYSTEM_ROLE_PROVE;

    // 注入消息Mapper
    @Autowired
    private K2MessageMapper k2MessageMapper;

    // 注入商品添加委托类
    @Autowired
    private ProductAddAppoint productAddAppoint;

    /**
     * -----------------------------------------------------
     * 功能:  添加商品
     * <p>
     * 参数:
     * K2Member         K2MemberAndElseInfo        操作的用户信息
     * AddProductDto    dto                        添加的商品信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemResult addProduct(K2MemberAndElseInfo k2MemberAndElseInfo, AddProductDto dto) throws CheckValueException {

        SystemResult result = productAddAppoint.checkProductInfo(dto, k2MemberAndElseInfo);
        return result;
    }

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
    public SystemResult addProductSku(String skuJson, String productInfo, String state, K2MemberAndElseInfo k2Member) throws Exception {

        /*
        添加商品信息
        这里明明是添加商品的SKU为
            因为商品的SKU开销很大 我们需要将数什么会有添加商品信息的方法存在呢？据存放到数据库当中去，存放的时候需要指定商品信息
            所以我们根据传入过来的state 判断本次是否需要添加商品信息
         */
        SystemResult addProductResult = ProductBasicsAppoint.addProduct
                (jedisPool, productInfo, PRODUCT_NUMBER_REDIS_KEY, k2ProductMapper, k2Member.getK2Member(), state, k2ProductSketchMapper, restTemplate, CACHE_SERVER_URL, PRODUCT_IMAGE_NOT_DEFINITION);
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
        SystemResult addSku_KeyResult = ProductSkuAppoint.addProductSkuKeyInfos(skuPojos, k2Member.getK2Member(), k2ProductWithBLOBs, productSkuMapper, k2ProductSkuKeyMapper);
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

        // 添加信息 提示用户 商品提交申请成功
        StringBuilder sb = new StringBuilder();
        sb.append("您的商品信息:商品名称- ");
        sb.append(k2ProductWithBLOBs.getProductName());
        sb.append(" :商品编号:-");
        sb.append(k2ProductWithBLOBs.getProductNumber());
        sb.append(" 提交成功,请耐心等待系统审核,请多多关注消息,谢谢! ----来自系统管理员");
        UserMessageAppoint.addMessageGotoMysql(sb.toString() + k2ProductWithBLOBs.getProductName(), k2Member.getK2Member().getMemberId(), k2MessageMapper);

        // 添加商品成功 往队列发送信息同步solr
        ProductBasicsAppoint.addProductInfoQueue(k2ProductWithBLOBs);
        ProductBasicsAppoint.addSynchronizedProductGotoCache(k2ProductWithBLOBs);

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
    public SystemResult addProductPageInfo(K2MemberAndElseInfo k2Member) throws Exception {

        // 商品类目的信息
        SystemResult productCategoryInfo = productCategoryAppoint.getProductCategoryInfo();
        if (productCategoryInfo.getStatus() != 200) return productCategoryInfo;
        // 取出数据
        ShowProductAddPageDto showProductAddPageDto = (ShowProductAddPageDto) productCategoryInfo.getData();

        // 查询商品品牌信息
        K2ProductBrandExample brandExample = new K2ProductBrandExample();
        brandExample.createCriteria().andBrandStoreIdEqualTo(Integer.parseInt(k2Member.getK2Member().getRetain1()))
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
    public SystemResult getSkuInfoByCId(Integer cId, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // 查询该商品类目是否存在
        K2ProductCategory k2ProductCategory = k2ProductCategoryMapper.selectByPrimaryKey(cId);
        if (k2ProductCategory == null) {
            return new SystemResult(100, "你选中的类目不存在,请刷新页面重试", null);
        } else if (k2ProductCategory.getCategoryIsParent() == 1) {
            return new SystemResult(100, "请将类目精确到二级类目", null);
        }

        // 查找属于该商品类目的SKU信息
        List<K2ProductSkuKey> skuInfoByCid = productSkuMapper.getSkuInfoByCid(cId);
        List<K2ProductSkuKey> skuInfoByStoreId = productSkuMapper.getSkuInfoByStoreId(cId, Integer.parseInt(k2MemberAndElseInfo.getK2Member().getRetain1()));
        skuInfoByCid.addAll(skuInfoByStoreId);
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
     * 功能:  显示商品修改页面并查询商品信息
     * <p>
     * 参数:
     * productId         Integer          需要查询的商品id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult showEditGetProInfo(Integer productId, K2MemberAndElseInfo k2Member) {

        // 查询出该商品的信息
        ShowEditProductInfoDto productInfoByPId = productManageMapper.getProductInfoByPId(productId);

        // 判断商品是否存在
        if (productInfoByPId == null) return new SystemResult(100, "商品信息出错,请刷新页面重试", null);

        // 查询出该商家的所有品牌信息
        K2ProductBrandExample brandExample = new K2ProductBrandExample();
        brandExample.createCriteria().andBrandStoreIdEqualTo(Integer.parseInt(k2Member.getK2Member().getRetain1()));
        List<K2ProductBrand> k2ProductBrands = k2ProductBrandMapper.selectByExample(brandExample);

        // 创建返回值
        ShowEditProductDto dto = new ShowEditProductDto();
        dto.setBrands(k2ProductBrands);

        // 计算出 是否可以修改
        if (productInfoByPId.getNextUpdateTime() == null) {
            dto.setEditFlag(true);
        } else if (new Date().compareTo(productInfoByPId.getNextUpdateTime()) == -1) {
            dto.setEditFlag(false);
            // 变换时间为String
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            productInfoByPId.setLastTimeStr(sdf.format(productInfoByPId.getLastUpdateTime()));
            productInfoByPId.setNextTimeStr(sdf.format(productInfoByPId.getNextUpdateTime()));
        } else if (new Date().compareTo(productInfoByPId.getNextUpdateTime()) == 1) {
            dto.setEditFlag(true);
        } else {
            dto.setEditFlag(false);
        }

        dto.setProductInfo(productInfoByPId);
        return new SystemResult(dto);
    }

    /**
     * -----------------------------------------------------
     * 功能:  查询商品的图片信息
     * <p>
     * 参数:
     * productId         Integer          需要查询的商品id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult getProductImageByPId(Integer productId) {

        // 创建商品集合
        List<ProductImageDto> productImages = new ArrayList<>();

        // 查询商品图片
        String productImageById = productManageMapper.getProductImageById(productId);
        // 判断商品图片是否存在
        if (StringUtils.isEmpty(productImageById)) {
            ProductImageDto dto = new ProductImageDto();
            dto.setImageUrl(PRODUCT_IMAGE_NOT_DEFINITION);
            dto.setOrder(1);
            dto.setProductId(1);
            productImages.add(dto);
        } else {
            // 商品不为空 遍历商品信息
            String[] imageSplit = productImageById.split(",");
            for (int i = 0; i < imageSplit.length; i++) {
                ProductImageDto dto = new ProductImageDto();
                dto.setImageUrl(imageSplit[i]);
                dto.setOrder(i);
                dto.setProductId(i);
                productImages.add(dto);
            }
        }
        return new SystemResult(productImages);
    }

    /**
     * -----------------------------------------------------
     * 功能:  修改商品信息
     * <p>
     * 参数:
     * k2ProductWithBLOBs         K2ProductWithBLOBs          修改的商品信息
     * k2Member                   K2Member                    操作的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemResult editProductInfo(K2ProductWithBLOBs k2ProductWithBLOBs, K2MemberAndElseInfo k2Member) {

        // 查询该商品是否可以修改
        ShowEditProductInfoDto productInfoByPId = productManageMapper.getProductInfoByPId(k2ProductWithBLOBs.getProductId());
        // 查询商品其他信息
        K2ProductWithBLOBs productWithBLOBs = k2ProductMapper.selectByPrimaryKey(k2ProductWithBLOBs.getProductId());
        // 创建校验商品信息的返回值
        SystemResult result = null;

        if (productInfoByPId == null || productWithBLOBs == null) return new SystemResult("商品信息不存在,请刷新页面重试");
        if (productInfoByPId.getLastUpdateTime() != null &&
                productInfoByPId.getNextUpdateTime().compareTo(new Date()) == 1) {
            return new SystemResult("现在还不能修改该商品的信息,预计在:" + new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date()) + "，可以进行修改");
        } else if (productWithBLOBs.getProductState().toString().equals(ProductStateEnum.DEL.getValue() + "")) { // 判断商品的状态是否正确
            return new SystemResult(100, "商品的状态为删除,暂时不能修改信息", null);
        } else if ((result = ProductBasicsAppoint.checkProductIsUser(productWithBLOBs, k2Member, SYSTEM_ROLE_PROVE)).getStatus() != 200) { // 校验信息
            return result;
        }

        // 清空不能修改的数据
        k2ProductWithBLOBs.editClearValue();
        // 补全其他信息
        k2ProductWithBLOBs.setProductUpdateUsername(k2Member.getK2Member().getMemberAccount());
        k2ProductWithBLOBs.setProductUpdateUserid(k2Member.getK2Member().getMemberId());
        k2ProductWithBLOBs.setProductUpdateTime(new Date());

        // 修改商品信息
        k2ProductMapper.updateByPrimaryKeySelective(k2ProductWithBLOBs);
        // 修改成功后 修改该商品最后一次的修改时间
        K2ProductEditSize editSize = new K2ProductEditSize();
        editSize.setEditProductId(k2ProductWithBLOBs.getProductId());
        Date date = new Date();
        editSize.setLastUpdateTime(date);
        editSize.setLastUpdateUserId(k2Member.getK2Member().getMemberId());
        editSize.setLastUpdateUserNaem(k2Member.getK2Member().getMemberAccount());
        // 计算出三天后的时间
        long l = date.getTime() + (1000 * 60 * 60 * 24 * 3);
        editSize.setNextUpdateTime(new Date(l));
        k2ProductEditSizeMapper.insert(editSize);

        // 修改商品简述的信息
        K2ProductSketch sketch = new K2ProductSketch();
        sketch.setProductSketchId(k2ProductWithBLOBs.getProductSketchId());
        sketch.setProductSketchValue(k2ProductWithBLOBs.getProductSketchContent());
        k2ProductSketchMapper.updateByPrimaryKeySelective(sketch);


        // 查询商品信息
        k2ProductWithBLOBs = k2ProductMapper.selectByPrimaryKey(k2ProductWithBLOBs.getProductId());
        // 插入成功 往队列写入数据 同步信息
        ProductBasicsAppoint.addProductInfoQueue(k2ProductWithBLOBs);

        return new SystemResult(200, "您的商品信息提交成功,请耐心等待系统确认~~~~");
    }

    /**
     * -----------------------------------------------------
     * 功能:  逻辑删除商品信息
     * <p>
     * 参数:
     * productId                Integer          被删除的商品id
     * k2Member                   K2Member       操作的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult delProductInfo(Integer productId, K2MemberAndElseInfo k2Member, Integer state) {

        // 校验商品状态是否正确
        if (state != ProductStateEnum.SJ.getValue() && state != ProductStateEnum.DEL.getValue()
                && state != ProductStateEnum.XJ.getValue())
            return new SystemResult(100, "错误错误错误,请刷新页面重试", null);

        // 查询该商品信息是否存在
        K2ProductWithBLOBs productWithBLOBs = k2ProductMapper.selectByPrimaryKey(productId);
        if (productWithBLOBs == null) return new SystemResult(100, "该商品信息可能已经被删除了哦,请刷新页面重试", null);

        // 校验商品信息
        SystemResult result = ProductBasicsAppoint.checkProductIsUser(productWithBLOBs, k2Member, SYSTEM_ROLE_PROVE);
        if (result.getStatus() != 200) return result;

        // 修改商品在数据库中的数据
        productWithBLOBs.setProductState(state);
        productWithBLOBs.setProductUpdateTime(new Date());
        productWithBLOBs.setProductUpdateUserid(k2Member.getK2Member().getMemberId());
        productWithBLOBs.setProductUpdateUsername(k2Member.getK2Member().getMemberAccount());
        k2ProductMapper.updateByPrimaryKeySelective(productWithBLOBs);

        // 修改成功后 向队列发送同步数据
        ProductBasicsAppoint.addSynchronizedProductGotoCache(productWithBLOBs);
        // 如果是恢复商品的话 需要进行二次审核
        if (state == ProductStateEnum.SJ.getValue()) {
            ProductBasicsAppoint.addProductInfoQueue(productWithBLOBs);
        }

        String message = "";
        if (state == ProductStateEnum.DEL.getValue()) {
            message = "你需要删除的商品信息已经提交,请等待系统确认";
        } else if (state == ProductStateEnum.SJ.getValue()) {
            message = "你需要恢复的商品信息已经提交,请等待系统确认。";
        } else {
            message = "你需要下架的商品信息已经提交,请等待系统确认。";
        }
        return new SystemResult(message);
    }
}
