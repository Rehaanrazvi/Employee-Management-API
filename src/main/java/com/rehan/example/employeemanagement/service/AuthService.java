package com.rehan.example.employeemanagement.service;


import com.rehan.example.employeemanagement.Dto.UserDTO;
import com.rehan.example.employeemanagement.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


public interface AuthService {
    public User register(UserDTO dto);
    public UserDetails login(UserDTO dto);
}

