package com.king2.commons.mapper;

import com.king2.commons.pojo.K2Message;
import com.king2.commons.pojo.K2MessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2MessageMapper {
    int countByExample(K2MessageExample example);

    int deleteByExample(K2MessageExample example);

    int deleteByPrimaryKey(Integer messageId);

    int insert(K2Message record);

    int insertSelective(K2Message record);

    List<K2Message> selectByExampleWithBLOBs(K2MessageExample example);

    List<K2Message> selectByExample(K2MessageExample example);

    K2Message selectByPrimaryKey(Integer messageId);

    int updateByExampleSelective(@Param("record") K2Message record, @Param("example") K2MessageExample example);

    int updateByExampleWithBLOBs(@Param("record") K2Message record, @Param("example") K2MessageExample example);

    int updateByExample(@Param("record") K2Message record, @Param("example") K2MessageExample example);

    int updateByPrimaryKeySelective(K2Message record);

    int updateByPrimaryKeyWithBLOBs(K2Message record);

    int updateByPrimaryKey(K2Message record);
}