package com.example.demo.api;

import com.example.demo.config.ResponseFilter;
import com.example.demo.entity.Book;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen")
@Api(tags = "book",value = "the Book API")
public interface BookApi {

    @ApiOperation(value = "Create New Book", nickname = "creatingBook", response = Book.class, tags = {"book"})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = Book.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/book",
            produces = {"application/json;charset=utf-8"},
            consumes = {"application/json;charset=utf-8"},
            method = RequestMethod.POST)
    ResponseEntity<Book> createBook(@ApiParam(value = "The Book to be created", required = true)@Valid @RequestBody Book body, HttpServletRequest request, HttpServletResponse response
    ) throws Exception;

    @ApiOperation(value = "Retrieves a Book by ID", nickname = "retrieveBook", response = Book.class, tags = {"book"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Book.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 404, message = "Not Found", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/book/{id}",
            produces = {"application/json;charset=utf-8"},
            method = RequestMethod.GET)
    @ResponseFilter
    ResponseEntity<Book> retrieveBook(@ApiParam(value = "Id of the Book", required = true) @PathVariable("id") String id,
                                              HttpServletResponse response, HttpServletRequest request
    ) throws Exception;
}
