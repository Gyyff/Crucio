package com.heiqi.chat.service;
/**
 * @ClassName @Author zhouliyi @Date 2023年12月04日 10:41 @Description
 */
public interface TLSSigAPIv2Service {

    String genUserSig(String userid, long expire);
}
