package com.example.bookapi.repository;

import com.example.bookapi.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepository {

    private final String filePath = "src/main/resources/books.json";
    private List<Book> books;

    public BookRepository() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            books = mapper.readValue(new File(filePath), mapper.getTypeFactory().constructCollectionType(List.class, Book.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public List<Book> getBooks(String author, String bookName, Integer releaseYear) {
        return books.stream()
                .filter(book -> (author == null || book.getAuthor().equalsIgnoreCase(author)) &&
                        (bookName == null || book.getBookName().equalsIgnoreCase(bookName)) &&
                        (releaseYear == null || book.getReleaseDate().getYear() == releaseYear))
                .collect(Collectors.toList());
    }

    public void deleteBooks(String author, String bookName, Integer releaseYear) {
        books = books.stream()
                .filter(book -> !(book.getAuthor().equalsIgnoreCase(author) ||
                        book.getBookName().equalsIgnoreCase(bookName) ||
                        book.getReleaseDate().getYear() == releaseYear))
                .collect(Collectors.toList());
        saveBooks();
    }

    public void updateBook(Book updatedBook) {
        books = books.stream()
                .map(book -> book.getBookName().equalsIgnoreCase(updatedBook.getBookName()) ? updatedBook : book)
                .collect(Collectors.toList());
        saveBooks();
    }

    private void saveBooks() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filePath), books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
