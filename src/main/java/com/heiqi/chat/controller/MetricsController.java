package com.heiqi.chat.controller;

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
    public Metrics getMetricsByMetricID(@PathVariable("MetricID") int MetricID) {
        return metricsService.getMetricsByMetricID(MetricID);
    }

    @GetMapping("/getMetricsByUserID/{UserID}")
    public Metrics getMetricsByUserID(@PathVariable("UserID") int UserID) {
        return metricsService.getMetricsByUserID(UserID);
    }

    // 这里写更多的 getter 函数...

    @PostMapping("/insertMetrics")
    public void insertMetrics(@RequestBody Metrics metrics) {
        metricsService.insertMetrics(metrics);
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


