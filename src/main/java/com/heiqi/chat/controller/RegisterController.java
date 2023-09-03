package com.heiqi.chat.controller;

import com.heiqi.chat.Utils.MateUtils;
import com.heiqi.chat.entity.User;
import com.heiqi.chat.service.RepresentService;
import com.heiqi.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/user/Register")
public class RegisterController {
    String Tempt;
    @Autowired

    private final UserService userService;
    private final MateUtils mateUtils;
    @Autowired
    public RegisterController(UserService userService,MateUtils mateUtils) {
        this.userService = userService;
        this.mateUtils = mateUtils;
    }
    //用户的注册 验证码发送
    @GetMapping("/userRegisterSendSMS/{Phone}")
    public void Register(@PathVariable("Phone") String Phone) throws Exception {
        String randomNum = mateUtils.Sjs();
        String TempLateParam = "{\"code\" : \""+randomNum+"\"}";
        SendSMS.SendSms(Phone,TempLateParam);
      Tempt = randomNum;
    }

    @PostMapping("/userRegisterVerify/{temp}")
    public void verify(@PathVariable("temp") String temp,@RequestBody User user) throws Exception {
        System.out.println("temp = " + temp);
        System.out.println("Temp = " + Tempt);
        if (Tempt.equals(temp)){
            userService.insertUser(user);
            System.out.println("验证完成，注册成功");
        }else {
            System.out.println("验证失败，请重新输入验证码");
        }
    }

   //修改用户其他的属性
    @PutMapping("/userSet")
    public void userSet(@RequestBody User user){
        int userId = user.getUserId();
        userService.updateUserAge(userId,user.getAge());
        userService.updateUserIdentity(userId,user.getIdentity());
        userService.updateUserGender(userId,user.getGender());
        userService.updateUserSex(userId,user.getSex());
        userService.updateUserAddress(userId,user.getAddress());
        userService.updateUserName(userId,user.getUserName());
        userService.updateUserEducation(userId,user.getEducation());
        userService.updateUserHeight(userId,user.getHeight());
        userService.updateUserIsAuthed(userId,1);
    }
}
