package com.heiqi.chat.controller;


import com.baomidou.mybatisplus.generator.IFill;
import com.heiqi.chat.Utils.UserPerferenceUtils;
import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.UserPreference;
import com.heiqi.chat.entity.UserPreferenceChoice;
import com.heiqi.chat.entity.UserPreferenceFoundation;
import com.heiqi.chat.service.UserPreferenceService;
import com.heiqi.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/UserPreference")
public class UserPreferenceController {
    private final UserPreferenceService userPreferenceService;
    private final UserPerferenceUtils userPerferenceUtils;



    @Autowired
    public UserPreferenceController(UserPreferenceService userPreferenceService, UserPerferenceUtils userPerferenceUtils) {
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

    @GetMapping("/getUserPreferenceChoiceByUserId/{UserId}")
    public Result getUserPreferenceChoiceByUserId(@PathVariable("UserId") int UserId){
        UserPreferenceChoice userPreferenceChoiceByUserId = userPreferenceService.getUserPreferenceChoiceByUserId(UserId);
        if (userPreferenceChoiceByUserId!=null){
            return Result.success(userPreferenceChoiceByUserId);
        }
        return Result.error();

    }

    @GetMapping("/getUserPreferenceFoundationByUserId/{UserId}")
    public Result getUserPreferenceFoundationByUserId(@PathVariable("UserId") int UserId) {
        UserPreferenceFoundation userPreferenceFoundationByUserId = userPreferenceService.getUserPreferenceFoundationByUserId(UserId);
        if (userPreferenceFoundationByUserId!=null){
            return Result.success(userPreferenceFoundationByUserId);
        }else return Result.error();

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
        if ((userPreferenceFoundation.getSex()==null)||(userPreferenceFoundation.getEducation()==null)){
            return Result.error("请重新填写选项提交");
        }
        int userId = userPreferenceFoundation.getUserId();
        UserPreferenceChoice choice = userPreferenceService.getUserPreferenceChoiceByUserId(userId);
        UserPreferenceFoundation foundation = userPreferenceService.getUserPreferenceFoundationByUserId(userId);
        if ((choice==null)&&(foundation==null)){
            UserPreferenceFoundation foundation1 = userPreferenceService.insertUserPreferenceFoundation(userPreferenceFoundation);
            return Result.success(foundation1);
        }if ((choice==null)&&(foundation!=null)){
            userPreferenceService.deleteUserPreferenceFoundationByUserId(userId);
            UserPreferenceFoundation foundation1 = userPreferenceService.insertUserPreferenceFoundation(userPreferenceFoundation);
            return Result.success(foundation1);
        }if ((choice!=null)&&(foundation==null)){
            UserPreferenceFoundation foundation1 = userPreferenceService.insertUserPreferenceFoundation(userPreferenceFoundation);
            UserPreference userPreference = userPerferenceUtils.UserPerferenceStructure(choice, userPreferenceFoundation);
            if (userPreferenceService.getUserPreferenceByUserId(userId)!=null){
                userPreferenceService.deleteUserPreferenceByUserId(userId);
                userPreferenceService.insertUserPreference(userPreference);
            } if (userPreferenceService.getUserPreferenceByUserId(userId)==null){
                userPreferenceService.insertUserPreference(userPreference);
            }
            return Result.success(foundation1);
        }if ((choice!=null)&&(foundation!=null)){
            userPreferenceService.deleteUserPreferenceFoundationByUserId(userId);
            userPreferenceService.insertUserPreferenceFoundation(userPreferenceFoundation);
            UserPreference userPreference = userPerferenceUtils.UserPerferenceStructure(choice, userPreferenceFoundation);
            if (userPreferenceService.getUserPreferenceByUserId(userId)!=null){
                userPreferenceService.deleteUserPreferenceByUserId(userId);
                userPreferenceService.insertUserPreference(userPreference);
            } if (userPreferenceService.getUserPreferenceByUserId(userId)==null){
                userPreferenceService.insertUserPreference(userPreference);
            }
            UserPreferenceFoundation userPreferenceFoundationByUserId = userPreferenceService.getUserPreferenceFoundationByUserId(userId);
            return Result.success(userPreferenceFoundationByUserId);
        }
        else return Result.error("提交失败");
    }


    @PutMapping("/insertUserPreference")
    public Result insertUserPreference(@RequestBody UserPreferenceChoice userPreferenceChoice) {
        int userId = userPreferenceChoice.getUserId();
        UserPreferenceChoice choice = userPreferenceService.getUserPreferenceChoiceByUserId(userId);
        UserPreferenceFoundation foundation = userPreferenceService.getUserPreferenceFoundationByUserId(userId);
        if ((choice==null)&&(foundation==null)){
            UserPreferenceChoice choice1 = userPreferenceService.insertUserPreferenceChoice(userPreferenceChoice);
            return Result.success(choice1);
        }if ((choice==null)&&(foundation!=null)){
            UserPreference userPreference = userPerferenceUtils.UserPerferenceStructure(userPreferenceChoice, foundation);
            UserPreferenceChoice choice1 = userPreferenceService.insertUserPreferenceChoice(userPreferenceChoice);
            if (userPreferenceService.getUserPreferenceByUserId(userId)!=null){
                userPreferenceService.deleteUserPreferenceByUserId(userId);
                userPreferenceService.insertUserPreference(userPreference);
            } if (userPreferenceService.getUserPreferenceByUserId(userId)==null){
                userPreferenceService.insertUserPreference(userPreference);
            }
            return Result.success(choice1);
        }if ((choice!=null)&&(foundation==null)){
            userPreferenceService.deleteUserPreferenceChoiceByUserId(userId);
            UserPreferenceChoice choice1 = userPreferenceService.insertUserPreferenceChoice(userPreferenceChoice);
            return Result.success(choice1);
        }if ((choice!=null)&&(foundation!=null)){
            userPreferenceService.deleteUserPreferenceChoiceByUserId(userId);
            UserPreferenceChoice choice1 = userPreferenceService.insertUserPreferenceChoice(userPreferenceChoice);
            UserPreference userPreference = userPerferenceUtils.UserPerferenceStructure(userPreferenceChoice, foundation);
            if (userPreferenceService.getUserPreferenceByUserId(userId)!=null){
                userPreferenceService.deleteUserPreferenceByUserId(userId);
                userPreferenceService.insertUserPreference(userPreference);
            } if (userPreferenceService.getUserPreferenceByUserId(userId)==null){
                userPreferenceService.insertUserPreference(userPreference);
            }

            return Result.success(choice1);
        }
        else return Result.error("提交失败");
    }


}
