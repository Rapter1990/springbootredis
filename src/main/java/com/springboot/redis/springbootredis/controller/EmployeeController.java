package com.springboot.redis.springbootredis.controller;

import com.springboot.redis.springbootredis.model.Employee;
import com.springboot.redis.springbootredis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/find/all")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<Employee> findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

}
