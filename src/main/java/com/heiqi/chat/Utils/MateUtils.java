package com.heiqi.chat.Utils;


import com.heiqi.chat.entity.NonCore;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MateUtils{
//    public NonCore Convert(NonCore noncore){
//        NonCore nonCore = new NonCore();
//        nonCore.setNonCoreID(noncore.getNonCoreID());
//        nonCore.setUserID(noncore.getUserID());
//        if (noncore.getInAndEx()==2){
//            nonCore.setInAndEx(1);
//        }
//        if (noncore.getInAndEx()==3||noncore.getInAndEx()==4){
//            nonCore.setInAndEx(2);
//        }
//        if (noncore.getInAndEx()==0||noncore.getInAndEx()==1){
//            nonCore.setInAndEx(0);
//        }
//        if (noncore.getConfidence()==2){
//            nonCore.setConfidence(1);
//        }
//        if (noncore.getConfidence()==3||noncore.getConfidence()==4){
//            nonCore.setConfidence(2);
//        }
//        if (noncore.getConfidence()==0||noncore.getConfidence()==1){
//            nonCore.setConfidence(0);
//        }
//        if (noncore.getMoralSense()==2){
//            nonCore.setMoralSense(1);
//        }
//        if (noncore.getMoralSense()==3||noncore.getMoralSense()==4){
//            nonCore.setMoralSense(2);
//        }
//        if (noncore.getMoralSense()==0||noncore.getMoralSense()==1){
//            nonCore.setMoralSense(0);
//        }
//        if (noncore.getCure()==2){
//            nonCore.setCure(1);
//        }
//        if (noncore.getCure()==3||noncore.getCure()==4){
//            nonCore.setCure(2);
//        }
//        if (noncore.getCure()==0||noncore.getCure()==1){
//            nonCore.setCure(0);
//        }
//        if (noncore.getEmotion()==2){
//            nonCore.setEmotion(1);
//        }
//        if (noncore.getEmotion()==3||noncore.getEmotion()==4){
//            nonCore.setEmotion(2);
//        }
//        if (noncore.getEmotion()==0||noncore.getEmotion()==1){
//            nonCore.setEmotion(0);
//        }
//        if (noncore.getRisk()==2){
//            nonCore.setRisk(1);
//        }
//        if (noncore.getRisk()==3||noncore.getRisk()==4){
//            nonCore.setRisk(2);
//        }
//        if (noncore.getRisk()==0||noncore.getRisk()==1){
//            nonCore.setRisk(0);
//        }
//        if (noncore.getLeaderShip()==2){
//            nonCore.setLeaderShip(1);
//        }
//        if (noncore.getLeaderShip()==3||noncore.getLeaderShip()==4){
//            nonCore.setLeaderShip(2);
//        }
//        if (noncore.getLeaderShip()==0||noncore.getLeaderShip()==1){
//            nonCore.setLeaderShip(0);
//        }
//        if (noncore.getResPonSiBiLiTy()==2){
//            nonCore.setResPonSiBiLiTy(1);
//        }
//        if (noncore.getResPonSiBiLiTy()==3||noncore.getResPonSiBiLiTy()==4){
//            nonCore.setResPonSiBiLiTy(2);
//        }
//        if (noncore.getResPonSiBiLiTy()==0||noncore.getResPonSiBiLiTy()==1){
//            nonCore.setResPonSiBiLiTy(0);
//        }
//        if (noncore.getRespect()==2){
//            nonCore.setRespect(1);
//        }
//        if (noncore.getRespect()==3||noncore.getRespect()==4){
//            nonCore.setRespect(2);
//        }
//        if (noncore.getRespect()==0||noncore.getRespect()==1){
//            nonCore.setRespect(0);
//        }
//        if (noncore.getReason()==2){
//            nonCore.setReason(1);
//        }
//        if (noncore.getReason()==3||noncore.getReason()==4){
//            nonCore.setReason(2);
//        }
//        if (noncore.getReason()==0||noncore.getReason()==1){
//            nonCore.setReason(0);
//        }
//        if (noncore.getWillPower()==2){
//            nonCore.setWillPower(1);
//        }
//        if (noncore.getWillPower()==3||noncore.getWillPower()==4){
//            nonCore.setWillPower(2);
//        }
//        if (noncore.getWillPower()==0||noncore.getWillPower()==1){
//            nonCore.setWillPower(0);
//        }
//        if (noncore.getAutoNoMy()==2){
//            nonCore.setAutoNoMy(1);
//        }
//        if (noncore.getAutoNoMy()==3||noncore.getAutoNoMy()==4){
//            nonCore.setAutoNoMy(2);
//        }
//        if (noncore.getAutoNoMy()==0||noncore.getAutoNoMy()==1){
//            nonCore.setAutoNoMy(0);
//        }
//
//        if (noncore.getRomantic()==2){
//            nonCore.setRomantic(1);
//        }
//        if (noncore.getRomantic()==3||noncore.getRomantic()==4){
//            nonCore.setRomantic(2);
//        }
//        if (noncore.getRomantic()==0||noncore.getRomantic()==1){
//            nonCore.setRomantic(0);
//        }
//        if (noncore.getChallenge()==2){
//            nonCore.setChallenge(1);
//        }
//        if (noncore.getChallenge()==3||noncore.getChallenge()==4){
//            nonCore.setChallenge(2);
//        }
//        if (noncore.getChallenge()==0||noncore.getChallenge()==1){
//            nonCore.setChallenge(0);
//        }
//        if (noncore.getSolitude()==2){
//            nonCore.setSolitude(1);
//        }
//        if (noncore.getSolitude()==3||noncore.getSolitude()==4){
//            nonCore.setSolitude(2);
//        }
//        if (noncore.getSolitude()==0||noncore.getSolitude()==1){
//            nonCore.setSolitude(0);
//        }
//        if (noncore.getEast()==2){
//            nonCore.setEast(1);
//        }
//        if (noncore.getEast()==3||noncore.getEast()==4){
//            nonCore.setEast(2);
//        }
//        if (noncore.getEast()==0||noncore.getEast()==1){
//            nonCore.setEast(0);
//        }
//        if (noncore.getAchieve()==2){
//            nonCore.setAchieve(1);
//        }
//        if (noncore.getAchieve()==3||noncore.getAchieve()==4){
//            nonCore.setAchieve(2);
//        }
//        if (noncore.getAchieve()==0||noncore.getAchieve()==1){
//            nonCore.setAchieve(0);
//        }
//        return nonCore;


  //  }
  public String Sjs() {
      // 创建Random对象
      Random rand = new Random();

      // 生成4位随机数
      String randomNum = String.valueOf(rand.nextInt(9000) + 1000);

      System.out.println("生成的4位随机数为：" + randomNum);
      return randomNum;
  }

    public  double cosineSimilarity(int[] data1, int[] data2) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < data1.length; i++) {
            dotProduct += data1[i] * data2[i];
            normA += Math.pow(data1[i], 2);
            normB += Math.pow(data2[i], 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

}
