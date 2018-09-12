package com.software.engineering.spring.tripexspenses.service;

import java.util.List;

import com.software.engineering.spring.tripexspenses.domen.Employee;


public interface EmployeesService {
	public List<Employee> findAll();
	public void delete(Long employeeId);
	public Employee save(Employee employee);
	public Employee findByID(Long employeeId) ;
}
