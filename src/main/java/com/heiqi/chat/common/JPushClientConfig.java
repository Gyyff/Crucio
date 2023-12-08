package com.heiqi.chat.common;

import cn.jiguang.common.ClientConfig;
import com.heiqi.chat.api.jpush.JPushClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName
 * @Author zhouliyi
 * @Date 2023年12月06日 19:23
 * @Description
 */
@Configuration
@Slf4j
public class JPushClientConfig {

  @Value("${jpush.appkey}")
  private String APP_KEY;

  @Value("${jpush.appsecret}")
  private String MASTER_SECRET;

  @Bean("jpushClient")
  public JPushClient jpushClient() {
    ClientConfig clientConfig = ClientConfig.getInstance();
    JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
    return jpushClient;
  }
}
