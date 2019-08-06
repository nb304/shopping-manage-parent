package com.king2.commons.mapper;

import com.king2.commons.pojo.K2OrderLogistics;
import com.king2.commons.pojo.K2OrderLogisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2OrderLogisticsMapper {
    int countByExample(K2OrderLogisticsExample example);

    int deleteByExample(K2OrderLogisticsExample example);

    int deleteByPrimaryKey(Integer olId);

    int insert(K2OrderLogistics record);

    int insertSelective(K2OrderLogistics record);

    List<K2OrderLogistics> selectByExampleWithBLOBs(K2OrderLogisticsExample example);

    List<K2OrderLogistics> selectByExample(K2OrderLogisticsExample example);

    K2OrderLogistics selectByPrimaryKey(Integer olId);

    int updateByExampleSelective(@Param("record") K2OrderLogistics record, @Param("example") K2OrderLogisticsExample example);

    int updateByExampleWithBLOBs(@Param("record") K2OrderLogistics record, @Param("example") K2OrderLogisticsExample example);

    int updateByExample(@Param("record") K2OrderLogistics record, @Param("example") K2OrderLogisticsExample example);

    int updateByPrimaryKeySelective(K2OrderLogistics record);

    int updateByPrimaryKeyWithBLOBs(K2OrderLogistics record);

    int updateByPrimaryKey(K2OrderLogistics record);
}