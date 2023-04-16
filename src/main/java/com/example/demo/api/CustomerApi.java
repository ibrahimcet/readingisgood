package com.example.demo.api;

import com.example.demo.config.ResponseFilter;
import com.example.demo.entity.Customer;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen")
@Api(tags = "customer",value = "the Customer API")
public interface CustomerApi {

    @ApiOperation(value = "Registering New Customer", nickname = "registeringCustomer", response = Customer.class, tags = {"customer"})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = Customer.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/customer",
            produces = {"application/json;charset=utf-8"},
            consumes = {"application/json;charset=utf-8"},
            method = RequestMethod.POST)
    ResponseEntity<Customer> registerCustomer(@ApiParam(value = "The Customer to be created", required = true)@Valid @RequestBody Customer body, HttpServletRequest request, HttpServletResponse response
    ) throws Exception;


    @ApiOperation(value = "Retrieves a Customer by ID", nickname = "retrieveCustomer", response = Customer.class, tags = {"customer"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Customer.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 404, message = "Not Found", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/customer/{id}",
            produces = {"application/json;charset=utf-8"},
            method = RequestMethod.GET)
    @ResponseFilter
    ResponseEntity<Customer> retrieveCustomer(@ApiParam(value = "Id of the Customer", required = true) @PathVariable("id") String id,
                                            HttpServletResponse response, HttpServletRequest request
    ) throws Exception;
}
