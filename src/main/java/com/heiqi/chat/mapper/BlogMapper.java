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

    @Insert("INSERT INTO blog(BlogID, UserID, Content,PostTime) VALUES(#{BlogID}, #{UserID}, #{Content},#{PostTime})")
    @Options(useGeneratedKeys = true, keyProperty = "BlogID")
    int insertBlog(Blog blog);

    @Delete("DELETE FROM blog WHERE UserID = #{UserID}")
    int deleteBlogByUserID(@Param("UserID") int UserID);

    @Delete("DELETE FROM blog WHERE BlogID = #{BlogID}")
    int deleteBlogByBlogID(@Param("BlogID") int BlogID);

    @Update("UPDATE blog SET Content = #{Content} WHERE UserID = #{UserID}")
    int updateBlogByUserID(@Param("UserID") int UserID, @Param("Content") String Content);

    @Update("UPDATE blog SET Content = #{Content} WHERE BlogID = #{BlogID}")
    int updateBlogByBlogID(@Param("BlogID") int BlogID, @Param("Content") String Content);
}
