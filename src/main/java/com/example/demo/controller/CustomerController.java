package com.example.demo.controller;

import com.example.demo.api.CustomerApi;
import com.example.demo.config.ResponseFilter;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
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
public class CustomerController implements CustomerApi {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    @Override
    public ResponseEntity<Customer> registerCustomer(@Valid Customer body, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Customer customer = customerService.registerCustomer(body);
        logger.info("Registered new customer with id:{}", customer.getId());
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @ResponseFilter
    @Override
    public ResponseEntity<Customer> retrieveCustomer(String id, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Customer customer = customerService.retrieveCustomer(id);
        logger.info("retrieve customer with id:{}", customer.getId());
        return ResponseEntity.ok().body(customer);
    }
}
