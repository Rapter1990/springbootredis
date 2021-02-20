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

    @Cacheable(value = "employees", key = "#id", unless = "#employeeResult.phone == '111-222-3333'")
    @GetMapping("/find/{id}")
    public Optional<Employee> findById(@PathVariable Long id) {
        LOG.info("Getting Employee with ID {}.", id);
        return employeeService.findById(id);
    }

    @CachePut(value = "employees", key = "#employee.id")
    @PutMapping("/update")
    public Employee updateEmployeeByID(@RequestBody Employee employee) {
        employeeService.updateEmployeeByID(employee);
        return employee;
    }

    @CacheEvict(value = "employees", allEntries=true)
    @DeleteMapping("delete/{id}")
    public void deleteUserByID(@PathVariable Long id) {
        LOG.info("deleting person with id {}", id);
        employeeService.deleteUserByID(id);
    }
}
