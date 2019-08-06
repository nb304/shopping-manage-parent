package com.king2.commons.mapper;

import com.king2.commons.pojo.K2OrderTrading;
import com.king2.commons.pojo.K2OrderTradingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2OrderTradingMapper {
    int countByExample(K2OrderTradingExample example);

    int deleteByExample(K2OrderTradingExample example);

    int deleteByPrimaryKey(Integer tradingId);

    int insert(K2OrderTrading record);

    int insertSelective(K2OrderTrading record);

    List<K2OrderTrading> selectByExample(K2OrderTradingExample example);

    K2OrderTrading selectByPrimaryKey(Integer tradingId);

    int updateByExampleSelective(@Param("record") K2OrderTrading record, @Param("example") K2OrderTradingExample example);

    int updateByExample(@Param("record") K2OrderTrading record, @Param("example") K2OrderTradingExample example);

    int updateByPrimaryKeySelective(K2OrderTrading record);

    int updateByPrimaryKey(K2OrderTrading record);
}