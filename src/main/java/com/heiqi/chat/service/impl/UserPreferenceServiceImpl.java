package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.UserPreference;
import com.heiqi.chat.mapper.UserPreferenceMapper;
import com.heiqi.chat.service.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPreferenceServiceImpl implements UserPreferenceService {


    private UserPreferenceMapper userPreferenceMapper;


    @Autowired
    public UserPreferenceServiceImpl(UserPreferenceMapper userPreferenceMapper) {
        this.userPreferenceMapper=userPreferenceMapper;
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
        }
        return userPreferenceMapper.getUserPreferenceByUserId(userPreference.getUserID());
    }
}
