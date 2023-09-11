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
    public Blog insertBlog(Blog blog) {
        Blog blogByUserID = blogMapper.getBlogByUserID(blog.getUserID());
        if (blogByUserID==null){
            blogMapper.insertBlog(blog);
        }
        return blogMapper.getBlogByUserID(blog.getUserID());
    }

    @Override
    public int deleteBlogByUserID(int UserID) {
        return blogMapper.deleteBlogByUserID(UserID);
    }

    @Override
    public Blog updateContentIntroductionByUserID(int UserID, String ContentIntroduction) {
        blogMapper.updateContentIntroductionByUserID(UserID,ContentIntroduction);
        return blogMapper.getBlogByUserID(UserID);
    }

    @Override
    public Blog updateContentDreamByUserID(int UserID, String ContentDream) {
        blogMapper.updateContentDreamByUserID(UserID,ContentDream);
        return blogMapper.getBlogByUserID(UserID);
    }


}
