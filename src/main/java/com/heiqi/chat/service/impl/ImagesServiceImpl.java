package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.Images;
import com.heiqi.chat.mapper.ImagesMapper;
import com.heiqi.chat.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagesServiceImpl implements ImagesService {
    private final ImagesMapper imagesMapper;


    @Autowired
    public ImagesServiceImpl(ImagesMapper imagesMapper) {
        this.imagesMapper = imagesMapper;
    }

    @Override
    public int insertImages(int blogID, String imagePath) {
        return imagesMapper.insertImages(blogID,imagePath);
    }

    @Override
    public List<Images> getImagesByBlogID(int blogID) {
        return imagesMapper.getImagesByBlogID(blogID);
    }

    @Override
    public Images getImagesByImagePath(String ImagePath) {
        return imagesMapper.getImagesByImagePath(ImagePath);
    }
}
