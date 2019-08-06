package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ByGeneralize;
import com.king2.commons.pojo.K2ByGeneralizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ByGeneralizeMapper {
    int countByExample(K2ByGeneralizeExample example);

    int deleteByExample(K2ByGeneralizeExample example);

    int deleteByPrimaryKey(Integer byGeneralizeId);

    int insert(K2ByGeneralize record);

    int insertSelective(K2ByGeneralize record);

    List<K2ByGeneralize> selectByExample(K2ByGeneralizeExample example);

    K2ByGeneralize selectByPrimaryKey(Integer byGeneralizeId);

    int updateByExampleSelective(@Param("record") K2ByGeneralize record, @Param("example") K2ByGeneralizeExample example);

    int updateByExample(@Param("record") K2ByGeneralize record, @Param("example") K2ByGeneralizeExample example);

    int updateByPrimaryKeySelective(K2ByGeneralize record);

    int updateByPrimaryKey(K2ByGeneralize record);
}