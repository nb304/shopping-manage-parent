package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ProductSkuValue;
import com.king2.commons.pojo.K2ProductSkuValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ProductSkuValueMapper {
    int countByExample(K2ProductSkuValueExample example);

    int deleteByExample(K2ProductSkuValueExample example);

    int deleteByPrimaryKey(Integer productSkuValueId);

    int insert(K2ProductSkuValue record);

    int insertSelective(K2ProductSkuValue record);

    List<K2ProductSkuValue> selectByExample(K2ProductSkuValueExample example);

    K2ProductSkuValue selectByPrimaryKey(Integer productSkuValueId);

    int updateByExampleSelective(@Param("record") K2ProductSkuValue record, @Param("example") K2ProductSkuValueExample example);

    int updateByExample(@Param("record") K2ProductSkuValue record, @Param("example") K2ProductSkuValueExample example);

    int updateByPrimaryKeySelective(K2ProductSkuValue record);

    int updateByPrimaryKey(K2ProductSkuValue record);
}