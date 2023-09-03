package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.Book;
import com.heiqi.chat.entity.UserBook;
import com.heiqi.chat.mapper.BookMapper;
import com.heiqi.chat.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Book getBookById(int BookID) {
        return bookMapper.getBookById(BookID);
    }

    @Override
    public Book getBookByName(String BookName) {
        return bookMapper.getBookByName(BookName);
    }

    @Override
    public Book getBookByAuthor(String Author) {
        return bookMapper.getBookByAuthor(Author);
    }

    @Override
    public UserBook getUserBookByUserID(int UserID) {
        return bookMapper.getUserBookByUserID(UserID);
    }

    @Override
    public int insertUserBook(UserBook userBook) {
        return bookMapper.insertUserBook(userBook);
    }

    @Override
    public int updateUserBookRecommendation(int UserID, int BookID, String Recommendation) {
        return bookMapper.updateUserBookRecommendation(UserID,BookID,Recommendation);
    }

    @Override
    public int deleteUserBook(int BookID, int UserID) {
        return bookMapper.deleteUserBook(BookID,UserID);
    }

    @Override
    public int insertBook(Book book) {
        return bookMapper.insertBook(book);
    }

    @Override
    public int deleteBook(int BookID) {
        return bookMapper.deleteBook(BookID);
    }

    @Override
    public int updateBookName(int BookID, String BookName) {
        return bookMapper.updateBookName(BookID,BookName);
    }

    @Override
    public int updateAuthor(int BookID, String Author) {
        return bookMapper.updateBookAuthor(BookID,Author);
    }
}
