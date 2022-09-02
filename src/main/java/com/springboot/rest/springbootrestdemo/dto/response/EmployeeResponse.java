package com.springboot.rest.springbootrestdemo.dto.response;

import com.springboot.rest.springbootrestdemo.dto.request.EmployeeRequest;
import com.springboot.rest.springbootrestdemo.model.Employee;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
//    private long id;
//    private String name;
//    private String surname;
//    private int age;
//    private double salary;

    private List<EmployeeRequest>  employees;
}
