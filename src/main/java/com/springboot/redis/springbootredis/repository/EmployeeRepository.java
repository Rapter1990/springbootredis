package com.springboot.redis.springbootredis.repository;

import com.springboot.redis.springbootredis.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
