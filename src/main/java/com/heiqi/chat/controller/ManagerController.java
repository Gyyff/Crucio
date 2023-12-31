package com.heiqi.chat.controller;


import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.*;
import com.heiqi.chat.service.ManagerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager")
public class ManagerController {
    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/getAllUsers")
    public Result getAllUsers(@RequestBody BaseUser baseUser) {
        List<User> allUsers = managerService.getAllUsers();
        if (allUsers!=null){
            return Result.success(allUsers);
        }else return Result.error("目前还没有用户数据");
    }

    @PostMapping("/getAllBlog")
    public Result getAllBlog(@RequestBody BaseUser baseUser) {
        List<Blog> allBlog = managerService.getAllBlog();
        if (allBlog!=null){
            return Result.success(allBlog);
        }else return Result.error("目前还没有用户个人资料数据");
    }

    @PostMapping("/getAllFeedback")
    public Result getAllFeedback(@RequestBody BaseUser baseUser) {
        List<FeedBack> allFeedback = managerService.getAllFeedback();
        if (allFeedback!=null){
            return Result.success(allFeedback);
        }else return Result.error("目前还没有反馈数据");
    }

    @PostMapping("/getAllMetricsChoice")
    public Result getAllMetricsChoice(@RequestBody BaseUser baseUser) {
        List<MetricsChoice> allMetricsChoice = managerService.getAllMetricsChoice();
        if (allMetricsChoice!=null){
            return Result.success(allMetricsChoice);
        }else return Result.error("目前还没有用户性格测试选项数据");
    }

    @PostMapping("/getAllUserPreferenceFoundation")
    public Result getAllUserPreferenceFoundation(@RequestBody BaseUser baseUser) {
        List<UserPreferenceFoundation> allUserPreferenceFoundation = managerService.getAllUserPreferenceFoundation();
        if (allUserPreferenceFoundation!=null){
            return Result.success(allUserPreferenceFoundation);
        }else return Result.error("目前还没有用户基础信息选项数据");
    }

    @PostMapping("/getAllUserPreferenceChoice")
    public Result getAllUserPreferenceChoice(@RequestBody BaseUser baseUser) {
        List<UserPreferenceChoice> allUserPreferenceChoice = managerService.getAllUserPreferenceChoice();
        if (allUserPreferenceChoice!=null){
            return Result.success(allUserPreferenceChoice);
        }else return Result.error("目前还没有用户偏好测试数据");
    }

}
