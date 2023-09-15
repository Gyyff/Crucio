package com.heiqi.chat.service;

import com.heiqi.chat.entity.FeedBack;
import org.springframework.stereotype.Service;

@Service
public interface FeedbackService {
    FeedBack getFeedbackByFeedbackID(int FeedbackID);

    FeedBack getFeedbackByUserID(int UserID);

    int insertFeedBack(FeedBack feedBack);

    int deleteFeedBack(int FeedbackID);

    int updateFeedBackContent(int UserId,String Content);
}
