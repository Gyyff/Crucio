package com.heiqi.chat.service;

import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.Blog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
public interface BlogService {
    Blog findByBlogID(int BlogID);

    Blog findByUserID(int UserID);

    Blog insertBlog(Blog blog);

    int deleteBlogByUserID(int UserID);

    Blog updateContentIntroductionByUserID(int UserID, String ContentIntroduction);

    Blog updateContentDreamByUserID(int UserID, String ContentDream);


    Blog updateContent1(@Param("UserID") int UserID, @Param("Content1") String Content1);

    Blog updateContent2(@Param("UserID") int UserID, @Param("Content2") String Content2);


    Blog updateContent3(@Param("UserID") int UserID, @Param("Content3") String Content3);


    Blog updateContent4(@Param("UserID") int UserID, @Param("Content4") String Content4);


    Blog updateContent5(@Param("UserID") int UserID, @Param("Content5") String Content5);


    Blog updateContent6(@Param("UserID") int UserID, @Param("Content6") String Content6);


    Blog updateContent7(@Param("UserID") int UserID, @Param("Content7") String Content7);


    Blog updateContent8(@Param("UserID") int UserID, @Param("Content8") String Content8);


    Blog updateContent9(@Param("UserID") int UserID, @Param("Content9") String Content9);


    Blog updateContent10(@Param("UserID") int UserID, @Param("Content10") String Content10);


    Blog updatePhoto1(@Param("UserID") int UserID, @Param("Photo1") String Photo1);


    Blog updatePhoto2(@Param("UserID") int UserID, @Param("Photo2") String Photo2);


    Blog updatePhoto3(@Param("UserID") int UserID, @Param("Photo3") String Photo3);


    Blog updatePhoto4(@Param("UserID") int UserID, @Param("Photo4") String Photo4);


    Blog updatePhoto5(@Param("UserID") int UserID, @Param("Photo5") String Photo5);


    Blog updatePhoto6(@Param("UserID") int UserID, @Param("Photo6") String Photo6);


    Result deletePhoto1ByUserID(@Param("UserID") int UserID);


    Result deletePhoto2ByUserID(@Param("UserID") int UserID);


    Result deletePhoto3ByUserID(@Param("UserID") int UserID);


    Result deletePhoto4ByUserID(@Param("UserID") int UserID);


    Result deletePhoto5ByUserID(@Param("UserID") int UserID);

    Result deletePhoto6ByUserID(@Param("UserID") int UserID);

    Result deleteContentIntroductionByUserID(int UserID);

    Result deleteContentDreamByUserID(int UserID);


    Result deleteContent1(int UserID);

    Result deleteContent2(int UserID);


    Result deleteContent3(int UserID);


    Result deleteContent4(int UserID);


    Result deleteContent5(int UserID);


    Result deleteContent6(int UserID);


    Result deleteContent7(int UserID);


    Result deleteContent8(int UserID);


    Result deleteContent9(int UserID);


    Result deleteContent10(int UserID);


}
