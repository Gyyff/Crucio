package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.Values;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface ValuesMapper {
    @Select("SELECT * FROM uservalues WHERE UserId = #{UserId}")
    Values getValuesUserByUserId(@Param("UserId") int UserId);

    @Select("SELECT * FROM uservalues WHERE ValuesId = #{ValuesId}")
    Values getValuesUserByValuesId(@Param("ValuesId") int ValuesId);

    @Insert("INSERT INTO uservalues(ValuesId, UserId, `A`,`B`,`C`,`D`,`E`,`F`,`G`,`H`,`I`,`J`) VALUES(#{ValuesId}, #{UserId}, #{A},#{B},#{C},#{D},#{E},#{F},#{G},#{H},#{I},#{J})")
    @Options(useGeneratedKeys = true, keyProperty = "ValuesId")
    int insertsValues(Values values);

    @Delete("DELETE FROM uservalues WHERE UserId = #{UserId}")
    int deleteValuesByUserId(@Param("UserId") int UserId);

    @Delete("DELETE FROM uservalues WHERE ValuesId = #{ValuesId}")
    int deleteValuesByValuesId(@Param("ValuesId") int ValuesId);

}
