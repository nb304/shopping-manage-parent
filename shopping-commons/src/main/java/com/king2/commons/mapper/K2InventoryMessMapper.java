package com.king2.commons.mapper;

import com.king2.commons.pojo.K2InventoryMess;
import com.king2.commons.pojo.K2InventoryMessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2InventoryMessMapper {
    int countByExample(K2InventoryMessExample example);

    int deleteByExample(K2InventoryMessExample example);

    int deleteByPrimaryKey(Integer imId);

    int insert(K2InventoryMess record);

    int insertSelective(K2InventoryMess record);

    List<K2InventoryMess> selectByExample(K2InventoryMessExample example);

    K2InventoryMess selectByPrimaryKey(Integer imId);

    int updateByExampleSelective(@Param("record") K2InventoryMess record, @Param("example") K2InventoryMessExample example);

    int updateByExample(@Param("record") K2InventoryMess record, @Param("example") K2InventoryMessExample example);

    int updateByPrimaryKeySelective(K2InventoryMess record);

    int updateByPrimaryKey(K2InventoryMess record);
}