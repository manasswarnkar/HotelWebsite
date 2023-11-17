package com.example.springboot.service;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.*;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service

public class LoginService {
    private final UserRepository userRepository;
    public User loginHandler(String username, String password) {
        Optional<User> userInfo = userRepository.getUserByUsername(username);
        if (userInfo.isPresent()) {
            if (Objects.equals(userInfo.get().getUsername(), username)) {
                if (Objects.equals(userInfo.get().getPassword(), password)) {
                    System.out.println("Successfully logged in!");
                    return userInfo.get();
                } else {
                    throw new RuntimeException("Incorrect Password");
                }
            } else {
                throw new RuntimeException("User Not Found");
            }
        }
        return null;
    }
}
