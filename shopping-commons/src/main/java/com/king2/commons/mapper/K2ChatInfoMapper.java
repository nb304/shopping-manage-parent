package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ChatInfo;
import com.king2.commons.pojo.K2ChatInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ChatInfoMapper {
    int countByExample(K2ChatInfoExample example);

    int deleteByExample(K2ChatInfoExample example);

    int deleteByPrimaryKey(Integer chatInfoId);

    int insert(K2ChatInfo record);

    int insertSelective(K2ChatInfo record);

    List<K2ChatInfo> selectByExampleWithBLOBs(K2ChatInfoExample example);

    List<K2ChatInfo> selectByExample(K2ChatInfoExample example);

    K2ChatInfo selectByPrimaryKey(Integer chatInfoId);

    int updateByExampleSelective(@Param("record") K2ChatInfo record, @Param("example") K2ChatInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") K2ChatInfo record, @Param("example") K2ChatInfoExample example);

    int updateByExample(@Param("record") K2ChatInfo record, @Param("example") K2ChatInfoExample example);

    int updateByPrimaryKeySelective(K2ChatInfo record);

    int updateByPrimaryKeyWithBLOBs(K2ChatInfo record);

    int updateByPrimaryKey(K2ChatInfo record);
}