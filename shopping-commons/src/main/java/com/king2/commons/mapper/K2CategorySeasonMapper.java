package com.king2.commons.mapper;

import com.king2.commons.pojo.K2CategorySeason;
import com.king2.commons.pojo.K2CategorySeasonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2CategorySeasonMapper {
    int countByExample(K2CategorySeasonExample example);

    int deleteByExample(K2CategorySeasonExample example);

    int deleteByPrimaryKey(Integer categorySeasonId);

    int insert(K2CategorySeason record);

    int insertSelective(K2CategorySeason record);

    List<K2CategorySeason> selectByExample(K2CategorySeasonExample example);

    K2CategorySeason selectByPrimaryKey(Integer categorySeasonId);

    int updateByExampleSelective(@Param("record") K2CategorySeason record, @Param("example") K2CategorySeasonExample example);

    int updateByExample(@Param("record") K2CategorySeason record, @Param("example") K2CategorySeasonExample example);

    int updateByPrimaryKeySelective(K2CategorySeason record);

    int updateByPrimaryKey(K2CategorySeason record);
}