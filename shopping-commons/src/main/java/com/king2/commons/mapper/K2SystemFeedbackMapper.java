package com.king2.commons.mapper;

import com.king2.commons.pojo.K2SystemFeedback;
import com.king2.commons.pojo.K2SystemFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2SystemFeedbackMapper {
    int countByExample(K2SystemFeedbackExample example);

    int deleteByExample(K2SystemFeedbackExample example);

    int deleteByPrimaryKey(Integer systemFeedbackId);

    int insert(K2SystemFeedback record);

    int insertSelective(K2SystemFeedback record);

    List<K2SystemFeedback> selectByExampleWithBLOBs(K2SystemFeedbackExample example);

    List<K2SystemFeedback> selectByExample(K2SystemFeedbackExample example);

    K2SystemFeedback selectByPrimaryKey(Integer systemFeedbackId);

    int updateByExampleSelective(@Param("record") K2SystemFeedback record, @Param("example") K2SystemFeedbackExample example);

    int updateByExampleWithBLOBs(@Param("record") K2SystemFeedback record, @Param("example") K2SystemFeedbackExample example);

    int updateByExample(@Param("record") K2SystemFeedback record, @Param("example") K2SystemFeedbackExample example);

    int updateByPrimaryKeySelective(K2SystemFeedback record);

    int updateByPrimaryKeyWithBLOBs(K2SystemFeedback record);

    int updateByPrimaryKey(K2SystemFeedback record);
}