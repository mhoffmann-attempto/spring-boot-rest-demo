package com.attempto.demo.rest.persistance;

import java.util.List;
import java.util.Optional;

import com.attempto.demo.rest.model.Book;

public interface Library {

    List<Book> allBooks();

    void addBook(Book book);

    void deleteBook(long bookId);

    void changeBook(Book book);

    Optional<Book> getBook(long bookId);
}
