package com.vignesh.EMS_Backend.controller;

import com.vignesh.EMS_Backend.entity.Employee;
import com.vignesh.EMS_Backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
        Employee newEmp = service.createEmployee(emp);
        return new ResponseEntity<>(newEmp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Long employeeId){
        Employee emp = service.getEmployeeById(employeeId);
        return ResponseEntity.ok(emp);
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(service.getAllEmployee());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
        Employee employee = service.updateEmployee(id, emp);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        System.out.println(id);
        return ResponseEntity.ok("Employee deleted!");
    }
}
