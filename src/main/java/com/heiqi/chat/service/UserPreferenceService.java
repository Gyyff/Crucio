package com.heiqi.chat.service;

import com.heiqi.chat.entity.UserPreference;
import org.springframework.stereotype.Service;

@Service
public interface UserPreferenceService {
    UserPreference getUserPreferenceByUserId(int UserId);

    UserPreference getUserPreferenceByUserPreferenceID(int UserPreferenceId);

    void deleteUserPreferenceByUserId(int UserId);

    UserPreference insertUserPreference(UserPreference userPreference);
}
