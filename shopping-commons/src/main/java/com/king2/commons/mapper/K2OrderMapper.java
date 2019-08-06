package com.king2.commons.mapper;

import com.king2.commons.pojo.K2Order;
import com.king2.commons.pojo.K2OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2OrderMapper {
    int countByExample(K2OrderExample example);

    int deleteByExample(K2OrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(K2Order record);

    int insertSelective(K2Order record);

    List<K2Order> selectByExample(K2OrderExample example);

    K2Order selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") K2Order record, @Param("example") K2OrderExample example);

    int updateByExample(@Param("record") K2Order record, @Param("example") K2OrderExample example);

    int updateByPrimaryKeySelective(K2Order record);

    int updateByPrimaryKey(K2Order record);
}