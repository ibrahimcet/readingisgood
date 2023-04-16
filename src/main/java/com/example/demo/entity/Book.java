package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "book")
public class Book {

    @Id
    private String id;

    @NotNull
    private String author;

    @NotNull
    private String name;

    private Integer page;

    @NotNull
    private Integer stock;

    @NotNull
    private String price;
}
