package com.heiqi.chat.service;

import com.heiqi.chat.entity.FeedBack;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedbackService {
    FeedBack getFeedbackByFeedbackID(int FeedbackID);

    List<FeedBack> getFeedbackByUserID(int UserID);

    int insertFeedBack(FeedBack feedBack);

    int deleteFeedBack(int FeedbackID);

}
