package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    //这个类是客户端给服务端发送的消息

    private int toUserId;
    private String message;


}
