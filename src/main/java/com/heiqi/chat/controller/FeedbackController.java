package com.heiqi.chat.controller;

import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.FeedBack;
import com.heiqi.chat.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getFeedbackByUserID/{UserID}")
    public FeedBack getFeedbackByUserID(@PathVariable("UserID") int UserID) {
        return feedbackService.getFeedbackByUserID(UserID);
    }

    // 这里写更多的 getter 函数...

    @PostMapping("/insertFeedBack")
    public Result insertFeedBack(@RequestBody FeedBack feedBack) {
        feedbackService.insertFeedBack(feedBack);
       return Result.success(feedbackService.getFeedbackByUserID(feedBack.getUserID()));
    }

    @DeleteMapping("deleteFeedBack/{FeedbackID}")
    public void deleteFeedBack(@PathVariable("FeedbackID") int FeedbackID) {
        feedbackService.deleteFeedBack(FeedbackID);
    }

    @PutMapping("/updateFeedBackContent/{FeedbackID}")
    public void updateFeedBackContent(@PathVariable("FeedbackID") int FeedbackID, @RequestBody String Content) {
        feedbackService.updateFeedBackContent(FeedbackID, Content);
    }
    // 这里写更多的 setter 函数...

}
