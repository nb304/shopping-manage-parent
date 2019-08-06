package com.king2.commons.mapper;

import com.king2.commons.pojo.K2Role;
import com.king2.commons.pojo.K2RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2RoleMapper {
    int countByExample(K2RoleExample example);

    int deleteByExample(K2RoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(K2Role record);

    int insertSelective(K2Role record);

    List<K2Role> selectByExample(K2RoleExample example);

    K2Role selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") K2Role record, @Param("example") K2RoleExample example);

    int updateByExample(@Param("record") K2Role record, @Param("example") K2RoleExample example);

    int updateByPrimaryKeySelective(K2Role record);

    int updateByPrimaryKey(K2Role record);
}