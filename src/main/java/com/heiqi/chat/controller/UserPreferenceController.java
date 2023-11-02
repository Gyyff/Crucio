package com.heiqi.chat.controller;


import com.heiqi.chat.Utils.UserPerferenceUtils;
import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.UserPreference;
import com.heiqi.chat.entity.UserPreferenceChoice;
import com.heiqi.chat.entity.UserPreferenceFoundation;
import com.heiqi.chat.service.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/UserPreference")
public class UserPreferenceController {
    private final UserPreferenceService userPreferenceService;
    private final UserPerferenceUtils userPerferenceUtils;
    @Autowired
    public UserPreferenceController(UserPreferenceService userPreferenceService,UserPerferenceUtils userPerferenceUtils) {
        this.userPreferenceService = userPreferenceService;
        this.userPerferenceUtils = userPerferenceUtils;

    }

    @GetMapping("/getUserPreferenceByUserId/{UserId}")
    public Result getUserPreferenceByUserId(@PathVariable("UserId") int UserId) {
        UserPreference userPreference = userPreferenceService.getUserPreferenceByUserId(UserId);
        if (userPreference != null) {
            return Result.success(userPreference);
        } else {
            return Result.error("查找失败");
        }


    }

    @GetMapping("/getUserPreferenceFoundationByUserId/{UserId}")
    public Result getUserPreferenceFoundationByUserId(@PathVariable("UserId") int UserId) {
        UserPreferenceFoundation userPreferenceFoundationByUserId = userPreferenceService.getUserPreferenceFoundationByUserId(UserId);
        if (userPreferenceFoundationByUserId != null) {
            return Result.success(userPreferenceFoundationByUserId);
        } else return Result.error("查找失败");
    }

    @GetMapping("/getUserPreferenceByUserPreferenceID/{UserPreferenceId}")
    public Result getUserPreferenceByUserPreferenceID(@PathVariable("UserPreferenceId") int UserPreferenceId) {
        UserPreference userPreference = userPreferenceService.getUserPreferenceByUserPreferenceID(UserPreferenceId);
        if (userPreference != null) {
            return Result.success(userPreference);
        } else {
            return Result.error("查找失败");
        }
    }


    @DeleteMapping("/deleteUserPreferenceByUserId/{UserId}")
    public Result deleteUserPreferenceByUserId(@PathVariable("UserId") int UserId) {
        userPreferenceService.deleteUserPreferenceByUserId(UserId);
        return Result.success();
    }

    @PutMapping("/insertUserPreferenceFoundation")
    public Result insertUserPreferenceFoundation(@RequestBody UserPreferenceFoundation userPreferenceFoundation) {
        UserPreferenceFoundation userPreferenceFoundation1 = userPreferenceService.insertUserPreferenceFoundation(userPreferenceFoundation);
        return Result.success(userPreferenceFoundation1);
    }


    @PutMapping("/insertUserPreference")
    public Result insertUserPreference(@RequestBody UserPreferenceChoice userPreferenceChoice) {
       if (userPreferenceService.getUserPreferenceFoundationByUserId(userPreferenceChoice.getUserID())==null){
           return Result.error("请您先完成基础偏好测试");
       }if (userPreferenceService.getUserPreferenceChoiceByUserId(userPreferenceChoice.getUserID())==null) {
            UserPreferenceFoundation upf = userPreferenceService.getUserPreferenceFoundationByUserId(userPreferenceChoice.getUserID());
            UserPreference userPreference = userPerferenceUtils.UserPerferenceStructure(userPreferenceChoice, upf);
            userPreferenceService.insertUserPreference(userPreference);
            userPreferenceService.insertUserPreferenceChoice(userPreferenceChoice);
            UserPreferenceChoice usc = userPreferenceService.getUserPreferenceChoiceByUserId(userPreferenceChoice.getUserID());
            return Result.success(usc);
        }if (userPreferenceService.getUserPreferenceChoiceByUserId(userPreferenceChoice.getUserID())!=null){
            UserPreferenceFoundation upf = userPreferenceService.getUserPreferenceFoundationByUserId(userPreferenceChoice.getUserID());
            int userPreferenceID = userPreferenceService.getUserPreferenceByUserId(userPreferenceChoice.getUserID()).getUserPreferenceID();
            UserPreference userPreference = userPerferenceUtils.UserPerferenceStructure(userPreferenceChoice, upf);
            userPreference.setUserPreferenceID(userPreferenceID);
            UserPreferenceChoice choice = userPreferenceService.updateUserPreferenceChoiceIdByUserId(userPreferenceChoice);
            userPreferenceService.deleteUserPreferenceByUserId(userPreference.getUserID());
            userPreferenceService.insertUserPreference(userPreference);
            return Result.success(choice);
        }else return Result.error("提交失败");
    }


}
