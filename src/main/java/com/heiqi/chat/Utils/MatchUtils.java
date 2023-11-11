package com.heiqi.chat.Utils;

import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.Match;
import com.heiqi.chat.entity.Metrics;
import com.heiqi.chat.entity.User;
import com.heiqi.chat.entity.UserPreference;
import com.heiqi.chat.mapper.MatchMapper;
import com.heiqi.chat.mapper.MetricsMapper;
import com.heiqi.chat.mapper.UserMapper;
import com.heiqi.chat.mapper.UserPreferenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MatchUtils {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MetricsMapper metricsMapper;
    @Autowired
    private UserPreferenceMapper userPreferenceMapper;
    @Autowired
    private MatchMapper matchMapper;



    public int MateMatchSimilarity(int user1Values, int user2Value) {
        //关于匹配逻辑  判断B对A的吸引力，实际上最重要的是A的偏好如何
        //比如略微注重开放性的话，即使对方B开放性再高，在A看来吸引力也和略微注重开放性是一样的。
        //所以偏好重要的是加分的上限。   略微注重最高加1分   比较注重加3分   非常注重加6分


        //对于一个略微注重的，无论对方  略微具备 比较具备  非常具备  都最多只加一分
        if ((user1Values==2)&&(user2Value>=2)){
            return 1;
        }
        //对于比较注重的， 对方略微具备 加1分  比较具备和非常具备 都只加3分
        if (user1Values==4&&user2Value==2){
            return 1;
        }
        if (user1Values==4&&user2Value>=4){
            return 3;
        }
        //对于非常注重的，对方略微具备 直接排除   比较具备  加3分  非常具备加 6分
        if (user1Values==6&&user2Value<=2){
            return -300;
        }
        if (user1Values==6&&user2Value==4){
            return 3;
        }
        if (user1Values==6&&user2Value==6){
            return 6;
        }
        //同理扣分也是  也存在上限，最多扣一分，最多扣三分，以及非常注重的直接排除负分的。
        //对于略微注重的，无论对方 略微不具备  比较不具备  非常不具备  都是最多只扣一分
        if (user1Values==2&&user2Value<=-2){
            return -1;
        }
        //对于比较注重的，对方 略微不具备 扣一分，比较不具备 和非常 不具备 扣3分
        if (user1Values==4&&user2Value==-2){
            return -1;
        }
        if (user1Values==4&&user2Value<=-4){
            return -3;
        }
        else
            return 0;

        //对于非常注重的，只要负分 就直接排除

    }
    public int AttitudesSimilarity(int user1Values,int user2Values){
        //用户 非常热爱中国的制度 则直接排除略微及以下的
        if (user1Values==6&&user2Values<2){
            return -300;
        }
        //用户 比较热爱中国的制度 则排除略微喜欢西方制度及以下的
        if (user1Values==4&&user2Values<=-2){
            return -300;
        }
        //用户 非常热爱西方制度 则排除略微以以上热爱中国制度的
        if (user1Values==-6&&user2Values>=-2){
            return -300;
        }
        //用户 比较热爱西方制度 则排除略微喜欢中国制度及以上
        if (user1Values==-4&&user2Values>=2){
            return -300;
        }
        //用户 都同时非常热爱中国国家的制度
        if (user1Values==6&&user2Values==6){
            return 6;
        }
        //用户 都同时非常热爱西方国家的制度
        if (user1Values==-6&&user2Values==-6){
            return 6;
        }
        else return 2;
    }

    public int MaleSimilarity(int user1Values,int user2Values,int user1Gender){
        //男生则直接跳过
        if (user1Gender==1){
            return 0;
        }
        //女生则直接进入匹配
        if (user1Gender==0){
            //女生如果比较讨厌大男子主义 男生比较不是大男子主义
            if (user1Values<=-4&&user2Values<=-4){
                return 2;
            }
            //女生略微讨厌大男子主义  男生特质<=0
            if (user1Values<=-2&&user2Values<=0){
                return 1;
            }
            //女生讨厌大男子主义 男生具有大男子主义
            if (user1Values<=-4&&user2Values>=4){
                return -60;
            }
            //女生喜欢大男子主义 男生没有大男子主义
            if (user1Values>=4&&user2Values<=-4){
                return -60;
            }
            //女生比较喜欢大男子主义  男生比较大男子主义
            if (user1Values>=4&&user2Values>=4){
                return 2;
            }
            //女生喜欢大男子主义 男生具有大男子主义
            if (user1Values>0&&user2Values>0){
                return 1;
            }
            //女生不喜欢大男子主义 男生没有大男子主义
            if (user1Values<0&&user2Values<0){
                return 1;
            }
        }
        return 0;
    }





    //测试匹配
    public Result getUserMatch(int UserId) throws Exception {
        MatchUtils matchUtils = new MatchUtils();
        User user = userMapper.getUserById(UserId);
       if (user.getIsPreference() == 0 && user.getIsTested() == 0) {
           return Result.error("请您完成偏好测试和性格测试后再来匹配");
       }
       if (user.getIsPreference() == 0) {
           return Result.error("请您完成偏好测试后再来匹配");
       }
       if (user.getIsTested() == 0) {
           return Result.error("请您完成性格测试后再来匹配");
       }

       if (userMapper.getUserById(UserId).getMatchStatus() == 0) {
           //首先得到当前用户的用户所想要匹配的对象的 年龄区间 学历区间 以及用户的性取向
           UserPreference userPreference = userPreferenceMapper.getUserPreferenceByUserId(UserId);
           Metrics UserMetrics = metricsMapper.getMetricsByUserID(UserId);

           // 根据用户选择的年龄区间 确定出最初的匹配范围
           List<User> usersByAgeBetween = userMapper.getUsersByAgeBetween(userPreference.getAgeMax(), userPreference.getAgeMin());
           //在此范围内 筛选出符合用户性取向 学历要求的用户 并且提前建立一个准备进行偏好匹配的集合
           List<User> firstUsers = new ArrayList<>();
           usersByAgeBetween.forEach((fuser -> {
               //  ①参与匹配的用户学历等级>= 用户偏好等级  ②参与匹配的用户性别 == 用户的性取向 ③参与匹配的用户 是未被匹配的状态
               if ((userPreference.getEducation() <= fuser.getEducation()) && ((userPreference.getSex() == fuser.getGender())||(userPreference.getSex()==2)) && (fuser.getMatchStatus() == 0)) {
                   firstUsers.add(fuser);
               }
           }));
           //进行第二轮适配
           //设置三个变量 TmaX：单向适配的最高得分   TAndS：双向适配的*总*分 T+St(双向匹配的得分) SucCesUserId：匹配成功的用户ID
           AtomicInteger TmaX = new AtomicInteger();
           AtomicInteger TAndS = new AtomicInteger();
           AtomicInteger SucCesUserId = new AtomicInteger();
           //遍历集合进行循环匹配  匹配逻辑参考 MatchUtils这个类中的 MateMatchSimilarity()方法
           if (firstUsers != null) {
               firstUsers.forEach((sUser -> {
                   System.out.println("---------------开始--------------");
                   System.out.println("当前进行适配的用户id是" + sUser.getUserId());
                   Metrics metricsUser = metricsMapper.getMetricsByUserID(sUser.getUserId());
                   int T = 0;
                   if (metricsUser != null) {
                       T += matchUtils.MateMatchSimilarity(userPreference.getCuriosity(), metricsUser.getCuriosity());
//           System.out.println("A=" + userPreference.getCuriosity() + "   " + "B=" + metricsUser.getCuriosity() + "   " + "T1 = " + T);
                     T += matchUtils.MateMatchSimilarity(userPreference.getReadly(), metricsUser.getReadly());
//           System.out.println("A=" + userPreference.getReadly() + "   " + "B=" + metricsUser.getReadly() + "   " + "T2 = " + T);
                     T += matchUtils.MateMatchSimilarity(userPreference.getAbstractness(), metricsUser.getAbstractness());
//           System.out.println("A=" + userPreference.getAbstractness() + "   " + "B=" + metricsUser.getAbstractness() + "   " + "T3 = " + T);
                     T += matchUtils.MateMatchSimilarity(userPreference.getIntellectual(), metricsUser.getIntellectual());
//           System.out.println("A=" + userPreference.getIntellectual() + "   " + "B=" + metricsUser.getIntellectual() + "   " + "T4 = " + T);
                     T += matchUtils.MateMatchSimilarity(userPreference.getOpenl(), metricsUser.getOpenl());
//           System.out.println("A=" + userPreference.getOpenl() + "   " + "B=" + metricsUser.getOpenl() + "   " + "T5 = " + T);
                     T += matchUtils.MateMatchSimilarity(userPreference.getTryNew(), metricsUser.getTryNew());
//           System.out.println("A=" + userPreference.getTryNew() + "   " + "B=" + metricsUser.getTryNew() + "   " + "T6 = " + T);
                     T += matchUtils.MateMatchSimilarity(userPreference.getIdea(), metricsUser.getIdea());
//           System.out.println("A=" + userPreference.getIdea() + "   " + "B=" + metricsUser.getIdea() + "   " + "T7 = " + T);
                     T += matchUtils.MateMatchSimilarity(userPreference.getStandard(), metricsUser.getStandard());
//           System.out.println("A=" + userPreference.getStandard() + "   " + "B=" + metricsUser.getStandard() + "   " + "T8 = " + T);
                     T += matchUtils.MateMatchSimilarity(userPreference.getHc(), metricsUser.getHc());
//           System.out.println("A=" + userPreference.getHc() + "   " + "B=" + metricsUser.getHc() + "   " + "T9 = " + T);
                     T += matchUtils.MateMatchSimilarity(userPreference.getFs(), metricsUser.getFs());
//           System.out.println("A=" + userPreference.getFs() + "   " + "B=" + metricsUser.getFs() + "   " + "T10 = " + T);
                     T += matchUtils.MateMatchSimilarity(userPreference.getAdventure(), metricsUser.getAdventure());
 //          System.out.println("A=" + userPreference.getAdventure() + "   " + "B=" + metricsUser.getAdventure() + "   " + "T13 = " + T);
                     T += matchUtils.MateMatchSimilarity(userPreference.getAchievement(), metricsUser.getAchievement());
 //          System.out.println("A=" + userPreference.getAchievement() + "   " + "B=" + metricsUser.getAchievement() + "   " + "T14 = " + T);
                     T += matchUtils.MateMatchSimilarity(userPreference.getAesthetic(), metricsUser.getAesthetic());
 //          System.out.println("A=" + userPreference.getAesthetic() + "   " + "B=" + metricsUser.getAesthetic() + "   " + "T15 = " + T);
                     T += matchUtils.MateMatchSimilarity(userPreference.getExcitement(), metricsUser.getExcitement());
 //          System.out.println("A=" + userPreference.getExcitement() + "   " + "B=" + metricsUser.getExcitement() + "   " + "T16 = " + T);
                       T += matchUtils.MateMatchSimilarity(userPreference.getRebel(), metricsUser.getRebel());
                       T += matchUtils.MateMatchSimilarity(userPreference.getAltruism(), metricsUser.getAltruism());
                       T += matchUtils.MateMatchSimilarity(userPreference.getEmotion(), metricsUser.getEmotion());
                       T += matchUtils.MateMatchSimilarity(userPreference.getCharacterl(), metricsUser.getCharacterl());
                       T += matchUtils.MateMatchSimilarity(userPreference.getOrganization(), metricsUser.getOrganization());
                       T += matchUtils.MateMatchSimilarity(userPreference.getInductive(), metricsUser.getInductive());
                       T += matchUtils.AttitudesSimilarity(userPreference.getAttitudes(), metricsUser.getAttitudes());
                       T += matchUtils.MateMatchSimilarity(userPreference.getSelfish(), metricsUser.getSelfish());
                       T += matchUtils.MaleSimilarity(userPreference.getMale(), metricsUser.getMale(), user.getGender());
 //                      System.out.println("当前用户性别为" + user.getGender() + "----大男子主义匹配分数为" + matchUtils.MaleSimilarity(userPreference.getMale(), metricsUser.getMale(), user.getGender()));
                   }
                   //采用累加制 计算出T的总和
                   System.out.println("最终匹配结束总分T总 = " + T);
                   //只有单向匹配分数>0 才可进入双向匹配  同时如果单向得分小于最高分数 则排除掉该用户
                   if (T > 0) {
                       //进行双向匹配 同理参考MatchUtils这个类中的 MateMatchSimilarity()方法  只不过参数调换位置
//                       System.out.println("------找到了一名契合度高的用户 开始双向契合度匹配------");
//                       System.out.println("-------双向匹配开始-------");
                       int St = 0;
                       UserPreference sUserPreference = userPreferenceMapper.getUserPreferenceByUserId(sUser.getUserId());
                       if ((sUserPreference.getSex() == user.getGender())||(sUserPreference.getSex()==2)) {
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getCuriosity(), UserMetrics.getCuriosity());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getReadly(), UserMetrics.getReadly());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getAbstractness(), UserMetrics.getAbstractness());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getIntellectual(), UserMetrics.getIntellectual());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getOpenl(), UserMetrics.getOpenl());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getTryNew(), UserMetrics.getTryNew());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getIdea(), UserMetrics.getIdea());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getStandard(), UserMetrics.getStandard());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getHc(), UserMetrics.getHc());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getFs(), UserMetrics.getFs());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getAdventure(), UserMetrics.getAdventure());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getAchievement(), UserMetrics.getAchievement());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getAesthetic(), UserMetrics.getAesthetic());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getExcitement(), UserMetrics.getExcitement());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getRebel(), UserMetrics.getRebel());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getAltruism(), UserMetrics.getAltruism());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getEmotion(), UserMetrics.getEmotion());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getCharacterl(), UserMetrics.getCharacterl());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getOrganization(), UserMetrics.getOrganization());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getInductive(), UserMetrics.getInductive());
                           St += matchUtils.AttitudesSimilarity(sUserPreference.getAttitudes(), UserMetrics.getAttitudes());
                           St += matchUtils.MateMatchSimilarity(sUserPreference.getSelfish(), UserMetrics.getSelfish());
                           St += matchUtils.MaleSimilarity(sUserPreference.getMale(), UserMetrics.getMale(), sUser.getGender());
//                           System.out.println("当前用户性别为" + sUser.getGender() + "----大男子主义匹配分数为" + matchUtils.MaleSimilarity(sUserPreference.getMale(), UserMetrics.getMale(), sUser.getGender()));
                           System.out.println("该用户对当前用户的双向匹配得分为" + St);

                           if ((St > 0) && ((St + T) > TAndS.get())) {
                               TAndS.set(St + T);
                               SucCesUserId.set(sUser.getUserId());
          //                     System.out.println("当前双向契合度最高分为" + TAndS.get() + "   " + "这位用户的ID是" + SucCesUserId.get());
           //                    System.out.println("成功找到一位适配对象！！");
                           } else {
             //                  System.out.println("双向匹配度过低 适配结束 开始匹配下一位对象");
                           }
           //                System.out.println("-------双向匹配结束------- ");
                       }
                   }
           //        System.out.println("---------------结束--------------");
           //        System.out.println("    ");
           //        System.out.println("    ");
               }));
               System.out.println("匹配结束 最高适配度的用户是" + " " + SucCesUserId.get() + " " + "号用户" + "    " + "他与当前用户的双向契合度总分是" + " " + TAndS.get() + "分。");
               User sUser = userMapper.getUserById(SucCesUserId.get());
               if (sUser != null) {
                   matchMapper.insertMatch(new Match(user.getUserId(), sUser.getUserId(), 0, 0));
                   userMapper.updateUserMatchStatus(user.getUserId(), 1);
                   userMapper.updateUserMatchStatus(sUser.getUserId(), 1);
//                   systemEndpoint.sendSystemMessageToClient("已经成功为您匹配到一位适配对象", sUser.getUserId());
//                   SendEmailUtils.sendMatchEmail(sUser.getEmail());
 //                  SendEmailUtils.sendMatchEmail(user.getEmail());
                   return Result.success(sUser);
               } else {
                   return Result.error("暂时还没有找到适配对象，您可以查看Crucio中目前有多少人符合您的偏好");
               }
           } else {
               return Result.error("暂时还没有找到适配对象，您可以查看Crucio中目前有多少人符合您的偏好");
           }
       } else {
           return Result.error("您正在匹配或已经成功匹配到适配对象，无法进行匹配");
       }

   }
}
