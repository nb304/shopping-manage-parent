package com.king2.commons.mapper;

import com.king2.commons.pojo.K2RoleParallelismJurisdiction;
import com.king2.commons.pojo.K2RoleParallelismJurisdictionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2RoleParallelismJurisdictionMapper {
    int countByExample(K2RoleParallelismJurisdictionExample example);

    int deleteByExample(K2RoleParallelismJurisdictionExample example);

    int deleteByPrimaryKey(Integer parallelismJurisdictionId);

    int insert(K2RoleParallelismJurisdiction record);

    int insertSelective(K2RoleParallelismJurisdiction record);

    List<K2RoleParallelismJurisdiction> selectByExample(K2RoleParallelismJurisdictionExample example);

    K2RoleParallelismJurisdiction selectByPrimaryKey(Integer parallelismJurisdictionId);

    int updateByExampleSelective(@Param("record") K2RoleParallelismJurisdiction record, @Param("example") K2RoleParallelismJurisdictionExample example);

    int updateByExample(@Param("record") K2RoleParallelismJurisdiction record, @Param("example") K2RoleParallelismJurisdictionExample example);

    int updateByPrimaryKeySelective(K2RoleParallelismJurisdiction record);

    int updateByPrimaryKey(K2RoleParallelismJurisdiction record);
}