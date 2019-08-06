package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ProductBrand;
import com.king2.commons.pojo.K2ProductBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ProductBrandMapper {
    int countByExample(K2ProductBrandExample example);

    int deleteByExample(K2ProductBrandExample example);

    int deleteByPrimaryKey(Integer brandId);

    int insert(K2ProductBrand record);

    int insertSelective(K2ProductBrand record);

    List<K2ProductBrand> selectByExample(K2ProductBrandExample example);

    K2ProductBrand selectByPrimaryKey(Integer brandId);

    int updateByExampleSelective(@Param("record") K2ProductBrand record, @Param("example") K2ProductBrandExample example);

    int updateByExample(@Param("record") K2ProductBrand record, @Param("example") K2ProductBrandExample example);

    int updateByPrimaryKeySelective(K2ProductBrand record);

    int updateByPrimaryKey(K2ProductBrand record);
}