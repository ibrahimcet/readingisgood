package com.example.demo.api;

import com.example.demo.config.ResponseFilter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen")
@Api(tags = "statistics",value = "the Statistics API")
@RequestMapping("/api")
public interface StatisticsApi {

    @ApiOperation(value = "Total Order count", nickname = "getTotalOrderCount", response = Integer.class, tags = {"totalOrderCount"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Integer.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 404, message = "Not Found", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/statistics/totalOrderCount",
            produces = {"application/json;charset=utf-8"},
            method = RequestMethod.GET)
    @ResponseFilter
    ResponseEntity<Integer> totalOrderCount(HttpServletResponse response, HttpServletRequest request
    );

    @ApiOperation(value = "Total Amount of Purchased Orders", nickname = "getTotalAmountOfPurchasedOrders", response = Integer.class, tags = {"totalAmountOfPurchasedOrders"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Integer.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 404, message = "Not Found", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/statistics/totalAmountofPurchasedOrders",
            produces = {"application/json;charset=utf-8"},
            method = RequestMethod.GET)
    @ResponseFilter
    ResponseEntity<Integer> totalAmountOfPurchasedOrders(HttpServletResponse response, HttpServletRequest request
    );

    @ApiOperation(value = "Total Amount of Purchased Books", nickname = "getTotalAmountOfPurchasedBooks", response = Integer.class, tags = {"totalAmountOfPurchasedBooks"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Integer.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 404, message = "Not Found", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/statistics/totalAmountofPurchasedBooks",
            produces = {"application/json;charset=utf-8"},
            method = RequestMethod.GET)
    @ResponseFilter
    ResponseEntity<Integer> totalAmountOfPurchasedBooks(HttpServletResponse response, HttpServletRequest request
    );
}
