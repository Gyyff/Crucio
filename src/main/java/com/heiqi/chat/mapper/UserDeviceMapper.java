package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.User;
import com.heiqi.chat.entity.UserDevice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
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


  @Insert("INSERT INTO userdevice (id,UserId,DeviceId) VALUES (#{id},#{userId},#{deviceId})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  int insertUserDevice(UserDevice userDevice);

  @Update("UPDATE userdevice set DeviceId=#{deviceId} where UserId=#{userId}")
  int updateUserDevice(UserDevice userDevice);


  @Select("select count(1) from userdevice where UserId=#{userId}")
  int selectUserDevice(@Param("userId") Integer userId);

}
