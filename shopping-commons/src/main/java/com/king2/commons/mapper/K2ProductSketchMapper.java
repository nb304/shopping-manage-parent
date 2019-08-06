package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ProductSketch;
import com.king2.commons.pojo.K2ProductSketchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ProductSketchMapper {
    int countByExample(K2ProductSketchExample example);

    int deleteByExample(K2ProductSketchExample example);

    int deleteByPrimaryKey(Integer productSketchId);

    int insert(K2ProductSketch record);

    int insertSelective(K2ProductSketch record);

    List<K2ProductSketch> selectByExampleWithBLOBs(K2ProductSketchExample example);

    List<K2ProductSketch> selectByExample(K2ProductSketchExample example);

    K2ProductSketch selectByPrimaryKey(Integer productSketchId);

    int updateByExampleSelective(@Param("record") K2ProductSketch record, @Param("example") K2ProductSketchExample example);

    int updateByExampleWithBLOBs(@Param("record") K2ProductSketch record, @Param("example") K2ProductSketchExample example);

    int updateByExample(@Param("record") K2ProductSketch record, @Param("example") K2ProductSketchExample example);

    int updateByPrimaryKeySelective(K2ProductSketch record);

    int updateByPrimaryKeyWithBLOBs(K2ProductSketch record);

    int updateByPrimaryKey(K2ProductSketch record);
}