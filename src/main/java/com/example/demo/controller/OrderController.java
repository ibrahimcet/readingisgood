package com.example.demo.controller;

import com.example.demo.api.OrderApi;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class OrderController implements OrderApi {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    @Override
    public ResponseEntity<Order> createOrder(@Valid Order body, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Order order = orderService.createOrder(body);
        logger.info("Created new order with id:{}", order.getId());
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Order> retrieveOrder(String id, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Order order = orderService.retrieveOrder(id);
        return ResponseEntity.ok().body(order);
    }

}
