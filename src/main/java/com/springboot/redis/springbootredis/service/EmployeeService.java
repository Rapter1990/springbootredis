package com.springboot.redis.springbootredis.service;

import com.springboot.redis.springbootredis.model.Employee;
import com.springboot.redis.springbootredis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployeeByID(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public void deleteEmployeeByID(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            Employee deletedEmployee = employee.get();
            employeeRepository.delete(deletedEmployee);
        }
    }
}
