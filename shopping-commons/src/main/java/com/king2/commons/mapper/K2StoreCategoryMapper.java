package com.king2.commons.mapper;

import com.king2.commons.pojo.K2StoreCategory;
import com.king2.commons.pojo.K2StoreCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2StoreCategoryMapper {
    int countByExample(K2StoreCategoryExample example);

    int deleteByExample(K2StoreCategoryExample example);

    int deleteByPrimaryKey(Integer storeCategoryId);

    int insert(K2StoreCategory record);

    int insertSelective(K2StoreCategory record);

    List<K2StoreCategory> selectByExample(K2StoreCategoryExample example);

    K2StoreCategory selectByPrimaryKey(Integer storeCategoryId);

    int updateByExampleSelective(@Param("record") K2StoreCategory record, @Param("example") K2StoreCategoryExample example);

    int updateByExample(@Param("record") K2StoreCategory record, @Param("example") K2StoreCategoryExample example);

    int updateByPrimaryKeySelective(K2StoreCategory record);

    int updateByPrimaryKey(K2StoreCategory record);
}