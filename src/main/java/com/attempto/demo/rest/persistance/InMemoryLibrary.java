package com.attempto.demo.rest.persistance;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.attempto.demo.rest.model.Book;

@Repository
public class InMemoryLibrary implements Library {

    private static final Logger LOG = LoggerFactory.getLogger(InMemoryLibrary.class);

    private final Map<Long, Book> books = new ConcurrentHashMap<>();

    @Override
    public List<Book> allBooks() {
        return books.values().parallelStream().toList();
    }

    @Override
    public void addBook(final Book book) {
        final Optional<Book> oldValue = Optional.ofNullable(
            books.put(book.getId(), book));
        if (oldValue.isPresent()) {
            LOG.warn("Overwriting old Book: " + book);
        }
    }

    @Override
    public void deleteBook(final long bookId) {
        if (books.containsKey(bookId)) {
            books.remove(bookId);
        } else {
            throw new IllegalArgumentException("Book not found for id: " + bookId);
        }
    }

    @Override
    public void changeBook(Book book) {
        final Optional<Book> oldValue = Optional.ofNullable(
            books.put(book.getId(), book));
        if (oldValue.isEmpty()) {
            LOG.warn("The Book was not there. Adding it: " + book);
        }
    }

    @Override
    public Optional<Book> getBook(long bookId) {
        return Optional.ofNullable(books.get(bookId));
    }
}
