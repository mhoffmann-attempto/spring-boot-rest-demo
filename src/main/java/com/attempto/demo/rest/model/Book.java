package com.attempto.demo.rest.model;

import java.math.BigDecimal;
import java.util.StringJoiner;

import jakarta.annotation.Nonnull;

public class Book {

    private long id;

    @Nonnull
    private String name;

    @Nonnull
    private String author;

    @Nonnull
    private BigDecimal price;

    private int pages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
            .add("uuid=" + id)
            .add("name='" + name + "'")
            .add("author='" + author + "'")
            .add("price=" + price)
            .add("pages=" + pages)
            .toString();
    }
}
