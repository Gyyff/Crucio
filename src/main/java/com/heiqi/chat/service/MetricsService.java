package com.heiqi.chat.service;


import com.heiqi.chat.entity.Metrics;
import com.heiqi.chat.entity.MetricsChoice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface MetricsService {
    Metrics getMetricsByMetricID(int MetricID);

    Metrics getMetricsByUserID(int UserID);

    Metrics insertMetrics(Metrics metrics);

    int deleteByUserID(int UserID);

    int deleteByMetricID(int MetricID);

    MetricsChoice getMetricsChoiceByUserID(int userId);

    MetricsChoice upDateMetricsChoiceByUserId(MetricsChoice metricsChoice);

    MetricsChoice insertMetricsChoice(MetricsChoice metricsChoice);

    void deleteMetricsChoice(int userId);

//    int insertScoRel(int MetricID,int ScoRel);
}
