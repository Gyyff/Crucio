package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.Metrics;
import com.heiqi.chat.entity.MetricsChoice;
import com.heiqi.chat.mapper.MetricsMapper;
import com.heiqi.chat.mapper.UserMapper;
import com.heiqi.chat.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricsServiceImpl implements MetricsService {
    private final MetricsMapper metricsMapper;
    private final UserMapper userMapper;

    @Autowired
    public MetricsServiceImpl(MetricsMapper metricsMapper,UserMapper userMapper) {
        this.metricsMapper = metricsMapper;
        this.userMapper = userMapper;
    }
    @Override
    public Metrics getMetricsByMetricID(int MetricID) {
        return metricsMapper.getMetricsByMetricID(MetricID);
    }

    @Override
    public Metrics getMetricsByUserID(int UserID) {
        return metricsMapper.getMetricsByUserID(UserID);
    }

    @Override
    public Metrics insertMetrics(Metrics metrics) {
        if (metricsMapper.getMetricsByUserID(metrics.getUserID())==null){
            metricsMapper.insertMetrics(metrics);
            userMapper.updateUserIsTested(metrics.getUserID(),1);
        }
        return metricsMapper.getMetricsByUserID(metrics.getUserID());
    }

    @Override
    public int deleteByUserID(int UserID) {
        return metricsMapper.deleteByUserID(UserID);
    }

    @Override
    public int deleteByMetricID(int MetricID) {
        return metricsMapper.deleteByMetricID(MetricID);
    }

    @Override
    public MetricsChoice getMetricsChoiceByUserID(int userId) {
        return metricsMapper.getMetricsChoiceByUserID(userId);
    }

    @Override
    public MetricsChoice upDateMetricsChoiceByUserId(MetricsChoice metricsChoice) {
        metricsMapper.upDateMetricsChoiceByUserId(metricsChoice,metricsChoice.getUserId());
        MetricsChoice metricsChoiceByUserID = metricsMapper.getMetricsChoiceByUserID(metricsChoice.getUserId());
        return metricsChoiceByUserID;
    }

    @Override
    public MetricsChoice insertMetricsChoice(MetricsChoice metricsChoice) {
        metricsMapper.insertMetricsChoice(metricsChoice);
        MetricsChoice metricsChoiceByUserID = metricsMapper.getMetricsChoiceByUserID(metricsChoice.getUserId());
        return metricsChoiceByUserID;
    }

    @Override
    public void deleteMetricsChoice(int userId) {
        metricsMapper.deleteMetricsChoiceByUserId(userId);
    }


}
