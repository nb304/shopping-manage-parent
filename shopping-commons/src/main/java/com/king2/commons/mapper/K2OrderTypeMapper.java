package com.king2.commons.mapper;

import com.king2.commons.pojo.K2OrderType;
import com.king2.commons.pojo.K2OrderTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2OrderTypeMapper {
    int countByExample(K2OrderTypeExample example);

    int deleteByExample(K2OrderTypeExample example);

    int deleteByPrimaryKey(Integer oyId);

    int insert(K2OrderType record);

    int insertSelective(K2OrderType record);

    List<K2OrderType> selectByExample(K2OrderTypeExample example);

    K2OrderType selectByPrimaryKey(Integer oyId);

    int updateByExampleSelective(@Param("record") K2OrderType record, @Param("example") K2OrderTypeExample example);

    int updateByExample(@Param("record") K2OrderType record, @Param("example") K2OrderTypeExample example);

    int updateByPrimaryKeySelective(K2OrderType record);

    int updateByPrimaryKey(K2OrderType record);
}