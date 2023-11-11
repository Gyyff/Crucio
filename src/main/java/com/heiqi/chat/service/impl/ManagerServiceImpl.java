package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.*;
import com.heiqi.chat.mapper.*;
import com.heiqi.chat.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerMapper managerMapper;
    private final BlogMapper blogMapper;
    private final FeedbackMapper feedbackMapper;
    private final UserPreferenceMapper userPreferenceMapper;

    private final MetricsMapper metricsMapper;

    private final UserMapper userMapper;

    @Autowired
    public ManagerServiceImpl(ManagerMapper managerMapper,BlogMapper blogMapper,FeedbackMapper feedbackMapper,UserPreferenceMapper userPreferenceMapper,MetricsMapper metricsMapper,UserMapper userMapper) {
        this.managerMapper = managerMapper;
        this.blogMapper=blogMapper;
        this.feedbackMapper=feedbackMapper;
        this.userMapper=userMapper;
        this.userPreferenceMapper=userPreferenceMapper;
        this.metricsMapper=metricsMapper;
    }
    @Override
    public Manager getManager(Manager manager) {
        String managerName = manager.getManagerName();
        String managerPassWord = manager.getManagerPassWord();
        return managerMapper.getManager(managerName,managerPassWord);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getUserTable();
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogMapper.getAllBlog();
    }

    @Override
    public List<FeedBack> getAllFeedback() {
        return feedbackMapper.getAllFeedback();
    }

    @Override
    public List<MetricsChoice> getAllMetricsChoice() {
        return metricsMapper.getAllMetricsChoice();
    }

    @Override
    public List<UserPreferenceFoundation> getAllUserPreferenceFoundation() {
        return userPreferenceMapper.getAllUserPreferenceFoundation();
    }

    @Override
    public List<UserPreferenceChoice> getAllUserPreferenceChoice() {
        return userPreferenceMapper.getAllUserPreferenceChoice();
    }
}
