package com.heiqi.chat.service.impl;

import static com.heiqi.chat.api.jpush.push.model.notification.PlatformNotification.ALERT;

import cn.jiguang.common.ServiceHelper;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import com.heiqi.chat.api.jpush.JPushClient;
import com.heiqi.chat.api.jpush.push.PushClient;
import com.heiqi.chat.api.jpush.push.model.Options;
import com.heiqi.chat.api.jpush.push.model.Platform;
import com.heiqi.chat.api.jpush.push.model.PushPayload;
import com.heiqi.chat.api.jpush.push.model.audience.Audience;
import com.heiqi.chat.api.jpush.push.model.notification.Notification;
import com.heiqi.chat.entity.User;
import com.heiqi.chat.entity.UserDevice;
import com.heiqi.chat.service.PushService;
import java.util.Base64;
import java.util.UUID;
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
//        return PushPayload.newBuilder()
//                .setPlatform(Platform.ios())
//                .setAudience(Audience.registrationId("18171adc020abb747fa"))
//                .setNotification(Notification.alert(msg))
//                .setOptions(Options.newBuilder().setApnsProduction(true).build())
//                .setCid("ebae1fea7f785ba3d5ff8869-223880fe-e375-48fa-bc71-759c876830b0")
//                .build();
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.registrationId("140fe1da9fad4ada223"))
                .setNotification(Notification.alert(msg))
                .setCid("ebae1fea7f785ba3d5ff8869-c730ff3c-0f89-4b58-9304-4ee531feb76a")
                .build();
    }

    public static void main(String[] args) {
        System.out.println(ServiceHelper.getBasicAuthorization("ebae1fea7f785ba3d5ff8869", "47a208b34004925190240f9f"));
        //https://api.jpush.cn/v3/push/cid?count=3
    }
}
