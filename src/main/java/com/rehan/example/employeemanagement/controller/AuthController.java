package com.rehan.example.employeemanagement.controller;


import com.rehan.example.employeemanagement.Dto.UserDTO;
import com.rehan.example.employeemanagement.entity.User;
import com.rehan.example.employeemanagement.security.JwtService;
import com.rehan.example.employeemanagement.service.AuthserviceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthserviceImpl authservice;
    private final JwtService jwtService;

    private AuthController(AuthserviceImpl authservice, JwtService jwtService){
        this.authservice=authservice;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> saveUser(@RequestBody @Valid UserDTO userDTO){
        authservice.register(userDTO);
        return ResponseEntity.ok("User registered succesfully");
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> loginUser(@RequestBody @Valid UserDTO dto ){
        UserDetails userDetails = authservice.login(dto);
        String token = jwtService.generateToken(userDetails);
        authservice.login(dto);
        return ResponseEntity.ok(Map.of("token",token));
    }

}
