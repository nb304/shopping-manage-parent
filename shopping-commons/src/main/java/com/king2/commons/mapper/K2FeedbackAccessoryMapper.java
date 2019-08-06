package com.king2.commons.mapper;

import com.king2.commons.pojo.K2FeedbackAccessory;
import com.king2.commons.pojo.K2FeedbackAccessoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2FeedbackAccessoryMapper {
    int countByExample(K2FeedbackAccessoryExample example);

    int deleteByExample(K2FeedbackAccessoryExample example);

    int deleteByPrimaryKey(Integer feedbackAccessoryId);

    int insert(K2FeedbackAccessory record);

    int insertSelective(K2FeedbackAccessory record);

    List<K2FeedbackAccessory> selectByExampleWithBLOBs(K2FeedbackAccessoryExample example);

    List<K2FeedbackAccessory> selectByExample(K2FeedbackAccessoryExample example);

    K2FeedbackAccessory selectByPrimaryKey(Integer feedbackAccessoryId);

    int updateByExampleSelective(@Param("record") K2FeedbackAccessory record, @Param("example") K2FeedbackAccessoryExample example);

    int updateByExampleWithBLOBs(@Param("record") K2FeedbackAccessory record, @Param("example") K2FeedbackAccessoryExample example);

    int updateByExample(@Param("record") K2FeedbackAccessory record, @Param("example") K2FeedbackAccessoryExample example);

    int updateByPrimaryKeySelective(K2FeedbackAccessory record);

    int updateByPrimaryKeyWithBLOBs(K2FeedbackAccessory record);

    int updateByPrimaryKey(K2FeedbackAccessory record);
}