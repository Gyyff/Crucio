package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.Images;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface ImagesMapper {

    @Insert("INSERT INTO images(BlogID, ImagePath) VALUES (#{BlogID}, #{ImagePath})")
    int insertImages(int BlogID,String ImagePath);

    @Select("SELECT * FROM images WHERE BlogID = #{BlogID}")
    List<Images> getImagesByBlogID(int BlogID);

    @Select("SELECT * FROM images WHERE ImagePath = #{ImagePath}")
    Images getImagesByImagePath(String ImagePath);


}