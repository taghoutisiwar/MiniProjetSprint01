package com.example.demo.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Employee;
import com.example.demo.Service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		modelMap.addAttribute("Employee", new Employee());
		modelMap.addAttribute("mode", "new");
		return "createEmployee";
	}

	@RequestMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee,
	                           ModelMap modelMap) {
	    Employee savedEmployee = employeeService.saveEmployee(employee);
	    String msg ="Employee enregistré avec Id "+savedEmployee.getId();
	    modelMap.addAttribute("msg", msg);
	    return "createEmployee";
	}
	
	@RequestMapping("/listeEmployee")
	public String listeEmployee(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Employee> empl = employeeService.getAllEmployeesParPage(page, size);
		modelMap.addAttribute("employee", empl);
		 modelMap.addAttribute("pages", new int[empl.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeEmployee";
	}
	@RequestMapping("/modifierEmployee")
	public String editerEmployee(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Employee e= employeeService.getEmployee(id);
	modelMap.addAttribute("employee", e);
	return "editerEmployee";
	}
	
	@RequestMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute("employee") Employee employee,
			ModelMap modelMap) {

	 employeeService.updateEmployee(employee);
	 List<Employee> employees = employeeService.getAllEmployees();
	 modelMap.addAttribute("employees", employees);
	return "listeEmployee";
	}


	@RequestMapping("/supprimerEmployee")
	public String supprimerEmployee(@RequestParam("id") Long id,
			ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		employeeService.deleteEmployeeById(id);
		Page<Employee> employees = employeeService.getAllEmployeesParPage(page,
		size);
		modelMap.addAttribute("employees", employees);
		modelMap.addAttribute("pages", new int[employees.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeEmployee";
	}
}