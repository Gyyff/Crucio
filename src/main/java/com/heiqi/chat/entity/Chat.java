package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Chat {
    private int ChatID;
    private int SenderID;
    private int ReceiverID;
    private String Content;
    private Date DateTime;
}
