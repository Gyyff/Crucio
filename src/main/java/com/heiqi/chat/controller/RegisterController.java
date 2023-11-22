package com.heiqi.chat.controller;

import com.heiqi.chat.Utils.JwtUtil;
import com.heiqi.chat.Utils.MateUtils;
import com.heiqi.chat.Utils.SendEmailUtils;
import com.heiqi.chat.common.Result;
import com.heiqi.chat.common.SensitiveWordsChecker;
import com.heiqi.chat.entity.BaseUser;
import com.heiqi.chat.entity.Manager;
import com.heiqi.chat.entity.User;
import com.heiqi.chat.service.ManagerService;
import com.heiqi.chat.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
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
    private final SensitiveWordsChecker sensitiveWordsChecker;

    private final ManagerService managerService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;



    @Autowired
    public RegisterController(UserService userService, MateUtils mateUtils,SensitiveWordsChecker sensitiveWordsChecker,ManagerService managerService) {
        this.userService = userService;
        this.mateUtils = mateUtils;
        this.sensitiveWordsChecker=sensitiveWordsChecker;
        this.managerService = managerService;

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
//        if (sensitiveWordsChecker.containsSensitiveWords(user.getUserName())){
//            return Result.error("用户名中存在敏感词");
//        }
        if (userService.getUserByPhone(user.getPhone()) == null) {
            if (user.getPassWord().equals(PasswordAgain)) {
                userService.insertUser(user);
                User registerUser= userService.getUserByPhone(user.getPhone());
                userService.updateUserIsLogged(registerUser.getUserId(),1);
                User Ruser = userService.getUserById(registerUser.getUserId());
                String token = JwtUtil.sign(Ruser.getUserId());
                stringRedisTemplate.opsForValue().set(token, "", 1, TimeUnit.DAYS);
                Ruser.setToken(token);
                return Result.success(Ruser);
            }else {
                return Result.error("两次输入的密码不一致，请确认密码后重试");
            }
        } else {
            return Result.error("手机号已被注册或系统异常，请检查手机号是否正确，如有疑问可联系客服");
        }
    }

    // 临时 用户的账号密码登录
    @GetMapping("/userLogonOfPassword/{Phone}/{Password}")
    public Result userLogonOfPassword(@PathVariable("Phone") String Phone, @PathVariable("Password") String Password) {
        User user = userService.getUserByPhone(Phone);
        if (user!=null){
            if (user.getPassWord().equals(Password)){
                userService.updateUserIsLogged(user.getUserId(),1);
                String token = JwtUtil.sign(user.getUserId());
                stringRedisTemplate.opsForValue().set(token, "", 1, TimeUnit.DAYS);
                user.setToken(token);
                return Result.success(user);
            }else {
                return Result.error("密码错误请确认密码后重试");
            }
        }else {
            return Result.error("该手机号还未被注册，请您注册后再试");
        }
    }
    //校验邮箱是否被注册
    @GetMapping("/verifyUserEmail/{Email}")
    public Result verifyUserEmail(@PathVariable("Email") String Email){
        if (userService.getUserByEmail(Email)==null){
            return Result.success("邮箱可以使用");
        }else
            return Result.error("邮箱已经被注册");

    }



    //用户注册时的验证码校验 验证成功则直接注册
    @PostMapping("/userRegisterVerify/{temp}")
    public Result verify(@PathVariable("temp") String temp, @RequestBody User user) throws Exception {
        System.out.println("temp = " + temp);
        System.out.println("user.getPhone() = " + user.getPhone());
        System.out.println("map values " + map.get(user.getPhone()));
//        if (sensitiveWordsChecker.containsSensitiveWords(user.getUserName())){
//            return Result.error("用户名中存在敏感词");
//        }
        if (map.get(user.getPhone()).equals(temp)) {
            userService.insertUser(user);
            System.out.println("验证完成，注册成功");
            User registUser = userService.getUserByPhone(user.getPhone());
            userService.updateUserIsLogged(registUser.getUserId(),1);
            User Ruser= userService.getUserById(registUser.getUserId());

            String token = JwtUtil.sign(Ruser.getUserId());
            stringRedisTemplate.opsForValue().set(token, "", 1, TimeUnit.DAYS);
            Ruser.setToken(token);

            return Result.success(Ruser);
            //成功则返回register 也就是数据库新增的user
        } else {
            //失败则返回前端传的user
            System.out.println("验证失败，请重新输入验证码");
            return Result.error("验证码错误");
        }
    }


    //邮箱验证码的发送
    @GetMapping("/userRegisterSendEmail/{Email}")
    public Result userRegisterSendEmail(@PathVariable("Email") String Email) throws Exception {
        if (userService.getUserByEmail(Email)!=null){
            return Result.error("该邮箱已被注册，请勿重复注册");
        }
        if (userService.getUserByEmail(Email) == null) {
            String randomNum = mateUtils.Sjs();
            SendEmailUtils.sendEmail(Email, randomNum);
            map.put(Email, randomNum);
            return Result.success("验证码已经发送");
        } else {
            return Result.error("邮箱已被注册或系统异常，请检查邮箱是否正确，如有疑问可联系客服");
        }
    }

    //邮箱验证码的确认
    @PostMapping("/userRegisterEmailVerify/{code}")
    public Result userRegisterEmailVerify(@PathVariable("code") String code, @RequestBody User user) throws Exception {
        if (userService.getUserByEmail(user.getEmail())!=null){
            return Result.error("该邮箱已被注册，请勿重复注册");
        }
//        if (sensitiveWordsChecker.containsSensitiveWords(user.getUserName())){
//            return Result.error("用户名中存在敏感词");
//        }
        if (map.get(user.getEmail()).equals(code)) {
            userService.insertUser(user);
            System.out.println("验证完成，注册成功");
            User registUser = userService.getUserByEmail(user.getEmail());
            userService.updateUserIsLogged(registUser.getUserId(),1);
            User Ruser= userService.getUserById(registUser.getUserId());

            String token = JwtUtil.sign(Ruser.getUserId());
            stringRedisTemplate.opsForValue().set(token, "", 1, TimeUnit.DAYS);
            Ruser.setToken(token);

            return Result.success(Ruser);
            //成功则返回register 也就是数据库新增的user
        } else {
            //失败则返回前端传的user
            System.out.println("验证失败，请重新输入验证码");
            return Result.error("验证码错误");
        }
    }
    //邮箱登录
    @GetMapping("/userLogonEmailOfPassword/{Email}/{Password}")
    public Result userLogonEmailOfPassword(@PathVariable("Email") String Email, @PathVariable("Password") String Password) {
        User user = userService.getUserByEmail(Email);
        if (user!=null){
            if (user.getPassWord().equals(Password)){
                userService.updateUserIsLogged(user.getUserId(),1);
                String token = JwtUtil.sign(user.getUserId());
                stringRedisTemplate.opsForValue().set(token, "", 1, TimeUnit.DAYS);
                user.setToken(token);
                return Result.success(user);
            }else {
                return Result.error("密码错误请确认密码后重试");
            }
        }else {
            return Result.error("该邮箱号还未被注册，请您注册后再试");
        }
    }


    //修改用户其他的属性
    @PutMapping("/userSet")
    public Result userSet(@RequestBody User user) {
//        if (sensitiveWordsChecker.containsSensitiveWords(user.getUserName())){
//            return Result.error("用户名中存在敏感词");
//        }
        int userId = user.getUserId();
        userService.updateUserAge(userId, user.getAge());
        userService.updateUserIdentity(userId, user.getIdentity());
        userService.updateUserGender(userId, user.getGender());
        userService.updateUserName(userId, user.getUserName());
        userService.updateUserEducation(userId, user.getEducation());
        userService.updateUserWeChat(userId,user.getWeChat());
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


    //管理员登录
    @GetMapping("/checkLogin")
    public Result checkLogin(@RequestBody Manager manager){
        Manager m = managerService.getManager(manager);
        if (m!=null){
            String token = JwtUtil.sign(m.getManagerId());
            stringRedisTemplate.opsForValue().set(token, "", 1, TimeUnit.DAYS);
            m.setToken(token);
            return Result.success(m);
        }else
            return Result.error("账号验证错误");
    }
}
