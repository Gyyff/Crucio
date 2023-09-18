package com.heiqi.chat.controller;

import com.heiqi.chat.Utils.UploadUtil;
import com.heiqi.chat.common.Result;
import com.heiqi.chat.service.BlogService;
import com.heiqi.chat.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/user/images")
public class ImagesController {
    private final ImagesService imagesService;


    private final BlogService blogService;
    @Autowired
    public ImagesController(ImagesService imagesService, BlogService blogService) {
        this.imagesService = imagesService;
        this.blogService = blogService;
    }

    @PostMapping("/upload/{UserId}")
    public Result upload(@PathVariable("UserId") int UserId, @RequestBody MultipartFile file) throws IOException {
            String path = UploadUtil.uploadImage(file);
        int blogID = blogService.findByUserID(UserId).getBlogID();
        System.out.println("blogID = " + blogID);
        imagesService.insertImages(blogID,path);
        return Result.success(path);
    }
}