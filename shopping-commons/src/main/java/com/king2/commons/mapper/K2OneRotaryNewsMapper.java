package com.king2.commons.mapper;

import com.king2.commons.pojo.K2OneRotaryNews;
import com.king2.commons.pojo.K2OneRotaryNewsExample;
import com.king2.commons.pojo.K2OneRotaryNewsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2OneRotaryNewsMapper {
    int countByExample(K2OneRotaryNewsExample example);

    int deleteByExample(K2OneRotaryNewsExample example);

    int deleteByPrimaryKey(Integer oneRotaryNewsId);

    int insert(K2OneRotaryNewsWithBLOBs record);

    int insertSelective(K2OneRotaryNewsWithBLOBs record);

    List<K2OneRotaryNewsWithBLOBs> selectByExampleWithBLOBs(K2OneRotaryNewsExample example);

    List<K2OneRotaryNews> selectByExample(K2OneRotaryNewsExample example);

    K2OneRotaryNewsWithBLOBs selectByPrimaryKey(Integer oneRotaryNewsId);

    int updateByExampleSelective(@Param("record") K2OneRotaryNewsWithBLOBs record, @Param("example") K2OneRotaryNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") K2OneRotaryNewsWithBLOBs record, @Param("example") K2OneRotaryNewsExample example);

    int updateByExample(@Param("record") K2OneRotaryNews record, @Param("example") K2OneRotaryNewsExample example);

    int updateByPrimaryKeySelective(K2OneRotaryNewsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(K2OneRotaryNewsWithBLOBs record);

    int updateByPrimaryKey(K2OneRotaryNews record);
}