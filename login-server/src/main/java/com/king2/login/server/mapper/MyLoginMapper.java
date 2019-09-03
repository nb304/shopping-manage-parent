package com.king2.login.server.mapper;


import com.king2.commons.pojo.K2Jurisdiction;
import com.king2.commons.pojo.K2Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyLoginMapper {



    @Select("select role_id roleId, " +
            "role_name roleName, " +
            "create_user_id createUserId, " +
            " create_user_name createUserName, " +
            " state state, " +
            " update_user_id updateUserId, " +
            " update_user_name updateUserName, " +
            " retain1, " +
            " retain2, " +
            " retain3, " +
            " retain4, " +
            " retain5 " +
            "FROM k2_role " +
            "WHERE role_id in(select role_id  from k2_role_member WHERE member_id=#{account})  and state!=2")
    //获取对应的用户角色信息
    public List<K2Role> getMemberOnRoleMess(@Param("account") String account);


    @Select(" select  " +
            " jur_id jurId, " +
            " jur_name jurName, " +
            " juri_url juriUrl, " +
            " jur_icon jurIcon, " +
            " jur_parent_id jurParentId, " +
            " jur_component jurComponent, " +
            " jur_create_time jurCreateTime, " +
            " jur_update_time jurUpdateTime, " +
            " jur_del_flag    jurDelFlag, " +
            " retain1, " +
            " retain2, " +
            " retain3, " +
            " retain4, " +
            " retain5 " +
            " from k2_jurisdiction " +
            " where jur_id IN (SELECT DISTINCT jurisdiction_id from k2_role_parallelism_jurisdiction WHERE role_id IN" +
            "<foreach collection='roleIds' open='(' item='currId' separator=',' close=')'> #{currId}</foreach> " +
            "and jur_del_flag!=1")
    //获取角色对应的权限信息
    public List<K2Jurisdiction> getMemberOnJurMess(@Param("roleIds") List<Integer> roleIds);
}
