package com.example.springboot.controller;

import com.example.springboot.dto.LoginRequestDTO;
import com.example.springboot.model.User;
import com.example.springboot.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))


public class LoginController {
    private final LoginService loginService;
    @GetMapping("/login")
    public User login(@RequestBody @NotNull LoginRequestDTO loginRequestDTO){
        return loginService.loginHandler(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
    }
}
