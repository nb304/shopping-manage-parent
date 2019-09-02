package com.king2.product.server.mapper;

import com.king2.commons.pojo.K2StoreCheck;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * 店铺入住Mapper
 */
public interface StoreEnterMapper {

    /**
     * 获取店铺入住的数量信息
     *
     * @param storeCheckState
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("<script>" +
            "SELECT COUNT(*) FROM k2_store_check " +
            "<where>" +
            "<if test='storeCheckState != null'>" +
            " store_check_state = #{storeCheckState} " +
            "</if>" +
            "<if test='startTime != null'>" +
            " AND store_check_create_time &gt;= #{startTime} " +
            "</if>" +
            "<if test='endTime != null'>" +
            " AND store_check_create_time &lt;= #{endTime} " +
            "</if>" +
            "</where>" +
            "</script>")
    int getStoreEnterCount(@Param("storeCheckState") Integer storeCheckState,
                           @Param("startTime") Date startTime,
                           @Param("endTime") Date endTime);


    /**
     * 获取店铺入住的数据信息
     *
     * @param storeCheckState
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("<script>" +
            "SELECT * FROM k2_store_check " +
            "<where>" +
            "<if test='storeCheckState != null'>" +
            " store_check_state = #{storeCheckState} " +
            "</if>" +
            "<if test='startTime != null'>" +
            " AND store_check_create_time &gt;= #{startTime} " +
            "</if>" +
            "<if test='endTime != null'>" +
            " AND store_check_create_time &lt;= #{endTime} " +
            "</if>" +
            "</where>" +
            "LIMIT #{index} , #{endIndex}" +
            "</script>")
    List<K2StoreCheck> getStoreEnterDatas(@Param("storeCheckState") Integer storeCheckState,
                                          @Param("startTime") Date startTime,
                                          @Param("endTime") Date endTime,
                                          @Param("index") Integer index, @Param("endIndex") Integer endIndex);
}
