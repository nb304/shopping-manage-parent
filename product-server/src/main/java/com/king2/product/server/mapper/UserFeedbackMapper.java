package com.king2.product.server.mapper;

import com.king2.commons.pojo.K2UserFeedback;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * 用户反馈Mapper
 */
public interface UserFeedbackMapper {


    /**
     * 根据条件获取反馈编号的条数
     *
     * @param userFeedbackNumber
     * @param userName
     * @param userFeedbackState
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("<script>" +
            "SELECT COUNT(*) FROM k2_user_feedback " +
            "WHERE user_feedback_state != 3" +
            "<if test='userFeedbackNumber != null'>" +
            "AND user_feedback_number = #{userFeedbackNumber} " +
            "</if>" +
            "<if test='userName != null'>" +
            "AND user_name = #{userName} " +
            "</if>" +
            "<if test='userFeedbackState != null'>" +
            "AND user_feedback_state = #{userFeedbackState} " +
            "</if>" +
            "<if test='startTime != null'>" +
            "AND create_time &gt;= #{startTime} " +
            "</if>" +
            "<if test='endTime != null'>" +
            "AND create_time &lt;= #{endTime} " +
            "</if>" +
            "</script>")
    int getFeedbackCount(@Param("userFeedbackNumber") String userFeedbackNumber, @Param("userName") String userName,
                         @Param("userFeedbackState") String userFeedbackState, @Param("startTime") Date startTime,
                         @Param("endTime") Date endTime);

    /**
     * 通过条件获取反馈的信息
     *
     * @param userFeedbackNumber
     * @param userName
     * @param userFeedbackState
     * @param startTime
     * @param endTime
     * @param index
     * @param endIndex
     * @return
     */
    @Select("<script>" +
            "SELECT k.* , m.`member_portrait` image , m.`member_name` uName FROM " +
            "k2_user_feedback k , k2_member m  " +
            "WHERE user_feedback_state != 3 AND k.`user_id` = m.`member_id` " +
            "<if test='userFeedbackNumber != null'>" +
            "AND k.user_feedback_number = #{userFeedbackNumber} " +
            "</if>" +
            "<if test='userName != null'>" +
            "AND k.user_name = #{userName} " +
            "</if>" +
            "<if test='userFeedbackState != null'>" +
            "AND k.user_feedback_state = #{userFeedbackState} " +
            "</if>" +
            "<if test='startTime != null'>" +
            "AND k.create_time &gt;= #{startTime} " +
            "</if>" +
            "<if test='endTime != null'>" +
            "AND k.create_time &lt;= #{endTime} " +
            "</if>" +
            "GROUP BY k.create_time DESC LIMIT #{index} , #{endIndex}" +
            "</script>")
    List<K2UserFeedback> getFeedbackDatas(@Param("userFeedbackNumber") String userFeedbackNumber, @Param("userName") String userName,
                                          @Param("userFeedbackState") String userFeedbackState, @Param("startTime") Date startTime,
                                          @Param("endTime") Date endTime, @Param("index") Integer index, @Param("endIndex") Integer endIndex);
}
