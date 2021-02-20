package com.springboot.redis.springbootredis.repository;

import com.springboot.redis.springbootredis.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
