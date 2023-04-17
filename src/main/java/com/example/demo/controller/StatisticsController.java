package com.example.demo.controller;

import com.example.demo.api.StatisticsApi;
import com.example.demo.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class StatisticsController implements StatisticsApi {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsController.class);

    private final StatisticsService statisticsService;

    @Override
    public ResponseEntity<Integer> totalOrderCount(HttpServletResponse response, HttpServletRequest request) {
        Integer totalOrderCount = statisticsService.getTotalOrderCount();
        logger.info("Retrieved total order count: ", totalOrderCount);
        return ResponseEntity.ok().body(totalOrderCount);
    }

    @Override
    public ResponseEntity<Integer> totalAmountOfPurchasedOrders(HttpServletResponse response, HttpServletRequest request) {
        Integer totalAmountOfPurchasedOrders = statisticsService.getTotalAmountOfPurchasedOrders();
        logger.info("Retrieved total amount of purchased orders: ", totalAmountOfPurchasedOrders);
        return ResponseEntity.ok().body(totalAmountOfPurchasedOrders);
    }

    @Override
    public ResponseEntity<Integer> totalAmountOfPurchasedBooks(HttpServletResponse response, HttpServletRequest request)  {
        Integer totalAmountOfPurchasedBooks = statisticsService.getTotalAmountOfPurchasedBooks();
        logger.info("Retrieved total amount of purchased books: ", totalAmountOfPurchasedBooks);
        return ResponseEntity.ok().body(totalAmountOfPurchasedBooks);
    }
}
