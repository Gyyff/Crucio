package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.Images;
import com.heiqi.chat.entity.UserPhoto;
import com.heiqi.chat.mapper.ImagesMapper;
import com.heiqi.chat.mapper.UserPhotoMapper;
import com.heiqi.chat.service.UserPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPhotoServiceImpl implements UserPhotoService {
    private final UserPhotoMapper userPhotoMapper;
    private final ImagesMapper imagesMapper;

    @Autowired
    public UserPhotoServiceImpl(UserPhotoMapper userPhotoMapper,ImagesMapper imagesMapper) {
        this.userPhotoMapper = userPhotoMapper;
        this.imagesMapper = imagesMapper;
    }



    @Override
    public List<Images>getPhotosByUserId(int UserId) {
        UserPhoto userPhoto = userPhotoMapper.getPhotosByUserId(UserId);
        List<Images> images = new ArrayList<>();
        images.add(imagesMapper.getImagesByImagePath(userPhoto.getPhoto1()));
        images.add(imagesMapper.getImagesByImagePath(userPhoto.getPhoto2()));
        images.add(imagesMapper.getImagesByImagePath(userPhoto.getPhoto3()));
        images.add(imagesMapper.getImagesByImagePath(userPhoto.getPhoto4()));
        images.add(imagesMapper.getImagesByImagePath(userPhoto.getPhoto5()));
        images.add(imagesMapper.getImagesByImagePath(userPhoto.getPhoto6()));
        return images;
    }


    @Override
    public void uploadPhoto(UserPhoto userPhoto) {
        userPhotoMapper.uploadPhoto(userPhoto);
    }

    @Override
    public void deletePhotoByUserId(int UserId) {
        userPhotoMapper.deletePhotoByUserId(UserId);
    }

    @Override
    public void updatePhoto1ByUserId(int UserId, String photo1) {
        userPhotoMapper.updatePhoto1ByUserId(UserId,photo1);
    }

    @Override
    public void updatePhoto2ByUserId(int UserId, String photo2) {
        userPhotoMapper.updatePhoto2ByUserId(UserId,photo2);
    }

    @Override
    public void updatePhoto3ByUserId(int UserId, String photo3) {
        userPhotoMapper.updatePhoto3ByUserId(UserId,photo3);
    }

    @Override
    public void updatePhoto4ByUserId(int UserId, String photo4) {
        userPhotoMapper.updatePhoto4ByUserId(UserId,photo4);
    }

    @Override
    public void updatePhoto5ByUserId(int UserId, String photo5) {
        userPhotoMapper.updatePhoto5ByUserId(UserId,photo5);
    }

    @Override
    public void updatePhoto6ByUserId(int UserId, String photo6) {
        userPhotoMapper.updatePhoto6ByUserId(UserId,photo6);
    }




}
