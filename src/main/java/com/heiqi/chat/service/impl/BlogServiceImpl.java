package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.Blog;
import com.heiqi.chat.mapper.BlogMapper;
import com.heiqi.chat.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    private final BlogMapper blogMapper;

    @Autowired
    public BlogServiceImpl(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }
    @Override
    public Blog findByBlogID(int BlogID) {
        return blogMapper.getBlogByBlogID(BlogID);
    }

    @Override
    public Blog findByUserID(int UserID) {
        return blogMapper.getBlogByUserID(UserID);
    }

    @Override
    public int insertBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @Override
    public int deleteBlogByUserID(int UserID) {
        return blogMapper.deleteBlogByUserID(UserID);
    }

    @Override
    public int deleteBlogByBlogID(int BlogID) {
        return blogMapper.deleteBlogByBlogID(BlogID);
    }

    @Override
    public int updateBlogByUserID(int UserID, String Content) {
        return blogMapper.updateBlogByUserID(UserID,Content);
    }

    @Override
    public int updateBlogByBlogID(int BlogID, String Content) {
        return blogMapper.updateBlogByBlogID(BlogID,Content);
    }
}
