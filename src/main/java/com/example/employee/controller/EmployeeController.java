package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Endpoint to retrieve all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Endpoint to retrieve an employee by empid
    @GetMapping("/{empid}")
    public Employee getEmployeeById(@PathVariable String empid) {
        return employeeRepository.findByEmpid(empid);
    }

    @GetMapping("/search-by-date")
    public List<Employee> getEmployeesByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        // Ensure both startDate and endDate are inclusive
        LocalDate start = startDate.atStartOfDay().toLocalDate(); // Start of the day
        LocalDate end = endDate.atTime(23, 59, 59).toLocalDate(); // End of the day
    
        return employeeRepository.findByEmpJoinDateBetween(start, end);
    }
    
}
