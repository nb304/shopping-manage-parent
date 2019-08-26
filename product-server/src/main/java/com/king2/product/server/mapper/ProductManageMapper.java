package com.king2.product.server.mapper;

import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.product.server.dto.ProductInfoToRedisDataDto;
import com.king2.product.server.dto.ShowEditProductInfoDto;
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
            "SELECT * FROM (" +
            "SELECT " +
            "p.`product_id`,p.`product_name` ,s.`stroe_name` belong_store_name, " +
            "p.`product_state`,p.`product_create_userid`, p.`product_update_username`, " +
            "p.`product_update_userid`,p.`product_number` ,pb.`brand_name`, p.`product_two_category_id`, " +
            "p.`product_create_username`, SUM(kc.`product_sku_kc`) total_kc , pc.`category_name` " +
            "FROM " +
            "k2_product p , k2_product_sku_priceandkc kc , k2_product_brand pb , k2_stroe s ,k2_product_category pc " +
            "WHERE " +
            "#{randomString} =  #{randomString} AND " +
            "p.`product_id` = kc.`belong_product_id` AND " +
            "p.`product_brand_id` = pb.`brand_id` AND " +
            "<if test='storeId != null'>" +
            "p.`product_store_id` =  #{storeId} AND " +
            "</if>" +
            "p.`product_one_category_id` = pc.`category_id` " +
            "<if test='state != null and state != 0'>" +
            "AND p.product_state = #{state} " +
            "</if>" +
            "<if test='productName != null'>" +
            "AND p.`product_name` like #{productName} " +
            "</if>" +
            "<if test='productId != null'>" +
            "AND p.`product_id` = #{productId} " +
            "</if>" +
            "GROUP BY p.`product_id` " +
            "<if test='kc != null'>" +
            "HAVING total_kc &gt; #{kc} " +
            "</if>" +
            "ORDER BY product_update_time DESC " +
            "LIMIT #{index} , #{maxTotal}" +
            ")a1 , " +
            "(" +
            "SELECT pc.`category_id`,pc.`category_name` `twoCateName` FROM k2_product_category pc" +
            ")a2 WHERE a1.`product_two_category_id` = a2.`category_id` " +
            "</script>")
    List<ProductInfoToRedisDataDto> getProductByStoreId(@Param("storeId") Integer storeId, @Param("state") Integer state, @Param("index") Integer index,
                                                        @Param("maxTotal") Integer maxTotal, @Param("kc") Integer kc, @Param("productName") String productName,
                                                        @Param("productId") Integer productId, @Param("randomString") String randomString);

    /**
     * 查询该店铺的商品有几条
     *
     * @param storeId 店铺id
     * @return
     */
    @Select("<script>" +
            "SELECT COUNT(*) FROM k2_product WHERE product_store_id = #{storeId}" +
            "<if test='productName != null'>" +
            "AND `product_name` like #{productName}" +
            "</if>" +
            "<if test='state != null and state != 0'>" +
            "AND product_state = #{state} " +
            "</if>" +
            "</script>")
    Integer getProductCountByStoreId(@Param("storeId") Integer storeId, @Param("productName") String productName, @Param("state") Integer state);

    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    @Select("SELECT p.`product_id`,p.`product_name`,p.`product_brand_id`, \n" +
            "p.`product_bazaar_price` , p.`product_system_price` , " +
            "p.`product_if_support` , p.`product_support_day` ,\n" +
            "p.`product_points` , p.`product_order_rule` , p.`product_unit` , \n" +
            "s.product_sketch_id productSketchId , s.`product_sketch_value` productSketchContentl," +
            "e.next_update_time nextUpdateTime, e.last_update_time lastUpdateTime, \n" +
            "e.last_update_user_naem lastUpdateUserNaem FROM \n" +
            "k2_product p LEFT JOIN k2_product_sketch s \n" +
            "ON p.`product_sketch_id` = s.`product_sketch_id` \n" +
            "LEFT JOIN k2_product_edit_size e \n" +
            "ON p.`product_id` = e.edit_product_id \n" +
            "WHERE p.`product_id` = #{productId} ORDER BY e.last_update_time DESC  LIMIT 0 ,1 ")
    ShowEditProductInfoDto getProductInfoByPId(Integer productId);

    /**
     * 查询商品的图片信息
     *
     * @param productId
     * @return
     */
    @Select("SELECT product_image FROM k2_product WHERE product_id = #{productId}")
    String getProductImageById(Integer productId);
}
