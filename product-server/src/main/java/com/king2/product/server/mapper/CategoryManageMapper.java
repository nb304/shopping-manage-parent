package com.king2.product.server.mapper;

import com.king2.commons.pojo.K2ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品类目Mapper
 */
public interface CategoryManageMapper {

    /**
     * 查询商品类目信息的数量
     *
     * @return
     */
    @Select("<script>" +
            "SELECT COUNT(*) FROM k2_product_category " +
            "WHERE category_parent_id = 0 " +
            "<if test='categoryName != null'>" +
            "AND category_name LIKE #{categoryName} " +
            "</if>" +
            "</script>")
    Integer selectCount(@Param("categoryName") String categoryName);

    /**
     * 查询商品的类目信息
     *
     * @param categoryName
     * @param index
     * @param currentSize
     * @return
     */
    @Select("<script>" +
            "SELECT * FROM k2_product_category " +
            "WHERE category_parent_id = 0 " +
            "<if test='categoryName != null'>" +
            "AND category_name LIKE #{categoryName} " +
            "</if>" +
            "ORDER BY category_create_time DESC LIMIT #{index} , #{currentSize}" +
            "</script>")
    List<K2ProductCategory> getCategory(@Param("categoryName") String categoryName, @Param("index") Integer index,
                                        @Param("currentSize") Integer currentSize);

    /**
     * 根据父类信息查询子类目的信息
     *
     * @param parentId
     * @return
     */
    @Select("SELECT * FROM k2_product_category " +
            "WHERE category_parent_id = #{parentId}")
    List<K2ProductCategory> getCategoryById(Integer parentId);
}
