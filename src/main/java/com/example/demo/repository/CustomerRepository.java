package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface CustomerRepository extends MongoRepository<Customer, String> {


}
