package com.heiqi.chat.service.impl;

import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.UserPreference;
import com.heiqi.chat.entity.UserPreferenceChoice;
import com.heiqi.chat.entity.UserPreferenceFoundation;
import com.heiqi.chat.mapper.UserMapper;
import com.heiqi.chat.mapper.UserPreferenceMapper;
import com.heiqi.chat.service.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPreferenceServiceImpl implements UserPreferenceService {


    private UserPreferenceMapper userPreferenceMapper;
    private UserMapper userMapper;


    @Autowired
    public UserPreferenceServiceImpl(UserPreferenceMapper userPreferenceMapper,UserMapper userMapper) {
        this.userPreferenceMapper=userPreferenceMapper;
        this.userMapper=userMapper;
    }

    @Override
    public UserPreference getUserPreferenceByUserId(int UserId) {
        return userPreferenceMapper.getUserPreferenceByUserId(UserId);
    }

    @Override
    public UserPreference getUserPreferenceByUserPreferenceID(int UserPreferenceId) {
        return userPreferenceMapper.getUserPreferenceByUserPreferenceID(UserPreferenceId);
    }

    @Override
    public void deleteUserPreferenceByUserId(int UserId) {
        userPreferenceMapper.deleteUserPreferenceByUserId(UserId);
    }

    @Override
    public UserPreference insertUserPreference(UserPreference userPreference) {
        if (userPreferenceMapper.getUserPreferenceByUserId(userPreference.getUserID())==null){
            userPreferenceMapper.insertUserPreference(userPreference);
            userMapper.updateUserIsPreference(userPreference.getUserID(),1);

        }
        return userPreferenceMapper.getUserPreferenceByUserId(userPreference.getUserID());
    }

    @Override
    public UserPreferenceFoundation insertUserPreferenceFoundation(UserPreferenceFoundation userPreferenceFoundation) {
        userPreferenceMapper.insertUserPreferenceFoundation(userPreferenceFoundation);
        UserPreferenceFoundation userPreferenceFoundationByUserId = userPreferenceMapper.getUserPreferenceFoundationByUserId(userPreferenceFoundation.getUserId());
        return userPreferenceFoundationByUserId;
    }

    @Override
    public UserPreferenceFoundation getUserPreferenceFoundationByUserId(int userId) {
        UserPreferenceFoundation userPreferenceFoundationByUserId = userPreferenceMapper.getUserPreferenceFoundationByUserId(userId);
        return userPreferenceFoundationByUserId;
    }

    @Override
    public UserPreferenceChoice insertUserPreferenceChoice(UserPreferenceChoice userPreferenceChoice) {
        userPreferenceMapper.insertUserPreferenceChoice(userPreferenceChoice);
        UserPreferenceChoice userPreferenceChoiceByUserId = userPreferenceMapper.getUserPreferenceChoiceByUserId(userPreferenceChoice.getUserId());
        return userPreferenceChoiceByUserId;
    }

    @Override
    public UserPreferenceChoice updateUserPreferenceChoiceIdByUserId(UserPreferenceChoice userPreferenceChoice) {
        userPreferenceMapper.updateUserPreferenceChoiceIdByUserId(userPreferenceChoice,userPreferenceChoice.getUserId());
        UserPreferenceChoice userPreferenceChoiceByUserId = userPreferenceMapper.getUserPreferenceChoiceByUserId(userPreferenceChoice.getUserId());
        return userPreferenceChoiceByUserId;
    }

    @Override
    public UserPreferenceChoice getUserPreferenceChoiceByUserId(int userId) {
        return userPreferenceMapper.getUserPreferenceChoiceByUserId(userId);
    }

    @Override
    public UserPreferenceFoundation updateUserPreferenceFoundationByUserId(UserPreferenceFoundation userPreferenceFoundation) {
        userPreferenceMapper.updateUserPreferenceFoundationByUserId(userPreferenceFoundation,userPreferenceFoundation.getUserId());
        UserPreferenceFoundation userPreferenceFoundationByUserId = userPreferenceMapper.getUserPreferenceFoundationByUserId(userPreferenceFoundation.getUserId());
        return userPreferenceFoundationByUserId;
    }

    @Override
    public int updateCuriosity(int UserId, int curiosity) {
        return userPreferenceMapper.updateCuriosity(UserId,curiosity);
    }

    @Override
    public int updateReadLy(int UserId, int readly) {
        return userPreferenceMapper.updateReadLy(UserId,readly);
    }

    @Override
    public int updateAbstractness(int UserId, int abstractness) {
        return userPreferenceMapper.updateAbstractness(UserId,abstractness);
    }

    @Override
    public int updateIntellectual(int UserId, int intellectual) {
        return userPreferenceMapper.updateIntellectual(UserId,intellectual);
    }

    @Override
    public int updateOpenL(int UserId, int openl) {
        return userPreferenceMapper.updateOpenL(UserId,openl);
    }

    @Override
    public int updateTryNew(int UserId, int tryNew) {
        return userPreferenceMapper.updateTryNew(UserId,tryNew);
    }

    @Override
    public int updateIdea(int UserId, int idea) {
        return userPreferenceMapper.updateIdea(UserId,idea);
    }

    @Override
    public int updateStandard(int UserId, int standard) {
        return userPreferenceMapper.updateStandard(UserId,standard);
    }

    @Override
    public int updateHc(int UserId, int hc) {
        return userPreferenceMapper.updateHc(UserId,hc);
    }

    @Override
    public int updateFs(int UserId, int fs) {
        return userPreferenceMapper.updateFs(UserId,fs);
    }

    @Override
    public int updateAdventure(int UserId, int adventure) {
        return userPreferenceMapper.updateAdventure(UserId,adventure);
    }

    @Override
    public int updateAchievement(int UserId, int achievement) {
        return userPreferenceMapper.updateAchievement(UserId,achievement);
    }

    @Override
    public int updateAesthetic(int UserId, int aesthetic) {
        return userPreferenceMapper.updateAesthetic(UserId,aesthetic);
    }

    @Override
    public int updateExcitement(int UserId, int excitement) {
        return userPreferenceMapper.updateExcitement(UserId,excitement);
    }

    @Override
    public int updateRebel(int UserId, int rebel) {
        return userPreferenceMapper.updateRebel(UserId,rebel);
    }

    @Override
    public int updateAltruism(int UserId, int altruism) {
        return userPreferenceMapper.updateAltruism(UserId,altruism);
    }

    @Override
    public int updateEmotion(int UserId, int emotion) {
        return userPreferenceMapper.updateEmotion(UserId,emotion);
    }

    @Override
    public int updateCharacterL(int UserId, int characterl) {
        return userPreferenceMapper.updateCharacterL(UserId,characterl);
    }

    @Override
    public int updateOrganization(int UserId, int organization) {
        return userPreferenceMapper.updateOrganization(UserId,organization);
    }

    @Override
    public int updateInductive(int UserId, int inductive) {
        return userPreferenceMapper.updateInductive(UserId,inductive);
    }

    @Override
    public int updateAttitudes(int UserId, int attitudes) {
        return userPreferenceMapper.updateAttitudes(UserId,attitudes);
    }

    @Override
    public int updateSelfish(int UserId, int selfish) {
        return userPreferenceMapper.updateSelfish(UserId,selfish);
    }

    @Override
    public int updateMale(int UserId, int male) {
        return userPreferenceMapper.updateMale(UserId,male);
    }

    @Override
    public int updateSex(int UserId, int sex) {
        return userPreferenceMapper.updateSex(UserId,sex);
    }

    @Override
    public int updateEducation(int UserId, int education) {
        return userPreferenceMapper.updateEducation(UserId,education);
    }

    @Override
    public int updateAgeMax(int UserId, int ageMax) {
        return userPreferenceMapper.updateAgeMax(UserId,ageMax);
    }

    @Override
    public int updateAgeMin(int UserId, int ageMin) {
        return userPreferenceMapper.updateAgeMin(UserId,ageMin);
    }

    @Override
    public void deleteUserPreferenceFoundationByUserId(int userId) {
        userPreferenceMapper.deleteUserPreferenceFoundationByUserId(userId);
    }

    @Override
    public void deleteUserPreferenceChoiceByUserId(int userId) {
        userPreferenceMapper.deleteUserPreferenceChoiceByUserId(userId);
    }
}
