package com.app.service;

import java.util.List;

import com.app.entities.Employee;

public interface EmployeeService {
//add a method to list all emps
	List<Employee> getAllEmps();

	Employee addEmpDetails(Employee emp);
}
