package com.heiqi.chat.controller;

import com.heiqi.chat.common.Result;
import com.heiqi.chat.service.TLSSigAPIv2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName
 * @Author
 * @Date 2023年12月04日 11:16
 * @Description
 */
@RestController
@RequestMapping("/tencent")
public class TencentController {

  @Autowired
  private TLSSigAPIv2Service tlsSigAPIv2Service;


  @RequestMapping("/genUserSig")
  public Result getTlsSign(@RequestParam("userid") String userid,@RequestParam("expire") long expire){
    String userSign = tlsSigAPIv2Service.genUserSig(userid,expire);
    return Result.success(userSign);
  }
}
