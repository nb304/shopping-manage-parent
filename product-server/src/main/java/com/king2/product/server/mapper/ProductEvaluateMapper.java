package com.king2.product.server.mapper;

import com.king2.commons.pojo.K2ProductEvaluate;
import com.king2.commons.pojo.K2ProductEvaluateWithBLOBs;
import com.king2.product.server.pojo.ProductEvaluatePojo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * 商品评价Mapper
 */
public interface ProductEvaluateMapper {


    /**
     * 查询商品评价数量
     *
     * @param orderNumber
     * @param productEvaluateUsername
     * @param productEvaluateState
     * @param startTime
     * @param endTime
     * @param storeId
     * @return
     */
    @Select("<script>" +
            "SELECT COUNT(*) FROM k2_product_evaluate " +
            "<where>" +
            "<if test='orderNumber != null'>" +
            "order_number = #{orderNumber} " +
            "</if>" +
            "<if test='productEvaluateUsername != null'>" +
            "AND product_evaluate_username = #{productEvaluateUsername} " +
            "</if>" +
            "<if test='productEvaluateState != null'>" +
            "AND product_evaluate_state = #{productEvaluateState} " +
            "</if>" +
            "<if test='startTime != null'>" +
            "AND create_time &gt;= #{startTime} " +
            "</if>" +
            "<if test='endTime != null'>" +
            "AND create_time &lt;= #{endTime} " +
            "</if>" +
            "<if test='storeId != null'>" +
            "AND belong_store_id = #{storeId} " +
            "</if>" +
            "</where>" +
            "</script>")
    int getProductEvaluateSize(@Param("orderNumber") String orderNumber, @Param("productEvaluateUsername") String productEvaluateUsername,
                               @Param("productEvaluateState") Integer productEvaluateState,
                               @Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("storeId") Integer storeId);

    /**
     * 查询商品评价集合
     *
     * @param orderNumber
     * @param productEvaluateUsername
     * @param productEvaluateState
     * @param startTime
     * @param endTime
     * @param storeId
     * @return
     */
    @Select("<script>" +
            "SELECT " +
            " e.* , m.`member_portrait` image , m.`member_name` uName , p.`product_name` pName , p.`product_image` pImage " +
            " FROM k2_product_evaluate e , k2_member m  , k2_product p " +
            "WHERE e.`product_evaluate_userid` = m.`member_id` AND e.`belong_product_id` = p.`product_id` " +
            "<if test='orderNumber != null'>" +
            "AND e.order_number = #{orderNumber} " +
            "</if>" +
            "<if test='productEvaluateUsername != null'>" +
            "AND e.product_evaluate_username = #{productEvaluateUsername} " +
            "</if>" +
            "<if test='productEvaluateState != null'>" +
            "AND e.product_evaluate_state = #{productEvaluateState} " +
            "</if>" +
            "<if test='startTime != null'>" +
            "AND e.create_time  &gt;= #{startTime} " +
            "</if>" +
            "<if test='endTime != null'>" +
            "AND e.create_time &lt;= #{endTime} " +
            "</if>" +
            "<if test='storeId != null'>" +
            "AND e.belong_store_id = #{storeId} " +
            "</if>" +
            " ORDER BY e.create_time DESC LIMIT #{index} , #{currentSize}" +
            "</script>")
    List<ProductEvaluatePojo> getProductEvaluateList(@Param("orderNumber") String orderNumber, @Param("productEvaluateUsername") String productEvaluateUsername,
                                                     @Param("productEvaluateState") Integer productEvaluateState,
                                                     @Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("storeId") Integer storeId,
                                                     @Param("index") Integer index, @Param("currentSize") Integer currentSize);
}
