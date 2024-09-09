package com.vignesh.EMS_Backend.mapper;

import com.vignesh.EMS_Backend.dto.EmployeeDto;
import com.vignesh.EMS_Backend.entity.Employee;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
}
