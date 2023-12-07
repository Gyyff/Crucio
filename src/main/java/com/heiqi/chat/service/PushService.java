package com.heiqi.chat.service;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import com.heiqi.chat.entity.User;
import com.heiqi.chat.entity.UserDevice;

/**
 * @ClassName @Author zhouliyi @Date 2023年12月07日 15:09 @Description
 */
public interface PushService {

    /**
     * 新消息推送
     * @param userDevice
     */
    void pushNewChatMsg(UserDevice userDevice) throws APIConnectionException, APIRequestException;

    /**
     * 新匹配推送
     * @param userDevice
     */
    void pushMatchingMsg(UserDevice userDevice) throws APIConnectionException, APIRequestException;
}
