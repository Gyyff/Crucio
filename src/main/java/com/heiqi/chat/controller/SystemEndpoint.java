package com.heiqi.chat.controller;

import com.heiqi.chat.common.SessionWrap;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@ServerEndpoint(value = "/api/SystemEndPoint/{to}")
public class SystemEndpoint {



        private static List<SessionWrap> sessionsList = new ArrayList<>();

        private int to;


        @OnMessage
        //接收到客户端发送的数据时被调用
        public void onMessage(String message, Session session) {
            try {

                for (SessionWrap item : sessionsList) {
                    if (item.getTo() == to) {
                        item.getSession().getBasicRemote().sendText(message);
                        break;
                    }
                }
                System.out.println("消息发送完毕");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @OnOpen
        public void onOpen(Session session, @PathParam("to") int to) {
            System.out.println("连接已确认 ");
            this.to = to;
            for (SessionWrap item : sessionsList) {
                if (item.getTo() == to) {
                    item.setSession(session);
                    return;
                }
            }
            SessionWrap sessionWrap = new SessionWrap();
            sessionWrap.setSession(session);
            sessionWrap.setTo(to);
            sessionsList.add(sessionWrap);
        }

        @OnClose
        public void onClose(Session session) {
            System.out.println("链接关闭了");
        }

        @OnError
        public void onError(Session session, Throwable error) {
            System.out.println("链接出错了" + error.getMessage());
        }


        public void sendSystemMessageToClient(String message, int UserId) throws Exception {
            for (SessionWrap item : sessionsList) {
                if (item.getTo() == UserId) {
                    item.getSession().getBasicRemote().sendText(message);
                    break;
                }


            }
        }
    }


