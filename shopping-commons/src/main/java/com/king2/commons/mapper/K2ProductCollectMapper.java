package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ProductCollect;
import com.king2.commons.pojo.K2ProductCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ProductCollectMapper {
    int countByExample(K2ProductCollectExample example);

    int deleteByExample(K2ProductCollectExample example);

    int deleteByPrimaryKey(Integer productCollectId);

    int insert(K2ProductCollect record);

    int insertSelective(K2ProductCollect record);

    List<K2ProductCollect> selectByExample(K2ProductCollectExample example);

    K2ProductCollect selectByPrimaryKey(Integer productCollectId);

    int updateByExampleSelective(@Param("record") K2ProductCollect record, @Param("example") K2ProductCollectExample example);

    int updateByExample(@Param("record") K2ProductCollect record, @Param("example") K2ProductCollectExample example);

    int updateByPrimaryKeySelective(K2ProductCollect record);

    int updateByPrimaryKey(K2ProductCollect record);
}