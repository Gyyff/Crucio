package com.heiqi.chat.controller;

import com.heiqi.chat.Utils.MetricsUtils;
import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.BaseUser;
import com.heiqi.chat.entity.Metrics;
import com.heiqi.chat.entity.MetricsChoice;
import com.heiqi.chat.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/info")
public class MetricsController {
    private final MetricsService metricsService;
    private final MetricsUtils metricsUtils;

    @Autowired
    public MetricsController(MetricsService metricsService,MetricsUtils metricsUtils) {
        this.metricsService = metricsService;
        this.metricsUtils = metricsUtils;
    }

    @GetMapping("/getMetricsByMetricID/{MetricID}")
    public Result getMetricsByMetricID(@PathVariable("MetricID") int MetricID) {
        Metrics metrics = metricsService.getMetricsByMetricID(MetricID);
        return Result.success(metrics);
    }

    @GetMapping("/getMetricsByUserID/{UserID}")
    public Result getMetricsByUserID(@PathVariable("UserID") int UserID) {
        Metrics metrics = metricsService.getMetricsByUserID(UserID);
        return Result.success(metrics);
    }

    @GetMapping("/getMetricsChoiceByUserID/{UserID}")
    public Result getMetricsChoiceByUserID(@PathVariable("UserID") int UserID) {
        MetricsChoice metricsChoiceByUserID = metricsService.getMetricsChoiceByUserID(UserID);
        return Result.success(metricsChoiceByUserID);
    }


    // 这里写更多的 getter 函数...

    @PutMapping("/insertMetrics")
    public Result insertMetrics(@RequestBody MetricsChoice metricsChoice, BaseUser baseUser) {
        if (metricsService.getMetricsChoiceByUserID(metricsChoice.getUserID())!=null){
            Metrics metricsByUserID = metricsService.getMetricsByUserID(metricsChoice.getUserID());
            int metricID = metricsByUserID.getMetricID();
            Metrics metrics = metricsUtils.MetricsStructure(metricsChoice);
            metrics.setMetricID(metricID);
            metricsService.upDateMetricsChoiceByUserId(metricsChoice);
            metricsService.deleteByUserID(metricsChoice.getUserID());
            metricsService.insertMetrics(metrics);
            MetricsChoice metricsChoiceByUserID = metricsService.getMetricsChoiceByUserID(metricsChoice.getUserID());
            return Result.success(metricsChoiceByUserID);
        }else {
            Metrics metrics = metricsUtils.MetricsStructure(metricsChoice);
            metricsService.insertMetricsChoice(metricsChoice);
            metricsService.insertMetrics(metrics);
            MetricsChoice metricsChoiceByUserID = metricsService.getMetricsChoiceByUserID(metricsChoice.getUserID());
            return Result.success(metrics);
        }

    }

    @DeleteMapping("deleteByUserID/{UserId}")
    public void deleteByUserID(@PathVariable("UserId") int UserId, BaseUser baseUser) {
        metricsService.deleteByUserID(UserId);
    }

    @DeleteMapping("deleteByMetricID/{MetricID}")
    public void deleteByMetricID(@PathVariable("MetricID") int MetricID, BaseUser baseUser) {
        metricsService.deleteByMetricID(MetricID);
    }

    // 这里写更多的 setter 函数...
}


