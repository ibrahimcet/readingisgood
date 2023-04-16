package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "customer")
public class Customer implements Serializable{

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    private String email;

    @JsonIgnore
    private String password;

    @NotNull
    private String username;
}
