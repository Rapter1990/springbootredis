package com.springboot.redis.springbootredis.service;

import com.springboot.redis.springbootredis.model.Employee;
import com.springboot.redis.springbootredis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAll() {

        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public void save(Employee employee) {

        employeeRepository.save(employee);
    }

    public void update(Long id,Employee employee) {

        boolean isUpdatingEmployee = (employee.getId() == id);

        if (isUpdatingEmployee) {
            Employee existingUser = employeeRepository.findById(employee.getId()).get();

            existingUser.setId(id);
            existingUser.setFirstName(employee.getFirstName());
            existingUser.setLastName(employee.getLastName());
            existingUser.setEmail(employee.getEmail());
            existingUser.setPhone(employee.getPhone());

            employeeRepository.save(existingUser);
        }

    }

    public void deleteEmployeeByID(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            Employee deletedEmployee = employee.get();
            employeeRepository.delete(deletedEmployee);
        }
    }

}
