package com.carservice.carservice.services;

import com.carservice.carservice.models.Employees;
import com.carservice.carservice.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Object getAllEmployees() {
        List<Employees> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees1 -> employees.add(employees1));
        if (employees.isEmpty()) {
            return "No Employees Found";
        }
        return employees;
    }

    public Object getEmployeeById(int id) {
        Optional employee = employeeRepository.findById(id);

        if (employee.isEmpty()) {
            return "No Employee Found with this "+id;
        }
        return employee.get();
    }

    public Object saveEmployee(Employees employee) {
        return employeeRepository.save(employee);
    }

    public Object updateEmployee(Employees newEmployee, int id) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirst_name(newEmployee.getFirst_name());
                    employee.setMiddle_name(newEmployee.getMiddle_name());
                    employee.setLast_name(newEmployee.getLast_name());
                    employee.setEmail(newEmployee.getEmail());
                    employee.setPhone_number(newEmployee.getPhone_number());
                    employee.setSecondary_phone_number(newEmployee.getSecondary_phone_number());
                    employee.setGender(newEmployee.getGender());
                    employee.setRole(newEmployee.getRole());
                    employee.setDob(newEmployee.getDob());
                    employee.setAddress1_street_address(newEmployee.getAddress1_street_address());
                    employee.setAddress1_city(newEmployee.getAddress1_city());
                    employee.setAddress1_state(newEmployee.getAddress1_state());
                    employee.setAddress1_country(newEmployee.getAddress1_country());
                    employee.setAddress1_zipcode(newEmployee.getAddress1_zipcode());
                    employee.setAddress1_street_address(newEmployee.getAddress2_street_address());
                    employee.setAddress1_city(newEmployee.getAddress2_city());
                    employee.setAddress1_state(newEmployee.getAddress2_state());
                    employee.setAddress1_country(newEmployee.getAddress2_country());
                    employee.setAddress1_zipcode(newEmployee.getAddress2_zipcode());
                    return employeeRepository.save(employee);
                })
                .orElseGet(()->{
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });
    }

    public Object deleteEmployee(int id) {
        Optional employee = employeeRepository.findById(id);

        if (!employee.isPresent()) {
            return "No Employee Found with this"+ id;
        }

        employeeRepository.deleteById(id);
        return "Employee Deleted Successfully";
    }
}
