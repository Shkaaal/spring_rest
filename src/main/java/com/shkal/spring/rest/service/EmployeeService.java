package com.shkal.spring.rest.service;

import com.shkal.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> showAllEmployees();

    public void saveNewEmployee(Employee employee);

    public Employee getEmployee (int id);

    public void deleteEmployee(int id);
}
