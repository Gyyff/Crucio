package com.heiqi.chat.mapper;


import com.heiqi.chat.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    @Select("SELECT * FROM user WHERE UserId = #{UserId}")
    User getUserById(@Param("UserId") int UserId);

    @Select("SELECT * FROM user WHERE UserName = #{UserName}")
    User getUserByName(@Param("UserName") String UserName);

    @Select("SELECT * FROM user WHERE Age = #{Age}")
    User getUserByAge(@Param("Age") int Age);

    @Select("SELECT * FROM user WHERE Address = #{Address}")
    User getUserByAddress(@Param("Address") String Address);

    @Select("SELECT * FROM user WHERE Phone = #{Phone}")
    User getUserByPhone(@Param("Phone") String Phone);


    @Select("SElECT * FROM user WHERE age BETWEEN #{ageMin} AND #{ageMax} ")
    List<User> getUsersByAgeBetween(int ageMax,int ageMin);


    @Insert("INSERT INTO user(UserId, UserName, Phone,PassWord, Photo, Identity, Gender, Age,HomeTown, Address, Height, Education,Beauty,IsPreference,IsTested,IsAuthed,IsLogged,MatchStatus) VALUES(#{UserId}, #{UserName}, #{Phone},#{PassWord}, #{Photo}, #{Identity}, #{Gender}, #{Age}, #{HomeTown},#{Address}, #{Height}, #{Education},#{Beauty},#{IsPreference},#{IsTested},#{IsAuthed},#{IsLogged},#{MatchStatus})")
    @Options(useGeneratedKeys = true, keyProperty = "UserId")
    int insertUser(User user);

    @Delete("DELETE FROM user WHERE UserId = #{UserId}")
    int deleteUser(@Param("UserId") int UserId);

    @Update("UPDATE user SET UserName = #{UserName} WHERE UserId = #{UserId}")
    int updateUserName(@Param("UserId") int UserId, @Param("UserName") String UserName);

    @Update("UPDATE user SET Age = #{Age} WHERE UserId = #{UserId}")
    int updateUserAge(@Param("UserId") int UserId, @Param("Age") int Age);

    @Update("UPDATE user SET Address = #{Address} WHERE UserId = #{UserId}")
    int updateUserAddress(@Param("UserId") int UserId, @Param("Address") String Address);

    @Update("UPDATE user SET Identity = #{Identity} WHERE UserId = #{UserId}")
    int updateUserIdentity(@Param("UserId") int UserId, @Param("Identity") String Identity);

    @Update("UPDATE user SET education = #{Education} WHERE userId = #{UserId}")
    int updateUserEducation(@Param("UserId") int UserId, @Param("Education") int Education);

    @Update("UPDATE user SET Photo = #{Photo} WHERE UserId = #{UserId}")
    int updateUserPhoto(@Param("UserId") int UserId, @Param("Photo") String Photo);

    @Update("UPDATE user SET IsAuthed = #{IsAuthed} WHERE UserId = #{UserId}")
    int updateUserIsAuthed(@Param("UserId") int UserId, @Param("IsAuthed") int IsAuthed);

    @Update("UPDATE user SET IsLogged = #{IsLogged} WHERE UserId = #{UserId}")
    int updateUserIsLogged(@Param("UserId") int UserId, @Param("IsLogged") int IsLogged);

    @Update("UPDATE user SET MatchStatus = #{MatchStatus} WHERE UserId = #{UserId}")
    int updateUserMatchStatus(@Param("UserId") int UserId, @Param("MatchStatus") int MatchStatus);

    @Update("UPDATE user SET IsTested = #{IsTested} WHERE UserId = #{UserId}")
    int updateUserIsTested(@Param("UserId") int UserId, @Param("IsTested") int IsTested);

    @Update("UPDATE user SET Gender = #{Gender} WHERE UserId = #{UserId}")
    int updateUserGender(@Param("UserId") int UserId, @Param("Gender") int Gender);


    @Update("UPDATE user SET Height = #{Height} WHERE UserId = #{UserId}")
    int updateUserHeight(@Param("UserId") int UserId, @Param("Height") int Height);



}
