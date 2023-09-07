package com.heiqi.chat.controller;


import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.UserPreference;
import com.heiqi.chat.service.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/UserPreference")
public class UserPreferenceController {
    private final UserPreferenceService userPreferenceService;

    @Autowired
    public UserPreferenceController(UserPreferenceService userPreferenceService) {
        this.userPreferenceService = userPreferenceService;

    }
    @GetMapping("/getUserPreferenceByUserId/{UserId}")
    public Result getUserPreferenceByUserId(@PathVariable("UserId") int UserId){
        UserPreference userPreference = userPreferenceService.getUserPreferenceByUserId(UserId);
        if (userPreference!=null){
            return Result.success(userPreference);
        }else {
            return Result.error("查找失败");
        }


    }


    @GetMapping("/getUserPreferenceByUserPreferenceID/{UserPreferenceId}")
    public Result getUserPreferenceByUserPreferenceID(@PathVariable("UserPreferenceId")int UserPreferenceId){
        UserPreference userPreference = userPreferenceService.getUserPreferenceByUserPreferenceID(UserPreferenceId);
        if (userPreference!=null){
            return Result.success(userPreference);
        }else {
            return Result.error("查找失败");
        }
    }


    @DeleteMapping("/deleteUserPreferenceByUserId/{UserId}")
    public Result deleteUserPreferenceByUserId(@PathVariable("UserId") int UserId){
        userPreferenceService.deleteUserPreferenceByUserId(UserId);
        return Result.success();
    }


    @PostMapping("/insertUserPreference")
    public Result insertUserPreference(@RequestBody UserPreference userPreference){
        UserPreference userPreference1 = userPreferenceService.insertUserPreference(userPreference);
        if (userPreference1!=null){
            return Result.success(userPreference1);
        }else {
            return Result.error("失败");
        }

    }

}
