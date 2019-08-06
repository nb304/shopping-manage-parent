package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ProductSkuPriceandkc;
import com.king2.commons.pojo.K2ProductSkuPriceandkcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ProductSkuPriceandkcMapper {
    int countByExample(K2ProductSkuPriceandkcExample example);

    int deleteByExample(K2ProductSkuPriceandkcExample example);

    int deleteByPrimaryKey(Integer skuPriceandkcId);

    int insert(K2ProductSkuPriceandkc record);

    int insertSelective(K2ProductSkuPriceandkc record);

    List<K2ProductSkuPriceandkc> selectByExampleWithBLOBs(K2ProductSkuPriceandkcExample example);

    List<K2ProductSkuPriceandkc> selectByExample(K2ProductSkuPriceandkcExample example);

    K2ProductSkuPriceandkc selectByPrimaryKey(Integer skuPriceandkcId);

    int updateByExampleSelective(@Param("record") K2ProductSkuPriceandkc record, @Param("example") K2ProductSkuPriceandkcExample example);

    int updateByExampleWithBLOBs(@Param("record") K2ProductSkuPriceandkc record, @Param("example") K2ProductSkuPriceandkcExample example);

    int updateByExample(@Param("record") K2ProductSkuPriceandkc record, @Param("example") K2ProductSkuPriceandkcExample example);

    int updateByPrimaryKeySelective(K2ProductSkuPriceandkc record);

    int updateByPrimaryKeyWithBLOBs(K2ProductSkuPriceandkc record);

    int updateByPrimaryKey(K2ProductSkuPriceandkc record);
}