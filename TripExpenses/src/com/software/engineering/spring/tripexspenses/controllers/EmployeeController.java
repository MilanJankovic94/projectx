package com.software.engineering.spring.tripexspenses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.software.engineering.spring.tripexspenses.domen.Employee;
import com.software.engineering.spring.tripexspenses.service.EmployeesService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeesService employeesService;
	
	@RequestMapping("/employees")
	public String showEmployees(Model model) {
		List<Employee> employees=employeesService.findAll();
		model.addAttribute("employees",employees);
		return "employees";
	}
	@RequestMapping("/addemployee")
	public String createEmployee(Model model) {
		
		return "addemployee";
	}

	@RequestMapping(value = "/docreateemployee", method = RequestMethod.POST)
	public String doCreateEmployee(Model model,  Employee employee,  BindingResult result) {
	
		employeesService.save(employee);
		System.out.println(employee);
		System.out.println("employee added successfully");
		model.addAttribute("message","Employee added succesfully!!!");
		
		return "addemployee";

	}
	
}
