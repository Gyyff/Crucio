package com.heiqi.chat.service.impl;

import static com.heiqi.chat.api.jpush.push.model.notification.PlatformNotification.ALERT;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import com.heiqi.chat.api.jpush.JPushClient;
import com.heiqi.chat.api.jpush.push.PushClient;
import com.heiqi.chat.api.jpush.push.model.Platform;
import com.heiqi.chat.api.jpush.push.model.PushPayload;
import com.heiqi.chat.api.jpush.push.model.audience.Audience;
import com.heiqi.chat.api.jpush.push.model.notification.Notification;
import com.heiqi.chat.entity.User;
import com.heiqi.chat.entity.UserDevice;
import com.heiqi.chat.service.PushService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName
 * @Author zhouliyi
 * @Date 2023年12月07日 15:09
 * @Description
 */
@Service
public class PushServiceImpl implements PushService {

    private final String NEW_CHAT_MSG = "对方发来一条新消息";

    private final String NEW_MATCHING_MSG = "您有新匹配对象，请注意查看哟";


    @Autowired
    private JPushClient jpushClient;


    @Override
    public void pushNewChatMsg(UserDevice userDevice) throws APIConnectionException, APIRequestException {
        PushPayload pushPayload = buildPushPayload(userDevice,NEW_CHAT_MSG);
        jpushClient.sendPush(pushPayload);
    }

    @Override
    public void pushMatchingMsg(UserDevice userDevice) throws APIConnectionException, APIRequestException {
        PushPayload pushPayload = buildPushPayload(userDevice,NEW_MATCHING_MSG);
        jpushClient.sendPush(pushPayload);
    }

    private PushPayload buildPushPayload(UserDevice userDevice,String msg){
        return PushPayload.newBuilder()
                .setPlatform(userDevice.getClientType() == 0 ? Platform.android() : Platform.ios())
                .setAudience(Audience.registrationId(userDevice.getDeviceId()))
                .setNotification(Notification.alert(msg))
                .setCid(UUID.randomUUID().toString())
                .build();
    }
}
