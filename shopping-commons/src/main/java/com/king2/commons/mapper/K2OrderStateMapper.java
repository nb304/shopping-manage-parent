package com.king2.commons.mapper;

import com.king2.commons.pojo.K2OrderState;
import com.king2.commons.pojo.K2OrderStateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2OrderStateMapper {
    int countByExample(K2OrderStateExample example);

    int deleteByExample(K2OrderStateExample example);

    int deleteByPrimaryKey(String osId);

    int insert(K2OrderState record);

    int insertSelective(K2OrderState record);

    List<K2OrderState> selectByExample(K2OrderStateExample example);

    K2OrderState selectByPrimaryKey(String osId);

    int updateByExampleSelective(@Param("record") K2OrderState record, @Param("example") K2OrderStateExample example);

    int updateByExample(@Param("record") K2OrderState record, @Param("example") K2OrderStateExample example);

    int updateByPrimaryKeySelective(K2OrderState record);

    int updateByPrimaryKey(K2OrderState record);
}