package com.example.springboot.controller;

import com.example.springboot.dto.RegisterRequestDTO;
import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class RegisterController {
    private final RegisterService registerService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody @NotNull RegisterRequestDTO registerRequestDTO){
        User user = registerService.registerHandler(registerRequestDTO.getUsername(),
                registerRequestDTO.getPassword(), registerRequestDTO.getFirstName(),
                registerRequestDTO.getLastName(), registerRequestDTO.getDob());
        return user;
    }

}
