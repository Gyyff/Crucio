package com.heiqi.chat.service;

import com.heiqi.chat.entity.NonCore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NonCoreService {
    NonCore getNonCoreByNonCoreID(int NonCoreID);

    NonCore getNonCoreByUserID(int UserID);

    int insertNonCore(NonCore nonCore);

    int deleteNonCoreByUserID(int UserID);

    int deleteNonCoreByNonCoreID(int NonCoreID);

 //   List<NonCore> getSoulFriend(int UserID);
}
