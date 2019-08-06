package com.king2.commons.mapper;

import com.king2.commons.pojo.K2Product;
import com.king2.commons.pojo.K2ProductExample;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ProductMapper {
    int countByExample(K2ProductExample example);

    int deleteByExample(K2ProductExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(K2ProductWithBLOBs record);

    int insertSelective(K2ProductWithBLOBs record);

    List<K2ProductWithBLOBs> selectByExampleWithBLOBs(K2ProductExample example);

    List<K2Product> selectByExample(K2ProductExample example);

    K2ProductWithBLOBs selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") K2ProductWithBLOBs record, @Param("example") K2ProductExample example);

    int updateByExampleWithBLOBs(@Param("record") K2ProductWithBLOBs record, @Param("example") K2ProductExample example);

    int updateByExample(@Param("record") K2Product record, @Param("example") K2ProductExample example);

    int updateByPrimaryKeySelective(K2ProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(K2ProductWithBLOBs record);

    int updateByPrimaryKey(K2Product record);
}