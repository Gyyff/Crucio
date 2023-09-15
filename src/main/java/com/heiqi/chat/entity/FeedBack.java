package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FeedBack {
    private int feedbackId;
    private int userId;
    private int user2Id;
    private int overallPoint;       //总满意度
    private String manyChoice;    //多选题 你对哪一点感觉到不满
    private int thoughtQ;       //思想契合程度
    private int valuesQ;        //价值观和你是否统一
    private int lifeQ;          //人生观和你是否统一
    private int characterQ;     //你是否喜欢对方的性格
    private int conflictQ;       //你们是否有很多思想冲突
    private int humiliationQ;       //对方是否对你产生过羞辱
    private String supplementQ;      //补充 其他回答


}
