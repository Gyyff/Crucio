package com.heiqi.chat.service;


import com.heiqi.chat.entity.Metrics;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface MetricsService {
    Metrics getMetricsByMetricID(int MetricID);

    Metrics getMetricsByUserID(int UserID);

    Metrics insertMetrics(Metrics metrics);

    int deleteByUserID(int UserID);

    int deleteByMetricID(int MetricID);

//    int insertScoRel(int MetricID,int ScoRel);
}
