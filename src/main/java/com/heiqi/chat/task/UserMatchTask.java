package com.heiqi.chat.task;

import cn.hutool.core.collection.CollUtil;
import com.heiqi.chat.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class UserMatchTask {

    private final UserService userService;

//    @Autowired
//    public UserMatchTask(UserService userService) {
//        this.userService = userService;
//    }
    // 0 0 0/8 * * *
    // cron 秒 分 时 日 月 年
    @Scheduled(cron = "0 0 0/8 * * *")
    public void UserMatch() {
        List<Integer> userIds = userService.getUserIds();
        if (CollUtil.isEmpty(userIds)) {
            return;
        }
        log.info("开始执行用户匹配定时任务，用户数量:{}", userIds.size());
        userIds.forEach(item -> {
            try {
                userService.getUserMatch(item);
            } catch (Exception e) {
                log.error("用户匹配定时任务执行失败,用户id:{}", item, e);
            }
        });

    }
}
