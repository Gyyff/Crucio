package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPreferenceChoice {

    private int userPreferenceChoiceId;
    private int userId;
    private Integer curiosity;//好奇心
    private Integer readly; //是否阅读
    private Integer abstractness;  //抽象性
    private Integer intellectual;  // 智力投入
    private Integer openl;  // 开放性
    private Integer tryNew;  // 尝新
    private Integer idea;  // 理想主义性
    private Integer standard;  // 顺从/独立
    private Integer hc;  // 虐猫态度
    private Integer fs;  //是否相信风水
    private Integer adventure;  // 冒险精神
    private Integer achievement;  // 成就欲水平
    private Integer aesthetic;  // 美感体验
    private Integer excitement; //寻求刺激
    private Integer rebel;  // 反叛性
    private Integer altruism;  // 利他性
    private Integer emotion;  // 情感丰富程度
    private Integer characterl;  // 性格内向还是外向
    private Integer organization; //条理性
    private Integer inductive;  // 感性还是理性
    private Integer attitudes; //政治态度
    private Integer selfish;  // 个人主义还是集体主义
    private Integer male; //大男子主义
}
