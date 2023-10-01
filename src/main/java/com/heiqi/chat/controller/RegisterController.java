package com.heiqi.chat.controller;

import com.heiqi.chat.Utils.JwtUtil;
import com.heiqi.chat.Utils.MateUtils;
import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.User;
import com.heiqi.chat.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/user/Register")
public class RegisterController {
    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    private final UserService userService;
    private final MateUtils mateUtils;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RegisterController(UserService userService, MateUtils mateUtils) {
        this.userService = userService;
        this.mateUtils = mateUtils;
    }

    //用户的注册 验证码发送
    @GetMapping("/userRegisterSendSMS/{Phone}")
    public Result Register(@PathVariable("Phone") String Phone) throws Exception {
        if (userService.getUserByPhone(Phone) == null) {
            String randomNum = mateUtils.Sjs();
            String TempLateParam = "{\"code\" : \"" + randomNum + "\"}";
            SendSMS.SendSms(Phone, TempLateParam);
            map.put(Phone, randomNum);
            return Result.success("验证码已经发送");
        } else {
            return Result.error("手机号已被注册或系统异常，请检查手机号是否正确，如有疑问可联系客服");
        }

    }

    //临时 用户的注册 账号密码注册
    @PostMapping("/userRegisterOfPassword/{PasswordAgain}")
    public Result RegisterOfPassword(@PathVariable("PasswordAgain") String PasswordAgain,@RequestBody User user
    ) throws Exception {
        if (userService.getUserByPhone(user.getPhone()) == null) {
            if (user.getPassWord().equals(PasswordAgain)) {
                userService.insertUser(user);
                return Result.success("注册成功");
            }else {
                return Result.error("两次输入的密码不一致，请确认密码后重试");
            }
        } else {
            return Result.error("手机号已被注册或系统异常，请检查手机号是否正确，如有疑问可联系客服");
        }
    }




    //用户注册时的验证码校验 验证成功则直接注册
    @PostMapping("/userRegisterVerify/{temp}")
    public Result verify(@PathVariable("temp") String temp, @RequestBody User user) throws Exception {
        System.out.println("temp = " + temp);
        System.out.println("user.getPhone() = " + user.getPhone());
        System.out.println("map values " + map.get(user.getPhone()));
        if (map.get(user.getPhone()).equals(temp)) {
            userService.insertUser(user);
            System.out.println("验证完成，注册成功");
            User registerUser = userService.getUserByPhone(user.getPhone());

            String token = JwtUtil.sign(registerUser.getUserId());
            stringRedisTemplate.opsForValue().set(token, "", 1, TimeUnit.DAYS);
            registerUser.setToken(token);

            return Result.success(registerUser);
            //成功则返回register 也就是数据库新增的user
        } else {
            //失败则返回前端传的user
            System.out.println("验证失败，请重新输入验证码");
            return Result.error("验证码错误");
        }
    }

    //修改用户其他的属性
    @PutMapping("/userSet")
    public Result userSet(@RequestBody User user) throws ParseException {
        int userId = user.getUserId();
        userService.updateUserAge(userId, user.getAge());
        userService.updateUserIdentity(userId, user.getIdentity());
        userService.updateUserGender(userId, user.getGender());
        userService.updateUserName(userId, user.getUserName());
        userService.updateUserEducation(userId, user.getEducation());
        userService.updateUserHeight(userId, user.getHeight());
        userService.updateUserBirthDay(userId, user.getBirthDay());
        userService.updateUserWeight(userId, user.getWeight());
        userService.updateUserSchool(userId, user.getSchool());
        userService.updateUserHomeTownA(userId, user.getHomeTownA());
        userService.updateUserHomeTownB(userId, user.getHomeTownB());
        userService.updateUserAddressA(userId, user.getAddressA());
        userService.updateUserAddressB(userId, user.getAddressB());
        //最后将用户的资料审核状态设置为1
        userService.updateUserIsAuthed(userId, 1);
        User SetUser = userService.getUserById(userId);
        if (SetUser != null) {
            return Result.success(SetUser);
        } else {
            return Result.error();
        }
    }
}
