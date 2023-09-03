package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Represent {
    private int UserId ;
    private String Description; // 自我描述
    private String Seek; //理想追求
    private String LifeWay; //生活方式
    private String Idol; // 崇拜的人
}
