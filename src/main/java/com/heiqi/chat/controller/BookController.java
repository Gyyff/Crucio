package com.heiqi.chat.controller;

import com.heiqi.chat.entity.BaseUser;
import com.heiqi.chat.entity.Book;
import com.heiqi.chat.entity.UserBook;
import com.heiqi.chat.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getBookById/{BookID}")
    public Book getBookById(@PathVariable("BookID") int BookID) {
        return bookService.getBookById(BookID);
    }

    @GetMapping("/getBookByName/{BookName}")
    public Book getBookByName(@PathVariable("BookName") String BookName) {
        return bookService.getBookByName(BookName);
    }

    @GetMapping("/getBookByAuthor/{Author}")
    public Book getBookByAuthor(@PathVariable("Author") String Author) {
        return bookService.getBookByAuthor(Author);
    }

    @GetMapping("/getUserBookByUserID/{UserID}")
    public UserBook getUserBookByUserID(@PathVariable("UserID") int UserID) {
        return bookService.getUserBookByUserID(UserID);
    }
    // 这里写更多的 getter 函数...

    @PostMapping("/insertBook")
    public void insertBook(@RequestBody Book book, BaseUser baseUser) {
        bookService.insertBook(book);
    }

    @PostMapping("/insertUserBook")
    public void insertUserBook(@RequestBody UserBook userBook, BaseUser baseUser) {
        System.out.println("userBook = " + userBook);
        bookService.insertUserBook(userBook);
    }

    @DeleteMapping("/deleteBook/{BookID}")
    public void deleteBook(@PathVariable("BookID") int BookID, BaseUser baseUser) {
        bookService.deleteBook(BookID);
    }

    @DeleteMapping("/deleteUserBook/{BookID}/{UserID}")
    public void deleteUserBook(@PathVariable("BookID") int BookID, @PathVariable("UserID") int UserID, BaseUser baseUser) {
        bookService.deleteUserBook(BookID, UserID);
    }

    @PutMapping("/updateBookName/{BookID}")
    public void updateBookName(@PathVariable("BookID") int BookID, @RequestBody String BookName, BaseUser baseUser) {
        bookService.updateBookName(BookID, BookName);
    }

    @PutMapping("/updateBookAuthor/{BookID}")
    public void updateBookAuthor(@PathVariable("BookID") int BookID, @RequestBody String Author, BaseUser baseUser) {
        bookService.updateAuthor(BookID, Author);
    }

    @PutMapping("/updateUserBookRecommendation/{UserID}/{BookID}")
    public void updateUserBookRecommendation(@PathVariable("UserID") int UserID, @PathVariable("BookID") int BookID, @RequestBody String Recommendation, BaseUser baseUser) {
        bookService.updateUserBookRecommendation(UserID, BookID, Recommendation);
    }
    // 这里写更多的 setter 函数...


}
