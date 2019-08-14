package com.king2.product.server.mapper;

import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.product.server.dto.ProductInfoToRedisDataDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品管理Mapper接口
 */
public interface ProductManageMapper {


    /**
     * 查询商品信息
     *
     * @param storeId     店铺id
     * @param state       商品状态
     * @param index       起始索引
     * @param maxTotal    查几条
     * @param kc          库存大于几条的
     * @param productName 商品名称
     * @return
     */
    @Select("<script>" +
            "SELECT " +
            "p.`product_id`,p.`product_name` ,s.`stroe_name` belong_store_name, " +
            "p.`product_state`,p.`product_create_userid`, p.`product_update_username`, " +
            "p.`product_update_userid`,p.`product_number` ,pb.`brand_name`, " +
            "p.`product_create_username`, SUM(kc.`product_sku_kc`) total_kc " +
            "FROM " +
            "k2_product p , k2_product_sku_priceandkc kc , k2_product_brand pb , k2_stroe s " +
            "WHERE " +
            "p.`product_id` = kc.`belong_product_id` AND " +
            "p.`product_brand_id` = pb.`brand_id` AND " +
            "p.`product_store_id` =  #{storeId} " +
            "<if test='state != null and state != 0'>" +
            "AND p.product_state = #{state} " +
            "</if>" +
            "<if test='productName != null'>" +
            "AND p.`product_name` like #{productName} " +
            "</if>" +
            "GROUP BY p.`product_id` " +
            "<if test='kc != null'>" +
            "HAVING total_kc &gt; #{kc} " +
            "</if>" +
            "ORDER BY product_update_time DESC " +
            "LIMIT #{index} , #{maxTotal}" +
            "</script>")
    List<ProductInfoToRedisDataDto> getProductByStoreId(@Param("storeId") Integer storeId, @Param("state") Integer state, @Param("index") Integer index,
                                                        @Param("maxTotal") Integer maxTotal, @Param("kc") Integer kc, @Param("productName") String productName);

    /**
     * 查询该店铺的商品有几条
     *
     * @param storeId 店铺id
     * @return
     */
    @Select("SELECT COUNT(*) FROM k2_product WHERE product_store_id = #{storeId}")
    Integer getProductCountByStoreId(Integer storeId);
}
