package com.example.springboot.service;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@EnableMongoRepositories
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service

public class RegisterService {
    private final UserRepository userRepository;

    public User registerHandler(String username, String password, String firstName, String lastName, LocalDate dob){
        userRepository.save(new User(username, password, firstName, lastName, dob));
        Optional<User> userInfo = userRepository.getUserByUsername(username);
        if (userInfo.isPresent()){
            return userInfo.get();
        }
        else{
            throw new RuntimeException("Missing Values/Incorrect Format");
        }
    }
}

