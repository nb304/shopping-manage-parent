package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ChinaArea;
import com.king2.commons.pojo.K2ChinaAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ChinaAreaMapper {
    int countByExample(K2ChinaAreaExample example);

    int deleteByExample(K2ChinaAreaExample example);

    int deleteByPrimaryKey(Integer areaId);

    int insert(K2ChinaArea record);

    int insertSelective(K2ChinaArea record);

    List<K2ChinaArea> selectByExample(K2ChinaAreaExample example);

    K2ChinaArea selectByPrimaryKey(Integer areaId);

    int updateByExampleSelective(@Param("record") K2ChinaArea record, @Param("example") K2ChinaAreaExample example);

    int updateByExample(@Param("record") K2ChinaArea record, @Param("example") K2ChinaAreaExample example);

    int updateByPrimaryKeySelective(K2ChinaArea record);

    int updateByPrimaryKey(K2ChinaArea record);
}