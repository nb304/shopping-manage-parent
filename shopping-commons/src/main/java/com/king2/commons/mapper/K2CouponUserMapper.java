package com.king2.commons.mapper;

import com.king2.commons.pojo.K2CouponUser;
import com.king2.commons.pojo.K2CouponUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface K2CouponUserMapper {
    int countByExample(K2CouponUserExample example);

    int deleteByExample(K2CouponUserExample example);

    int deleteByPrimaryKey(Integer couponUserId);

    int insert(K2CouponUser record);

    int insertSelective(K2CouponUser record);

    List<K2CouponUser> selectByExample(K2CouponUserExample example);

    K2CouponUser selectByPrimaryKey(Integer couponUserId);

    int updateByExampleSelective(@Param("record") K2CouponUser record, @Param("example") K2CouponUserExample example);

    int updateByExample(@Param("record") K2CouponUser record, @Param("example") K2CouponUserExample example);

    int updateByPrimaryKeySelective(K2CouponUser record);

    int updateByPrimaryKey(K2CouponUser record);
}