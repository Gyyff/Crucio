package com.heiqi.chat.controller;

import com.heiqi.chat.entity.Blog;
import com.heiqi.chat.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/blog")
public class BlogController {
    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }


    @GetMapping("/getBlogByBlogID/{BlogID}")
    public Blog getBlogByBlogID(@PathVariable("BlogID") int BlogID) {
        return blogService.findByBlogID(BlogID);
    }

    @GetMapping("/getBlogByUserID/{UserID}")
    public Blog getBlogByUserID(@PathVariable("UserID") int UserID) {
        return blogService.findByUserID(UserID);
    }

    // 这里写更多的 getter 函数...
    @PostMapping("/insertBlog")
    public void insertBlog(@RequestBody Blog blog) {
        blogService.insertBlog(blog);
    }

    @DeleteMapping("/deleteBlogByUserID/{UserID}")
    public void deleteBlogByUserID(@PathVariable("UserID") int UserID) {
        blogService.deleteBlogByUserID(UserID);
    }

    @DeleteMapping("/deleteBlogByBlogID/{BlogID}")
    public void deleteBlogByBlogID(@PathVariable("BlogID") int BlogID) {
        blogService.deleteBlogByBlogID(BlogID);
    }

    @PutMapping("/updateBlogByBlogID/{BlogID}")
    public void updateBlogByBlogID(@PathVariable("BlogID") int BlogID, @RequestBody String Content) {
        blogService.updateBlogByBlogID(BlogID, Content);
    }

    @PutMapping("/updateBlogByUserID/{UserID}")
    public void updateBlogByUserID(@PathVariable("UserID") int UserID, @RequestBody String Content) {
        blogService.updateBlogByUserID(UserID, Content);
    }

    // 这里写更多的 setter 函数...
}
