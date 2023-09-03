package com.heiqi.chat.service;

import com.heiqi.chat.entity.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface BlogService {
    Blog findByBlogID(int BlogID);

    Blog findByUserID(int UserID);

    int insertBlog(Blog blog);

    int deleteBlogByUserID(int UserID);

    int deleteBlogByBlogID(int BlogID);

    int updateBlogByUserID(int UserID, String Content);

    int updateBlogByBlogID(int BlogID, String Content);

}
