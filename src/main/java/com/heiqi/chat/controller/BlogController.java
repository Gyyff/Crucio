package com.heiqi.chat.controller;

import com.heiqi.chat.common.Result;
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
    public Result insertBlog(@RequestBody Blog blog) {
        Blog blogS = blogService.insertBlog(blog);
        return Result.success(blogS);
    }

    @DeleteMapping("/deleteBlogByUserID/{UserID}")
    public void deleteBlogByUserID(@PathVariable("UserID") int UserID) {
        blogService.deleteBlogByUserID(UserID);
    }


    @PutMapping("/updateContentIntroductionByUserID/{UserID}")
    public Result updateContentIntroductionByUserID(@PathVariable("UserID") int UserID, @RequestBody String Content) {
        if (blogService.findByUserID(UserID)!=null) {
            return Result.success(blogService.updateContentIntroductionByUserID(UserID, Content));
        }else {
            return Result.error("没找到该blog");
        }
    }

    @PutMapping("/updateContentDreamByUserID/{UserID}")
    public Result updateContentDreamByUserID(@PathVariable("UserID") int UserID, @RequestBody String Content) {
        if (blogService.findByUserID(UserID)!=null) {
            return Result.success(blogService.updateContentDreamByUserID(UserID, Content));
        }else {
            return Result.error("没找到该blog");
        }
    }

    // 这里写更多的 setter 函数...
}
