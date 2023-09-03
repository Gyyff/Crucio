package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPreference {
    private int userPreferenceID;
    private int userID;
    private int education; // 想要匹配的人的最高学历
    private int ageMax;  // 想要匹配的人的最大年龄
    private int ageMin; // 想要匹配的人的最小年龄
    private int curiosity;//好奇心
    private int readly; //是否阅读
    private int abstractness;  //抽象性
    private int intellectual;  // 智力投入
    private int openl;  // 开放性
    private int tryNew;  // 尝新
    private int idea;  // 理想主义性
    private int standard;  // 顺从/独立
    private int hc;  // 虐猫态度
    private int fs;  //是否相信风水
    private int star;  // 是否相信星座
    private int chineseMed;  // 是否相信中医
    private int adventure;  // 冒险精神
    private int achievement;  // 成就欲水平
    private int aesthetic;  // 美感体验
    private int excitement; //寻求刺激
    private int rebel;  // 反叛性
    private int altruism;  // 利他性
    private int emotion;  // 情感丰富程度
    private int characterl;  // 性格内向还是外向
    private int organization; //条理性
    private int inductive;  // 感性还是理性
    private int attitudes; //政治态度
    private int selfish;  // 个人主义还是集体主义
    private int male; //大男子主义
}
