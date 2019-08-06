package com.king2.commons.mapper;

import com.king2.commons.pojo.K2SystemCommonState;
import com.king2.commons.pojo.K2SystemCommonStateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2SystemCommonStateMapper {
    int countByExample(K2SystemCommonStateExample example);

    int deleteByExample(K2SystemCommonStateExample example);

    int deleteByPrimaryKey(Integer systemCommonStateId);

    int insert(K2SystemCommonState record);

    int insertSelective(K2SystemCommonState record);

    List<K2SystemCommonState> selectByExample(K2SystemCommonStateExample example);

    K2SystemCommonState selectByPrimaryKey(Integer systemCommonStateId);

    int updateByExampleSelective(@Param("record") K2SystemCommonState record, @Param("example") K2SystemCommonStateExample example);

    int updateByExample(@Param("record") K2SystemCommonState record, @Param("example") K2SystemCommonStateExample example);

    int updateByPrimaryKeySelective(K2SystemCommonState record);

    int updateByPrimaryKey(K2SystemCommonState record);
}