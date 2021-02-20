package com.springboot.redis.springbootredis.model;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@Cache(region = "employeeCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee implements Serializable {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
