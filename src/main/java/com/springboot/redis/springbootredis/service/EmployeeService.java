package com.springboot.redis.springbootredis.service;

import com.springboot.redis.springbootredis.model.Employee;
import com.springboot.redis.springbootredis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }

}
