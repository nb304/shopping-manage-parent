package com.king2.commons.mapper;

import com.king2.commons.pojo.K2Generalize;
import com.king2.commons.pojo.K2GeneralizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2GeneralizeMapper {
    int countByExample(K2GeneralizeExample example);

    int deleteByExample(K2GeneralizeExample example);

    int deleteByPrimaryKey(Integer generalizeId);

    int insert(K2Generalize record);

    int insertSelective(K2Generalize record);

    List<K2Generalize> selectByExample(K2GeneralizeExample example);

    K2Generalize selectByPrimaryKey(Integer generalizeId);

    int updateByExampleSelective(@Param("record") K2Generalize record, @Param("example") K2GeneralizeExample example);

    int updateByExample(@Param("record") K2Generalize record, @Param("example") K2GeneralizeExample example);

    int updateByPrimaryKeySelective(K2Generalize record);

    int updateByPrimaryKey(K2Generalize record);
}