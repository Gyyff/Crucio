package com.heiqi.chat.controller;


import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import com.heiqi.chat.Utils.JwtUtil;
import com.heiqi.chat.Utils.MatchUtils;
import com.heiqi.chat.Utils.UploadUtil;
import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.BaseUser;
import com.heiqi.chat.entity.User;
import com.heiqi.chat.entity.UserDevice;
import com.heiqi.chat.entity.UserPreference;
import com.heiqi.chat.service.PushService;
import com.heiqi.chat.service.UserPreferenceService;
import com.heiqi.chat.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserPreferenceService userPreferenceService;

    private final MatchUtils matchUtils;

    @Autowired
    private PushService pushService;

    @Autowired
    public UserController(UserService userService , UserPreferenceService userPreferenceService ,MatchUtils matchUtils ) {
        this.userService = userService;
        this.userPreferenceService=userPreferenceService;
        this.matchUtils = matchUtils;

    }

    @GetMapping("/getUserById/{UserId}")
    public Result getUserById(@PathVariable("UserId") int UserId, BaseUser baseUser) {
        User user = userService.getUserById(UserId);
        return Result.success(user);
    }

    @GetMapping("/getUserByName/{UserName}")
    public User getUserByName(@PathVariable("UserName") String UserName) {
        return userService.getUserByName(UserName);
    }

    @GetMapping("/getUserByAge/{Age}")
    public User getUserByAge(@PathVariable("Age") int Age) {
        return userService.getUserByAge(Age);
    }

    @GetMapping("/getUserByAddress/{Address}")
    public User getUserByAddress(@PathVariable("Address") String Address) {
        return userService.getUserByAddress(Address);
    }

    @GetMapping("/getUserByPhone/{Phone}")
    public Result getUserByPhone(@PathVariable("Phone") String Phone) {
        User user = userService.getUserByPhone(Phone);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.error("失败");
        }

    }

    //获取符合用户偏好的人数
    @GetMapping("/getConformUsers/{UserId}")
    public Result getConformUsers(@PathVariable("UserId") int UserId) {
        return userService.getConformUsers(UserId);
    }


    //登录时发送短信验证码

    @GetMapping("/sendSMSofLogon/{Phone}")
    public Result sendSMSofLogon(@PathVariable("Phone") String Phone) throws Exception {
        return userService.sendSMSofLogon(Phone);
    }

    //用户登录(效验短信验证码)
    @GetMapping("/userLogon/{Tem}/{Phone}")
    public Result userLogon(@PathVariable("Tem") String Tem, @PathVariable("Phone") String Phone) {
        return userService.userLogon(Tem, Phone);
    }


    //用户登出
    @GetMapping("/userQuit/{UserId}")
    public Result userQuit(@PathVariable("UserId") int UserId) {
        userService.userQuit(UserId);
        return Result.success();
    }

    //结束关系
    @DeleteMapping("/cutLove/{UserId}")
    public Result cutLove(@PathVariable("UserId") int UserId) {
        return userService.cutLove(UserId);
    }

    //确认关系
    @PutMapping("/confirmShip/{UserId}")
    public Result confirmShip(@PathVariable("UserId") int UserId) {
        return userService.confirmShip(UserId);
    }


    //这里是用户匹配
    @GetMapping("/getUserMatch/{UserId}")
    public Result getUserMatch(@PathVariable("UserId") int UserId) throws Exception {
        return userService.getUserMatch0(UserId);
    }
    //向另一位用户发送消息
   @PostMapping("sendMessageToUserOther/{UserId}")
    public Result sendMessageToUserOther(@PathVariable("UserId") int UserId,@RequestBody String messages) throws Exception {
        return userService.sendMessageToUserOther(messages,UserId);
    }

    //用户前往匹配页面时的校验
    @GetMapping("/determineToMatchPages/{UserId}")
    public Result determineToMatchPages(@PathVariable("UserId") int UserId) {
        return userService.determineToMatchPages(UserId);
    }
    //查看用户的匹配模式选择
    @GetMapping("/getUserMatchChoice/{UserId}")
    public Result getUserMatchChoice(@PathVariable("UserId") int UserId){
        int matchChoice = userService.getUserById(UserId).getMatchChoice();
        return Result.success(matchChoice);
    }


    // 这里写更多的 getter 函数...+

    @PostMapping("/insertUser")
    public void insertUser(@RequestBody User user, BaseUser baseUser) throws Exception {
        userService.insertUser(user);
    }


    @DeleteMapping("/deleteUser/{UserId}")
    public void deleteUser(@PathVariable("UserId") int UserId, BaseUser baseUser) {
        userService.deleteUser(UserId);
    }


    //用户头像上传
    @PutMapping("/uploadUserPhoto/{UserId}")
    public Result uploadUserPhoto(@PathVariable("UserId") int UserId, @RequestBody MultipartFile file, BaseUser baseUser) throws IOException {
        String path = UploadUtil.uploadImage(file);
        userService.updateUserPhoto(UserId, path);
        return Result.success(path);
    }
    @PutMapping("/updateUserWeChat/{UserId}")
    public Result updateUserWeChat(@PathVariable("UserId") int UserId, @RequestBody String WeChat, BaseUser baseUser) {
        userService.updateUserWeChat(UserId, WeChat);
        return Result.success();
    }
    //切换为自动匹配状态
    @PutMapping("/updateUserMatchChoiceAuto/{UserId}")
    public Result updateUserMatchChoiceAuto(@PathVariable("UserId") int UserId, BaseUser baseUser) {
        User userById = userService.getUserById(UserId);
        if (userPreferenceService.getUserPreferenceFoundationByUserId(UserId)==null&&userById.getIsPreference()==0&&userById.getIsTested()==0){
            return Result.error("请先完成基础信息选项、恋爱偏好测试、性格与价值观测试");
        }
        if (userById.getIsPreference()==0&&userById.getIsTested()==0){
            return Result.error("请先完成恋爱偏好测试、性格与价值观测试");
        }
        if (userPreferenceService.getUserPreferenceFoundationByUserId(UserId)==null&&userById.getIsPreference()==0){
            return Result.error("请先完成基础信息选项、恋爱偏好测试");
        }
        if (userPreferenceService.getUserPreferenceFoundationByUserId(UserId)==null&&userById.getIsTested()==0){
            return Result.error("请先完成基础信息选项、性格与价值观测试");
        }
        if (userPreferenceService.getUserPreferenceFoundationByUserId(UserId)==null){
            return Result.error("请先完成基础信息选项");
        }
        if (userById.getIsPreference()==0){
            return Result.error("请先完成恋爱偏好测试");
        }
        if (userById.getIsTested()==0){
            return Result.error("请先完成性格与价值观测试");
        }
        userService.updateUserMatchChoiceAuto(UserId);
        return Result.success();
    }

    //切换为暂停匹配状态
    @PutMapping("/updateUserMatchChoiceStop/{UserId}")
    public Result updateUserMatchChoiceStop(@PathVariable("UserId") int UserId, BaseUser baseUser) {
        userService.updateUserMatchChoiceStop(UserId);
        return Result.success();
    }


    @PutMapping("/updateUserName/{UserId}")
    public void updateUserName(@PathVariable("UserId") int UserId, @RequestBody String UserName, BaseUser baseUser) {
        userService.updateUserName(UserId, UserName);
    }

    @PutMapping("/updateUserAge/{UserId}")
    public void updateUserAge(@PathVariable("UserId") int UserId, @RequestBody int Age, BaseUser baseUser) {
        userService.updateUserAge(UserId, Age);
    }


    @PutMapping("/updateUserIdentity/{UserId}")
    public void updateUserIdentity(@PathVariable("UserId") int UserId, @RequestBody String Identity, BaseUser baseUser) {
        userService.updateUserIdentity(UserId, Identity);
    }

    @PutMapping("/updateUserEducation/{UserId}")
    public void updateUserEducation(@PathVariable("UserId") int UserId, @RequestBody int Education, BaseUser baseUser) {
        System.out.println("UserId = " + UserId);
        System.out.println("Education = " + Education);
        userService.updateUserEducation(UserId, Education);
    }

    @PutMapping("/updateUserPhoto/{UserId}")
    public void updateUserPhoto(@PathVariable("UserId") int UserId, @RequestBody String Photo, BaseUser baseUser) {
        userService.updateUserPhoto(UserId, Photo);
    }

    @PutMapping("/updateUserIsAuthed/{UserId}")
    public void updateUserIsAuthed(@PathVariable("UserId") int UserId, @RequestBody int IsAuthed, BaseUser baseUser) {
        userService.updateUserIsAuthed(UserId, IsAuthed);
    }

    @PutMapping("/updateUserIsLogged/{UserId}")
    public void updateUserIsLogged(@PathVariable("UserId") int UserId, @RequestBody int IsLogged, BaseUser baseUser) {
        userService.updateUserIsLogged(UserId, IsLogged);
    }

    @PutMapping("/updateUserIsTested/{UserId}")
    public void updateUserIsTested(@PathVariable("UserId") int UserId, @RequestBody int IsTested, BaseUser baseUser) {
        userService.updateUserIsTested(UserId, IsTested);
    }


    // 这里写更多的 setter 函数...

  //测试用
    @GetMapping("/matchTest")
    public void matchTest(){

       userService.testMatch();

    }

    //绑定设备
    @PostMapping("/bindDevice")
    public Result bindDevice(@RequestBody UserDevice userDevice){
        return userService.bindDevice(userDevice.getUserId(),userDevice.getDeviceId(),userDevice.getClientType());
    }


    @PostMapping("/push")
    public Result pushMsg() throws APIConnectionException, APIRequestException {
        pushService.pushMatchingMsg(new UserDevice());
        return new Result<>();
    }
}