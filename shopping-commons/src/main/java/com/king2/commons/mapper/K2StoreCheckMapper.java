package com.king2.commons.mapper;

import com.king2.commons.pojo.K2StoreCheck;
import com.king2.commons.pojo.K2StoreCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2StoreCheckMapper {
    int countByExample(K2StoreCheckExample example);

    int deleteByExample(K2StoreCheckExample example);

    int deleteByPrimaryKey(Integer storeCheckId);

    int insert(K2StoreCheck record);

    int insertSelective(K2StoreCheck record);

    List<K2StoreCheck> selectByExample(K2StoreCheckExample example);

    K2StoreCheck selectByPrimaryKey(Integer storeCheckId);

    int updateByExampleSelective(@Param("record") K2StoreCheck record, @Param("example") K2StoreCheckExample example);

    int updateByExample(@Param("record") K2StoreCheck record, @Param("example") K2StoreCheckExample example);

    int updateByPrimaryKeySelective(K2StoreCheck record);

    int updateByPrimaryKey(K2StoreCheck record);
}