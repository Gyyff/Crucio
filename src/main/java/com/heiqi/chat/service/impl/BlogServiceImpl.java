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

    @Override
    public Blog updateContent2(int UserID, String Content2) {
        blogMapper.updateContent2(UserID,Content2);
        return blogMapper.getBlogByUserID(UserID);
    }

    @Override
    public Blog updateContent3(int UserID, String Content3) {
        blogMapper.updateContent3(UserID,Content3);
        return blogMapper.getBlogByUserID(UserID);
    }

    @Override
    public Blog updateContent4(int UserID, String Content4) {
        blogMapper.updateContent4(UserID,Content4);
        return blogMapper.getBlogByUserID(UserID);
    }

    @Override
    public Blog updateContent5(int UserID, String Content5) {
        blogMapper.updateContent5(UserID,Content5);
        return blogMapper.getBlogByUserID(UserID);
    }

    @Override
    public Blog updateContent6(int UserID, String Content6) {
        blogMapper.updateContent6(UserID,Content6);
        return blogMapper.getBlogByUserID(UserID);
    }

    @Override
    public Blog updateContent7(int UserID, String Content7) {
        blogMapper.updateContent7(UserID,Content7);
        return blogMapper.getBlogByUserID(UserID);
    }

    @Override
    public Blog updateContent8(int UserID, String Content8) {
        blogMapper.updateContent8(UserID,Content8);
        return blogMapper.getBlogByUserID(UserID);
    }

    @Override
    public Blog updateContent9(int UserID, String Content9) {
        blogMapper.updateContent9(UserID,Content9);
        return blogMapper.getBlogByUserID(UserID);
    }

    @Override
    public Blog updateContent10(int UserID, String Content10) {
        blogMapper.updateContent10(UserID,Content10);
        return blogMapper.getBlogByUserID(UserID);
    }

    @Override
    public Blog updatePhoto1(int UserID, String Photo1) {
        blogMapper.updatePhoto1(UserID,Photo1);
        Blog blog= blogMapper.getBlogByUserID(UserID);
        return blog;
    }

    @Override
    public Blog updatePhoto2(int UserID, String Photo2) {
        blogMapper.updatePhoto2(UserID,Photo2);
        Blog blog= blogMapper.getBlogByUserID(UserID);
        return blog;
    }

    @Override
    public Blog updatePhoto3(int UserID, String Photo3) {
        blogMapper.updatePhoto3(UserID,Photo3);
        Blog blog= blogMapper.getBlogByUserID(UserID);
        return blog;
    }

    @Override
    public Blog updatePhoto4(int UserID, String Photo4) {
        blogMapper.updatePhoto4(UserID,Photo4);
        Blog blog= blogMapper.getBlogByUserID(UserID);
        return blog;
    }

    @Override
    public Blog updatePhoto5(int UserID, String Photo5) {
        blogMapper.updatePhoto5(UserID,Photo5);
        Blog blog= blogMapper.getBlogByUserID(UserID);
        return blog;
    }

    @Override
    public Blog updatePhoto6(int UserID, String Photo6) {
        blogMapper.updatePhoto6(UserID,Photo6);
        Blog blog= blogMapper.getBlogByUserID(UserID);
        return blog;
    }


}
