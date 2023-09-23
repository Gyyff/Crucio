package com.heiqi.chat.controller;

import com.heiqi.chat.common.SessionWrap;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;




@Component
@ServerEndpoint(value = "/api/websocket/{from}/{to}")
public class ChatEndPoint {

    private static List<SessionWrap> sessionList = new ArrayList<>();

    private int from;

    private int to;


    @OnMessage
    //接收到客户端发送的数据时被调用
    public void onMessage(String message, Session session) {
        try {
            System.out.println("收到了消息 确认连接");
//            //将message转换成message对象
//            ObjectMapper mapper = new ObjectMapper();
//            Message mess = mapper.readValue(message, Message.class);
//            //选择要把消息推送给谁（数据接收人）
//            int toUserId = mess.getToUserId();
//            //获取消息数据(数据内容)
//            String toMessage = mess.getMessage();
//            //获取给指定用户的消息格式的数据
//            String resultMessage = MessageUtils.getMessage(false, UserId, toMessage);
//            System.out.println("resultMessage = " + resultMessage.toString());
//            //发送数据
//            session.getBasicRemote().sendText(resultMessage);

            for (SessionWrap item : sessionList){
                if (item.getFrom()==to&&item.getTo()==from){
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
    public void onOpen(Session session, @PathParam("from") int from, @PathParam("to") int to) {
        System.out.println("连接已确认 ");
        this.from = from;
        this.to = to;
        for (SessionWrap item : sessionList) {
            if (item.getFrom() == from && item.getTo() == to) {
                item.setSession(session);
                return;
            }
        }
        SessionWrap sessionWrap = new SessionWrap();
        sessionWrap.setSession(session);
        sessionWrap.setFrom(from);
        sessionWrap.setTo(to);
        sessionList.add(sessionWrap);

    }
    @OnClose
    public void onClose(Session session) {
        System.out.println("链接关闭了");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("链接出错了" + error.getMessage());
    }
}

