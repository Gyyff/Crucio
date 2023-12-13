package com.heiqi.chat.common;

import jakarta.websocket.Session;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionWrap {
//    private int from;     //会话发起者id
    private int to;     //会话接收者id
    private Session session;
}
