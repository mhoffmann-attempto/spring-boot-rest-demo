package com.attempto.demo.rest.persistance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.RepeatedTest;

import com.attempto.demo.rest.model.Book;

class RandomBookChooserTest {

    @RepeatedTest(5)
    void thereIsABook() {
        final Book aRandomBook = RandomBookChooser.createARandomBook();
        System.out.println(aRandomBook);
        assertAll(
            () -> assertThat(aRandomBook.getAuthor()).isNotEmpty(),
            () -> assertThat(aRandomBook.getName()).isNotEmpty(),
            () -> assertThat(aRandomBook.getPrice().doubleValue()).isBetween(0.00D, 100D),
            () -> assertThat(aRandomBook.getPages()).isBetween(0, 2000),
            () -> assertThat(aRandomBook.getId()).isGreaterThan(0)
        );
    }
}
