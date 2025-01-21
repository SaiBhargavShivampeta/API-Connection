package com.example.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "empid", nullable = false, unique = true)
    private String empid; // Unique identifier for employees, manually assigned or generated

    @Column(name = "empfname", nullable = false, length = 50)
    private String empFname; // Employee first name

    @Column(name = "emplname", nullable = false, length = 50)
    private String empLname; // Employee last name

    @Column(name = "empjoindate", nullable = false)
    private LocalDate empJoinDate; // Employee join date

    // Default constructor (required for JPA)
    public Employee() {
    }

    // Constructor for easier instantiation
    public Employee(String empid, String empFname, String empLname, LocalDate empJoinDate) {
        this.empid = empid;
        this.empFname = empFname;
        this.empLname = empLname;
        this.empJoinDate = empJoinDate;
    }

    // Getters and setters
    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpFname() {
        return empFname;
    }

    public void setEmpFname(String empFname) {
        this.empFname = empFname;
    }

    public String getEmpLname() {
        return empLname;
    }

    public void setEmpLname(String empLname) {
        this.empLname = empLname;
    }

    public LocalDate getEmpJoinDate() {
        return empJoinDate;
    }

    public void setEmpJoinDate(LocalDate empJoinDate) {
        this.empJoinDate = empJoinDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "empid='" + empid + '\'' +
               ", empFname='" + empFname + '\'' +
               ", empLname='" + empLname + '\'' +
               ", empJoinDate=" + empJoinDate +
               '}';
    }
}
