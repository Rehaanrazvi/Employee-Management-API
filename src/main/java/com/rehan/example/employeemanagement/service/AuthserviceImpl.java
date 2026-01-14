package com.rehan.example.employeemanagement.service;


import com.rehan.example.employeemanagement.Dto.UserDTO;
import com.rehan.example.employeemanagement.Repository.UserRepository;
import com.rehan.example.employeemanagement.entity.User;
import com.rehan.example.employeemanagement.exception.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthserviceImpl implements AuthService{

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public AuthserviceImpl(UserRepository repo, PasswordEncoder passwordEncoder){
        this.repo =repo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(UserDTO dto) {

        User user = new User();
            user.setEmail(dto.getEmail());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            return repo.save(user);
    }

    @Override
    public UserDetails login(UserDTO dto) {
        User user = repo.findByEmail(dto.getEmail()).orElseThrow(() -> new RuntimeException("Invalid  EMAIL or PASSWORD "));
        boolean matches = passwordEncoder.matches(dto.getPassword(), user.getPassword());
        if (!matches){
            throw new RuntimeException("Invalid email or password");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(new ArrayList<>()) // No roles for now
                .build();

    }
}
