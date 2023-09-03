package com.heiqi.chat.mapper;


import com.heiqi.chat.entity.Chat;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface ChatMapper {

    @Select("SELECT * FROM chat WHERE ChatID = #{ChatID}")
    Chat getChatByChatID(@Param("ChatID") int ChatID);

    @Select("SELECT * FROM chat WHERE SenderID = #{SenderID}")
    Chat getChatBySenderID(@Param("SenderID") int SenderID);

    @Select("SELECT * FROM chat WHERE ReceiverID = #{ReceiverID}")
    Chat getChatByReceiverID(@Param("ReceiverID") int ReceiverID);

    @Insert("INSERT INTO chat(ChatID, SenderID, ReceiverID,Content,DateTime,Img) VALUES(#{ChatID}, #{SenderID}, #{ReceiverID},#{Content},#{DateTime},#{Img})")
    @Options(useGeneratedKeys = true, keyProperty = "ChatID")
    int insertChat(Chat chat);

    @Delete("DELETE FROM chat WHERE ChatID = #{ChatID}")
    int deleteChatByChatID(@Param("ChatID") int ChatID);


}
