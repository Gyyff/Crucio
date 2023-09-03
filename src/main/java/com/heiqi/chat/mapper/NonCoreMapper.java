package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.NonCore;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface NonCoreMapper {
    @Select("SELECT * FROM noncore WHERE NonCoreID = #{NonCoreID}")
    NonCore getNonCoreByNonCoreID(@Param("NonCoreID") int NonCoreID);

    @Select("SELECT * FROM noncore WHERE UserID = #{UserID}")
    NonCore getNonCoreByUserID(@Param("UserID") int UserID);

    @Insert("INSERT INTO noncore(NonCoreID, UserID, InAndEx, Confidence, MoralSense, Cure, Emotion, Risk, LeaderShip, ResPonSiBiLiTy, Respect,Reason,WillPower,AutoNoMy,Romantic,Challenge,Solitude,East,Achieve,NewThings,Empathy,Aesthetic,Stimulate,Anxiety,SoAnxiety,Enthusiasm,Dynamism,Imagination,RichExperience,Frank,Organized,Purpose,Discipline,Rebel,Humorous,Attitude,Fairness) VALUES(#{NonCoreID}, #{UserID}, #{InAndEx}, #{Confidence}, #{MoralSense}, #{Cure}, #{Emotion}, #{Risk}, #{LeaderShip}, #{ResPonSiBiLiTy}, #{Respect},#{Reason},#{WillPower},#{AutoNoMy},#{Romantic},#{Challenge},#{Solitude},#{East},#{Achieve},#{NewThings},#{Empathy},#{Aesthetic},#{Stimulate},#{Anxiety},#{SoAnxiety},#{Enthusiasm},#{Dynamism},#{Imagination},#{RichExperience},#{Frank},#{Organized},#{Purpose},#{Discipline},#{Rebel},#{Humorous},#{Attitude},#{Fairness})")
    @Options(useGeneratedKeys = true, keyProperty = "NonCoreID")
    int insertNonCore(NonCore nonCore);




    @Delete("DELETE FROM noncore WHERE UserID = #{UserID}")
    int deleteNonCoreByUserID(@Param("UserID") int UserID);

    @Delete("DELETE FROM noncore WHERE NonCoreID = #{NonCoreID}")
    int deleteNonCoreByNonCoreID(@Param("NonCoreID") int NonCoreID);


}
