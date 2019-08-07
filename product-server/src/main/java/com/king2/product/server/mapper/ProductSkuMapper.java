package com.king2.product.server.mapper;

import com.king2.commons.pojo.K2ProductSkuValue;
import com.king2.product.server.dto.ProductSkuDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*=======================================================
	说明:    商品SKU-key Mapper接口

	作者		时间					注释
  	俞烨		2019.08.07   			创建
=======================================================*/
public interface ProductSkuMapper {


    /**
     * -----------------------------------------------------
     * 功能:  批量添加Sku-key的数据
     * <p>
     * 参数:
     * productSkuDtos          List<ProductSkuDto>            SKUPOJO的数据集合
     * <p>
     * 返回: void
     * -----------------------------------------------------
     */
    @Insert("<script>" +
            "INSERT INTO k2_product_sku_key(`product_sku_key_name`,`belong_product_id`,`belong_category_id`" +
            ",`is_system_create`,`create_userid`,`belong_store_id`,`sku_key_state`,`create_time`,`sku_key_order`)" +
            "VALUES" +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.productSkuKeyName},#{item.belongProductId},#{item.belongCategoryId},#{item.isSystemCreate}," +
            "#{item.createUserid},#{item.belongStoreId},#{item.skuKeyState},#{item.createTime},#{item.skuKeyOrder})" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "productSkuKeyId")
    void batchInsertSkuKey(@Param("list") List<ProductSkuDto> productSkuDtos);

    /**
     * -----------------------------------------------------
     * 功能:  批量添加Sku-value的数据
     * <p>
     * 参数:
     * k2ProductSkuValues          List<K2ProductSkuValue>            SKU-vakue POJO的数据集合
     * <p>
     * 返回: void
     * -----------------------------------------------------
     */
    @Insert("<script>" +
            "INSERT INTO k2_product_sku_key(sku_value,sku_key_id)" +
            "VALUES" +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.skuValue},#{item.skuKeyId})" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "productSkuValueId")
    void batchInsertSkuValue(@Param("list") List<K2ProductSkuValue> k2ProductSkuValues);
}
