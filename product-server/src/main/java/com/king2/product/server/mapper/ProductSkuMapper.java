package com.king2.product.server.mapper;

import com.king2.commons.pojo.K2ProductCommonskus;
import com.king2.commons.pojo.K2ProductSkuKey;
import com.king2.commons.pojo.K2ProductSkuPriceandkc;
import com.king2.commons.pojo.K2ProductSkuValue;
import com.king2.product.server.dto.ProductSkuDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*=======================================================
	˵��:    ��ƷSKU-key Mapper�ӿ�

	����		ʱ��					ע��
  	����		2019.08.07   			����
=======================================================*/
public interface ProductSkuMapper {


    /**
     * -----------------------------------------------------
     * ����:  �������Sku-key������
     * <p>
     * ����:
     * productSkuDtos          List<ProductSkuDto>            SKUPOJO�����ݼ���
     * <p>
     * ����: void
     * -----------------------------------------------------
     */
    @Insert("<script>" +
            "INSERT INTO k2_product_sku_key(`product_sku_key_name`,`belong_product_id`,`belong_category_id`" +
            ",`is_system_create`,`create_userid`,`belong_store_id`,`sku_key_state`,`create_time`,`sku_key_order`)" +
            "VALUES" +
            "<foreach collection='list' item='item' separator=','>" +
            "<if test='item.isSystemCreate != 1'>" +
            "(#{item.productSkuKeyName},#{item.belongProductId},#{item.belongCategoryId},#{item.isSystemCreate}," +
            "#{item.createUserid},#{item.belongStoreId},#{item.skuKeyState},#{item.createTime},#{item.skuKeyOrder})" +
            "</if>" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "productSkuKeyId")
    void batchInsertSkuKey(@Param("list") List<ProductSkuDto> productSkuDtos);

    /**
     * -----------------------------------------------------
     * ����:  �������Sku-value������
     * <p>
     * ����:
     * k2ProductSkuValues          List<K2ProductSkuValue>            SKU-vakue POJO�����ݼ���
     * <p>
     * ����: void
     * -----------------------------------------------------
     */
    @Insert("<script>" +
            "INSERT INTO k2_product_sku_value(sku_value,sku_key_id)" +
            "VALUES" +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.skuValue},#{item.skuKeyId})" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "productSkuValueId")
    void batchInsertSkuValue(@Param("list") List<K2ProductSkuValue> k2ProductSkuValues);


    /**
     * -----------------------------------------------------
     * ����:  ���������Ʒ������SKU����
     * <p>
     * ����:
     * k2ProductCommonskuses          List<K2ProductCommonskus>            ��Ʒ������SKU����
     * <p>
     * ����: void
     * -----------------------------------------------------
     */
    @Insert("<script>" +
            "INSERT INTO k2_product_commonskus(commons_sku_id,product_id)" +
            "VALUES" +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.commonsSkuId},#{item.productId})" +
            "</foreach>" +
            "</script>")
    void batchInsertCommonsSku(@Param("list") List<K2ProductCommonskus> k2ProductCommonskuses);

    /**
     * -----------------------------------------------------
     * ����:  ���������ƷSKU-Value�Ŀ��۸���Ϣ
     * <p>
     * ����:
     * k2ProductSkuPriceandkcs          List<K2ProductSkuPriceandkc>            SKU-vakue�Ŀ��۸�POJO�����ݼ���
     * <p>
     * ����: void
     * -----------------------------------------------------
     */
    @Insert("<script>" +
            "INSERT INTO k2_product_sku_priceandkc(sku_priceandkc_valuelistid,belong_product_id," +
            "product_sku_price,product_sku_kc,product_sku_value_ids)" +
            "VALUES" +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.skuPriceandkcValuelistid},#{item.belongProductId}," +
            "#{item.productSkuPrice},#{item.productSkuKc},#{item.productSkuValueIds})" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "skuPriceandkcId")
    void batchInsertSkuValueKc(@Param("list") List<K2ProductSkuPriceandkc> k2ProductSkuPriceandkcs);

    /**
     * -----------------------------------------------------
     * ����:  ͨ����Ʒ��Ŀ��ѯ��ƷSKU��Ϣ
     * <p>
     * ����:
     * cId          Integer         ��Ʒ��Ŀ��id
     * <p>
     * ����: List<K2ProductSkuKey>        ��Ŀ����
     * -----------------------------------------------------
     */
    @Select("SELECT product_sku_key_id,product_sku_key_name,is_system_create FROM" +
            " k2_product_sku_key WHERE belong_category_id = #{cId} AND retain1 = 1 AND sku_key_state = 1 AND is_system_create = 1")
    List<K2ProductSkuKey> getSkuInfoByCid(Integer cId);

    /**
     * -----------------------------------------------------
     * ����:  ͨ������id��ѯ��ƷSKU��Ϣ
     * <p>
     * ����:
     * cId          Integer         ��Ʒ��Ŀ��id
     * <p>
     * ����: List<K2ProductSkuKey>        ��Ŀ����
     * -----------------------------------------------------
     */
    @Select("SELECT product_sku_key_id,product_sku_key_name,is_system_create FROM" +
            " k2_product_sku_key WHERE belong_category_id = #{cId} AND retain1 = 1 AND sku_key_state = 1 AND belong_store_id = #{storedId} AND is_system_create = 2")
    List<K2ProductSkuKey> getSkuInfoByStoreId(@Param("cId") Integer cId, @Param("storedId") Integer storeId);

    /**
     * �����޸���Ʒ��SKU�������С
     *
     * @param k2ProductSkuPriceandkcs
     */
    @Update("<script>" +
            "<foreach  collection='list' item='item' separator=';'>" +
            "UPDATE k2_product_sku_priceandkc SET product_sku_price = #{item.productSkuPrice} " +
            ", product_sku_kc = #{item.productSkuKc} " +
            "WHERE sku_priceandkc_id = #{item.skuPriceandkcId}" +
            "</foreach>  " +
            "</script>")
    void batchUpdate(@Param("list") List<K2ProductSkuPriceandkc> k2ProductSkuPriceandkcs);
}
