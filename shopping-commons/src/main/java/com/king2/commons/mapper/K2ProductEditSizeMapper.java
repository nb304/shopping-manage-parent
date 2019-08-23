package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ProductEditSize;
import com.king2.commons.pojo.K2ProductEditSizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ProductEditSizeMapper {
    int countByExample(K2ProductEditSizeExample example);

    int deleteByExample(K2ProductEditSizeExample example);

    int deleteByPrimaryKey(Integer editSize);

    int insert(K2ProductEditSize record);

    int insertSelective(K2ProductEditSize record);

    List<K2ProductEditSize> selectByExample(K2ProductEditSizeExample example);

    K2ProductEditSize selectByPrimaryKey(Integer editSize);

    int updateByExampleSelective(@Param("record") K2ProductEditSize record, @Param("example") K2ProductEditSizeExample example);

    int updateByExample(@Param("record") K2ProductEditSize record, @Param("example") K2ProductEditSizeExample example);

    int updateByPrimaryKeySelective(K2ProductEditSize record);

    int updateByPrimaryKey(K2ProductEditSize record);
}