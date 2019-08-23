package com.king2.product.server.appoint;

import com.king2.commons.mapper.K2ProductSkuKeyMapper;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.mapper.ProductSkuMapper;
import com.king2.product.server.pojo.ProductSkuPojo;
import com.king2.product.server.dto.ProductSkuDto;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/*=======================================================
	说明:    商品SKU管理委派类

	作者		时间					注释
  	俞烨		2019.08.07   			创建
=======================================================*/
@Component
public class ProductSkuAppoint {


    /**
     * -----------------------------------------------------
     * 功能:  根据pojos获取对应的商品SKU集合信息并添加数据
     * <p>
     * 参数:
     * productSkuPojos          List<ProductSkuPojo>            SKUPOJO的数据集合
     * k2Member                 K2Member                        操作的人员
     * k2Product                K2ProductWithBLOBs              商品信息
     * <p>
     * 返回: UserManageUtil              返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult addProductSkuKeyInfos(List<ProductSkuPojo> productSkuPojos, K2Member k2Member, K2ProductWithBLOBs k2ProductWithBLOBs,
                                                     ProductSkuMapper productSkuKeyMapper, K2ProductSkuKeyMapper k2ProductSkuKeyMapper) {

        // 判断Pojo是否有数据
        if (CollectionUtils.isEmpty(productSkuPojos)) return new SystemResult(100, "请填写商品SKU的信息", null);
        // 根据集合获取商品Sku集合数据
        SystemResult systemResult = forEachPojosReturnSkuLists(productSkuPojos, k2ProductWithBLOBs, k2Member, productSkuKeyMapper, k2ProductSkuKeyMapper);
        if (systemResult.getStatus() != 200) return systemResult;

        // 添加商品sku
        ProductSkuDatas data = (ProductSkuDatas) systemResult.getData();
        SystemResult addProductSkuKey = addProductSkuKey(data, productSkuKeyMapper);

        return addProductSkuKey;
    }


    /**
     * -----------------------------------------------------
     * 功能:   添加商品sku-key信息 并返回SKU——VALUE的数据
     * <p>
     * 参数:
     * productSkuPojos          List<ProductSkuPojo>            SKUPOJO的数据集合
     * productSkuKeyMapper      ProductSkuKeyMapper             商品Sku-key的Mapper接口实例
     * <p>
     * 返回: UserManageUtil              返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult addProductSkuKey(ProductSkuDatas productSkuDatas, ProductSkuMapper productSkuKeyMapper) {
        // 添加商品sku-key的信息
        if (!CollectionUtils.isEmpty(productSkuDatas.getUserCreateSkus()))
            productSkuKeyMapper.batchInsertSkuKey(productSkuDatas.getUserCreateSkus());

        // 添加成功后创建该sku-key的值数据
        // 添加成功 ， 将两个集合合并并排序
        productSkuDatas.getUserCreateSkus().addAll(productSkuDatas.getSystemCreateSKus());
        // 进行排序
        Collections.sort(productSkuDatas.getUserCreateSkus());

        // 创建SKUValue的返回数据
        List<K2ProductSkuValue> k2ProductSkuValues = new ArrayList<>();
        for (ProductSkuDto productSkuDto : productSkuDatas.getUserCreateSkus()) {
            // 获取到当前sku-key的value信息
            if (!StringUtils.isEmpty(productSkuDto.getProduct_sku_value())) {
                String[] split = productSkuDto.getProduct_sku_value().split(",");
                for (String s : split) {
                    K2ProductSkuValue value = new K2ProductSkuValue();
                    value.setSkuValue(s);
                    value.setSkuKeyId(productSkuDto.getProductSkuKeyId());
                    k2ProductSkuValues.add(value);
                }
            }

        }
        return new SystemResult(k2ProductSkuValues);
    }


    /**
     * -----------------------------------------------------
     * 功能:  根据pojos获取对应的商品SKU集合信息2
     * <p>
     * 参数:
     * productSkuPojos          List<ProductSkuPojo>            SKUPOJO的数据集合
     * k2Member                 K2Member                        操作的人员
     * k2Product                K2ProductWithBLOBs              商品信息
     * <p>
     * 返回: UserManageUtil              返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult forEachPojosReturnSkuLists(List<ProductSkuPojo> productSkuPojos, K2ProductWithBLOBs k2Product,
                                                          K2Member k2Member, ProductSkuMapper productSkuKeyMapper, K2ProductSkuKeyMapper k2ProductSkuKeyMapper) {

        // 创建SKU返回值
        List<ProductSkuDto> productSkuDtos = new ArrayList<>();
        // 创建系统定义好的SKU信息
        List<ProductSkuDto> systemProductSkuDtos = new ArrayList<>();
        // 创建SKU公共商品信息集合
        List<K2ProductCommonskus> k2ProductCommonskuses = new ArrayList<K2ProductCommonskus>();
        // 遍历POJO信息封装SKU参数
        // 定义count;
        int count = 0;
        for (ProductSkuPojo productSkuPojo : productSkuPojos) {
            // 查看
            // 校验数据如果校验成功则返回SKU数据
            ProductSkuDto dto = new ProductSkuDto();
            // 校验SKU名称
            if (StringUtils.isEmpty(productSkuPojo.getProductSkuKeyName()) || productSkuPojo.getProductSkuKeyName().length() > 50) {
                return new SystemResult(100, "sku的key过长，范围在1~50字", null);
            }
            // 校验SKU的Value
            if (StringUtils.isEmpty(productSkuPojo.getSkuValue())) {
                return new SystemResult(100, "sku的值不能为空", null);
            }

            // 判断是否是系统创建
            if (productSkuPojo.isSystemDef()) {
                // 是系统创建  就要添加商品信息对应的SKU公共表的信息
                if (StringUtils.isEmpty(productSkuPojo.getProductSkuKeyId()) || !productSkuPojo.getProductSkuKeyId().matches("[0-9]{1,}")) {
                    // 系统创建的SKU信息错误
                    return new SystemResult(100, "系统创建的SKU信息错误", null);
                }

                // 查看该SKU信息是否为空
                K2ProductSkuKey productSkuKey = k2ProductSkuKeyMapper.selectByPrimaryKey(Integer.parseInt(productSkuPojo.getProductSkuKeyId()));
                if (productSkuKey == null || productSkuKey.getSkuKeyState() != 1)
                    return new SystemResult(100, "加载失败，请刷新页面重试", null);

                // 补全公共信息数据
                K2ProductCommonskus commonskus = new K2ProductCommonskus();
                commonskus.setCommonsSkuId(Integer.parseInt(productSkuPojo.getProductSkuKeyId()));
                commonskus.setProductId(k2Product.getProductId());
                k2ProductCommonskuses.add(commonskus);
                // 本次公共的SKU值信息
                dto.setIsSystemCreate(1);
                dto.setProduct_sku_value(productSkuPojo.getSkuValue());
                dto.setSkuKeyOrder(productSkuKey.getSkuKeyOrder());
                dto.setProductSkuKeyId(productSkuKey.getProductSkuKeyId());
                systemProductSkuDtos.add(dto);
                continue;
            }

            // 补全数据
            dto.setProduct_sku_value(productSkuPojo.getSkuValue());
            dto.setProductSkuKeyName(productSkuPojo.getProductSkuKeyName());
            dto.setBelongProductId(k2Product.getProductId());
            dto.setBelongCategoryId(k2Product.getProductTwoCategoryId());
            // 是否是系统创建的  ---1是 2否
            dto.setIsSystemCreate(2);
            dto.setCreateUserid(k2Member.getMemberId());
            dto.setCreateTime(new Date());
            dto.setBelongStoreId(Integer.parseInt(k2Member.getRetain1()));
            dto.setSkuKeyOrder(++count);
            //SKU组的状态  ---1正常使用 2删除 3注销
            dto.setSkuKeyState(1);
            productSkuDtos.add(dto);
        }
        // 遍历完成 批量添加公共的SKU数据
        if(!CollectionUtils.isEmpty(k2ProductCommonskuses)) productSkuKeyMapper.batchInsertCommonsSku(k2ProductCommonskuses);

        // 将数据封装进对象中
        ProductSkuDatas skuDatas = new ProductSkuDatas();
        skuDatas.setSystemCreateSKus(systemProductSkuDtos);
        skuDatas.setUserCreateSkus(productSkuDtos);

        return new SystemResult(skuDatas);
    }

}

class ProductSkuDatas {

    private List<ProductSkuDto> userCreateSkus = new ArrayList<>();

    private List<ProductSkuDto> systemCreateSKus;

    public List<ProductSkuDto> getUserCreateSkus() {
        return userCreateSkus;
    }

    public void setUserCreateSkus(List<ProductSkuDto> userCreateSkus) {
        this.userCreateSkus = userCreateSkus;
    }

    public List<ProductSkuDto> getSystemCreateSKus() {
        return systemCreateSKus;
    }

    public void setSystemCreateSKus(List<ProductSkuDto> systemCreateSKus) {
        this.systemCreateSKus = systemCreateSKus;
    }
}
