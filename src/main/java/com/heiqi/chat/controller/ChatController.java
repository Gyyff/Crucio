package com.heiqi.chat.controller;

import com.heiqi.chat.entity.Chat;
import com.heiqi.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/getChatByChatID/{ChatID}")
    public Chat getChatByChatID(@PathVariable("ChatID") int ChatID) {
        return chatService.getChatByChatID(ChatID);
    }

    @GetMapping("/getChatBySenderID/{SenderID}")
    public Chat getChatBySenderID(@PathVariable("SenderID") int SenderID) {
        return chatService.getChatBySenderID(SenderID);
    }

    @GetMapping("/getChatByReceiverID/{ReceiverID}")
    public Chat getChatByReceiverID(@PathVariable("ReceiverID") int ReceiverID) {
        return chatService.getChatByReceiverID(ReceiverID);
    }

    // 这里写更多的 getter 函数...

    @PostMapping("/insertChat")
    public void insertChat(@RequestBody Chat chat) {
        chatService.insertChat(chat);
    }

    @DeleteMapping("deleteChatByChatID/{ChatID}")
    public void deleteChatByChatID(@PathVariable("ChatID") int ChatID) {
        chatService.deleteChatByChatID(ChatID);
    }

    // 这里写更多的 setter 函数...
}
