package com.heiqi.chat.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiqi.chat.Utils.MessageUtils;
import com.heiqi.chat.entity.Message;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;



import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/api/user/chatEndpoint")
public class ChatEndPoint {

    //用来储存每一个客户端对象对应的ChatEndpoint
    private static Map<Integer,ChatEndPoint> onlineUsers =  new ConcurrentHashMap<>();


    //声明Session对象，通过该对象可以发送消息给指定用户
    private Session session;

    //声明一个HttpSession对象，我们之前在HttpSession对象中存储了用户ID
    private HttpSession httpSession;




    @OnMessage
    //接收到客户端发送的数据时被调用
    public void onMessage(String message, Session session) {
        try {
            //将message转换成message对象
            ObjectMapper mapper = new ObjectMapper();
            Message mess = mapper.readValue(message, Message.class);
            //选择要把消息推送给谁（数据接收人）
            int toUserId = mess.getToUserId();
            //获取消息数据(数据内容)
            String toMessage = mess.getMessage();
            //获取当前登录的用户
            int userId = (int) httpSession.getAttribute("userId");

            //获取给指定用户的消息格式的数据
            String resultMessage = MessageUtils.getMessage(false, userId, toMessage);
            //发送数据
            onlineUsers.get(toUserId).session.getBasicRemote().sendText(resultMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnOpen
    public void onOpen(Session session,EndpointConfig config) {
        //将局部的session对象赋值给成员session
        this.session=session;
        //获取httpSession对象
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        this.httpSession=httpSession;

        //从httpSession对象里面获取用户ID
        Integer userId = (Integer) httpSession.getAttribute("userId");

        //将当前对象存储到容器中
        onlineUsers.put(userId,this);
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

