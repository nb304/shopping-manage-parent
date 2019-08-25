package com.king2.product.server.mapper;

import com.king2.commons.pojo.K2ProductSpu;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/*=======================================================
	说明:    商品SPU Mapper接口

	作者		时间					注释
  	俞烨		2019.08.07   			创建
=======================================================*/
public interface ProductSpuMapper {

    /**
     * -----------------------------------------------------
     * 功能:  批量添加SPU的数据
     * <p>
     * 参数:
     * list          List<K2ProductSpu>             SPU的集合数据
     * <p>
     * 返回: void
     * -----------------------------------------------------
     */
    @Insert("<script>" +
            "INSERT INTO k2_product_spu(product_spu_name,product_spu_value,product_spu_order," +
            "product_spu_state,belong_product_id,create_time) VALUES" +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.productSpuName},#{item.productSpuValue},#{item.productSpuOrder}," +
            "#{item.productSpuState},#{item.belongProductId},#{item.createTime})" +
            "</foreach>" +
            "</script>")
    void batchInsertProductSpu(@Param("list") List<K2ProductSpu> list);

    /**
     * 查询商品SPU的信息根据商品id
     *
     * @param productId
     * @return
     */
    @Select("SELECT " +
            "product_spu_id,product_spu_name,product_spu_value,product_spu_order," +
            "product_spu_state,belong_product_id,create_time " +
            "FROM k2_product_spu WHERE belong_product_id = #{productId} " +
            "ORDER BY product_spu_order ASC")
    List<K2ProductSpu> getSpuByProductId(Integer productId);

    /**
     * 查询最大的排序值
     *
     * @param productId
     * @return
     */
    @Select("SELECT MAX(product_spu_order) FROM k2_product_spu WHERE belong_product_id = #{productId}")
    Integer getMaxOrder(Integer productId);


    /**
     * 根据商品的SPUid查询商品信息
     *
     * @param spuId
     * @return
     */
    @Select("SELECT p.* FROM k2_product_spu spu , k2_product p \n" +
            "WHERE spu.`belong_product_id` = p.`product_id` AND spu.`product_spu_id` = #{spuId} GROUP BY p.`product_id`")
    K2ProductWithBLOBs getProductBySpuId(Integer spuId);
}
