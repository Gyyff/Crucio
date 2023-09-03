package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.Chat;
import com.heiqi.chat.mapper.ChatMapper;
import com.heiqi.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {
    private final ChatMapper chatMapper;

    @Autowired
    public ChatServiceImpl(ChatMapper chatMapper) {
        this.chatMapper = chatMapper;
    }

    @Override
    public Chat getChatByChatID(int ChatID) {
        return chatMapper.getChatByChatID(ChatID);
    }

    @Override
    public Chat getChatBySenderID(int SenderID) {
        return chatMapper.getChatBySenderID(SenderID);
    }

    @Override
    public Chat getChatByReceiverID(int ReceiverID) {
        return chatMapper.getChatByReceiverID(ReceiverID);
    }

    @Override
    public int insertChat(Chat chat) {
        return chatMapper.insertChat(chat);
    }

    @Override
    public int deleteChatByChatID(int ChatID) {
        return chatMapper.deleteChatByChatID(ChatID);
    }
}
