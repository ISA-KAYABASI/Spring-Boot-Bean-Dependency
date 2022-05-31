package com.isakayabasi.crudapplicationspringboot.service;

import com.isakayabasi.crudapplicationspringboot.model.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
}
