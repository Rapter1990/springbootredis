package com.springboot.redis.springbootredis.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@Cache(region = "employeeCache", usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@Getter
@Setter
public class Employee implements Serializable {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
