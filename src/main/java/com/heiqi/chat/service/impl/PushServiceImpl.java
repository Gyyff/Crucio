package com.heiqi.chat.service.impl;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import com.heiqi.chat.api.jpush.JPushClient;
import com.heiqi.chat.api.jpush.push.CIDResult;
import com.heiqi.chat.api.jpush.push.model.Options;
import com.heiqi.chat.api.jpush.push.model.Platform;
import com.heiqi.chat.api.jpush.push.model.PushPayload;
import com.heiqi.chat.api.jpush.push.model.audience.Audience;
import com.heiqi.chat.api.jpush.push.model.notification.Notification;
import com.heiqi.chat.entity.UserDevice;
import com.heiqi.chat.service.PushService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName
 * @Author zhouliyi
 * @Date 2023年12月07日 15:09
 * @Description
 */
@Service
@Slf4j
public class PushServiceImpl implements PushService {

  private final String NEW_CHAT_MSG = "对方发来一条新消息";

  private final String NEW_MATCHING_MSG = "您有新匹配对象，请注意查看哟";

  @Autowired private JPushClient jpushClient;


  @Override
  public void pushNewChatMsg(UserDevice userDevice)
      throws APIConnectionException, APIRequestException {
    PushPayload pushPayload = buildPushPayload(userDevice, NEW_CHAT_MSG);
    jpushClient.sendPush(pushPayload);
  }

  @Override
  public void pushMatchingMsg(UserDevice userDevice)
      throws APIConnectionException, APIRequestException {
    PushPayload pushPayload = buildPushPayload(userDevice, NEW_MATCHING_MSG);
    jpushClient.sendPush(pushPayload);
  }

  private PushPayload buildPushPayload(UserDevice userDevice, String msg)
      throws APIConnectionException, APIRequestException {
    String cid = getCid();
    PushPayload pushPayload = null;
    if (userDevice.getClientType() == 0) {
      pushPayload =
          PushPayload.newBuilder()
              .setPlatform(Platform.android())
              .setAudience(Audience.registrationId(userDevice.getDeviceId()))
              .setNotification(Notification.alert(msg))
              .setCid(cid)
              .build();
    } else {
      pushPayload =
          PushPayload.newBuilder()
              .setPlatform(Platform.ios())
              .setAudience(Audience.registrationId(userDevice.getDeviceId()))
              .setNotification(Notification.alert(msg))
              .setOptions(Options.newBuilder().setApnsProduction(true).build())
              .setCid(cid)
              .build();
    }
    return pushPayload;
  }

  private String getCid() throws APIConnectionException, APIRequestException {
    CIDResult cidResult = jpushClient.getCidList(1, null);
    if (cidResult.isResultOK()) {
      return cidResult.cidlist.get(0);
    }
    return null;
  }
}
