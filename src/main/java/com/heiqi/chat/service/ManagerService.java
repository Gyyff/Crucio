package com.heiqi.chat.service;

import com.heiqi.chat.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagerService {
    Manager getManager(Manager manager);


    List<User> getAllUsers();

    List<Blog> getAllBlog();

    List<FeedBack>  getAllFeedback();

    List<MetricsChoice> getAllMetricsChoice();

    List<UserPreferenceFoundation> getAllUserPreferenceFoundation();

    List<UserPreferenceChoice> getAllUserPreferenceChoice();
}
