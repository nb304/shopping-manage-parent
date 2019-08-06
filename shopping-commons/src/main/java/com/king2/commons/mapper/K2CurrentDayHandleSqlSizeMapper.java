package com.king2.commons.mapper;

import com.king2.commons.pojo.K2CurrentDayHandleSqlSize;
import com.king2.commons.pojo.K2CurrentDayHandleSqlSizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2CurrentDayHandleSqlSizeMapper {
    int countByExample(K2CurrentDayHandleSqlSizeExample example);

    int deleteByExample(K2CurrentDayHandleSqlSizeExample example);

    int deleteByPrimaryKey(Integer sqlSizeId);

    int insert(K2CurrentDayHandleSqlSize record);

    int insertSelective(K2CurrentDayHandleSqlSize record);

    List<K2CurrentDayHandleSqlSize> selectByExample(K2CurrentDayHandleSqlSizeExample example);

    K2CurrentDayHandleSqlSize selectByPrimaryKey(Integer sqlSizeId);

    int updateByExampleSelective(@Param("record") K2CurrentDayHandleSqlSize record, @Param("example") K2CurrentDayHandleSqlSizeExample example);

    int updateByExample(@Param("record") K2CurrentDayHandleSqlSize record, @Param("example") K2CurrentDayHandleSqlSizeExample example);

    int updateByPrimaryKeySelective(K2CurrentDayHandleSqlSize record);

    int updateByPrimaryKey(K2CurrentDayHandleSqlSize record);
}