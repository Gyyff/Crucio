package com.heiqi.chat.service.impl;

import com.heiqi.chat.Utils.MateUtils;
import com.heiqi.chat.entity.NonCore;
import com.heiqi.chat.mapper.NonCoreMapper;
import com.heiqi.chat.service.NonCoreService;
import com.heiqi.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NonCoreServiceImpl implements NonCoreService {

    private final NonCoreMapper nonCoreMapper;
    private final UserService userService;
    private final MateUtils mateUtils;

    @Autowired
    public NonCoreServiceImpl(NonCoreMapper nonCoreMapper, UserService userService, MateUtils mateUtils) {
        this.nonCoreMapper = nonCoreMapper;
        this.userService = userService;
        this.mateUtils = mateUtils;
    }


    @Override
    public NonCore getNonCoreByNonCoreID(int NonCoreID) {
        return nonCoreMapper.getNonCoreByNonCoreID(NonCoreID);
    }

    @Override
    public NonCore getNonCoreByUserID(int UserID) {
        return nonCoreMapper.getNonCoreByUserID(UserID);
    }

    @Override
    public int insertNonCore(NonCore nonCore) {
        return nonCoreMapper.insertNonCore(nonCore);
    }

    @Override
    public int deleteNonCoreByUserID(int UserID) {
        return nonCoreMapper.deleteNonCoreByUserID(UserID);
    }

    @Override
    public int deleteNonCoreByNonCoreID(int NonCoreID) {
        return nonCoreMapper.deleteNonCoreByNonCoreID(NonCoreID);
    }


//    //*ToDo*灵魂匹配逻辑入口**********
//
//    @Override
//    public List<NonCore> getSoulFriend(int UserID) {
//        //得到当前用户的NonCore对象
//        NonCore thisNonCore = nonCoreMapper.getNonCoreByUserID(UserID);
//        //创建非核心属性匹配成功的集合
//        List<NonCore> Success = new ArrayList<>();
//        userService.getUserMatch(UserID).forEach((nonCores) -> {
//            //找到对应的NonCore对象
//            NonCore nonCore = nonCoreMapper.getNonCoreByUserID(nonCores.getUserID());
//            //开始进行判断 InAndEx 采用+1-1算法
//            if (((thisNonCore.getInAndEx() + 1) == nonCore.getInAndEx()) || ((thisNonCore.getInAndEx() - 1) == nonCore.getInAndEx()) || (thisNonCore.getInAndEx() == nonCore.getInAndEx())) {
//                //Risk(冒险精神) 采用+1-1算法
//                if ((thisNonCore.getRisk() == nonCore.getRisk()) || ((thisNonCore.getRisk() + 1) == nonCore.getRisk()) || ((thisNonCore.getRisk() - 1) == nonCore.getRisk())) {
//                    //Reason(理性还是感性) 采用+1-1算法
//                    if ((thisNonCore.getReason() == nonCore.getReason()) || ((thisNonCore.getReason() + 1) == nonCore.getReason()) || ((thisNonCore.getReason() - 1) == nonCore.getReason())) {
//                        //AutoNoMy(自主性)采用+1-1算法
//                        if ((thisNonCore.getAutoNoMy() == nonCore.getAutoNoMy()) || ((thisNonCore.getAutoNoMy() + 1) == nonCore.getAutoNoMy()) || ((thisNonCore.getAutoNoMy() - 1) == nonCore.getAutoNoMy())) {
//                            //Challenge(安逸还是挑战)必须相等
//                            if ((thisNonCore.getChallenge() == nonCore.getChallenge()) || ((thisNonCore.getChallenge() + 1) == nonCore.getChallenge()) || ((thisNonCore.getChallenge() - 1) == nonCore.getChallenge())) {
//                                //East(东西方文化偏好)必须相等
//                                if ((thisNonCore.getEast() == nonCore.getEast()) || ((thisNonCore.getEast() + 1) == nonCore.getEast()) || ((thisNonCore.getEast() - 1) == nonCore.getEast())) {
//                                    //Achieve(高成就和低成就需求)必须相等
//                                    if ((thisNonCore.getAchieve() == nonCore.getAchieve()) || ((thisNonCore.getAchieve() + 1) == nonCore.getAchieve()) || ((thisNonCore.getAchieve() - 1) == nonCore.getAchieve())) {
//                                        //Respect(是否会尊重他人)必须相等
//                                        if ((thisNonCore.getRespect() == nonCore.getRespect()) || ((thisNonCore.getRespect() + 1) == nonCore.getRespect()) || ((thisNonCore.getRespect() - 1) == nonCore.getRespect())) {
//                                            //Confidence(自信心还是自我怀疑)必须相等
//                                            if ((thisNonCore.getConfidence() == nonCore.getConfidence()) || ((thisNonCore.getConfidence() + 1) == nonCore.getConfidence()) || ((thisNonCore.getConfidence() - 1) == nonCore.getConfidence())) {
//                                                //Cure(治愈他人)必须相等
//                                                if ((thisNonCore.getCure() == nonCore.getCure()) || ((thisNonCore.getCure() + 1) == nonCore.getCure()) || ((thisNonCore.getCure() - 1) == nonCore.getCure())) {
//                                                    //MoralSense(道德感)必须相等
//                                                    if ((thisNonCore.getMoralSense() == nonCore.getMoralSense()) || ((thisNonCore.getMoralSense() + 1) == nonCore.getMoralSense()) || ((thisNonCore.getMoralSense() - 1) == nonCore.getMoralSense())) {
//                                                        //ResPonSiBiLiTy(责任心)必须相等
//                                                        if ((thisNonCore.getResPonSiBiLiTy() == nonCore.getResPonSiBiLiTy()) || ((thisNonCore.getResPonSiBiLiTy() + 1) == nonCore.getResPonSiBiLiTy()) || ((thisNonCore.getResPonSiBiLiTy() - 1) == nonCore.getResPonSiBiLiTy())) {
//                                                            //WillPower(意志力)必须相等
//                                                            if ((thisNonCore.getWillPower() == nonCore.getWillPower()) || ((thisNonCore.getWillPower() + 1) == nonCore.getWillPower()) || ((thisNonCore.getWillPower() - 1) == nonCore.getWillPower())) {
//                                                                //Solitude(安静独处还是热闹)
//                                                                if ((thisNonCore.getSolitude() == nonCore.getSolitude()) || ((thisNonCore.getSolitude() + 1) == nonCore.getSolitude()) || ((thisNonCore.getSolitude() - 1) == nonCore.getSolitude())) {
//                                                                    //Romantic(散漫还是条理 这里翻译错了)使用+-1算法
//                                                                    if ((thisNonCore.getRomantic() + 1) == nonCore.getRomantic() || (thisNonCore.getRomantic() - 1) == nonCore.getRomantic() || thisNonCore.getRomantic() == nonCore.getRomantic()) {
//                                                                        //匹配结束 加入匹配成功的集合
//                                                                        Success.add(nonCore);
//                                                                        System.out.println("匹配成功的队列" + nonCore);
//                                                                    }
//
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//
//
//        });
//        System.out.println("非核心属性匹配开始...................................");
//        System.out.println("经过非核心属性匹配后，与该用户匹配的人数有:" + Success.size() + "人");
//        System.out.println("非核心属性匹配结束........................................");
//        return Success;
//    }
}
