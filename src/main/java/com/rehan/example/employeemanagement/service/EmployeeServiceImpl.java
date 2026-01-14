package com.rehan.example.employeemanagement.service;


import com.rehan.example.employeemanagement.entity.Employee;
import com.rehan.example.employeemanagement.Repository.EmployeeRepository;
import com.rehan.example.employeemanagement.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepository repo;
    public EmployeeServiceImpl(EmployeeRepository repo){
        this.repo=repo;
    }

    @Override
    public Employee saveEmployee(Employee e) {
         return repo.save(e);
    }

    @Override
    public Page<Employee> getAllEmployees(Pageable pageable) {
        return (repo.findAll(pageable));
    }

    @Override
    public Employee getEmployeeById(Long id) {
       return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee with ID: "+id+" not found"));

    }

    @Override
    public Employee updateEmployee(Long id ,Employee e) {
        Optional<Employee> byId = repo.findById(id);
        if (byId.isPresent()){
            e.setId(id);
            Employee save = repo.save(e);
            return save;
        }else {
            throw new ResourceNotFoundException("Employee with ID " + id + " not found");
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Employee partialUpdate(Long id, Map<String, Object> updates) {
        Employee employee= repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee with id: "+id+" not found "));
        updates.forEach((key,value) ->{
            switch (key){
                case "firstName" -> employee.setFirstName((String) value);
                case "lastName" -> employee.setLastName((String) value);
                case "email" -> employee.setEmail((String) value);
                case "department" -> employee.setDepartment((String) value);
            }
        });
        return repo.save(employee);
    }
}
