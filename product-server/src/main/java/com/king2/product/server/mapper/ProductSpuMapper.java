package com.king2.product.server.mapper;

import com.king2.commons.pojo.K2ProductSpu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

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
}
