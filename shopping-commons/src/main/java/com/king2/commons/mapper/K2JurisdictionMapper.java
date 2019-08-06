package com.king2.commons.mapper;

import com.king2.commons.pojo.K2Jurisdiction;
import com.king2.commons.pojo.K2JurisdictionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2JurisdictionMapper {
    int countByExample(K2JurisdictionExample example);

    int deleteByExample(K2JurisdictionExample example);

    int deleteByPrimaryKey(String jurId);

    int insert(K2Jurisdiction record);

    int insertSelective(K2Jurisdiction record);

    List<K2Jurisdiction> selectByExample(K2JurisdictionExample example);

    K2Jurisdiction selectByPrimaryKey(String jurId);

    int updateByExampleSelective(@Param("record") K2Jurisdiction record, @Param("example") K2JurisdictionExample example);

    int updateByExample(@Param("record") K2Jurisdiction record, @Param("example") K2JurisdictionExample example);

    int updateByPrimaryKeySelective(K2Jurisdiction record);

    int updateByPrimaryKey(K2Jurisdiction record);
}