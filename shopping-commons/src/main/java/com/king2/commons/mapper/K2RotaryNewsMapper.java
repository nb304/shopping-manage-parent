package com.king2.commons.mapper;

import com.king2.commons.pojo.K2RotaryNews;
import com.king2.commons.pojo.K2RotaryNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2RotaryNewsMapper {
    int countByExample(K2RotaryNewsExample example);

    int deleteByExample(K2RotaryNewsExample example);

    int deleteByPrimaryKey(Integer rotaryId);

    int insert(K2RotaryNews record);

    int insertSelective(K2RotaryNews record);

    List<K2RotaryNews> selectByExampleWithBLOBs(K2RotaryNewsExample example);

    List<K2RotaryNews> selectByExample(K2RotaryNewsExample example);

    K2RotaryNews selectByPrimaryKey(Integer rotaryId);

    int updateByExampleSelective(@Param("record") K2RotaryNews record, @Param("example") K2RotaryNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") K2RotaryNews record, @Param("example") K2RotaryNewsExample example);

    int updateByExample(@Param("record") K2RotaryNews record, @Param("example") K2RotaryNewsExample example);

    int updateByPrimaryKeySelective(K2RotaryNews record);

    int updateByPrimaryKeyWithBLOBs(K2RotaryNews record);

    int updateByPrimaryKey(K2RotaryNews record);
}