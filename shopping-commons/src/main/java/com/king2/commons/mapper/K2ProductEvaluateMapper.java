package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ProductEvaluate;
import com.king2.commons.pojo.K2ProductEvaluateExample;
import com.king2.commons.pojo.K2ProductEvaluateWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ProductEvaluateMapper {
    int countByExample(K2ProductEvaluateExample example);

    int deleteByExample(K2ProductEvaluateExample example);

    int deleteByPrimaryKey(Integer productEvaluateId);

    int insert(K2ProductEvaluateWithBLOBs record);

    int insertSelective(K2ProductEvaluateWithBLOBs record);

    List<K2ProductEvaluateWithBLOBs> selectByExampleWithBLOBs(K2ProductEvaluateExample example);

    List<K2ProductEvaluate> selectByExample(K2ProductEvaluateExample example);

    K2ProductEvaluateWithBLOBs selectByPrimaryKey(Integer productEvaluateId);

    int updateByExampleSelective(@Param("record") K2ProductEvaluateWithBLOBs record, @Param("example") K2ProductEvaluateExample example);

    int updateByExampleWithBLOBs(@Param("record") K2ProductEvaluateWithBLOBs record, @Param("example") K2ProductEvaluateExample example);

    int updateByExample(@Param("record") K2ProductEvaluate record, @Param("example") K2ProductEvaluateExample example);

    int updateByPrimaryKeySelective(K2ProductEvaluateWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(K2ProductEvaluateWithBLOBs record);

    int updateByPrimaryKey(K2ProductEvaluate record);
}