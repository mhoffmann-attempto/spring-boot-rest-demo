package com.attempto.demo.rest.persistance;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LibraryInitializer implements ApplicationRunner {

    private final Library library;

    public LibraryInitializer(final Library library) {
        this.library = library;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 2; i++) {
            library.addBook(RandomBookChooser.createARandomBook());
        }
    }
}
