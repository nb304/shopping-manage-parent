package com.king2.commons.mapper;

import com.king2.commons.pojo.K2MemberDeliveryAddress;
import com.king2.commons.pojo.K2MemberDeliveryAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2MemberDeliveryAddressMapper {
    int countByExample(K2MemberDeliveryAddressExample example);

    int deleteByExample(K2MemberDeliveryAddressExample example);

    int deleteByPrimaryKey(Integer daId);

    int insert(K2MemberDeliveryAddress record);

    int insertSelective(K2MemberDeliveryAddress record);

    List<K2MemberDeliveryAddress> selectByExample(K2MemberDeliveryAddressExample example);

    K2MemberDeliveryAddress selectByPrimaryKey(Integer daId);

    int updateByExampleSelective(@Param("record") K2MemberDeliveryAddress record, @Param("example") K2MemberDeliveryAddressExample example);

    int updateByExample(@Param("record") K2MemberDeliveryAddress record, @Param("example") K2MemberDeliveryAddressExample example);

    int updateByPrimaryKeySelective(K2MemberDeliveryAddress record);

    int updateByPrimaryKey(K2MemberDeliveryAddress record);
}