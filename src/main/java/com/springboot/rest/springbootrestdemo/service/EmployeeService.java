package com.springboot.rest.springbootrestdemo.service;

import com.springboot.rest.springbootrestdemo.dto.request.EmployeeRequest;
import com.springboot.rest.springbootrestdemo.dto.response.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse getAllEmployee();

    EmployeeRequest getEmployeeById(long id);

    EmployeeResponse getEmployeeByNameAndSurname(String name,String surname);

    void insert(EmployeeRequest employeeRequest);

    void update(EmployeeRequest employeeRequest, long id);

    void updateSome(EmployeeRequest employeeRequest, long id);

    void delete(long id);
}
