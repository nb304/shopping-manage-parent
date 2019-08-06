package com.king2.commons.mapper;

import com.king2.commons.pojo.K2RotaryNewsImageInfo;
import com.king2.commons.pojo.K2RotaryNewsImageInfoExample;
import com.king2.commons.pojo.K2RotaryNewsImageInfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2RotaryNewsImageInfoMapper {
    int countByExample(K2RotaryNewsImageInfoExample example);

    int deleteByExample(K2RotaryNewsImageInfoExample example);

    int deleteByPrimaryKey(Integer rotaryImageInfoId);

    int insert(K2RotaryNewsImageInfoWithBLOBs record);

    int insertSelective(K2RotaryNewsImageInfoWithBLOBs record);

    List<K2RotaryNewsImageInfoWithBLOBs> selectByExampleWithBLOBs(K2RotaryNewsImageInfoExample example);

    List<K2RotaryNewsImageInfo> selectByExample(K2RotaryNewsImageInfoExample example);

    K2RotaryNewsImageInfoWithBLOBs selectByPrimaryKey(Integer rotaryImageInfoId);

    int updateByExampleSelective(@Param("record") K2RotaryNewsImageInfoWithBLOBs record, @Param("example") K2RotaryNewsImageInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") K2RotaryNewsImageInfoWithBLOBs record, @Param("example") K2RotaryNewsImageInfoExample example);

    int updateByExample(@Param("record") K2RotaryNewsImageInfo record, @Param("example") K2RotaryNewsImageInfoExample example);

    int updateByPrimaryKeySelective(K2RotaryNewsImageInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(K2RotaryNewsImageInfoWithBLOBs record);

    int updateByPrimaryKey(K2RotaryNewsImageInfo record);
}