package com.example.demo.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Employee;

public interface EmployeeService {

	Employee getEmployee(Long id);

	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeById(Long id);
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployeeById(Long id);
	
	List<Employee> getEmployees();

	List<Employee> getAllEmployees();

	void deleteEmployee(Employee e);
	
	Page<Employee> getAllEmployeesParPage(int page, int size);

}
