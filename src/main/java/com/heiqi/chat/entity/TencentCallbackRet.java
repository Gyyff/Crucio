package com.heiqi.chat.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName @Author zhouliyi @Date 2023年12月07日 14:32 @Description
 */
@Data
public class TencentCallbackRet {

  @JsonProperty("ActionStatus")
  private String actionStatus;

  @JsonProperty("ErrorInfo")
  private String errorInfo;

  @JsonProperty("ErrorCode")
  private Integer errorCode;


  public static TencentCallbackRet success(){
    TencentCallbackRet ret = new TencentCallbackRet();
    ret.setActionStatus("OK");
    ret.setErrorInfo("");
    ret.setErrorCode(0);
    return ret;
  }
}
