package com.king2.commons.mapper;

import com.king2.commons.pojo.K2OrderAfterSales;
import com.king2.commons.pojo.K2OrderAfterSalesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2OrderAfterSalesMapper {
    int countByExample(K2OrderAfterSalesExample example);

    int deleteByExample(K2OrderAfterSalesExample example);

    int deleteByPrimaryKey(Integer asId);

    int insert(K2OrderAfterSales record);

    int insertSelective(K2OrderAfterSales record);

    List<K2OrderAfterSales> selectByExampleWithBLOBs(K2OrderAfterSalesExample example);

    List<K2OrderAfterSales> selectByExample(K2OrderAfterSalesExample example);

    K2OrderAfterSales selectByPrimaryKey(Integer asId);

    int updateByExampleSelective(@Param("record") K2OrderAfterSales record, @Param("example") K2OrderAfterSalesExample example);

    int updateByExampleWithBLOBs(@Param("record") K2OrderAfterSales record, @Param("example") K2OrderAfterSalesExample example);

    int updateByExample(@Param("record") K2OrderAfterSales record, @Param("example") K2OrderAfterSalesExample example);

    int updateByPrimaryKeySelective(K2OrderAfterSales record);

    int updateByPrimaryKeyWithBLOBs(K2OrderAfterSales record);

    int updateByPrimaryKey(K2OrderAfterSales record);
}