package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName
 * @Author zhouliyi
 * @Date 2023年12月05日 16:36
 * @Description
 */
@Getter
@Setter
public class UserDevice {

 /**
  * 主键id
  */
 private Integer id;


 /**
  * 用户id
  */
  private Integer userId;

 /**
  * 设备id
  */
 private String deviceId;

 /**
  * 0-安卓 1-ios
  */
 private Integer clientType;
}
