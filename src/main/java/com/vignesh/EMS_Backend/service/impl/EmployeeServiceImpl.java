package com.vignesh.EMS_Backend.service.impl;

import com.vignesh.EMS_Backend.entity.Employee;
import com.vignesh.EMS_Backend.exception.ResourceNotFoundException;
import com.vignesh.EMS_Backend.repository.EmployeeRepo;
import com.vignesh.EMS_Backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo repo;
    @Override
    public Employee createEmployee(Employee employee) {
        return repo.save(employee);
    }

    public Employee getEmployeeById(Long id){
        return repo
                .findById(id)
                .orElseThrow(()
                        -> new ResourceNotFoundException("Employee with the id: " + id + " not found!"));
    }

    public List<Employee> getAllEmployee(){
        return repo.findAll();
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee){
        Employee oldEmployee = repo
                .findById(id)
                .orElseThrow(()
                        -> new ResourceNotFoundException("Employee with the id "
                        + updatedEmployee.getId()
                        + " not found!"));
        oldEmployee.setFirstName(updatedEmployee.getFirstName());
        oldEmployee.setLastName(updatedEmployee.getLastName());
        oldEmployee.setEmail(updatedEmployee.getEmail());
        return repo.save(oldEmployee);
    }

    public void deleteEmployee(Long id){
        Employee emp = repo.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("Employee with the id " + id + " not found!"));
        repo.deleteById(id);
    }
}
