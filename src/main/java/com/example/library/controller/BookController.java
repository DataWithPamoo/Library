package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.Bookservice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final Bookservice bookService;

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/all")
    public List<Book> getAll() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/update/{id}")
    public Book update(@PathVariable String id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        bookService.deleteBookById(id);
    }

    @GetMapping("/year/{year}")
    public List<Book> getByYear(@PathVariable int year) {
        return bookService.getBooksByYear(year);
    }

    @GetMapping("/genre/{id}")
    public String getGenre(@PathVariable String id) {
        return bookService.getGenreByBookId(id);
    }

    @DeleteMapping("/delete/year/{year}")
    public void deleteByYear(@PathVariable int year) {
        bookService.deleteBooksByYear(year);
    }
}