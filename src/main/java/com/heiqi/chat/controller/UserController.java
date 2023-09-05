package com.heiqi.chat.controller;


import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.Represent;
import com.heiqi.chat.entity.User;
import com.heiqi.chat.service.RepresentService;
import com.heiqi.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final RepresentService representService;
    @Autowired
    public UserController(UserService userService,RepresentService representService) {
        this.userService = userService;
        this.representService = representService;
    }

    @GetMapping("/getUserById/{UserId}")
    public Result getUserById(@PathVariable("UserId") int UserId) {
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
    public User getUserByPhone(@PathVariable("Phone") String Phone){
        return userService.getUserByPhone(Phone);
    }

    @GetMapping("/getRepresentByUserId/{UserId}")
    public Represent getRepresentByUserId(@PathVariable("UserId") int UserId){
        return representService.getRepresentByUserId(UserId);
    }
    //登录时发送短信验证码
    @GetMapping("/sendSMSofLogon/{Phone}")
    public Result sendSMSofLogon(@PathVariable("Phone") String Phone) throws Exception {
        return Result.success();
    }

    //用户登录(效验短信验证码)
    @GetMapping("/userLogon/{Phone}")
    public Result userLogon(@PathVariable("Phone") String Phone,@RequestBody String Tempt)  {
        User user = userService.userLogon(Phone, Tempt);
        if (user!=null){
            return Result.success(user);
        }else {
            return Result.error("登录失败请检查验证码是否正确");
        }
       
    }

    //用户登出
    @GetMapping("/userQuit/{UserId}")
    public Result userQuit(@PathVariable("UserId") int UserId){
        userService.userQuit(UserId);
       return Result.success();
    }

    //这里是用户匹配
    @GetMapping("/getUserMatch/{UserId}")
    public User getUserMatch(@PathVariable("UserId") int UserId){
        return userService.getUserMatch(UserId);
    }

    // 这里写更多的 getter 函数...

    @PostMapping("/insertUser")
    public void insertUser(@RequestBody User user) throws Exception {
        userService.insertUser(user);
    }

    @PostMapping("/insertRepresent")
    public void insertRepresent(@RequestBody Represent represent){
        representService.insertRepresent(represent);
    }

    @DeleteMapping("/deleteUser/{UserId}")
    public void deleteUser(@PathVariable("UserId") int UserId) {
        userService.deleteUser(UserId);
    }

    @DeleteMapping("/deleteRepresent/{UserId}")
    public void deleteRepresent(@PathVariable("UserId") int UserId){
        representService.deleteRepresent(UserId);
    }

    @PutMapping("/updateUserName/{UserId}")
    public void updateUserName(@PathVariable("UserId") int UserId, @RequestBody String UserName) {
        userService.updateUserName(UserId, UserName);
    }

    @PutMapping("/updateUserAge/{UserId}")
    public void updateUserAge(@PathVariable("UserId") int UserId, @RequestBody int Age) {
        userService.updateUserAge(UserId, Age);
    }

    @PutMapping("/updateUserAddress/{UserId}")
    public void updateUserAddress(@PathVariable("UserId") int UserId, @RequestBody String Address) {
        userService.updateUserAddress(UserId,Address);
    }
    @PutMapping("/updateUserIdentity/{UserId}")
    public void updateUserIdentity(@PathVariable("UserId") int UserId, @RequestBody String Identity) {
        userService.updateUserIdentity(UserId,Identity);
    }

    @PutMapping("/updateUserEducation/{UserId}")
    public void updateUserEducation(@PathVariable("UserId") int UserId, @RequestBody int Education) {
        System.out.println("UserId = " + UserId);
        System.out.println("Education = " + Education);
        userService.updateUserEducation(UserId,Education);
    }

    @PutMapping("/updateUserPhoto/{UserId}")
    public void updateUserPhoto(@PathVariable("UserId") int UserId, @RequestBody String Photo) {
        userService.updateUserPhoto(UserId,Photo);
    }

    @PutMapping("/updateUserIsAuthed/{UserId}")
    public void updateUserIsAuthed(@PathVariable("UserId") int UserId,@RequestBody int IsAuthed){
        userService.updateUserIsAuthed(UserId, IsAuthed);
    }

    @PutMapping("/updateUserIsLogged/{UserId}")
    public void updateUserIsLogged(@PathVariable("UserId") int UserId,@RequestBody int IsLogged){
        userService.updateUserIsLogged(UserId,IsLogged);
    }

    //用户是否已经经过性格测试 （0，代表没有）  （1，代表已经通过测试）
    @PutMapping("/updateUserIsTested/{UserId}")
    public void updateUserIsTested(@PathVariable("UserId") int UserId,@RequestBody int IsTested){
        userService.updateUserIsTested(UserId,IsTested);
    }


    @PutMapping("/updateDescription/{UserId}")
    public void updateDescription(@PathVariable("UserId") int UserId,@RequestBody String Description){
        representService.updateDescription(UserId,Description);
    }

    @PutMapping("/updateSeek/{UserId}")
    public void updateSeek(@PathVariable("UserId") int UserId,@RequestBody String Seek){
        representService.updateSeek(UserId,Seek);
    }

    @PutMapping("/updateLifeWay/{UserId}")
    public void updateLifeWay(@PathVariable("UserId") int UserId,@RequestBody String LifeWay){
        representService.updateLifeWay(UserId,LifeWay);
    }
    @PutMapping("/updateIdol/{UserId}")
    public void updateIdol(@PathVariable("UserId") int UserId,@RequestBody String Idol){
        representService.updateIdol(UserId,Idol);
    }
    // 这里写更多的 setter 函数...
}