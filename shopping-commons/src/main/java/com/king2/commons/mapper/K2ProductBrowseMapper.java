package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ProductBrowse;
import com.king2.commons.pojo.K2ProductBrowseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ProductBrowseMapper {
    int countByExample(K2ProductBrowseExample example);

    int deleteByExample(K2ProductBrowseExample example);

    int deleteByPrimaryKey(Integer productBrowseId);

    int insert(K2ProductBrowse record);

    int insertSelective(K2ProductBrowse record);

    List<K2ProductBrowse> selectByExample(K2ProductBrowseExample example);

    K2ProductBrowse selectByPrimaryKey(Integer productBrowseId);

    int updateByExampleSelective(@Param("record") K2ProductBrowse record, @Param("example") K2ProductBrowseExample example);

    int updateByExample(@Param("record") K2ProductBrowse record, @Param("example") K2ProductBrowseExample example);

    int updateByPrimaryKeySelective(K2ProductBrowse record);

    int updateByPrimaryKey(K2ProductBrowse record);
}