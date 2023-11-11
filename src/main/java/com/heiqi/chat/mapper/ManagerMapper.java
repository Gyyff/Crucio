package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.Images;
import com.heiqi.chat.entity.Manager;
import org.apache.ibatis.annotations.Select;

public interface ManagerMapper {
    @Select("SELECT * FROM manager WHERE managerName = #{managerName} AND managerPassWord = #{managerPassWord}")
    Manager getManager(String managerName,String managerPassWord);
}
