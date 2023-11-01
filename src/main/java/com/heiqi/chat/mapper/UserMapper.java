package com.heiqi.chat.mapper;


import com.heiqi.chat.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
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

    @Select("SELECT * FROM user WHERE Email = #{Email}")
    User getUserByEmail(@Param("Email") String Email);

    @Select("SElECT * FROM user WHERE age BETWEEN #{ageMin} AND #{ageMax} ")
    List<User> getUsersByAgeBetween(int ageMax, int ageMin);


    @Insert("INSERT INTO user(UserId, UserName,Phone,Email,PassWord,WeChat, Photo, Identity, Gender, Age,BirthDay,Weight,School,HomeTownA,HomeTownB, AddressA,AddressB, Height, Education,Beauty,IsPreference,IsTested,IsAuthed,IsLogged,MatchStatus,MatchChoice) VALUES(#{UserId}, #{UserName}, #{Phone},#{Email},#{WeChat},#{PassWord}, #{Photo}, #{Identity}, #{Gender}, #{Age}, #{BirthDay},#{Weight},#{School},#{HomeTownA},#{HomeTownB},#{AddressA},#{AddressB}, #{Height}, #{Education},#{Beauty},#{IsPreference},#{IsTested},#{IsAuthed},#{IsLogged},#{MatchStatus},#{MatchChoice})")
    @Options(useGeneratedKeys = true, keyProperty = "UserId")
    int insertUser(User user);

    @Delete("DELETE FROM user WHERE UserId = #{UserId}")
    int deleteUser(@Param("UserId") int UserId);

    @Update("UPDATE user SET UserName = #{UserName} WHERE UserId = #{UserId}")
    int updateUserName(@Param("UserId") int UserId, @Param("UserName") String UserName);

    @Update("UPDATE user SET Age = #{Age} WHERE UserId = #{UserId}")
    int updateUserAge(@Param("UserId") int UserId, @Param("Age") int Age);

    @Update("UPDATE user SET WeChat = #{WeChat} WHERE UserId = #{UserId}")
    int updateUserWeChat(@Param("UserId") int UserId, @Param("WeChat") String WeChat);

    @Update("UPDATE user SET MatchChoice = 1 WHERE UserId = #{UserId}")
    int updateUserMatchChoiceAuto(@Param("UserId") int UserId);

    @Update("UPDATE user SET MatchChoice = 0 WHERE UserId = #{UserId}")
    int updateUserMatchChoiceStop(@Param("UserId") int UserId);



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

    @Update("UPDATE user SET IsPreference = #{IsPreference} WHERE UserId = #{UserId}")
    int updateUserIsPreference(@Param("UserId") int UserId, @Param("IsPreference") int IsPreference);

    @Update("UPDATE user SET BirthDay = #{BirthDay} WHERE UserId = #{UserId}")
    int updateUserBirthDay(@Param("UserId") int UserId, @Param("BirthDay") String BirthDay);

    @Update("UPDATE user SET Weight = #{Weight} WHERE UserId = #{UserId}")
    int updateUserWeight(@Param("UserId") int UserId, @Param("Weight") int Weight);

    @Update("UPDATE user SET School = #{School} WHERE UserId = #{UserId}")
    int updateUserSchool(@Param("UserId") int UserId, @Param("School") String School);

    @Update("UPDATE user SET HomeTownA = #{HomeTownA} WHERE UserId = #{UserId}")
    int updateUserHomeTownA(@Param("UserId") int UserId, @Param("HomeTownA") String HomeTownA);

    @Update("UPDATE user SET HomeTownB = #{HomeTownB} WHERE UserId = #{UserId}")
    int updateUserHomeTownB(@Param("UserId") int UserId, @Param("HomeTownB") String HomeTownB);

    @Update("UPDATE user SET AddressA = #{AddressA} WHERE UserId = #{UserId}")
    int updateUserAddressA(@Param("UserId") int UserId, @Param("AddressA") String AddressA);

    @Update("UPDATE user SET AddressB = #{AddressB} WHERE UserId = #{UserId}")
    int updateUserAddressB(@Param("UserId") int UserId, @Param("AddressB") String AddressB);


}
