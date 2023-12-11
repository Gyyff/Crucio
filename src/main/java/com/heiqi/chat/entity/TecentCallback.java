package com.heiqi.chat.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

/**
 * @ClassName
 * @Author bonies
 * @Date 2023年12月07日 14:18
 * @Description
 */
@Data
public class TecentCallback {

    @JsonProperty("CallbackCommand")
   private String callbackCommand;

   @JsonProperty("From_Account")
   private String fromAccount;

   @JsonProperty("To_Account")
   private String To_Account;


   @JsonProperty("MsgSeq")
   private Long MsgSeq;

   @JsonProperty("MsgRandom")
   private Long MsgRandom;

  @JsonProperty("MsgKey")
   private String MsgKey;

  @JsonProperty("OnlineOnlyFlag")
   private Integer OnlineOnlyFlag;

  @JsonProperty("MsgBody")
   private List MsgBody;

  @JsonProperty("CloudCustomData")
   private String CloudCustomData;

   @JsonProperty("EventTime")
   private Long eventTime;

}
