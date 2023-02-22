package com.attempto.demo.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.attempto.demo.rest.model.Book;
import com.attempto.demo.rest.persistance.Library;

@RestController
public class BookController {

    private final Library library;

    public BookController(final Library library) {
        this.library = library;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return library.allBooks();
    }

    @GetMapping("/book/{bookId}")
    public Optional<Book> getBook(@PathVariable(value = "bookId") long bookId) {
        return library.getBook(bookId);
    }

    @DeleteMapping("/book/{bookId}")
    public void deleteBook(@PathVariable(value = "bookId") long bookId) {
        library.deleteBook(bookId);
    }

    @PutMapping(value = "/book/{bookId}")
    public void putBook(
        @PathVariable(value = "bookId") final long bookId,
        @RequestBody final Book book) {
        checkBookIdValid(bookId, book);
        library.addBook(book);
    }

    @PatchMapping(value = "/book/{bookId}")
    public void patchBook(
        @PathVariable(value = "bookId") final long bookId,
        @RequestBody final Book book) {
        checkBookIdValid(bookId, book);
        library.changeBook(book);
    }

    @PostMapping(value = "/book/{bookId}")
    public void postBook(
        @PathVariable(value = "bookId") final long bookId,
        @RequestBody final Book book) {
        checkBookIdValid(bookId, book);
        library.changeBook(book);
    }

    private static void checkBookIdValid(long bookId, Book book) {
        if (bookId != book.getId()) {
            throw new IllegalArgumentException("book Ids do not match path: " + bookId
                + "; body: " + book.getId());
        }
    }



}
