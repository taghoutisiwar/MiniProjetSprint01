package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Employee;
import com.example.demo.Repository.EmployeeRepository;

@Service

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getEmployees() {
	    return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);	
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(Employee e) {
		employeeRepository.delete(e);
	}

	@Override
	public Page<Employee> getAllEmployeesParPage(int page, int size) {
	return employeeRepository.findAll(PageRequest.of(page, size));
	}
}