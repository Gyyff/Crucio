package com.heiqi.chat.controller;

import com.alibaba.fastjson.JSONObject;
import com.heiqi.chat.entity.TecentCallback;
import com.heiqi.chat.entity.TencentCallbackRet;
import com.heiqi.chat.entity.UserDevice;
import com.heiqi.chat.service.PushService;
import com.heiqi.chat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName 
 * @Author zhouliyi 
 * @Date 2023年12月07日 11:08 
 * @Description
 */
@RestController
@RequestMapping("/api/jpush")
@Slf4j
public class JpushRetController {

  @Autowired private UserService userService;

  @Autowired private PushService pushService;

  @PostMapping("/im/notify")
  public TencentCallbackRet notifyJpush(@RequestBody TecentCallback tecentCallback) {

    try {
      log.info("腾讯云回调：{}", JSONObject.toJSONString(tecentCallback));
      if(!"C2C.CallbackBeforeSendMsg".equals(tecentCallback.getCallbackCommand())){
        return TencentCallbackRet.success();
      }
      Integer toAccount = Integer.parseInt(tecentCallback.getTo_Account());
      UserDevice userDevice = userService.selectUserDevice(toAccount);
      if (userDevice != null) {
        pushService.pushNewChatMsg(userDevice);
      }
    } catch (Exception e) {
      log.error("error:", e);
    }
    return TencentCallbackRet.success();
  }
}
