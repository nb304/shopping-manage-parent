package com.king2.product.server.mapper;

import com.king2.commons.pojo.K2ProductBrand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品品牌管理Mapper
 */
public interface BrandManageMapper {

    /**
     * 根据店铺id查询店铺条数
     *
     * @param storeId
     * @return
     */
    @Select("<script>" +
            "SELECT COUNT(*) FROM k2_product_brand" +
            "<where>" +
            "<if test='storeId != null'>" +
            "brand_store_id = #{storeId} " +
            "</if>" +
            "<if test='brandName != null'>" +
            "AND brand_name LIKE #{brandName}" +
            "</if>" +
            "</where>" +
            "</script>")
    Integer selectCount(@Param("storeId") Integer storeId, @Param("brandName") String brandName);

    /**
     * 获取分页数据
     *
     * @param storeId
     * @param index
     * @param currentSize
     * @return
     */
    @Select("<script>" +
            "SELECT * FROM k2_product_brand" +
            "<where>" +
            "<if test='storeId != null'>" +
            "brand_store_id = #{storeId} " +
            "</if>" +
            "<if test='brandName != null'>" +
            "AND brand_name LIKE #{brandName}" +
            "</if>" +
            "</where>" +
            "ORDER BY brand_update_time DESC LIMIT #{index} , #{currentSize}" +
            "</script>")
    List<K2ProductBrand> getBrands(@Param("storeId") Integer storeId,
                                   @Param("index") Integer index,
                                   @Param("currentSize") Integer currentSize,
                                   @Param("brandName") String brandName);
}
