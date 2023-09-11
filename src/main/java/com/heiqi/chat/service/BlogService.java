package com.heiqi.chat.service;

import com.heiqi.chat.entity.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface BlogService {
    Blog findByBlogID(int BlogID);

    Blog findByUserID(int UserID);

    Blog insertBlog(Blog blog);

    int deleteBlogByUserID(int UserID);

    Blog updateContentIntroductionByUserID(int UserID,  String ContentIntroduction);

    Blog updateContentDreamByUserID(int UserID,  String ContentDream);





}
