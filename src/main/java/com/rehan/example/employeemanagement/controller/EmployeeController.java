package com.rehan.example.employeemanagement.controller;


import com.rehan.example.employeemanagement.Dto.EmployeeDTO;
import com.rehan.example.employeemanagement.entity.Employee;
import com.rehan.example.employeemanagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    EmployeeService service;
    public EmployeeController(EmployeeService service){
        this.service=service;
    }
    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(Pageable pageable){
        Page<Employee> employeesPage = service.getAllEmployees(pageable);
        List<EmployeeDTO> dto =
                    employeesPage
                .stream()
                .map(EmployeeDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id){
        Employee emp = service.getEmployeeById(id);
        return ResponseEntity.ok(EmployeeDTO.fromEntity(emp));
    }
    @PatchMapping("/{id}")
    public ResponseEntity <EmployeeDTO> patchEmployee(
            @PathVariable Long id , @RequestBody Map<String,Object> updates){
        Employee updated = service.partialUpdate(id,updates);
        return ResponseEntity.ok(EmployeeDTO.fromEntity(updated));
    }


    @PostMapping()
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody @Valid  EmployeeDTO dto){
        Employee saved =service.saveEmployee(dto.toEntity());
        return ResponseEntity.ok(EmployeeDTO.fromEntity(saved));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody @Valid  EmployeeDTO dto, @PathVariable Long id){
        Employee updated =service.updateEmployee(id,dto.toEntity());
        return ResponseEntity.ok(EmployeeDTO.fromEntity(updated));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployees(@PathVariable Long id){
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
