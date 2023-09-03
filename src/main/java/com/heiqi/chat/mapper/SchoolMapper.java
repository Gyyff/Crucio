package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface SchoolMapper {
    @Select("SELECT * FROM school WHERE id = #{id}")
    School getSchoolById(int id);

    @Select("SELECT * FROM school WHERE name = #{name}")
    School getSchoolByName(String name);
}
