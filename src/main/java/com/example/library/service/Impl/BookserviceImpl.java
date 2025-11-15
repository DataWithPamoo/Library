package com.example.library.service.Impl;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.Bookservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookserviceImpl implements Bookservice {

    private final BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book updateBook(String id, Book book) {
        Book existing = getBookById(id);
        if (existing == null) return null;

        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setYear(book.getYear());
        existing.setGenre(book.getGenre());

        return bookRepository.save(existing);
    }

    @Override
    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getBooksByYear(int year) {
        return bookRepository.findByYear(year);
    }

    @Override
    public String getGenreByBookId(String id) {
        Book book = getBookById(id);
        return (book != null) ? book.getGenre() : null;
    }

    @Override
    public void deleteBooksByYear(int year) {
        List<Book> books = bookRepository.findByYear(year);
        bookRepository.deleteAll(books);
    }
}