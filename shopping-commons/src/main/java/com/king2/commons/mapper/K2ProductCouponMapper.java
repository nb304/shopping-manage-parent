package com.king2.commons.mapper;

import com.king2.commons.pojo.K2ProductCoupon;
import com.king2.commons.pojo.K2ProductCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2ProductCouponMapper {
    int countByExample(K2ProductCouponExample example);

    int deleteByExample(K2ProductCouponExample example);

    int deleteByPrimaryKey(Integer productCouponId);

    int insert(K2ProductCoupon record);

    int insertSelective(K2ProductCoupon record);

    List<K2ProductCoupon> selectByExample(K2ProductCouponExample example);

    K2ProductCoupon selectByPrimaryKey(Integer productCouponId);

    int updateByExampleSelective(@Param("record") K2ProductCoupon record, @Param("example") K2ProductCouponExample example);

    int updateByExample(@Param("record") K2ProductCoupon record, @Param("example") K2ProductCouponExample example);

    int updateByPrimaryKeySelective(K2ProductCoupon record);

    int updateByPrimaryKey(K2ProductCoupon record);
}