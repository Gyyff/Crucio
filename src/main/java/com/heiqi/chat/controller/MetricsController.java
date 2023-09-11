package com.heiqi.chat.controller;

import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.Metrics;
import com.heiqi.chat.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/info")
public class MetricsController {
    private final MetricsService metricsService;

    @Autowired
    public MetricsController(MetricsService metricsService) {
        this.metricsService = metricsService;
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

    // 这里写更多的 getter 函数...

    @PutMapping("/insertMetrics")
    public Result insertMetrics(@RequestBody Metrics metrics) {
        Metrics metrics1 = metricsService.insertMetrics(metrics);
        return Result.success(metrics1);
    }

    @DeleteMapping("deleteByUserID/{UserId}")
    public void deleteByUserID(@PathVariable("UserId") int UserId) {
        metricsService.deleteByUserID(UserId);
    }

    @DeleteMapping("deleteByMetricID/{MetricID}")
    public void deleteByMetricID(@PathVariable("MetricID") int MetricID) {
        metricsService.deleteByMetricID(MetricID);
    }

    // 这里写更多的 setter 函数...
}


