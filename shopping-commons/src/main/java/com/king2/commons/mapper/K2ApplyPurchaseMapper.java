package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ApplyPurchase;
import com.king2.commons.pojo.K2ApplyPurchaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ApplyPurchaseMapper {
    int countByExample(K2ApplyPurchaseExample example);

    int deleteByExample(K2ApplyPurchaseExample example);

    int deleteByPrimaryKey(Integer apId);

    int insert(K2ApplyPurchase record);

    int insertSelective(K2ApplyPurchase record);

    List<K2ApplyPurchase> selectByExampleWithBLOBs(K2ApplyPurchaseExample example);

    List<K2ApplyPurchase> selectByExample(K2ApplyPurchaseExample example);

    K2ApplyPurchase selectByPrimaryKey(Integer apId);

    int updateByExampleSelective(@Param("record") K2ApplyPurchase record, @Param("example") K2ApplyPurchaseExample example);

    int updateByExampleWithBLOBs(@Param("record") K2ApplyPurchase record, @Param("example") K2ApplyPurchaseExample example);

    int updateByExample(@Param("record") K2ApplyPurchase record, @Param("example") K2ApplyPurchaseExample example);

    int updateByPrimaryKeySelective(K2ApplyPurchase record);

    int updateByPrimaryKeyWithBLOBs(K2ApplyPurchase record);

    int updateByPrimaryKey(K2ApplyPurchase record);
}