package com.heiqi.chat.controller;

import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.BaseUser;
import com.heiqi.chat.entity.FeedBack;
import com.heiqi.chat.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/getFeedbackByFeedbackID/{FeedbackID}")
    public FeedBack getFeedbackByFeedbackID(@PathVariable("FeedbackID") int FeedbackID) {
        return feedbackService.getFeedbackByFeedbackID(FeedbackID);
    }

    //查看该用户的反馈
    @GetMapping("/getFeedbackByUserID/{UserID}")
    public Result getFeedbackByUserID(@PathVariable("UserID") int UserID) {
        return Result.success(feedbackService.getFeedbackByUserID(UserID));
    }

    // 这里写更多的 getter 函数...


    //发送反馈
    @PostMapping("/insertFeedBack")
    public Result insertFeedBack(@RequestBody FeedBack feedBack, BaseUser baseUser) {
        feedbackService.insertFeedBack(feedBack);
        List<FeedBack> feedBacks;
        feedBacks=feedbackService.getFeedbackByUserID(feedBack.getUserId());
       return Result.success(feedBacks);
    }
    //删除
    @DeleteMapping("deleteFeedBack/{FeedbackID}")
    public Result deleteFeedBack(@PathVariable("FeedbackID") int FeedbackID, BaseUser baseUser) {
       return Result.success(feedbackService.deleteFeedBack(FeedbackID));
    }

    // 这里写更多的 setter 函数...

}
