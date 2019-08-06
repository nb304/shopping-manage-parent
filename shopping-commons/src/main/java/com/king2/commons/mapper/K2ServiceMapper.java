package com.king2.commons.mapper;

import com.king2.commons.pojo.K2Service;
import com.king2.commons.pojo.K2ServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ServiceMapper {
    int countByExample(K2ServiceExample example);

    int deleteByExample(K2ServiceExample example);

    int deleteByPrimaryKey(Integer serviceId);

    int insert(K2Service record);

    int insertSelective(K2Service record);

    List<K2Service> selectByExample(K2ServiceExample example);

    K2Service selectByPrimaryKey(Integer serviceId);

    int updateByExampleSelective(@Param("record") K2Service record, @Param("example") K2ServiceExample example);

    int updateByExample(@Param("record") K2Service record, @Param("example") K2ServiceExample example);

    int updateByPrimaryKeySelective(K2Service record);

    int updateByPrimaryKey(K2Service record);
}