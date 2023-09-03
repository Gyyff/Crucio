package com.heiqi.chat.controller;


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
    public UserPreference getUserPreferenceByUserId(@PathVariable("UserId") int UserId){
        return userPreferenceService.getUserPreferenceByUserId(UserId);
    }


    @GetMapping("/getUserPreferenceByUserPreferenceID/{UserPreferenceId}")
    public UserPreference getUserPreferenceByUserPreferenceID(@PathVariable("UserPreferenceId")int UserPreferenceId){
        return userPreferenceService.getUserPreferenceByUserPreferenceID(UserPreferenceId);
    }


    @DeleteMapping("/deleteUserPreferenceByUserId/{UserId}")
    public void deleteUserPreferenceByUserId(@PathVariable("UserId") int UserId){
        userPreferenceService.deleteUserPreferenceByUserId(UserId);
    }


    @PostMapping("/insertUserPreference")
    public void insertUserPreference(@RequestBody UserPreference userPreference){
        userPreferenceService.insertUserPreference(userPreference);
    }

}
