package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private int UserId;
    private String UserName;
    private String Phone;
    private String PassWord;
    private String Photo;
    private String Identity;
    private int Gender;
    private int Age;
    private String Address;
    private int Height;
    private int Education;
    private int Sex;
    private int Beauty;
    private int IsTested; //性格测试状态
    private int IsAuthed; //资料审核状态
    private int IsLogged; //登录状态
    private int MatchStatus; //匹配状态

}
