package com.springboot.rest.springbootrestdemo.repository;

import com.springboot.rest.springbootrestdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByNameAndSurname (String name,String surname);
}
