package com.example.demo.entity;

import com.example.demo.validation.Quantity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "order")
@Validated
public class Order {

    @Id
    private String id;

    @NotNull
    private Customer customer;

    @NotNull
    private Book book;

    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private String address;

    @Quantity
    private Integer quantity;
}
