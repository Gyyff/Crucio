package com.heiqi.chat.service;

import com.heiqi.chat.entity.Images;

import java.util.List;

public interface ImagesService {
    int insertImages(int blogID,String imagePath);

    List<Images> getImagesByBlogID(int blogID);

    Images getImagesByImagePath(String ImagePath);
}
