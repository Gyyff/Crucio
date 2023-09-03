package com.heiqi.chat.service;

import com.heiqi.chat.entity.Images;
import com.heiqi.chat.entity.UserPhoto;

import java.util.List;

public interface UserPhotoService {
    List<Images> getPhotosByUserId(int UserId);
    void uploadPhoto(UserPhoto userPhoto);
    void deletePhotoByUserId(int UserId);;
    void updatePhoto1ByUserId(int UserId,String photo1);
    void updatePhoto2ByUserId(int UserId,String photo2);
    void updatePhoto3ByUserId(int UserId,String photo3);
    void updatePhoto4ByUserId(int UserId,String photo4);
    void updatePhoto5ByUserId(int UserId,String photo5);
    void updatePhoto6ByUserId(int UserId,String photo6);
}
