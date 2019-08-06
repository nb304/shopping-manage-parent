package com.king2.commons.mapper;

import com.king2.commons.pojo.K2PurchaseProduct;
import com.king2.commons.pojo.K2PurchaseProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2PurchaseProductMapper {
    int countByExample(K2PurchaseProductExample example);

    int deleteByExample(K2PurchaseProductExample example);

    int deleteByPrimaryKey(Integer ppId);

    int insert(K2PurchaseProduct record);

    int insertSelective(K2PurchaseProduct record);

    List<K2PurchaseProduct> selectByExample(K2PurchaseProductExample example);

    K2PurchaseProduct selectByPrimaryKey(Integer ppId);

    int updateByExampleSelective(@Param("record") K2PurchaseProduct record, @Param("example") K2PurchaseProductExample example);

    int updateByExample(@Param("record") K2PurchaseProduct record, @Param("example") K2PurchaseProductExample example);

    int updateByPrimaryKeySelective(K2PurchaseProduct record);

    int updateByPrimaryKey(K2PurchaseProduct record);
}