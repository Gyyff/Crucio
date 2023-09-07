package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.UserPreference;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface UserPreferenceMapper {
    @Select("SELECT * FROM userpreference WHERE UserId = #{UserId}")
    UserPreference getUserPreferenceByUserId(@Param("UserId") int UserId);

    @Select("SELECT * FROM userpreference WHERE UserPreferenceId = #{UserPreferenceId}")
    UserPreference getUserPreferenceByUserPreferenceID(@Param("UserPreferenceId") int UserPreferenceId);

    @Insert("INSERT INTO userpreference(userPreferenceID, userID,sex,education,ageMax, ageMin,curiosity, readly, abstractness, intellectual, openl, tryNew,idea, standard, hc, fs,adventure,achievement,aesthetic,excitement,rebel,altruism,emotion,characterl,organization,inductive,attitudes,selfish,male) VALUES(#{userPreferenceID},#{userID},#{sex},#{education},#{ageMax},#{ageMin},#{curiosity},#{readly},#{abstractness},#{intellectual},#{openl},#{tryNew},#{idea},#{standard},#{hc},#{fs},#{adventure},#{achievement},#{aesthetic},#{excitement},#{rebel},#{altruism},#{emotion},#{characterl},#{organization},#{inductive},#{attitudes},#{selfish},#{male})")
    @Options(useGeneratedKeys = true, keyProperty = "userPreferenceID")
    int insertUserPreference(UserPreference userPreference);

    @Delete("DELETE FROM userpreference WHERE UserID = #{UserID}")
    void deleteUserPreferenceByUserId(@Param("UserID") int UserID);



}
