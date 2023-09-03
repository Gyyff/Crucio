package com.heiqi.chat.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.heiqi.chat.Utils.MatchUtils;
import com.heiqi.chat.Utils.MateUtils;
import com.heiqi.chat.controller.SendSMS;
import com.heiqi.chat.entity.Metrics;
import com.heiqi.chat.entity.User;
import com.heiqi.chat.entity.UserPreference;
import com.heiqi.chat.mapper.MetricsMapper;
import com.heiqi.chat.mapper.UserMapper;
import com.heiqi.chat.mapper.UserPreferenceMapper;
import com.heiqi.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class UserServiceImp implements UserService {

    private final UserMapper userMapper;
    private final MetricsMapper metricsMapper;
    private final UserPreferenceMapper userPreferenceMapper;

    private final MatchUtils matchUtils;

    private final MateUtils mateUtils;


    @Autowired
    public UserServiceImp(UserMapper userMapper, MetricsMapper metricsMapper, UserPreferenceMapper userPreferenceMapper, MatchUtils matchUtils,MateUtils mateUtils) {
        this.userMapper = userMapper;
        this.metricsMapper = metricsMapper;
        this.userPreferenceMapper = userPreferenceMapper;
        this.matchUtils = matchUtils;
        this.mateUtils = mateUtils;
    }

    String Temp;

    @Override
    public User getUserById(int UserId) {
        return userMapper.getUserById(UserId);
    }

    @Override
    public User getUserByName(String UserName) {
        return userMapper.getUserByName(UserName);
    }

    @Override
    public User getUserByAge(int Age) {
        return userMapper.getUserByAge(Age);
    }

    @Override
    public User getUserByAddress(String Address) {
        return userMapper.getUserByAddress(Address);
    }

    @Override
    public User getUserByPhone(String Phone) {
        return userMapper.getUserByPhone(Phone);
    }

    @Override
    public String sendSMSofLogon(String Phone) throws Exception {
        Temp = mateUtils.Sjs();
        String TEMPT = "{\"code\" : \""+Temp+"\"}";
        SendSMS.SendSms(Phone,TEMPT);
        return Temp;
    }

    @Override
    public User userLogon(String Phone,String Tempt) {
        String falsePhone = null;
        System.out.println("Temp= " + Temp);
        if (Tempt.equals(Temp)){
            System.out.println("验证码正确 验证成功");
            User user = userMapper.getUserByPhone(Phone);
            userMapper.updateUserIsLogged(user.getUserId(),1);
            System.out.println("登录成功");
            return user;
        }else
            System.out.println("登陆失败 请检查验证码");
            return userMapper.getUserByPhone(falsePhone);

    }

    @Override
    public void userQuit(int UserId){
        userMapper.updateUserIsLogged(UserId,0);
    }




//    @Override
//    public List<Metrics> getUserMatch(int UserId) {
//        System.out.println("首先开始用户核心属性匹配........................");
//        //得到当前用户的经验开放性水平的得分
//        int ScoRel = metricsMapper.getMetricsByUserID(UserId).getScoRel();
//        //得到当前user的核心匹配属性(对象)
//        Metrics thisUserMetrics = metricsMapper.getMetricsByUserID(UserId);
//        //设定需要匹配的经验开放性水平总分的区间
//        int ScoRelMax = ScoRel + 4;
//        int ScoRelMin = ScoRel - 4;
//        //建立匹配成功的用户集合
//        List<Metrics> successList = new ArrayList<>();
//        //找到符合当前用户经验开放水平得分区间的用户集合
//        List<Metrics> metricses = metricsMapper.findUserByScoRel(ScoRelMax, ScoRelMin);
//        System.out.println("符合当前用户经验开放水平得分总分区间的人数有：" + metricses.size() + "人");
//        //遍历集合，在循环中逐一进行筛选，最终将通过筛选匹配的用户放入成功匹配的用户集合
//        metricses.forEach((metrics) -> {
//            //首先排除自己
//            if (metrics.getUserID() != thisUserMetrics.getUserID()) {
//                //性别判断
//                if (userMapper.getUserById(thisUserMetrics.getUserID()).getSex() == userMapper.getUserById(metrics.getUserID()).getGender())
//                    //判断用户的匹配状态
//                    if ((userMapper.getUserById(metrics.getUserID()).getMatchStatus() == 1) || (userMapper.getUserById(metrics.getUserID()).getMatchStatus() == 0)) {
//                        //Freedom匹配:用户有三种状态 0、1、2，分别表示 威权 中立 自由，自由的只能和自由的匹配到一起，中立的可以和中立、威权的匹配到一起，中立和威权都不能匹配到自由
//                        if ((thisUserMetrics.getFreedom() == 2 && metrics.getFreedom() == 2) || (thisUserMetrics.getFreedom() == metrics.getFreedom()) || (thisUserMetrics.getFreedom() == 0 && metrics.getFreedom() == 1) || (thisUserMetrics.getFreedom() == 1 && metrics.getFreedom() == 0)) {
//                            //Idea理想主义程度匹配:用户评分满分是五分 我们需要在当前用户评分的基础上 进行+1-1或者相等的区间匹配
//                            if (((metrics.getIdea() + 1) == thisUserMetrics.getIdea()) || ((metrics.getIdea() - 1) == thisUserMetrics.getIdea()) || (metrics.getIdea() == thisUserMetrics.getIdea())) {
//                                //Standard顺从或者独立型性格匹配:用户评分满分是五分 我们需要在当前用户评分的基础上 进行+1-1或者相等的区间匹配
//                                if (((metrics.getStandard() + 1) == thisUserMetrics.getStandard()) || ((metrics.getStandard() - 1) == thisUserMetrics.getStandard()) || (metrics.getStandard() == thisUserMetrics.getStandard())) {
//                                    //ChineseMed是否相信中医匹配:用户三种状态有0、1、2，分别表示 相信 中立 不相信 ，中立的可以和任何类型的匹配到一起，相信的可以和中立、相信匹配，不信的可以和不信、中立匹配，这里我们仍可以用+1-1进行匹配
//                                    if (((metrics.getChineseMed() + 1) == thisUserMetrics.getChineseMed()) || ((metrics.getChineseMed() - 1) == thisUserMetrics.getChineseMed()) || (metrics.getChineseMed() == thisUserMetrics.getChineseMed())) {
//                                        //Star是否相信星座匹配:用户有三种状态 0、1、2，分别表示 相信 中立 不相信，不相信的只能和不相信的匹配到一起，中立的可以和中立、相信的匹配到一起，中立和相信都不能匹配到不相信
//                                        if ((metrics.getStar() == 2 && thisUserMetrics.getStar() == 2) || (metrics.getStar() == thisUserMetrics.getStar()) || (metrics.getStar() == 0 && thisUserMetrics.getStar() == 1) || (metrics.getStar() == 1 && thisUserMetrics.getStar() == 0)) {
//                                            //FS是否相信风水:用户有三种状态 0、1、2，分别表示 相信 中立 不相信，不相信的只能和不相信的匹配到一起，中立的可以和中立、相信的匹配到一起，中立和相信都不能匹配到不相信
//                                          if ((metrics.getFS() == 2 && thisUserMetrics.getFS() == 2) || (metrics.getFS() == thisUserMetrics.getFS()) || (metrics.getFS() == 0 && thisUserMetrics.getFS() == 1) || (metrics.getFS() == 1 && thisUserMetrics.getFS() == 0)) {
//                                                //Principle是否认同美国制度匹配:用户有三种状态 0、1、2，分别表示 认同 中立 不认同，认同的只会与认同的匹配在一起，中立的可以和中立、不认同的匹配在一起，不认同的可以和中立、不认同的匹配在一起
//                                                if ((metrics.getPrinciple() == 0 && thisUserMetrics.getPrinciple() == 0) || (metrics.getPrinciple() == thisUserMetrics.getPrinciple()) || (metrics.getPrinciple() == 1 && thisUserMetrics.getPrinciple() == 2) || (metrics.getPrinciple() == 2 && thisUserMetrics.getPrinciple() == 1)) {
//                                                    //NewAThings尝新性 用户有三种状态 0、1、2，分别表示 认同 中立 不认同，认同的只会与认同的匹配在一起，中立的可以和中立、不认同的匹配在一起，不认同的可以和中立、不认同的匹配在一起
//                                                    if (((metrics.getNewAThings()+1)==thisUserMetrics.getNewAThings())||((metrics.getNewAThings()-1)==thisUserMetrics.getNewAThings())||(metrics.getNewAThings()==thisUserMetrics.getNewAThings())){
//                                                    //将经过筛选的用户放入successList集合
//                                                    successList.add(metrics);
//                                              }
//                                            }
//                                        }
//
//                                    }
//
//                                }
//
//                            }
//                        }
//                    }
//            }}
//        });
//        System.out.println("经过第一轮用户核心属性匹配后得到了" + successList.size() + "人");
//        System.out.println("核心属性匹配结束............................................");
//        return successList;
//
//
//    }

    //**匹配入口**

    @Override
    public User getUserMatch(int UserId) {
        //首先得到当前用户的用户所想要匹配的对象的 年龄区间 学历区间 以及用户的性取向
        UserPreference userPreference = userPreferenceMapper.getUserPreferenceByUserId(UserId);
        Metrics UserMetrics = metricsMapper.getMetricsByUserID(UserId);
        User user = userMapper.getUserById(UserId);
        // 根据用户选择的年龄区间 确定出最初的匹配范围
        List<User> usersByAgeBetween = userMapper.getUsersByAgeBetween(userPreference.getAgeMax(), userPreference.getAgeMin());
        //在此范围内 筛选出符合用户性取向 学历要求的用户 并且提前建立一个准备进行偏好匹配的集合
        List<User> firstUsers = new ArrayList<>();
        usersByAgeBetween.forEach((fuser -> {
            //  ①参与匹配的用户学历等级>= 用户偏好等级  ②参与匹配的用户性别 == 用户的性取向 ③参与匹配的用户 是未被匹配的状态
            if ((userPreference.getEducation() <= fuser.getEducation()) && (user.getSex() == fuser.getGender()) && (fuser.getMatchStatus() == 0)) {
                firstUsers.add(fuser);
            }
        }));
        //进行第二轮适配
        //设置三个变量 TmaX：单向适配的最高得分   TAndS：双向适配的*总*分 T+St(双向匹配的得分) SucCesUserId：匹配成功的用户ID
        AtomicInteger TmaX = new AtomicInteger();
        AtomicInteger TAndS = new AtomicInteger();
        AtomicInteger SucCesUserId = new AtomicInteger();
        //遍历集合进行循环匹配  匹配逻辑参考 MatchUtils这个类中的 MateMatchSimilarity()方法
        firstUsers.forEach((sUser -> {
            System.out.println("---------------开始--------------");
            System.out.println("当前进行适配的用户id是" + sUser.getUserId());
            Metrics metricsUser = metricsMapper.getMetricsByUserID(sUser.getUserId());
            int T = 0;
            T += matchUtils.MateMatchSimilarity(userPreference.getCuriosity(), metricsUser.getCuriosity());
//            System.out.println("A=" + userPreference.getCuriosity() + "   " + "B=" + metricsUser.getCuriosity() + "   " + "T1 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getReadly(), metricsUser.getReadly());
//            System.out.println("A=" + userPreference.getReadly() + "   " + "B=" + metricsUser.getReadly() + "   " + "T2 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getAbstractness(), metricsUser.getAbstractness());
//            System.out.println("A=" + userPreference.getAbstractness() + "   " + "B=" + metricsUser.getAbstractness() + "   " + "T3 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getIntellectual(), metricsUser.getIntellectual());
//            System.out.println("A=" + userPreference.getIntellectual() + "   " + "B=" + metricsUser.getIntellectual() + "   " + "T4 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getOpenl(), metricsUser.getOpenl());
//            System.out.println("A=" + userPreference.getOpen() + "   " + "B=" + metricsUser.getOpen() + "   " + "T5 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getTryNew(), metricsUser.getTryNew());
//            System.out.println("A=" + userPreference.getTryNew() + "   " + "B=" + metricsUser.getTryNew() + "   " + "T6 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getIdea(), metricsUser.getIdea());
//            System.out.println("A=" + userPreference.getIdea() + "   " + "B=" + metricsUser.getIdea() + "   " + "T7 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getStandard(), metricsUser.getStandard());
//            System.out.println("A=" + userPreference.getStandard() + "   " + "B=" + metricsUser.getStandard() + "   " + "T8 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getHc(), metricsUser.getHc());
//            System.out.println("A=" + userPreference.getHc() + "   " + "B=" + metricsUser.getHc() + "   " + "T9 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getFs(), metricsUser.getFs());
//            System.out.println("A=" + userPreference.getFs() + "   " + "B=" + metricsUser.getFs() + "   " + "T10 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getStar(), metricsUser.getStar());
//            System.out.println("A=" + userPreference.getStar() + "   " + "B=" + metricsUser.getStar() + "   " + "T11 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getChineseMed(), metricsUser.getChineseMed());
//            System.out.println("A=" + userPreference.getChineseMed() + "   " + "B=" + metricsUser.getChineseMed() + "   " + "T12 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getAdventure(), metricsUser.getAdventure());
//            System.out.println("A=" + userPreference.getAdventure() + "   " + "B=" + metricsUser.getAdventure() + "   " + "T13 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getAchievement(), metricsUser.getAchievement());
//            System.out.println("A=" + userPreference.getAchievement() + "   " + "B=" + metricsUser.getAchievement() + "   " + "T14 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getAesthetic(), metricsUser.getAesthetic());
//            System.out.println("A=" + userPreference.getAesthetic() + "   " + "B=" + metricsUser.getAesthetic() + "   " + "T15 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getExcitement(), metricsUser.getExcitement());
//            System.out.println("A=" + userPreference.getExcitement() + "   " + "B=" + metricsUser.getExcitement() + "   " + "T16 = " + T);
            T += matchUtils.MateMatchSimilarity(userPreference.getRebel(),metricsUser.getRebel());
            T += matchUtils.MateMatchSimilarity(userPreference.getAltruism(),metricsUser.getAltruism());
            T += matchUtils.MateMatchSimilarity(userPreference.getEmotion(),metricsUser.getEmotion());
            T += matchUtils.MateMatchSimilarity(userPreference.getCharacterl(),metricsUser.getCharacterl());
            T += matchUtils.MateMatchSimilarity(userPreference.getOrganization(),metricsUser.getOrganization());
            T += matchUtils.MateMatchSimilarity(userPreference.getInductive(),metricsUser.getInductive());
            T += matchUtils.AttitudesSimilarity(userPreference.getAttitudes(),metricsUser.getAttitudes());
            T += matchUtils.MateMatchSimilarity(userPreference.getSelfish(),metricsUser.getSelfish());
            T += matchUtils.MaleSimilarity(userPreference.getMale(),metricsUser.getMale(),user.getGender());
            System.out.println("当前用户性别为"+user.getGender()+"----大男子主义匹配分数为" +matchUtils.MaleSimilarity(userPreference.getMale(),metricsUser.getMale(),user.getGender()));
            //采用累加制 计算出T的总和
            System.out.println("最终匹配结束总分T总 = " + T);
            //只有单向匹配分数>0 才可进入双向匹配  同时如果单向得分小于最高分数 则排除掉该用户
            if (T > 0) {
                //进行双向匹配 同理参考MatchUtils这个类中的 MateMatchSimilarity()方法  只不过参数调换位置
                System.out.println("------找到了一名契合度高的用户 开始双向契合度匹配------");
                System.out.println("-------双向匹配开始-------");
                int St = 0;
                UserPreference sUserPreference = userPreferenceMapper.getUserPreferenceByUserId(sUser.getUserId());
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
                St += matchUtils.MateMatchSimilarity(sUserPreference.getStar(), UserMetrics.getStar());
                St += matchUtils.MateMatchSimilarity(sUserPreference.getChineseMed(), UserMetrics.getChineseMed());
                St += matchUtils.MateMatchSimilarity(sUserPreference.getAdventure(), UserMetrics.getAdventure());
                St += matchUtils.MateMatchSimilarity(sUserPreference.getAchievement(), UserMetrics.getAchievement());
                St += matchUtils.MateMatchSimilarity(sUserPreference.getAesthetic(), UserMetrics.getAesthetic());
                St += matchUtils.MateMatchSimilarity(sUserPreference.getExcitement(), UserMetrics.getExcitement());
                St +=matchUtils.MateMatchSimilarity(sUserPreference.getRebel(),UserMetrics.getRebel());
                St +=matchUtils.MateMatchSimilarity(sUserPreference.getAltruism(),UserMetrics.getAltruism());
                St +=matchUtils.MateMatchSimilarity(sUserPreference.getEmotion(),UserMetrics.getEmotion());
                St +=matchUtils.MateMatchSimilarity(sUserPreference.getCharacterl(),UserMetrics.getCharacterl());
                St +=matchUtils.MateMatchSimilarity(sUserPreference.getOrganization(),UserMetrics.getOrganization());
                St +=matchUtils.MateMatchSimilarity(sUserPreference.getInductive(),UserMetrics.getInductive());
                St +=matchUtils.AttitudesSimilarity(sUserPreference.getAttitudes(),UserMetrics.getAttitudes());
                St +=matchUtils.MateMatchSimilarity(sUserPreference.getSelfish(),UserMetrics.getSelfish());
                St +=matchUtils.MaleSimilarity(sUserPreference.getMale(),UserMetrics.getMale(),sUser.getGender());
                System.out.println("当前用户性别为"+sUser.getGender()+"----大男子主义匹配分数为" +matchUtils.MaleSimilarity(sUserPreference.getMale(),UserMetrics.getMale(),sUser.getGender()));
                System.out.println("该用户对当前用户的双向匹配得分为" + St);

                if ((St > 0) && ((St + T) > TAndS.get())) {
                    TAndS.set(St + T);
                    SucCesUserId.set(sUser.getUserId());
                    System.out.println("当前双向契合度最高分为" + TAndS.get() + "   " + "这位用户的ID是" + SucCesUserId.get());
                    System.out.println("成功找到一位适配对象！！");
                } else {
                    System.out.println("双向匹配度过低 适配结束 开始匹配下一位对象");
                }
                System.out.println("-------双向匹配结束------- ");
            }
            System.out.println("---------------结束--------------");
            System.out.println("    ");
            System.out.println("    ");
        }));
        System.out.println("匹配结束 最高适配度的用户是" + " " + SucCesUserId.get() + " " + "号用户" + "    " + "他与当前用户的双向契合度总分是" + " " + TAndS.get() + "分。");
        User sUser = userMapper.getUserById(SucCesUserId.get());
        if (sUser!=null){
            userMapper.updateUserMatchStatus(user.getUserId(),1);
            userMapper.updateUserMatchStatus(sUser.getUserId(),1);
        }
        return  sUser;
    }

    @Override
    public void insertUser(User user) {
         userMapper.insertUser(user);
    }

    @Override
    public void deleteUser(int UserId) {
         userMapper.deleteUser(UserId);
    }

    @Override
    public void updateUserName(int UserId, String UserName) {
         userMapper.updateUserName(UserId, UserName);
    }

    @Override
    public void updateUserAge(int UserId, int Age) {
         userMapper.updateUserAge(UserId, Age);
    }

    @Override
    public void updateUserAddress(int UserId, String Address) {
         userMapper.updateUserAddress(UserId, Address);
    }

    @Override
    public void updateUserIdentity(int UserId, String Identity) {
         userMapper.updateUserIdentity(UserId, Identity);
    }

    @Override
    public void updateUserEducation(int UserId, int Education) {
         userMapper.updateUserEducation(UserId, Education);
    }

    @Override
    public void updateUserPhoto(int UserId, String Photo) {
         userMapper.updateUserPhoto(UserId, Photo);
    }

    @Override
    public void updateUserGender(int UserId, int Gender) {
        userMapper.updateUserGender(UserId,Gender);
    }

    @Override
    public void updateUserSex(int UserId, int Sex) {
        userMapper.updateUserSex(UserId,Sex);
    }
    @Override
    public void updateUserHeight(int UserId, int Height) {
        userMapper.updateUserHeight(UserId,Height);
    }


    @Override
    public void updateUserIsAuthed(int UserId, int IsAuthed) {
         userMapper.updateUserIsAuthed(UserId, IsAuthed);
    }

    @Override
    public void updateUserIsLogged(int UserId, int IsLogged) {
         userMapper.updateUserIsLogged(UserId, IsLogged);
    }

    @Override
    public void updateUserMatchStatus(int UserId, int MatchStatus) {
         userMapper.updateUserMatchStatus(UserId, MatchStatus);
    }

    @Override
    public void updateUserIsTested(int UserId, int IsTested) {
         userMapper.updateUserIsTested(UserId, IsTested);
    }



}