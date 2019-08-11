package com.king2.product.server.mapper;

import com.king2.commons.pojo.K2ProductWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品管理Mapper接口
 */
public interface ProductManageMapper {


    @Select("SELECT" +
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
            "<if test='state != null'>" +
            "AND p.product_state = #{state} " +
            "</if>" +
            "<if test='productName != null AND productName != '''>" +
            "AND p.`product_name` " +
            "</if>" +
            "GROUP BY p.`product_id` " +
            "HAVING total_kc > 20 " +
            "LIMIT 0 , #{maxTotal}")
    List<K2ProductWithBLOBs> getProductByStoreId(@Param("storeId") Integer storeId, @Param("state") Integer state,
                                                 Integer maxTotal, Integer kc, String productName);
}
