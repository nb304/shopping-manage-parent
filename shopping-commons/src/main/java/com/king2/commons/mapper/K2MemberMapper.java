package com.king2.commons.mapper;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2MemberMapper {
    int countByExample(K2MemberExample example);

    int deleteByExample(K2MemberExample example);

    int deleteByPrimaryKey(Integer memberId);

    int insert(K2Member record);

    int insertSelective(K2Member record);

    List<K2Member> selectByExample(K2MemberExample example);

    K2Member selectByPrimaryKey(Integer memberId);

    int updateByExampleSelective(@Param("record") K2Member record, @Param("example") K2MemberExample example);

    int updateByExample(@Param("record") K2Member record, @Param("example") K2MemberExample example);

    int updateByPrimaryKeySelective(K2Member record);

    int updateByPrimaryKey(K2Member record);
}