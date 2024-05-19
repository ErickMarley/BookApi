package com.example.bookapi.controller;

import com.example.bookapi.model.Book;
import com.example.bookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getBooks(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String bookName,
            @RequestParam(required = false) Integer releaseYear) {
        return bookService.getBooks(author, bookName, releaseYear);
    }

    @DeleteMapping
    public void deleteBooks(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String bookName,
            @RequestParam(required = false) Integer releaseYear) {
        bookService.deleteBooks(author, bookName, releaseYear);
    }

    @PutMapping
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }
}
