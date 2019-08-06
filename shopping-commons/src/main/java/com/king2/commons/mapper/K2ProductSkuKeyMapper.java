package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ProductSkuKey;
import com.king2.commons.pojo.K2ProductSkuKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ProductSkuKeyMapper {
    int countByExample(K2ProductSkuKeyExample example);

    int deleteByExample(K2ProductSkuKeyExample example);

    int deleteByPrimaryKey(Integer productSkuKeyId);

    int insert(K2ProductSkuKey record);

    int insertSelective(K2ProductSkuKey record);

    List<K2ProductSkuKey> selectByExample(K2ProductSkuKeyExample example);

    K2ProductSkuKey selectByPrimaryKey(Integer productSkuKeyId);

    int updateByExampleSelective(@Param("record") K2ProductSkuKey record, @Param("example") K2ProductSkuKeyExample example);

    int updateByExample(@Param("record") K2ProductSkuKey record, @Param("example") K2ProductSkuKeyExample example);

    int updateByPrimaryKeySelective(K2ProductSkuKey record);

    int updateByPrimaryKey(K2ProductSkuKey record);
}