package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.FeedBack;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FeedbackMapper {
    @Select("SELECT * FROM feedback WHERE feedbackId = #{feedbackId}")
    FeedBack getFeedbackByFeedbackID(@Param("feedbackId") int feedbackId);

    @Select("SELECT * FROM feedback ")
    List<FeedBack> getAllFeedback();
    @Select("SELECT * FROM feedback WHERE UserID = #{userId}")
    List<FeedBack> getFeedbackByUserID(@Param("userId") int userId);

    @Insert("INSERT INTO feedback(feedbackId, userId, user2Id,overallPoint,manyChoice,thoughtQ,valuesQ,lifeQ,characterQ,conflictQ,humiliationQ,supplementQ) VALUES(#{feedbackId}, #{userId}, #{user2Id},#{overallPoint},#{manyChoice},#{thoughtQ},#{valuesQ},#{lifeQ},#{characterQ},#{conflictQ},#{humiliationQ},#{supplementQ})")
    @Options(useGeneratedKeys = true, keyProperty = "feedbackId")
    int insertFeedBack(FeedBack feedBack);

    @Delete("DELETE FROM feedback WHERE FeedbackID = #{FeedbackID}")
    int deleteFeedBack(@Param("FeedbackID") int FeedbackID);

}
