package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultMessage {
    //这个类是服务端给客户端发送的消息
    private boolean isSystem;  // 判断该消息是不是系统消息
    private int fromUserId; // 是谁发过来的
    private Object message; //
}
