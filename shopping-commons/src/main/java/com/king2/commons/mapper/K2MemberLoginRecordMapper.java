package com.king2.commons.mapper;

import com.king2.commons.pojo.K2MemberLoginRecord;
import com.king2.commons.pojo.K2MemberLoginRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2MemberLoginRecordMapper {
    int countByExample(K2MemberLoginRecordExample example);

    int deleteByExample(K2MemberLoginRecordExample example);

    int deleteByPrimaryKey(Integer reId);

    int insert(K2MemberLoginRecord record);

    int insertSelective(K2MemberLoginRecord record);

    List<K2MemberLoginRecord> selectByExample(K2MemberLoginRecordExample example);

    K2MemberLoginRecord selectByPrimaryKey(Integer reId);

    int updateByExampleSelective(@Param("record") K2MemberLoginRecord record, @Param("example") K2MemberLoginRecordExample example);

    int updateByExample(@Param("record") K2MemberLoginRecord record, @Param("example") K2MemberLoginRecordExample example);

    int updateByPrimaryKeySelective(K2MemberLoginRecord record);

    int updateByPrimaryKey(K2MemberLoginRecord record);
}