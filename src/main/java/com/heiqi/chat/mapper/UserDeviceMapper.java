package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.User;
import com.heiqi.chat.entity.UserDevice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @ClassName
 * @Author zhouliyi
 * @Date 2023年12月05日 16:42
 * @Description
 */
@Mapper
public interface UserDeviceMapper {


  @Insert("INSERT INTO user_device (id,userId,deviceId) VALUES (#{id},#{userId},#{deviceId})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  int insertUserDevice(UserDevice userDevice);

  @Update("UPDATE user_device set deviceId=#{deviceId} where userId=#{userId}}")
  int updateUserDevice(UserDevice userDevice);


  @Select("select 1 from user_device from userId=#{userId}")
  int selectUserDevice(int userId);
}
