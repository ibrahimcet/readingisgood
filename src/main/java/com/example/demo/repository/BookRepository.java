package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository  extends MongoRepository<Book, String> {

    Book findByName(String name);
}
