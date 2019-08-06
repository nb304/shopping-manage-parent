package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ProductSpu;
import com.king2.commons.pojo.K2ProductSpuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ProductSpuMapper {
    int countByExample(K2ProductSpuExample example);

    int deleteByExample(K2ProductSpuExample example);

    int deleteByPrimaryKey(Integer productSpuId);

    int insert(K2ProductSpu record);

    int insertSelective(K2ProductSpu record);

    List<K2ProductSpu> selectByExample(K2ProductSpuExample example);

    K2ProductSpu selectByPrimaryKey(Integer productSpuId);

    int updateByExampleSelective(@Param("record") K2ProductSpu record, @Param("example") K2ProductSpuExample example);

    int updateByExample(@Param("record") K2ProductSpu record, @Param("example") K2ProductSpuExample example);

    int updateByPrimaryKeySelective(K2ProductSpu record);

    int updateByPrimaryKey(K2ProductSpu record);
}