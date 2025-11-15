package com.example.library.service;

import com.example.library.model.Book;
import java.util.List;

public interface Bookservice {

    Book addBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(String id);
    Book updateBook(String id, Book book);
    void deleteBookById(String id);

    List<Book> getBooksByYear(int year);

    String getGenreByBookId(String id);

    void deleteBooksByYear(int year);
}
