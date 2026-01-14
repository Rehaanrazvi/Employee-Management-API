package com.rehan.example.employeemanagement.Dto;

import com.rehan.example.employeemanagement.entity.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotBlank(message = "first name is required")
    private String firstName;

    @NotBlank(message = "last name is required")
    private String lastName;

    @NotBlank(message = "email is required")
    @Email(message = "email should be valid")
    private String email;

    @NotBlank(message = "department is required")
    private String department;

    public Employee toEntity(){
        Employee employee = new Employee( );
        employee.setFirstName(this.firstName);
        employee.setLastName(this.lastName);
        employee.setEmail(this.email);
        employee.setDepartment(this.department);
        return employee;
    }
    public static EmployeeDTO fromEntity(Employee employee){
        EmployeeDTO dto =new EmployeeDTO();
        dto.setDepartment(employee.getDepartment());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        return dto;
    }

}
