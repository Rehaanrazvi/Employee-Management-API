package com.rehan.example.employeemanagement.service;

import com.rehan.example.employeemanagement.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public Employee saveEmployee(Employee e);

    public Page<Employee> getAllEmployees(Pageable pageable);

    public Employee getEmployeeById(Long id);

    public Employee updateEmployee(Long id,Employee e);

    public void deleteEmployee(Long id);

    public Employee partialUpdate(Long id, Map<String, Object> updates);
}
