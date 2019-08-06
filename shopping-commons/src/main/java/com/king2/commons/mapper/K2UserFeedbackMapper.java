package com.king2.commons.mapper;

import com.king2.commons.pojo.K2UserFeedback;
import com.king2.commons.pojo.K2UserFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2UserFeedbackMapper {
    int countByExample(K2UserFeedbackExample example);

    int deleteByExample(K2UserFeedbackExample example);

    int deleteByPrimaryKey(Integer userFeedbackId);

    int insert(K2UserFeedback record);

    int insertSelective(K2UserFeedback record);

    List<K2UserFeedback> selectByExampleWithBLOBs(K2UserFeedbackExample example);

    List<K2UserFeedback> selectByExample(K2UserFeedbackExample example);

    K2UserFeedback selectByPrimaryKey(Integer userFeedbackId);

    int updateByExampleSelective(@Param("record") K2UserFeedback record, @Param("example") K2UserFeedbackExample example);

    int updateByExampleWithBLOBs(@Param("record") K2UserFeedback record, @Param("example") K2UserFeedbackExample example);

    int updateByExample(@Param("record") K2UserFeedback record, @Param("example") K2UserFeedbackExample example);

    int updateByPrimaryKeySelective(K2UserFeedback record);

    int updateByPrimaryKeyWithBLOBs(K2UserFeedback record);

    int updateByPrimaryKey(K2UserFeedback record);
}