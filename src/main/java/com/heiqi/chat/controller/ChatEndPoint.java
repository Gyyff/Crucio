package com.heiqi.chat.controller;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.heiqi.chat.Utils.RedisUtil;
import com.heiqi.chat.common.SessionWrap;
import io.swagger.models.auth.In;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@ServerEndpoint(value = "/api/websocket/{from}/{to}")
public class ChatEndPoint {

    private static List<SessionWrap> sessionList = new ArrayList<>();

    private Map<Session,SessionWrap> FROM_TO = new ConcurrentHashMap<>();


    @OnMessage
    //接收到客户端发送的数据时被调用
    public void onMessage(String message, Session session) {
        try {
            System.out.println("收到了消息 确认连接");
            SessionWrap wrap = FROM_TO.get(session);
            for (SessionWrap item : sessionList){
                if (item.getFrom()==wrap.getTo() && item.getTo()==wrap.getFrom()){
                    item.getSession().getBasicRemote().sendText(message);
                    FROM_TO.remove(wrap);
                    break;
                } else {
                    // 用户离线，开始缓存消息
                    RedisUtil.lLeftPush(wrap.getTo() + "-" + wrap.getFrom(), message);
                }
            }
            System.out.println("消息发送完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("from") int from, @PathParam("to") int to) {
        System.out.println("连接已确认 ");
        for (SessionWrap item : sessionList) {
            if (item.getFrom() == from && item.getTo() == to) {
                item.setSession(session);
                break;
            }
        }
        SessionWrap sessionWrap = new SessionWrap();
        sessionWrap.setSession(session);
        sessionWrap.setFrom(from);
        sessionWrap.setTo(to);
        sessionList.add(sessionWrap);
        String key = from + "-" + to;
        FROM_TO.put(session, sessionWrap);
        List<String> msgList = RedisUtil.lRange(key, 0, -1);
        if (CollUtil.isNotEmpty(msgList)) {
            msgList.forEach(item -> {
                try {
                    sendMessageToClient(item, to);
                } catch (Exception e) {
                    log.error("消息发送失败,from:{},to:{}", from, to, e);
                }
            });
            RedisUtil.delete(key);
        }
    }
    @OnClose
    public void onClose(Session session) {
        System.out.println("链接关闭了");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("链接出错了" + error.getMessage());
    }


//
    public void sendMessageToClient(String message,int UserId) throws Exception {
        for (SessionWrap item : sessionList) {
            if (item.getTo() == UserId) {
                item.getSession().getBasicRemote().sendText(message);
                break;
            }


        }
    }
}

