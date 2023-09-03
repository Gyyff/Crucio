package com.heiqi.chat.mapper;


import com.heiqi.chat.entity.Represent;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface RepresentMapper {
    @Select("SELECT * FROM represent WHERE UserId = #{UserId}")
    Represent getRepresentByUserId(@Param("UserId") int UserId);

    @Insert("INSERT INTO represent(UserId,Description,Seek,LifeWay,Idol) VALUES(#{UserId}, #{Description}, #{Seek}, #{LifeWay}, #{Idol})")
    @Options(useGeneratedKeys = true, keyProperty = "UserId")
    int insertRepresent(Represent represent);

    @Delete("DELETE FROM represent WHERE UserId = #{UserId}")
    int deleteRepresent(@Param("UserId") int UserId);

    @Update("UPDATE represent SET Description = #{Description} WHERE UserId = #{UserId}")
    int updateDescription(@Param("UserId") int UserId, @Param("Description") String Description);

    @Update("UPDATE represent SET Seek = #{Seek} WHERE UserId = #{UserId}")
    int updateSeek(@Param("UserId") int UserId, @Param("Seek") String Seek);

    @Update("UPDATE represent SET LifeWay = #{LifeWay} WHERE UserId = #{UserId}")
    int updateLifeWay(@Param("UserId") int UserId, @Param("LifeWay") String LifeWay);

    @Update("UPDATE represent SET Idol = #{Idol} WHERE UserId = #{UserId}")
    int updateIdol(@Param("UserId") int UserId, @Param("Idol") String Idol);




}
