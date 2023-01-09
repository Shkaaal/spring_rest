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

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveNewEmployee(employee);
        return employee;
    }


    @PutMapping("/employees")
    public Employee changeEmployee(@RequestBody Employee employee) {
        employeeService.saveNewEmployee(employee);
        return employee;
    }


    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("No id " + id + " in DB");
        }

        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted!";
    }
}