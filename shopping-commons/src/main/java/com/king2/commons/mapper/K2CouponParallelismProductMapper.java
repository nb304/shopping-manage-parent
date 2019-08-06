package com.king2.commons.mapper;

import com.king2.commons.pojo.K2CouponParallelismProduct;
import com.king2.commons.pojo.K2CouponParallelismProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2CouponParallelismProductMapper {
    int countByExample(K2CouponParallelismProductExample example);

    int deleteByExample(K2CouponParallelismProductExample example);

    int deleteByPrimaryKey(Integer couponParallelismProductId);

    int insert(K2CouponParallelismProduct record);

    int insertSelective(K2CouponParallelismProduct record);

    List<K2CouponParallelismProduct> selectByExample(K2CouponParallelismProductExample example);

    K2CouponParallelismProduct selectByPrimaryKey(Integer couponParallelismProductId);

    int updateByExampleSelective(@Param("record") K2CouponParallelismProduct record, @Param("example") K2CouponParallelismProductExample example);

    int updateByExample(@Param("record") K2CouponParallelismProduct record, @Param("example") K2CouponParallelismProductExample example);

    int updateByPrimaryKeySelective(K2CouponParallelismProduct record);

    int updateByPrimaryKey(K2CouponParallelismProduct record);
}