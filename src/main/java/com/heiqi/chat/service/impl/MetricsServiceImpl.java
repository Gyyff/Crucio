package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.Metrics;
import com.heiqi.chat.mapper.MetricsMapper;
import com.heiqi.chat.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricsServiceImpl implements MetricsService {
    private final MetricsMapper metricsMapper;

    @Autowired
    public MetricsServiceImpl(MetricsMapper metricsMapper) {
        this.metricsMapper = metricsMapper;
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
    public int insertMetrics(Metrics metrics) {
        return metricsMapper.insertMetrics(metrics);
    }

    @Override
    public int deleteByUserID(int UserID) {
        return metricsMapper.deleteByUserID(UserID);
    }

    @Override
    public int deleteByMetricID(int MetricID) {
        return metricsMapper.deleteByMetricID(MetricID);
    }


}
