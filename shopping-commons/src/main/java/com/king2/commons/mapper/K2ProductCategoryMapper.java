package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ProductCategory;
import com.king2.commons.pojo.K2ProductCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ProductCategoryMapper {
    int countByExample(K2ProductCategoryExample example);

    int deleteByExample(K2ProductCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(K2ProductCategory record);

    int insertSelective(K2ProductCategory record);

    List<K2ProductCategory> selectByExample(K2ProductCategoryExample example);

    K2ProductCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") K2ProductCategory record, @Param("example") K2ProductCategoryExample example);

    int updateByExample(@Param("record") K2ProductCategory record, @Param("example") K2ProductCategoryExample example);

    int updateByPrimaryKeySelective(K2ProductCategory record);

    int updateByPrimaryKey(K2ProductCategory record);
}