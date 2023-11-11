package com.heiqi.chat.service;


import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.User;
import com.heiqi.chat.entity.UserPreferenceChoice;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;


public interface UserService {
    User getUserById(int UserId);

    User getUserByName(String UserName);

    User getUserByAge(int Age);

    User getUserByAddress(String Address);

    User getUserByPhone(String Phone);

    User getUserByEmail(String email);

//    Result getUserMatch(int UserId) throws Exception;

    Result getUserMatch0(int UserId);

    Result getConformUsers(int UserId);



    List<Integer> getUserIds();

    List<User>  getUsers();

    List<Integer> getAllUsersIds();

    List<User> getUserTable();


    void testMatch();

    //   public List<Metrics> getUserMatch(int UserId);
    void insertUser(User user) throws Exception;

    void deleteUser(int UserId);

    void updateUserName(int UserId, String UserName);

    void updateUserAge(int UserId, int Age);

   Result sendMessageToUserOther(String messages,int UserId) throws Exception;



    void updateUserIdentity(int UserId, String Identity);

    void updateUserEducation(int UserId, int Education);

    void updateUserPhoto(int UserId, String Photo);

    void updateUserGender(int UserId, int Gender);

    void updateUserWeChat(int UserId, String WeChat);

    void updateUserMatchChoiceAuto(int UserId);

    void updateUserMatchChoiceStop(int UserId);



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

    Result cutLove(int UserId);


    Result confirmShip(int UserId);

    Result determineToMatchPages(int UserId);

}
