package com.example.demo.controller;

import com.example.demo.api.BookApi;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class BookController implements BookApi {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;


    @Override
    public ResponseEntity<Book> createBook(@Valid Book body, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Book book = bookService.createBook(body);
        logger.info("Created new book with id:{}", book.getId());
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Book> retrieveBook(String id, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Book book = bookService.retrieveBook(id);
        return ResponseEntity.ok().body(book);
    }
}
