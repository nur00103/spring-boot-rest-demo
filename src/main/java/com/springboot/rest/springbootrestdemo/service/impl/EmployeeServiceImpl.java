package com.springboot.rest.springbootrestdemo.service.impl;

import com.springboot.rest.springbootrestdemo.enums.ErrorCodeEnum;
import com.springboot.rest.springbootrestdemo.dto.request.EmployeeRequest;
import com.springboot.rest.springbootrestdemo.dto.response.EmployeeResponse;
import com.springboot.rest.springbootrestdemo.exception.EmployeeException;
import com.springboot.rest.springbootrestdemo.model.Employee;
import com.springboot.rest.springbootrestdemo.repository.EmployeeRepository;
import com.springboot.rest.springbootrestdemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse getAllEmployee() {
       List<EmployeeRequest> employeeRequestList= employeeRepository.findAll()
               .stream().map(employee -> convertToReq(employee))
               .collect(Collectors.toList());

       return EmployeeResponse.builder().employees(employeeRequestList).build();
    }

    @Override
    public EmployeeRequest getEmployeeById(long id) {
        return employeeRepository.findById(id).map(employee -> convertToReq(employee))
                .orElseThrow(()-> new EmployeeException(ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getMessage()));
    }

    @Override
    public EmployeeResponse getEmployeeByNameAndSurname(String name, String surname) {
        List<EmployeeRequest> requestList= employeeRepository.findByNameAndSurname(name, surname).stream()
                .map(employee -> convertToReq(employee)).collect(Collectors.toList());

        return EmployeeResponse.builder().employees(requestList).build();
    }

    @Override
    public void insert(EmployeeRequest employeeRequest) {
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeRequest,employee);
        employeeRepository.save(employee);
    }

    @Override
    public void update(EmployeeRequest employeeRequest, long id) {
       Employee employee= employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeException(ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getMessage()));
        BeanUtils.copyProperties(employeeRequest,employee);
        employee.setId(id);
        employeeRepository.save(employee);
    }

    @Override
    public void updateSome(EmployeeRequest employeeRequest, long id) {
        Employee employee= employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeException(ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getMessage()));
        if (employeeRequest.getName()!=null){
            employee.setName(employeeRequest.getName());
        }
        if (employeeRequest.getSurname()!=null){
            employee.setSurname(employeeRequest.getSurname());
        }
        if (employeeRequest.getAge()>0){
            employee.setAge(employeeRequest.getAge());
        }
        if (employeeRequest.getSalary()>0){
            employee.setSalary(employeeRequest.getSalary());
        }
        employeeRepository.save(employee);
    }

    @Override
    public void delete(long id) {
        Employee employee= employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeException(ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getMessage()));
        employeeRepository.deleteById(id);
    }

    private EmployeeRequest convertToReq(Employee employee){
//        EmployeeRequest employeeRequest=new EmployeeRequest();
//        BeanUtils.copyProperties(employee,employeeRepository);

        //Or

        return EmployeeRequest.builder().id(employee.getId()).name(employee.getName())
                .surname(employee.getSurname()).age(employee.getAge())
                .salary(employee.getSalary()).build();


    }
}
