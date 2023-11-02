package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MetricsChoice {
    private int metricsChoiceId;
    private int userId;
    private Integer curiosity1;//好奇心
    private Integer curiosity2;//好奇心
    private Integer readly; //是否阅读
    private Integer abstractness1;  //抽象性
    private Integer abstractness2;  //抽象性
    private Integer intellectual;  // 智力投入
    private Integer openl1;  // 开放性
    private Integer openl2;  // 开放性
    private Integer tryNew1;  // 尝新
    private Integer tryNew2;  // 尝新
    private Integer idea1;  // 理想主义性
    private Integer idea2;  // 理想主义性
    private Integer standard1;  // 顺从/独立
    private Integer standard2;  // 顺从/独立
    private Integer hc;  // 虐猫态度
    private Integer fs;  //是否相信风水
    private Integer adventure1;  // 冒险精神
    private Integer adventure2;  // 冒险精神
    private Integer achievement1;  // 成就欲水平
    private Integer achievement2;  // 成就欲水平
    private Integer aesthetic1;  // 美感体验
    private Integer aesthetic2;  // 美感体验
    private Integer excitement1; //寻求刺激
    private Integer excitement2; //寻求刺激
    private Integer rebel1;  // 反叛性
    private Integer rebel2;  // 反叛性
    private Integer altruism1;  // 利他性
    private Integer altruism2;  // 利他性
    private Integer emotion1;  // 情感丰富程度
    private Integer emotion2;  // 情感丰富程度
    private Integer characterl1;  // 性格内向还是外向
    private Integer characterl2;  // 性格内向还是外向
    private Integer organization1; //条理性
    private Integer organization2; //条理性
    private Integer inductive;  // 感性还是理性
    private Integer attitudes; //政治态度
    private Integer selfish1;  // 个人主义还是集体主义
    private Integer selfish2;  // 个人主义还是集体主义
    private Integer male1; //大男子主义
    private Integer male2; //大男子主义
}
