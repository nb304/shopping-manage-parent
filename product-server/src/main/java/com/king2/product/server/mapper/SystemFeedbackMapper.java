package com.king2.product.server.mapper;

import com.king2.commons.pojo.K2SystemFeedback;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * 系统通知Mapper
 */
public interface SystemFeedbackMapper {

    @Select("<script>" +
            "SELECT * FROM (\n" +
            "SELECT * FROM k2_system_feedback \n" +
            "WHERE is_common = 0 OR  retain1 = 1 OR  belong_user_id = 2\n" +
            ")a1 WHERE a1.feedback_state != 3 " +
            "<if test='feedbackState != null'>" +
            " AND a1.feedback_state = #{feedbackState}" +
            "</if>" +
            "<if test='startTime != null'>" +
            " AND create_time &gt;= #{startTime}" +
            "</if>" +
            "</script>")
    List<K2SystemFeedback> getSystemFeedbackCount(@Param("feedbackState") Integer feedbackState,
                                                  @Param("startTime") Date startTime);
}
