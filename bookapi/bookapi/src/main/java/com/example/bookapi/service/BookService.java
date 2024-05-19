package com.example.bookapi.service;
import com.example.bookapi.model.Book;
import com.example.bookapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public List<Book> getBooks(String author, String bookName, Integer releaseYear) {
        return bookRepository.getBooks(author, bookName, releaseYear);
    }

    public void deleteBooks(String author, String bookName, Integer releaseYear) {
        bookRepository.deleteBooks(author, bookName, releaseYear);
    }

    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }
}
