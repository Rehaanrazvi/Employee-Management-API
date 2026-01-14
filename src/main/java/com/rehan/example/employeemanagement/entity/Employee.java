package com.rehan.example.employeemanagement.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "first name is required")
    private String firstName;
    @NotBlank(message = "last name is required")
    private String lastName;

    @NotBlank(message = "email is required")
    @Email(message = "email should be valid")
    private String email;
    @NotBlank(message = "department is required")
    private String department;
}
