package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserBook {
    private int UserID;
    private int BookID;
    private String Recommendation;
}
