package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.Blog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface BlogMapper {
    @Select("SELECT * FROM blog WHERE BlogID = #{BlogID}")
    Blog getBlogByBlogID(@Param("BlogID") int BlogID);

    @Select("SELECT * FROM blog WHERE UserID = #{UserID}")
    Blog getBlogByUserID(@Param("UserID") int UserID);

    @Insert("INSERT INTO blog(BlogID, UserID, ContentIntroduction,ContentDream,PostTime,Content2,Content3,Content4,Content5,Content6,Content7,Content8,Content9,Content10,Photo1,Photo2,Photo3,Photo4,Photo5,Photo6) VALUES(#{BlogID}, #{UserID}, #{ContentIntroduction},#{ContentDream},#{PostTime},#{Content2},#{Content3},#{Content4},#{Content5},#{Content6},#{Content7},#{Content8},#{Content9},#{Content10},#{Photo1},#{Photo2},#{Photo3},#{Photo4},#{Photo5},#{Photo6})")
    @Options(useGeneratedKeys = true, keyProperty = "BlogID")
    int insertBlog(Blog blog);

    @Delete("DELETE FROM blog WHERE UserID = #{UserID}")
    int deleteBlogByUserID(@Param("UserID") int UserID);

    @Update("UPDATE blog SET ContentIntroduction = #{ContentIntroduction} WHERE UserID = #{UserID}")
    int updateContentIntroductionByUserID(@Param("UserID") int UserID, @Param("ContentIntroduction") String ContentIntroduction);


    @Update("UPDATE blog SET ContentDream = #{ContentDream} WHERE UserID = #{UserID}")
    int updateContentDreamByUserID(@Param("UserID") int UserID, @Param("ContentDream") String ContentDream);

    @Update("UPDATE blog SET Content1 = #{Content1} WHERE UserID = #{UserID}")
    int updateContent1(@Param("UserID") int UserID, @Param("Content1") String Content1);

    @Update("UPDATE blog SET Content2 = #{Content2} WHERE UserID = #{UserID}")
    int updateContent2(@Param("UserID") int UserID, @Param("Content2") String Content2);

    @Update("UPDATE blog SET Content3 = #{Content3} WHERE UserID = #{UserID}")
    int updateContent3(@Param("UserID") int UserID, @Param("Content3") String Content3);

    @Update("UPDATE blog SET Content4 = #{Content4} WHERE UserID = #{UserID}")
    int updateContent4(@Param("UserID") int UserID, @Param("Content4") String Content4);

    @Update("UPDATE blog SET Content5 = #{Content5} WHERE UserID = #{UserID}")
    int updateContent5(@Param("UserID") int UserID, @Param("Content5") String Content5);

    @Update("UPDATE blog SET Content6 = #{Content6} WHERE UserID = #{UserID}")
    int updateContent6(@Param("UserID") int UserID, @Param("Content6") String Content6);

    @Update("UPDATE blog SET Content7 = #{Content7} WHERE UserID = #{UserID}")
    int updateContent7(@Param("UserID") int UserID, @Param("Content7") String Content7);

    @Update("UPDATE blog SET Content8 = #{Content8} WHERE UserID = #{UserID}")
    int updateContent8(@Param("UserID") int UserID, @Param("Content8") String Content8);

    @Update("UPDATE blog SET Content9 = #{Content9} WHERE UserID = #{UserID}")
    int updateContent9(@Param("UserID") int UserID, @Param("Content9") String Content9);

    @Update("UPDATE blog SET Content10 = #{Content10} WHERE UserID = #{UserID}")
    int updateContent10(@Param("UserID") int UserID, @Param("Content10") String Content10);

    @Update("UPDATE blog SET Photo1 = #{Photo1} WHERE UserID = #{UserID}")
    int updatePhoto1(@Param("UserID") int UserID, @Param("Photo1") String Photo1);

    @Update("UPDATE blog SET Photo2 = #{Photo2} WHERE UserID = #{UserID}")
    int updatePhoto2(@Param("UserID") int UserID, @Param("Photo2") String Photo2);

    @Update("UPDATE blog SET Photo3 = #{Photo3} WHERE UserID = #{UserID}")
    int updatePhoto3(@Param("UserID") int UserID, @Param("Photo3") String Photo3);

    @Update("UPDATE blog SET Photo4 = #{Photo4} WHERE UserID = #{UserID}")
    int updatePhoto4(@Param("UserID") int UserID, @Param("Photo4") String Photo4);

    @Update("UPDATE blog SET Photo5 = #{Photo5} WHERE UserID = #{UserID}")
    int updatePhoto5(@Param("UserID") int UserID, @Param("Photo5") String Photo5);

    @Update("UPDATE blog SET Photo6 = #{Photo6} WHERE UserID = #{UserID}")
    int updatePhoto6(@Param("UserID") int UserID, @Param("Photo6") String Photo6);


    @Update("UPDATE blog SET Photo1 = null WHERE UserID = #{UserID}")
    int deletePhoto1ByUserID(@Param("UserID") int UserID);

    @Update("UPDATE blog SET Photo2 = null WHERE UserID = #{UserID}")
    int deletePhoto2ByUserID(@Param("UserID") int UserID);

    @Update("UPDATE blog SET Photo3 = null WHERE UserID = #{UserID}")
    int deletePhoto3ByUserID(@Param("UserID") int UserID);

    @Update("UPDATE blog SET Photo4 = null WHERE UserID = #{UserID}")
    int deletePhoto4ByUserID(@Param("UserID") int UserID);

    @Update("UPDATE blog SET Photo5 = null WHERE UserID = #{UserID}")
    int deletePhoto5ByUserID(@Param("UserID") int UserID);
    @Update("UPDATE blog SET Photo6 = null WHERE UserID = #{UserID}")
    int deletePhoto6ByUserID(@Param("UserID") int UserID);

    @Update("UPDATE blog SET ContentIntroduction = null WHERE UserID = #{UserID}")
    int deleteContentIntroductionByUserID(@Param("UserID") int UserID);

    @Update("UPDATE blog SET ContentDream = null WHERE UserID = #{UserID}")
    int deleteContentDreamByUserID(@Param("UserID") int UserID);

    @Update("UPDATE blog SET Content1 = null WHERE UserID = #{UserID}")
    int deleteContent1(@Param("UserID") int UserID);

    @Update("UPDATE blog SET Content2 = null WHERE UserID = #{UserID}")
    int deleteContent2(@Param("UserID") int UserID);

    @Update("UPDATE blog SET Content3 = null WHERE UserID = #{UserID}")
    int deleteContent3(@Param("UserID") int UserID);

    @Update("UPDATE blog SET Content4 = null WHERE UserID = #{UserID}")
    int deleteContent4(@Param("UserID") int UserID);

    @Update("UPDATE blog SET Content5 = null WHERE UserID = #{UserID}")
    int deleteContent5(@Param("UserID") int UserID);

    @Update("UPDATE blog SET Content6 = null WHERE UserID = #{UserID}")
    int deleteContent6(@Param("UserID") int UserID);

    @Update("UPDATE blog SET Content7 = null WHERE UserID = #{UserID}")
    int deleteContent7(@Param("UserID") int UserID);

    @Update("UPDATE blog SET Content8 = null WHERE UserID = #{UserID}")
    int deleteContent8(@Param("UserID") int UserID);

    @Update("UPDATE blog SET Content9 = null WHERE UserID = #{UserID}")
    int deleteContent9(@Param("UserID") int UserID);

    @Update("UPDATE blog SET Content10 = null WHERE UserID = #{UserID}")
    int deleteContent10(@Param("UserID") int UserID);
}
