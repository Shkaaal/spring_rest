package com.shkal.spring.rest.controller;

import com.shkal.spring.rest.entity.Employee;
import com.shkal.spring.rest.exception_handling.EmployeeIncorrectData;
import com.shkal.spring.rest.exception_handling.NoSuchEmployeeException;
import com.shkal.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class MyRESTController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> employees = employeeService.showAllEmployees();
        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("Такого работника с айди + " + id + " нет!");
        }

        return employee;
    }

}