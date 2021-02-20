package com.springboot.redis.springbootredis.controller;

import com.springboot.redis.springbootredis.model.Employee;
import com.springboot.redis.springbootredis.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/find/all")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @Cacheable(value = "employees", key = "#id", condition= "#id == 4")
    @GetMapping("/find/{id}")
    public Optional<Employee> findById(@PathVariable Long id) {
        LOG.info("Getting Employee with ID {}.", id);
        return employeeService.findById(id);
    }

    @CachePut(value = "employees", key = "employee.id")
    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        LOG.info("Saving Employee.");
        employeeService.save(employee);
        return employee;
    }

    @CachePut(value = "employees", key = "#employee.id")
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable Long id) {
        LOG.info("Updating Employee with id {}", id);
        employeeService.update(id,employee);
        return employee;
    }

    @CacheEvict(value = "employees", allEntries=true)
    @DeleteMapping("delete/{id}")
    public void deleteEmployeeByID(@PathVariable Long id) {
        LOG.info("Deleting Employee with id {}", id);
        employeeService.deleteEmployeeByID(id);
    }
}
