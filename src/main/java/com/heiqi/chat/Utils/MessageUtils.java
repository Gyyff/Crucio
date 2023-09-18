package com.heiqi.chat.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiqi.chat.entity.ResultMessage;

public class MessageUtils {
    public static String getMessage(boolean isSystemMessage, Integer fromUserId, Object message) {
        try {
            ResultMessage resultMessage = new ResultMessage();
            resultMessage.setSystem(isSystemMessage);
            resultMessage.setMessage(message);
            if (fromUserId != null) {
                resultMessage.setFromUserId(fromUserId);
            }
            ObjectMapper mapper = new ObjectMapper();

            return mapper.writeValueAsString(resultMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
