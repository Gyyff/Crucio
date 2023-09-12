package com.heiqi.chat.service;


import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;


public interface UserService {
    User getUserById(int UserId);

    User getUserByName(String UserName);

    User getUserByAge(int Age);

    User getUserByAddress(String Address);

    User getUserByPhone(String Phone);

    User getUserMatch(int UserId);

    //   public List<Metrics> getUserMatch(int UserId);
    void insertUser(User user) throws Exception;

    void deleteUser(int UserId);

    void updateUserName(int UserId, String UserName);

    void updateUserAge(int UserId, int Age);


    void updateUserIdentity(int UserId, String Identity);

    void updateUserEducation(int UserId, int Education);

    void updateUserPhoto(int UserId, String Photo);

    void updateUserGender(int UserId, int Gender);



    void updateUserHeight(int UserId, int Height);


    void updateUserIsAuthed(@Param("UserId") int UserId, @Param("IsAuthed") int IsAuthed);

    void updateUserIsLogged(@Param("UserId") int UserId, @Param("IsLogged") int IsLogged);

    void updateUserMatchStatus(@Param("UserId") int UserId, @Param("MatchStatus") int MatchStatus);

    void updateUserIsTested(@Param("UserId") int UserId, @Param("IsTested") int IsTested);

    Result userLogon(@Param("Phone") String Phone, @Param("Tempt") String Tempt);

    Result sendSMSofLogon(@Param("Phone") String Phone) throws Exception;

    void userQuit(@Param("UserId") int UserId);

    int updateUserBirthDay(@Param("UserId") int UserId, @Param("BirthDay") String BirthDay);


    int updateUserWeight(@Param("UserId") int UserId, @Param("Weight") int Weight);


    int updateUserSchool(@Param("UserId") int UserId, @Param("School") String School);


    int updateUserHomeTownA(@Param("UserId") int UserId, @Param("HomeTownA") String HomeTownA);


    int updateUserHomeTownB(@Param("UserId") int UserId, @Param("HomeTownB") String HomeTownB);


    int updateUserAddressA(@Param("UserId") int UserId, @Param("AddressA") String AddressA);


    int updateUserAddressB(@Param("UserId") int UserId, @Param("AddressB") String AddressB);


}
