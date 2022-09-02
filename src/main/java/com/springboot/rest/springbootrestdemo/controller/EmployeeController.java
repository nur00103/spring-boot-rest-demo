package com.springboot.rest.springbootrestdemo.controller;

import com.springboot.rest.springbootrestdemo.dto.request.EmployeeRequest;
import com.springboot.rest.springbootrestdemo.dto.response.EmployeeResponse;
import com.springboot.rest.springbootrestdemo.repository.EmployeeRepository;
import com.springboot.rest.springbootrestdemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("restApi")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("employee")
    public EmployeeResponse getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public EmployeeRequest getEmployeeById(@PathVariable("id") long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/search")
    public EmployeeResponse getEmployeeByNameAndSurname
            (@RequestParam("name") String name,@RequestParam("surname") String surname){
        return employeeService.getEmployeeByNameAndSurname(name,surname);
    }

    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public  void saveEmployee(@RequestBody EmployeeRequest employeeRequest){
        employeeService.insert(employeeRequest);
    }

    @PutMapping("/{id}")
    public void updateAll(@RequestBody EmployeeRequest employeeRequest,@PathVariable("id") long id){
        employeeService.update(employeeRequest,id);
    }

    @PatchMapping("/{id}")
    public void updateSome(@RequestBody EmployeeRequest employeeRequest,@PathVariable("id") long id){
        employeeService.updateSome(employeeRequest,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        employeeService.delete(id);
    }
}
