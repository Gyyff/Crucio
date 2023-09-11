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

    @Insert("INSERT INTO blog(BlogID, UserID, ContentIntroduction,ContentDream,PostTime) VALUES(#{BlogID}, #{UserID}, #{ContentIntroduction},#{ContentDream},#{PostTime})")
    @Options(useGeneratedKeys = true, keyProperty = "BlogID")
    int insertBlog(Blog blog);

    @Delete("DELETE FROM blog WHERE UserID = #{UserID}")
    int deleteBlogByUserID(@Param("UserID") int UserID);

    @Update("UPDATE blog SET ContentIntroduction = #{ContentIntroduction} WHERE UserID = #{UserID}")
    int updateContentIntroductionByUserID(@Param("UserID") int UserID, @Param("ContentIntroduction") String ContentIntroduction);

    @Update("UPDATE blog SET ContentDream = #{ContentDream} WHERE UserID = #{UserID}")
    int updateContentDreamByUserID(@Param("UserID") int UserID, @Param("ContentDream") String ContentDream);

}
