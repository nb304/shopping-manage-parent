package com.king2.product.server.appoint.check;


import com.king2.commons.pojo.K2Product;
import com.king2.commons.pojo.K2ProductSkuKey;
import com.king2.commons.pojo.K2ProductSpu;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.utils.JsonUtils;
import com.king2.product.server.dto.AddProductDto;
import com.king2.product.server.dto.ProductSkuDto;
import com.king2.product.server.enmu.K2ProductSkuKeyEnum;
import com.king2.product.server.enmu.ProductEnum;
import com.king2.product.server.enmu.ProductSpuEnum;
import com.king2.product.server.enmu.ProductStateEnum;
import com.king2.product.server.exception.CheckValueException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/*=======================================================
	说明:    商品添加校验数据管理类

	作者		时间					注释
  	俞烨		2019.09.29   			创建
=======================================================*/
public class CheckProductInfoManage {

    /**
     * -----------------------------------------------------
     * 功能:  校验商品的类目信息是否正确
     * <p>
     * 参数:
     * productDto         AddProductDto         需要判断的商品信息
     * product            K2ProductWithBLOBs    最终操作的商品数据
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public static void checkProductCategoryInfo(AddProductDto productDto, K2ProductWithBLOBs product)
            throws CheckValueException {
        // 判断类目是否正确
        String[] categortArr = {};
        if (StringUtils.isEmpty(productDto.getProductCategory()) || productDto.getProductCategory().split(",").length != 2) {
            throw new CheckValueException("商品的类目信息错误,请重新选择");
        } else {
            categortArr = productDto.getProductCategory().split(",");
        }
        for (String s : categortArr) {
            // 判断类目信息是否是数字
            if (StringUtils.isEmpty(s) || !s.matches("[0-9]{1,}")) {
                throw new CheckValueException("商品的类目信息错误,请重新选择");
            }
        }

        // 类目信息正确
        product.setProductOneCategoryId(Integer.parseInt(categortArr[0]));
        product.setProductTwoCategoryId(Integer.parseInt(categortArr[1]));
    }

    /**
     * -----------------------------------------------------
     * 功能:  校验商品的其他信息
     * <p>
     * 参数:
     * productDto         AddProductDto         需要判断的商品信息
     * product            K2ProductWithBLOBs    最终操作的商品数据
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public static void checkProductElseInfo(AddProductDto productDto, K2ProductWithBLOBs productWithBLOBs) throws CheckValueException {

        // 校验商品卖点
        if (!StringUtils.isEmpty(productDto.getProductPoints()) && (productDto.getProductPoints().length() > 200 || productDto.getProductPoints().length() < 10)) {
            throw new CheckValueException("商品卖点的字符长度在10~200之间");
        }

        // 判断是否支持退货
        if (productDto.getProductIfSupport() != 1 && productDto.getProductIfSupport() != 2) {
            throw new CheckValueException("请选择是否支持退款");
        } else if (productDto.getProductIfSupport() == 1 && StringUtils.isEmpty(productDto.getProductSupportDay() + "")) {
            throw new CheckValueException("请选择无理由退货退款的天数");
        }


        // 商品的信息到这里就已经结束了 我们需要将请求域中的数据 存入到我们的ProductInfo对象中去
        productWithBLOBs.setProductName(productDto.getProductName());
        productWithBLOBs.setProductBrandId(productDto.getProductBrandId());
        productWithBLOBs.setProductSystemPrice(productDto.getProductSystemPrice());
        productWithBLOBs.setProductBazaarPrice(productDto.getProductBazaarPrice());
        productWithBLOBs.setProductPoints(productDto.getProductPoints());
        productWithBLOBs.setProductUnit(productDto.getProductUnit());
        productWithBLOBs.setProductSketchContent(productDto.getProductSketchContent());
        productWithBLOBs.setProductIfSupport(productDto.getProductIfSupport());
        productWithBLOBs.setProductSupportDay(productDto.getProductSupportDay());
        productWithBLOBs.setProductState(ProductStateEnum.SH.getValue());
        productWithBLOBs.setProductCreateTime(new Date());
        productWithBLOBs.setProductOrderRule(productDto.getProductOrderRule());
    }

    /**
     * -----------------------------------------------------
     * 功能:  校验商品的SPU信息是否正确 如果正确就返回商品的SPU集合列表
     * <p>
     * 参数:
     * productDto         AddProductDto         需要判断的商品信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public static List<K2ProductSpu> checkProductSpuJsonReturnSpuInfoLists(AddProductDto productDto) throws CheckValueException {

        // 判断商品的SPU信息是否为空
        if (StringUtils.isEmpty(productDto.getProductSpu())) {
            throw new CheckValueException("商品的参数信息不能为空");
        }
        productDto.setProductSpu(productDto.getProductSpu().replaceAll("\\\\", ""));
        // 不为空就将信息转换成集合
        List<ProductSpuInfo> productSpuInfos = null;
        try {
            productSpuInfos = JsonUtils.jsonToList(productDto.getProductSpu(), ProductSpuInfo.class);
            if (CollectionUtils.isEmpty(productSpuInfos)) {
                throw new CheckValueException("商品的参数信息不能为空");
            }
        } catch (Exception e) {
            throw new CheckValueException("商品的参数信息转换错误,请稍后重试.");
        }

        // 遍历商品的SPU信息 并校验
        List<K2ProductSpu> spus = new ArrayList<>();
        int count = 0;
        for (ProductSpuInfo productSpuInfo : productSpuInfos) {
            // 判断数据
            if (StringUtils.isEmpty(productSpuInfo.getProductSpuName()) || productSpuInfo.getProductSpuName().length() > 20) {
                throw new CheckValueException("商品参数的名称字符长度为1-20之间");
            } else if (StringUtils.isEmpty(productSpuInfo.getProductSpuValue()) || productSpuInfo.getProductSpuValue().length() > 100) {
                throw new CheckValueException("商品参数的值字符长度为1-100之间");
            }
            K2ProductSpu spu = new K2ProductSpu();
            spu.setCreateTime(new Date());
            spu.setProductSpuName(productSpuInfo.getProductSpuName());
            spu.setProductSpuValue(productSpuInfo.getProductSpuValue());
            spu.setProductSpuOrder(count++);
            spu.setProductSpuState(ProductSpuEnum.SYZ.getValue());
            spus.add(spu);
        }
        return spus;
    }


    /**
     * -----------------------------------------------------
     * 功能:  校验商品的SKU信息是否正确 如果正确就返回商品的SKU集合列表
     * <p>
     * 参数:
     * productDto         AddProductDto         需要判断的商品信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public static List<ProductSkuDto> checkProductSkuJsonReturnSkuInfoLists(AddProductDto productDto) throws CheckValueException {
        // 判断商品的SPU信息是否为空
        if (StringUtils.isEmpty(productDto.getProductSpu())) {
            throw new CheckValueException("商品的参数信息不能为空");
        }
        productDto.setProductSku(productDto.getProductSku().replaceAll("\\\\", ""));
        // 不为空就将信息转换成集合
        List<ProductSkuInfo> productSkuInfos = null;
        try {
            productSkuInfos = JsonUtils.jsonToList(productDto.getProductSku(), ProductSkuInfo.class);
            if (CollectionUtils.isEmpty(productSkuInfos)) {
                throw new CheckValueException("商品的配置信息不能为空");
            }
        } catch (Exception e) {
            throw new CheckValueException("商品的配置信息转换错误,请稍后重试.");
        }

        List<ProductSkuDto> skuDtos = new ArrayList<>();
        for (int i = 0; i < productSkuInfos.size(); i++) {
            ProductSkuInfo productSkuInfo = productSkuInfos.get(i);
            if (StringUtils.isEmpty(productSkuInfo.getProductSkuName()) || productSkuInfo.getProductSkuName().length() > 20) {
                throw new CheckValueException("商品配置的名称字符长度为1-20之间");
            } else if (StringUtils.isEmpty(productSkuInfo.getProductSkuValue())) {
                throw new CheckValueException("商品配置的值不能为空");
            }
            // 校验商品的SKU参数
            ProductSkuDto skuDto = new ProductSkuDto();
            skuDto.setProduct_sku_value(productSkuInfo.getProductSkuValue());
            skuDto.setSkuKeyOrder(i);
            skuDto.setProductSkuKeyName(productSkuInfo.getProductSkuName());
            skuDto.setSkuKeyState(K2ProductSkuKeyEnum.ZCSY.getValue());
            skuDto.setCreateTime(new Date());
            skuDto.setIsSystemCreate(K2ProductSkuKeyEnum.SYSTEM_FLAG_NO.getValue());
            skuDtos.add(skuDto);
        }
        return skuDtos;
    }

}

// 商品的Spu信息
class ProductSpuInfo {
    private String productSpuName;
    private String productSpuValue;

    public String getProductSpuName() {
        return productSpuName;
    }

    public void setProductSpuName(String productSpuName) {
        this.productSpuName = productSpuName;
    }

    public String getProductSpuValue() {
        return productSpuValue;
    }

    public void setProductSpuValue(String productSpuValue) {
        this.productSpuValue = productSpuValue;
    }
}

// 商品的SKU信息
class ProductSkuInfo {
    private String productSkuName;
    private String productSkuValue;

    public String getProductSkuName() {
        return productSkuName;
    }

    public void setProductSkuName(String productSkuName) {
        this.productSkuName = productSkuName;
    }

    public String getProductSkuValue() {
        return productSkuValue;
    }

    public void setProductSkuValue(String productSkuValue) {
        this.productSkuValue = productSkuValue;
    }
}
