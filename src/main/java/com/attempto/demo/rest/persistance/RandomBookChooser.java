package com.attempto.demo.rest.persistance;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.attempto.demo.rest.model.Book;

@Service
public class RandomBookChooser {

    private static final List<String> authors = List.of(
        "Author 1",
        "Detektive five",
        "Erin Huntinger",
        "J.B.K. Robust",
        "Erich Kasten",
        "Der Rote Teufel");
    private static final List<String> names = List.of(
        "Title 1",
        "Ein spannendes Buch",
        "Detektive Title",
        "Worrior Cabs",
        "Harry Schrotter");

    private static final AtomicInteger nextId = new AtomicInteger(0);

    public static Book createARandomBook() {
        final Random randomizer = new SecureRandom();

        final Book book = new Book();

        book.setId(nextId.incrementAndGet());
        book.setAuthor(authors.get(randomizer.nextInt(authors.size())));
        book.setName(names.get(randomizer.nextInt(names.size())));
        book.setPages(randomizer.nextInt(2000));
        book.setPrice(
            BigDecimal.valueOf(
                    randomizer.nextInt(100) + randomizer.nextDouble())
                .setScale(2, RoundingMode.HALF_DOWN));

        return book;
    }

}
