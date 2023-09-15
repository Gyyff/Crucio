package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.FeedBack;
import org.apache.ibatis.annotations.*;

public interface FeedbackMapper {
    @Select("SELECT * FROM feedback WHERE FeedbackID = #{FeedbackID}")
    FeedBack getFeedbackByFeedbackID(@Param("FeedbackID") int FeedbackID);

    @Select("SELECT * FROM feedback WHERE UserID = #{UserID}")
    FeedBack getFeedbackByUserID(@Param("UserID") int UserID);

    @Insert("INSERT INTO feedback(FeedbackID, UserID, Content,FeedbackTime) VALUES(#{FeedbackID}, #{UserID}, #{Content},#{FeedbackTime})")
    @Options(useGeneratedKeys = true, keyProperty = "FeedbackID")
    int insertFeedBack(FeedBack feedBack);

    @Delete("DELETE FROM feedback WHERE FeedbackID = #{FeedbackID}")
    int deleteFeedBack(@Param("FeedbackID") int FeedbackID);

    @Update("UPDATE feedback SET Content = #{Content} WHERE UserID = #{UserID}")
    int updateFeedBackContent(@Param("UserID") int UserID, @Param("Content") String Content);
}
