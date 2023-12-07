package com.heiqi.chat.controller;

import com.alibaba.fastjson.JSONObject;
import com.heiqi.chat.entity.TecentCallback;
import com.heiqi.chat.entity.TencentCallbackRet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName
 * @Author zhouliyi
 * @Date 2023年12月07日 11:08
 * @Description
 */
@RestController
@RequestMapping("/api/jpush")
@Slf4j
public class JpushRetController {

 @PostMapping("/im/notify")
 public TencentCallbackRet notifyJpush(@RequestBody TecentCallback tecentCallback){

  log.info(JSONObject.toJSONString(tecentCallback));
  return TencentCallbackRet.success();
 }
}
