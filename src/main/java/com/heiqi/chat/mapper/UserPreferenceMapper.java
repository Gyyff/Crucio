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

    @Update("UPDATE userpreference SET curiosity = #{curiosity} WHERE UserId = #{UserId}")
    int updateCuriosity(@Param("UserId") int UserId, @Param("curiosity") int curiosity);

    @Update("UPDATE userpreference SET readly = #{readly} WHERE UserId = #{UserId}")
    int updateReadLy(@Param("UserId") int UserId, @Param("readly") int readly);

    @Update("UPDATE userpreference SET abstractness = #{abstractness} WHERE UserId = #{UserId}")
    int updateAbstractness(@Param("UserId") int UserId, @Param("abstractness") int abstractness);

    @Update("UPDATE userpreference SET intellectual = #{intellectual} WHERE UserId = #{UserId}")
    int updateIntellectual(@Param("UserId") int UserId, @Param("intellectual") int intellectual);

    @Update("UPDATE userpreference SET openl = #{openl} WHERE UserId = #{UserId}")
    int updateOpenL(@Param("UserId") int UserId, @Param("openl") int openl);

    @Update("UPDATE userpreference SET tryNew = #{tryNew} WHERE UserId = #{UserId}")
    int updateTryNew(@Param("UserId") int UserId, @Param("tryNew") int tryNew);
    @Update("UPDATE userpreference SET idea = #{idea} WHERE UserId = #{UserId}")
    int updateIdea(@Param("UserId") int UserId, @Param("idea") int idea);

    @Update("UPDATE userpreference SET standard = #{standard} WHERE UserId = #{UserId}")
    int updateStandard(@Param("UserId") int UserId, @Param("standard") int standard);

    @Update("UPDATE userpreference SET hc = #{hc} WHERE UserId = #{UserId}")
    int updateHc(@Param("UserId") int UserId, @Param("hc") int hc);

    @Update("UPDATE userpreference SET fs = #{fs} WHERE UserId = #{UserId}")
    int updateFs(@Param("UserId") int UserId, @Param("fs") int fs);

    @Update("UPDATE userpreference SET adventure = #{adventure} WHERE UserId = #{UserId}")
    int updateAdventure(@Param("UserId") int UserId, @Param("adventure") int adventure);

    @Update("UPDATE userpreference SET achievement = #{achievement} WHERE UserId = #{UserId}")
    int updateAchievement(@Param("UserId") int UserId, @Param("achievement") int achievement);

    @Update("UPDATE userpreference SET aesthetic = #{aesthetic} WHERE UserId = #{UserId}")
    int updateAesthetic(@Param("UserId") int UserId, @Param("aesthetic") int aesthetic);

    @Update("UPDATE userpreference SET excitement = #{excitement} WHERE UserId = #{UserId}")
    int updateExcitement(@Param("UserId") int UserId, @Param("excitement") int excitement);

    @Update("UPDATE userpreference SET rebel = #{rebel} WHERE UserId = #{UserId}")
    int updateRebel(@Param("UserId") int UserId, @Param("rebel") int rebel);

    @Update("UPDATE userpreference SET altruism = #{altruism} WHERE UserId = #{UserId}")
    int updateAltruism(@Param("UserId") int UserId, @Param("altruism") int altruism);

    @Update("UPDATE userpreference SET emotion = #{emotion} WHERE UserId = #{UserId}")
    int updateEmotion(@Param("UserId") int UserId, @Param("emotion") int emotion);

    @Update("UPDATE userpreference SET characterl = #{characterl} WHERE UserId = #{UserId}")
    int updateCharacterL(@Param("UserId") int UserId, @Param("characterl") int characterl);

    @Update("UPDATE userpreference SET organization = #{organization} WHERE UserId = #{UserId}")
    int updateOrganization(@Param("UserId") int UserId, @Param("organization") int organization);

    @Update("UPDATE userpreference SET inductive = #{inductive} WHERE UserId = #{UserId}")
    int updateInductive(@Param("UserId") int UserId, @Param("inductive") int inductive);

    @Update("UPDATE userpreference SET attitudes = #{attitudes} WHERE UserId = #{UserId}")
    int updateAttitudes(@Param("UserId") int UserId, @Param("attitudes") int attitudes);

    @Update("UPDATE userpreference SET selfish = #{selfish} WHERE UserId = #{UserId}")
    int updateSelfish(@Param("UserId") int UserId, @Param("selfish") int selfish);

    @Update("UPDATE userpreference SET male = #{male} WHERE UserId = #{UserId}")
    int updateMale(@Param("UserId") int UserId, @Param("male") int male);


}
