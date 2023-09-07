package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class User {
    private int UserId;
    private String UserName;//用户名
    private String Phone;//手机号
    private String PassWord;//密码
    private String Photo;//照片
    private String Identity;//所在行业 身份
    private int Gender;//性别
    private int Age;//年龄
    private String BirthDay;//生日
    private int Weight;//体重
    private String School; //毕业院校
    private String HomeTownA;//家乡 省（直辖市）
    private String HomeTownB;//家乡 市（所在区）
    private String AddressA;//现居地 省（直辖市）
    private String AddressB;//现居地 市（所在区）
    private int Height;//身高
    private int Education;//教育水平
    private int Beauty;//颜值
    private int IsPreference;//偏好测试状态
    private int IsTested; //性格测试状态
    private int IsAuthed; //资料审核状态
    private int IsLogged; //登录状态
    private int MatchStatus; //匹配状态

}
