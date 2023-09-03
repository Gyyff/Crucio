package com.heiqi.chat.service;

import com.heiqi.chat.entity.Book;
import com.heiqi.chat.entity.UserBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Book getBookById(int BookID);

    Book getBookByName(String BookName);

    Book getBookByAuthor(String Author);

    UserBook getUserBookByUserID(int UserID);

    int insertUserBook(UserBook userBook);

    int updateUserBookRecommendation(int UserID, int BookID, String Recommendation);

    int deleteUserBook(int BookID, int UserID);

    int insertBook(Book book);

    int deleteBook(int BookID);

    int updateBookName(int BookID, String BookName);

    int updateAuthor(int BookID, String Author);
}
