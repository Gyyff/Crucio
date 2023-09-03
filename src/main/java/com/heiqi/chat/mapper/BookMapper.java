package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.Book;
import com.heiqi.chat.entity.UserBook;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface BookMapper {

    @Select("SELECT * FROM book WHERE BookID = #{BookID}")
    Book getBookById(@Param("BookID") int BookID);

    @Select("SELECT * FROM book WHERE BookName = #{BookName}")
    Book getBookByName(@Param("BookName") String BookName);

    @Select("SELECT * FROM book WHERE Author = #{Author}")
    Book getBookByAuthor(@Param("Author") String Author);

    @Select("SELECT * FROM userbook WHERE UserID = #{UserID}")
    UserBook getUserBookByUserID(@Param("UserID") int UserID);

    @Insert("INSERT INTO userbook(UserID, BookID, Recommendation) VALUES(#{UserID}, #{BookID}, #{Recommendation})")
    @Options(useGeneratedKeys = true, keyProperty = "UserID")
    int insertUserBook(UserBook userBook);

    @Update("UPDATE userbook SET Recommendation = #{Recommendation} WHERE UserID = #{UserID} AND BookID = #{BookID} ")
    int updateUserBookRecommendation(@Param("UserID") int UserID, @Param("BookID") int BookID, @Param("Recommendation") String Recommendation);

    @Delete("DELETE FROM userbook WHERE BookID = #{BookID} AND UserID = #{UserID}")
    int deleteUserBook(@Param("BookID") int BookID, @Param("UserID") int UserID);

    @Insert("INSERT INTO book(BookID, BookName, Author) VALUES(#{BookID}, #{BookName}, #{Author})")
    @Options(useGeneratedKeys = true, keyProperty = "BookID")
    int insertBook(Book book);

    @Delete("DELETE FROM book WHERE BookID = #{BookID}")
    int deleteBook(@Param("BookID") int BookID);

    @Update("UPDATE book SET BookName = #{BookName} WHERE BookID = #{BookID}")
    int updateBookName(@Param("BookID") int BookID, @Param("BookName") String BookName);

    @Update("UPDATE book SET Author = #{Author} WHERE BookID = #{BookID}")
    int updateBookAuthor(@Param("BookID") int BookID, @Param("Author") String Author);


}
