package com.example.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RegisterRequestDTO {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
