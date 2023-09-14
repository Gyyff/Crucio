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

    @Insert("INSERT INTO `match`(MatchID, UserID1, UserID2,RelationshipUser1,RelationshipUser2) VALUES(#{MatchID}, #{UserID1}, #{UserID2},#{RelationshipUser1},#{RelationshipUser2})")
    @Options(useGeneratedKeys = true, keyProperty = "MatchID")
    int insertMatch(Match match);

    @Delete("DELETE FROM `match` WHERE MatchID = #{MatchID}")
    int deleteMatchByMatchID(@Param("MatchID") int MatchID);

    @Delete("DELETE FROM `match` WHERE UserID1 = #{UserID1}")
    int deleteMatchByUserID1(@Param("UserID1") int UserID1);

    @Delete("DELETE FROM `match` WHERE UserID2 = #{UserID2}")
    int deleteMatchByUserID2(@Param("UserID2") int UserID2);

    @Update("UPDATE `match` SET RelationshipUser1 = #{RelationshipUser1} WHERE UserID1 = #{UserID1}")
    int updateRelationshipUser1(@Param("UserID1") int UserID1, @Param("RelationshipUser1") int RelationshipUser1);

    @Update("UPDATE `match` SET RelationshipUser2 = #{RelationshipUser2} WHERE UserID2 = #{UserID2}")
    int updateRelationshipUser2(@Param("UserID2") int UserID2, @Param("RelationshipUser2") int RelationshipUser2);
}
