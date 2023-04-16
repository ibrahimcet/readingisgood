package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer registerCustomer(Customer customer){
        customerRepository.save(customer);
        return customer;
    }

    public Customer retrieveCustomer(String id) throws NotFoundException {
        Customer retrievedCustomer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found"));
        return retrievedCustomer;
    }


}
