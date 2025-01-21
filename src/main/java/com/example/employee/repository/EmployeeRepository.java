package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    
    // Method to find employees by joining date
    List<Employee> findByEmpJoinDateBetween(LocalDate startDate, LocalDate endDate);

    // Method to find an employee by empid
    Employee findByEmpid(String empid);
}
