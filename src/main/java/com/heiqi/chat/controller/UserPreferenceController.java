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


    @PutMapping("/insertUserPreference")
    public Result insertUserPreference(@RequestBody UserPreference userPreference){
        UserPreference userPreferenceByUserId = userPreferenceService.getUserPreferenceByUserId(userPreference.getUserID());
        if (userPreferenceByUserId==null){
            UserPreference userPreference1 = userPreferenceService.insertUserPreference(userPreference);
            return Result.success(userPreference1);
        }if (userPreferenceByUserId!=null){
            int id = userPreference.getUserID();
            userPreferenceService.deleteUserPreferenceByUserId(id);
            userPreferenceService.insertUserPreference(userPreference);
//            userPreferenceService.updateCuriosity(id,userPreference.getCuriosity());
//            userPreferenceService.updateReadLy(id,userPreference.getReadly());
//            userPreferenceService.updateAbstractness(id,userPreference.getAbstractness());
//            userPreferenceService.updateIntellectual(id,userPreference.getIntellectual());
//            userPreferenceService.updateOpenL(id,userPreference.getOpenl());
//            userPreferenceService.updateTryNew(id,userPreference.getTryNew());
//            userPreferenceService.updateIdea(id,userPreference.getIdea());
//            userPreferenceService.updateStandard(id,userPreference.getStandard());
//            userPreferenceService.updateHc(id,userPreference.getHc());
//            userPreferenceService.updateFs(id,userPreference.getFs());
//            userPreferenceService.updateAdventure(id,userPreference.getAdventure());
//            userPreferenceService.updateAchievement(id,userPreference.getAchievement());
//            userPreferenceService.updateAesthetic(id,userPreference.getAesthetic());
//            userPreferenceService.updateExcitement(id,userPreference.getExcitement());
//            userPreferenceService.updateRebel(id,userPreference.getRebel());
//            userPreferenceService.updateAltruism(id,userPreference.getAltruism());
//            userPreferenceService.updateEmotion(id,userPreference.getEmotion());
//            userPreferenceService.updateCharacterL(id,userPreference.getCharacterl());
//            userPreferenceService.updateOrganization(id,userPreference.getOrganization());
//            userPreferenceService.updateInductive(id,userPreference.getInductive());
//            userPreferenceService.updateAttitudes(id,userPreference.getAttitudes());
//            userPreferenceService.updateSelfish(id,userPreference.getSelfish());
//            userPreferenceService.updateMale(id,userPreference.getMale());
            UserPreference preference = userPreferenceService.getUserPreferenceByUserId(id);
            return Result.success(preference);
        }else {
            return Result.error("失败");
        }

    }

}
