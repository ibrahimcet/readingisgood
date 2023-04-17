package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.entity.Status;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class StatisticsService {

    private final OrderRepository orderRepository;

    public Integer getTotalOrderCount(){
        return orderRepository.findAll().size();
    }

    public Integer getTotalAmountOfPurchasedOrders(){
        return (int) orderRepository.findAll().stream()
                .filter(order -> order.getStatus().equals(Status.PURCHASED)).count();
    }

    public Integer getTotalAmountOfPurchasedBooks(){
        return (int) orderRepository.findAll().stream()
                .filter(order -> order.getStatus().equals(Status.PURCHASED))
                .map(order -> order.getBook().getStock()).count();
    }

}
