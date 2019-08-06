package com.king2.commons.mapper;

import com.king2.commons.pojo.K2PurchaseOrder;
import com.king2.commons.pojo.K2PurchaseOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2PurchaseOrderMapper {
    int countByExample(K2PurchaseOrderExample example);

    int deleteByExample(K2PurchaseOrderExample example);

    int deleteByPrimaryKey(Integer poId);

    int insert(K2PurchaseOrder record);

    int insertSelective(K2PurchaseOrder record);

    List<K2PurchaseOrder> selectByExampleWithBLOBs(K2PurchaseOrderExample example);

    List<K2PurchaseOrder> selectByExample(K2PurchaseOrderExample example);

    K2PurchaseOrder selectByPrimaryKey(Integer poId);

    int updateByExampleSelective(@Param("record") K2PurchaseOrder record, @Param("example") K2PurchaseOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") K2PurchaseOrder record, @Param("example") K2PurchaseOrderExample example);

    int updateByExample(@Param("record") K2PurchaseOrder record, @Param("example") K2PurchaseOrderExample example);

    int updateByPrimaryKeySelective(K2PurchaseOrder record);

    int updateByPrimaryKeyWithBLOBs(K2PurchaseOrder record);

    int updateByPrimaryKey(K2PurchaseOrder record);
}