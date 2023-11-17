package com.example.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Document(collection = "users")
@Getter
@Setter
@ToString
@AllArgsConstructor

public class User {
//    @Id
//    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
