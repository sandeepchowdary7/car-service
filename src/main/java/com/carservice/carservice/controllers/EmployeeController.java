package com.carservice.carservice.controllers;

import com.carservice.carservice.models.Employees;
import com.carservice.carservice.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    private Object getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{employeeId}")
    private Object getEmployeeById(@PathVariable("employeeId") int employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/employee")
    private Object saveShop(@RequestBody Employees employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employee/{employeeId}")
    private Object updateEmployee(@RequestBody Employees employee, @PathVariable("employeeId") int id) {
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/employee/{employeeId}")
    private Object deleteEmployee(@PathVariable("employeeId") int id) {
        return employeeService.deleteEmployee(id);
    }
}