package com.springboot.rest.springbootrestdemo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    private long id;
    private String name;
    private String surname;
    private int age;
    private double salary;

}
