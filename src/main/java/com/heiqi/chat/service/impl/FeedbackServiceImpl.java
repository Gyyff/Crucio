package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.FeedBack;
import com.heiqi.chat.mapper.FeedbackMapper;
import com.heiqi.chat.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackMapper feedbackMapper;

    @Autowired
    public FeedbackServiceImpl(FeedbackMapper feedbackMapper) {
        this.feedbackMapper = feedbackMapper;
    }
    @Override
    public FeedBack getFeedbackByFeedbackID(int FeedbackID) {
        return feedbackMapper.getFeedbackByFeedbackID(FeedbackID);
    }

    @Override
    public FeedBack getFeedbackByUserID(int UserID) {
        return feedbackMapper.getFeedbackByUserID(UserID);
    }

    @Override
    public int insertFeedBack(FeedBack feedBack) {
        return feedbackMapper.insertFeedBack(feedBack);
    }

    @Override
    public int deleteFeedBack(int FeedbackID) {
        return feedbackMapper.deleteFeedBack(FeedbackID);
    }

    @Override
    public int updateFeedBackContent(int FeedbackID,String Content) {
        return feedbackMapper.updateFeedBackContent(FeedbackID,Content);
    }
}
