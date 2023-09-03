package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.Match;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface MatchMapper {
    @Select("SELECT * FROM `match` WHERE MatchID = #{MatchID}")
    Match getMatchByMatchID(@Param("MatchID") int MatchID);

    @Select("SELECT * FROM `match` WHERE UserID1 = #{UserID1}")
    Match getMatchByUserID1(@Param("UserID1") int UserID1);

    @Select("SELECT * FROM`match` WHERE UserID2 = #{UserID2}")
    Match getMatchByUserID2(@Param("UserID2") int UserID2);

    @Insert("INSERT INTO `match`(MatchID, UserID1, UserID2,MatchTime) VALUES(#{MatchID}, #{UserID1}, #{UserID2},#{MatchTime})")
    @Options(useGeneratedKeys = true, keyProperty = "MatchID")
    int insertMatch(Match match);

    @Delete("DELETE FROM `match` WHERE MatchID = #{MatchID}")
    int deleteMatchByMatchID(@Param("MatchID") int MatchID);

    @Delete("DELETE FROM `match` WHERE UserID1 = #{UserID1}")
    int deleteMatchByUserID1(@Param("UserID1") int UserID1);

    @Delete("DELETE FROM `match` WHERE UserID2 = #{UserID2}")
    int deleteMatchByUserID2(@Param("UserID2") int UserID2);
}
