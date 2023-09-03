package com.heiqi.chat.controller;

import com.heiqi.chat.Utils.UploadUtil;
import com.heiqi.chat.service.BlogService;
import com.heiqi.chat.service.ImagesService;
import com.heiqi.chat.service.UserPhotoService;
import com.heiqi.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/user/images")
public class ImagesController {
    private final ImagesService imagesService;
    private final UserPhotoService userPhotoService;

    private final BlogService blogService;
    @Autowired
    public ImagesController(ImagesService imagesService, UserPhotoService userPhotoService,BlogService blogService) {
        this.imagesService = imagesService;
        this.userPhotoService = userPhotoService;
        this.blogService = blogService;
    }

    @PostMapping("/upload/{UserId}")
    public String upload(@PathVariable("UserId") int UserId, @RequestBody MultipartFile file) throws IOException {
            String path = UploadUtil.uploadImage(file);
        int blogID = blogService.findByUserID(UserId).getBlogID();
        System.out.println("blogID = " + blogID);
        imagesService.insertImages(blogID,path);
            return path;
    }
}