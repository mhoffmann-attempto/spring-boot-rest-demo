package com.attempto.demo.rest;

import java.util.UUID;
import java.util.stream.IntStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.attempto.demo.rest.model.Book;
import com.attempto.demo.rest.persistance.Library;
import com.attempto.demo.rest.persistance.RandomBookChooser;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(
			RestApplication.class, args);
	}



}
