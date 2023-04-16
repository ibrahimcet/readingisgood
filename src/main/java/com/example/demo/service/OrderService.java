package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Order;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.OrderRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    public Order createOrder(Order order){
        Book existingBook = bookRepository.findByName(order.getBook().getName());
        String bookId = existingBook.getId();
        String customerId = order.getCustomer().getId();

        Order existingOrder = orderRepository.findAll().stream()
                .filter(o -> o.getBook().getId().equals(bookId) && o.getCustomer().getId().equals(customerId))
                .findFirst().orElse(null);

        if (existingOrder != null){
            throw new RuntimeException(String.format("an order has already been created for the same customer: %s from the same book : %s", order.getCustomer().getName(), order.getBook().getName()));
        }
        orderRepository.save(order);
        existingBook.setStock(existingBook.getStock() - 1);
        bookRepository.save(existingBook);
        return order;
    }

    public Order retrieveOrder(String id) throws NotFoundException {
        Order retrievedOrder = orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Order not found"));
        return retrievedOrder;
    }
}
