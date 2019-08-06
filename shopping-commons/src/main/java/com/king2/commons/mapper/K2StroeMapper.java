package com.king2.commons.mapper;

import com.king2.commons.pojo.K2Stroe;
import com.king2.commons.pojo.K2StroeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2StroeMapper {
    int countByExample(K2StroeExample example);

    int deleteByExample(K2StroeExample example);

    int deleteByPrimaryKey(Integer stroeId);

    int insert(K2Stroe record);

    int insertSelective(K2Stroe record);

    List<K2Stroe> selectByExample(K2StroeExample example);

    K2Stroe selectByPrimaryKey(Integer stroeId);

    int updateByExampleSelective(@Param("record") K2Stroe record, @Param("example") K2StroeExample example);

    int updateByExample(@Param("record") K2Stroe record, @Param("example") K2StroeExample example);

    int updateByPrimaryKeySelective(K2Stroe record);

    int updateByPrimaryKey(K2Stroe record);
}