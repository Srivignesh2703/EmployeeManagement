package com.vignesh.EMS_Backend.service;

import com.vignesh.EMS_Backend.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployee();
    Employee updateEmployee(Long id, Employee updatedEmployee);
    void deleteEmployee(Long id);
}
