package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Service.EmployeeService;
import com.example.demo.entities.Employee;

@SpringBootApplication
public class MiniProjet01Application implements CommandLineRunner{

	@Autowired
	EmployeeService employeeService;
	public static void main(String[] args) {
		SpringApplication.run(MiniProjet01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeService.saveEmployee(new Employee( ));
		
	}

}
