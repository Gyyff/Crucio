package com.heiqi.chat.service;

import com.heiqi.chat.entity.Represent;
import org.apache.ibatis.annotations.Param;

public interface RepresentService {
    Represent getRepresentByUserId(int UserId);
    int insertRepresent(Represent represent);
    int deleteRepresent(int UserId);

    int updateDescription(@Param("UserId") int UserId, @Param("Description") String Description);

    int updateSeek(@Param("UserId") int UserId, @Param("Seek") String Seek);

    int updateLifeWay(@Param("UserId") int UserId, @Param("LifeWay") String LifeWay);

    int updateIdol(@Param("UserId") int UserId, @Param("Idol") String Idol);
}
