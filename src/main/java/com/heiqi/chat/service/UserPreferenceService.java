package com.heiqi.chat.service;

import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.UserPreference;
import com.heiqi.chat.entity.UserPreferenceChoice;
import com.heiqi.chat.entity.UserPreferenceFoundation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
public interface UserPreferenceService {
    UserPreference getUserPreferenceByUserId(int UserId);

    UserPreference getUserPreferenceByUserPreferenceID(int UserPreferenceId);

    void deleteUserPreferenceByUserId(int UserId);

    UserPreference insertUserPreference(UserPreference userPreference);

    UserPreferenceFoundation insertUserPreferenceFoundation(UserPreferenceFoundation userPreferenceFoundation);


    UserPreferenceFoundation getUserPreferenceFoundationByUserId(int userId);


    UserPreferenceChoice insertUserPreferenceChoice(UserPreferenceChoice userPreferenceChoice);

    UserPreferenceChoice updateUserPreferenceChoiceIdByUserId(UserPreferenceChoice userPreferenceChoice);

    UserPreferenceChoice getUserPreferenceChoiceByUserId(int userId);

    UserPreferenceFoundation updateUserPreferenceFoundationByUserId(UserPreferenceFoundation userPreferenceFoundation);
    int updateCuriosity(int UserId, int curiosity);


    int updateReadLy(int UserId, int readly);


    int updateAbstractness(int UserId, int abstractness);


    int updateIntellectual(int UserId, int intellectual);


    int updateOpenL(int UserId, int openl);


    int updateTryNew(int UserId, int tryNew);

    int updateIdea(int UserId, int idea);


    int updateStandard(int UserId, int standard);


    int updateHc(int UserId, int hc);


    int updateFs(int UserId, int fs);


    int updateAdventure(int UserId, int adventure);


    int updateAchievement(int UserId, int achievement);


    int updateAesthetic(int UserId, int aesthetic);


    int updateExcitement(int UserId, int excitement);


    int updateRebel(int UserId, int rebel);


    int updateAltruism(int UserId, int altruism);


    int updateEmotion(int UserId, int emotion);


    int updateCharacterL(int UserId, int characterl);


    int updateOrganization(int UserId, int organization);


    int updateInductive(int UserId, int inductive);


    int updateAttitudes(int UserId, int attitudes);


    int updateSelfish(int UserId, int selfish);


    int updateMale(int UserId, int male);



    int updateSex(int UserId,int sex);



    int updateEducation(int UserId, int education);


    int updateAgeMax( int UserId,int ageMax);


    int updateAgeMin(int UserId,int ageMin);

    void deleteUserPreferenceFoundationByUserId(int userId);

    void deleteUserPreferenceChoiceByUserId(int userId);

}
