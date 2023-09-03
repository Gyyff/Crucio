package com.heiqi.chat.service;

import com.heiqi.chat.entity.Chat;
import org.springframework.stereotype.Service;

@Service
public interface ChatService {
    Chat getChatByChatID(int ChatID);

    Chat getChatBySenderID(int SenderID);

    Chat getChatByReceiverID(int ReceiverID);

    int insertChat(Chat chat);

    int deleteChatByChatID(int ChatID);
}
